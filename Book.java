//Java program to illustrate book Class that takes Input from the books and related information.

import java.util.Scanner;

public class Book{
    //class data members
    public int sNo;
    public String bookName;
    public String authorName;
    public int bookQty;
    public int bookQtyCopy;

    Scanner input = new Scanner(System.in);

    //constructor to add book details
    public Book(){
        System.out.println("Enter Serial No of Book: ");
        this.sNo = input.nextInt();
        input.nextLine(); //for resolving the buffer value.

        System.out.println("Enter Book Name: ");
        this.bookName = input.nextLine();

        System.out.println("Enter Author Name: ");
        this.authorName = input.nextLine();

        System.out.println("Enter Quantity of Books: ");
        this.bookQty = input.nextInt();
        bookQtyCopy = this.bookQty;
    }
}