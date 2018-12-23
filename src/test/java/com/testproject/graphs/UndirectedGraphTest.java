package com.testproject.graphs;

import com.testproject.graphs.utils.DirectedIndexGraph;
import com.testproject.graphs.utils.UndirectedIndexGraph;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class UndirectedGraphTest {

    @Test
    public void simpleTestConnected() {
        UndirectedIndexGraph graph = new UndirectedIndexGraph();
        graph.addVertex();
        graph.addVertex();
        graph.addVertex();
        graph.addEdge(0,1);
        graph.addEdge(1,2);

        Assert.assertTrue(TestUtils.equals(graph.getPath(0, 2), Arrays.asList(0, 1, 2)));
        Assert.assertTrue(TestUtils.equals(graph.getPath(2, 0), Arrays.asList(0, 1, 2)));
    }
}

