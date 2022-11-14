package com.example.librarysystem;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class ReportList implements Serializable {
    ArrayList<ReportObj> reportList;

    public ArrayList<ReportObj> getReportList() {
        return reportList;
    }


    public ReportList(ArrayList<ReportObj> listOfReports) {

        this.reportList = listOfReports;
    }

    public ReportList() {
        this.reportList = null;
    }

    public void writeToFile(ReportList ROB, Context context) {

        //Open the file to write to
        File directory = new File(context.getFilesDir().getAbsolutePath()
                + File.separator + "serlization");
        if (!directory.exists()) {
            directory.mkdirs();
        }

        String filename = "reportList.srl";
        ObjectOutput out = null;

        try {
            out = new ObjectOutputStream(new FileOutputStream(directory
                    + File.separator + filename));
            //write the objects from the lOB arraylist so they are stored in the fie
            out.writeObject(ROB);
            //close the out object output stream
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static ReportList read(Context context) {
        //make the object input stream and array list, along with create a string for the file name
        ObjectInputStream input = null;
        ArrayList<ReportList> ROB = null;
        String filename = "reportList.srl";
        //open the file you will read from
        File direct = new File(context.getFilesDir().getAbsolutePath() + File.separator + "serlization");

        ReportList returnList = null;
        try {
            //declare the ObjectInputStream
            input = new ObjectInputStream(new FileInputStream(direct + File.separator + filename));

            //read the arraylist from the file and store it in return list
            returnList = (ReportList) input.readObject();
            input.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (returnList == null) {
            //if return list is null then return a empty list
            ReportList rL2 = new ReportList();
            return rL2;
        } else {
            //else return the written list
            return returnList;
        }
    }
}
