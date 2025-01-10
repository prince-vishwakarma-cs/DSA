class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] freq = new int[26];
            int[] temp = new int[26];
        for (int i = 0; i < words2.length; i++) {
             Arrays.fill(temp, 0);
            for (int j = 0; j < words2[i].length(); j++) {
                int ci=words2[i].charAt(j) - 'a';
                temp[ci]++;
                freq[ci]=Math.max(temp[ci],freq[ci]);
            }
        }
        List<String> lt = new ArrayList<>();
        for (int i = 0; i < words1.length; i++) {
            Arrays.fill(temp, 0);
            for (int j = 0; j < words1[i].length(); j++) {
                temp[words1[i].charAt(j) - 'a']++;
            }
            int j = 0;
            while (j < 26 && freq[j] <= temp[j])
                j++;
            if (j == 26)
                lt.add(words1[i]);
        }
        return lt;
    }
}