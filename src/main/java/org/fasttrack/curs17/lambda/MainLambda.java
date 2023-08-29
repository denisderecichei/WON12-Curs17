package org.fasttrack.curs17.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class MainLambda {

    public static void main(String[] args) throws InterruptedException {
        int notaMihai = 5;
        int notaAntonia = 8;
        Random random = new Random();

//        notaMihai = bonus1P(notaMihai);
//        notaAntonia = bonus2P(notaAntonia);

        // f(x) = x + 1; f(x) = g(x) + ..... // f(x) = f(x-1) + ....
        MyLambda myLambda = (int a) -> a + 1;
        System.out.println(myLambda.increment1(notaMihai));
        System.out.println(myLambda.increment1(notaAntonia));

        //aprovizioneaza cu valori de tip T
        Supplier<Integer> always8 = () -> 8;
        Supplier<Integer> randomGenerator = () -> random.nextInt(100) + 1;
        Supplier<String> stringSupplier = () -> "Hello";
        //evalueaza expresii pe un tip de date si returneaza boolean -> echivalent de if
        Predicate<Integer> isHigherThan50 = a -> a > 50;
        Predicate<String> containsA = a -> a.contains("A");

        //only consumes the files
        Consumer<String> print2Times = stringToBeConsumed -> {
            System.out.println(stringToBeConsumed.length() + " is the length of the string");
            System.out.println(stringToBeConsumed + " is the string itself");
            System.out.println("La revedere!");
        };

        print2Times.accept("Bluza");
        print2Times.accept("Cardigan");

        System.out.println("-----------");
        System.out.println(containsA.test("Alina"));
        System.out.println(containsA.test("BAu"));
        System.out.println(containsA.test("TEST123"));
        System.out.println("-----------");

        Function<Integer, Integer> noBonus = notaMea -> notaMea;
        Function<Integer, Integer> punctBonus = notaMea -> notaMea + 1;
        Function<Integer, Integer> douaPuncteBonus = notaMea -> notaMea + 2;
        List<Integer> noteleMele = Arrays.asList(5, 6, 7, 9, 9, 8, 3, 4);
        List<Integer> noteMariteCu1 = givePoints(noteleMele, punctBonus);
        List<Integer> noteMariteCu2 = givePoints(noteleMele, douaPuncteBonus);
        List<Integer> noteMariteCuLambdaulMeu = givePoints(noteleMele, myLambda);
        System.out.println(noteMariteCuLambdaulMeu);
        System.out.println(noteMariteCu1);
        System.out.println(noteMariteCu2);

        Function<String, Integer> stringToSize = String::length;

        printNumbersUnderValue(randomGenerator, isHigherThan50);

    }

    public static List<Integer> givePoints(List<Integer> note, Function<Integer, Integer> eventualePuncteBonus) {
        List<Integer> noteleMarite = new ArrayList<>();
        for (Integer notaCurenta: note) {
            noteleMarite.add(eventualePuncteBonus.apply(notaCurenta));
        }
        return noteleMarite;
    }

    public static List<Integer> givePoints(List<Integer> note, MyLambda eventualePuncteBonus) {
        List<Integer> noteleMarite = new ArrayList<>();
        for (Integer notaCurenta: note) {
            noteleMarite.add(eventualePuncteBonus.increment1(notaCurenta));
        }
        return noteleMarite;
    }

    public static void printNumbersUnderValue(Supplier<Integer> supplier, Predicate<Integer> predicate) throws InterruptedException {
        System.out.println("+++++++++++++++++++++++++++++++++");
        while (true) {
            Thread.sleep(1000);
            Integer numarulMeu = supplier.get();
            if (predicate.test(numarulMeu)) {
                System.out.println(numarulMeu);
            }
        }

    }


}
