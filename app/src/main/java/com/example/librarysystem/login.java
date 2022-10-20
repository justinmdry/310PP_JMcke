package com.example.librarysystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class login extends AppCompatActivity {
    static int id = 0;
    static ArrayList<Book> books;
    static BookList lOB ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        createDB();
    }

    public void login(View v){
        EditText user=(EditText) findViewById(R.id.username);
        EditText pass=(EditText) findViewById(R.id.password);
        String userS=user.getText().toString();
        String passS=pass.getText().toString();

        if(userS.equals("user") && passS.equals("pass")){
            Intent intent= new Intent(this, UserMain.class);

            startActivity(intent);
        }
        if(userS.equals("admin") && passS.equals("pass")){
            Intent intent= new Intent(this, AdminMain.class);

            startActivity(intent);
        }
    }

    public void createDB() {
        //this will create or read the database from the file and BookList.read() function
        books = new ArrayList<Book>();

        lOB = lOB.read(getApplicationContext());

        ArrayList<Book> listOfBooks;
        listOfBooks = lOB.getBookList();
        // ^ reads the list into listOfBooks, if null which is checked below, make the database and store to file

            if (listOfBooks == null || listOfBooks.isEmpty()) {

                Book book1 = new Book(id, "Catch-22", "Joseph Teller", "War");
                Book book2 = new Book(id, "Lolita", "Vladimir Nabokov", "Romance");
                Book book3 = new Book(id, "The Great Gatsby", "F. Scott Fitzgerald", "Fiction");
                Book book4 = new Book(id, "Invisible Man", "Ralph Ellison", "Race");
                Book book5 = new Book(id, "Slaughterhouse-Five", "Kurt Vonnegut Jr.", "Science Fiction");
                Book book6 = new Book(id, "The Catcher in the Rye", "J.D. Salinger", "Young Adult");
                Book book7 = new Book(id, "The Sound and the Fury", "William Faulkner", "Fiction");
                Book book8 = new Book(id, "1984", "George Orwell", "Science Fiction");
                Book book9 = new Book(id, "Beloved", "Toni Morrison", "Race");
                Book book10 = new Book(id, "The Grapes of Wrath", "John Steinbeck", "Historical");
                Book book11 = new Book(id, "To Kill a Mockingbird", "Harper Lee", "Historical");
                Book book12 = new Book(id, "The Sun Also Rises", "Ernest Hemingway", "Historical");
                Book book13 = new Book(id, "An American Tragedy", "Theodore Dreiser", "Historical");
                Book book14 = new Book(id, "Atlas Shrugged", "Ayn Rand", "Philosophy");
                Book book15 = new Book(id, "Brave New World", "Alduos Huxley", "Science Fiction");
                Book book16 = new Book(id, "Gone with the Wind", "Margaret Mitchell", "Romance");
                Book book17 = new Book(id, "Midnight's Children", "Salman Rushdie", "Historical");
                Book book18 = new Book(id, "My Antonia", "Willa Cather", "Fiction");
                Book book19 = new Book(id, "On the Road", "Jack Kerouac", "Travel");
                Book book20 = new Book(id, "The Adventures of Huckleberry Finn", "Mark Twain", "Historical");
                Book book21 = new Book(id, "The Heart is a Lonely Hunter", "Carson McCullers", "Fiction");
                Book book22 = new Book(id, "The Hitchhiker's Guide to the Galaxy", "Douglas Adams", "Science Fiction");
                Book book23 = new Book(id, "The Tropic of Cancer", "Henry Miller", "Historical");
                Book book24 = new Book(id, "Their Eyes Were Watching God", "Zora Neale Hurston", "Historical");
                Book book25 = new Book(id, "To the Lighthouse", "Virginia Woolf", "Fiction");
                Book book26 = new Book(id, "Ulysses", "James Joyce", "Fiction");
                Book book27 = new Book(id, "Moby Dick", "Herman Melville", "Historical");
                Book book28 = new Book(id, "Dracula", "Bram Stoker", "Horror");
                Book book29 = new Book(id, "Life of Pi", "Yann Martel", "Adventure");
                Book book30 = new Book(id, "Heart of Darkness", "Joseph Conrad", "Historical");

                books.add(book1);
                books.add(book2);
                books.add(book3);
                books.add(book4);
                books.add(book5);
                books.add(book6);
                books.add(book7);
                books.add(book8);
                books.add(book9);
                books.add(book10);
                books.add(book11);
                books.add(book12);
                books.add(book13);
                books.add(book14);
                books.add(book15);
                books.add(book16);
                books.add(book17);
                books.add(book18);
                books.add(book19);
                books.add(book20);
                books.add(book21);
                books.add(book22);
                books.add(book23);
                books.add(book24);
                books.add(book25);
                books.add(book26);
                books.add(book27);
                books.add(book28);
                books.add(book29);
                books.add(book30);

                lOB = new BookList(books);

                lOB.writeToFile(lOB, getApplicationContext());

            }
        }


}