package codingInterview.slidingPattern.problem;

import java.util.HashMap;
import java.util.Map;

public class Challenge1 {
	public static boolean findPermutation(String input, String pattern) {
		if (pattern.length() > input.length())
			throw new IllegalArgumentException("Pattern Length is more than the input");

		Map<Character, Integer> patternMap = new HashMap<>();
		int match = 0, windowStart = 0;
		for (char c : pattern.toCharArray()) {
			patternMap.put(c, patternMap.getOrDefault(c, 0) + 1);
		}

		for (int windowEnd = 0; windowEnd < input.length(); windowEnd++) {

			char endChar = input.charAt(windowEnd);
			if (patternMap.containsKey(endChar)) {
				patternMap.put(endChar, patternMap.get(endChar) - 1);
				if (patternMap.get(endChar) == 0)
					match++;
			}

			if (match == patternMap.size()) {
				return true;
			}

			if (windowEnd >= pattern.length() - 1) {
				char startChar = input.charAt(windowStart++);
				if (patternMap.containsKey(startChar)) {
					if (patternMap.get(startChar) == 0)
						match--;
					patternMap.put(startChar, patternMap.get(startChar) + 1);
				}
			}
		}
		return false;

	}

	public static void main(String[] args) {
		System.out.println(Challenge1.findPermutation("oidbcaf", "abc"));
		System.out.println(Challenge1.findPermutation("odicf", "dc"));
		System.out.println(Challenge1.findPermutation("bcdxabcdy", "bcdyabcdx"));
		System.out.println(Challenge1.findPermutation("aaacb", "abc"));
		System.out.println(Challenge1.findPermutation("", ""));
	}
}
