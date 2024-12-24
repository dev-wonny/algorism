package main._202408;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 조이스틱 {

	//https://school.programmers.co.kr/learn/courses/30/lessons/42860

	public static void main(String[] args) {
		조이스틱.Solution solution = new 조이스틱.Solution();
		int result = solution.solution("JAN");
		System.out.println("result>>>" + result);

	}

	static class Solution {
		// name을 자른다
		// 글자 - 'A' 각각 차이를 계산한다
		// J  E  R   O   E   N
		// 9, 4, 17, 14, 4, 13 == 61 != 56
		// 9, 4, 9, 12, 4, 13 == 51 != 56 + 이동 5
		//ABCDEFGHIJKLM  // NOPQRSTUVWXYZ 26개
		public int solution(String name) {
			String[] arr = name.split("");
			List arrayList = new ArrayList<Integer>();

			for (int i = 0; i < arr.length; i++) {
				int diff = arr[i].charAt(0) - 'A';
				if (diff > 13) {
					diff = arr[i].charAt(0) - 'Z';//[9, 4, -8, -11, 4, 13]
					//음수면 절대값으로 만든 후 +1을 해준다
					diff = diff * -1 + 1;
				}
				arrayList.add(diff);//[9, 4, 9, 12, 4, 13]
			}

			System.out.println(arrayList);

//			int sum = arrayList.stream().mapToInt(Integer::intValue).sum();
			int sum = arrayList.stream().mapToInt(j -> (int) j).sum();  // or Integer::intValue

			int result = sum + (arr.length - 1);
			return result;
		}


	}//class end
}
