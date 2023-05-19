package com.personallearning.learnsp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class firstController {

    @RequestMapping("/courses")
    public List<Course> retrieveAllCourses() {
        return Arrays.asList(
                new Course(1, "Aws", "Shivam"),
                new Course(2, "Java", "Shivam"),
                new Course(3, "Spring", "Shivam"),
                new Course(4, "SpringBoot1", "Shivam")
        );
    }

}
