package com.company.controllers;

import com.company.dbhelper.DbConnection;
import com.company.dbhelper.DbConnectionBook;
import com.company.objects.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static com.company.dbhelper.DbConnection.getConnection;

public class StudentController {


    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;


    //add student controller
    public static boolean addStudent() {
        //prompt the user for date
        System.out.println("Enter the name of the student: ");
        String name = scanner.next();

        System.out.println("Enter the age of the student: ");
        int age = scanner.nextInt();

        try {
            //INSERT INTO students(name, age) VALUES('name', age);
            ps = getConnection().prepareStatement("INSERT INTO students(name, age) VALUES('" + name + "', " + age + ") ");

            ps.execute(); //execute the sql command
            return true; //return true if successful

        } catch (SQLException e) {
            System.out.println("Database Error");
            return false;
        }
    }

    //get student by ID
    public static Student getStudentById() {
        //prompt the user to enter the id of the student they want
        //to retrieve
        System.out.println("Enter the id of the student: ");
        int id = scanner.nextInt();

        try {
            ps = getConnection().prepareStatement("SELECT * FROM students WHERE id=" + id);
            rs = ps.executeQuery();

            //define variables to temporarily hold
            //each field in the result set
            int studentId, age;
            String name;

            //initialise the student object to return at the end of the method execution
            Student student = new Student();

            //loop  through the result set and add the necessary values to the student object
            while (rs.next()) {
                studentId = rs.getInt("id");
                name = rs.getString("name");
                age = rs.getInt("age");
                student.setName(name);
                student.setId(id);
                student.setAge(age);
            }
            return student;


        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean addStudentScores() {

        System.out.println("Enter score of mathematics of the student: ");
        int mathematicsScore = scanner.nextInt();

        System.out.println("Enter score of english of the student: ");
        int englishScoreScore = scanner.nextInt();

        System.out.println("Enter score of physics of the student: ");
        int physicsScore = scanner.nextInt();

        System.out.println("Enter score of chemistry of the student: ");
        int chemistryScore = scanner.nextInt();

        System.out.println("Enter the id of the student: ");
        int studentId = scanner.nextInt();

        try {
            ps = getConnection().prepareStatement("INSERT INTO scores(studentid ,mathematics , english, physics, chemistry) VALUES(" + studentId + ", " + mathematicsScore + ", " + englishScoreScore + ", " + physicsScore + ", " + chemistryScore + ") ");

            ps.execute(); //execute the sql command
            return true; //return true if successful

        } catch (SQLException e) {
            System.out.println("Database Error");
            return false;

        }
    }

    public static boolean deleteScores() {

        System.out.println("Enter the id of the student which scores you want to delete: ");
        int studentId = scanner.nextInt();

        try {
            ps = DbConnection.getConnection().prepareStatement("DELETE FROM scores WHERE studentid=" + studentId);
            ps.execute();
            return true;

        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    public static boolean editScore() {
        //add an editScore method, to edit a particular student's score for a subject of choice
        System.out.println("Enter id of the student which score you want to edit: ");
        int studentId = scanner.nextInt();

        System.out.println("Which subject scores you want to update? ");
        System.out.println("1. Mathematics. If yes, please enter new score: ");
        System.out.println("2. English. If yes, please enter new score: ");
        System.out.println("3. Physics. If yes, please enter new score:");
        System.out.println("4. Chemistry. If yes, please enter new score:");

        System.out.println("Select an option: ");
        int option = scanner.nextInt();

        System.out.println("Please enter new score: ");
        int newScore = scanner.nextInt();

        switch (option) {
            case 1:
                try {
                    ps = DbConnection.getConnection().prepareStatement("UPDATE scores SET mathematics='" + newScore + "'WHERE studentid=" + studentId);
                    ps.execute();
                    return true;

                } catch (SQLException e) {
                    e.printStackTrace();
                    return false;
                }
            case 2:
                try {
                    ps = DbConnection.getConnection().prepareStatement("UPDATE scores SET english='" + newScore + "'WHERE studentid=" + studentId);
                    ps.execute();
                    return true;

                } catch (SQLException e) {
                    e.printStackTrace();
                    return false;
                }
            case 3:
                try {
                    ps = DbConnection.getConnection().prepareStatement("UPDATE scores SET physics='" + newScore + "'WHERE studentid=" + studentId);
                    ps.execute();
                    return true;

                } catch (SQLException e) {
                    e.printStackTrace();
                    return false;
                }
            case 4:
                try {
                    ps = DbConnection.getConnection().prepareStatement("UPDATE scores SET chemistry='" + newScore + "'WHERE studentid=" + studentId);
                    ps.execute();
                    return true;

                } catch (SQLException e) {
                    e.printStackTrace();
                    return false;
                }
            default:
                System.out.println("Invalid option. Try again");
                editScore();
        }
        return false;
    }

    public static boolean deleteScore() {
        //add an overloaded deleteScore() method that takes id(int) as a parameter to you allow you to delete
        // a student's score when a student is deleted from the database

        System.out.println("Enter the id which scores you want to delete: ");
        int id = scanner.nextInt();

        try {
            ps = DbConnection.getConnection().prepareStatement("DELETE FROM scores WHERE id=" + id);
            ps.execute();
            return true;

        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }
}

