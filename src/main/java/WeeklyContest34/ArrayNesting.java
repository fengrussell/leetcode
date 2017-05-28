package WeeklyContest34;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by russell on 2017/5/28.
 */
public class ArrayNesting {
    public int arrayNesting(int[] nums) {

        Set<Integer> set = new HashSet<Integer>();
        int value = 0;
        set.add(value);
        for (int i = 0; i < nums.length; i++) {
            value = nextIndex(value, nums);
            if (set.contains(value)) {
                return i+1;
            } else {
                set.add(value);
            }
        }

        return nums.length;
    }

    public int nextIndex(int value, int[] nums) {
        return nums[value];
    }

    public static void main(String[] args) {
        ArrayNesting arrayNesting = new ArrayNesting();
        int nums[] = {5,4,0,3,1,6,2};
        System.out.println(arrayNesting.arrayNesting(nums));
        int nums1[] = {0,2,1};
        System.out.println(arrayNesting.arrayNesting(nums1));
    }
}
