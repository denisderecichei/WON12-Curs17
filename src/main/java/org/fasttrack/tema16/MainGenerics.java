package org.fasttrack.tema16;

import java.util.List;
import java.util.Optional;

public class MainGenerics {

    public static void main(String[] args) {
        Clothes c1 = new Clothes("bluza", 10, Category.NEW);
        Clothes c2 = new Clothes("pantalon", 11, Category.REFURBISHED);

        Shop<Clothes> clothesShop = new Shop<>();
        clothesShop.addItem(c1);
        clothesShop.addItem(c2);

        System.out.println(clothesShop.findByCategory(Category.NEW));
        System.out.println(clothesShop.findByCategory(Category.ON_SALE));

        Optional<Clothes> bluza = clothesShop.findByName("bluza");
        if (bluza.isPresent()) {
            System.out.println(bluza);
        } else {
            System.out.println("Nu avem bluza");
        }

        List<Clothes> allMyClothes = clothesShop.getItems();
        Clothes foundClothes = null;
        for (Clothes c: allMyClothes) {
            if (c.name().equals("cardigan")) {
                foundClothes = c;
                break;
            }
        }
        Optional<Clothes> cardigan = clothesShop.findByName("cardigan");
        if (cardigan.isPresent()) {
            System.out.println(cardigan.get());
        } else {
            System.out.println("Nu avem cardigan");
        }
        System.out.println(cardigan);
        System.out.println("-------------------");
        System.out.println(clothesShop.removeItem("bluza"));
        System.out.println(clothesShop.removeItem("bluza"));
        System.out.println(clothesShop.removeItem("cardigan"));
    }

}
