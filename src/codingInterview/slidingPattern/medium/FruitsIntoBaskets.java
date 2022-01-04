package codingInterview.slidingPattern.medium;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBaskets {
	public static int findMaxFruitsIntoBaskets(char[] input) {
		if (null == input || input.length == 0)
			throw new IllegalArgumentException("Invalid input. Please check the input");
		int maxCount = 0;
		Map<Character, Integer> fruitMap = new HashMap<>();
		final int STOP_CONDITION = 2;
		int windowStart = 0;
		for (int windowEnd = 0; windowEnd < input.length; windowEnd++) {
			Character endChar = input[windowEnd];
			fruitMap.put(endChar, fruitMap.getOrDefault(endChar, 0) + 1);
			while (fruitMap.size() > STOP_CONDITION) {
				Character startChar = input[windowStart];
				fruitMap.put(startChar, fruitMap.get(startChar) - 1);
				if (fruitMap.get(startChar) == 0)
					fruitMap.remove(startChar);
				windowStart++;
			}
			maxCount = Math.max(maxCount, windowEnd - windowStart + 1);
		}
		return maxCount;
	}

	public static void main(String[] args) {
		System.out.println(FruitsIntoBaskets.findMaxFruitsIntoBaskets(new char[] { 'A', 'B', 'C', 'A', 'C' }));
		System.out.println(FruitsIntoBaskets.findMaxFruitsIntoBaskets(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }));
		System.out.println(FruitsIntoBaskets.findMaxFruitsIntoBaskets(new char[] {}));
	}
}
