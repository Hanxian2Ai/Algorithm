package daily.questions;

import java.util.HashMap;
import java.util.Map.Entry;

class Solution1410 {

    private static final int size = 6;
    public String entityParser(String text) {
        HashMap<String, String> map = new HashMap<>(size);
        map.put("&quot;", "\"");
        map.put("&apos;", "'");
        map.put("&amp;", "&");
        map.put("&gt;", ">");
        map.put("&lt;", "<");
        map.put("&frasl;", "/");
        for(Entry<String, String> item : map.entrySet()){
            text = text.replace(item.getKey(),item.getValue());
        }
        return text;
    }
}