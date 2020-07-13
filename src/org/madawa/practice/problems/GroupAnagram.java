package org.madawa.practice.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap();

        for (String str: strs) {
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            String s = new String(temp);
            if (!map.containsKey(s)) {
                map.put(s, new ArrayList<>());
            }
            map.get(s).add(str);
        }
        List<List<String>> result = new ArrayList<>();

        for (Map.Entry<String, List<String>> entry: map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<String>> result = groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
        for (List<String> group: result) {
            System.out.print("[");
            for (String an: group) {
                System.out.print(an + ", ");
            }
            System.out.print("] ");
        }
    }
}
