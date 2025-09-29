package stepikAlgo;

import lombok.AllArgsConstructor;

import java.util.*;

public class Tree {

    /*
    реализация алгоритма который обходит дереао и печатает в массив
     A
     / \
    B   C
   / \ / \ \
  D  E F  G H
     */
    @AllArgsConstructor
    public static class Node {
        char value;
        List<Node> children;

        public Node(char value) {
            this.value = value;
            this.children = new ArrayList<>();
        }
    }

    public static void main(String[] args) {

        Node root = new Node('A');
        root.children.add(new Node('B'));
        root.children.add(new Node('C'));
        root.children.add(new Node('D'));

        root.children.get(0).children.add(new Node('E'));
        root.children.get(0).children.add(new Node('F'));
        root.children.get(0).children.add(new Node('G'));

        root.children.get(1).children.add(new Node('H'));
        root.children.get(1).children.add(new Node('I'));

        getNodesBelow(root);

    }

    public static List<Node> getNodesBelow(Node node) {
        List<Node> nodes = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();

        queue.add(node);
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            for (Node child : currentNode.children) {
                nodes.add(child);
                queue.add(child);
            }
        }

        nodes.remove(node);
        nodes.forEach(n -> System.out.println(n.value));// удалить переданный узел из списка
        return nodes;
    }
}

