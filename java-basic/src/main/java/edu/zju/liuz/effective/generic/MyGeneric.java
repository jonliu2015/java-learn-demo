package edu.zju.liuz.effective.generic;

import java.util.List;

/**
 * Created by Administrator on 2017/3/18.
 */
public class MyGeneric<T> {
    T object;
    T object2;

    public void setObject(Object object) {
        System.err.println(object.getClass().toString());
        this.object = (T) object;
    }

    public void setObject() {
        object = (T) new Integer(111);
    }

    public T getObject() {
        return object;
    }

    public <T> T[] getMoreObj() {
        Object[] objects = new Object[2];
        objects[0] = objects;
        T[] ts = (T[]) objects;
        System.err.println(ts.getClass());
        return ts;
    }

    public void test(List<String> list) {

    }

    @Override
    public String toString() {
        return object.getClass().toString();
    }
}
