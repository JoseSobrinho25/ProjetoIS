package org.example;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
@XmlRootElement
public class ListProfessors {

    private ArrayList<Professor> list;

    public ListProfessors(ArrayList<Professor> list) {
        this.list = list;
    }

    public ListProfessors() {
    }
    @XmlElement(name = "Professor")
    public ArrayList<Professor> getList() {
        return list;
    }

    public void setList(ArrayList<Professor> list) {
        this.list = list;
    }
}
