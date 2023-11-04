package competition;

import java.util.TreeMap;

class Solution2904 {
    public String shortestBeautifulSubstring(String s, int k) {
        int length = s.length();

        TreeMap<Integer, String> treeMap = new TreeMap<>();

        if (k == 1) {
            for (int i = 0; i < s.length(); i++) {
                if ((s.charAt(i) - '0') == 1) {
                    return "1";
                }
            }
            return "";
        }
        for (int left = 0; left < length - 1; left++) {
            for (int right = left + 1; right < length; right++) {
                String substring = s.substring(left, right + 1);
                if (findK(substring, k)) {
                    if (treeMap.containsKey(substring.length())) {
                        String s1 = treeMap.get(substring.length());
                        String s2 = minStr(s1, substring);
                        treeMap.put(substring.length(), s2);
                    } else {
                        treeMap.put(substring.length(), substring);
                    }
                }
            }
        }
        return treeMap.firstEntry() == null ? "" : treeMap.firstEntry().getValue();
    }

    public boolean findK(String str, int k) {
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            if ((str.charAt(i) - '0') == 1) {
                res++;
            }
        }
        return res == k;
    }

    public String minStr(String a, String b) {
        return a.compareTo(b) < 0 ? a : b;
    }

}