package com.yzy.leetcode;

import com.yzy.common.ListNode;
import com.yzy.common.TreeNode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Description:
 满二叉树是一类二叉树，其中每个结点恰好有 0 或 2 个子结点。

 返回包含 N 个结点的所有可能满二叉树的列表。 答案的每个元素都是一个可能树的根结点。

 答案中每个树的每个结点都必须有 node.val=0。

 你可以按任何顺序返回树的最终列表。

  

 示例：

 输入：7
 输出：[[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
 解释：

  

 提示：

 1 <= N <= 20


 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode894 {

    public static void main(String[] args) {
        List<TreeNode> list = solution(7);
        System.out.println(list);

    }

    /**
     * 观察后发现:
     * 1. 其中结果两两对称，互为镜像，还有一个是自我对称
     * 2.  规律
     *          n = 3    -->  1   种情况
     *              5    -->  2   种情况
     *              7    -->  5   种情况
     *              9    -->  10  种情况
     *              11   -->  ??  种情况
     *
     * @param N
     * @return
     */
    public static List<TreeNode> solution(int N) {

        //偶数不能得到满二叉树
        if (N % 2 == 0) return null;




        return null;
    }


}
