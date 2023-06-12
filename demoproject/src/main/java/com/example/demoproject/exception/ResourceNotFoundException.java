package com.example.demoproject.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ResourceNotFoundException  extends  RuntimeException {
    private boolean status;
    private  String message;




}
