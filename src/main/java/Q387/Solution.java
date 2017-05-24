package Q387;

import java.util.*;

/**
 * Created by russell on 2017/5/24.
 */
public class Solution {
    public int firstUniqChar(String s) {
        byte[] bytes = s.getBytes();
        // 用HashTable表记录重复的字符和下标，如果重复则更新下标list，只有list长度为1，说明没有重复的，然后再找最小的index
        Hashtable<Byte, ByteIdx> byteTable = new Hashtable<Byte, ByteIdx>();

        for (int i = 0; i < bytes.length; i++) {
            ByteIdx byteIdx = byteTable.get(bytes[i]);
            if (byteIdx == null) {
                byteIdx = new ByteIdx(bytes[i]);
                byteIdx.addIndex(i);
                byteTable.put(bytes[i], byteIdx);
            } else {
                byteIdx.addIndex(i);
            }
        }

        int index = -1;

        Enumeration e = byteTable.elements();
        while (e.hasMoreElements()) {
            List<Integer> list = ((ByteIdx)e.nextElement()).idxList;

            if (list.size() == 1) {
                if (index == -1 || list.get(0) < index) {
                    index = list.get(0);
                }
            }
        }

        return index;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.firstUniqChar("aabb"));
        System.out.println(solution.firstUniqChar("leetcode"));
        System.out.println(solution.firstUniqChar("loveleetcode"));
    }
}

class ByteIdx {
    Byte value;
    List<Integer> idxList;

    public ByteIdx(Byte _byte) {
        value = _byte;
        idxList = new ArrayList<Integer>();
    }

    public void addIndex(Integer index) {
        idxList.add(index);
    }
}
