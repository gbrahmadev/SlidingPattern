package codingInterview.slidingPattern.hard;

public class LongestSubarrayWithOnesAfterReplacement {
	public static int findLongestSubarrayWithOnesAfterReplacement(int[] input, int k) {
		int len = 0;
		int coundOfReplacement = 0;
		int windowStart = 0;
		for (int windowEnd = 0; windowEnd < input.length; windowEnd++) {
			if (input[windowEnd] == 0) {
				coundOfReplacement++;
			}
			if (coundOfReplacement > k) {
				if (input[windowStart] == 0) {
					coundOfReplacement--;
				}
				windowStart++;
			}
			len = Math.max(len, windowEnd - windowStart + 1);
		}
		return len;
	}

	public static void main(String[] args) {

		System.out.println(LongestSubarrayWithOnesAfterReplacement
				.findLongestSubarrayWithOnesAfterReplacement(new int[] { 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1 }, 2));

		System.out.println(LongestSubarrayWithOnesAfterReplacement
				.findLongestSubarrayWithOnesAfterReplacement(new int[] { 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1 }, 3));
	}
}
