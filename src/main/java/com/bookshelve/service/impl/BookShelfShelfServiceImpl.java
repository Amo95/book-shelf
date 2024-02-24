package com.bookshelve.service.impl;

import com.bookshelve.model.BooksInfo;
import com.bookshelve.repository.BookShelf;
import com.bookshelve.service.BookShelfService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookShelfShelfServiceImpl implements BookShelfService {

    private final BookShelf bookShelf;

    @Override
    public List<BooksInfo> getBooksInfo() {
        return List.of();
    }
}
