class Solution {
    public String answerString(String word, int numFriends) {
        if (numFriends == 1) {
            return word;
        }

        String maxP1 = "";
        int wordLen = word.length();

        int maxLength = wordLen - numFriends + 1;

        for (int i = 0; i < wordLen; i++) {
            int endIndex = Math.min(i + maxLength, wordLen);
            
            String temp;
            temp = word.substring(i, endIndex);

            if (temp.compareTo(maxP1) > 0) {
                maxP1 = temp;
            }
        }

        return maxP1;
    }
}