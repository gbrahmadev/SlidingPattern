package codingInterview.slidingPattern.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKDistinctCharacters {
	public static int findLongestSubstringWithKDistinctCharacters(String input, int k) {
		int uniqLen = 0;
		int windowStart = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (int windowEnd = 0; windowEnd < input.length(); windowEnd++) {
			Character rightChar = input.charAt(windowEnd);
			map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);
			while (map.size() > k) {
				Character leftChar = input.charAt(windowStart);
				map.put(leftChar, map.get(leftChar) - 1);
				if (map.get(leftChar) == 0)
					map.remove(leftChar);
				windowStart++;
			}

			uniqLen = Math.max(uniqLen, windowEnd - windowStart + 1);
		}
		return uniqLen;
	}

	public static void main(String[] args) {
		System.out.println(
				LongestSubstringWithKDistinctCharacters.findLongestSubstringWithKDistinctCharacters("araaci", 2));
		System.out.println(
				LongestSubstringWithKDistinctCharacters.findLongestSubstringWithKDistinctCharacters("araaci", 1));
		System.out.println(
				LongestSubstringWithKDistinctCharacters.findLongestSubstringWithKDistinctCharacters("cbbebi", 3));
	}

}
