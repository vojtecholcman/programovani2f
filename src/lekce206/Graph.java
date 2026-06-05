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
        Graph<String> g = new Graph<>();
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
        System.out.println(a);
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
            return String.valueOf(value) + ": {" + neighbours.toString() + "}";
        }
    }
    private final Set<Node> nodes = new HashSet<>();

    public Node<E> add(E value) {
        Node<E> node = new Node(value);
        nodes.add(node);
        return node;
    }

    public void link(Node<E> source, Node<E> target) {
        source.add(target);
    }

}
