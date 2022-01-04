package codingInterview.slidingPattern.hard;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithSameLettersAfterReplacement {
	public static int findLongestSubstringWithSameLettersAfterReplacement(String input) {
		int len =0;
		int windowStart =0;
		Map<Character,Integer> charMap = new HashMap<>();
		for (int windowEnd = 0; windowEnd < input.length(); windowEnd++) {
			char endChar = input.charAt(windowEnd);
			if(charMap.containsKey(endChar))
				windowStart = Math.max(windowStart, charMap.get(endChar)+1);
			charMap.put(endChar, windowEnd);	
			len = Math.max(len, windowEnd-windowStart+1);
			
		}
		return len;
	}
	
	public static void main(String[] args) {
		System.out.println(LongestSubstringWithSameLettersAfterReplacement.findLongestSubstringWithSameLettersAfterReplacement("aabccbb"));
		System.out.println(LongestSubstringWithSameLettersAfterReplacement.findLongestSubstringWithSameLettersAfterReplacement("abbb"));
		System.out.println(LongestSubstringWithSameLettersAfterReplacement.findLongestSubstringWithSameLettersAfterReplacement("abccde"));
	}

}

