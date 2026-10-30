package com.cfs.folder_service.controller;


import com.cfs.folder_service.model.FolderEntity;
import com.cfs.folder_service.repo.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/folders")
public class FolderController {


    @Autowired
    private FolderRepository folderRepository;


    @GetMapping({"", "/folders"})
    public List<FolderEntity> getAllFolders()
    {
        return folderRepository.findAll();
    }

    @GetMapping("/{id}")
    public FolderEntity getFolder(@PathVariable Long id)
    {
        return folderRepository.findById(id).orElse(null);
    }

    @PostMapping("/create")
    public FolderEntity createFolder(@RequestBody FolderEntity folder)
    {
        if (folder.getId() == null) {
            folder.setId(System.currentTimeMillis());
        }
        return folderRepository.save(folder);

    }


    @DeleteMapping("/{id}")
    public void deleteFolder(@PathVariable Long id)
    {
        folderRepository.deleteById(id);
    }

    @GetMapping("/parent/{parentId}")
    public List<FolderEntity> getFoldersByParent(@PathVariable Long parentId)
    {
        return folderRepository.findByParentId(parentId);
    }

}
