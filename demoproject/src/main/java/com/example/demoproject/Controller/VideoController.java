package com.example.demoproject.Controller;

import com.example.demoproject.dao.VideoEntity;
import com.example.demoproject.dto.FileModel;
import com.example.demoproject.service.FileService;
import com.example.demoproject.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class VideoController {
    @Value("${project.video")
    private String path;
    @Autowired
    private VideoService videoService;

@Autowired
private FileService fileService;

    @PostMapping("/save")
    public ResponseEntity<?> saveVideo(@RequestBody VideoEntity videoentity){
        return  new ResponseEntity<VideoEntity>(videoService.createPost(videoentity), HttpStatus.OK);
    }

    @GetMapping("/allVideos")
    public ResponseEntity<?> getAllVideos() {
        return new ResponseEntity<List<VideoEntity>>(videoService.getallPost(), HttpStatus.OK);
    }
    @GetMapping("{id}")
    public VideoEntity getVideoById(@PathVariable Long id){

        return  videoService.getById(id);
    }
@PostMapping("/post/{id}")
    public VideoEntity uploadingVideo(@RequestParam("video")MultipartFile video,Long id)throws IOException{
        VideoEntity v=videoService.getById(id);
    FileModel fileModel=fileService.uploadVideo(path,video);
    v.setVideoName(fileModel.getVideoFilename());
    VideoEntity finallyUpload=videoService.updatePost(v,id);
    return finallyUpload;
}





    }
