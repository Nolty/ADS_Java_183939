package ru.geekbrains;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomeWorkApp {
    static List<Item> ITEMS = new ArrayList<>();

    public static void main(String[] args) {
        testPow();
        testBag();
    }

    private static void testPow() {
        System.out.println(pow(2, 0));
        System.out.println(pow(2, 1));
        System.out.println(pow(2, 3));
        System.out.println(pow(2, -3));
    }

    private static double pow(double value, int power) {
        if (power == 0) {
          return 1;
        } else if (power == 1) {
            return value;
        } else {
            if (power < 0) {
                value = 1 / value;
                power *= -1;
            }
            return value * pow(value, power - 1);
        }
    }

    private static void testBag() {
        ITEMS.add(new Item("Книга", 1, 600));
        ITEMS.add(new Item("Бинокль", 2, 5_000));
        ITEMS.add(new Item("Аптечка", 4, 1_500));
        ITEMS.add(new Item("Ноутбук", 6, 40_000));
        Bag result = bestBagPriceForCapacity(10);
        System.out.println(result);
    }

    private static <E> Bag bestBagPriceForCapacity(double capacity) {
        if (capacity < 0) return null;
        if (capacity == 0) return new Bag(0, 0);

        double weight = -1;
        double price = -1;
        String newItem = null;
        List<String> previousItems = null;
        for (Item item : ITEMS) {
            Bag previous = bestBagPriceForCapacity(capacity - item.weight);
            if (previous == null) continue;

            double candidateWeight = previous.weight;
            double candidatePrice = previous.price;
            double bestPrice = 0;
            Item candidateItem = null;
            for (Item candidate: ITEMS) {
                if (previous.contains(candidate)) continue;
                if (candidateWeight + candidate.weight <= capacity && bestPrice < candidateWeight + candidate.price) {
                    candidateItem = candidate;
                    bestPrice = candidatePrice + candidate.price;
                }
            }

            if (candidateItem != null && bestPrice > price) {
                price = bestPrice;
                weight = candidateWeight + candidateItem.weight;
                newItem = candidateItem.name;
                previousItems = previous.content;
            }
        }

        Bag bestBag = new Bag(weight, price);
        bestBag.add(previousItems);
        bestBag.add(Collections.singletonList(newItem));
        return bestBag;
    }

    static class Item {
        public String name;
        public double weight;
        public double price;

        public Item(String name, double weight, double price) {
            this.name = name;
            this.weight = weight;
            this.price = price;
        }
    }

    static class Bag {
        private final List<String> content = new ArrayList<>();
        double weight;
        double price;

        public Bag(double weight, double price) {
            this.weight = weight;
            this.price = price;
        }

        public void add(List<String> list) {
            content.addAll(list);
        }

        public boolean contains(Item item) {
            return content.contains(item.name);
        }

        @Override
        public String toString() {
            return "Bag{" +
                    "content=" + content +
                    ", weight=" + weight +
                    ", price=" + price +
                    '}';
        }
    }
}
