## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

Library Management System
This Java program implements a simple Library Management System that allows users to manage books and users in a library. The system provides functionalities such as adding books and users, displaying available books, searching for books by title or author, checking out books, and returning books.

Classes
1. Book
Represents a book in the library.
Attributes include bookID, title, author, genre, and availability.
Provides methods to retrieve information about the book.
2. User
Represents a library user.
Attributes include userID, name, contactInfo, borrowedBooks, and borrowedBooksCount.
Provides methods for borrowing and returning books.
3. Library
Manages the collection of books and users in the library.
Provides methods for adding books and users, searching for books, checking out and returning books, and displaying library information.
Supports loading and saving library data to a file using serialization.
4. LibraryManagementSystem (Main Class)
Implements the main menu for the library management system.
Allows users to interact with the system by choosing various options such as adding books, adding users, searching for books, and more.
How to Use
Run the program (LibraryManagementSystem.java) in a Java environment.
Choose options from the main menu to perform different operations in the library.
Features
Add new books and users to the library.
Display available books in the library.
Search for books by title or author.
Check out and return books.
Load and save library data to a file for persistent storage.
File Handling
The program supports loading and saving library data to a file named "library.data" using ObjectInputStream and ObjectOutputStream.
Note
The system assumes a maximum capacity for books and users (100 each).
Users are limited to borrowing a specified maximum number of books.
