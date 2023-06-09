package com.example.videoupload.dao;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name="upload_video")

public class Videoentity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int id;
    @Column(length = 50)
    private  String tittle;
    @Column(length = 200)
    private String descr;
    private  String tags;
    private String videoName;
    private Date addedDate;





}
