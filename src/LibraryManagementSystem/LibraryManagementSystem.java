import java.io.*;
import java.util.*;
/**creating a class Book that contains relevant attributes */
 class Book {
    int bookID; //the unique identifier of the book
    String title; //the title of the book
    String author; //the author of the book
    String genre; //the genre of the book
    boolean availability; //the availabilty status of the book
/**creating a parametrized consructor for class Book */
     Book(int bookID, String title, String author, String genre, boolean availability) {
        //setting the Book class attributes to the provided values that the user inputs from keybord
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.availability = availability;
     }
    
/**creating a method for getting the book IDs and returning them */
    public int getBookID() {
        return bookID;
    }
/**creating a method for getting the book title and returning it */
    public String getTitle() {
        return title;
    }
/**creating a method for getting the book author and returning them */
    public String getAuthor() {
        return author;
    }
/**creaing a method for getting the book genre and returning them */
    public String getGenre() {
        return genre;
    }
/**creating a method for getting the books availability status and returning it */
    public boolean isAvailability() {
        return availability;
    }
/**creating a string that will return all the book information*/
    public String theString() {
        return "Book ID: " + bookID + ", Title:" + title + ", Author:" + author + ", Genre:" + genre +
               ", Availability:" + (availability ? "Available" : "Not Available");
    }
}

/**creating a class User that contains relevant attributes */
 class User {
    int userID; //the unique id for each user
    String name;//the name of the user
    String contactInfo; //the contact infomation of the user
    int[] borrowedBooks; //array for all the books the user has borrowed
    int borrowedBooksCount; //initially set to zero the count of the books te user has borrowed
/**parametrized constructor that takes an additional parameter for the mximum number of books one person can borrow*/
     User(int userID, String name, String contactInfo, int maxBorrowedBooks) {
         //setting the User class attributes to the provided values that the user inputs from keybord
        this.userID = userID;
        this.name = name;
        this.contactInfo = contactInfo;
        this.borrowedBooks = new int[maxBorrowedBooks];
        this.borrowedBooksCount = 0;
    }
/**method that will return the user id that the user inputs */
    public int getUserID() {
        return userID;
    }
/**method that will return the user name that the user inputs */
    public String getName() {
        return name;
    }
/**method that will return the user contact info that the user inputs */
    public String getContactInfo() {
        return contactInfo;
    }
/**method that will return the borrowed books array */
    public int[] getBorrowedBooks() {
        return borrowedBooks;
    }
/**method that will return the count for the borrowed books */
    public int getBorrowedBooksCount() {
        return borrowedBooksCount;
    }
/**method that assigns the book id to the borrowd books array and increments the count of borrowed books*/
    public void borrowBook(int bookID) {
        borrowedBooks[borrowedBooksCount++] = bookID;
    }
/**method that checks if book id matches the id that is in the borrowed book array and then decrements its value by one to show book has been returned*/
    public boolean returnBook(int bookID) {
        for (int i = 0; i < borrowedBooksCount; i++) {
            if (borrowedBooks[i] == bookID) {
                borrowedBooks[i] = borrowedBooks[--borrowedBooksCount];
                return true;
            }
        }
        /**reurns false if book id was not found in the array */
        return false;
    }
/**creating a string that will return all the user  information*/
    public String theString() {
        return "UserId:" + userID + ", Name:" + name + ", Contact Info:" + contactInfo;
    }
}
/**creating a library class  */
 class Library {
    Book[] books; //array to store book obhects in the library
    User[] users; //array to store user objects in the library
    int bookCount; //current count of books and users in the library
    int userCount;
/**creating a constructor that specifies the maximum number of books na dusers that the library will store */
    public Library(int maxBooks, int maxUsers) {
        this.books = new Book[maxBooks];    // Initialize the array to store Book objects with the specified maximum capacity.
        this.users = new User[maxUsers]; // Initialize the array to store User objects with the specified maximum capacity.
        this.bookCount = 0; //initialize both initially to 0
        this.userCount = 0;
    }
/**method that adds a book to the library by checking if book count is less than the maximum capacity of the library */
    public void addBook(Book book) {
        if (bookCount < books.length) {
            books[bookCount++] = book; // adds new book to the array if count is less
        } else {
            System.out.println("Cannot add more books. Library is full."); //if count is equal or more give error message
        }
    }
/**method that adds new user using the same logic as the add Book method */
    public void addUser(User user) {
        if (userCount < users.length) {
            users[userCount++] = user;
        } else {
            System.out.println("Cannot add more users. Library is full.");
        }
    }
/**method that finds a book according to its ID */
    public Book findBookByID(int bookID) {
        for (int i = 0; i < bookCount; i++) {//iterate through the books in the arrayuntil is the less than the total number of books
            if (books[i].getBookID() == bookID) { //checks if ID of books in array matches the specified id and returns that Book object if true
                return books[i];
            }
        }
        return null;//does not return if match is not found
    }
/** method taht finds a specific user by their ID follows the same logic as fing book by ID*/
    public User findUserByID(int userID) {
        for (int i = 0; i < userCount; i++) {
            if (users[i].getUserID() == userID) {
                return users[i];
            }
        }
        return null;
    }
/**method that searches books by name of book */
    public Book[] searchBooksByTitle(String title) {
        Book[] result = new Book[bookCount];// Create an array to store matching books with the same title.
        int count = 0;  // Initialize a counter to keep track of the number of matching books found.
        for (int i = 0; i < bookCount; i++) {// Iterate through the array of books in the library.
            if (books[i].getTitle().equalsIgnoreCase(title)) {// Check if the title of the current book matches the specified title (case-insensitive).
                result[count++] = books[i]; // If a match is found, add the Book object to the result array and increment the counter.
            }
        }
        // Return a copy of the result array containing only the matching books (excluding null entries).
        return Arrays.copyOf(result, count);
    }
/**maethod for searching books based on their author using same logic as search by title*/
    public Book[] searchBooksByAuthor(String author) {
        Book[] result = new Book[bookCount];
        int count = 0;
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getAuthor().equalsIgnoreCase(author)) {
                result[count++] = books[i];
            }
        }
        return Arrays.copyOf(result, count);
    }
/**method for user to check out book using parameters of the user checking the book out an dthe book being checked out */
    public void checkoutBook(int userID, int bookID) {
        // Find the Book object with the specified bookID in the library.
        Book book = findBookByID(bookID);
         // Find the User object with the specified userID in the library.
        User user = findUserByID(userID);
        // Check if the book, user, and the book's availability meet the conditions for checkout.
        if (book != null && user != null && book.isAvailability()) {
            // Set the availability of the book to false, indicating it is now checked out.
            book.availability = false;
            // Record the book's ID in the user's list of borrowed books.
            user.borrowBook(bookID);
            System.out.println("Book checked out successfully.");
        } else {
            System.out.println("Unable to checkout book.");// Print a message indicating that the book could not be checked out.
        }
    }
/**method that returns a book back to the library using same logic as check out book method */
    public void returnBook(int userID, int bookID) {
        Book book = findBookByID(bookID);
        User user = findUserByID(userID);
        if (book != null && user != null && !book.isAvailability() && user.returnBook(bookID)) {
            book.availability = true;
            System.out.println("Book returned successfully");
        } else {
            System.out.println("Unable to return book");
        }
    }
/**Displays information about the books in the library. gives message if no books in libarary */
    public void displayBooks() {
        if (bookCount == 0) {// Check if there are no books in the library.
            System.out.println("No books in the library");// If no books, print a message indicating that there are no books in the library.
        } else {
            System.out.println("Books in the library:");// If there are books, print a header indicating that the following are the books in the library.
            for (int i = 0; i < bookCount; i++) {// Iterate through the array of books in the library.
                System.out.println(books[i].theString());//print the array
            }
        }
    }
/**Loads library data from a file using ObjectInputStream.
 * Reads the serialized Library object and updates the current library's state.
 */
    public void loadLibraryFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("library.data"))) {
            Library loadedLibrary = (Library) ois.readObject();// Read the serialized Library object from the file.
            this.books = loadedLibrary.books;// Update the current library's state with the loaded data.
            this.users = loadedLibrary.users;
            System.out.println("Library data loaded successfully");// Print a success message indicating that the library data was loaded successfully.
        } catch (FileNotFoundException e) {
            System.out.println("No existing library data found.");// Print a message if no existing library data file is found.
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading library data: " + e.getMessage());// Print an error message if an exception occurs during the loading process.
        }
    }
/**
 * Saves the current library data to a file using ObjectOutputStream.
 * Serializes the Library object and writes it to a file named "library.data."
 */
    public void saveLibraryToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("library.data"))) {
           // Serialize and write the current library object to the file.
            oos.writeObject(this);
            System.out.println("Library data saved successfully");// Print a success message indicating that the library data was saved successfully.
        } catch (IOException e) {
            // Print an error message if an exception occurs during the saving process.
            System.out.println("Error saving library data: " + e.getMessage());
        }
    }
}
   /**Main class */
public class LibraryManagementSystem {
    //Main function
    public static void main(String[] args) {
      // Create a new Library object with a maximum capacity for 100 books and 100 users.
        Library library = new Library(100, 100);
        //load library data from a file named "library.data".
        library.loadLibraryFromFile();
//to take input from user aboutthe menu option they want to choose
        Scanner input = new Scanner(System.in);


        int choice;//variable that store sthe choice of the user
        // Infinite loop to keep the menu running until the user chooses to exit.
        while (true) {
            // Display the main menu options for the library management system.
            System.out.println("Welcome to the library management system!");
            System.out.println("1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. Display Books");
            System.out.println("4. Return Books");
            System.out.println("5. Search Book by author");
            System.out.println("6. Search Book by title");
            System.out.println("7. Check out Books");
            System.out.println("8. Exit");
            System.out.println("Please enter your choice.");
        
            try {
                // Read the user's choice.
                choice = input.nextInt();
                input.nextLine();  // Consume the newline character
        
                // Switch statement to handle different user choices.
                switch (choice) {
                    case 1:
                        addBook(library, input);
                        break;
                    case 2:
                        addUser(library, input);
                        break;
                    case 3:
                        library.displayBooks();
                        break;
                    case 4:
                        returnBook(library, input);
                        break;
                    case 5:
                        searchBookByAuthor(library, input);
                        break;
                    case 6:
                        searchBookByTitle(library, input);
                        break;
                    case 7:
                        checkoutBook(library, input);
                        break;
                    case 8:
                        library.saveLibraryToFile();
                        System.out.println("Exiting the system");
                        System.exit(0);  // Exiting the program
                    default:
                        System.out.println("Invalid input. Enter a number");
                        break;
                }
            } catch (InputMismatchException e) {
                // Handle the case where the user enters something that is not a number.
                System.out.println("Invalid input. Please enter a number");
                input.nextLine();  // Clear the input buffer
            }
        }
    }
        
    private static void addBook(Library library, Scanner input) {
        // Prompt the user to enter the book ID.
        System.out.println("Enter book ID:");
        int bookID;
        // Loop until valid input is provided.
        while (true) {
            try {
                // Read the book ID from the input.
                bookID = input.nextInt();
                input.nextLine();  // Consume the newline character
                // Check if the book ID already exists in the library.
                if (library.findBookByID(bookID) != null) {
                    System.out.println("Book ID already exists. Please enter a different ID:");
                    continue; // Prompt the user to enter a different ID.
                }
                break;  // Exit the loop if input is valid
            } catch (InputMismatchException e) {
                // Handle the case where the input is not a valid integer.
                System.out.println("Invalid input. Please enter a valid book ID:");
                input.nextLine();  // Clear the input buffer
            }
        }
    
        // Prompt the user to enter the title.
        System.out.println("Enter title:");
        String title = input.nextLine();
        // Check if the title is empty.
        if (title.isEmpty()) {
            System.out.println("Title cannot be empty. Please enter a valid title:");
            return; // Exit the function if the title is empty.
        }
    
        // Prompt the user to enter the author's name.
        System.out.println("Enter name of the author:");
        String author = input.nextLine();
        // Check if the author's name is empty.
        if (author.isEmpty()) {
            System.out.println("Author name cannot be empty. Please enter a valid author name:");
            return; // Exit the function if the author's name is empty.
        }
    
        // Prompt the user to enter the genre.
        System.out.println("Enter genre:");
        String genre = input.nextLine();
        // Check if the genre is empty.
        if (genre.isEmpty()) {
            System.out.println("Genre cannot be empty. Please enter a valid genre:");
            return; // Exit the function if the genre is empty.
        }
    
        // Create a new Book object with the provided information and set its availability to true.
        Book book = new Book(bookID, title, author, genre, true);
        // Call the addBook method of the library to add the new book.
        library.addBook(book);
        // Print a success message indicating that the book was added successfully.
        System.out.println("Book added successfully");
    }
    
/**Adds a new user to the library based on user input. */
static void addUser(Library library, Scanner input) {
    // Prompt the user to enter the user details and read the input.
    System.out.println("Enter user ID:");
    int userID;
    while (true) {
        try {
            userID = input.nextInt();
            input.nextLine();  // Consume the newline character
            // Check if the user ID is already in use
            if (library.findUserByID(userID) != null) {
                System.out.println("User ID already exists. Please enter a different ID:");
                continue;
            }
            break;  // Exit the loop if input is valid
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid user ID:");
            input.nextLine();  // Clear the input buffer
        }
    }

    // Prompt the user to enter the name.
    System.out.println("Enter name:");
    String name = input.nextLine();
    // Check if the name is empty.
    if (name.isEmpty()) {
        System.out.println("Name cannot be empty. Please enter a valid name:");
        return;
    }

    // Prompt the user to enter the contact info.
    System.out.println("Enter contact info:");
    String contactInfo = input.nextLine();
    // Check if the contact info is empty.
    if (contactInfo.isEmpty()) {
        System.out.println("Contact info cannot be empty. Please enter valid contact info:");
        return;
    }

    // Create a new User object with the provided information, assuming maxBorrowedBooks is 5.
    User user = new User(userID, name, contactInfo, 5);  // Assuming maxBorrowedBooks is 5
    // Call the addUser method of the library to add the new user.
    library.addUser(user);
    System.out.println("User added successfully");
}

    
/**Handles the process of a user returning a book to the library based on user input. */
     static void returnBook(Library library, Scanner input) {
        System.out.println("Enter user ID:");
        int userID = input.nextInt();
        System.out.println("Enter book ID:");
        int bookID = input.nextInt();
        // Call the returnBook method of the library to handle the book return process.
        library.returnBook(userID, bookID);
    }
/**Searches for books by a specific author in the library and displays the results. */
     static void searchBookByAuthor(Library library, Scanner input) {
        System.out.println("Enter author name:");
        String author = input.next();
        // Call the searchBooksByAuthor method of the library to retrieve matching books.
        Book[] result = library.searchBooksByAuthor(author);
        // Display the search results using the displaySearchResults method.
        displaySearchResults(result);
    }

     static void searchBookByTitle(Library library, Scanner input) {
        System.out.println("Enter book title:");
        String title = input.next();
        Book[] result = library.searchBooksByTitle(title);
        displaySearchResults(result);
    }
/**works in the same manner search book by title method works  */
static void checkoutBook(Library library, Scanner input) {
    System.out.println("Enter user ID:");
    int userID;
    while (true) {
        try {
            userID = input.nextInt();
            input.nextLine();  // Consume the newline character
            // Check if the user exists in the library.
            if (library.findUserByID(userID) == null) {
                System.out.println("User not found. Please enter a valid user ID:");
                continue;
            }
            break;  // Exit the loop if input is valid
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid user ID:");
            input.nextLine();  // Clear the input buffer
        }
    }

    System.out.println("Enter book ID:");
    int bookID;
    while (true) {
        try {
            bookID = input.nextInt();
            input.nextLine();  // Consume the newline character
            // Check if the book exists in the library and is available.
            Book book = library.findBookByID(bookID);
            if (book == null) {
                System.out.println("Book not found. Please enter a valid book ID:");
                continue;
            }
            if (!book.isAvailability()) {
                System.out.println("Book is not available for checkout.");
                continue;
            }
            break;  // Exit the loop if input is valid
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid book ID:");
            input.nextLine();  // Clear the input buffer
        }
    }

    // Call the checkoutBook method of the library to handle the checkout process.
    library.checkoutBook(userID, bookID);
}

/**Displays the results of a book search to the user. */
     static void displaySearchResults(Book[] result) {
         // Check if there are no books in the search results.
        if (result.length == 0) {
            //prints message if matching books are not found
            System.out.println("No matching books found.");
        } else {
            System.out.println("Matching books:");
            //iterates through the array of books and prints their details
            for (Book book : result) {
                System.out.println(book.theString());
            }
        }
    }
}

