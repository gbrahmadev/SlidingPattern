package codingInterview.slidingPattern.easy;

public class SmallestSubarrayWithAGivenSum {
	public static int findSmallestSubarrayWithAGivenSum(int[] input, int s) {
		int windowStart = 0, len = Integer.MAX_VALUE, windowSum = 0;

		for (int windowEnd = 0; windowEnd < input.length; windowEnd++) {
			windowSum += input[windowEnd];
			while (windowSum >= s) {
				len = Math.min(len, windowEnd - windowStart + 1);
				windowSum -= input[windowStart++];

			}
		}
		return len == Integer.MAX_VALUE ? 0 : len;
	}

	public static void main(String[] args) {
		int[] input = {3,4,1,1,6};
		System.out.println(SmallestSubarrayWithAGivenSum.findSmallestSubarrayWithAGivenSum(input, 8));
	}
}
