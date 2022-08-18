import java.util.Scanner;

public class Library {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("**************************Welcome to the Library**************************");
        System.out.println("Select an Option: ");

        //creating an object of books class
        Books books = new Books();
        //Creating object of student class
        Students student = new Students();

        int choice;
        int searchChoice;

        do{
            books.displayMenu();
            choice = input.nextInt();
            switch(choice){
                case 0:
                    System.out.println("You exited Successfully!");
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
    }
}