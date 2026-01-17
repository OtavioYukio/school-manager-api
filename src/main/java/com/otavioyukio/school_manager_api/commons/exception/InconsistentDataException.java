package com.otavioyukio.school_manager_api.commons.exception;

public class InconsistentDataException extends RuntimeException {
    public InconsistentDataException(String message) {
        super("Inconsistent data.");
    }
}
