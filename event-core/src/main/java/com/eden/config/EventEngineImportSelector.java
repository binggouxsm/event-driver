package com.eden.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

public class EventEngineImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {

        Map<String, Object> annotationAttributes = annotationMetadata.getAnnotationAttributes(EnableEventEngine.class.getCanonicalName());
        String type = "" + annotationAttributes.get("value");
        switch (type) {
            case "memory":
                return new String[]{"com.eden.config.MemoryConfig"};
            default:
                return new String[]{"com.eden.config.RedisConfig"};
        }


    }
}
