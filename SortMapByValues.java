package com.company;

import java.util.*;

public class Maps {
    public static void main(String[] args) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int[] nums = {41, 80, 20, 17, 10, 50};
        for (int i = 0; i < nums.length; i++) {
            hm.put(i, nums[i]);
        }
        List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(hm.entrySet());
        ValueComparator valueComparator = new ValueComparator();
        Collections.sort(list, valueComparator);

        HashMap<Integer, Integer> hm2 = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> me : list) {
            hm2.put(me.getKey(), me.getValue());
        }

        for (Map.Entry<Integer, Integer> me : hm2.entrySet()) {
            System.out.println(me.getKey() + " " + me.getValue());
        }

/**     Another way of printing it
 Iterator itr = hm.entrySet().iterator();
 while(itr.hasNext()){
 Map.Entry me = (Map.Entry) itr.next();
 System.out.println(me.getKey() + " " + me.getValue());
 }
 **/
    }
}

class ValueComparator implements Comparator<Map.Entry<Integer, Integer>> {

    @Override
    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
        if(o1.getValue() < o2.getValue()) return -1;
        else if(o1.getValue() > o2.getValue()) return 1;
        else return 0;
    }

    @Override
    public Comparator<Map.Entry<Integer, Integer>> reversed() {
        return null;
    }
}
