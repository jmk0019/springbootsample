package com.example.demoproject.dao;

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
@Table(name="upload")

public class VideoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 50)
    private  String tittle;
    @Column(length = 200)
    private String descr;
    private  String tags;
    private String videoName;
    private Date addedDate;




}
