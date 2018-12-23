package com.testproject.graphs.utils;

import java.util.*;

public abstract class IndexGraph {
    private final ArrayList<List<Integer>> adjacencyList;

    /**
     * Create new Graph object.
     */
    public IndexGraph() {
        this.adjacencyList = new ArrayList<>();
    }

    public int addVertex() {
        adjacencyList.add(new ArrayList<>());
        return adjacencyList.size() - 1;
    }

    public abstract void addEdge(int firstIndex, int secondIndex);

    protected void addDirectEdge(int firstIndex, int secondIndex) {
        adjacencyList.get(firstIndex).add(secondIndex);
    }

    public List<Integer> getPath(int firstIndex, int secondIndex) {
        checkIndex(firstIndex);
        checkIndex(secondIndex);
        Boolean[] visited = new Boolean[adjacencyList.size()];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }

        Queue<Integer> queue = new ArrayDeque<>(adjacencyList.get(firstIndex));
        List<Integer> path = new LinkedList<>();
        path.add(firstIndex);
        visited[firstIndex] = true;

        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            if (current == secondIndex) {
                path.add(current);
                return path;
            } else if (!visited[current]) {
                visited[current] = true;
                queue.addAll(adjacencyList.get(current));
                path.add(current);
            }
        }

        return Collections.emptyList();
    }



    protected void checkIndex(int index) {
        if (index < 0 || index > adjacencyList.size() - 1) {
            throw new IllegalArgumentException("Invalid index " + index);
        }
    }
}