package WeeklyContest34;

/**
 * Created by russell on 2017/5/28.
 */
public class RangeAddition {
    public int maxCount(int m, int n, int[][] ops) {

        if (ops == null) return 0;
        if (ops.length == 0) return m*n;


        int minM = m;
        int minN = n;

        for (int i = 0; i < ops.length; i++) {

            if (ops[i][0] < minM) {
                minM = ops[i][0];
            }
            if (ops[i][1] < minN) {
                minN = ops[i][1];
            }
        }
        return minM * minN;
    }

    public static void main(String[] args) {
//        int[][] array = {{1, 1}, {2, 2}};
//
//        for (int i = 0; i < 2; i++){
//            for (int j = 0; j < 2; j++) {
//                System.out.print(array[i][j] + " ");
//            }
//            System.out.println();
//        }
        RangeAddition rangeAddition = new RangeAddition();
        int[][] ops = {};
        System.out.println(rangeAddition.maxCount(3, 3 , ops));
        int[][] ops1 = {{2, 2}, {3, 3}};
        System.out.println(rangeAddition.maxCount(3, 3 , ops1));
    }
}
