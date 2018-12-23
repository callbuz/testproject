package com.testproject.graphs.utils;

public class UndirectedIndexGraph extends IndexGraph {
    @Override
    public void addEdge(int firstIndex, int secondIndex) {
        checkIndex(firstIndex);
        checkIndex(secondIndex);
        addDirectEdge(firstIndex, secondIndex);
        addDirectEdge(secondIndex, firstIndex);
    }
}
