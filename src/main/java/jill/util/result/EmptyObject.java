package jill.util.result;

import java.util.HashMap;

/**
 * 用于返回空对象
 */
public class EmptyObject extends HashMap {

    public static final EmptyObject EMPTY = new EmptyObject();

    private EmptyObject() {}

}
