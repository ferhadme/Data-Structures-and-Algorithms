package com.ferhad;

public class Main {

    public static void main(String[] args) {
//         Testing...

        SkipList<Integer, Double> skipList = new SkipList<>();
        skipList.add(1, 1.0);
        skipList.add(2, 3.0);
        skipList.add(4, 2.0);
        skipList.add(3, 5.0);
        skipList.add(0, 0.5);

        System.out.println(skipList.size()); // 5

        System.out.println(skipList.get(1)); // 1.0

        skipList.remove(2); // removes element with key 2

        System.out.println(skipList.size()); // 4
        System.out.println(skipList.get(3)); // 5.0

    }
}
