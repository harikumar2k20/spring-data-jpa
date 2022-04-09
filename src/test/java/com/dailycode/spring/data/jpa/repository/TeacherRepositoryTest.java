package com.dailycode.spring.data.jpa.repository;

import com.dailycode.spring.data.jpa.entity.Course;
import com.dailycode.spring.data.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){
        Course courseDBA = Course.builder()
                .title("DBA")
                .credit(5)
                .build();
        Course courseJAVA = Course.builder()
                .title("JAVA")
                .credit(6)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Raja")
                .lastName("Rao")
                //.courses(List.of( courseDBA,courseJAVA))
                .build();
       teacherRepository.save(teacher);
    }
}