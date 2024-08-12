import java.util.ArrayList;
import java.util.Arrays;

public class 서울에서김서방찾기 {

	public static void main(String[] args) {
		서울에서김서방찾기.Solution solution = new 서울에서김서방찾기.Solution();
		String[] arr = {"Jane", "Kim"};
		String result = solution.solution(arr);
		System.out.println(result);

	}
	static class Solution {
		public String solution(String[] seoul) {
			ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(seoul));
			int idx = arrayList.indexOf("Kim");

			StringBuilder sb = new StringBuilder("김서방은 에 있다");
			sb.insert(5, idx);

			return String.valueOf(sb);
		}
	}
}
