package org.example;

import com.example.tutorial.protos.Professors;
import com.github.javafaker.Faker;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;


public class ObjectToXml {
    public static void main(String[] args) throws Exception{



        ArrayList<Professor> listProf = new ArrayList<>();
        String profName;
        String profId;
        String profAddress;
        String profNumber;
        String profBithDate;

        String studentId;
        String studentName;
        String studentAddress;
        String studentPhone;
        String studentBirthDate;
        String studentRegistrationDate;

        Faker faker = new Faker();

        Random rand = new Random();

        for(int i = 0; i < 10 ; i++) {
            ArrayList <Student> aux2 = new ArrayList<>();
            profId = faker.idNumber().valid();
            profName = (faker.name().firstName() + " " + faker.name().lastName());
            profAddress = (faker.address().fullAddress());
            profNumber = (faker.phoneNumber().cellPhone());
            String formattedDate = String.format("%1$tb %1$te, %1$tY %1$tI:%1$tM %1$Tp", faker.date().birthday());
            formattedDate = String.format("%1$tb %1$te, %1$tY %1$tI:%1$tM %1$Tp", faker.date().birthday());
            profBithDate = (formattedDate);
            Professor prof = new Professor();
            prof.setName(profName);
            prof.setId(profId);
            prof.setAddress(profAddress);
            prof.setPhoneNumber(profNumber);
            prof.setBirthDate(profBithDate);
            Student student = new Student();

            for (int j = 0; j < 1000; j++) {

                studentId = ((faker.idNumber().valid()));
                studentName = (faker.name().firstName() + " " + faker.name().lastName());
                studentAddress = (faker.address().fullAddress());
                studentPhone = (faker.phoneNumber().cellPhone());
                formattedDate = String.format("%1$tb %1$te, %1$tY %1$tI:%1$tM %1$Tp", faker.date().birthday());
                studentBirthDate = (formattedDate);
                formattedDate = String.format("%1$tb %1$te, %1$tY %1$tI:%1$tM %1$Tp", faker.date().birthday());
                studentRegistrationDate = (formattedDate);

                student.setId(studentId);
                student.setName(studentName);
                student.setAddress(studentAddress);
                student.setphoneNumber(studentPhone);
                student.setBirthDate(studentBirthDate);
                student.setRegistrationDate(studentRegistrationDate);

                int random = rand.nextInt(2);
                if (random == 0) {
                    student.setGender("M");
                } else {
                    student.setGender("F");
                }
                aux2.add(student);


            }
            prof.setStudentList(aux2);
            listProf.add(prof);

        }

        ListProfessors list = new ListProfessors(listProf);



        //java object to xml
        long ini = System.currentTimeMillis();
        JAXBContext contextObj = JAXBContext.newInstance(ListProfessors.class);
        Marshaller marshallerObj = contextObj.createMarshaller();
        marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshallerObj.marshal(list,new FileOutputStream("student.xml"));
       long fini = System.currentTimeMillis();
       System.out.println("Time: "+ (fini - ini));

        //xml to java object
        long ini1 = System.currentTimeMillis();
        File file = new File("student.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(ListProfessors.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        ListProfessors listp= (ListProfessors) jaxbUnmarshaller.unmarshal(file);
        long fini1 = System.currentTimeMillis();
        System.out.println("Time: "+ (fini1 - ini1));


        // XML compressed with gzip
        long ini2 = System.currentTimeMillis();
        Path source = Paths.get("student.xml");
        Path target = Paths.get("student.xml.gz");
        try (GZIPOutputStream gos = new GZIPOutputStream(
                new FileOutputStream(target.toFile()));
             FileInputStream fis = new FileInputStream(source.toFile())) {

            // copy file
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) > 0) {
                gos.write(buffer, 0, len);
            }

        }
        long fini2 = System.currentTimeMillis();
        System.out.println("Time: "+ (fini - ini) + (fini2 - ini2));


        //decompressed gzip
        long ini3 = System.currentTimeMillis();
        Path source1 = Paths.get("student.xml.gz");
        Path target1 = Paths.get("studentDecompressed.xml");

        try (GZIPInputStream gis = new GZIPInputStream(
                new FileInputStream(source1.toFile()));
             FileOutputStream fos = new FileOutputStream(target1.toFile())) {

            // copy GZIPInputStream to FileOutputStream
            byte[] buffer = new byte[1024];
            int len;
            while ((len = gis.read(buffer)) > 0) {
                fos.write(buffer, 0, len);
            }

        }
        long fini3 = System.currentTimeMillis();
        System.out.println("Time: "+ (fini1 - ini1) + (fini3 - ini3));

    }
}