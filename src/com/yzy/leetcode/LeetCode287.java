package com.yzy.leetcode;

/**
 * Description:
 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。

 示例 1:

 输入: [1,3,4,2,2]
 输出: 2
 示例 2:

 输入: [3,1,3,4,2]
 输出: 3
 说明：

 不能更改原数组（假设数组是只读的）。
 只能使用额外的 O(1) 的空间。
 时间复杂度小于 O(n2) 。
 数组中只有一个重复的数字，但它可能不止重复出现一次。

 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode287 {

    public static void main(String[] args) {

        int[] n = new int[] {3,2,3,4,1,5};
        int exist = solution(n);
        System.out.println(exist);
    }

    public static int solution(int[] nums) {
        int slow = 0;
        int fast = 0;
        while (true) {     //第一层循环 快慢指针求相遇点
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                fast = 0;    //第二层循环，从相遇点 和 起点 同时出发，下一次相等的即为 入环节点(即重复的数)
                while (nums[fast] != nums[slow]) {
                    fast = nums[fast];
                    slow = nums[slow];
                }
                return nums[fast];
            }
        }
    }


}
