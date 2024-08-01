import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;

        // Frequency maps for characters in word1 and word2
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        
        for (char c : word1.toCharArray()) {
            freq1[c - 'a']++;
        }
        
        for (char c : word2.toCharArray()) {
            freq2[c - 'a']++;
        }

        // Check if both words have the same set of unique characters
        for (int i = 0; i < 26; i++) {
            if ((freq1[i] == 0 && freq2[i] != 0) || (freq1[i] != 0 && freq2[i] == 0)) {
                return false;
            }
        }

        // Frequency count maps to compare the frequency of frequencies
        Map<Integer, Integer> freqCount1 = new HashMap<>();
        Map<Integer, Integer> freqCount2 = new HashMap<>();
        
        for (int i = 0; i < 26; i++) {
            if (freq1[i] > 0) {
                freqCount1.put(freq1[i], freqCount1.getOrDefault(freq1[i], 0) + 1);
            }
            if (freq2[i] > 0) {
                freqCount2.put(freq2[i], freqCount2.getOrDefault(freq2[i], 0) + 1);
            }
        }
        
        // Compare frequency count maps
        return freqCount1.equals(freqCount2);
    }
}
