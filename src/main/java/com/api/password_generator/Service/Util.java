package com.api.password_generator.Service;

import java.util.Collections;
import java.util.Random;

public class Util {
    public static final Random RANDOM = new Random();
    public static final Double DIVISION = 1.2;
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    public static final String CHARACTER_SPECIAL = "!#$%&*+-./:;<=>?@[\\]^_|";

    private Util() {
        super();
    }

    public static String createPasswordInitial(Integer length) {
        return String.join("", Collections.nCopies(length, "#"));
    }
}
