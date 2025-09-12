import java.io.*;

public class Main{

    static void AddBook(String[] arr, BufferedReader reader) throws IOException{

        String book_name;
        System.out.print("Enter the book's name:");
        book_name = reader.readLine();
        for(int x = 0; x < arr.length; x++){
            if(arr[x] == null){
                arr[x] = book_name;
                break;
            }
        }

        System.out.println("NOTICE: LIBRARY IS ALREADY FULL!!");
    }

    static boolean ScanBook(String[] arr, BufferedReader reader) throws IOException {

        String book_name;
        System.out.print("Enter the book's name to scan:");
        book_name = reader.readLine();

        for (String book : arr) {
            if(book != null) {
                if (book.equals(book_name)) {
                    return true;
                }
            }else{
                break;
            }
        }

        return false;

    }

    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] books = new String[100];
        boolean isRunning = true;

        while(isRunning){
            String str_choice;
            int choice;
            System.out.println("SIMPLE MENU-DRIVEN LIBRARY SYSTEM");
            System.out.println("1.Add a book.");
            System.out.println("2.Display all books.");
            System.out.println("3.Search for a book by title.");
            System.out.println("4.Display the number of books in the library.");
            System.out.println("5.Exit the program.");
            System.out.print("Enter choice:");
            str_choice = reader.readLine();
            choice = Integer.parseInt(str_choice);

            switch(choice){
                case 1:
                    AddBook(books, reader);
                    break;
                case 2:
                    for(int x = 0; x < books.length; x++){
                        if(books[x] != null){
                            System.out.println("Book #" +(x + 1) + ": " + books[x]);
                        }
                        else{
                            break;
                        }

                    }
                    break;
                case 3:
                    if(ScanBook(books, reader)){
                        System.out.println("This book is on the library");
                    }else{
                        System.out.println("This book is not on the library");
                    }
                    break;
                case 4:
                    int num_books = 0;
                    for(String book : books){
                        if(book != null){
                            num_books += 1;
                        }else{
                            break;
                        }
                    }
                    System.out.println("Number of books in the library: " + num_books);
                    break;
                case 5:
                    System.out.println("CLOSING THE PROGRAM.....");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }

    }
}
