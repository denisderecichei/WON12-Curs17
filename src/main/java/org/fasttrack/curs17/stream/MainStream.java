package org.fasttrack.curs17.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MainStream {

    public static void main(String[] args) {
        List<String> poeti = Arrays.asList("Blaga", "Barbu", "Arghezi", "Nichita", "Bacovia", "Blaga");
//        for (int i = 0; i < poeti.size(); i++)
//        for (String poetCurent: poeti)
        //iterator:
//        Iterator<String> iterator = poeti.iterator();
//        while (iterator.hasNext()) {
//            String nr = iterator.next();
//        }
        List<String> poetiCuB = poeti.stream()
                .filter(poet -> poet.contains("B"))
                .filter(poet -> poet.contains("L"))
                .map(poet -> poet + " are litera B")
                .map(String::toUpperCase)
                .skip(1)
                .limit(1)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(poetiCuB);

        System.out.println(poeti.stream().count());

        System.out.println(
                poeti.stream()
                        .allMatch(poet -> poet.contains("a"))
        );

        Optional<String> primulPoetCuB = poeti.stream()
                .filter(poet -> poet.startsWith("B"))
                .findAny();
        if (primulPoetCuB.isPresent()) {
            String prmiul = primulPoetCuB.get();
            System.out.println(prmiul);
        }

        Wine w1 = new Wine(2009, 100);
        Wine w2 = new Wine(2008, 150);
        Wine w3 = new Wine(1600, 10050);
        Wine w4 = new Wine(2021, 10);
        Wine w5 = new Wine(2023, 20000);
        List<Wine> wines = Arrays.asList(w1, w2, w3, w4, w5);
        System.out.println("sorting");
        poeti.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::print);

        System.out.println();
        wines.stream()
                .sorted(Comparator.comparing(Wine::getYear).thenComparing(Wine::getPrice))
                .forEach(wine -> System.out.println(wine));

        OptionalInt average = IntStream.range(1, 100)
                .map(x -> x * 2)
                .max();

        Integer sumOfPrices = wines.stream()
                .map(Wine::getPrice)
                //Stream<Integer> dupa acest pas
                .reduce(0, Integer::sum);
        System.out.println("Average is: " + (sumOfPrices / wines.size()));

        final int minPrice = 20;
//        System.out.println("Average is: " + (sumOfPrices / wines.size()));
        wines.stream()
                //minPrice sa fie final.
                .filter(wine -> wine.getPrice() > minPrice)
                .sorted(Comparator.comparing(Wine::getYear))
                .collect(Collectors.toList());
    }

    //exemplu pt tema
    public List<Wine> returnWinesByYearAscending(List<Wine> wines) {
        return wines.stream()
                .sorted(Comparator.comparing(Wine::getYear))
                .collect(Collectors.toList());
    }

    public List<Wine> returnWinesSortedByYearButWithPriceAbove(List<Wine> wines, int minPrice) {
        return wines.stream()
                //la filter, fiind operatii logice, puteti inlantui orice cu operatori logici precum || sau &&.
                .filter(wine -> wine.getPrice() > minPrice || wine.getPrice() > 100)
                .sorted(Comparator.comparing(Wine::getYear))
                .collect(Collectors.toList());
    }
}
