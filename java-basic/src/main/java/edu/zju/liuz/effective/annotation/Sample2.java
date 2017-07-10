package edu.zju.liuz.effective.annotation;

/**
 * Created by Liu.Zheng on 2017/3/27.
 */

public class Sample2 {
    @ExceptionTest(ArrayIndexOutOfBoundsException.class)
    public static void m1() {
        int[] i = new int[1];
        int a = i[3];
    }
}
