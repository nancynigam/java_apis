//https://www.tutorialspoint.com/difference-between-comparable-and-comparator-in-java
package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Movies implements Comparable<Movies>{
    private String name;
    private double rating;
    private int year;


    public static void main(String[] args){
        ArrayList<Movies> list = new ArrayList<Movies>();
        list.add(new Movies("Force Awakens", 8.3, 2015));
        list.add(new Movies("Star Wars", 8.7, 1977));
        list.add(new Movies("Empire Strikes Back", 8.8, 1980));
        list.add(new Movies("Return of the Jedi", 8.4, 1983));
        System.out.println("Sorting according to name");
        NameComparator nameComparator = new NameComparator();
        Collections.sort(list,nameComparator);
        for (Movies movie: list)
            System.out.println(movie.getName() + " " +
                    movie.getRating() + " " +
                    movie.getYear());
        System.out.println();
        System.out.println("Sorting according to rating");
        RatingsComparator ratingsComparator = new RatingsComparator();
        Collections.sort(list,ratingsComparator);
        for (Movies movie: list)
            System.out.println(movie.getRating() + " " +
                    movie.getName() + " " +
                    movie.getYear());
        System.out.println();
        System.out.println("Sorting according to year");
        Collections.sort(list);
        for (Movies movie: list)
            System.out.println(movie.getYear() + " " +
                    movie.getRating() + " " +
                    movie.getName()+" ");


    }

    public Movies(String name, double rating, int year) {
        this.name = name;
        this.rating = rating;
        this.year = year;
    }

    public double getRating() {
        return rating;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    @Override
    public int compareTo(Movies o) {
        return this.year - o.year;
    }
}


class RatingsComparator implements Comparator<Movies> {

    @Override
    public int compare(Movies o1, Movies o2) {
        if(o1.getRating()<o2.getRating()) return -1;
        else if(o1.getRating()>o2.getRating()) return 1;
        else return 0;
    }
}

class NameComparator implements Comparator<Movies> {

    @Override
    public int compare(Movies o1, Movies o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
