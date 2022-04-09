package com.dailycode.spring.data.jpa.repository;

import com.dailycode.spring.data.jpa.entity.Course;
import com.dailycode.spring.data.jpa.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository materialRepository;

    @Test
    public void saveCourseMaterial(){
        Course course = Course.builder()
                .title("DSA")
                .credit(6)
                .build();

        CourseMaterial material = CourseMaterial.builder()
                .url("www.google.com")
                .course(course)
                .build();
        materialRepository.save(material);
    }

    @Test
    public void printAllCourseMaterials(){
        List<CourseMaterial> courseMaterials = materialRepository.findAll();
        System.out.println("courseMaterials = " + courseMaterials);
    }

}