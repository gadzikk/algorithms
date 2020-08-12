package trees.trees_iterative;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

/**
 * Created by gadzik on 09.08.20.
 */
public class SidewaysTravesalOfComplete {
    // https://www.geeksforgeeks.org/sideways-traversal-of-a-complete-binary-tree/
    static class pair {
        int first, second;

        public pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static int size = (int) 1e5;
    static int maxLevel = 0;

    static Vector<Integer>[] tree = new Vector[size + 1];
    static boolean[] vis = new boolean[size + 1];
    static int[] level = new int[size + 1];

    static Vector<Integer>[] nodes = new Vector[size + 1];

    static void addEdge(int a, int b) {
        tree[a].add(b);
        tree[b].add(a);
    }

    static void bfs(int node) {

        Queue<pair> qu = new LinkedList<>();
        qu.add(new pair(node, 0));
        nodes[0].add(node);
        vis[node] = true;
        level[1] = 0;

        while (!qu.isEmpty()) {
            pair p = qu.peek();
            qu.remove();
            vis[p.first] = true;

            for (int child : tree[p.first]) {
                if (!vis[child]) {
                    qu.add(new pair(child, p.first));
                    level[child] = level[p.first] + 1;
                    maxLevel = Math.max(maxLevel, level[child]);
                    nodes[level[child]].add(child);
                }
            }
        }
    }

    static void display() {
        int k = 0, path = 0;
        int condn = (maxLevel) / 2 + 1;
        boolean flag = true;

        while (condn-- > 0) {

            if (flag) {
                int j = nodes[k].size() - 1;
                for (j = 0; j < nodes[k].size() - path; j++) {
                    System.out.print(nodes[k].get(j) + " ");
                }

                k++;

                while (k < maxLevel) {
                    j = nodes[k].size() - 1;
                    System.out.print(nodes[k].get(j - path) + " ");
                    k++;
                }

                j = nodes[k].size() - 1;
                if (k > path) {
                    for (j -= path; j >= 0; j--) {
                        System.out.print(nodes[k].get(j) + " ");
                    }
                }

                maxLevel--;
                k--;
                path++;
                flag = !flag;
            } else {
                int j = nodes[k].size() - 1;
                for (j = 0; j < nodes[k].size() - path; j++) {
                    System.out.print(nodes[k].get(j) + " ");
                }

                maxLevel--;
                k--;

                while (k > path) {
                    int c = nodes[k].size() - 1;
                    System.out.print(nodes[k].get(c - path) + " ");
                    k--;
                }

                j = nodes[k].size() - 1;

                if (k == path) {
                    for (j -= path; j >= 0; j--) {
                        System.out.print(nodes[k].get(j) + " ");
                    }
                }

                path++;
                k++;
                flag = !flag;
            }
        }
    }

    public static void main(String[] args) {

        for (int i = 0; i < tree.length; i++) {
            tree[i] = new Vector<>();
            nodes[i] = new Vector<>();
        }

        for (int i = 1; i <= 5; i++) {
            addEdge(i, 2 * i);
            addEdge(i, 2 * i + 1);
        }

        bfs(1);
        display();
    }
}
