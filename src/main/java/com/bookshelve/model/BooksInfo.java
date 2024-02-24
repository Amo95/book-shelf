package com.bookshelve.model;

import com.bookshelve.enums.Course;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity(name = "books_info")
public class BooksInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Course course;
    private String lecturer;
    private LocalDate dataAdded;
//    private String rating;
}