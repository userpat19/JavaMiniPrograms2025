import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class new_program {
    public static void main(String[] args) {
        // Your initials
        String initials = "CMSC";
        String fileName = initials + ".txt";

        try {
            // This will CREATE the file, or OVERWRITE it if it already exists
            PrintWriter outStream = new PrintWriter(fileName);

            // Sample message
            String message = "This output is written to the file " + fileName;

            // Write to the text file
            outStream.println(message);

            // Also display the same output on the screen
            System.out.println(message);

            // Close the stream
            outStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error opening file: " + e.getMessage());
        }
    }
}