class Solution {
    public boolean isValid(String word) {
        if(word.length()<3) return false;
        int vowel=0;
        int consonant=0;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(!((ch>='0' && ch <='9') || (ch>='A' && ch <='Z') || (ch>='a' && ch <='z')))return false;
             if(ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' || ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
                vowel++;
            else if((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z'))
                consonant++;
        }
        return (consonant > 0 && vowel > 0);
    }
}