package ru.geekbrains;

import java.util.ArrayList;
import java.util.List;

public class HomeWorkApp {
    public static void main(String[] args) {
        // treeTest1();
        treeTest2(20);
    }

    private static void treeTest2(int count) {
        List<Tree<Integer>> treeList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            Tree<Integer> tree = new TreeImpl<>();
            generateTree(tree);
            treeList.add(tree);
        }

        int countBalancedTree = 0;
        for (Tree<Integer> tree: treeList) {
            if (tree.isBalanced()) {
                countBalancedTree++;
            }
        }

        double balanced = 1.0 * countBalancedTree / count * 100.0;
        double notBalanced = 100.0 - balanced;
        System.out.printf("Кол-во сбалансированных деревьев: %d\n", countBalancedTree);
        System.out.printf("Несбалансированными являются %3.2f%% деревьев\n", notBalanced);
    }

    private static void generateTree(Tree<Integer> tree) {
        while (tree.getHeight() < 4) {
            int value = (int) ((Math.random() * 50) - 25);
            tree.add(value);
        }
    }

    private static void treeTest1() {
        Tree<Integer> tree = new TreeImpl<>();

        tree.add(60);
        tree.add(50);
        tree.add(66);
        tree.add(40);
        tree.add(55);
        tree.add(70);
        tree.add(31);
        tree.add(45);
        tree.add(42);
        tree.add(43);
        tree.add(69);
        tree.add(67);
        tree.add(68);
        tree.add(81);

        System.out.println(tree.size());
        System.out.println(tree.isBalanced());
        System.out.println(tree.getHeight());
        tree.display();

//        tree.remove(31);
//        tree.remove(42);
        tree.remove(70);
        tree.remove(40);

        tree.display();

//        tree.traverse(Tree.TraversMode.IN_ORDER);
    }
}
