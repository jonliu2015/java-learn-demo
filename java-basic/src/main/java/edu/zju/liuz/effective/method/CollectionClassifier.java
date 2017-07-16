package edu.zju.liuz.effective.method;

import java.util.*;

/**
 * Created by Liu.Zheng on 2017/4/2.
 */
public class CollectionClassifier {
    public static String classify(Set<?> set) {
        return "set";
    }
    public static String classify(List<?> list) {
        return "list";
    }
    public static String classify(Collection<?> collection) {
        return "collection";
    }
    public static void main(String[] args) {
        Collection<?>[] collections = {
                new HashSet<String>(),
                new ArrayList<String>(),
                new HashMap<String, String>().values()
        };
        for (Collection<?> c: collections) {
            System.out.println(classify(c));
        }

    }
}
