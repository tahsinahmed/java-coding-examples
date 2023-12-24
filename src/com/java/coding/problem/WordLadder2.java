package com.java.coding.problem;

import java.util.*;

public class WordLadder2 {
    public static void main(String[] args) {
        String start = "hit", end = "cog";
        Set<String> dict = new HashSet<>() {{
            add("hot");
            add("dot");
            add("dog");
            add("lot");
            add("log");
        }};

        System.out.println(findLadders(start, end, dict));
    }

    private static List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> result = new ArrayList<>();
        LinkedList<WordNode2> queue = new LinkedList<>();
        queue.add(new WordNode2(start, 1, null));
        dict.add(end);
        int minStep = 0;
        HashSet<String> visited = new HashSet<>();
        HashSet<String> unvisited = new HashSet<>(dict);

        int preNumSteps = 0;
        while (!queue.isEmpty()) {
            WordNode2 top = queue.pop();
            String word = top.word;
            int currNumSteps = top.numSteps;
            if (word.equals(end)) {
                if (minStep == 0)
                    minStep = top.numSteps;
                if (top.numSteps == minStep && minStep != 0) {
                    ArrayList<String> t = new ArrayList<>();
                    t.add(top.word);
                    while (top.pre != null) {
                        t.add(0, top.pre.word);
                        top = top.pre;
                    }
                    result.add(t);
                    continue;
                }
            }

            if (preNumSteps < currNumSteps)
                unvisited.removeAll(visited);

            preNumSteps = currNumSteps;
            char[] arr = word.toCharArray();
            for (int i=0; i<arr.length; i++) {
                for (char c='a'; c<='z'; c++) {
                    char temp = arr[i];
                    if (arr[i] != c)
                        arr[i] = c;
                    String newWord = new String(arr);
                    if (unvisited.contains(newWord)) {
                        queue.add(new WordNode2(newWord, top.numSteps + 1, top));
                        visited.add(newWord);
                    }
                    arr[i] = temp;
                }
            }
        }
        return result;
    }


}

class WordNode2 {
    String word;
    int numSteps;
    WordNode2 pre;

    public WordNode2(String word, int numSteps, WordNode2 pre) {
        this.word = word;
        this.numSteps = numSteps;
        this.pre = pre;
    }
}