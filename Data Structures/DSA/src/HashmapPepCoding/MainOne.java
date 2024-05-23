package HashmapPepCoding;


import java.util.HashMap;
import java.util.Set;

public class MainOne {
    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<>();
        map.put("India",4);
        map.put("USA",1);
        map.put("Russia",2);
        System.out.println(map);

        map.put("Japan",5);
        map.put("India",6); // value updates here

        System.out.println(map);
        System.out.println(map.get("India"));
        System.out.println(map.get("Australia"));

        System.out.println(map.containsKey("India"));
        System.out.println(map.containsKey("Australia"));

        Set<String> keys = map.keySet();
        System.out.println(keys);

        for(String key : map.keySet()){
            int valueOfEachKey = map.get(key) + 1;
            map.put(key,valueOfEachKey);
        }
        System.out.println(map);

        System.out.println( highestFrequencyChar("aavvvvccc"));

    }
    public static char  highestFrequencyChar(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxValue = 0;
        char maxChar = '_';
        for (Character ch : str.toCharArray()) {
            if (map.containsKey(ch)) {
                int currentVal = map.get(ch);
                map.put(ch, currentVal + 1);
//    map.compute(ch, (k, v) -> (v == null) ? 1 : v + 1);
            } else {
                map.put(ch, 1);
            }
        }
        for (Character key : map.keySet()) {
            int val = map.get(key);
            if (val > maxValue) {
                maxValue = val;
                maxChar = key;
            }
        }
        return maxChar;
    }

}
