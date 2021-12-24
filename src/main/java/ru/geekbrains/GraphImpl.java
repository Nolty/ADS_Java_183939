package ru.geekbrains;

import java.util.*;

public class GraphImpl implements Graph {
    Map<String, Vertex> vertices;
    Map<Vertex, List<Edge>> verticesEdges;

    public GraphImpl() {
        this.vertices = new HashMap<>();
        this.verticesEdges = new HashMap<>();
    }

    @Override
    public void addVertex(String name) {
        Vertex vertex = new Vertex(name);
        vertices.put(name, vertex);
        verticesEdges.put(vertex, new LinkedList<>());
    }

    @Override
    public void addEdge(String source, String target, Double weight) {
        Vertex fromVertex = vertices.get(source);
        Vertex toVertex = vertices.get(target);

        if (fromVertex != null && toVertex != null) {
            verticesEdges.get(fromVertex).add(new Edge(toVertex, weight));
        }
    }

    @Override
    public void computeShortestPaths(String start) {
        Vertex sourceVertex = vertices.get(start);

        if (sourceVertex == null) {
            return;
        }

        reset();

        sourceVertex.setDistance(0.0);
        sourceVertex.setVisited(true);

        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(sourceVertex);

        while (!priorityQueue.isEmpty()) {
            Vertex actualVertex = priorityQueue.poll();

            for (Edge edge : verticesEdges.get(actualVertex)) {

                Vertex v = edge.getTarget();
                if (!v.isVisited()) {
                    double newDistance = actualVertex.getDistance() + edge.getWeight();

                    if (newDistance < v.getDistance()) {
                        priorityQueue.remove(v);
                        v.setDistance(newDistance);
                        v.setParent(actualVertex);
                        priorityQueue.add(v);
                    }
                }
            }
            actualVertex.setVisited(true);
        }
    }

    @Override
    public List<Vertex> getShortestPathTo(String target) {
        List<Vertex> path = new ArrayList<>();
        Vertex targetVertex = vertices.get(target);

        for (Vertex vertex = targetVertex; vertex != null; vertex = vertex.getParent()) {
            path.add(vertex);
        }

        Collections.reverse(path);
        return path;
    }

    private void reset() {
        vertices.values().forEach(value -> {
            value.setVisited(false);
            value.setDistance(Double.MAX_VALUE);
        });
    }
}
