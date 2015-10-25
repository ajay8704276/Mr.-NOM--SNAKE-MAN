package com.ajay.tcs.framework;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ajax on 10/25/2015.
 */
public class Pool<T> {


    private final List<T> freeObjects;
    private PoolObjectFactory<T> factory;
    private final int maxSize;



    public interface PoolObjectFactory<T>{

        public T createObject();
    }


    public Pool(PoolObjectFactory<T> factory, int maxSize) {
        this.factory = (PoolObjectFactory<T>) factory;
        this.maxSize = maxSize;
        this.freeObjects = new ArrayList<T>(maxSize);
    }


    public T newObject() {
        T object = null;
        if (freeObjects.size() == 0)
            object = (T) factory.createObject();
        else
            object = freeObjects.remove(freeObjects.size() - 1);
        return object;
    }

    public void free(T object) {
        if (freeObjects.size() < maxSize)
            freeObjects.add(object);
    }

//    PoolObjectFactory<Input.TouchEvent> factory = new PoolObjectFactory<Input.TouchEvent>() {
//        @Override
//        public Input.TouchEvent createObject() {
//            return new Input.TouchEvent();
//        }
//    };

    Pool<Input.TouchEvent> touchEventPool = new Pool<Input.TouchEvent>((PoolObjectFactory<Input.TouchEvent>) factory, 50);
    Input.TouchEvent touchEvent = touchEventPool.newObject();

           // touchEventPool.free()
}
