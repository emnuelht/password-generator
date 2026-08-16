package com.api.password_generator.Interface;

import com.api.password_generator.Model.PasswordGeneratorRequest;

public interface Generate {
    String generate(String password);
    Boolean isUse(PasswordGeneratorRequest request);
}
