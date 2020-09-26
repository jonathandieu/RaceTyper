import java.util.*

public class Menu
{

  private ArrayList<LinkedList<String>> blockLoader;
  private Scanner sc;
  private int timeLimit = 20;

  // Implement this functionality later
  private String file;
  
  public Menu()
  {
    sc = new Scanner(System.in);
    blockLoader = new ArrayList<>();
  
    
  } 

  public void splashOptions()
  {
    System.out.println("Press 1 to start the game.");
    System.out.println("Press 2 to die");
    System.out.println("Press 3 to exit the game");
    
    int choice = sc.nextInt();
    switch(choice)
    {
      case 1:
      start();
      break;
      
      case 2:
      break;

      case 3:
      
      return;
      System.out.println("Thanks for playing!\n");
      System.exit(0);
    }
  }   
  
  

  public void startMenu() {
    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-==-=-=-=-=-=-=-=-=-");
    System.out.println("Welcome to RacerType!");
    System.out.println("Created by Jonathan Dieu, John Pham, and Ryan Black");
    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-==-=-=-=-=-=-=-=-=-");

    System.out.println("Would you like to create a new paragraph to practice on? Y/N");
    char res = sc.next();
  
    if (res == 'Y')
        continue;
        
    else
     exit(0);

    System.out.println("Please enter your paragraph:");
    enterParagraph();
    
  } 
 
 public void enterParagraph() {
  String input;
  paragraph = new Paragraph();

  while (input != "@@") {
      input = sc.next();
      paragraph.add(input);
  }
  blockLoader.add(paragraph);
 }

 public void addToParagraph(int paragraph)
 {
   while (true)
   {
     System.out.println("Enter in a sentence to add");
     
   }

 }
  // Method that prints out your options
  // And helper methods for each option
  
  

  // Functionality for the game
  // Times users and compares their input to what is being held in blockLoader
  public void startGame(int paragraph, difficulty)
  {
    int count = 0;
    double overallTime = 0;
    
    final long start = System.nanoTime();
    String userInput = sc.nextLine();
    
    for (String sentence : blockLoader.get(paragraph))
    {
      final long start = System.nanoTime();
      String userInput = sc.nextLine();
      final long stop = System.nanoTime();

      double totalTime = (stop - start) / 1e9;

      if (totalTime >= timeLimit * difficulty)
        typingError(sentence, totalLimit);
      
      else if (++count % 3 == 0)
        typingSuccess();
    }

    // IMPLEMENT LATER
    // A report screen that will display some cool stats to the user
    reportPrint(paragraph, difficulty, overallTime);
  }

  // Occurs when the user can't type a word correctly or on time
  public void typingError(String sentence, double totalTime)
  {
    System.out.println("Oops! Looks like you couldn't finish correctly or on time, let's try this again")
    System.out.println("Try typing this sentence again:\n" + sentence + "\nTake your time, you can do it!");

    String input = Scanner.nextLine();
    while (!input.equals(sentence))
    {
      System.out.println("Try again. Take your time, it's okay to slow down a bit");
    }
  }

  // A small congratulatory message when the user types 3 sentences correctly
  public void typingSuccess()
  {
    System.out.println("LET'S GOOOOOOOOO!!!\nPOGCHAMP");
  }
}