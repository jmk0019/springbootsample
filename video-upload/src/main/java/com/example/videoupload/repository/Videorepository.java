package com.example.videoupload.repository;

import com.example.videoupload.dao.Videoentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Videorepository  extends JpaRepository<Videoentity ,Integer> {




}
