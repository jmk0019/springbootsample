package com.example.videoupload.service;

import com.example.videoupload.dao.Videoentity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface VideoService {
    public Videoentity createPost(Videoentity videoentity);
    public Videoentity getById(Integer id);
    public Videoentity updatePost(Videoentity videoentity,Integer id);
    public void deletedVideos(Integer id);
    public List<Videoentity> getallPost();





}
