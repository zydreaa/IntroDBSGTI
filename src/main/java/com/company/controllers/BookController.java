package com.company.controllers;

import com.company.books.Book;


import java.io.DataInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static com.company.dbhelper.DbConnectionBook.getConnection;

public class BookController {

    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;


    //add student controller
    public static boolean addBook() {
        //prompt the user for date
        System.out.println("Enter the name of the book: ");
        String name = scanner.nextLine();

        System.out.println("Enter the price of the book: ");
        int price = scanner.nextInt();

        try {
            //INSERT INTO book(name, price) VALUES('name', price);
            ps = getConnection().prepareStatement("INSERT INTO Books(name, price) VALUES('" + name + "', " + price + ") ");

            ps.execute(); //execute the sql command
            return true; //return true if successful

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //get a book by ID
    public static Book getBookById() {
        //prompt the user to enter the id of a book
        //they want to retrieve
        System.out.println("Enter the id of the book: ");
        int id = scanner.nextInt();

        try {
            ps = getConnection().prepareStatement("SELECT * FROM Books WHERE id=" + id);
            rs = ps.executeQuery();

            //define variables to temporarily hold
            //each field in the result set
            int bookId, price;
            String name;

            //initialise the book object to return at the end of the method execution
            Book book = new Book();

            //loop  through the result set and add the necessary values to the book object
            while (rs.next()) {
                bookId = rs.getInt("id");
                name = rs.getString("name");
                price = rs.getInt("price");
                book.setName(name);
                book.setId(id);
                book.setPrice(price);
            }
            return book;


        } catch (SQLException e) {
            System.out.println("Database Error");
            return null;
        }
    }

    public static boolean deleteBook() {
        //prompt the user to enter the name of a book
        //they want to delete
        System.out.println("Enter the id of a book: ");
        int id = scanner.nextInt();

        try {
            ps = getConnection().prepareStatement("DELETE FROM Books WHERE id=" + id);
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

        public static boolean editBookName() {
        //prompt the user to enter the name of a book
        //they want to edit name

            System.out.println("Enter the new name of a book: ");
            String name = scanner.nextLine();
            System.out.println("Enter the id of a book which want to edit name: ");
            int id = scanner.nextInt();

        try {
            ps = getConnection().prepareStatement("UPDATE Books SET name='" + name + "'WHERE id=" + id);
            ps.execute();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;



        }
    }
}