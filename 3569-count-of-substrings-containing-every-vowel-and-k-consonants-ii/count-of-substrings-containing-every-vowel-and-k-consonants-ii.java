class Solution {
    public long countOfSubstrings(String word, int k) {
        int arr[] = new int[26];
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
    
        int left = 0, right = 0;
        int consonants = 0;
        long ans = 0;
        int n = word.length();
        int lastCons = -1;
        
        while (right < n) {
            char ch = word.charAt(right);
            if (vowels.contains(ch)) {
                arr[ch - 'a']++;
            } else {
                consonants++;
            }
            while (consonants > k) {
                char leftChar = word.charAt(left);
                if (vowels.contains(leftChar)) {
                    arr[leftChar - 'a']--;
                } else {
                    lastCons = left;
                    consonants--;
                }
                left++;
            }
            if (consonants == k && arr['a' - 'a'] > 0 && arr['e' - 'a'] > 0 && arr['i' - 'a'] > 0 && arr['o' - 'a'] > 0 && arr['u' - 'a'] > 0) {
                while (vowels.contains(word.charAt(left)) && arr[word.charAt(left) - 'a'] > 1) {
                    arr[word.charAt(left) - 'a']--;
                    left++;
                }
                ans += left - lastCons;
            }
            right++;
        }
        return ans;
    }
}
