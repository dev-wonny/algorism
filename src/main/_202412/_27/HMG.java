package main._202412._27;

public class HMG {
    public static void main(String[] args) {
        String[] commandArr = new String[] {"Hyundai-Motor-Group", "Next-Generation-Vehicle"};
        for (String command : commandArr) {
            String[] arr = command.split("-");
            StringBuilder sb = new StringBuilder();
            for (String a : arr) {
                sb.append(a.charAt(0));
            }
            System.out.println(sb);
        }
    }// end
}