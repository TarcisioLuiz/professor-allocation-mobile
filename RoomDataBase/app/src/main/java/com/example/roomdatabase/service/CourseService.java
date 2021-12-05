package com.example.roomdatabase.service;

import com.example.roomdatabase.model.Course;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CourseService {

    @GET("courses")
    Call<List<Course>> getAll();
}
