package edu.icet.services.validation;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public interface ValidationService {
    public ResponseEntity<?> validate(BindingResult result);
}
