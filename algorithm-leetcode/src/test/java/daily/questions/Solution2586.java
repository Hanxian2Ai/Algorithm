package daily.questions;

class Solution2586 {

    private static final char[] originNums = {'a', 'e', 'i', 'o', 'u'};

    private static final String originStr = "aeiou";

    public int vowelStrings(String[] words, int left, int right) {

        int res = 0;
        // HashSet<Character> set = new HashSet<>();
        // for (char c : origin) {
        //     set.add(c);
        // }

        for (int i = left; i <= right; i++) {
            String word = words[i];
            char a = word.charAt(0);
            char b = word.charAt(word.length() - 1);
            // if (set.contains(a) && set.contains(b)){
            //     res++;
            // }
            if (originStr.indexOf(a) != -1 && originStr.indexOf(b) != -1) {
                res++;
            }
        }
        return res;
    }
}
