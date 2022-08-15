package ir.soroosh;

import ir.soroosh.btree.BTree;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        BTree b = new BTree(false);
        for (int i = 4; i < 1000; i++) {
            b.insert((new Random()).nextInt(0,i));
        }
        System.out.println(b.getSorted());
    }
}
