package com.company.objects;

public class Student {

    //Define properties of the Student object
    private int id;
    private String name;
    private  int age;
    private int mathematicsScore;
    private int englishScore;
    private int physicsScore;
    private int chemistryScore;

    public Student(){

    }

    //Define constructor
    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    //Define getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMathematicsScore() {
        return mathematicsScore;
    }

    public void setMathematicsScore(int mathematicsScore) {
        this.mathematicsScore = mathematicsScore;
    }

    public int getEnglishScore() {
        return englishScore;
    }

    public void setEnglishScore(int englishScore) {
        this.englishScore = englishScore;
    }

    public int getPhysicsScore() {
        return physicsScore;
    }

    public void setPhysicsScore(int physicsScore) {
        this.physicsScore = physicsScore;
    }

    public int getChemistryScore() {
        return chemistryScore;
    }

    public void setChemistryScore(int chemistryScore) {
        this.chemistryScore = chemistryScore;
    }

}
