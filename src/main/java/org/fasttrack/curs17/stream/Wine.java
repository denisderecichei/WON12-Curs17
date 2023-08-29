package org.fasttrack.curs17.stream;

public class Wine {
    private int year;
    private int price;

    public Wine(int year, int price) {
        this.year = year;
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Wine{" +
                "year=" + year +
                ", price=" + price +
                '}';
    }
}
