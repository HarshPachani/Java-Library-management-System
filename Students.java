import java.util.Scanner;

import javax.swing.text.AbstractDocument.Content;

public class Students {
    //creating object of Scanner and Student class
    Scanner input = new Scanner(System.in);
    Student theStudent[] = new Student[50]; //This is array of object.

    public static int count = 0;

    //Method 1 to add books
    public void addStudent(Student s){
        for (int i = 0; i < count; i++) {
            if(s.regNum.equalsIgnoreCase(theStudent[i].regNum)){
                System.out.println("Student of Reg Num: " + s.regNum + "is Ready Registered.");
                return;
            }
        }
        if(count <= 50){
            theStudent[count] = s;
            count++;
        }
    }

    //Method 2 Displaying all students
    public void showAllStudents(){
        System.out.println("Student Name\t\tReg Number");
        for (int i = 0; i < count; i++) {
            System.out.println(theStudent[i].studentName +"\t\t" + theStudent[i].regNum);
        }
    }

    //Method 3 to check the student
    public int isStudent(){
        System.out.println("Enter Register number: ");
        String regNum = input.nextLine();

        for (int i = 0; i < count; i++) {
            if(theStudent[i].regNum.equalsIgnoreCase(regNum)){
                return i;
            }
        }
        System.out.println("Student is not Registered.");
        System.out.println("Get Registered First.");

        return -1;
    }

    //Method 4 to remove the book
    public void checkOutBook(Books books){
        int studentIndex = this.isStudent();
        if(studentIndex != -1){
            System.out.println("Checking out");
            books.showAllBooks();
            Book b = books.checkOutBook();

            System.out.println("Checking out");
            if(b != null){
                if(theStudent[studentIndex].booksCount <= 3){
                    System.out.println("Adding Book");
                    theStudent[studentIndex].borrowedBooks[theStudent[studentIndex].booksCount] = b;
                    theStudent[studentIndex].booksCount++;
                    
                    return;
                }else{
                    System.out.println("Student Can not Borrow more than 3 Books.");
                    return;
                }
            }
            System.out.println("Book is not Available.");
        }
    }

    //Method 5 to add the book
    public void checkInBook(Books book){
        int studentIndex = this.isStudent();
        if(studentIndex != -1){
            System.out.println("S.No\t\t\tBook Name\t\t\tAuthor Name");
            Student s = theStudent[studentIndex];

            for (int i = 0; i < s.booksCount; i++) {
                System.out.println(s.borrowedBooks[i].sNo + "\t\t\t" 
                            + s.borrowedBooks[i].bookName + "\t\t\t"
                            + s.borrowedBooks[i].authorName);
            }

            System.out.println("Enter Serial Number of Book to be Checked In: ");
            int sNo = input.nextInt();

            for (int i = 0; i < s.booksCount; i++) {
                if(sNo == s.borrowedBooks[i].sNo){
                    book.checkInBook(s.borrowedBooks[i]);
                    s.borrowedBooks[i] = null;
                    return;
                }
            }
            System.out.println("Book of Serial No " +sNo + " not found");
        }
    }
}
