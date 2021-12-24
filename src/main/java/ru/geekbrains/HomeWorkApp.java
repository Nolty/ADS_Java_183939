package ru.geekbrains;

import java.util.List;

public class HomeWorkApp {
    public static void main(String[] args) {
        searchPath("Москва", "Воронеж");
    }

    @SuppressWarnings("SameParameterValue")
    private static void searchPath(String start, String end) {
        Graph graph = new GraphImpl();

        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Рязань");
        graph.addVertex("Калуга");
        graph.addVertex("Липецк");
        graph.addVertex("Тамбов");
        graph.addVertex("Орел");
        graph.addVertex("Саратов");
        graph.addVertex("Курск");
        graph.addVertex("Воронеж");

        graph.addEdge("Москва", "Тула", 183.0);
        graph.addEdge("Москва", "Рязань", 199.0);
        graph.addEdge("Москва", "Калуга", 181.0);
        graph.addEdge("Тула", "Липецк", 292.0);
        graph.addEdge("Рязань", "Тамбов", 288.0);
        graph.addEdge("Калуга", "Орел", 212.0);
        graph.addEdge("Липецк", "Воронеж", 126.0);
        graph.addEdge("Тамбов", "Саратов", 386.0);
        graph.addEdge("Орел", "Курск", 163.0);
        graph.addEdge("Саратов", "Воронеж", 511.0);
        graph.addEdge("Курск", "Воронеж", 227.0);

        graph.computeShortestPaths(start);
        List<Vertex> path = graph.getShortestPathTo(end);

        for (Vertex vertex : path) {
            if (vertex.getName().equals(end)) {
                System.out.printf("%s (%5.2f км)\n", vertex.getName(), vertex.getDistance());
            } else {
                System.out.printf("%s --> ", vertex.getName());
            }
        }
    }
}
