package edu.zju.liuz.pat;

import java.util.*;

public class Main {
    /**
     * pat a 1001
     * */
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int a = scanner.nextInt();
//        int b = scanner.nextInt();
//        int result = a + b;
//        if (result==0) {
//            System.out.println(0);
//        } else {
//            String s0 = result>0?"":"-";
//            String s1 = "";
//            int i = 0;
//            result = Math.abs(result);
//            while (result > 0) {
//                if (i==3||i==6) {
//                    s1 = "," + s1;
//                }
//                i++;
//                s1 = result%10 + s1;
//                result = result/10;
//            }
//            System.out.println(s0 + s1);
//        }
//    }

    /**
     * pat a 1007 Maximum Subsequence Sum
     * 思路：1.到达该位置时的局部最大值；2.遍历前面数列后的最大值
     * 类似的问题想通手法解决。
     * */
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int K = scanner.nextInt();
//        int[] nums = new int[K];
//        for (int i = 0; i < K; i++) {
//            nums[i] = scanner.nextInt();
//        }
//        boolean isNegative = true;
//        int i = 0 , j = 0;
//        int tempI = 0, tempJ = 0;
//        int allMax = nums[0];
//        int theMax = nums[0];
//        for (int k = 1; k < K; k++) {
//            if (theMax + nums[k] > nums[k]) {
//                isNegative = false;
//                tempJ++;
//                theMax = theMax + nums[k];
//            } else {
//                theMax = nums[k];
//                tempI = tempJ = k;
//            }
//            if (theMax > allMax) {
//                allMax = theMax;
//                i = tempI;
//                j = tempJ;
//            }
//        }
//        if (isNegative) {
//            System.out.printf("%d %d %d", 0, nums[0], nums[K - 1]);
//        } else {
//            System.out.printf("%d %d %d", allMax, nums[i], nums[j]);
//        }
//    }

    /**
     pat a 1010
     思路：1.将数字都转换为十进制；2.寻找进制
     注意：要考虑radix可能是很大的 甚至大于int最大值
     * */
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String a = scanner.next();
//        String b = scanner.next();
//        int tag = scanner.nextInt();
//        int radix = scanner.nextInt();
//        long num1 = 0, num2 = 0;
//        boolean is = false;
//        int radixInt = 36;
//        go:
//        if (tag==1) {
//            char[] cs = a.toCharArray();
//            for (int i = cs.length - 1; i >= 0; i--) {
//                num1 = num1 * radix + getInt(cs[i]);
//            }
//            char[] cs2 = b.toCharArray();
//            while (true) {
//                if (radixInt==1) break;
//                num2 = 0;
//                for (int i = 0; i < cs2.length; i++) {
//                    if (radixInt < getInt(cs2[i])) break go;
//                    num2 = num2 * radixInt + getInt(cs2[i]);
//                }
//                if (num1==num2) {
//                    is = true;
//                    break;
//                } else if (num2>num1) {
//                    radixInt--;
//                } else if (num2<num1) {
//                    radixInt++;
//                }
//            }
//        } else if (tag==2) {
//            char[] cs = b.toCharArray();
//            for (int i = cs.length - 1; i >= 0; i--) {
//                num2 = num2 * radix + getInt(cs[i]);
//            }
//            char[] cs2 = a.toCharArray();
//            while (true) {
//                if (radixInt==1) break;
//                num1 = 0;
//                for (int i = 0; i < cs2.length; i++) {
//                    if (radixInt < getInt(cs2[i])) break go;
//                    num1 = num1 * radixInt + getInt(cs2[i]);
//                }
//                if (num1==num2) {
//                    is = true;
//                    break;
//                } else if (num1>num2) {
//                    radixInt--;
//                } else if (num1<num2) {
//                    radixInt++;
//                }
//            }
//        }
//
//        if (is) {
//            System.out.println(radixInt);
//        } else {
//            System.out.println("Impossible");
//        }
//    }
//    private static int getInt(char c) {
//        if (c >= '0'&&c <= '9') {
//            return c - '0';
//        } else {
//            return c - 'a' + 10;
//        }
//    }

    /**
     * pat advanced 1014 Waiting in Line
     * 思路：
     * 本题容易出错的地方：是在17:00及以后开始服务的客户输出"Sorry"，而不是17:00之前结束服务的输出"Sorry"；
     * 如客户是16:59开始服务，服务时间为2，则输出的应该是17:01，而不是"Sorry"。
     * */
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int N = scanner.nextInt();//window
//        int M = scanner.nextInt();//capacity
//        int K = scanner.nextInt();//num of people
//        int Q = scanner.nextInt();//num of queries
//        int[] process = new int[K];
//        int[] query = new int[Q];
//        String[] result = new String[Q];
//        for (int i = 0; i < K; i++) {
//            process[i] = scanner.nextInt();
//        }
//        for (int i = 0; i < Q; i++) {
//            query[i] = scanner.nextInt();
//        }
//        if (K <= N) {
//            for (int i = 0; i < Q; i++) {
//                int done = process[query[i] - 1];
//                result[i] = format(done, process[query[i] - 1]);
//            }
//        } else {
//            int[][] wait = new int[N][M];
//            for (int i = 0; i < N; i++) {
//                wait[i][0] = process[i];
//            }
//            if (K <= N * M) {
//                int ma = K / N;
//                for (int i = 0; i < N; i++) {
//                    for (int j = 1; j < ma; j++) {
//                        wait[i][j] = wait[i][j - 1] + process[j * N + i];
//                    }
//                }
//                for (int i = 0; i < K - N * (M - 1); i++) {
//                    wait[i][M - 1] = wait[i][M - 2] + process[(M - 1) * N + i];
//                }
//                for (int i = 0; i < Q; i++) {
//                    int done = wait[(query[i] - 1)%N][(query[i] - 1)/N];
//                    result[i] = format(done, process[query[i] - 1]);
//                }
//            } else {
//                for (int i = 0; i < N; i++) {
//                    for (int j = 1; j < M; j++) {
//                        wait[i][j] = wait[i][j - 1] + process[j * N + i];
//                    }
//                }
//                int change = N * M;
//                for (int i = 0; i < Q; i++) {
//                    int done;
//                    if (query[i] <= N * M) {
//                        done = wait[(query[i] - 1)%N][(query[i] - 1)/N];
//                    } else {
//                        int q = 0;
//                        for (int j = 0; j < query[i] - change; j++) {
//                            int min = Integer.MIN_VALUE;
//                            for (int k = 0; k < N; k++) {
//                                if (wait[k][0] < min) {
//                                    min = wait[k][0];
//                                    q = k;
//                                }
//                            }
//                            if (M != 1) {
//                                for (int m = 0; m < M - 1; m++) {
//                                    wait[q][m] = wait[q][m + 1];
//                                }
//                                wait[q][M - 1] = wait[q][M - 2] + process[change + j];
//                            } else {
//                                wait[q][0] = wait[q][0] + process[change + j];
//                            }
//                        }
//                        done = wait[q][M - 1];
//                        change = query[i];
//                    }
//                    result[i] = format(done, process[query[i] - 1]);
//                }
//            }
//        }
//        for (String s: result) {
//            System.out.println(s);
//        }
//    }
//    public static String format(int done, int process) {
//        String result;
//        int m = done % 60;
//        int h = 8 + (done - m)/60;
//        h = h>17?17:h;
//        int sh = 8 + (done - process)/60;
//        if (sh >= 17) result = "Sorry";
//        else result = (h>9?String.valueOf(h):"0"+h)+":"+(m>9?String.valueOf(m):"0"+m);
//        return result;
//    }

    /**
     pat advanced 1015 Reversible Primes
     A reversible prime in any number system is a prime whose "reverse" in that number system is also a prime. For example in the decimal system 73 is a reversible prime because its reverse 37 is also a prime.
     Now given any two positive integers N (< 105) and D (1 < D <= 10), you are supposed to tell if N is a reversible prime with radix D.
     Input Specification:
     The input file consists of several test cases. Each case occupies a line which contains two integers N and D. The input is finished by a negative N.
     Output Specification:
     For each test case, print in one line "Yes" if N is a reversible prime with radix D, or "No" if not.
     Sample Input:
     73 10
     23 2
     23 10
     -2
     Sample Output:
     Yes
     Yes
     No
     思路：1.判断是否素数；2.某进制下数字如何反转
     结果：通过测试点0,1,2,未通过3
     * */
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        ArrayList<Integer> NS = new ArrayList<>();
//        ArrayList<Integer> DS = new ArrayList<>();
//        while (scanner.hasNext()) {
//            int i = scanner.nextInt();
//            if (i < 0) break;
//            NS.add(i);
//            DS.add(scanner.nextInt());
//        }
//        String[] result = new String[NS.size()];
//        for (int i = 0; i < result.length; i++) {
//            result[i] = isPrime(NS.get(i));
//            result[i] = isPrime(reverse(NS.get(i), DS.get(i)));
//        }
//        for (String s: result) {
//            System.out.println(s);
//        }
//    }
//    public static String isPrime(int num) {
//        if (num<2) return "No";
//        for (int i = 2; i < num/2; i++) {
//            if (num%i==0) return "No";
//        }
//        return "Yes";
//    }
//    public static int reverse(int num, int radix) {
//        String numofradix = "";
//        do {
//            numofradix = numofradix + num%radix;
//            num = num/radix;
//        } while (num!=0);
//        for (int i = 0; i < numofradix.length(); i++) {
//            num = num*radix + (numofradix.charAt(i)-'0');
//        }
//        return num;
//    }

    /**
     pat advanced 1016 phone bills
     A long-distance telephone company charges its customers by the following rules:
     Making a long-distance call costs a certain amount per minute, depending on the time
     of day when the call is made. When a customer starts connecting a long-distance call,
     the time will be recorded, and so will be the time when the customer hangs up the phone.
     Every calendar month, a bill is sent to the customer for each minute called
     (at a rate determined by the time of day). Your job is to prepare the bills for each month,
     given a set of phone call records.
     Input Specification:
     Each input file contains one test case. Each case has two parts: the rate structure,
     and the phone call records.
     The rate structure consists of a line with 24 non-negative integers denoting the toll
     (cents/minute) from 00:00 - 01:00, the toll from 01:00 - 02:00, and so on for each hour in the day.
     The next line contains a positive number N (<= 1000), followed by N lines of records.
     Each phone call record consists of the name of the customer
     (string of up to 20 characters without space), the time and date (mm:dd:hh:mm),
     and the word "on-line" or "off-line".
     For each test case, all dates will be within a single month. Each "on-line" record is
     paired with the chronologically next record for the same customer provided it is an "off-line" record.
     Any "on-line" records that are not paired with an "off-line" record are ignored,
     as are "off-line" records not paired with an "on-line" record. It is guaranteed that
     at least one call is well paired in the input. You may assume that no two records for the
     same customer have the same time. Times are recorded using a 24-hour clock.
     Output Specification:
     For each test case, you must print a phone bill for each customer.
     Bills must be printed in alphabetical order of customers' names. For each customer,
     first print in a line the name of the customer and the month of the bill in the format shown by the sample. Then for each time period of a call, print in one line the beginning and ending time and date (dd:hh:mm), the lasting time (in minute) and the charge of the call. The calls must be listed in chronological order. Finally, print the total charge for the month in the format shown by the sample.
     Sample Input:
     10 10 10 10 10 10 20 20 20 15 15 15 15 15 15 15 20 30 20 15 15 10 10 10
     10
     CYLL 01:01:06:01 on-line
     CYLL 01:28:16:05 off-line
     CYJJ 01:01:07:00 off-line
     CYLL 01:01:08:03 off-line
     CYJJ 01:01:05:59 on-line
     aaa 01:01:01:03 on-line
     aaa 01:02:00:01 on-line
     CYLL 01:28:15:41 on-line
     aaa 01:05:02:24 on-line
     aaa 01:04:23:59 off-line
     Sample Output:
     CYJJ 01
     01:05:59 01:07:00 61 $12.10
     Total amount: $12.10
     CYLL 01
     01:06:01 01:08:03 122 $24.40
     28:15:41 28:16:05 24 $3.85
     Total amount: $28.25
     aaa 01
     02:00:01 04:23:59 4318 $638.80
     Total amount: $638.80
     思路：1.Map存储每个人的所有记录（List）；2.记录排序（怎么排序？）；3.遍历记录得到结果
     * */
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int[] rate = new int[24];//24每个小时的费用
//        for (int i = 0; i < rate.length; i++) {
//        }
//    }

    /**
     pat advanced 1017 Queueing at Bank
     Suppose a bank has K windows open for service. There is a yellow line in front of the windows
     which devides the waiting area into two parts. All the customers have to wait in line behind
     the yellow line, until it is his/her turn to be served and there is a window available.
     It is assumed that no window can be occupied by a single customer for more than 1 hour.
     Now given the arriving time T and the processing time P of each customer, you are supposed to
     tell the average waiting time of all the customers.
     Input Specification:
     Each input file contains one test case. For each case, the first line contains 2 numbers:
     N (<=10000) - the total number of customers, and K (<=100) - the number of windows.
     Then N lines follow, each contains 2 times: HH:MM:SS - the arriving time, and P - the
     processing time in minutes of a customer. Here HH is in the range [00, 23], MM and SS are
     both in [00, 59]. It is assumed that no two customers arrives at the same time.
     Notice that the bank opens from 08:00 to 17:00. Anyone arrives early will have to wait in line
     till 08:00, and anyone comes too late (at or after 17:00:01) will not be served nor counted into
     the average.
     Output Specification:
     For each test case, print in one line the average waiting time of all the customers, in minutes
     and accurate up to 1 decimal place.
     Sample Input:
     7 3
     07:55:00 16
     17:00:01 2
     07:59:59 15
     08:01:00 60
     08:00:00 30
     08:00:02 2
     08:03:00 10
     Sample Output:
     8.2
     思路：1.queue存储排队的人，到达时间优先；2.窗口结束前一个人后，记录到达和结束时间，并从队列取下一个人
     注意：到达时间不等于服务开始的时间；开始服务的时间超过17点是否也不需要计入？
     * */
//    public static void main(String[] args) {
//        int sum = 0;
//        int count = 0;
//        Scanner scanner = new Scanner(System.in);
//        int N = scanner.nextInt();
//        int K = scanner.nextInt();
//        Queue<Person> queue = new PriorityQueue<>(N);
//        for (int i = 0; i < N; i++) {
//            count++;
//            queue.add(new Person());//todo 去掉17点后来的人
//        }
//        Person[] window = new Person[K];
//        if (count <= K) {
//            for (Person p: queue) {
//                sum += p.process;
//            }
//        } else {
//            for (int i = 0; i < K; i++) {
//
//            }
//            while (!queue.isEmpty()) {
//
//            }
//        }
//
//        System.out.printf("%.0f", (double)sum/count);
//    }
//    public static class Person {
//        int arrival;
//        int process;
//        int complete;
//    }

    /**
     pat advanced 1018
     * */


    /**
     pat advanced 1019 General Palindromic Number
     A number that will be the same when it is written forwards or backwards is known as a Palindromic
     Number. For example, 1234321 is a palindromic number. All single digit numbers are palindromic numbers.
     Although palindromic numbers are most often considered in the decimal system, the concept of
     palindromicity can be applied to the natural numbers in any numeral system. Consider a number N > 0
     in base b >= 2, where it is written in standard notation with k+1 digits ai as the sum of (aibi)
     for i from 0 to k. Here, as usual, 0 <= ai < b for all i and ak is non-zero. Then N is palindromic
     if and only if ai = ak-i for all i. Zero is written 0 in any base and is also palindromic by definition.
     Given any non-negative decimal integer N and a base b, you are supposed to tell if N is a palindromic
     number in base b.
     Input Specification:
     Each input file contains one test case. Each case consists of two non-negative numbers N and b,
     where 0 <= N <= 109 is the decimal number and 2 <= b <= 109 is the base. The numbers are separated
     by a space.
     Output Specification:
     For each test case, first print in one line "Yes" if N is a palindromic number in base b, or "No"
     if not. Then in the next line, print N as the number in base b in the form "ak ak-1 ... a0". Notice
     that there must be no extra space at the end of output.
     Sample Input 1:
     27 2
     Sample Output 1:
     Yes
     1 1 0 1 1
     Sample Input 2:
     121 5
     Sample Output 2:
     No
     4 4 1
     思路：1.将十进制数转换为b进制；2.判断转换后是否为Palindromic Number
     注意：当base比较大的时候，我们无法直接写出转换后的数字，因此用int数组来表示转换后数字。
     结果：未通过6,7
     * */
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int num = scanner.nextInt();
//        int base = scanner.nextInt();
//        int[] trans = trans(num, base);
//        if (isPali(trans)) System.out.println("Yes");
//        else System.out.println("No");
//        for (int i = 0; i < trans.length - 1; i++) {
//            System.out.print(trans[i] + " ");
//        }
//        System.out.print(trans[trans.length - 1]);
//    }
//    public static int[] trans(int num, int base) {
//        int temp = 0;
//        int[] is = new int[8];
//        int count = 0;
//        do {
//            temp = num%base;
//            is[count] = temp;
//            num = num/base;
//            count++;
//        } while (num!=0);
//        int[] result = new int[count];
//        for (int i = 0; i < count; i++) {
//            result[count - i - 1] = is[i];
//        }
//        return result;
//    }
//    public static boolean isPali(int[] num) {
//        for (int i = 0; i < num.length/2; i++) {
//            if (num[i]!=num[num.length - 1 - i]) return false;
//        }
//        return true;
//    }

    /**
     * pat advanced 1020 Tree Traversals
     Suppose that all the keys in a binary tree are distinct positive integers. Given the postorder
     and inorder traversal sequences, you are supposed to output the level order traversal sequence
     of the corresponding binary tree.
     Input Specification:
     Each input file contains one test case. For each case, the first line gives a positive integer
     N (<=30), the total number of nodes in the binary tree. The second line gives the postorder
     sequence and the third line gives the inorder sequence. All the numbers in a line are separated
     by a space.
     Output Specification:
     For each test case, print in one line the level order traversal sequence of the corresponding
     binary tree. All the numbers in a line must be separated by exactly one space, and there must
     be no extra space at the end of the line.
     Sample Input:
     7
     2 3 1 5 7 6 4
     1 2 3 4 5 6 7
     Sample Output:
     4 1 6 3 5 7 2
     思路：1.利用后序和中序创建树（学习一个！）；2.层次遍历该树
     结果：全部通过
     * */
//    public static void main(String[] args) {
//        Node root = new Node();
//        Scanner scanner = new Scanner(System.in);
//        int sum = scanner.nextInt();
//        int[] postorder = new int[sum];
//        int[] inorder = new int[sum];
//        for (int i = 0; i < sum; i++) {
//            postorder[i] = scanner.nextInt();
//        }
//        for (int i = 0; i < sum; i++) {
//            inorder[i] = scanner.nextInt();
//        }
//        createTree(root, postorder, inorder);
//        levelOrderTree(root);
//    }
//    public static void createTree(Node root, int[] post, int[] in) {
//        root.key = post[post.length - 1];
//        if (post.length == 1) return;
//        int i = 0;
//        for (; i < in.length; i++) {
//            if (in[i]==root.key) break;
//        }
//        if (i > 0) {
//            int[] leftpost = new int[i];
//            int[] leftin = new int[i];
//            for (int j = 0; j < i; j++) {
//                leftpost[j] = post[j];
//                leftin[j] = in[j];
//            }
//            Node left = new Node();
//            root.left = left;
//            createTree(left, leftpost, leftin);
//        }
//        if (post.length - i - 1 > 0) {
//            int[] rightpost = new int[post.length - i - 1];
//            int[] rightin = new int[post.length - i - 1];
//            for (int j = 0; j < post.length - i - 1; j++) {
//                rightpost[j] = post[j + i];
//                rightin[j] = in[j + i + 1];
//            }
//            Node right = new Node();
//            root.right = right;
//            createTree(right, rightpost, rightin);
//        }
//    }
//    public static void levelOrderTree(Node root) {
//        Queue<Node> queue = new ArrayDeque<>();
//        queue.add(root);
//        Node node = queue.remove();
//        System.out.print(node.key);
//        if (node.left!=null) queue.add(node.left);
//        if (node.right!=null) queue.add(node.right);
//        while (!queue.isEmpty()) {
//            node = queue.remove();
//            System.out.print(" " + node.key);
//            if (node.left!=null) queue.add(node.left);
//            if (node.right!=null) queue.add(node.right);
//        }
//    }
//    public static class Node {
//        Node left;
//        Node right;
//        int key;
//    }

    /**
     pat advanced 1021 Deepest Root (25)
     A graph which is connected and acyclic can be considered a tree. The height of the tree
     depends on the selected root. Now you are supposed to find the root that results in a
     highest tree. Such a root is called the deepest root.
     Input Specification:
     Each input file contains one test case. For each case, the first line contains a positive
     integer N (<=10000) which is the number of nodes, and hence the nodes are numbered from 1
     to N. Then N-1 lines follow, each describes an edge by given the two adjacent nodes' numbers.
     Output Specification:
     For each test case, print each of the deepest roots in a line. If such a root is not unique,
     print them in increasing order of their numbers. In case that the given graph is not a tree,
     print "Error: K components" where K is the number of connected components in the graph.
     Sample Input 1:
     5
     1 2
     1 3
     1 4
     2 5
     Sample Output 1:
     3
     4
     5
     Sample Input 2:
     5
     1 3
     1 4
     2 5
     3 4
     Sample Output 2:
     Error: 2 components
     图相关题目之后做
     * */

    /**
     pat advanced 1022 Digital Library
     A Digital Library contains millions of books, stored according to their titles, authors,
     key words of their abstracts, publishers, and published years. Each book is assigned an
     unique 7-digit number as its ID. Given any query from a reader, you are supposed to output
     the resulting books, sorted in increasing order of their ID's.
     Input Specification:
     Each input file contains one test case. For each case, the first line contains a positive
     integer N (<=10000) which is the total number of books. Then N blocks follow, each contains
     the information of a book in 6 lines:
     Line #1: the 7-digit ID number;
     Line #2: the book title -- a string of no more than 80 characters;
     Line #3: the author -- a string of no more than 80 characters;
     Line #4: the key words -- each word is a string of no more than 10 characters without any
     white space, and the keywords are separated by exactly one space;
     Line #5: the publisher -- a string of no more than 80 characters;
     Line #6: the published year -- a 4-digit number which is in the range [1000, 3000].
     It is assumed that each book belongs to one author only, and contains no more than 5 key words;
     there are no more than 1000 distinct key words in total; and there are no more than 1000 distinct
     publishers.
     After the book information, there is a line containing a positive integer M (<=1000) which is
     the number of user's search queries. Then M lines follow, each in one of the formats shown below:
     1: a book title
     2: name of an author
     3: a key word
     4: name of a publisher
     5: a 4-digit number representing the year
     Output Specification:
     For each query, first print the original query in a line, then output the resulting book ID's in
     increasing order, each occupying a line. If no book is found, print "Not Found" instead.
     Sample Input:
     3
     1111111
     The Testing Book
     Yue Chen
     test code debug sort keywords
     ZUCS Print
     2011
     3333333
     Another Testing Book
     Yue Chen
     test code sort keywords
     ZUCS Print2
     2012
     2222222
     The Testing Book
     CYLL
     keywords debug book
     ZUCS Print2
     2011
     6
     1: The Testing Book
     2: Yue Chen
     3: keywords
     4: ZUCS Print
     5: 2011
     3: blablabla
     Sample Output:
     1: The Testing Book
     1111111
     2222222
     2: Yue Chen
     1111111
     3333333
     3: keywords
     1111111
     2222222
     3333333
     4: ZUCS Print
     1111111
     5: 2011
     1111111
     2222222
     3: blablabla
     Not Found
     思路：1.利用Map存储书信息；2.根据查询类型到相应Map中查找书籍
     * */
//    public static void main(String[] args) {
//        Set<Integer> books = new HashSet<>();
//        Map<String, List<Integer>> title = new HashMap<>();
//        Map<String, List<Integer>> author = new HashMap<>();
//        Map<String, List<Integer>> keyword = new HashMap<>();
//        Map<String, List<Integer>> publisher = new HashMap<>();
//        Map<Integer, List<Integer>> year = new HashMap<>();
//        Scanner scanner = new Scanner(System.in);
//        int booksum = scanner.nextInt();
//        for (int i = 0; i < booksum; i++) {
//            int id = scanner.nextInt();
//            if (!books.contains(id)) {
//                books.add(id);
//                String s = scanner.next();
//                if (title.keySet().contains(s)) {
//
//                } else {
//
//                }
//            }
//        }
//        int querysum = scanner.nextInt();
//        String[] query = new String[querysum];
//        for (int i = 0; i < querysum; i++) {
//            query[i] = scanner.next();
//        }
//        String[] result = new String[querysum];
//
//    }
//    public static String find(String s) {
//        String result = "";
//        return result;
//    }

    /**
     pat advanced 1023 Have Fun with Numbers (20)
     Notice that the number 123456789 is a 9-digit number consisting exactly the numbers from 1 to 9,
     with no duplication. Double it we will obtain 246913578, which happens to be another 9-digit
     number consisting exactly the numbers from 1 to 9, only in a different permutation. Check to see
     the result if we double it again!
     Now you are suppose to check if there are more numbers with this property. That is, double a given
     number with k digits, you are to tell if the resulting number consists of only a permutation of
     the digits in the original number.
     Input Specification:
     Each input file contains one test case. Each case contains one positive integer with no more than
     20 digits.
     Output Specification:
     For each test case, first print in a line "Yes" if doubling the input number gives a number that
     consists of only a permutation of the digits in the original number, or "No" if not. Then in the
     next line, print the doubled number.
     Sample Input:
     1234567899
     Sample Output:
     Yes
     2469135798
     思路：1.大数乘以2（学习一个！分治思想）；2.对两个数字每位计数
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String origin = scanner.next();
        String trans = doubleNum(origin);
        int[] count1 = new int[10];
        int[] count2 = new int[10];
        boolean yes = true;
        for (char c: trans.toCharArray()) {
            count2[c-'0']++;
        }
        for (char c: origin.toCharArray()) {
            count1[c-'0']++;
        }
        for (int i = 0; i < 10; i++) {
            if (count1[i]!=count2[i]) {
                yes = false;
                break;
            }
        }
        if (yes) System.out.println("Yes");
        else System.out.println("No");
        System.out.println(trans);
    }
    public static String doubleNum(String num) {
        String result = "";
        char[] cs = num.toCharArray();
        int[] re = new int[cs.length + 1];
        for (int i = 1; i < re.length; i++) {
            re[i] = (cs[i - 1] - '0') * 2;
        }
        for (int i = 0; i < re.length - 1; i++) {
            re[i] = re[i + 1]/10 + re[i];
            re[i + 1] = re[i + 1]%10;
        }
        boolean start = false;
        for (int i = 0; i < re.length; i++) {
            if (re[i] > 0) start = true;
            if (start) result += ""+re[i];
        }
        return result;
    }

    /**
     1024. Palindromic Number (25)
     A number that will be the same when it is written forwards or backwards is known as a Palindromic
     Number. For example, 1234321 is a palindromic number. All single digit numbers are palindromic numbers.
     Non-palindromic numbers can be paired with palindromic ones via a series of operations. First,
     the non-palindromic number is reversed and the result is added to the original number. If the result
     is not a palindromic number, this is repeated until it gives a palindromic number. For example, if we
     start from 67, we can obtain a palindromic number in 2 steps: 67 + 76 = 143, and 143 + 341 = 484.
     Given any positive integer N, you are supposed to find its paired palindromic number and the number
     of steps taken to find it.
     Input Specification:
     Each input file contains one test case. Each case consists of two positive numbers N and K, where
     N (<= 1010) is the initial numer and K (<= 100) is the maximum number of steps. The numbers are
     separated by a space.
     Output Specification:
     For each test case, output two numbers, one in each line. The first number is the paired palindromic
     number of N, and the second number is the number of steps taken to find the palindromic number. If
     the palindromic number is not found after K steps, just output the number obtained at the Kth step
     and K instead.
     Sample Input 1:
     67 3
     Sample Output 1:
     484
     2
     Sample Input 2:
     69 3
     Sample Output 2:
     1353
     3
     思路：1.步骤次数内做题目所给运算；2.循环判断是否Palindromic Number；
     * */

    

}