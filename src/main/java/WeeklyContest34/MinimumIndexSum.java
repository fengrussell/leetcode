package WeeklyContest34;


import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;

/**
 * Created by russell on 2017/5/28.
 */
public class MinimumIndexSum {
    public String[] findRestaurant(String[] list1, String[] list2) {


        Hashtable<String, Count> table = new Hashtable<String, Count>();
        int len1 = list1.length;
        int len2 = list2.length;
        int len = Math.max(len1, len2);

        Count restaurant = null;
        for (int i = 0; i < len; i++) {
            if (i < len1) {
                restaurant = table.get(list1[i]);
                if (restaurant == null) {
                    table.put(list1[i], new Count(list1[i]));
                }
            }

            if (i < len2) {
                restaurant = table.get(list2[i]);
                if (restaurant == null) {
                    table.put(list2[i], new Count(list2[i]));
                }
            }

            restaurant.add(i);
        }

        int index = 0;
        Enumeration e = table.elements();
        while (e.hasMoreElements()) {
            restaurant = (Count)e.nextElement();

            if (restaurant.isCommon) {
                if (index < restaurant.sum) {
                    index = restaurant.sum;
                }
            }

        }
        return null;
    }

    public static void main(String[] args) {

    }
}

class Count {
    String str;
    int sum = -1;
    boolean isCommon = false;

    public Count(String _str){
        str = _str;
    }

    public void add(int idx) {
        if (sum == -1) {
            sum = idx;
        } else {
            sum = sum + idx;
            isCommon = true;
        }
    }
}
