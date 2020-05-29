package com.eden.config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import(EventEngineImportSelector.class)
public @interface EnableEventEngine {

    String value() default "redis";
}
