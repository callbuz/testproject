package com.testproject.graphs.utils;

public class DirectedIndexGraph extends IndexGraph {
    @Override
    public void addEdge(int firstIndex, int secondIndex) {
        checkIndex(firstIndex);
        checkIndex(secondIndex);
        addDirectEdge(firstIndex, secondIndex);
    }
}
