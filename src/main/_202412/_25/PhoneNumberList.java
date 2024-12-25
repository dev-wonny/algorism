package main._202412._25;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PhoneNumberList {

    public static void main(String[] args) {
        System.out.println("expect: false, result:" + solution(new String[] {"119", "97674223", "1195524421"}));
        System.out.println("expect: true, result:" + solution(new String[] {"123", "456", "789"}));
        System.out.println("expect: false, result:" + solution(new String[] {"12", "123", "1235", "567", "88"}));
        System.out.println("expect: false, result:" + solution(new String[] {"13", "124", "1245", "567", "88"}));


        //길이로 정렬 후
        String[] data = {"A", "B", "AB", "BC", "C"};

        System.out.println("전: " + Arrays.toString(data));

        Arrays.sort(data);
        System.out.println("후: " + Arrays.toString(data));

        System.out.println("124, 12 startsWith?");
        System.out.println("124".startsWith("12"));
        System.out.println("124, 13 startsWith?");
        System.out.println("124".startsWith("13"));

    }

    public static boolean solution(String[] phoneBook) {
        Set<String> set = new HashSet<>();

        for (String phone : phoneBook) {
            set.add(phone);
        }

        for (String phone : phoneBook) {
            for (int j = 1; j < phone.length(); j++) {
                if (set.contains(phone.substring(0, j))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean solution2(String[] phone_book) {
        // 1. 정렬
        Arrays.sort(phone_book);

        // 2. 정렬 후 인접한 두 문자열만 비교
        for (int i = 0; i < phone_book.length - 1; i++) {
            // 접두사 관계인지 확인
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }

        return true;
    }

    public static boolean solution3(String[] phone_book) {

        //길이로 정렬 후
        System.out.println("전: " + Arrays.toString(phone_book));

        Arrays.sort(phone_book);
        System.out.println("후: " + Arrays.toString(phone_book));

        System.out.println("124, 12 contain?");
        System.out.println("124".contains("12"));
        System.out.println("124, 13 contain?");
        System.out.println("124".contains("13"));


        // 다 비교하는 것뿐
        for (int i = 0; i < phone_book.length; i++) {
            for (int j = i + 1; j < phone_book.length; j++) {
                // 있으면 멈춰보자
                if (phone_book[j].contains(phone_book[i])) {
                    return false;
                }
            }
        }// for end
        return true;
    }// end
}
