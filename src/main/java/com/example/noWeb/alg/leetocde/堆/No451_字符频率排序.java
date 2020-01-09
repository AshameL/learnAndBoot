package com.example.noWeb.alg.leetocde.堆;

import java.util.HashMap;
import java.util.PriorityQueue;

public class No451_字符频率排序 {
    public String frequencySort(String s) {
        char[] chars = s.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        PriorityQueue<Character> queue = new PriorityQueue<Character>((o2, o1) -> map.get(o1)-map.get(o2));

        for(Character c:chars){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(Character c:map.keySet()){
            queue.add(c);
        }
        StringBuilder res =new StringBuilder();
        while ( !queue.isEmpty()){
            Character c = queue.poll();
            for(int i =0;i<map.get(c);i++){
                res.append(c);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        No451_字符频率排序 n = new No451_字符频率排序();
        String s = "Aabb";
        String res = n.frequencySort(s);
        System.out.println(res);
    }
}
