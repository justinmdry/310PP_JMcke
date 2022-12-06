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

## **Iteration 2 Specifications and Limitations**
- ### **Advanced Login**
    Users can now create different accounts that will save books specifically to them. Admin only has 1 universal account. Accounts are limited to a local device. Future iterations could utilize a cloud base system for accounts.

- ### **Search**
   Users can now search for a specific book, author, or genre within the user search page.

- ### **Report System**
    Users can now report damages on a certain book and include a description. Admins can view reported damage tickets and resolve them.

- ### **Advanced Book View**
    Users can now click on a book to view more in depth information

- ### **Descriptions**
    Books now have descriptions that give a brief summary of what it is about. Admin must now give a description when adding a book.

- ### **Open Source Libraries**
    
    - #### Calligraphy
    Allows for custom fonts that improve the look of buttons and text in a fast manner
    
    - #### Dynamic Toasts
    Improves the look of toast messages to provide better feedback to the user
## **Class Organization**
All classes function as activities within the android studio project. We have additional objects used to store data including: Book (stores book info), Booklist (A list of current books), ReportObj (Reported damage), ReportList (List of reports), Account (Stores login info for user) and AccountList (List of all accounts).

## **Installation Instructions**
### **System Requirements:**
- Android device with an internet connection

### **Installation:**
1. Allow your browser to install unknown apps. For additional help on this, follow these [instructions](https://www.lifewire.com/install-apk-on-android-4177185)
1. Download the APK file from the APK folder
3. Enjoy!

### **Running the application**
- Create an account to access user functionality.
    - Type in a username and password and press create account
    - To view admin, type in the following credentials
        - Username: admin
        - Password: pass
## **Team Members**
- Justin McKendry

## **New Apis for Personal project**
1. Google accounts api
- I apptempted to use Google accounts api to allow the user to log in or create an account based on if they have one already from their email and name on the Google account.
2. Facebook accounts api
- I apptempted to use Facebook accounts api to allow the user to log in or create an account based on if they have one already from their email and name from their Facebook account.

## **WBS/Gantt**
Link is [here](https://app.smartsheet.com/sheets/xm29X9Rc6PxrWWwhF9WVj38wqQ9vQHjcq3wF8491?view=grid)
