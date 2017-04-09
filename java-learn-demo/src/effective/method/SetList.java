package effective.method;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Administrator on 2017/4/2.
 */
public class SetList {
    public static void main(String[] a){
        Set<Integer> set = new TreeSet<>();
        List<Integer> list = new ArrayList<>();

        for(int i = -3; i < 3; i++) {
            set.add(i);
            list.add(i);
        }
        for (int i = 0; i < 3; i++){
            System.out.println(set.remove(i));
            System.out.println(list.remove(Integer.valueOf(i)));
        }
        System.out.print(set + " " + list);
    }
}
