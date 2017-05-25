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

        for (int i = 0; i < (bytes.length+1)/2; i++) {
            ByteIdx byteIdx = byteTable.get(bytes[i]);
            if (byteIdx == null) {
                byteIdx = new ByteIdx(bytes[i]);
                byteIdx.setIndex(i);
                byteTable.put(bytes[i], byteIdx);
            } else {
                byteIdx.setIndex(i);
            }

            int lastIdx = bytes.length-1-i;
            if (lastIdx > i) {
                ByteIdx lastByteIdx = byteTable.get(bytes[lastIdx]);
                if (lastByteIdx == null) {
                    lastByteIdx = new ByteIdx(bytes[lastIdx]);
                    lastByteIdx.setIndex(lastIdx);
                    byteTable.put(bytes[lastIdx], lastByteIdx);
                } else {
                    lastByteIdx.setIndex(lastIdx);
                }
            }
        }

        int index = -1;

        Enumeration e = byteTable.elements();
        while (e.hasMoreElements()) {
            ByteIdx idx = (ByteIdx)e.nextElement();

            if (!idx.isRepeate) {
                if (index == -1 || idx.minIdx < index) {
                    index = idx.minIdx;
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
    boolean isRepeate = false;
    int minIdx = -1;

    public ByteIdx(Byte _byte) {
        value = _byte;
    }

    public void setIndex(Integer index) {
        if (minIdx == -1) {
            minIdx = index;
        } else {
            isRepeate = true;
            if (index < minIdx) {
                minIdx = index;
            }
        }
    }
}
