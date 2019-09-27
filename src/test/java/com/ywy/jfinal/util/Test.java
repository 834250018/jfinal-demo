package com.ywy.jfinal.util;

import java.util.*;

/**
 * @author ve
 * @date 2019/9/27 9:38
 */
public class Test {

    @org.junit.Test
    public void test1() {
        System.out.println(((Object)new ArrayList<>()) );
        System.out.println(new TreeSet<>() instanceof Iterable);
        System.out.println(new LinkedList<>() instanceof Iterable);
        System.out.println();
        Arrays.asList();

    }
}
