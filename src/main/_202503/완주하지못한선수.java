package main._202503;

import java.util.HashMap;
import java.util.Map;

public class 완주하지못한선수 {
    public static void main(String[] args) {
        완주하지못한선수 o = new 완주하지못한선수();
        System.out.println(o.solution(new String[] {"leo", "kiki", "eden"}, new String[] {"eden", "kiki"}));
        System.out.println(o.solution(new String[] {"marina", "josipa", "nikola", "vinko", "filipa"}, new String[] {"josipa", "filipa", "marina", "nikola"}));
        System.out.println(o.solution(new String[] {"mislav", "stanko", "mislav", "ana"}, new String[] {"stanko", "ana", "mislav"}));
    }

    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap();
        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        for (String c : completion) {
            Integer orDefault = map.getOrDefault(c, 0);
            if (orDefault > 1) {
                //숫자를 빼준다
                map.put(c, orDefault - 1);
            } else {
                map.remove(c);
            }

        }
        return map.keySet().stream().findAny().get();
    }
}
