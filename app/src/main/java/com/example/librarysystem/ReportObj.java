package com.example.librarysystem;

import java.io.Serializable;

public class ReportObj implements Serializable {
String title, description;


public ReportObj(){
    title = null;
    description = null;
}

public ReportObj(String title, String description) {
    this.title = title;
    this.description = description;

}

}
