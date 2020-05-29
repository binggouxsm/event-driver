package com.eden.event.config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import(EventEngineImportSelector.class)
public @interface EnableEventEngine {

    /**
     * 根据value属性去决定Config类
     * @return
     */
    String value() default "com.eden.event.config.RedisConfig";
}
