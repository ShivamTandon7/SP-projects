package com.example.jpa.learnjpahibernate.course.springdatajpa;

import com.example.jpa.learnjpahibernate.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {

    List<Course> findByAuthor(String author);
}
