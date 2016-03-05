
import java.io.*;
import java.util.Arrays;
import java.util.ArrayList;

/* Author: Gloria Ngan
 * 
 * This is the class that acts as the library, holding
 * the books and allowing interactions with the books
 * using methods to add, remove, borrow, return, and
 * browse the books.
 */

public class Library{
  //Untested; ArrayList of Strings or Book objects???.
  private ArrayList<Book> database = new ArrayList<Book>();     //Holds all books.
  
  //Method to import books from a .txt file.
  public void importBook(String fileName){
    String file = fileName;     // The file to open.
    String line;
    
    try {
      // FileReader reads text files in the default encoding.
      FileReader fileReader = new FileReader(file);
      
      //Wrap FileReader in BufferedReader.
      BufferedReader bufferedReader = new BufferedReader(fileReader);
      
      //Saves each line as a book object.
      while((line = bufferedReader.readLine()) != null) {
        String[] str = line.split(", ");
        String ISBN = str[0];
        String title = str[1];
        String author = str[2];
        String genre = str[3];
        String status = str[4];
        Book book = new Book(ISBN, title, author, genre, status);
        
        database.add(book);
      }   
      
      bufferedReader.close();   //Close file.      
    }
    catch(FileNotFoundException ex) {
      System.out.println("Unable to open file '" + file + "'");                
    }
    catch(IOException ex) {
      System.out.println("Error reading file '" + file + "'");                  
    }    
  }
  
  //Modifier method to add a books to database.
  public void addNewBook(Book book){
    database.add(book);
  }
  
  //Modifier method to remove books from database.
  public void removeOldBook(Book book){
    database.remove(book);
  }
  
  //Method to mark a book as borrowed if it is available.
  public void borrowBook(Book book){
    book.makeBorrowed();
  }
  
  public void returnBook(Book book){
    book.makeReturned();
  }
  
  //Method to display all books in the library.
  public void browse(String genre){
    //TODO
  }
}
