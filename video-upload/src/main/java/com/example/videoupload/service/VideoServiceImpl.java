package com.example.videoupload.service;

import com.example.videoupload.dao.Videoentity;
import com.example.videoupload.exception.ResourceNotFoundException;
import com.example.videoupload.repository.Videorepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class VideoServiceImpl  implements  VideoService{
    @Autowired
    private  Videorepository videorepository;


    @Override
    public Videoentity createPost(Videoentity videoentity) {
        if(videoentity.getTittle().isEmpty()){
            throw  new ResourceNotFoundException(false,"video tittle can not empty");
        }
        try{
            Videoentity video=videorepository.save(videoentity);
            video.setAddedDate(new Date());
            return  video;
        }catch (Exception e){
            throw new ResourceNotFoundException(false,"something went wrong");
        }




    }

    @Override
    public Videoentity getById(Integer id) {
        Videoentity video=videorepository.findById(id).orElseThrow(()->new ResourceNotFoundException(false,"video not found"));
        return video;
    }

    @Override
    public Videoentity updatePost(Videoentity videoentity, Integer id) {
        Videoentity video=videorepository.findById(id).orElseThrow(()->new ResourceNotFoundException(false,"video not found"));
        video.setDescr(videoentity.getDescr());
        video.setTittle(videoentity.getTittle());
        video.setAddedDate(new Date());
        video.setTags(videoentity.getTags());
        Videoentity updateVideoFields=videorepository.save(video);
        return updateVideoFields;
    }

    @Override
    public void deletedVideos(Integer id) {


    }

    @Override
    public List<Videoentity> getallPost() {




        return videorepository.findAll();
    }
}
