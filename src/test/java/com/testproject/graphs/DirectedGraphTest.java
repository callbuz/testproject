package com.testproject.graphs;

import com.testproject.graphs.utils.DirectedIndexGraph;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class DirectedGraphTest {

    @Test
    public void simpleTestConnected() {
        DirectedIndexGraph graph = new DirectedIndexGraph();
        graph.addVertex();
        graph.addVertex();
        graph.addVertex();
        graph.addEdge(0,1);
        graph.addEdge(1,2);

        Assert.assertTrue(TestUtils.equals(graph.getPath(0, 2), Arrays.asList(0, 1, 2)));
        Assert.assertTrue(graph.getPath(2, 0).isEmpty());
    }

    @Test
    public void selfConnectedTest() {
        DirectedIndexGraph graph = new DirectedIndexGraph();
        graph.addVertex();
        graph.addVertex();
        graph.addVertex();
        graph.addEdge(0,0);
        graph.addEdge(0,1);
        graph.addEdge(1,1);
        graph.addEdge(2,2);

        Assert.assertTrue(graph.getPath(0, 2).isEmpty());
        Assert.assertTrue(graph.getPath(2, 0).isEmpty());
    }

    @Test
    public void circleConnected() {
        DirectedIndexGraph graph = new DirectedIndexGraph();
        graph.addVertex();
        graph.addVertex();
        graph.addVertex();
        graph.addVertex();
        graph.addVertex();
        graph.addVertex();
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(3,0);
        graph.addEdge(3,4);

        Assert.assertTrue(graph.getPath(0, 5).isEmpty());
        Assert.assertTrue(graph.getPath(5, 0).isEmpty());

        Assert.assertTrue(TestUtils.equals(graph.getPath(0, 4), Arrays.asList(0, 1, 2, 3, 4)));
    }

    @Test
    public void fullConnected() {
        DirectedIndexGraph graph = new DirectedIndexGraph();
        int size = 10;
        for (int i = 0; i < size; i++) {
            graph.addVertex();
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                graph.addEdge(i, j);
            }
        }

        Random rn = new Random();
        for (int i = 0; i < 10; i++) {
            Assert.assertTrue(!graph.getPath(rn.nextInt(size), rn.nextInt(size)).isEmpty());
        }
    }
}

