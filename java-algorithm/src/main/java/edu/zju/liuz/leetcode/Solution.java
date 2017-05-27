package edu.zju.liuz.leetcode;

import java.util.*;

/**
 * Created by Administrator on 2017/5/24.
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] = i;
                result[1] = map.get(target - nums[i]);
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int low = 0;
        int high = 0;
        int len = 0;
        for (; high < chars.length; ) {
            if(map.containsKey(chars[high])) {
                low = map.get(chars[high]) + 1;
            }
            map.put(chars[high], high);
            high++;
            if(high - low > len) {
                len = high - low;
            }
        }
        return len;
    }


    private int lo, maxLen;
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2)
            return s;

        for (int i = 0; i < len-1; i++) {
            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i+1); //assume even length.
        }
        return s.substring(lo, lo + maxLen);
    }

    private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }


    public List<List<Integer>> threeSum(int[] nums) {
        Set<Integer> set;
        Set<String> keep = new HashSet<String>();
        List<List<Integer>> re = new ArrayList<List<Integer>>();
        List<Integer> is;
        for (int i = 0; i < nums.length - 1; i++) {
            set = new HashSet<Integer>();
            for (int j = i + 1; j < nums.length; j++) {
                is = new ArrayList<Integer>();
                if (set.contains(0 - nums[i] - nums[j])) {
                    is.add(nums[i]);
                    is.add(nums[j]);
                    is.add(0 - nums[i] - nums[j]);
                    Collections.sort(is);
                    String s = String.valueOf(is.get(0)) + String.valueOf(is.get(1)) + String.valueOf(is.get(2));
                    if (!keep.contains(s)) {
                        re.add(is);
                        keep.add(s);
                    }
                }
                set.add(nums[j]);
            }
        }
        return re;
    }

}
