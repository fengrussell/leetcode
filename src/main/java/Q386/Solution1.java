package Q386;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by russell on 2017/5/24.
 */
public class Solution1 {

    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>(n);
        int curr = 1;
        for(int i = 1; i <= n; i++) {
            list.add(curr);
            if (curr * 10 <= n) {
                curr *= 10;
            } else if (curr % 10 != 9 && curr + 1 <= n) {
                curr++;
            } else {
                while ((curr / 10) % 10 == 9) {
                    curr /= 10;
                }
                curr = curr / 10 + 1;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        List<Integer> list = solution.lexicalOrder(10009);

        for (Integer i : list) {
            System.out.print(i + " ");
        }
    }
}
