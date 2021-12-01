package ru.geekbrains;

import java.util.Objects;

public class Notebook implements Comparable<Notebook> {
    private final Integer price;
    private final Integer memory;
    private final Brand brand;

    public Notebook(Integer price, Integer memory, Brand brand) {
        this.price = price;
        this.memory = memory;
        this.brand = brand;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getMemory() {
        return memory;
    }

    public Brand getBrand() {
        return brand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Notebook notebook = (Notebook) o;

        if (!Objects.equals(price, notebook.price)) return false;
        if (!Objects.equals(memory, notebook.memory)) return false;
        return brand == notebook.brand;
    }

    @Override
    public int hashCode() {
        int result = price != null ? price.hashCode() : 0;
        result = 31 * result + (memory != null ? memory.hashCode() : 0);
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Notebook o) {
        int result = this.price.compareTo(o.price);
        if (result == 0) {
            result = this.memory.compareTo(o.memory);
            if (result == 0) {
                return this.brand.compareTo(o.brand);
            }
        }
        return result;
    }
}
