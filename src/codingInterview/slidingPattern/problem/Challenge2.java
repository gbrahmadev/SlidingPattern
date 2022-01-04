package codingInterview.slidingPattern.problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Challenge2 {
	public static List<Integer> findListOfPermutation(String input, String pattern) {
		if (input.length() < pattern.length())
			throw new IllegalArgumentException("Pattern Length is more than the input");

		int match = 0, windowStart = 0;
		List<Integer> permList = new ArrayList<>();

		Map<Character, Integer> patternMap = new HashMap<>();

		for (char c : pattern.toCharArray()) {
			patternMap.put(c, patternMap.getOrDefault(c, 0) + 1);
		}

		for (int windowEnd = 0; windowEnd < input.length(); windowEnd++) {
			char rightChar = input.charAt(windowEnd);

			if (patternMap.containsKey(rightChar)) {
				patternMap.put(rightChar, patternMap.get(rightChar) - 1);
				if (patternMap.get(rightChar) == 0)
					match++;

			}

			if (match == patternMap.size()) {
				permList.add(windowStart);
			}

			if (windowEnd >= pattern.length() - 1) {
				char leftchar = input.charAt(windowStart++);
				if (patternMap.containsKey(leftchar)) {
					if (patternMap.get(leftchar) == 0)
						match--;
					patternMap.put(leftchar, patternMap.get(leftchar) + 1);
				}
			}
		}

		return permList;
	}

	public static void main(String[] args) {
		System.out.println(Challenge2.findListOfPermutation("ppqp", "pq"));
	}
}
