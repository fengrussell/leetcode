package WeeklyContest34;

/**
 * Created by russell on 2017/5/29.
 */
public class ArrayNesting1 {
    /**
     * 思路：和直接遍历不太一样，如果[i]元素被标记过是之前某个S数组的元素，则逃过。
     * @param nums
     * @return
     */
    public int arrayNesting(int[] nums) {
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            int len = 0;
            for (int j = i; nums[j] > -1; len++) {
                int next = nums[j];
                nums[j] = -1;
                j = next;
            }

            maxLen = Math.max(maxLen, len);
        }

        return maxLen;
    }

    /**
     * 耗时最短的答案，有点疑问，感觉时间复杂度没有上面的高效。这种避免用递归（我的答案提示TLE，思路一样）。
     * 2017.06.02 今天在leetcode提交，这个方法已经提示TLE了。这样可以判断contest当天测试用例没有那么多TestCase，所以可以submit。
     * 今天验证的结果，这个方法耗时为800-900ms，上面的方法耗时<10ms
     * @param nums
     * @return
     */
    public int arrayNesting1(int[] nums) {
        int res=0;
        for(int i=0;i<nums.length;i++)
        {
            int start=nums[i],count=0;
            do
            {
                start=nums[start];
                count++;
            }
            while(start!=nums[i]);
            res=Math.max(res,count);

        }
        return res;
    }

    public static void main(String[] args) {
        ArrayNesting1 arrayNesting = new ArrayNesting1();
        int nums[] = {5,4,0,3,1,6,2};
        System.out.println(arrayNesting.arrayNesting(nums));
        int nums1[] = {0,2,1};
        System.out.println(arrayNesting.arrayNesting(nums1));
        int nums2[] = {0,1,2};
        System.out.println(arrayNesting.arrayNesting(nums2));
    }
}

