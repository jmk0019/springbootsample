package com.example.videoupload.controller;

import com.example.videoupload.dao.Videoentity;
import com.example.videoupload.dto.FileModel;
import com.example.videoupload.repository.Videorepository;
import com.example.videoupload.service.FileService;
import com.example.videoupload.service.VideoService;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class VideoController {
    @Value("${project.video")
    private  String path;

@Autowired
    private VideoService videoService;
@Autowired
private FileService fileService;
@Autowired
private  Videorepository videorepository;
@PostMapping("/save")
    public ResponseEntity<?> saveVideo(@RequestBody Videoentity videoentity){
    return  new ResponseEntity<Videoentity>(videoService.createPost(videoentity), HttpStatus.OK);
}
@GetMapping("/allvideos")
    public ResponseEntity<?> getAllVideos(){
    return  new ResponseEntity<List<Videoentity>>(videoService.getallPost(),HttpStatus.OK);

}
@GetMapping("{id}")
    public Videoentity getVideoById(@PathVariable Integer id){
    return  videoService.getById(id);
}
@PostMapping("/post/{id}")
    public  Videoentity uploadingVideo(@RequestParam("video") MultipartFile video,Integer id) throws IOException {
    Videoentity v = videoService.getById(id);
    FileModel fileModel = fileService.uploadVideo(path,video);
    v.setVideoName(fileModel.getVideoFilename());
    Videoentity finallyUpload = videoService.updatePost(v,id);
    return  finallyUpload;

}
@GetMapping(value = "/play/{id}",produces = MediaType.ALL_VALUE)
    public  void playVideo(@PathVariable Integer id, HttpServletResponse response) throws IOException{
    Optional<Videoentity> video= videorepository.findById(id);
    InputStream  resource=fileService.getVideoFile(path,video.get().getVideoName(),id);
    response.setContentType(MediaType.ALL_VALUE);
    StreamUtils.copy(resource,response.getOutputStream());
}

}
