import java.util.Scanner;

public class Student {
    //class member variables
    String studentName;
    String regNum;
    
    Book borrowedBooks[] = new Book[3];
    public int booksCount = 0;

    Scanner input = new Scanner(System.in);

    //Constructor
    public Student(){
        System.out.println("Enter student Name: ");

        this.studentName = input.nextLine();

        System.out.println("Enter Registration Number: ");
        this.regNum = input.nextLine();
    }
}
