package edu.zju.liuz.effective.third;

/**
 * Created by Administrator on 2017/3/6.
 */
public class SingleTwo {
    private final static SingleTwo INSTANCE = new SingleTwo();

    private SingleTwo() {

    }

    public SingleTwo getInstance() {
        return INSTANCE;
    }
}
