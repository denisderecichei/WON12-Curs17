package org.fasttrack.tema16;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Shop<T extends ShopItem> {
    private List<T> items;

    public Shop() {
        this.items = new ArrayList<>();
    }

    public void addItem(T item) {
        this.items.add(item);
    }

    public List<T> getItems() {
        return items;
    }

    public List<T> findByCategory(Category category) {
        List<T> foundItems = new ArrayList<>();
        for (T currentItem: items) {
            if (category.equals(currentItem.category())) {
                foundItems.add(currentItem);
            }
        }
        return foundItems;
    }

    public List<T> findWithLowerPrice(int maxPrice) {
        List<T> foundItems = new ArrayList<>();
        for (T currentItem: items) {
            if (currentItem.price() < maxPrice) {
                foundItems.add(currentItem);
            }
        }
        return foundItems;
    }

    public Optional<T> findByName(String name) {
        for(T currentItem: items) {
            if (currentItem.name().equals(name)) {
                return Optional.of(currentItem);
            }
        }
        return Optional.empty();
    }

    public Optional<T> removeItem(String name) {
        for(T currentItem: items) {
            if (currentItem.name().equals(name)) {
                items.remove(currentItem);
                return Optional.of(currentItem);
            }
        }
        return Optional.empty();
    }
}
