package com.api.password_generator.Model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public record PasswordGeneratorRequest(
        @Min(8)
        @Max(26)
        Integer quantity,
        Boolean characterUpperCase,
        Boolean characterSpecial,
        Boolean numbers
) {
}
