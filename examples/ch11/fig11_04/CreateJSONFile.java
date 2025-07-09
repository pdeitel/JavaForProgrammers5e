// Fig. 11.4: CreateJSONFile.java
// Writing data to a JSON file using the Jackson open-source library.
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

// record class to represent an account
record Account(int accountNumber, String name, double balance) {}

public class CreateJSONFile {
   public static void main(String[] args) {
      // account data to write to JSON
      List<Account> accounts = List.of(
         new Account(100, "Devi", 24.98),
         new Account(200, "Taylor", 345.67),
         new Account(300, "Huber", 0.00),
         new Account(400, "Ito", -42.16),
         new Account(500, "Lopez", 224.62)
      );

      // Path to clients.json in user's Documents folder
      Path filePath = Path.of(System.getProperty("user.home"), 
         "Documents", "clients.json");

      var mapper = new ObjectMapper(); // performs the serialization

      try {
         // Write accounts to a JSON file
         mapper.writeValue(filePath.toFile(), accounts);
         System.out.printf(
            "JSON file created at: %s%n", filePath.toAbsolutePath());
      } 
      catch (IOException e) {
         System.err.printf(
            "Error writing JSON file: %s%n", e.getMessage());
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
