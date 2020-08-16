package graphs;

import java.util.*;

/**
 * Created by gadzik on 16.08.20.
 */
public class WordLadder2 {
    // https://www.geeksforgeeks.org/word-ladder-set-2-bi-directional-bfs/
    public static class node {
        String word;
        int len;

        public node(String word, int len) {
            this.word = word;
            this.len = len;
        }
    }

    public static boolean isAdj(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
            }
        }
        if (count == 1) {
            return true;
        }
        return false;
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<node> q1 = new LinkedList<>();
        Queue<node> q2 = new LinkedList<>();
        HashMap<String, Integer> vis1 = new HashMap<>();
        HashMap<String, Integer> vis2 = new HashMap<>();

        node start = new node(beginWord, 1);
        node end = new node(endWord, 1);

        vis1.put(beginWord, 1);
        q1.add(start);
        vis2.put(endWord, 1);
        q2.add(end);

        while (q1.size() > 0 && q2.size() > 0) {
            node curr1 = q1.remove();
            node curr2 = q2.remove();

            for (int i = 0; i < wordList.size(); i++) {

                // If any one of them is adjacent to curr1
                // and is not present in vis1
                // then push it in the queue
                if (isAdj(curr1.word, wordList.get(i)) && vis1.containsKey(wordList.get(i)) == false) {

                    node temp = new node(wordList.get(i), curr1.len + 1);
                    q1.add(temp);
                    vis1.put(wordList.get(i), curr1.len + 1);

                    // If temp is the destination node
                    // then return the answer
                    if (temp.word.equals(endWord)) {
                        return temp.len;
                    }

                    // If temp is present in vis2 i.e. distance from
                    // temp and the destination is already calculated
                    if (vis2.containsKey(temp.word)) {
                        return temp.len + vis2.get(temp.word) - 1;
                    }
                }
            }

            // Check all the neighbors of curr2
            for (int i = 0; i < wordList.size(); i++) {
                if (isAdj(curr2.word, wordList.get(i)) && !vis2.containsKey(wordList.get(i))) {
                    node temp = new node(wordList.get(i), curr2.len + 1);
                    q2.add(temp);
                    vis2.put(wordList.get(i), curr2.len + 1);

                    if (temp.word.equals(beginWord)) {
                        return temp.len;
                    }

                    if (vis1.containsKey(temp.word)) {
                        return temp.len + vis1.get(temp.word) - 1;
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String args[]) {
        List<String> wordList = new ArrayList<>();
        wordList.add("poon");
        wordList.add("plee");
        wordList.add("same");
        wordList.add("poie");
        wordList.add("plie");
        wordList.add("poin");
        wordList.add("plea");
        String start = "toon";
        String target = "plea";
        System.out.println(ladderLength(start, target, wordList));
    }
}
