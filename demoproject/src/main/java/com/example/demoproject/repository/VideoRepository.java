package com.example.demoproject.repository;

import com.example.demoproject.dao.VideoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository  extends JpaRepository<VideoEntity ,Long > {

}
