package com.onur.HRMSProject.core.Validation;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ValidationError {
    private boolean success;
    private String message;
    private String details;
}
