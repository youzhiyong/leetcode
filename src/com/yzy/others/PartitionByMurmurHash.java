package com.yzy.others;

import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * mycat 的一致性hash算法
 * @author youzhiyong
 */
public class PartitionByMurmurHash {

    private static final int DEFAULT_VIRTUAL_BUCKET_TIMES=160;
    private static final int DEFAULT_WEIGHT=1;
    private static final Charset DEFAULT_CHARSET=Charset.forName("UTF-8");

    private int seed = 0;
    private int count = 12;
    private int virtualBucketTimes=DEFAULT_VIRTUAL_BUCKET_TIMES;
    private Map<Integer,Integer> weightMap=new HashMap<>();

    private HashFunction hash;

    private SortedMap<Integer,Integer> bucketMap;

    public void init()  {
        bucketMap=new TreeMap<>();
        generateBucketMap();
    }

    private void generateBucketMap(){
        hash= Hashing.murmur3_32(seed);//计算一致性哈希的对象
        for(int i=0;i<count;i++){//构造一致性哈希环，用TreeMap表示
            StringBuilder hashName=new StringBuilder("SHARD-").append(i);
            for(int n=0,shard=virtualBucketTimes*getWeight(i);n<shard;n++){
                bucketMap.put(hash.hashUnencodedChars(hashName.append("-NODE-").append(n)).asInt(),i);
            }
        }
        weightMap=null;
    }
    /**
     * 得到桶的权重，桶就是实际存储数据的DB实例
     * 从0开始的桶编号为key，权重为值，权重默认为1。
     * 键值必须都是整数
     * @param bucket
     * @return
     */
    private int getWeight(int bucket){
        Integer w=weightMap.get(bucket);
        if(w==null){
            w=DEFAULT_WEIGHT;
        }
        return w;
    }


    public Integer calculate(String columnValue) {
        SortedMap<Integer, Integer> tail = bucketMap.tailMap(hash.hashUnencodedChars(columnValue).asInt());
        if (tail.isEmpty()) {
            return bucketMap.get(bucketMap.firstKey());
        }
        return tail.get(tail.firstKey());
    }

    public static void main(String[] args) throws IOException {
        PartitionByMurmurHash hash = new PartitionByMurmurHash();
        //种子
        hash.seed=0;
        //分片数
        hash.count=12;
        hash.virtualBucketTimes = 160;

        //初始化
        hash.init();
        //计算hash值 对应的分片  [0 - (hash.count-1)]
        int res = hash.calculate("owJnujvEBmcfNkX3B0Om4CizfaD8");
        System.out.println("对应的分片：" + (res + 1));
    }

}
