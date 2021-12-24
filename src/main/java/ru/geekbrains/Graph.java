package ru.geekbrains;

import java.util.List;

public interface Graph {

    void addVertex(String name);

    void addEdge(String source, String target, Double weight);

    void computeShortestPaths(String start);

    List<Vertex> getShortestPathTo(String target);
}
