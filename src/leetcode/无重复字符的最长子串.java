package leetcode;

import java.util.HashMap;

public class 无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {

        int max = 0;
        int index = 0;
        HashMap<Character,Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                index = index>map.get(s.charAt(i))?index:map.get(s.charAt(i))+1;
            }

            map.put(s.charAt(i),i);
            max = Math.max(max, i-index+1);
        }
        return max;
    }
}
