package com.testproject.graphs;

import com.testproject.graphs.utils.DirectedIndexGraph;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class IndexGraphTest {

    @Test
    public void simpleTestDisconnected() {
        DirectedIndexGraph graph = new DirectedIndexGraph();
        graph.addVertex();
        graph.addVertex();
        Assert.assertTrue(graph.getPath(0, 1).isEmpty());
    }

    @Test
    public void simpleTestConnected() {
        DirectedIndexGraph graph = new DirectedIndexGraph();
        graph.addVertex();
        graph.addVertex();
        Assert.assertTrue(TestUtils.equals(graph.getPath(0, 1), Arrays.asList(0, 1)));
    }
}

