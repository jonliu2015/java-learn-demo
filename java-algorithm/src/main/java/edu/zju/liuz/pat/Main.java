package edu.zju.liuz.pat;

import java.util.Scanner;

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
     * pat a 1010
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
     * 本题容易出错的地方：是在17:00及以后开始服务的客户输出"Sorry"，而不是17:00之前结束服务的输出"Sorry"；
     * 如客户是16:59开始服务，服务时间为2，则输出的应该是17:01，而不是"Sorry"。
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();//window
        int M = scanner.nextInt();//capacity
        int K = scanner.nextInt();//num of people
        int Q = scanner.nextInt();//num of queries
        int[] process = new int[K];
        int[] query = new int[Q];
        String[] result = new String[Q];
        for (int i = 0; i < K; i++) {
            process[i] = scanner.nextInt();
        }
        for (int i = 0; i < Q; i++) {
            query[i] = scanner.nextInt();
        }
        if (K <= N) {
            for (int i = 0; i < Q; i++) {
                int done = process[query[i] - 1];
                result[i] = format(done, process[query[i] - 1]);
            }
        } else {
            int[][] wait = new int[N][M];
            for (int i = 0; i < N; i++) {
                wait[i][0] = process[i];
            }
            if (K <= N * M) {
                int ma = K / N;
                for (int i = 0; i < N; i++) {
                    for (int j = 1; j < ma; j++) {
                        wait[i][j] = wait[i][j - 1] + process[j * N + i];
                    }
                }
                for (int i = 0; i < K - N * (M - 1); i++) {
                    wait[i][M - 1] = wait[i][M - 2] + process[(M - 1) * N + i];
                }
                for (int i = 0; i < Q; i++) {
                    int done = wait[(query[i] - 1)%N][(query[i] - 1)/N];
                    result[i] = format(done, process[query[i] - 1]);
                }
            } else {
                for (int i = 0; i < N; i++) {
                    for (int j = 1; j < M; j++) {
                        wait[i][j] = wait[i][j - 1] + process[j * N + i];
                    }
                }
                int change = N * M;
                for (int i = 0; i < Q; i++) {
                    int done;
                    if (query[i] <= N * M) {
                        done = wait[(query[i] - 1)%N][(query[i] - 1)/N];
                    } else {
                        int q = 0;
                        for (int j = 0; j < query[i] - change; j++) {
                            int min = Integer.MIN_VALUE;
                            for (int k = 0; k < N; k++) {
                                if (wait[k][0] < min) {
                                    min = wait[k][0];
                                    q = k;
                                }
                            }
                            if (M != 1) {
                                for (int m = 0; m < M - 1; m++) {
                                    wait[q][m] = wait[q][m + 1];
                                }
                                wait[q][M - 1] = wait[q][M - 2] + process[change + j];
                            } else {
                                wait[q][0] = wait[q][0] + process[change + j];
                            }
                        }
                        done = wait[q][M - 1];
                        change = query[i];
                    }
                    result[i] = format(done, process[query[i] - 1]);
                }
            }
        }
        for (String s: result) {
            System.out.println(s);
        }
    }
    public static String format(int done, int process) {
        String result;
        int m = done % 60;
        int h = 8 + (done - m)/60;
        h = h>17?17:h;
        int sh = 8 + (done - process)/60;
        if (sh >= 17) result = "Sorry";
        else result = (h>9?String.valueOf(h):"0"+h)+":"+(m>9?String.valueOf(m):"0"+m);
        return result;
    }
}