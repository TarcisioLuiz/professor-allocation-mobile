package com.example.roomdatabase.config;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.roomdatabase.model.Course;
import com.example.roomdatabase.dao.CourseDao;

@Database(entities = {Course.class}, version = 1)
public abstract class BancoDeDados extends RoomDatabase {

    public abstract CourseDao createCourseDao();





}
