package org.example;

import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;
@XmlType(propOrder = {
        "name",
        "phoneNumber",
        "birthDate",
        "address",
        "studentList"
})
@XmlAccessorType (XmlAccessType.FIELD)
public class Professor {
    @XmlAttribute(name = "ProfessorIdentifier")
    private int id;
    //@XmlElement(name = "ProfessorInfo")
    private String name;
    private String birthDate;
    private int phoneNumber;
    private String address;
    @XmlElement(name = "student")
    private ArrayList<Student> studentList = new ArrayList<>();

    public Professor() {
    }

    public Professor(int id, String name, String birthDate, int phoneNumber, String address, ArrayList<Student> studentList) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.studentList = studentList;
    }


    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
