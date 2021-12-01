package ru.geekbrains;

public enum Brand {
    LENUVO("Lenuvo"),
    ASOS("Asos"),
    MACNOTE("MacNote"),
    ESER("Eser"),
    XAMIOU("Xamiou");

    private final String value;

    Brand(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Brand getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
