package com.example.tutorial.protos;

import com.github.javafaker.Faker;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {


        //System.out.println(john);
        Professors prof = dataGenerate();
        FileOutputStream output = new FileOutputStream("testFile");
        prof.writeTo(output);
        output.close();

        // Read the existing address book.
        Professors addressBook =
                Professors.parseFrom(new FileInputStream("testFile"));
        System.out.println(addressBook);
    }

    static Professors dataGenerate() {

        Professors.Builder professors = Professors.newBuilder();
        Professor.Builder professor = Professor.newBuilder();
        Student.Builder student = Student.newBuilder();
        Faker faker = new Faker();

        for(int i = 0; i < 2 ; i++){
           professor.setId((faker.idNumber().valid()));
           professor.setName(faker.name().firstName() + " " + faker.name().lastName());
           professor.setEmail(faker.internet().emailAddress()) ;
           professor.setAddress(faker.address().fullAddress());
           professor.setPhoneNumber(faker.phoneNumber().cellPhone());
           for(int j = 0; j < 3; j++){
               student.setId((faker.idNumber().valid()));
               student.setName(faker.name().firstName() + " " + faker.name().lastName());
               student.setAddress(faker.address().fullAddress());
               professor.addStudent(student);
           }

           professors.addProfessor(professor);
           professor.clear();


           /*System.out.println(faker.name().firstName() + " " + faker.name().lastName());
           System.out.println(faker.idNumber().valid());
           System.out.println(faker.address().fullAddress());
           System.out.println(faker.phoneNumber().cellPhone());
           System.out.println(faker.internet().emailAddress());*/
        }

        /*Student Manel =
                Student.newBuilder()
                        .setId(1234)
                        .setName("John Doe")
                        .setAddress("Rua Viseu")
                        .setPhoneNumber(925594935)
                        .build();


        Professor john =
                Professor.newBuilder()
                        .setId(1234)
                        .setName("John Doe")
                        .setEmail("jdoe@example.com")
                        .setAddress("Rua Viseu")
                        .setPhoneNumber(925594935)
                        .addStudent(Manel)
                        .addStudent(Manel)
                        .build();

        Professor john1 =
                Professor.newBuilder()
                        .setId(1234)
                        .setName("teste 2")
                        .setEmail("jdoe@example.com")
                        .setAddress("Rua Viseu")
                        .setPhoneNumber(925594935)
                        .addStudent(Manel)
                        .build();

        professors.addProfessor(john);
        professors.addProfessor(john1);*/
        return professors.build();
    }
}
