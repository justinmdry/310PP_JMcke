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
                out.writeObject(lOB);
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        public static ArrayList<Book>read(Context context) {
            ObjectInputStream input = null;
            ArrayList<BookList> lOB = null;
            String filename = "bookList.srl";
            File direct = new File(context.getFilesDir().getAbsolutePath() + File.separator + "serlization");

            ArrayList<BookList> returnList = null;
            try {
                input = new ObjectInputStream(new FileInputStream(direct + File.separator + filename));

                returnList = (ArrayList<BookList>) input.readObject();
                input.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            ArrayList<Book> rL2 = new ArrayList<Book>();
            
            for(int i = 0 ; i < returnList.size() ; i++){
                rL2.add(returnList.get(i));
            }

            return rL2;
        }

}
