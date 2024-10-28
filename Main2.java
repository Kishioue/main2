public class Main {
  public static void main(String[] args) {
      String text = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
      
      // Assign a best-case scenario (empty string)
      String bestCase = ""; 

      // Initialize startTime for best-case scenario
      long startTime = System.nanoTime();
      int index = match(text, bestCase);
      // Initialize endTime for best-case scenario
      long endTime = System.nanoTime();
      
      // Calculate elapsedTime for best-case scenario
      long elapsedTime = endTime - startTime;
      
      if (index >= 0)
          System.out.println("best-case input matched at index " + index);
      else
          System.out.println("best-case input unmatched");   
      
      // Assign a worst-case scenario (text + one extra character that doesn't match)
      String worstCase = text + "!"; 
      
      // Initialize startTime for worst-case scenario
      startTime = System.nanoTime();
      index = match(text, worstCase);
      // Initialize endTime for worst-case scenario
      endTime = System.nanoTime();
      
      // Calculate elapsedTime for worst-case scenario
      elapsedTime = endTime - startTime;
      
      if (index >= 0)
          System.out.println("worst-case input matched at index " + index);
      else
          System.out.println("worst-case input unmatched");  
      
      // Output the elapsed times
      System.out.println("Elapsed time for best-case: " + elapsedTime + " nanoseconds");
      System.out.println("Elapsed time for worst-case: " + elapsedTime + " nanoseconds");
  }

  // Return the index of the first match. -1 otherwise.
  public static int match(String text, String pattern) {
      for (int i = 0; i < text.length() - pattern.length() + 1; i++) {
          if (isMatched(i, text, pattern))
              return i;
      }

      return -1;
  }
  
  // Test if pattern matches text starting at index i
  private static boolean isMatched(int i, String text, String pattern) {
      for (int k = 0; k < pattern.length(); k++) {
          if (pattern.charAt(k) != text.charAt(i + k)) {
              return false;
          }
      }
      
      return true;
  }
}