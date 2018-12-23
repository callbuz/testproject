package com.testproject.graphs.impl;

import com.testproject.graphs.Graph;
import com.testproject.graphs.utils.DirectedIndexGraph;
import com.testproject.graphs.utils.IndexGraph;
import com.testproject.graphs.utils.UndirectedIndexGraph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GraphImpl<T> implements Graph<T> {
    private HashMap<T, Integer> vertexes = new HashMap<>();
    private IndexGraph graph;


    public GraphImpl(boolean isDirected) {
        if (isDirected) {
            graph = new DirectedIndexGraph();
        } else {
            graph = new UndirectedIndexGraph();
        }
    }

    @Override
    public void addVertex(T v) {
        if (vertexes.get(v) != null) {
            throw new IllegalArgumentException("Item already exists");
        }
        vertexes.put(v, graph.addVertex());
    }

    /**
     * Add new edge between vertex.
     */
    @Override
    public void addEdge(T first, T second) {
        graph.addEdge(getIndex(first), getIndex(second));
    }

    private Integer getIndex(T elem) {
        Integer elemIndex = vertexes.get(elem);
        if (elemIndex == null) {
            throw new IllegalArgumentException(String.format("Vertex not found %s", elem));
        }
        return elemIndex;
    }

    @Override
    public List<T> getPath(T first, T second) {
        return graph
                .getPath(getIndex(first), getIndex(second))
                .stream()
                .map(this::findByIndex)
                .collect(Collectors.toList());
    }

    private T findByIndex(int index) {
        return vertexes
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue().equals(index))
                .findFirst()
                .map(Map.Entry::getKey)
                .orElseThrow(() -> new IllegalStateException("Element not found with index " + index));
    }
}
