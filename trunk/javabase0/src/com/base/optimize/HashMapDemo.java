package com.base.optimize;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Description HashMapĞÔÄÜ²âÊÔ
 * @author Administrator
 * 2012-9-22
 */
public class HashMapDemo {

    private static Map<String, Integer> map = new HashMap<String, Integer>();

    /**
     *  map.entrySet()
     */
    public static void testEntry() {
        map.put("a", 3);
        map.put("b", 2);
        map.put("c", 1);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 200000; i++) {
            for (Map.Entry en : map.entrySet()) {
                String s = en.getKey() + "";
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    /**
     *  map.keySet()
     */
    public static void testKeySet() {
        map.put("a", 3);
        map.put("b", 2);
        map.put("c", 1);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 200000; i++) {
            Iterator it = map.keySet().iterator();
            while (it.hasNext()) {
                String s = it.next() + "";
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        //testEntry();
        testKeySet();
    } 
}