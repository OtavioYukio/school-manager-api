package com.otavioyukio.school_manager_api.commons.exception;

public class ObjectNotFoundException extends RuntimeException {
    public ObjectNotFoundException(String object) {
        super(object + " not found.");
    }
}
