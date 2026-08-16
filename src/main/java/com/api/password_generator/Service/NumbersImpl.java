package com.api.password_generator.Service;

import com.api.password_generator.Interface.Generate;
import com.api.password_generator.Model.PasswordGeneratorRequest;

public class NumbersImpl implements Generate {
    @Override
    public String generate(String password) {
        int div = divisionPassword(password);
        String letters = getLetters(div, password);
        String numbers = getNumbers(div);
        return getNewPassword(password, letters, numbers);
    }

    @Override
    public Boolean isUse(PasswordGeneratorRequest request) {
        return request.numbers();
    }

    private int divisionPassword(String password) {
        double div = Math.floor(password.length() / Util.DIVISION);
        return (int) (password.length() - div);
    }

    private String getLetters(int division, String password) {
        StringBuilder sp = new StringBuilder();
        do {
            String c = String.valueOf(password.charAt(Util.RANDOM.nextInt(password.length())));
            if (Util.ALPHABET.toUpperCase().contains(c)) continue;
            if (Util.CHARACTER_SPECIAL.contains(c)) continue;
            if (sp.toString().contains(c)) continue;
            sp.append(c);
        } while (sp.length() != division);
        return sp.toString();
    }

    private String getNumbers(int division) {
        StringBuilder sp = new StringBuilder();
        do {
            int n = Util.RANDOM.nextInt(9);
            if (sp.toString().contains(n + "")) continue;
            sp.append(n);
        } while (sp.length() != division);
        return sp.toString();
    }

    private String getNewPassword(String password, String letters, String numbers) {
        String newPassword = password;
        for (int i = 0; i < letters.length(); i++) {
            String c = String.valueOf(letters.charAt(i));
            String n = String.valueOf(numbers.charAt(i));
            newPassword = newPassword.replaceAll(c, n);
        }
        return newPassword;
    }
}
