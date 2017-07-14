package edu.zju.liuz.leetcode;

import java.util.*;

/**
 * Created by Administrator on 2017/5/24.
 */
public class Solution {

    /**
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     * @Example:
     * Given nums = [2, 7, 11, 15], target = 9,
     * return [0, 1].
     * */
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

    /**
     * Given a string, find the length of the longest substring without repeating characters.
     * @Example:
     * Given "abcabcbb", the answer is "abc", which the length is 3.
     * Given "bbbbb", the answer is "b", with the length of 1.
     * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
     * */
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


    /**
     * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
     * @Example:
     * Input: "babad"
     * Output: "bab"
     * Note: "aba" is also a valid answer.
     * */
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

    public int numDecodings(String s) {
        if (s.equals("")) return 0;
        int res = 0;
        if (s.length()%2==0) {
            char[] is = s.toCharArray();
            res = count(is);
        } else {
            for (int i = 0; i < s.length(); i++) {
                char[] is1 = s.substring(0, i).toCharArray();
                char[] is2 = s.substring(i + 1, s.length()).toCharArray();
                res += count(is1) * count(is2) ;
            }
        }
        return res;
    }
    private int count(char[] is) {
        int count = 1;
        for (int i = 0; i < is.length/2; i++) {
            String t = String.valueOf(is[2*i])+is[2*i+1];
            count *= check(t);
        }
        if (is.length/2==1) return count;
        int count2 = 1;
        for (int i = 1; i < is.length/2; i++) {
            String t = String.valueOf(is[2*i-1])+is[2*i];
            count2 *= check(t);
        }
        return count+count2;
    }
    private int check(String t) {
        if (Integer.valueOf(t)<=26) {
            return 2;
        } else {
            return 1;
        }
    }

}
