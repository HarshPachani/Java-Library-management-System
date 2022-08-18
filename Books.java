import java.util.Scanner;

public class Books {
    //class data members
    Book theBooks[] = new Book[50]; //Array of an object.
    public static int count;

    Scanner input = new Scanner(System.in);

    //method 1 to compare books
    public int compareBookObjects(Book b1, Book b2){
        //if book name maches
        if(b1.bookName.equals(b2.bookName)){
            System.out.println("Book of this name Already Exists.");
            return 0;
        }

        //if book serial matches.
        if(b1.sNo == b2.sNo){
            System.out.println("Book of this Serial No Already exists.");
            return 0;
        }
        return 1;
    }

    //Method 2 to add book
    public void addBook(Book b){
        for (int i = 0; i < count; i++) {
            if(this.compareBookObjects(b, this.theBooks[i]) == 0){
                return;
            }

            if(count < 50){
                theBooks[count] = b;
                count++;
            }else{
                System.out.println("No Space to Add More Books");
            }
        }
    }

    //Method 3 To search book by serial number
    public void searchBySno(){
        System.out.println("\t\t\t\tSEARCH BY SERIAL NUMBER\n");

        //class data members
        int sNo;
        System.out.println("Enter Serial No of Book");
        sNo = input.nextInt();

        int flag = 0;
        System.out.println("S.No\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");
        for (int i = 0; i < count; i++) {
            if(sNo == theBooks[i].sNo){
                System.out.println(theBooks[i].sNo + "\t\t"
                + theBooks[i].bookName + "\t\t" 
                + theBooks[i].authorName + "\t\t"
                + theBooks[i].bookQtyCopy + "\t\t"
                + theBooks[i].bookQty);
                flag++;
                return;
            }
        }
        if(flag == 0)
            System.out.println("No Book for Serial No " + sNo + " Found.");
    }

    //Method 4 To search book by author name
    public void searchByAuthorName(){
        System.out.println("\t\t\t\tSEARCH BY AUTHOR NAME");
        input.nextLine();

        System.out.println("Enter Author Name: ");
        String authorName = input.nextLine();

        int flag = 0;
        System.out.println("S.No\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");
        for (int i = 0; i < count; i++) {
            if(authorName.equalsIgnoreCase(theBooks[i].authorName)){
                System.out.println(theBooks[i].sNo + "\t\t"
                + theBooks[i].bookName + "\t\t" 
                + theBooks[i].authorName + "\t\t"
                + theBooks[i].bookQtyCopy + "\t\t"
                + theBooks[i].bookQty);
                flag++;
            }
        }
        if(flag == 0)
            System.out.println("No Book of " + authorName + " Found.");
    }

    //Method 5 to display all books
    public void showAllBooks(){
        System.out.println("\t\t\t\tSHOWING ALL BOOKS\n");
        System.out.println("S.No\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");
        for (int i = 0; i < count; i++) {
            
            System.out.println(theBooks[i].sNo + "\t\t"
            + theBooks[i].bookName + "\t\t" 
            + theBooks[i].authorName + "\t\t"
            + theBooks[i].bookQtyCopy + "\t\t"
            + theBooks[i].bookQty);
        }
    }

    //Method 6 to edit the book
    public void upgradeBookQty(){
        System.out.println("\t\t\t\tUPGRADE QUANTITY OF A BOOK\n");
        System.out.println("Enter Serial No of Book");
        int sNo = input.nextInt();

        for (int i = 0; i < count; i++) {
            if(sNo == theBooks[i].sNo){
                System.out.println("Enter No of Books to be Added: ");
                int addingQty = input.nextInt();
                theBooks[i].bookQty += addingQty;
                theBooks[i].bookQtyCopy += addingQty;

                return;
            }
        }
    }

    //Method 7 To create menu.
    public void displayMenu(){
        System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.println("Press 0 to Exit Application");
        System.out.println("Press 1 to Add new Book.");
        System.out.println("Press 3 to Search a Book.");
        System.out.println("Press 4 to Show All Books.");
        System.out.println("Press 5 to Register Student.");
        System.out.println("Press 6 to Show All Registered Students.");
        System.out.println("Press 7 to Check Out Book.");
        System.out.println("Press 8 to Check In Book.");
        System.out.println("--------------------------------------------------------------------------------------------------");
    }

    //Method 8 To search the library
    public int isAvailable(int sNo){
        for (int i = 0; i < count; i++) {
            if(sNo == theBooks[i].sNo){
                if(theBooks[i].bookQtyCopy > 0){
                    System.out.println("Book is Available.");
                    return i;
                }
                System.out.println("Book is Unavailable");
                return -1;
            }
        }
        System.out.println("No Book of Serial Number "+ sNo + "Available in Library.");
        return -1;
    }

    //Method 9 to remove the book from the library
    public Book checkOutBook(){
        System.out.println("Enter Serial No of Book to be Checked Out.");
        int sNo = input.nextInt();

        int bookIndex = isAvailable(sNo);

        if(bookIndex != -1){
            theBooks[bookIndex].bookQtyCopy--;
            return theBooks[bookIndex];
        }
        return null;
    }

    //Method 10 To add the Book to the Library
    public void checkInBook(Book b){
        for (int i = 0; i < count; i++) {
            if(b.equals(theBooks[i])){
                theBooks[i].bookQtyCopy++;
                return;
            }
        }
    }
}