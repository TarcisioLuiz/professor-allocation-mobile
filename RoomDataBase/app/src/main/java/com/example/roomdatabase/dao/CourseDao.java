package com.example.roomdatabase.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.roomdatabase.model.Course;

import java.util.List;

@Dao
public interface CourseDao {

    @Delete
    void delete(Course course);

    @Query("SELECT * FROM course")
    List<Course> getAll();

    @Insert
    void create(Course course);
}
