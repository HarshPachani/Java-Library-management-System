import java.util.InputMismatchException;
import java.util.Scanner;

import javax.xml.catalog.Catalog;

public class Library {
    public static void main(String[] args) throws ClassNotFoundException{
        Scanner input = new Scanner(System.in);
        System.out.println("*************************************************Welcome to the Library*************************************************");
        System.out.println("Select an Option: ");

        try{
            //creating an object of books class
        Books books = new Books();
            try{
            //Creating object of student class
            Students student = new Students();

            int choice = 0;
            int searchChoice;

            do{
                books.displayMenu();
                try{
                    choice = input.nextInt();
                }catch(InputMismatchException e){
                    System.out.println("Only Numbers are Allowed as an input here.");
                }
                
                switch(choice){
                    case 0:
                        System.out.println("You exited Successfully!");
                        break;
                    case 1:
                        Book b = new Book(); //object of Book class.
                        books.addBook(b);
                        break;

                    case 2:
                        books.upgradeBookQty();
                        break;

                    case 3:
                        System.out.println("Press 1 to search with Book Serial No.");
                        System.out.println("Press 2 to search with Book's Author Name.");
                        searchChoice = input.nextInt();
                        switch(searchChoice){
                            case 1:
                                books.searchBySno();
                                break;

                            case 2:
                                books.searchByAuthorName();
                        }
                        break;
                    
                    case 4:
                        books.showAllBooks();
                        break;

                    case 5:
                        Student s = new Student();
                        student.addStudent(s);
                        break;

                    case 6:
                        student.showAllStudents();
                        break;

                    case 7:
                        student.checkOutBook(books);
                        break;

                    case 8:
                        student.checkInBook(books);
                        break;
                    
                    default:
                        System.out.println("Enter a valid number!");
                }
            }while(choice != 0);
        }catch(Exception e){
            System.out.println("Class not found Exception.");
        }
        input.close();
        }catch(Exception e){
            System.out.println("Class we are trying to use is not found!!");            
        }
    }
}
