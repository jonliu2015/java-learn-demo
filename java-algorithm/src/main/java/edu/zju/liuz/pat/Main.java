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
     * 类似问题类似方法解决。
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
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String origin = scanner.next();
//        String trans = doubleNum(origin);
//        int[] count1 = new int[10];
//        int[] count2 = new int[10];
//        boolean yes = true;
//        for (char c: trans.toCharArray()) {
//            count2[c-'0']++;
//        }
//        for (char c: origin.toCharArray()) {
//            count1[c-'0']++;
//        }
//        for (int i = 0; i < 10; i++) {
//            if (count1[i]!=count2[i]) {
//                yes = false;
//                break;
//            }
//        }
//        if (yes) System.out.println("Yes");
//        else System.out.println("No");
//        System.out.println(trans);
//    }
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


    /**
     1027	Colors in Mars (20)
     People in Mars represent the colors in their computers in a similar way as the Earth people. That is,
     a color is represented by a 6-digit number, where the first 2 digits are for Red, the middle 2 digits
     for Green, and the last 2 digits for Blue. The only difference is that they use radix 13 (0-9 and A-C)
     instead of 16. Now given a color in three decimal numbers (each between 0 and 168), you are supposed to
     output their Mars RGB values.
     Input
     Each input file contains one test case which occupies a line containing the three decimal color values.
     Output
     For each test case you should output the Mars RGB value in the following format: first output "#", then
     followed by a 6-digit number where all the English characters must be upper-cased. If a single color is
     only 1-digit long, you must print a "0" to the left.
     Sample Input
     15 43 71
     Sample Output
     #123456
     思路：将13进制转换为16进制即可
     注意：一位时0的处理
     * */



    /**
     1028. List Sorting (25)
     Excel can sort records according to any column. Now you are supposed to imitate this function.
     Input
     Each input file contains one test case. For each case, the first line contains two integers N (<=100000)
     and C, where N is the number of records and C is the column that you are supposed to sort the records
     with. Then N lines follow, each contains a record of a student. A student's record consists of his or
     her distinct ID (a 6-digit number), name (a string with no more than 8 characters without space), and
     grade (an integer between 0 and 100, inclusive).
     Output
     For each test case, output the sorting result in N lines. That is, if C = 1 then the records must be
     sorted in increasing order according to ID's; if C = 2 then the records must be sorted in non-decreasing
     order according to names; and if C = 3 then the records must be sorted in non-decreasing order according
     to grades. If there are several students who have the same name or grade, they must be sorted according
     to their ID's in increasing order.
     Sample Input 1
     3 1
     000007 James 85
     000010 Amy 90
     000001 Zoe 60
     Sample Output 1
     000001 Zoe 60
     000007 James 85
     000010 Amy 90
     Sample Input 2
     4 2
     000007 James 85
     000010 Amy 90
     000001 Zoe 60
     000002 James 98
     Sample Output 2
     000010 Amy 90
     000002 James 98
     000007 James 85
     000001 Zoe 60
     Sample Input 3
     4 3
     000007 James 85
     000010 Amy 90
     000001 Zoe 60
     000002 James 90
     Sample Output 3
     000001 Zoe 60
     000007 James 85
     000002 James 90
     000010 Amy 90
     思路：使用comparable接口，student对象保存type从而判断是对哪列排序
     * */
    public static class Student implements Comparable<Student>{
        int id;
        String name;
        int grade;
        int type;

        @Override
        public int compareTo(Student o) {
            if (type==1) {
                if (this.id>o.id) return 1;
                if (this.id<o.id) return -1;
                return 0;
            } else if (type==2) {
                return this.name.compareTo(o.name);
            } else if (type==3) {
                if (this.grade>o.grade) return 1;
                return 0;
            }
            return 0;
        }
    }


    /**
     1029. Median (25)
     Given an increasing sequence S of N integers, the median is the number at the middle position.
     For example, the median of S1={11, 12, 13, 14} is 12, and the median of S2={9, 10, 15, 16, 17} is 15.
     The median of two sequences is defined to be the median of the nondecreasing sequence which contains
     all the elements of both sequences. For example, the median of S1 and S2 is 13.
     Given two increasing sequences of integers, you are asked to find their median.
     Input
     Each input file contains one test case. Each case occupies 2 lines, each gives the information of a
     sequence. For each sequence, the first positive integer N (<=1000000) is the size of that sequence.
     Then N integers follow, separated by a space. It is guaranteed that all the integers are in the range
     of long int.
     Output
     For each test case you should output the median of the two given sequences in a line.
     Sample Input
     4 11 12 13 14
     5 9 10 15 16 17
     Sample Output
     13
     思路：归并排序？其实不用排序，归并的时候找到中间位置的那个就是中位数；由于超限，考虑不储存list2，
     在接受输入时就进行处理
     结果：归并排序内存超限，不行；但还是内存超限，不知为何。
     * */
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        //List<Long> list = new ArrayList<>();
//        int length1 = scanner.nextInt();
//        long[] list1 = new long[length1];
//        for (int i = 0; i < length1; i++) {
//            list1[i] = scanner.nextLong();
//            //list.add(scanner.nextLong());
//        }
//        int length2 = scanner.nextInt();
//        long[] list2 = new long[length2];
//        for (int i = 0; i < length2; i++) {
//            list2[i] = scanner.nextLong();
//            //list.add(scanner.nextLong());
//        }
//        //Collections.sort(list);
//        //int[] list = merge(list1, list2);
//        //int mid = (length1+length2)%2==1?(length1+length2)/2:(length1+length2-1)/2;
//        System.out.println(merge(list1, list2));
//
//    }

    public static long merge(long[] list1, long[] list2) {
        int length1 = list1.length;
        int length2 = list2.length;
        int index1 = 0;
        int index2 = 0;
        int mid = (length1+length2)%2==1?(length1+length2)/2:(length1+length2-1)/2;
        long num = 0;
        for (int i = 0; i <= mid; i++) {
            if (index1==length1) num = list2[index2++];
            else if (index2==length2) num = list1[index1++];
            else if (list1[index1]<list2[index2]) num = list1[index1++];
            else if (list1[index1]>list2[index2]) num = list2[index2++];
            else {
                num = list1[index1];
                index1++;
                index2++;
            }
        }
        return num;
    }

    public static int[] merge(int[] list1, int[] list2) {
        int length1 = list1.length;
        int length2 = list2.length;
        int[] list = new int[length1 + length2];
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < length1 + length2; i++) {
            if (index1==length1) list[i] = list2[index2++];
            else if (index2==length2) list[i] = list1[index1++];
            else if (list1[index1]<list2[index2]) list[i] = list1[index1++];
            else if (list1[index1]>list2[index2]) list[i] = list2[index2++];
            else {
                list[i++] = list1[index1++];
                list[i] = list2[index2++];
            }
        }
        return list;
    }

    /**
     1030. Travel Plan (30)
     A traveler's map gives the distances between cities along the highways, together with the cost
     of each highway. Now you are supposed to write a program to help a traveler to decide the shortest
     path between his/her starting city and the destination. If such a shortest path is not unique, you
     are supposed to output the one with the minimum cost, which is guaranteed to be unique.
     Input Specification:
     Each input file contains one test case. Each case starts with a line containing 4 positive integers
     N, M, S, and D, where N (<=500) is the number of cities (and hence the cities are numbered from 0
     to N-1); M is the number of highways; S and D are the starting and the destination cities,
     respectively. Then M lines follow, each provides the information of a highway, in the format:
     City1 City2 Distance Cost
     where the numbers are all integers no more than 500, and are separated by a space.
     Output Specification:
     For each test case, print in one line the cities along the shortest path from the starting point to
     the destination, followed by the total distance and the total cost of the path. The numbers must be
     separated by a space and there must be no extra space at the end of output.
     Sample Input
     4 5 0 3
     0 1 1 20
     1 3 2 30
     0 3 4 10
     0 2 2 20
     2 3 1 20
     Sample Output
     0 2 3 3 40
     * */


    /**
     1031. Hello World for U (20)
     Given any string of N (>=5) characters, you are asked to form the characters into the shape of U.
     For example, "helloworld" can be printed as:
     h  d
     e  l
     l  r
     lowo
     That is, the characters must be printed in the original order, starting top-down from the left
     vertical line with n1 characters, then left to right along the bottom line with n2 characters,
     and finally bottom-up along the vertical line with n3 characters. And more, we would like U to
     be as squared as possible -- that is, it must be satisfied that n1 = n3 = max { k| k <= n2 for
     all 3 <= n2 <= N } with n1 + n2 + n3 - 2 = N.
     Input Specification:
     Each input file contains one test case. Each case contains one string with no less than 5 and
     no more than 80 characters in a line. The string contains no white space.
     Output Specification:
     For each test case, print the input string in the shape of U as specified in the description.
     Sample Input:
     helloworld!
     Sample Output:
     h   !
     e   d
     l   l
     lowor
     思路：主要是要计算出n1=n3=(N+2)/3，n2=N+2-n1-n3，每行拼接好字符串即可
     * */

    /**
     To store English words, one method is to use linked lists and store a word letter by letter.
     To save some space, we may let the words share the same sublist if they share the same suffix.
     For example, "loading" and "being" are stored as showed in Figure 1.
     Figure 1
     You are supposed to find the starting position of the common suffix (e.g. the position of "i"
     in Figure 1).
     Input Specification:
     Each input file contains one test case. For each case, the first line contains two addresses
     of nodes and a positive N (<= 105), where the two addresses are the addresses of the first nodes
     of the two words, and N is the total number of nodes. The address of a node is a 5-digit positive
     integer, and NULL is represented by -1.
     Then N lines follow, each describes a node in the format:
     Address Data Next
     where Address is the position of the node, Data is the letter contained by this node which is an
     English letter chosen from {a-z, A-Z}, and Next is the position of the next node.
     Output Specification:
     For each case, simply output the 5-digit starting position of the common suffix. If the two words
     have no common suffix, output "-1" instead.
     Sample Input 1:
     11111 22222 9
     67890 i 00002
     00010 a 12345
     00003 g -1
     12345 D 67890
     00002 n 00003
     22222 B 23456
     11111 L 00001
     23456 e 67890
     00001 o 00010
     Sample Output 1:
     67890
     Sample Input 2:
     00001 00002 4
     00001 a 10001
     10001 s -1
     00002 a 10002
     10002 t -1
     Sample Output 2:
     -1
     思路：遍历节点的next，有无相同；
     结果：运行超时？？？
     * */
//    public static void main(String[] srg) {
//        Scanner scanner = new Scanner(System.in);
//        String head1 = scanner.next();
//        String head2 = scanner.next();
//        int amount = scanner.nextInt();
//        LetterNode[] letterNodes = new LetterNode[amount];
//        for (int i = 0; i < amount; i++) {
//            letterNodes[i] = new LetterNode();
//            letterNodes[i].pre = scanner.next();
//            letterNodes[i].value = scanner.next();
//            letterNodes[i].next = scanner.next();
//        }
//        Set<String> set = new HashSet<>();
//        String re = "-1";
//        for (LetterNode letterNode: letterNodes) {
//            if (set.contains(letterNode.next)) {
//                re = letterNode.next;
//            } else {
//                set.add(letterNode.next);
//            }
//        }
//        System.out.println(re);
//    }
    public static class LetterNode {
        String pre;
        String next;
        String value;
    }

    /**
     1033. To Fill or Not to Fill (25)
     With highways available, driving a car from Hangzhou to any other city is easy. But since the
     tank capacity of a car is limited, we have to find gas stations on the way from time to time.
     Different gas station may give different price. You are asked to carefully design the cheapest
     route to go.
     Input Specification:
     Each input file contains one test case. For each case, the first line contains 4 positive numbers:
     Cmax (<= 100), the maximum capacity of the tank; D (<=30000), the distance between Hangzhou and
     the destination city; Davg (<=20), the average distance per unit gas that the car can run; and
     N (<= 500), the total number of gas stations. Then N lines follow, each contains a pair of
     non-negative numbers: Pi, the unit gas price, and Di (<=D), the distance between this station and
     Hangzhou, for i=1,...N. All the numbers in a line are separated by a space.
     Output Specification:
     For each test case, print the cheapest price in a line, accurate up to 2 decimal places. It is
     assumed that the tank is empty at the beginning. If it is impossible to reach the destination,
     print "The maximum travel distance = X" where X is the maximum possible distance the car can run,
     accurate up to 2 decimal places.
     Sample Input 1:
     50 1300 12 8
     6.00 1250
     7.00 600
     7.00 150
     7.10 0
     7.20 200
     7.50 400
     7.30 1000
     6.85 300
     Sample Output 1:
     749.17
     Sample Input 2:
     50 1300 12 2
     7.10 0
     7.00 600
     Sample Output 2:
     The maximum travel distance = 1200.00
     * */


    /**
     1035. Password (20)
     To prepare for PAT, the judge sometimes has to generate random passwords for the users.
     The problem is that there are always some confusing passwords since it is hard to distinguish
     1 (one) from l (L in lowercase), or 0 (zero) from O (o in uppercase). One solution is to
     replace 1 (one) by @, 0 (zero) by %, l by L, and O by o. Now it is your job to write a
     program to check the accounts generated by the judge, and to help the juge modify the
     confusing passwords.
     Input Specification:
     Each input file contains one test case. Each case contains a positive integer N (<= 1000),
     followed by N lines of accounts. Each account consists of a user name and a password, both
     are strings of no more than 10 characters with no space.
     Output Specification:
     For each test case, first print the number M of accounts that have been modified, then print
     in the following M lines the modified accounts info, that is, the user names and the corresponding
     modified passwords. The accounts must be printed in the same order as they are read in. If no
     account is modified, print in one line "There are N accounts and no account is modified" where
     N is the total number of accounts. However, if N is one, you must print "There is 1 account
     and no account is modified" instead.
     Sample Input 1:
     3
     Team000002 Rlsp0dfa
     Team000003 perfectpwd
     Team000001 R1spOdfa
     Sample Output 1:
     2
     Team000002 RLsp%dfa
     Team000001 R@spodfa
     Sample Input 2:
     1
     team110 abcdefg332
     Sample Output 2:
     There is 1 account and no account is modified
     Sample Input 3:
     2
     team110 abcdefg222
     team220 abcdefg333
     Sample Output 3:
     There are 2 accounts and no account is modified
     思路：1.保存用户名和密码；2.检索密码字符串，替换。
     结果：格式错误什么鬼？
     * */
    public static class User {
        String name;
        String psd;
        boolean isModified = false;
    }
//    public static void main(String[] srgs) {
//        Scanner scanner = new Scanner(System.in);
//        int num = scanner.nextInt();
//        User[] users = new User[num];
//        int count = 0;
//        for (int i = 0; i < num; i++) {
//            users[i] = new User();
//            users[i].name = scanner.next();
//            users[i].psd = scanner.next();
//            if (check(users[i])) {
//                count++;
//            }
//        }
//        if (count==0) {
//            if (num>1) {
//                System.out.printf("There are %d accounts and no account is modified", num);
//            } else {
//                System.out.printf("There are %d account and no account is modified", num);
//            }
//        }
//        else {
//            System.out.println(count);
//            for (User user: users) {
//                if (user.isModified) System.out.printf("%s %s\n\r", user.name, user.psd);
//            }
//        }
//    }
    public static boolean check(User user) {
        boolean b = false;
        char[] cs = user.psd.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (cs[i]=='0') {
                cs[i]='%';
                b = true;
            }
            else if (cs[i]=='1') {
                cs[i]='@';
                b = true;
            }
            else if (cs[i]=='l') {
                cs[i]='L';
                b = true;
            }
            else if (cs[i]=='O') {
                cs[i]='o';
                b = true;
            }
        }
        user.psd = String.valueOf(cs);
        user.isModified = b;
        return b;
    }

    /**
     1036. Boys vs Girls (25)
     This time you are asked to tell the difference between the lowest grade of all the male
     students and the highest grade of all the female students.
     Input Specification:
     Each input file contains one test case. Each case contains a positive integer N, followed
     by N lines of student information. Each line contains a student's name, gender, ID and grade,
     separated by a space, where name and ID are strings of no more than 10 characters with no space,
     gender is either F (female) or M (male), and grade is an integer between 0 and 100. It is
     guaranteed that all the grades are distinct.
     Output Specification:
     For each test case, output in 3 lines. The first line gives the name and ID of the female
     student with the highest grade, and the second line gives that of the male student with
     the lowest grade. The third line gives the difference gradeF-gradeM. If one such kind of
     student is missing, output "Absent" in the corresponding line, and output "NA" in the
     third line instead.
     Sample Input 1:
     3
     Joe M Math990112 89
     Mike M CS991301 100
     Mary F EE990830 95
     Sample Output 1:
     Mary EE990830
     Joe Math990112
     6
     Sample Input 2:
     1
     Jean M AA980920 60
     Sample Output 2:
     Absent
     Jean AA980920
     NA
     思路：排序：1.男生比女生大；2.分数小则大。排序后取头尾处理即可
     * */
    public static class BGStudent implements Comparable<BGStudent>{
        String gender;
        String id;
        int grade;
        @Override
        public int compareTo(BGStudent o) {
            if (this.gender.equals(o.gender)) {
                return o.grade - this.grade;
            } else {
                return this.gender.charAt(0) - o.gender.charAt(0);
            }
        }
    }

    /**
     The magic shop in Mars is offering some magic coupons. Each coupon has an integer N printed
     on it, meaning that when you use this coupon with a product, you may get N times the value
     of that product back! What is more, the shop also offers some bonus product for free. However,
     if you apply a coupon with a positive N to this bonus product, you will have to pay the shop
     N times the value of the bonus product... but hey, magically, they have some coupons with
     negative N's!
     For example, given a set of coupons {1 2 4 -1}, and a set of product values {7 6 -2 -3} (in M
     ars dollars M$) where a negative value corresponds to a bonus product. You can apply coupon 3
     (with N being 4) to product 1 (with value M$7) to get M$28 back; coupon 2 to product 2 to get
     M$12 back; and coupon 4 to product 4 to get M$3 back. On the other hand, if you apply coupon 3
     to product 4, you will have to pay M$12 to the shop.
     Each coupon and each product may be selected at most once. Your task is to get as much money
     back as possible.
     Input Specification:
     Each input file contains one test case. For each case, the first line contains the number of
     coupons NC, followed by a line with NC coupon integers. Then the next line contains the number
     of products NP, followed by a line with NP product values. Here 1<= NC, NP <= 105, and it is
     guaranteed that all the numbers will not exceed 230.
     Output Specification:
     For each test case, simply print in a line the maximum amount of money you can get back.
     Sample Input:
     4
     1 2 4 -1
     4
     7 6 -2 -3
     Sample Output:
     43
     思路：将数排序，从大到小相乘，符号不同不相乘。
     * */

    /**
     Given a collection of number segments, you are supposed to recover the smallest number from
     them. For example, given {32, 321, 3214, 0229, 87}, we can recover many numbers such like
     32-321-3214-0229-87 or 0229-32-87-321-3214 with respect to different orders of combinations
     of these segments, and the smallest number is 0229-321-3214-32-87.
     Input Specification:
     Each input file contains one test case. Each case gives a positive integer N (<=10000) followed
     by N number segments. Each segment contains a non-negative integer of no more than 8 digits.
     All the numbers in a line are separated by a space.
     Output Specification:
     For each test case, print the smallest number in one line. Do not output leading zeros.
     Sample Input:
     5 32 321 3214 0229 87
     Sample Output:
     22932132143287
     思路：排序：由最高位比较到最低位，数值小则该数字小，某位没有数值则使用前一位数值比较。
     * */

    /**
     1039. Course List for Student (25)
     Zhejiang University has 40000 students and provides 2500 courses. Now given the student
     name lists of all the courses, you are supposed to output the registered course list for
     each student who comes for a query.
     Input Specification:
     Each input file contains one test case. For each case, the first line contains 2 positive
     integers: N (<=40000), the number of students who look for their course lists, and K (<=2500),
     the total number of courses. Then the student name lists are given for the courses (numbered
     from 1 to K) in the following format: for each course i, first the course index i and the
     number of registered students Ni (<= 200) are given in a line. Then in the next line, Ni
     student names are given. A student name consists of 3 capital English letters plus a one-digit
     number. Finally the last line contains the N names of students who come for a query. All the
     names and numbers in a line are separated by a space.
     Output Specification:
     For each test case, print your results in N lines. Each line corresponds to one student,
     in the following format: first print the student's name, then the total number of registered
     courses of that student, and finally the indices of the courses in increasing order. The query
     results must be printed in the same order as input. All the data in a line must be separated
     by a space, with no extra space at the end of the line.
     Sample Input:
     11 5
     4 7
     BOB5 DON2 FRA8 JAY9 KAT3 LOR6 ZOE1
     1 4
     ANN0 BOB5 JAY9 LOR6
     2 7
     ANN0 BOB5 FRA8 JAY9 JOE4 KAT3 LOR6
     3 1
     BOB5
     5 9
     AMY7 ANN0 BOB5 DON2 FRA8 JAY9 KAT3 LOR6 ZOE1
     ZOE1 ANN0 BOB5 JOE4 JAY9 FRA8 DON2 AMY7 KAT3 LOR6 NON9
     Sample Output:
     ZOE1 2 4 5
     ANN0 3 1 2 5
     BOB5 5 1 2 3 4 5
     JOE4 1 2
     JAY9 4 1 2 4 5
     FRA8 3 2 4 5
     DON2 2 4 5
     AMY7 1 5
     KAT3 3 2 4 5
     LOR6 4 1 2 4 5
     NON9 0
     思路：使用map存储
     * */

    /**
     Given a string, you are supposed to output the length of the longest symmetric sub-string.
     For example, given "Is PAT&TAP symmetric?", the longest symmetric sub-string is "s PAT&TAP s",
     hence you must output 11.
     Input Specification:
     Each input file contains one test case which gives a non-empty string of length no more than 1000.
     Output Specification:
     For each test case, simply print the maximum length in a line.
     Sample Input:
     Is PAT&TAP symmetric?
     Sample Output:
     11
     思路：记录一个最大值，记录一个当前位置最大值，O(n)
     结果：有一种情况：abcbcba 答案不对，算法还是有问题。网上还是靠枚举中心点来找最长，O(n2)
     * */
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String s = scanner.nextLine();
//        char[] cs = s.toCharArray();
//        if (cs.length == 1) System.out.println(1);
//        else {
//            int max = 1;
//            int tempI = 0, tempJ = 0;
//            for (int i = 1; i < cs.length; i++){
//                if (tempI-1>=0&&cs[i]==cs[tempI-1]) {
//                    tempJ = i;
//                    tempI--;
//                } else if (cs[i]==cs[tempJ]) {
//                    tempI = tempJ;
//                    tempJ = i;
//                } else {
//                    tempI = tempJ = i;
//                }
//                if (tempJ-tempI+1 > max) {
//                    max = tempJ - tempI + 1;
//                }
//            }
//            System.out.println(max);
//        }
//    }

    /**
     1041. Be Unique (20)
     Being unique is so important to people on Mars that even their lottery is designed in a unique way.
     The rule of winning is simple: one bets on a number chosen from [1, 104]. The first one who bets
     on a unique number wins. For example, if there are 7 people betting on 5 31 5 88 67 88 17, then
     the second one who bets on 31 wins.
     Input Specification:
     Each input file contains one test case. Each case contains a line which begins with a positive
     integer N (<=105) and then followed by N bets. The numbers are separated by a space.
     Output Specification:
     For each test case, print the winning number in a line. If there is no winner, print "None" instead.
     Sample Input 1:
     7 5 31 5 88 67 88 17
     Sample Output 1:
     31
     Sample Input 2:
     5 888 666 666 888 888
     Sample Output 2:
     None
     思路：？？？todo
     * */
//    public static void main(String[] s) {
//        Scanner scanner = new Scanner(System.in);
//        int sum = scanner.nextInt();
//        Set<Integer> set = new HashSet<>();
//        int[] is = new int[sum];
//        for (int i = 0; i < sum; i++){
//            is[i] = scanner.nextInt();
//            set.add(is[i]);
//        }
//        for (int i: is) {
//
//        }
//    }

    /**
     1042. Shuffling Machine (20)
     Shuffling is a procedure used to randomize a deck of playing cards. Because standard shuffling
     techniques are seen as weak, and in order to avoid "inside jobs" where employees collaborate with
     gamblers by performing inadequate shuffles, many casinos employ automatic shuffling machines. Your
     task is to simulate a shuffling machine.
     The machine shuffles a deck of 54 cards according to a given random order and repeats for a given
     number of times. It is assumed that the initial status of a card deck is in the following order:
     S1, S2, ..., S13, H1, H2, ..., H13, C1, C2, ..., C13, D1, D2, ..., D13, J1, J2
     where "S" stands for "Spade", "H" for "Heart", "C" for "Club", "D" for "Diamond", and "J" for "Joker".
     A given order is a permutation of distinct integers in [1, 54]. If the number at the i-th position
     is j, it means to move the card from position i to position j. For example, suppose we only have 5
     cards: S3, H5, C1, D13 and J2. Given a shuffling order {4, 2, 5, 3, 1}, the result will be: J2, H5,
     D13, S3, C1. If we are to repeat the shuffling again, the result will be: C1, H5, S3, J2, D13.
     Input Specification:
     Each input file contains one test case. For each case, the first line contains a positive integer
     K (<= 20) which is the number of repeat times. Then the next line contains the given order. All the
     numbers in a line are separated by a space.
     Output Specification:
     For each test case, print the shuffling results in one line. All the cards are separated by a space,
     and there must be no extra space at the end of the line.
     Sample Input:
     2
     36 52 37 38 3 39 40 53 54 41 11 12 13 42 43 44 2 4 23 24 25 26 27 6 7 8 48 49 50 51 9 10 14 15 16 5 17 18 19 1 20 21 22 28 29 30 31 32 33 34 35 45 46 47
     Sample Output:
     S7 C11 C10 C12 S1 H7 H8 H9 D8 D9 S11 S12 S13 D10 D11 D12 S3 S4 S6 S10 H1 H2 C13 D2 D3 D4 H6 H3 D13 J1 J2 C1 C2 C3 C4 D1 S5 H5 H11 H12 C6 C7 C8 C9 S2 S8 S9 H10 D5 D6 D7 H4 H13 C5
     思路：两个数组存卡牌，按照题目所给步骤操作即可
     * */

    /**
     1043. Is It a Binary Search Tree (25)
     A Binary Search Tree (BST) is recursively defined as a binary tree which has the following properties:
     The left subtree of a node contains only nodes with keys less than the node's key.
     The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
     Both the left and right subtrees must also be binary search trees.
     If we swap the left and right subtrees of every node, then the resulting tree is called the Mirror
     Image of a BST.
     Now given a sequence of integer keys, you are supposed to tell if it is the preorder traversal
     sequence of a BST or the mirror image of a BST.
     Input Specification:
     Each input file contains one test case. For each case, the first line contains a positive integer
     N (<=1000). Then N integer keys are given in the next line. All the numbers in a line are separated
     by a space.
     Output Specification:
     For each test case, first print in a line "YES" if the sequence is the preorder traversal sequence
     of a BST or the mirror image of a BST, or "NO" if not. Then if the answer is "YES", print in the next
     line the postorder traversal sequence of that tree. All the numbers in a line must be separated by a
     space, and there must be no extra space at the end of the line.
     Sample Input 1:
     7
     8 6 5 7 10 8 11
     Sample Output 1:
     YES
     5 7 6 8 11 10 8
     Sample Input 2:
     7
     8 10 11 8 6 7 5
     Sample Output 2:
     YES
     11 8 10 7 5 6 8
     Sample Input 3:
     7
     8 6 8 5 10 9 11
     Sample Output 3:
     NO
     思路：1.第一位必为根；2.子树必然比根大或比根小；3.子树处理同理；4判断并同时重建二叉树；5.后序遍历
     * */

    /**
     1044. Shopping in Mars (25)
     Shopping in Mars is quite a different experience. The Mars people pay by chained diamonds.
     Each diamond has a value (in Mars dollars M$). When making the payment, the chain can be cut
     at any position for only once and some of the diamonds are taken off the chain one by one. Once
     a diamond is off the chain, it cannot be taken back. For example, if we have a chain of 8 diamonds
     with values M$3, 2, 1, 5, 4, 6, 8, 7, and we must pay M$15. We may have 3 options:
     1. Cut the chain between 4 and 6, and take off the diamonds from the position 1 to 5 (with values
     3+2+1+5+4=15).
     2. Cut before 5 or after 6, and take off the diamonds from the position 4 to 6 (with values 5+4+6=15).
     3. Cut before 8, and take off the diamonds from the position 7 to 8 (with values 8+7=15).
     Now given the chain of diamond values and the amount that a customer has to pay, you are supposed to
     list all the paying options for the customer.
     If it is impossible to pay the exact amount, you must suggest solutions with minimum lost.
     Input Specification:
     Each input file contains one test case. For each case, the first line contains 2 numbers: N (<=105),
     the total number of diamonds on the chain, and M (<=108), the amount that the customer has to pay.
     Then the next line contains N positive numbers D1 ... DN (Di<=103 for all i=1, ..., N) which are the
     values of the diamonds. All the numbers in a line are separated by a space.
     Output Specification:
     For each test case, print "i-j" in a line for each pair of i <= j such that Di + ... + Dj = M. Note
     that if there are more than one solution, all the solutions must be printed in increasing order of i.
     If there is no solution, output "i-j" for pairs of i <= j such that Di + ... + Dj > M with (Di + ...
     + Dj - M) minimized. Again all the solutions must be printed in increasing order of i.
     It is guaranteed that the total value of diamonds is sufficient to pay the given amount.
     Sample Input 1:
     16 15
     3 2 1 5 4 6 8 7 16 10 15 11 9 12 14 13
     Sample Output 1:
     1-5
     4-6
     7-8
     11-11
     Sample Input 2:
     5 13
     2 4 5 7 9
     Sample Output 2:
     2-4
     4-5
     思路：1.满足要求的最小值以及相应取法；2.满足要求的临时最小值及取法。(动态规划？)
     结果：运行超时...得用c++写才行了。。。
     * */
//    public static void main(String[] a) {
//        Scanner scanner = new Scanner(System.in);
//        int amount = scanner.nextInt();
//        int N = scanner.nextInt();
//        int[] ds = new int[amount];
//        int tempI = 0, tempJ = 0;
//        int min = 128;
//        int tempsum = 0;
//        List<String> result = new ArrayList<>();
//        for (int i = 0; i < amount; i++) {
//            ds[i] = scanner.nextInt();
//            tempJ = i;
//            tempsum = sum(ds, tempI, tempJ);
//            while (tempsum > N) {
//                tempsum = sum(ds, tempI + 1, tempJ);
//            }
//            if (tempsum >= N) {
//                if (tempsum < min) {
//                    result.clear();
//                    result.add(""+(tempI+1)+"-"+(tempJ+1));
//                    //System.out.println("1:"+(tempI+1)+"-"+(tempJ+1));
//                    min = tempsum;
//                } else if (tempsum==min) {
//                    //System.out.println("2:"+(tempI+1)+"-"+(tempJ+1));
//                    result.add(""+(tempI+1)+"-"+(tempJ+1));
//                }
//            }
//        }
//        for (String s: result) {
//            System.out.println(s);
//        }
//    }
    public static int sum(int[] is, int i, int j) {
        int sum = 0;
        //System.out.println("1:"+(i+1)+"-"+(j+1));
        for (;i <= j; i++) {
            sum += is[i];
        }
        return sum;
    }

    /**
     1045. Favorite Color Stripe (30)
     Eva is trying to make her own color stripe out of a given one. She would like to keep only her
     favorite colors in her favorite order by cutting off those unwanted pieces and sewing the remaining
     parts together to form her favorite color stripe.
     It is said that a normal human eye can distinguish about less than 200 different colors, so Eva's
     favorite colors are limited. However the original stripe could be very long, and Eva would like to
     have the remaining favorite stripe with the maximum length. So she needs your help to find her the
     best result.
     Note that the solution might not be unique, but you only have to tell her the maximum length. For
     example, given a stripe of colors {2 2 4 1 5 5 6 3 1 1 5 6}. If Eva's favorite colors are given in
     her favorite order as {2 3 1 5 6}, then she has 4 possible best solutions {2 2 1 1 1 5 6},
     {2 2 1 5 5 5 6}, {2 2 1 5 5 6 6}, and {2 2 3 1 1 5 6}.
     Input Specification:
     Each input file contains one test case. For each case, the first line contains a positive integer
     N (<=200) which is the total number of colors involved (and hence the colors are numbered from 1
     to N). Then the next line starts with a positive integer M (<=200) followed by M Eva's favorite
     color numbers given in her favorite order. Finally the third line starts with a positive integer
     L (<=10000) which is the length of the given stripe, followed by L colors on the stripe. All the
     numbers in a line are separated by a space.
     Output Specification:
     For each test case, simply print in a line the maximum length of Eva's favorite stripe.
     Sample Input:
     6
     5 2 3 1 5 6
     12 2 2 4 1 5 5 6 3 1 1 5 6
     Sample Output:
     7
     思路：动态规划!!!
     结果：两个测试点运行超时...算法应该没问题...
     * */
//    public static void main(String[] s) {
//        Scanner scanner = new Scanner(System.in);
//        int N = scanner.nextInt();
//        int M = scanner.nextInt();
//        int[] stripe = new int[M];
//        for (int i = 0; i < M; i++) {
//            stripe[i] = scanner.nextInt();
//        }
//        int L = scanner.nextInt();
//        //int[] color = new int[L];
//        int max[][] = new int[M+1][L+1];
//        for (int i = 0; i < L; i++) {
//            int c = scanner.nextInt();
//            c = c<=N?c:N;
//            for (int j = 0; j < M; j++) {
//                if (c==stripe[j]) {
//                    max[j+1][i+1] = Math.max(max[j][i+1],max[j+1][i])+1;
//                } else {
//                    max[j+1][i+1] = Math.max(max[j][i+1],max[j+1][i]);
//                }
//            }
//        }
//        System.out.println(max[M][L]);
//    }

    /**
     1046 todo
     * */

    /**
     1047. Student List for Course (25)
     Zhejiang University has 40000 students and provides 2500 courses. Now given the registered
     course list of each student, you are supposed to output the student name lists of all the courses.
     Input Specification:
     Each input file contains one test case. For each case, the first line contains 2 numbers: N
     (<=40000), the total number of students, and K (<=2500), the total number of courses. Then N
     lines follow, each contains a student's name (3 capital English letters plus a one-digit number),
     a positive number C (<=20) which is the number of courses that this student has registered, and
     then followed by C course numbers. For the sake of simplicity, the courses are numbered from 1 to K.
     Output Specification:
     For each test case, print the student name lists of all the courses in increasing order of the
     course numbers. For each course, first print in one line the course number and the number of
     registered students, separated by a space. Then output the students' names in alphabetical order.
     Each name occupies a line.
     Sample Input:
     10 5
     ZOE1 2 4 5
     ANN0 3 5 2 1
     BOB5 5 3 4 2 1 5
     JOE4 1 2
     JAY9 4 1 2 5 4
     FRA8 3 4 2 5
     DON2 2 4 5
     AMY7 1 5
     KAT3 3 5 4 2
     LOR6 4 2 4 1 5
     Sample Output:
     1 4
     ANN0
     BOB5
     JAY9
     LOR6
     2 7
     ANN0
     BOB5
     FRA8
     JAY9
     JOE4
     KAT3
     LOR6
     3 1
     BOB5
     4 7
     BOB5
     DON2
     FRA8
     JAY9
     KAT3
     LOR6
     ZOE1
     5 9
     AMY7
     ANN0
     BOB5
     DON2
     FRA8
     JAY9
     KAT3
     LOR6
     ZOE1
     思路：用map来存储
     * */

    /**
     1048. Find Coins (25)
     Eva loves to collect coins from all over the universe, including some other planets like Mars.
     One day she visited a universal shopping mall which could accept all kinds of coins as payments.
     However, there was a special requirement of the payment: for each bill, she could only use exactly
     two coins to pay the exact amount. Since she has as many as 105 coins with her, she definitely
     needs your help. You are supposed to tell her, for any given amount of money, whether or not she
     can find two coins to pay for it.
     Input Specification:
     Each input file contains one test case. For each case, the first line contains 2 positive numbers:
     N (<=105, the total number of coins) and M(<=103, the amount of money Eva has to pay). The second
     line contains N face values of the coins, which are all positive numbers no more than 500. All the
     numbers in a line are separated by a space.
     Output Specification:
     For each test case, print in one line the two face values V1 and V2 (separated by a space) such
     that V1 + V2 = M and V1 <= V2. If such a solution is not unique, output the one with the smallest
     V1. If there is no solution, output "No Solution" instead.
     Sample Input 1:
     8 15
     1 2 8 7 2 4 11 15
     Sample Output 1:
     4 11
     Sample Input 2:
     7 14
     1 8 7 2 4 11 15
     Sample Output 2:
     No Solution
     思路：1.排序（接受输入同时插入排序，O(n2)）；2.从两边向中间检查是否有满足条件的，O(n)
     思路2：2.接受输入，数组和HasnMap存储，O(n)；2.遍历数组，检查map中有无满足的另一个数及其个数，O(n)。
     注意：结果要满足的条件（加数最小），以及是否有结果（标志）。
     结果：运行超时...
     * */
    public static void main(String s) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] coins = new int[N];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int temp = scanner.nextInt();
            coins[i] = temp;
            if (!map.containsKey(temp)) {
                map.put(temp, 1);
            } else {
                Integer integer = map.get(temp);
                map.put(temp, integer + 1);
            }
        }
        int min = 128, pair;
        boolean flag = false;
        for (int i = 0; i < N; i++) {
            int temp = M - coins[i];
            if (temp!=coins[i]) {

            } else {

            }
        }
    }

    /**
     1049. Counting Ones (30)
     The task is simple: given any positive integer N, you are supposed to count the total number
     of 1's in the decimal form of the integers from 1 to N. For example, given N being 12, there
     are five 1's in 1, 10, 11, and 12.
     Input Specification:
     Each input file contains one test case which gives the positive N (<=230).
     Output Specification:
     For each test case, print the number of 1's in one line.
     Sample Input:
     12
     Sample Output:
     5
     运行超时...
     * */
    public static void main1049(String[] s) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int result = 0;
        for (int i = 1; i <= N; i++) {
            result += countOne(i);
        }
        System.out.println(result);
    }
    public static int countOne(int num) {
        int result = 0;
        while (num > 0){
            if (num%10==1) result++;
            num = num/10;
        }
        return result;
    }

    /**
     Given two strings S1 and S2, S = S1 - S2 is defined to be the remaining string after taking all
     the characters in S2 from S1. Your task is simply to calculate S1 - S2 for any given strings.
     However, it might not be that simple to do it fast.
     Input Specification:
     Each input file contains one test case. Each case consists of two lines which gives S1 and S2,
     respectively. The string lengths of both strings are no more than 104. It is guaranteed that
     all the characters are visible ASCII codes and white space, and a new line character signals
     the end of a string.
     Output Specification:
     For each test case, print S1 - S2 in one line.
     Sample Input:
     They are students.
     aeiou
     Sample Output:
     Thy r stdnts.
     思路：HashSet来检查是否有这些字符。
     * */

}