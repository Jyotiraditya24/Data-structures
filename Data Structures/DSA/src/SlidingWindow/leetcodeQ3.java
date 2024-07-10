package SlidingWindow;

import java.util.HashMap;

public class leetcodeQ3 {
    public static void main(String[] args) {
        int ans = lengthOfLongestSubstring("abcabcbb");
        System.out.println(ans);
    }
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int maxValue = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                // Update maxValue and reset sum
                maxValue = Math.max(maxValue, sum);

                // Move the pointer to the next position of the first occurrence of the current character
                i = map.get(ch);
                map.clear();
                sum = 0;
            } else {
                // Add the character to the map and increment the sum
                map.put(ch, i);
                sum++;
            }
        }

        // Check the final sum for the last substring
        return Math.max(maxValue, sum);
    }
}
