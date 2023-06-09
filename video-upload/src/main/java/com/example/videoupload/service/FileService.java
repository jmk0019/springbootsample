package com.example.videoupload.service;

import com.example.videoupload.dto.FileModel;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
@Service
public interface FileService {

    FileModel uploadVideo(String path, MultipartFile file ) throws IOException;
    InputStream getVideoFile(String path,String filename,int id) throws FileNotFoundException;


}
