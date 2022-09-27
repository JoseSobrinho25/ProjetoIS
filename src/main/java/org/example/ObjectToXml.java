package org.example;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;


public class ObjectToXml {
    public static void main(String[] args) throws Exception{
        JAXBContext contextObj = JAXBContext.newInstance(ListProfessors.class);
        Marshaller marshallerObj = contextObj.createMarshaller();
        marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        Student stud1=new Student(20182728,"Alberto",918172616,"M","25/10/2000","25/10/2021","Rua benfica");
        Student stud2=new Student(20182720,"Joao",918672616,"M","25/10/2000","25/10/2021","Rua benfica");
        Student stud3=new Student(20182729,"Diogo",918175616,"M","25/10/2000","25/10/2021","Rua benfica");
        ArrayList <Student> aux2 = new ArrayList<>();
        aux2.add(stud1);
        aux2.add(stud2);
        aux2.add(stud3);
        Professor prof=new Professor(2018276713,"Jose", "20/10/1986", 918262734,"Rua Vale da Azenha",aux2);


        ArrayList <Professor> aux = new ArrayList<>();
        aux.add(prof);
        ListProfessors list = new ListProfessors(aux);



        marshallerObj.marshal(list,new FileOutputStream("student.xml"));

        // XML compressed with gzip
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


        //decompressed gzip
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

    }
}