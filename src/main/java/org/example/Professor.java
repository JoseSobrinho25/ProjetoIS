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
    private String id;
    //@XmlElement(name = "ProfessorInfo")
    private String name;
    private String birthDate;
    private String phoneNumber;
    private String address;
    @XmlElement(name = "student")
    private ArrayList<Student> studentList = new ArrayList<>();

    public Professor() {
    }

    public Professor(String id, String name, String birthDate, String phoneNumber, String address, ArrayList<Student> studentList) {
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
