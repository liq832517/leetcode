package leetcode;

public class StringCollection {
    public static void main(String[] args) {
        StringCollection sc = new StringCollection();
        sc.method("abcqwerAcb");
    }

    public void method(String a) {
        StringBuilder sb = new StringBuilder();
        int[] flags = new int[256];
        for (int i = 0; i < a.length(); i++) {
            if (flags[a.charAt(i)] == 0) {
                sb.append(a.charAt(i));
            }

            flags[a.charAt(i)]++;

        }
        System.out.println(sb.toString());
    }
}
