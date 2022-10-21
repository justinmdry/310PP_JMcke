# **COSC 310 - Group 30 - Library Managment System**
Welcome to our library managment system! Below is useful information about our app.

## **System Specifications**
The library app will allow users and staff to interact with the library’s inventory. The system will consist of a number of features with the first being an account feature where customers can make unique accounts and log in with them. Employees have access to a different account that allows access to features that users should not have access too. Next, the app will have a database that tracks new users and books the library has. The database will track the book’s name, author, genre, id, whether it is checked out or not, who has the book checked out. Users will be able to search for books based on keywords and withdraw books that are currently in stock. Users are able to return books and are notified of the time until overdue. Users can see what books they have checked out at any given time. Users can also report damages of any books and notify admins of the issue. Users can review books after they’ve returned it and view other people’s reviews. Admins can search for specific books and see who is borrowing it. Admins can also add new books to the database and delete any if needed. Admins can also respond to and resolve report tickets.

## **Feature Specifications**
- ### **Account**
    Users should be able to create a unique account, login with it and be able to logout. Admins should be able to login with their credentials and logout.

- ### **Database**
    Stores book information (ID, title, author, genre, checkout status, customer ID) and customer information (ID, first name, last name).

- ### **Search**
    A spinner that filters by the user’s input and displays book if criteria matches

- ### **Bookview**
    Users can see what book they took out, report damage with a button and review button that brings the user to a review page

- ### **Report**
    Users can make a ticket for damaged books. Admins can see active tickets and resolve them.

- ### **Review**
    Users can write reviews and rate books upon returning it. Users should be able to see reviews

## **Iteration 1 Specifications and Limitations**
- ### **Basic Login**
    A single account for users and a single account for admins that gives access to different views. Both can logout. No new accounts for this iteration

- ### **Home Screen**
    The user screen has My Books button and Search Books button. The admin screen will just have a Manage Books button

- ### **Database**
    The database will be primitive, consisting of a local file generated on the phone upon installation. It will have 30 books on install and admins will be able to add or delete books.

- ### **User My Books**
    A table that displays all the users checked out books and information. A check in button will be present that allows the user to “put back” a book.

- ### **User Search**
    Displays all available books and has a checkout button to checkout book.

- ### **Admin Manage Books**
    Displays all available books with a delete button available. An add button at the top should bring the admin to an add books page

- ### **Admin Add Book**
    Brings up a form for the admin to fill out

## **Class Organization**
All classes function as activities within the android studio project. The exception with this is Book and Booklist. Book is a static object that contains attributes about the books. Booklist is a public class used to store an arraylist of books and read and write to the internal storage.

## **Installation Instructions**
### **System Requirements:**
- Android device with an internet connection

### **Installation:**
1. Allow your browser to install unknown apps. For additional help on this, follow these [instructions](https://www.lifewire.com/install-apk-on-android-4177185)
1. Download the APK file from the APK folder
3. Enjoy!

### **Running the application**
- User and admin have different usernames and passwords
    - User
        - Username: user
        - Password: pass
    - Admin
        - Username: admin
        - Password: pass
## **Team Members**
- Ethan Sturek - Project Manager
- Justin McKendry - Back-End Engineer
- Liam Stienstra - Front-End Engineer

## **WBS/Gantt**
Link is [here](https://app.smartsheet.com/sheets/mGMPcRX684vc3jw7CM2J5m2WWVm5q4RPqFGX4GC1?view=gantt)
