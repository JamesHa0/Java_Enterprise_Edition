package com.jameshao.bookmanagement.service;

import com.jameshao.bookmanagement.Book;

import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl {
    private static List<Book> Books = new ArrayList<>();
    static {
        Books.add(new Book("红楼梦", "曹雪芹", "9787532100000"));
        Books.add(new Book("西游记", "吴承恩", "9787532111111"));
        Books.add(new Book("三国演义", "罗贯中", "978012345678"));
        Books.add(new Book("水浒传", "施耐庵", "978012345678"));
    }

    public static String searchBook (String isbn,String title){
        for (Book book : Books) {
            if (book.getTitle().equals(title) || book.getIsbn().equals(isbn)) {
                return book.toString();
            }
        }
        return "未找到图书";
    }

    public static String addBook (String isbn,String title,String author){
        for (Book book : Books) {
            if (book.getIsbn().equals(isbn)) {
                return "ISBN已存在";
            }
        }
        Book newBook = new Book(isbn,title,author);
        Books.add(newBook);
        return "添加成功："+newBook.toString();
    }

    public static String deleteBook (String isbn){
        for (Book book : Books) {
            if (book.getIsbn().equals(isbn)) {
                Books.remove(book);
                return "删除成功："+book.toString();
            }
        }
        return "删除失败：ISBN不存在";
    }



}
