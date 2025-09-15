class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        int res = 0;
        int wend = 0;

        while (wend < text.length()) {
            if (brokenLetters.indexOf(text.charAt(wend)) != -1) {
                while (wend < text.length() && text.charAt(wend) != ' ') {
                    wend += 1;
                }
            } else if (text.charAt(wend) == ' ' || wend == text.length() - 1) {
                res += 1;
            }
            wend += 1;
        }
        return res;
    }
}