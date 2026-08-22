package com.example.search_service.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class FolderServiceClientFallBack
        implements FolderSearchClient {

    private static final Logger log =
            LoggerFactory.getLogger(
                    FolderServiceClientFallBack.class
            );

    @Override
    public List<Map<String, Object>> getAllFolders() {

        log.warn("Fallback for getAllFolders");

        return List.of();
    }

    @Override
    public List<Map<String, Object>> getAllFilesByParent(Long parentId) {
        return List.of();
    }

    @Override
    public List<Map<String, Object>>
    getAllFoldersByParentId(Long parentId) {

        log.warn(
                "Fallback for parentId {}",
                parentId
        );

        return List.of();
    }
}