package com.api.password_generator.Service;

import com.api.password_generator.Interface.Generate;
import com.api.password_generator.Model.PasswordGeneratorRequest;

public class CharacterUpperCaseImpl implements Generate {
    @Override
    public String generate(String password) {
        int div = divisionPassword(password);
        String upperCase = getCharactersUpperCase(div, password);
        return getNewPassword(password, upperCase);
    }

    @Override
    public Boolean isUse(PasswordGeneratorRequest request) {
        return request.characterUpperCase();
    }

    private int divisionPassword(String password) {
        double div = Math.floor(password.length() / Util.DIVISION);
        return (int) (password.length() - div);
    }

    private String getCharactersUpperCase(int division, String password) {
        StringBuilder sp = new StringBuilder();
        do {
            String c = String.valueOf(password.charAt(Util.RANDOM.nextInt(password.length())));
            if (c.matches("\\d+")) continue;
            if (Util.CHARACTER_SPECIAL.contains(c)) continue;
            if (sp.toString().contains(c)) continue;
            sp.append(c);
        } while (sp.length() != division);
        return sp.toString().toUpperCase();
    }

    private String getNewPassword(String password, String uppers) {
        String newPassword = password;
        for (int i = 0; i < uppers.length(); i++) {
            String c = String.valueOf(uppers.charAt(i));
            newPassword = newPassword.replaceAll(c.toLowerCase(), c);
        }
        return newPassword;
    }
}
