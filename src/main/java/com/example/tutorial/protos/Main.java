package com.example.tutorial.protos;

import com.github.javafaker.Faker;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import org.example.ListProfessors;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {



        //System.out.println(john);
        long ini2 = System.currentTimeMillis();

        Professors prof = dataGenerate();

        long fini2 = System.currentTimeMillis();
        System.out.println("Time: "+ (fini2 - ini2));

        long ini = System.currentTimeMillis();
        FileOutputStream output = new FileOutputStream("testFile");
        prof.writeTo(output);
        output.close();
        long fini = System.currentTimeMillis();
        System.out.println("Time: "+ (fini - ini));

        // Read the existing address book.
        long ini1 = System.currentTimeMillis();
        Professors addressBook =
                Professors.parseFrom(new FileInputStream("testFile"));
        long fini1 = System.currentTimeMillis();
        System.out.println("Time: "+ (fini1 - ini1));
    }

    static Professors dataGenerate() {

        Professors.Builder professors = Professors.newBuilder();
        Professor.Builder professor = Professor.newBuilder();
        Student.Builder student = Student.newBuilder();
        Faker faker = new Faker();

        Random rand = new Random();


        for(int i = 0; i < 10 ; i++){
           professor.setId((faker.idNumber().valid()));
           professor.setName(faker.name().firstName() + " " + faker.name().lastName());
           professor.setAddress(faker.address().fullAddress());
           professor.setPhoneNumber(faker.phoneNumber().cellPhone());
           String formattedDate = String.format("%1$tb %1$te, %1$tY %1$tI:%1$tM %1$Tp", faker.date().birthday());
           professor.setBirthDate(formattedDate);
           formattedDate = String.format("%1$tb %1$te, %1$tY %1$tI:%1$tM %1$Tp", faker.date().birthday());
           professor.setBirthDate(formattedDate);
           for(int j = 0; j < 1000; j++){
               student.setId((faker.idNumber().valid()));
               student.setName(faker.name().firstName() + " " + faker.name().lastName());
               student.setAddress(faker.address().fullAddress());
               student.setPhoneNumber(faker.phoneNumber().cellPhone());
               formattedDate = String.format("%1$tb %1$te, %1$tY %1$tI:%1$tM %1$Tp", faker.date().birthday());
               student.setBirthDate(formattedDate);
               formattedDate = String.format("%1$tb %1$te, %1$tY %1$tI:%1$tM %1$Tp", faker.date().birthday());
               student.setRegistrationDate(formattedDate);
               professor.addStudent(student);
               int random = rand.nextInt(2);
               if(random == 0 ){
                   student.setGender("M");
               }
               else{
                   student.setGender("F");
               }

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
