package codingInterview.slidingPattern.easy;

public class MaxSumSubArrayOfSizeK {
	public static int findMaxSumSubArrayOfSizeK(int[] input, int subSize) {
		int sum = 0;
		int maxSum = 0;
		for (int i = 0; i < input.length; i++) {
			sum += input[i];
			if (i >= subSize - 1) {
				maxSum = Math.max(maxSum, sum);
				sum -= input[i - subSize + 1];
			}
		}
		return maxSum;
	}

	public static void main(String[] args) {
		int[] input = { 2, 1, 5, 1, 3, 2 };
		System.out.println(MaxSumSubArrayOfSizeK.findMaxSumSubArrayOfSizeK(input, 3));
	}
}
