package com.dailycode.spring.data.jpa.repository;

import com.dailycode.spring.data.jpa.entity.Course;
import com.dailycode.spring.data.jpa.entity.Student;
import com.dailycode.spring.data.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourse(){
        List<Course> courses = courseRepository.findAll();
        System.out.println("courses = " + courses);
    }

    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Hari")
                .lastName("Kumar")
                .build();
        Course course = Course.builder()
                .title("springboot")
                .teacher(teacher)
                .credit(8)
                .build();
        courseRepository.save(course);
    }


    @Test
    public void findAllPagination(){
       Pageable firstPageWithThreeRecords = PageRequest.of(0,3);
       Pageable secondPageWithTwoRecords = PageRequest.of(1,2);

       List<Course> courses = courseRepository.findAll(firstPageWithThreeRecords).getContent();
        System.out.println("courses = " + courses);

        long  totalElements = courseRepository.findAll(firstPageWithThreeRecords).getTotalElements();
        System.out.println("totalElements = " + totalElements);

        long totalPages = courseRepository.findAll(firstPageWithThreeRecords).getTotalPages();
        System.out.println("totalPages = " + totalPages);
    }

    @Test
    public void findAllSorting(){
        Pageable sortByTitle = PageRequest.of(0,2, Sort.by("title"));

        Pageable sortByCreditDesc = PageRequest.of(0,2,Sort.by("credit").descending());

        Pageable sortByTitleAndCredit = PageRequest.of(
                0,
                2,
                Sort.by("title")
                        .descending()
                        .and(Sort.by("credit"))
        );

        List<Course> courses = courseRepository.findAll(sortByTitleAndCredit).getContent();
        //System.out.println("courses = " + courses);
        courses.stream().map(Course::getTitle).forEach(System.out::println);
    }

    @Test
    public void printFindByTitleContaining(){
       Pageable firstPageWithTenRecords = PageRequest.of(0,10);
        List<Course> courses = courseRepository.findByTitleContaining("D", firstPageWithTenRecords).getContent();
        courses.stream().map(Course::getTitle).forEach(System.out::println);
        System.out.println("courses = " + courses);
    }

    @Test
    public void saveCourseWithStudentAndTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("John")
                .lastName("William")
                .build();
        Student student = Student.builder()
                .firstName("Anil")
                .lastName("bandaru")
                .emailId("anil@gmail.com")
                .build();
        Course course = Course.builder()
                .credit(12)
                .title("AI")
                .teacher(teacher)
                .build();
        course.addStudents(student);
        courseRepository.save(course);

    }
}