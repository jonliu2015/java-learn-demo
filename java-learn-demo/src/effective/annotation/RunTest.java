package effective.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Liu.Zheng on 2017/3/27.
 */
public class RunTest {
    public static void main(String[] args) throws Exception{
        int tests = 0;
        int passed = 0;
        Class testClass = Class.forName(Sample2.class.getName());
        for (Method method: testClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(ExceptionTest.class)) {
                tests++;
                try {
                    method.invoke(null);
                } catch (InvocationTargetException e) {
                    System.err.println(method.getName() + e.getCause());
                } catch (Exception e) {
                    System.err.print("sad...");
                }
            }
        }
        System.out.print(tests + ";" + passed);
    }
}
