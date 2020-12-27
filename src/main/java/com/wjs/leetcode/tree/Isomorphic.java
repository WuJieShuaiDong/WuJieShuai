package com.wjs.leetcode.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0
 * @Description: 同构字符串
 * @Author: WuJieShuaiDong
 * @Date: 2020/12/27 4:07 下午
 **/
public class Isomorphic {
    public boolean isOmorphic(String s, String t) {
        Map<Character, Character> s2t = new HashMap<Character, Character>();
        Map<Character, Character> t2s = new HashMap<Character, Character>();
        //两个映射表，第一个映射s--->t;第二个映射t---->s
        //从左向右遍历，为什么要两个映射表？因为s和t是等价的，s要映射t,t也要映射s 比如s = foo, t= bar
        //s中的键有o 对应的是a和r,s满足，t则不满足
        int len = s.length();
        for (int i = 0 ; i < len; ++i) {
            char x = s.charAt(i), y = t.charAt(i);
            if ((s2t.containsKey(x) && s2t.get(x) != y) || t2s.containsKey(y) && t2s.get(y) != x) {
                return false;
            }
            s2t.put(x,y);
            t2s.put(y,x);
        }
        return true;
    }


    /**
     * @param s
     * @param t
     * @return
     * @Description:尝试用一个映射表处理,尝试失败，解决不了比如 s=aa t=ab
     */
    public static boolean isOmorphicY(String s, String t){
        Map<Character, Character> s2t = new HashMap<Character, Character>();
        int len = s.length();
        for (int i = 0 ; i<len; i++) {
            char x = s.charAt(i), y = t.charAt(i);
            if (!s2t.containsKey(x)) {
                s2t.put(x,y);
            } else {
                if (s2t.get(x) != y) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("isOmorphicY: " + isOmorphicY("ab","aa"));
    }

}
