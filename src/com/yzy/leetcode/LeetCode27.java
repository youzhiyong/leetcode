package com.yzy.leetcode;

import com.yzy.common.ListNode;

/**
 * Description:
 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。

 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

 示例 1:

 给定 nums = [3,2,2,3], val = 3,

 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。

 你不需要考虑数组中超出新长度后面的元素。
 示例 2:

 给定 nums = [0,1,2,2,3,0,4,2], val = 2,

 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。

 注意这五个元素可为任意顺序。

 你不需要考虑数组中超出新长度后面的元素。
 说明:

 为什么返回数值是整数，但输出的答案是数组呢?

 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。

 你可以想象内部操作如下:

 // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
 int len = removeElement(nums, val);

 // 在函数里修改输入数组对于调用者是可见的。
 // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
 for (int i = 0; i < len; i++) {
 print(nums[i]);
 }
 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode27 {

    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 1, 4};

        int head = solution(input, 1);
        System.out.println(head);
    }

    public static int solution(int[] nums, int val) {
        int p = 0; //记录当前有效长度
        for (int i : nums) {
            if (val != i) { //不相等，并将元素放入有效长度对应的地址上，有效长度加1
                nums[p] = i;  //  ???
                p++;
            } else {
                //相等，则抛弃这个元素，有效长度不变
            }
        }
        return p;
    }

    public static int solution2(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int i = 0;
        int len = nums.length;
        int j = len - 1;

        for (; i <= j; i++) {
            if (nums[i] == val) {
                nums[i] = nums[j];
                j--;
                len--;
            }
        }
        return len;
    }
}
