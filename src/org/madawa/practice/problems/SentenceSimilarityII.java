package org.madawa.practice.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class SentenceSimilarityII {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
        if (words1.length != words2.length) {
            return false;
        }
        Map<String, List<String>> graph = new HashMap<>();
        for (List<String> pair : pairs) {
            String s1 = pair.get(0), s2 = pair.get(1);
            graph.putIfAbsent(s1, new ArrayList<>());
            graph.putIfAbsent(s2, new ArrayList<>());
            graph.get(s1).add(s2);
            graph.get(s2).add(s1);
        }

        for (int i = 0; i < words1.length; i++) {
            if (!dfs(graph, new HashSet<>(), words1[i], words2[i])) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(Map<String, List<String>> graph, Set<String> visited, String start, String end) {
        if (start.equals(end)) {
            return true;
        }
        visited.add(start);
        if (!graph.containsKey(start) || !graph.containsKey(end)) {
            return false;
        }

        for (String next : graph.get(start)) {
            if (visited.contains(next)) {
                continue;
            }
            if (dfs(graph, visited, next, end)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String[] words1 = {"this", "summer", "thomas", "get", "actually", "actually", "rich", "and", "possess", "the"
                , "actually", "great", "and", "fine", "vehicle", "every", "morning", "he", "drives", "one", "nice",
                           "car", "around", "one", "great", "city", "to", "have", "single", "super", "excellent",
                           "super", "as", "his", "brunch", "but", "he", "only", "eat", "single", "few", "fine", "food"
                , "as", "some", "fruits", "he", "wants", "to", "eat", "an", "unique", "and", "actually", "healthy",
                           "life"};
        String[] words2 = {"this", "summer", "thomas", "get", "very", "very", "rich", "and", "possess", "the", "very"
                , "fine", "and", "well", "car", "every", "morning", "he", "drives", "a", "fine", "car", "around",
                           "unique", "great", "city", "to", "take", "any", "really", "wonderful", "fruits", "as",
                           "his", "breakfast", "but", "he", "only", "drink", "an", "few", "excellent", "breakfast",
                           "as", "a", "super", "he", "wants", "to", "drink", "the", "some", "and", "extremely",
                           "healthy", "life"};

        String[][] pairs = {{"good", "nice"}, {"good", "excellent"}, {"good", "well"}, {"good", "great"}, {"fine",
                                                                                                           "nice"}, {
            "fine", "excellent"}, {"fine", "well"}, {"fine", "great"}, {"wonderful", "nice"}, {"wonderful",
                                                                                               "excellent"}, {
            "wonderful", "well"}, {"wonderful", "great"}, {"extraordinary", "nice"}, {"extraordinary", "excellent"},
                            {"extraordinary", "well"}, {"extraordinary", "great"}, {"one", "a"}, {"one", "an"}, {"one"
                                    , "unique"}, {"one", "any"}, {"single", "a"}, {"single", "an"}, {"single",
                                                                                                     "unique"}, {
            "single", "any"}, {"the", "a"}, {"the", "an"}, {"the", "unique"}, {"the", "any"}, {"some", "a"}, {"some",
                                                                                                              "an"},
                            {"some", "unique"}, {"some", "any"}, {"car", "vehicle"}, {"car", "automobile"}, {"car",
                                                                                                             "truck"}
                                                                                                             , {"auto"
                                    , "vehicle"}, {"auto", "automobile"}, {"auto", "truck"}, {"wagon", "vehicle"}, {
            "wagon", "automobile"}, {"wagon", "truck"}, {"have", "take"}, {"have", "drink"}, {"eat", "take"}, {"eat",
                                                                                                               "drink"
                            }, {"entertain", "take"}, {"entertain", "drink"}, {"meal", "lunch"}, {"meal", "dinner"},
                            {"meal", "breakfast"}, {"meal", "fruits"}, {"super", "lunch"}, {"super", "dinner"}, {
            "super", "breakfast"}, {"super", "fruits"}, {"food", "lunch"}, {"food", "dinner"}, {"food", "breakfast"},
                            {"food", "fruits"}, {"brunch", "lunch"}, {"brunch", "dinner"}, {"brunch", "breakfast"}, {
            "brunch", "fruits"}, {"own", "have"}, {"own", "possess"}, {"keep", "have"}, {"keep", "possess"}, {"very",
                                                                                                              "super"}, {"very", "actually"}, {"really", "super"}, {"really", "actually"}, {"extremely", "super"}, {"extremely", "actually"}};
        List<List<String>> list = Arrays.stream(pairs).map(Arrays::asList).collect(Collectors.toList());
        System.out.println(new SentenceSimilarityII().areSentencesSimilarTwo(words1, words2, list));
    }
}
