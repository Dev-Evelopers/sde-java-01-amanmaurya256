import java.util.*;

public class Problem1 {
    public static int shortestSubstringLength(String s) {
        if (s == null || s.isEmpty()) return 0;
        Set<Character> distinctSet = new HashSet<>();
        for (char c : s.toCharArray()) {
            distinctSet.add(c);
        }
        int required = distinctSet.size();
        Map<Character, Integer> freq = new HashMap<>();
        int left = 0, minLen = Integer.MAX_VALUE;
        int count = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            freq.put(c, freq.getOrDefault(c, 0) + 1);

            if (freq.get(c) == 1) {
                count++;
            }
            while (count == required) {
                minLen = Math.min(minLen, right - left + 1);

                char leftChar = s.charAt(left);
                freq.put(leftChar, freq.get(leftChar) - 1);
                if (freq.get(leftChar) == 0) {
                    count--;
                }
                left++;
            }
        }
        return minLen;
    }
    public static void main(String[] args) {
        String s = "aabcbcdbca";
        System.out.println("Shortest substring length: " + shortestSubstringLength(s));
    }
}
