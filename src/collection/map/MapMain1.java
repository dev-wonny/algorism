package collection.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapMain1 {
    public static void main(String[] args) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>HashMap 사용");
        Map<String, Integer> studentMap = new HashMap<>();
        studentMap.put("studentA", 90);
        studentMap.put("studentB", 80);
        studentMap.put("studentC", 80);
        studentMap.put("studentD", 100);
        System.out.println(studentMap);

        System.out.println();
        System.out.println("KeySet 활용");
        for (String key : studentMap.keySet()) {
            System.out.println("key=" + key + ", value=" + studentMap.get(key));
        }

        System.out.println();
        System.out.println("entrySet 활용");
        Set<Map.Entry<String, Integer>> entries = studentMap.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println("key=" + entry.getKey() + ", value=" + entry.getValue());
        }

        System.out.println();
        System.out.println("values 활용");
        Collection<Integer> values = studentMap.values();
        for (Integer var : values) {
            System.out.println("value = " + var);
        }

        // studentMap.iterator();// 왜 안됨? Collector 아니라서

        System.out.println("iterator 사용");
        Set<String> setKey = studentMap.keySet();
        Iterator<String> iterator = setKey.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.println("key=" + key + ", value=" + studentMap.get(key));
        }


        System.out.println();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>linkedHashMap 사용");
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        // 학생 성적 데이터 추가
        linkedHashMap.put("studentA", 90);
        linkedHashMap.put("studentB", 80);
        linkedHashMap.put("studentC", 80);
        linkedHashMap.put("studentD", 100);
        System.out.println(linkedHashMap);

        System.out.println();
        System.out.println("KeySet 활용");
        for (String key : linkedHashMap.keySet()) {
            System.out.println("key=" + key + ", value=" + linkedHashMap.get(key));
        }

        System.out.println();
        System.out.println("entrySet 활용");
        Set<Map.Entry<String, Integer>> entries1 = linkedHashMap.entrySet();
        for (Map.Entry<String, Integer> entry : entries1) {
            System.out.println("key=" + entry.getKey() + ", value=" + entry.getValue());
        }

        System.out.println();
        System.out.println("values 활용");
        Collection<Integer> values1 = linkedHashMap.values();
        for (Integer var : values1) {
            System.out.println("value = " + var);
        }

        // linkedHashMap.iterator();// 왜 안됨? Collector 아니라서


        System.out.println();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>TreeMap 사용");
        Map<String, Integer> treeMap = new TreeMap<>();
        // 학생 성적 데이터 추가
        treeMap.put("studentA", 90);
        treeMap.put("studentB", 80);
        treeMap.put("studentC", 80);
        treeMap.put("studentD", 100);
        System.out.println(treeMap);

        System.out.println();
        System.out.println("KeySet 활용");
        for (String key : treeMap.keySet()) {
            System.out.println("key=" + key + ", value=" + treeMap.get(key));
        }

        System.out.println();
        System.out.println("entrySet 활용");
        Set<Map.Entry<String, Integer>> entries2 = treeMap.entrySet();
        for (Map.Entry<String, Integer> entry : entries2) {
            System.out.println("key=" + entry.getKey() + ", value=" + entry.getValue());
        }

        System.out.println();
        System.out.println("values 활용");
        Collection<Integer> values2 = treeMap.values();
        for (Integer var : values2) {
            System.out.println("value = " + var);
        }
    }
}
