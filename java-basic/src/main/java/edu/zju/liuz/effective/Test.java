package edu.zju.liuz.effective;

import edu.zju.liuz.effective.generic.MyGeneric;
import edu.zju.liuz.effective.second.User;
import edu.zju.liuz.effective.third.SingleThree;

/**
 * Created by Liu.Zheng on 2017/3/5.
 * used for test
 */
public class Test {
    public static void main(String[] args) {
        MyGeneric<String> myGeneric = new MyGeneric<>();
        //myGeneric.test(new ArrayList<>());
        //myGeneric.getMoreObj();

        Object o;
        o = new String("aaa");
        myGeneric.setObject(o);
        System.out.println(myGeneric);
    }

    public static void testSecond() {
        User user = new User.Builder("liuz", 22).build();
        System.out.print(user.toString());
    }

    public static void testThird() {
        SingleThree singleThree = SingleThree.INSTANCE;
        SingleThree singleThree1 = SingleThree.INSTANCE;
        System.out.print(singleThree == singleThree1);
    }
}
