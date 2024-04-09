package model;

import java.io.Serializable;

public class Student implements Serializable {
    private String studentId;
    private String name;
    private int age;
    private String gender;
    private String address;
    private double averagescore;

    public Student() {
    }

    public Student(String studentId, String name, int age, String gender, String address, double averagescore) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.averagescore = averagescore;
    }

    public String getId() {
        return studentId;
    }

    public void setId(String id) {
        this.studentId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getAveragescore() {
        return averagescore;
    }

    public void setAveragescore(double averagescore) {
        this.averagescore = averagescore;
    }

    @Override
    public String toString() {
        return "student{" +
                "id='" + studentId + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", averagescore=" + averagescore +
                '}';
    }
}
