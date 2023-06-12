package com.example.demoproject.service;

import com.example.demoproject.dao.VideoEntity;
import com.example.demoproject.exception.ResourceNotFoundException;
import com.example.demoproject.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class VideoServiceImpl  implements  VideoService{
@Autowired
private VideoRepository videoRepository;

    @Override
    public VideoEntity createPost(VideoEntity videoEntity) {
        if (videoEntity.getTittle().isEmpty()) {
            throw new ResourceNotFoundException(false, "video tittle can not empty");
        }
        try{
            videoEntity.setAddedDate(new Date());
            VideoEntity video=videoRepository.save(videoEntity);

            return  video;
        }catch (Exception e){
            throw  new ResourceNotFoundException(false,"something went wrong");
        }

    }

    @Override
    public VideoEntity updatePost(VideoEntity videoEntity, Long id) {
        VideoEntity video=videoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(false,"file not found"));
        video.setDescr(videoEntity.getDescr());
        video.setTittle(videoEntity.getTittle());
        video.setAddedDate(new Date());
        video.setTags(videoEntity.getTags());
        VideoEntity updateVideoFields=videoRepository.save(video);
        return updateVideoFields;


    }

    @Override
    public VideoEntity getById(Long id) {

        VideoEntity video=videoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(false,"file not found"));
        return video;
    }

    @Override
    public void deleteVideos(Long id) {


    }

    @Override
    public List<VideoEntity> getallPost() {

        return videoRepository.findAll();
    }
}
