package com.api.password_generator.Service;

import com.api.password_generator.Interface.Generate;
import com.api.password_generator.Model.PasswordGeneratorRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenerateService {
    private final List<Generate> generateList = List.of(
            new CharacterLowerCaseImpl(),
            new CharacterUpperCaseImpl(),
            new CharacterSpecialImpl(),
            new NumbersImpl()
    );

    public String generate(PasswordGeneratorRequest req) {
        String password = Util.createPasswordInitial(req.quantity());

        for (Generate generate : generateList) {
            if (generate.isUse(req)) {
                password = generate.generate(password);
            }
        }

        return password;
    }
}
