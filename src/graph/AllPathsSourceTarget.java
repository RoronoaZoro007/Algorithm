package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AllPathsSourceTarget {

    List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        traverse(0, graph, new LinkedList<>());
        return result;
    }

    public void traverse(int nowPos, int[][] graph, LinkedList<Integer> path) {
        path.add(nowPos);
        int len = graph.length;
        if (nowPos == len - 1) {
            result.add(new ArrayList<>(path));
            path.removeLast();
            return;
        }
        for (int i = 0; i < graph[nowPos].length; i++) {
            traverse(graph[nowPos][i], graph, path);
        }
        path.removeLast();
    }
}
