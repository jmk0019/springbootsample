package com.example.demoproject.service;

import com.example.demoproject.dao.VideoEntity;

import java.util.List;

public interface VideoService {
 public VideoEntity createPost(VideoEntity videoEntity);
public VideoEntity updatePost(VideoEntity videoEntity,Long id);
 public VideoEntity  getById(Long id);
 public void deleteVideos(Long id);
 public List<VideoEntity> getallPost();


}
