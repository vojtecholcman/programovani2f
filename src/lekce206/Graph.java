/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lekce206;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author vojtech.holcman.s
 */
public class Graph<E> {

    public static void main(String[] args) {
        Graph<String> g = new Graph<>(true);

        Node<String> a = g.add("A");
        Node<String> b = g.add("B");
        Node<String> c = g.add("C");
        Node<String> d = g.add("D");
        Node<String> e = g.add("E");

        g.link(a, b);
        g.link(a, c);
        g.link(b, c);
        g.link(b, d);
        g.link(c, d);
        g.link(d, e);
        g.link(e, d);

        for (Node<String> node : g.nodes) {
            System.out.println(node);
        }
    }

    private final boolean oriented;
    private final Set<Node<E>> nodes = new HashSet<>();

    public Graph(boolean oriented) {
        this.oriented = oriented;
    }

    public static class Node<E> {

        private E value;
        private final Set<Node<E>> neighbours = new HashSet<>();

        public Node(E value) {
            this.value = value;
        }

        public void add(Node<E> node) {
            neighbours.add(node);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();

            sb.append(value);
            sb.append(": {");

            for (Node<E> neighbour : neighbours) {
                sb.append(neighbour.value);
                sb.append(", ");
            }

            if (!neighbours.isEmpty()) {
                sb.delete(sb.length() - 2, sb.length());
            }

            sb.append("}");

            return sb.toString();
        }
    }

    public Node<E> add(E value) {
        Node<E> node = new Node<>(value);
        nodes.add(node);
        return node;
    }

    public void link(Node<E> source, Node<E> target) {
        source.add(target);

        if (!oriented) {
            target.add(source);
        }
    }
}
