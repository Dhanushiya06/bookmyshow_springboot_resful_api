package com.nesit.bookmyshow._springboot_resful_api.service;

import com.nesit.bookmyshow._springboot_resful_api.model.File;
import com.nesit.bookmyshow._springboot_resful_api.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileService {

    @Autowired
    private FileRepository fileRepository;

    public File uploadFile(File file){
        return fileRepository.save(file);
    }

}
