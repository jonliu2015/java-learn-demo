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

//    public int numDecodings(String s) {
//        if (s.equals("")) return 0;
//        int res = 0;
//        if (s.length()%2==0) {
//            char[] is = s.toCharArray();
//            res = count(is);
//        } else {
//            for (int i = 0; i < s.length(); i++) {
//                char[] is1 = s.substring(0, i).toCharArray();
//                char[] is2 = s.substring(i + 1, s.length()).toCharArray();
//                res += count(is1) * count(is2) ;
//            }
//        }
//        return res;
//    }
//    private int count(char[] is) {
//        int count = 1;
//        for (int i = 0; i < is.length/2; i++) {
//            String t = String.valueOf(is[2*i])+is[2*i+1];
//            count *= check(t);
//        }
//        if (is.length/2==1) return count;
//        int count2 = 1;
//        for (int i = 1; i < is.length/2; i++) {
//            String t = String.valueOf(is[2*i-1])+is[2*i];
//            count2 *= check(t);
//        }
//        return count+count2;
//    }
//    private int check(String t) {
//        if (Integer.valueOf(t)<=26) {
//            return 2;
//        } else {
//            return 1;
//        }
//    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 3; i++) {
            if(i==0 || (i>0 && nums[i]!=nums[i-1])) {
                for (int j = i+1; j < nums.length - 2; j++) {
                    if (j==i+1 || (j>i+1 && nums[j]!=nums[j-1])) {
                        int lo = j+1, hi = nums.length - 1;
                        int t = target - nums[i] - nums[j];
                        while (lo != hi) {
                            if (nums[lo] + nums[hi] == t) {
                                if (lo>j+1&&nums[lo]==nums[lo-1]) {
                                    lo++;
                                } else if (hi<nums.length - 1&&nums[hi]==nums[hi+1]) {
                                    hi--;
                                } else {
                                    List<Integer> list = new ArrayList<Integer>();
                                    list.add(nums[i]);
                                    list.add(nums[j]);
                                    list.add(nums[lo]);
                                    list.add(nums[hi]);
                                    res.add(list);
                                    lo++;
                                }
                            } else if (nums[lo] + nums[hi] < t) lo++;
                            else if (nums[lo] + nums[hi] > t) hi--;
                        }
                    }
                }
            }
        }
        System.out.println(res);
        return res;
    }

    public void nextPermutation(int[] nums) {//TODO

    }
    public int divide(int dividend, int divisor) {
        //Reduce the problem to positive long integer to make it easier.
        //Use long to avoid integer overflow cases.
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
            sign = -1;
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);

        //Take care the edge cases.
        if (ldivisor == 0) return Integer.MAX_VALUE;
        if ((ldividend == 0) || (ldividend < ldivisor))	return 0;

        long lans = ldivide(ldividend, ldivisor);

        int ans;
        if (lans > Integer.MAX_VALUE){ //Handle overflow.
            ans = (sign == 1)? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            ans = (int) (sign * lans);
        }
        return ans;
    }

    private long ldivide(long ldividend, long ldivisor) {
        // Recursion exit condition
        if (ldividend < ldivisor) return 0;

        //  Find the largest multiple so that (divisor * multiple <= dividend),
        //  whereas we are moving with stride 1, 2, 4, 8, 16...2^n for performance reason.
        //  Think this as a binary search.
        long sum = ldivisor;
        long multiple = 1;
        while ((sum+sum) <= ldividend) {
            sum += sum;
            multiple += multiple;
        }
        //Look for additional value for the multiple from the reminder (dividend - sum) recursively.
        return multiple + ldivide(ldividend - sum, ldivisor);
    }

    public String fractionToDecimal(int numerator, int denominator) {//TODO 正负
        int integer = numerator/denominator;
        int remain = numerator%denominator;
        if (remain==0) {
            return String.valueOf(integer);
        } else {
            return String.valueOf(integer)+remain(remain, denominator);
        }
    }
    private String remain(int remain, int denominator) {
        int temp = remain;
        String res = "";
        boolean isRepeat = false;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int index = 0;
        map.put(temp, index);
        while (temp!=0) {
            index++;
            int u = (temp * 10) / denominator;
            temp = (temp * 10) % denominator;
            res += String.valueOf(u);
            if (map.containsKey(temp)) {
                isRepeat = true;
                index = map.get(temp);
                break;
            } else {
                map.put(temp, index);
            }
        }
        if (isRepeat) res = res.substring(0, index) + "(" + res.substring(index, res.length()) + ")";
        return "." + res;
    }

    public void solve(char[][] board) {
        if (board.length==0) return;
        for (int j = 0; j < board[0].length; j++) {
            int tempI = 0;
            int tempJ = j;
            uf(tempI, tempJ, board);
        }
        for (int j = 0; j < board[0].length; j++) {
            int tempI = board.length - 1;
            int tempJ = j;
            uf(tempI, tempJ, board);
        }
        for (int i = 0; i < board.length; i++) {
            int tempI = i;
            int tempJ = 0;
            uf(tempI, tempJ, board);
        }
        for (int i = 0; i < board.length; i++) {
            int tempI = i;
            int tempJ = board[0].length - 1;
            uf(tempI, tempJ, board);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j]=='1') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }
    private void uf(int tempI, int tempJ, char[][] board) {
        while (board[tempI][tempJ]!='1'&&board[tempI][tempJ]=='O') {
            board[tempI][tempJ] = '1';
            if (tempI - 1 > 0) uf(tempI - 1, tempJ, board);
            if (tempI + 1 < board.length) uf(tempI + 1, tempJ, board);
            if (tempJ - 1 > 0) uf(tempI, tempJ - 1, board);
            if (tempJ + 1 < board[0].length) uf(tempI, tempJ + 1, board);
        }
        return;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {//TODO
        Map<String, Set<String>> map = new HashMap<String, Set<String>>();
        Set<String> set = new HashSet<String>();
        int length = 2;
        String lastWord = beginWord;
        while (true) {
            for (String s: wordList) {
                if (isNext(lastWord, s)) {
                    set.add(s);
                }
            }
            for(String s: set) {
                if (isNext(s, endWord)) {
                    return length;
                }
            }
            map.put(beginWord, set);
        }
    }
    private boolean isNext(String str1, String str2) {
        int count = 0;
        char[] cs1 = str1.toCharArray();
        char[] cs2 = str2.toCharArray();
        for (int i = 0; i < cs1.length; i++) {
            if (cs1[i]==cs2[i]) {
                count++;
            }
        }
        return count==1;
    }

    public int numDecodings(String s) {
        return numDe(s);
    }
    private int numDe(String s) {
        if (s.equals("")) return 0;
        else if (s.length()==1) return 1;
        else if (s.length()==2) {
            if (Integer.valueOf(s)<26) {
                return 2;
            } else {
                return 1;
            }
        } else if (s.length()%2==0) {
            int res = 1;
            for (int i = 0; i < s.length() - 2; i += 2) {
                res *= numDe(s.substring(i, i + 2));
            }
            res += numDe(s.substring(1, s.length()));
            return res - 1;
        } else {
            int res = 0;
            for (int i = 0; i < s.length(); i += 2) {
                int n1 = numDe(s.substring(0, i))==0?1:numDe(s.substring(0, i));
                int n2 = numDe(s.substring(i + 1, s.length()))==0?1:numDe(s.substring(i + 1, s.length()));
                res +=  n1 * n2;
            }
            return res;
        }
    }

    public String largestNumber(int[] nums) {
        if (nums.length == 0) return "";
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > i ; j--) {
                if (compare(nums[j], nums[j-1])) {
                    swap(nums, j, j-1);
                }
            }
        }
        if (nums[0] == 0) return "0";
        String res = "";
        for (int i : nums) {
            res += String.valueOf(i);
        }
        return res;
    }
    private void swap (int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    //return true if num1 is 'larger' than num2
    private boolean compare(int num1, int num2) {//TODO 可以考虑使用compare接口
        String s1 = String.valueOf(num1);
        String s2 = String.valueOf(num2);
        long n1 = Long.valueOf(s1+s2);
        long n2 = Long.valueOf(s2+s1);
        return n1>n2;
    }

    /**
     * Definition for a point.
     * class Point {
     *     int x;
     *     int y;
     *     Point() { x = 0; y = 0; }
     *     Point(int a, int b) { x = a; y = b; }
     * }
     */
    class Point {
        int x;
        int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) { x = a; y = b; }
    }
    public int maxPoints(Point[] points) {
        return 0;
    }

}
