/**
 * Problem Set 5.
 *
 * It's time to put your skills to the test. This problem set focuses on using
 * built-in methods, most notable of the String class. It is also your first
 * introduction to methods that accept parameters and return values. The main
 * method is declared, but it is up to you to implement. Write your code for each
 * exercise in the corresponding method. Make sure you test your code thoroughly.
 *
 * The specifications for each exercise are outlined below. Your job is to write
 * lines of code to produce answers to my questions. Each exercise requires that
 * you ask the user to enter one or more values. Your code must meet the
 * requirements set forth in this section.
 *
 * Work through these exercises on your own. Experiment, make mistakes, ask
 * questions, and fix your mistakes. It's the only way to get good at programming.
 */

public class ProblemSet5 {

    public static void main(String[] args) {

      ProblemSet5 ps = new ProblemSet5();
      System.out.println(ps.surroundMe("abc", "123"));
      System.out.println(ps.endsMeet("abc", -1));
      System.out.println(ps.middleMan("a"));
      System.out.println(ps.isCentered("abcdefg", "cd"));
      System.out.println(ps.countMe("abc$ def$ $", '$'));
      System.out.println(ps.triplets(null));
      System.out.println(ps.addMe(null));
      System.out.println(ps.sequence(null));
      System.out.println(ps.intertwine(null, null));
      System.out.println(ps.isPalindrome(null));

    }

    /*
     * Exercise 1.
     *
     * Given two strings, return a new string built by surrounding in with the first
     * and last two characters of out.
     */

    public String surroundMe(String in, String out) {

      if (in == null || out == null || out.length() != 4) {
        return in;
      }

      String outBeg = out.substring(0, 2);
      String outEnd = out.substring(2, 4);

      return outBeg + in + outEnd;

    }

    /*
     * Exercise 2.
     *
     * Given a string and an integer, return a new string that represents the first
     * and last n characters of text.
     */

    public String endsMeet(String text, int n) {

      if (text == null || text.length() < 1 || text.length() > 10 || n < 1 || n > text.length()) {
        return text;
      }

      String textBeg = text.substring(0, n);
      String textEnd = text.substring(text.length() - n, text.length());

      return textBeg + textEnd;

    }

    /*
     * Exercise 3.
     *
     * Given a string, return a new string using the middle three characters of text.
     */

    public String middleMan(String text) {

      if (text == null || text.length() < 3 || text.length() % 2 == 0) {
        return text;
      }

      String middleText = text.substring(text.length() / 2 - 1, text.length() / 2 + 2);

      return middleText;

    }

    /*
     * Exercise 4.
     *
     * Given two strings, determine whether or not target is equivalent to the middle
     * three characters of text.
     */

    public boolean isCentered(String text, String target) {

      if (text == null || text.length() % 2 == 0 || text.length() < 3 || target == null || target.length() != 3) {
        return false;
      }

      String middleText = text.substring(text.length() / 2 - 1, text.length() / 2 + 2);

      if (middleText.equals(target)) {
        return true;
      } else {
        return false;
      }

    }

    /*
     * Exercise 5.
     *
     * Given a string and a character, compute the number of words that end in suffix.
     */

    public int countMe(String text, char suffix) {

      if (text == null || !Character.isLetter(suffix)) {
        return -1;
      }

      int wordCount = 0;

      for (int i = 0; i < text.length() - 1; i ++) {
            if (text.charAt(i + 1) == ' ' && text.charAt(i) == suffix) {
                wordCount++;
            }
      }

      if (text.charAt(text.length() - 1) == suffix) {
            wordCount ++;
      }

      return wordCount;

    }

    /*
     * Exercise 6.
     *
     * Given a string, compute the number of triplets in text.
     */

    public int triplets(String text) {

      if (text == null) {
        return -1;
      }

      int tripletCount = 0;

      for (int i = 0; i < text.length() - 2; i++) {
        char letterFirst = text.charAt(i);
        char letterSecond = text.charAt(i + 1);
        char letterThird = text.charAt(i + 2);
        if (letterFirst == letterSecond && letterFirst == letterThird) {
          tripletCount++;
        }
      }

        return tripletCount;

    }

    /*
     * Exercise 7.
     *
     * Given a string, compute the sum of the digits in text.
     */

    public long addMe(String text) {

      if (text == null) {
        return -1;
      }

      int sum = 0;

      for (int i = 0; i < text.length(); i++) {
        char character = text.charAt(i);
        if (Character.isDigit(character)) {
          int number = Character.getNumericValue(character);
          sum += number;
        }
      }

      return sum;

    }

    /*
     * Exercise 8.
     *
     * Given a string, compute the length of the longest sequence.
     */

    public long sequence(String text) {

      if (text == null) {
        return -1;
      } else if (text.equals("")) {
        return 0;
      }

      int longestConsecutive = 0;
      int consecutive = 0;


      for (int i = 1; i < text.length(); i++) {
        if (i == text.length() - 1) {
          if (text.charAt(i - 1) == text.charAt(i)) {
            consecutive++;
            if (consecutive > longestConsecutive) {
              longestConsecutive = consecutive;
            }
            consecutive = 0;
          } else if (text.charAt(i - 1) != text.charAt(i)) {
              if (consecutive > longestConsecutive) {
                longestConsecutive = consecutive;
              }
              consecutive = 0;
          }
        } else if (text.charAt(i - 1) == text.charAt(i)) {
          consecutive++;
        } else if (text.charAt(i) == ' ' || text.charAt(i) == '.' || text.charAt(i - 1) != text.charAt(i)) {
          if (consecutive > longestConsecutive) {
            longestConsecutive = consecutive;
          }
        consecutive = 0;
        }
      }

      if (longestConsecutive == 0) {
        longestConsecutive = 1;
      } else {
        longestConsecutive++;
      }

      return longestConsecutive;

    }

    /*
     * Exercise 9.
     *
     * Given two strings, return a new string built by intertwining each of the
     * characters of a and b.
     */

    public String intertwine(String a, String b) {

      if (a == null || b == null) {
        return null;
      }

      String intertwined = "";
      boolean aStop = true;
      boolean bStop = true;
      int loopLength = 0;

      if (a.length() > b.length()) {
        loopLength = a.length();
      } else if (b.length() > a.length()) {
        loopLength = b.length();
      } else {
        loopLength = a.length();
      }

      for (int i = 0; i < loopLength; i++) {
        if (i > a.length() - 1) {
          aStop = false;
        } else if (i > b.length() - 1) {
          bStop = false;
        }
        if (aStop) {
          intertwined += Character.toString(a.charAt(i));
        }
        if (bStop) {
          intertwined += Character.toString(b.charAt(i));
        }
      }

      return intertwined;

    }

    /*
     * Exercise 10.
     *
     * Given a string, determine whether or not it is a palindrome.
     */

    public boolean isPalindrome(String text) {

      if (text == null) {
        return false;
      }

      boolean isPalindrome = false;
      String reverse = "";

      for (int i = text.length() - 1; i >= 0; i--) {
        reverse += String.valueOf(text.charAt(i));
      }
      if (text.equals(reverse)) {
        isPalindrome = true;
      }

      return isPalindrome;

    }
}
