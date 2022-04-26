package com.company.books;

import com.company.menu.BookMenu;
import com.company.menu.StudentMenu;
import com.sun.javafx.scene.control.skin.TextAreaSkin;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //TASK
        //Create the same class in your code and
        //add the following fields: id(int), name(String), price(float).
        //In your main method, create a List of books and
        //return books that are more expensive than $5.

//        List<Book> books = new ArrayList<>();
//
//        books.add(new Book(1, "Atomic Habits", 20));
//        books.add(new Book(2, "Harry Potter", 15));
//        books.add(new Book(3, "Game of Thrones", 24));
//        books.add(new Book(4, "The Little Prince", 4));
//        books.add(new Book(5, "Divergent", 16));
//
//        System.out.println(filterLessThanFive(books));
//    }
//
//
//    public static List<String> filterLessThanFive(List<Book> books){
//        //an anonymous function -lam
////        books.removeIf(book -> book.getPrice() < 5);
////        return books;
//     List<String> bookNames = new ArrayList<>();
//
//     for (int i = 0; i < books.size(); i ++){
//         if (books.get(i).getPrice() < 5)books.remove(books.get(i));
//     }
//
//     books.forEach(book -> bookNames.add(book.getName()));
//
//    return bookNames;
//    }
        BookMenu.menu();
    }
}
