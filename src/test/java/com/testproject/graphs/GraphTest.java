package com.testproject.graphs;

import com.testproject.graphs.impl.GraphImpl;
import com.testproject.graphs.utils.DirectedIndexGraph;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class GraphTest {

    @Test
    public void simpleDirectTestConnected() {
        Graph<String> graph = new GraphImpl<>(true);
        graph.addVertex("1");
        graph.addVertex("2");
        graph.addVertex("3");
        graph.addEdge("1", "2");
        graph.addEdge("2", "3");
        Assert.assertTrue(TestUtils.equals(graph.getPath("1", "3"), Arrays.asList("1", "2", "3")));
        Assert.assertTrue(graph.getPath("3", "1").isEmpty());
    }

    @Test
    public void simpleUndirectTestConnected() {
        Graph<String> graph = new GraphImpl<>(false);
        graph.addVertex("1");
        graph.addVertex("2");
        graph.addVertex("3");
        graph.addEdge("1", "2");
        graph.addEdge("2", "3");
        Assert.assertTrue(TestUtils.equals(graph.getPath("1", "3"), Arrays.asList("1", "2", "3")));
        Assert.assertTrue(TestUtils.equals(graph.getPath("3", "1"), Arrays.asList("1", "2", "3")));
    }
}

