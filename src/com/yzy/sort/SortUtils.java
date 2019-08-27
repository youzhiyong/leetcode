package com.yzy.sort;

/**
 * Description:
 * Date: 2019-08-24
 *
 *                       - 插入排序{ -直接插入排序1
 *                                   -希尔排序2
 *
 *                       - 选择排序{ -简单选择排序3
 *                                   -堆排序4
 *
 *           - 内部排序{ - 交换排序{ -冒泡排序5
 *                                   -快速排序6
 *
 *                       - 归并排序7
 *                       - 基数排序8
 * 排序算法{
 *           - 外部排序
 * @author youzhiyong
 */
public class SortUtils {

    public static void main(String[] args) {
        int[] nums = new int[] {9,9,9,9,9,9,1,2,3,5,4,2,9};

        quickSort(nums);

        print(nums);

    }

    public static void print(int[] nums) {
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    /**
     * 直接插入排序
     * 第一层循环：遍历待比较的所有数组元素
     * 第二层循环：将本轮选择的元素(j)与已经排好序的元素相比较。
     *  如果：selected < ordered，那么将二者交换
     *  否则：退出内层循环(如果大于已经排好序的数组中最大的元素，则大于排序数组中所有的元素)
     * @param nums
     */
    public static void directInsertSort(int[] nums) {

        for (int i=1; i<nums.length;i++) {

            for (int j=i; j > 0; j--) {
                if (nums[j] < nums[j-1]) {
                    int temp = nums[j-1];
                    nums[j-1] = nums[j];
                    nums[j] = temp;
                } else break;
            }
        }
    }

    /**
     * 简单选择排序
     *
     * 1. 从待排序序列中，找到关键字最小的元素；
     * 2. 如果最小元素不是待排序序列的第一个元素，将其和第一个元素互换；
     * 3. 从余下的 N - 1 个元素中，找出关键字最小的元素，重复(1)、(2)步，直到排序结束。
     * @param nums
     */
    public static void simpleSelectSort(int[] nums) {

        for (int i = 0; i<nums.length; i++) {

            for (int j=i+1; j<nums.length;j++) {

                if (nums[j] < nums[i]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }

            }

        }
    }

    /**
     * 冒泡排序
     * 1. 将序列当中的左右元素，依次比较，保证右边的元素始终大于左边的元素； （ 第一轮结束后，序列最后一个元素一定是当前序列的最大值；）
     * 2. 对序列当中剩下的n-1个元素再次执行步骤1。
     * 3. 对于长度为n的序列，一共需要执行n-1轮比较
     * @param nums
     */
    public static void bubbleSort(int[] nums) {

        for (int i=0;i<nums.length - 1;i++) {  //第一层循环只需要len-1次
            for (int j=0;j<nums.length - 1 -i;j++) {
                if (nums[j] > nums[j+1]) {
                    int temp = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    public static void quickSort(int[] nums) {
        quickSortCore(nums, 0,nums.length - 1);
    }

    public static void quickSortCore(int[] arr, int start, int end) {

        int targe = arr[start];
        int i = start;
        int j = end;

        while (i < j) {

            while ((i < j) && arr[j] > targe) j--;

            while ((i < j) && arr[i] <= targe) i++;

            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }

        }

        arr[start] = arr[i];
        arr[i] = targe;

        quickSortCore(arr, start, i-1);

        quickSortCore(arr, i+1, end);

    }



}
