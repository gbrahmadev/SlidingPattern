package codingInterview.slidingPattern.hard;

import java.util.HashMap;
import java.util.Map;

public class NoRepeatSubstring {
	public static int findLargestNoRepeatSubstring(String input) {
		int maxlen = 0;
		int windowStart = 0;
		Map<Character, Integer> indexMap = new HashMap<>();
		for (int windowEnd = 0; windowEnd < input.length(); windowEnd++) {
			Character endChar = input.charAt(windowEnd);
			if (indexMap.containsKey(endChar)) {
				windowStart = Math.max(windowStart, indexMap.get(endChar)+1);
			}
			indexMap.put(endChar, windowEnd);
			maxlen = Math.max(maxlen, windowEnd - windowStart + 1);
		}
		return maxlen;
	}
	public static void main(String[] args) {
		System.out.println(NoRepeatSubstring.findLargestNoRepeatSubstring("aabccbb"));
		System.out.println(NoRepeatSubstring.findLargestNoRepeatSubstring("abbb"));
		System.out.println(NoRepeatSubstring.findLargestNoRepeatSubstring("abccde"));
	}
}
