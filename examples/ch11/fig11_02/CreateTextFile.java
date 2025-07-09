// Fig. 11.2: CreateTextFile.java
// Writing data to a sequential text file with class Formatter.
import java.util.Formatter;               
import java.nio.file.Path;
import java.util.List;
import java.io.IOException;
// record class to represent an account
record Account(int accountNumber, String name, double balance) {}

public class CreateTextFile {
   public static void main(String[] args) {
      // account data to write to a text file
      List<Account> accounts = List.of(
         new Account(100, "Devi", 24.98),
         new Account(200, "Taylor", 345.67),
         new Account(300, "Huber", 0.00),
         new Account(400, "Ito", -42.16),
         new Account(500, "Lopez", 224.62)
      );

      // Path to clients.txt in the user's Documents folder
      Path filePath = Path.of(System.getProperty("user.home"), 
         "Documents", "clients.txt");

      // open clients.txt, output data to the file then close clients.txt
      try (var output = new Formatter(filePath.toString())) {
         // output each Account to file
         for (var account : accounts) {
            output.format("%d %s %.2f%n", account.accountNumber(), 
               account.name(), account.balance());
         } 

         System.out.printf(
            "Text file created at: %s%n", filePath.toAbsolutePath());
      }
      catch (IOException e) {
         System.err.printf(
            "Error writing text file: %s%n", e.getMessage());
      } 
   } 
}



/*************************************************************************
* (C) Copyright 1992-2025 by Deitel & Associates, Inc. and               *
* Pearson Education, Inc. All Rights Reserved.                           *
*                                                                        *
* DISCLAIMER: The authors and publisher of this book have used their     *
* best efforts in preparing the book. These efforts include the          *
* development, research, and testing of the theories and programs        *
* to determine their effectiveness. The authors and publisher make       *
* no warranty of any kind, expressed or implied, with regard to these    *
* programs or to the documentation contained in these books. The authors *
* and publisher shall not be liable in any event for incidental or       *
* consequential damages in connection with, or arising out of, the       *
* furnishing, performance, or use of these programs.                     *
*************************************************************************/
