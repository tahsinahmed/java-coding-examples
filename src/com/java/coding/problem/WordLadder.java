package com.java.coding.problem;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        String start = "hit", end = "let";
        String[] dic = {"hot", "dot", "dog", "lot", "log"};
        System.out.println(ladderLength(start, end, new HashSet<>(Set.of(dic))));
    }

    private static int ladderLength(String start, String end, Set<String> dic) {
        LinkedList<WordNode> queue = new LinkedList<>();
        queue.add(new WordNode(start, 1));
        dic.add(end);
        while (!queue.isEmpty()) {
            WordNode top = queue.pop();
            String word = top.word;
            if (word.equals(end))
                return top.numSteps;

            char[] arr = word.toCharArray();
            for (int i=0; i<arr.length; i++) {
                for (char j='a'; j<='z'; j++) {
                    char temp = arr[i];
                    if (arr[i] != j)
                        arr[i] = j;
                    String newString = new String(arr);
                    if (dic.contains(newString)) {
                        queue.add(new WordNode(newString, top.numSteps + 1));
                        System.out.println(newString + (top.numSteps + 1));
                        dic.remove(newString);
                        if (newString.equals(end))
                            return top.numSteps + 1;
                    }
                    arr[i] = temp;
                }
            }
        }
        return 0;
    }

}

class WordNode {
    String word;
    int numSteps;

    public WordNode(String word, int numSteps) {
        this.word = word;
        this.numSteps = numSteps;
    }
}