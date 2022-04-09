package com.dailycode.spring.data.jpa.repository;

import com.dailycode.spring.data.jpa.entity.Guardian;
import com.dailycode.spring.data.jpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("honey@gmail.com")
                .firstName("Esther")
                .lastName("honey")
//                .guardianName("hari")
//                .guardianEmail("hari@gmail.com")
//                .guardianMobile("9343175326")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .name("vasu")
                .email("vasu@gmail.com")
                .mobile("1234567890")
                .build();
        Student  student = Student.builder()
                .firstName("Tracy")
                .lastName("Bandaru")
                .emailId("tracy@gmail.com")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printAllStudents(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> students = studentRepository.findByFirstName("Tracy");
        System.out.println("students = " + students);
    }

    @Test
    public void  printStudentByFirstNameContaining(){
        List<Student> students = studentRepository.findByFirstNameContaining("t");
        System.out.println("students = " + students);
    }

    @Test
    public void  printStudentBasedOnGuardianName(){
        List<Student> students = studentRepository.findByGuardianName("hari");
        System.out.println("students = " + students);
    }

    @Test
    public void getStudentByEmailAddress(){
        Student student = studentRepository.getStudentByEmailAddress("honey@gmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public void  getStudentFirstNameByEmailAddress(){
        String firstName = studentRepository.getStudentFirstNameByEmailAddress("honey@gmail.com");
        System.out.println("firstName = " + firstName);
    }

    @Test
    public void getStudentByEmailAddressNative(){
        Student student = studentRepository.getStudentByEmailAddressNative("tracy@gmail.com");
        System.out.println("studentRepository = " + student);
    }

    @Test
    public void getStudentByEmailAddressNativeNamedParam(){
        Student student = studentRepository.getStudentByEmailAddressNative("tracy@gmail.com");
        System.out.println("studentRepository = " + student);
    }

    @Test
    public void updateStudentNameByEmailIdTest(){
        studentRepository.updateStudentNameByEmailId("Tracy papa", "tracy@gmail.com");

    }


}