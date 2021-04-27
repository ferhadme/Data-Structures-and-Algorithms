package com.ferhad;

/**
 * Sample Object class for testing sorting of object types
 */
public class Person implements Comparable<Person> {
    private String firstName;
    private int age;

    public Person(String firstName, int age) {
        this.firstName = firstName;
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {
        if (this.firstName.compareTo(o.firstName) > 0) {
            return 1;
        } else if (this.firstName.compareTo(o.firstName) == 0) {
            return 0;
        }
        return -1;
    }

//    @Override
//    public int compareTo(Person o) {
//        if (this.age > o.age) {
//            return 1;
//        } else if (this.age == o.age) {
//            return 0;
//        }
//        return -1;
//    }

    @Override
    public String toString() {
        return this.firstName;
    }
}
