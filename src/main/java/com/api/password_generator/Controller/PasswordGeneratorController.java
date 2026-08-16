package com.api.password_generator.Controller;

import com.api.password_generator.Model.PasswordGeneratorRequest;
import com.api.password_generator.Service.GenerateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/generate")
@RequiredArgsConstructor
public class PasswordGeneratorController {

    private final GenerateService generateService;

    @GetMapping
    public ResponseEntity<?> generatePassword(@ModelAttribute @Valid PasswordGeneratorRequest req) {
        return ResponseEntity.ok(generateService.generate(req));
    }
}
