package graphs;

/**
 * Created by gadzik on 17.08.20.
 */
public class FindAllPosibleWords2 {
    // https://www.geeksforgeeks.org/boggle-set-2-using-trie/
    // Alphabet size
    static final int SIZE = 26;

    static final int M = 3;
    static final int N = 3;

    static class TrieNode {
        TrieNode[] Child = new TrieNode[SIZE];

        boolean leaf;

        public TrieNode() {
            leaf = false;
            for (int i = 0; i < SIZE; i++) {
                Child[i] = null;
            }
        }
    }

    static void insert(TrieNode root, String Key) {
        int n = Key.length();
        TrieNode pChild = root;

        for (int i = 0; i < n; i++) {
            int index = Key.charAt(i) - 'A';

            if (pChild.Child[index] == null) {
                pChild.Child[index] = new TrieNode();
            }

            pChild = pChild.Child[index];
        }

        pChild.leaf = true;
    }

    static boolean isSafe(int row, int col, boolean visited[][]) {
        return (row >= 0 && row < M && col >= 0 && col < N && !visited[row][col]);
    }

    static void searchWord(TrieNode root, char boggle[][], int row, int col, boolean visited[][], String str) {
        if (root.leaf == true) {
            System.out.println(str);
        }

        if (isSafe(row, col, visited)) {
            visited[row][col] = true;

            // traverse all child of current root
            for (int K = 0; K < SIZE; K++) {
                if (root.Child[K] != null) {
                    char ch = (char) (K + 'A');

                    if (isSafe(row + 1, col + 1, visited) && boggle[row + 1][col + 1] == ch) {
                        searchWord(root.Child[K], boggle, row + 1, col + 1, visited, str + ch);
                    }
                    if (isSafe(row, col + 1, visited) && boggle[row][col + 1] == ch) {
                        searchWord(root.Child[K], boggle, row, col + 1, visited, str + ch);
                    }
                    if (isSafe(row - 1, col + 1, visited) && boggle[row - 1][col + 1] == ch) {
                        searchWord(root.Child[K], boggle, row - 1, col + 1, visited, str + ch);
                    }
                    if (isSafe(row + 1, col, visited) && boggle[row + 1][col] == ch) {
                        searchWord(root.Child[K], boggle, row + 1, col, visited, str + ch);
                    }
                    if (isSafe(row + 1, col - 1, visited) && boggle[row + 1][col - 1] == ch) {
                        searchWord(root.Child[K], boggle, row + 1, col - 1, visited, str + ch);
                    }
                    if (isSafe(row, col - 1, visited) && boggle[row][col - 1] == ch) {
                        searchWord(root.Child[K], boggle, row, col - 1, visited, str + ch);
                    }
                    if (isSafe(row - 1, col - 1, visited) && boggle[row - 1][col - 1] == ch) {
                        searchWord(root.Child[K], boggle, row - 1, col - 1, visited, str + ch);
                    }
                    if (isSafe(row - 1, col, visited) && boggle[row - 1][col] == ch) {
                        searchWord(root.Child[K], boggle, row - 1, col, visited, str + ch);
                    }
                }
            }

            // make current element unvisited
            visited[row][col] = false;
        }
    }

    // Prints all words present in dictionary.
    static void findWords(char boggle[][], TrieNode root) {
        // Mark all characters as not visited
        boolean[][] visited = new boolean[M][N];
        TrieNode pChild = root;

        String str = "";

        for (int row = 0; row < M; row++) {
            for (int col = 0; col < N; col++) {
                if (pChild.Child[(boggle[row][col]) - 'A'] != null) {
                    str = str + boggle[row][col];
                    searchWord(pChild.Child[(boggle[row][col]) - 'A'], boggle, row, col, visited, str);
                    str = "";
                }
            }
        }
    }

    public static void main(String args[]) {
        String dictionary[] = {"GEEKS", "FOR", "QUIZ", "GEE"};
        TrieNode root = new TrieNode();

        int n = dictionary.length;
        for (int i = 0; i < n; i++) {
            insert(root, dictionary[i]);
        }

        char boggle[][] = {
                {'G', 'I', 'Z'},
                {'U', 'E', 'K'},
                {'Q', 'S', 'E'}
        };

        findWords(boggle, root);
    }
}
