package com.api.password_generator.Service;

import com.api.password_generator.Interface.Generate;
import com.api.password_generator.Model.PasswordGeneratorRequest;

public class CharacterLowerCaseImpl implements Generate {
    @Override
    public String generate(String password) {
        StringBuilder sb = new StringBuilder();
        do {
            String c = String.valueOf(Util.ALPHABET.charAt(Util.RANDOM.nextInt(Util.ALPHABET.length())));
            if (sb.toString().contains(c)) continue;
            sb.append(c);
        } while (sb.length() != password.length());
        return sb.toString().toLowerCase();
    }

    @Override
    public Boolean isUse(PasswordGeneratorRequest request) {
        return true;
    }
}
