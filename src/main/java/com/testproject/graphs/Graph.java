package com.testproject.graphs;

import java.util.List;

public interface Graph<T> {
    public void addVertex(T v);
    public void addEdge(T first, T second);
    public List<T> getPath(T first, T second);
}
