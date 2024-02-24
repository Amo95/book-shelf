package com.bookshelve.api;

import com.bookshelve.model.BooksInfo;
import com.bookshelve.service.impl.BookShelfShelfServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookShelfController {

    private final BookShelfShelfServiceImpl shelfService;

    public ResponseEntity<List<BooksInfo>> getAllBooksInfo() {
        return ResponseEntity.ok(shelfService.getBooksInfo());
    }
}
