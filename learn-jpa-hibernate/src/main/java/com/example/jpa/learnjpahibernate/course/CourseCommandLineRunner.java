package com.example.jpa.learnjpahibernate.course;

import com.example.jpa.learnjpahibernate.course.jdbc.CourseJDBCRepository;
import com.example.jpa.learnjpahibernate.course.jpa.CourseJpaRepository;
import com.example.jpa.learnjpahibernate.course.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    private CourseJDBCRepository repository;
    @Autowired
    private CourseSpringDataJpaRepository repository;
//    @Autowired
//    private CourseJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1L, "AWS", "Shivam"));
        repository.save(new Course(2L, "Azure", "Shivam"));
        repository.save(new Course(3L, "Devops", "Shivam"));

        repository.deleteById(3L);

        System.out.println(repository.findById(1L));
        System.out.println(repository.findById(2L));

        System.out.println(repository.findAll());
        System.out.println(repository.count());
        System.out.println(repository.findByAuthor("Shivam"));

    }

}
