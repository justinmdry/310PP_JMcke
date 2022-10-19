package com.example.librarysystem;

import android.content.Context;
import android.content.SharedPreferences;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class BookList extends Book {

    ArrayList<Book> bookList;

    public ArrayList<Book> getBookList() {
        return bookList;
    }

    public BookList(ArrayList<Book> listOfBooks){

        this.bookList= listOfBooks;
    }

    public BookList(){
        this.bookList = null;
    }

        public void writeToFile(BookList lOB, Context context){

            //Open the file to write to
            File directory = new File(context.getFilesDir().getAbsolutePath()
                    + File.separator + "serlization");
            if (!directory.exists()) {
                directory.mkdirs();
            }

            String filename = "bookList.srl";
            ObjectOutput out = null;

            try {
                out = new ObjectOutputStream(new FileOutputStream(directory
                        + File.separator + filename));
                //write the objects from the lOB arraylist so they are stored in the fie
                out.writeObject(lOB);
                //close the out object output stream
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        public static ArrayList<Book>read(Context context) {
        //make the object input stream and array list, along with create a string for the file name
        ObjectInputStream input = null;
            ArrayList<BookList> lOB = null;
            String filename = "bookList.srl";
            //open the file you will read from
            File direct = new File(context.getFilesDir().getAbsolutePath() + File.separator + "serlization");

            ArrayList<BookList> returnList = null;
            try {
                //declare the ObjectInputStream
                input = new ObjectInputStream(new FileInputStream(direct + File.separator + filename));

                //read the arraylist from the file and store it in return list
                returnList = (ArrayList<BookList>) input.readObject();
                input.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            if(returnList == null) {
                //if return list is null then return a empty list
                ArrayList<Book> rL2 = new ArrayList<Book>();
                return rL2;
            }else{
            //else conver the ArrayList<BookList> into an ArrayList<Book> so we can disply in table and have each
                // object in an individual spot in the ArrayList
            ArrayList<Book> rL2 = new ArrayList<Book>();
            
            for(int i = 0 ; i < returnList.size() ; i++){
                rL2.add(returnList.get(i));
            }

            return rL2;}
        }

}
