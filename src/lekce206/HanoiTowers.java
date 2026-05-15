/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lekce206;

import cz.gyarab.util.rmi.client.Connection;
import cz.gyarab.util.teaser.Hanoi;
import cz.gyarab.util.teaser.HanoiAnimator;
import cz.gyarab.util.teaser.HanoiRemote;
import java.io.IOException;
import java.util.Deque;
import java.util.EnumMap;
import java.util.LinkedList;
import java.util.Map;

/**
 *
 * @author vojtech.holcman.s
 */
public class HanoiTowers implements Hanoi {

    private final Map<Place, Deque<Integer>> towers = new EnumMap(Place.class);

    public static void main(String[] args) throws IOException {
        Hanoi ht = new HanoiRemote(new HanoiTowers(), new Connection("192.168.81.19"));
//        Hanoi ht = HanoiAnimator.createAnimator(new HanoiTowers());
        solve(ht, 3);
        ht.done();
        System.in.read();
    }

    private static void solve(Hanoi h, int count) {
        h.setup(count);
        solve(h, count, Place.LEFT, Place.RIGHT, Place.MIDDLE);
        h.done();
    }

    private static void solve(Hanoi h, int count, Place from, Place to, Place temp) {
        if (count > 1) {
            solve(h, count - 1, from, temp, to);
        }
        h.move(from, to);
        if (count > 1) {
            solve(h, count - 1, temp, to, from);
        }
    }

    @Override
    public void setup(int count) throws IllegalArgumentException {
        if (count <= 0) {
            throw new IllegalArgumentException("count should be a positive number");
        }
        for (Place place : Place.values()) {
            towers.put(place, new LinkedList<>());
        }
        for (int i = count; i >= 1; i--) {
            towers.get(Place.LEFT).push(i);
        }
    }

    @Override
    public void move(Place from, Place to) throws IllegalStateException {
        System.out.println(from + " -> " + to);
        if (from == null || to == null || from == to) {
            throw new IllegalArgumentException("invalid move");
        }

        if (towers.get(from).isEmpty()) {
            throw new IllegalArgumentException("the source tower is empty");
        }
        if (!towers.get(to).isEmpty() && towers.get(to).peek() <= towers.get(from).peek()) {
            throw new IllegalArgumentException("this item cannot be moved");
        }
        towers.get(to).push(towers.get(from).pop());
    }

    @Override
    public void done() throws IllegalStateException {
        if (!towers.get(Place.LEFT).isEmpty() || !towers.get(Place.MIDDLE).isEmpty()) {
            throw new IllegalArgumentException("the gameis not completed");
        }
    }

    @Override
    public String toString() {
        return towers.toString();
    }

}
