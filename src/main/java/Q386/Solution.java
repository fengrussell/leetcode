package Q386;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by russell on 2017/5/24.
 * 预期输出
 *  1 10 100 1000 1001 ... 1009
 *       101 1010 1011 ... 1019
 *       102 1020 1021 ... 1029
 *       ... ...
 *       109 1090 1091 ... 1099
 *    11 110 1100 1101 ... 1109
 *       111 1110 1111 ... 1119
 *       112 ...
 *       119 ...
 *    12 120 1200 1201 ... 1209
 *       121 1210 1211 ... 1219
 *       ...
 *    19 190 1900 1901 ... ...
 *       191 1910 1911 ... ...
 *       ...
 *       199 1990 1991 ... 1999
 *  2 20 200 2000 2001 ... 2009
 *   ... ...
 */
public class Solution {
    public List<Integer> lexicalOrder(int n) {

        List<Integer> list = new ArrayList<Integer>(n);
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        // 获取n的位数，例如 100为3位数
        int numDigit = getNumberDigit(n);
        // 起始值
        int startingValue = 0;
        for (int i =  0; i < array.length; i++) {
            startingValue = array[i];
            int startingDigit = 1;
//            boolean loopFlag = true;

            while (true) {
                // 第三步（也是第一步）：先重置起始值，然后判断是否退出
                startingValue = resetStartingValue(startingValue);
                startingDigit = getNumberDigit(startingValue);
                if (startingDigit == 1) {
                    if (array[i] != 9 && startingValue > array[i]) {
                        break;
                    } else if (array[i] == 9 && startingValue == 1) {
                        break;
                    }
                }

                // 第一步：从初始值开始，递增乘以10。例如 1 10 100 1000 ...
                int temp = startingValue, value = 0;
                for (int j = 0; j < numDigit; j++) {
                    if (temp > n) {
                        break;
                    } else {
                        value = temp;
                        list.add(value);
                    }
                    temp = value * 10;
                }

                // 第二步：第一步是先把某个初始值依次补0（乘以10），然后从最后一个值开始+1
                int remainder = value % 10;
                if (remainder == 0) { // 可以被10整除，例如 100，依次为101 102 103 ... 109
                    // 起始值从value+1开始
                    startingValue = value + 1;
                    for (int k = 0; k < 9; k++) {
                        int loopTemp = startingValue + k;
                        if (loopTemp <= n) {
                            list.add(loopTemp);
                        } else {
                            break;
                        }
                    }

                    value = startingValue + 9;
                    startingValue = resetStartingValue(value);

                } else { // 不能被10整除，说明自需要自增即可，例如 11 101 102
                    startingValue = startingValue + 1;
                }
            }
        }

        return list;
    }

    public int resetStartingValue(int val) {
        int val_digit = getNumberDigit(val);
        int remainder = 1;
        int quotient = 1;

        for (int i = 0; i < val_digit; i++) {
            remainder = val % 10;
            quotient = val / 10;

            if (remainder != 0) {
                return val;
            } else {
                val = quotient;
            }
        }


        return quotient;
    }

    public int getNumberDigit(int n) {
        int num = 1;
        int digit = 0;

        while (n >= num) {
            num = num * 10;
            digit++;
        }

        return digit;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> list = solution.lexicalOrder(10009);

        for (Integer i : list) {
            System.out.print(i + " ");
        }
    }
}
