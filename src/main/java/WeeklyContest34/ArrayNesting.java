package WeeklyContest34;


/**
 * Created by russell on 2017/5/28.
 */
public class ArrayNesting {
    public int arrayNesting(int[] nums) {

        int maxLen = 0;
        int len = 0;

        for (int i = 0; i < nums.length; i++) {

            len = nextIndex(i, nums);
            if (maxLen < len) {
                maxLen = len;
            }
        }

        return maxLen;
    }

    public int nextIndex(int startIdx, int[] array) {
        int nextIdx = array[startIdx];
        if (nextIdx == startIdx) {
            return 1;
        } else {
            return nextIndex(nextIdx, startIdx, array)+1;
        }
    }

    public int nextIndex(int index, int startIdx, int[] array) {
        int nextIdx = array[index];
        if (nextIdx == startIdx) {
            return 1;
        } else {
            return nextIndex(nextIdx, startIdx, array)+1;
        }
    }


    public static void main(String[] args) {
        ArrayNesting arrayNesting = new ArrayNesting();
        int nums[] = {5,4,0,3,1,6,2};
        System.out.println(arrayNesting.arrayNesting(nums));
        int nums1[] = {0,2,1};
        System.out.println(arrayNesting.arrayNesting(nums1));
        int nums2[] = {0,1,2};
        System.out.println(arrayNesting.arrayNesting(nums2));
    }
}
