package com.api.password_generator.Service;

import com.api.password_generator.Interface.Generate;
import com.api.password_generator.Model.PasswordGeneratorRequest;

import java.util.Arrays;

public class CharacterSpecialImpl implements Generate {
    @Override
    public String generate(String password) {
        int res = divisionPassword(password);
        String specials = getSpecials(res);
        int[] positions = getPositionsInPassword(password, res);
        return getNewPassword(password, positions, specials);
    }

    @Override
    public Boolean isUse(PasswordGeneratorRequest request) {
        return request.characterSpecial();
    }

    private int divisionPassword(String password) {
        double div = Math.floor(password.length() / Util.DIVISION);
        return (int) (password.length() - div);
    }

    private String getSpecials(int division) {
        StringBuilder sp = new StringBuilder();
        do {
            String c = String.valueOf(Util.CHARACTER_SPECIAL.charAt(Util.RANDOM.nextInt(Util.CHARACTER_SPECIAL.length())));
            if (sp.toString().contains(c)) continue;
            sp.append(c);
        } while (sp.length() != division);
        return sp.toString();
    }

    private int[] getPositionsInPassword(String password, int division) {
        int[] ps = new int[division];
        int i = 1;
        do {
            int n = Util.RANDOM.nextInt(password.length());
            if (Character.isUpperCase(password.charAt(n))) continue;
            if (String.valueOf(password.charAt(n)).matches("\\d+")) continue;
            if (Arrays.stream(ps).anyMatch(p -> p == n)) continue;
            ps[i - 1] = n;
            i++;
        } while (i != division);
        return ps;
    }

    private String getNewPassword(String password, int[] positions, String specials) {
        char[] newPassword = password.toCharArray();
        for (int j = 0; j < positions.length; j++) {
            newPassword[positions[j]] = specials.charAt(j);
        }
        return new String(newPassword);
    }
}
