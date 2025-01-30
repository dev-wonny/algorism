package main._202401._23;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/dota2-senate/solutions/3483399/simple-diagram-explanation
public class Dota2Senate {
    public static void main(String[] args) {
        System.out.println("expect:Radiant , result:" + predictPartyVictory("RD"));
        System.out.println("expect:Dire , result:" + predictPartyVictory("DR"));
        System.out.println("expect:Dire , result:" + predictPartyVictory("RDD"));
        System.out.println("expect:Radiant , result:" + predictPartyVictory("RRDDD"));
    }

    public static String predictPartyVictory(String senate) {
        char[] charArray = senate.toCharArray();

        Queue<Integer> queueR = new LinkedList<>();
        Queue<Integer> queueD = new LinkedList<>();
        for (int i = 0; i < charArray.length; i++) {

            char cur = charArray[i];
            if (cur == 'R') {
                queueR.add(i);
            } else {
                queueD.add(i);
            }
        }

        int addNum = charArray.length;

        while (!queueR.isEmpty() && !queueD.isEmpty()) {
            if (queueR.poll() < queueD.poll()) {
                queueR.add(addNum);
            } else {
                queueD.add(addNum);
            }
            addNum++;
        }

        return queueR.size() > queueD.size() ? "Radiant" : "Dire";
    }


    public static String predictPartyVictory2(String senate) {
        char[] charArray = senate.toCharArray();
        HashMap<Character, Integer> hashMap = new HashMap();

        for (char c : charArray) {
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }

        Integer r = hashMap.getOrDefault('R', 0);
        Integer d = hashMap.getOrDefault('D', 0);

        boolean first = charArray[0] == 'R';

        return r - d >= 0 && first ? "Radiant" : "Dire";

    }
}
