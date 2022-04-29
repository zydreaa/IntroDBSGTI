package com.company.menu;

import com.company.controllers.BookController;
import com.company.controllers.StudentController;
import com.company.objects.Student;

import java.util.Scanner;

public class StudentMenu {

    public static void menu(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("What do you want to do? ");
        System.out.println("1. Add a new student");
        System.out.println("2. Get student by id");
        System.out.println("3. Add student scores of the subjects");
        System.out.println("4. Delete student scores");
        System.out.println("5. Edit student score");

        System.out.println("Select an option: ");
        int option = scanner.nextInt();

        switch (option){
            case 1:
                System.out.println(StudentController.addStudent() ? "Student successfully added" : "Student was not added");
                break;
            case 2:
                System.out.println(StudentController.getStudentById().getName());
                break;
            case 3:
                System.out.println(StudentController.addStudentScores() ? "Student scores successfully added" : "Student scores were not added");
                break;
            case 4:
                System.out.println(StudentController.deleteScores() ? "Student scores were successfully deleted" : "Student scores were not deleted");
                break;
            case 5:
                System.out.println(StudentController.editScore() ? "Student score was successfully updated" : "Student score was not updated");
                break;
            default:
                System.out.println("Invalid option. Try again");
                menu();
        }
    }

}



