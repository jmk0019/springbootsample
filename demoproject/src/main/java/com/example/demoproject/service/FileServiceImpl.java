package com.example.demoproject.service;

import com.example.demoproject.dto.FileModel;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileServiceImpl  implements  FileService{
    @Override
    public FileModel uploadVideo(String path, MultipartFile file) throws IOException {
        FileModel fileModel=new FileModel();
        //fetch the original name
        String fileName=file.getOriginalFilename();
//trying to generate random id
        String randomId= UUID.randomUUID().toString();
        String finalName=randomId.concat(fileName).substring(fileName.indexOf("."));
        //file full path
        String filePath=path+ File.separator+finalName;
        //creating directory to save file
        File f=new File(path);
        if(!f.exists()){
            f.mkdir();
        }
        Files.copy(file.getInputStream(), Paths.get(filePath));
        fileModel.setVideoFilename(finalName);


        return fileModel;
    }

    @Override
    public InputStream getVideoFile(String path, String filename, Long id) throws FileNotFoundException {

        String fullPath=path+File.separator+filename;
        InputStream inputStream=new FileInputStream(fullPath);
        return inputStream;



    }
}
