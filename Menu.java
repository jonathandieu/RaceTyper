import java.io.FileInputStream;
import java.util.*;

public class Menu
{

  // Menu variables
  private ParagraphManager paraManager;
  private Scanner sc;
  private int timeLimit = 20;
  private String filename;
  

  // Constructor to initialize the scanner and the paraManager
  public Menu()
  {
    sc = new Scanner(System.in);
    paraManager = new ParagraphManager(sc);
  } 

  // Take in input from a text file with paragraph in it as specified by the user
  // public String fileReader() 
  // {
  //   System.out.println("Please enter the name of the file that you would like to use as input?");
    
  //   filename = sc.nextLine();
    
    // Takes file specified by the user and
    // Scanner inputscanner = new Scanner(new File(filename)); 
    // while (inputscanner.hasNextLine())
    // {
    //   String line = inputscanner.nextLine();
    // }

    
      
 // }
  // Wasn't working for some reason
    /*
  { FileInputStream fstream = new FileInputStream("");
    File inputfile = new File("input.txt");

    try (BufferedReader br = new BufferedReader(new FileReader(inputfile)));
      for(string line; (line = br.readLine()) != null; )
    {
      System.out.println(line);
    }
    
    fstream.close();
  }
  */
  
  // Initial options menu after a paragraph is created or chosen.
  public void splashOptions()
  {
    createHeader("1: Start a game.\n2: Paragraph editor.\n3: Exit game");
    
    int choice = sc.nextInt();
    switch(choice)
    {
      case 1:
        initGame();
        break;
      
      case 2:
        paraManager.paragraphMenu();
        break;

      case 3:
        System.out.println("Thanks for playing!\n");
        System.exit(0);
    }
  }   
  
  // Function that asks the user to choose a paragraph they wish to practice, displays titles,
  // and they choose the index assosciated with that specific paragraph. Starts the game.
  public void initGame() 
  {
    System.out.println("Please choose a paragraph to practice:");
    paraManager.titleList();
    int pgraph_num = sc.nextInt();

    System.out.println("Please choose a difficulty (1-5):");
    int difficulty = sc.nextInt();

    startGame(pgraph_num, difficulty);
  }

  // Function to output a list of all titles along with the index asssociated with that specific paragraph.
  // public void titleList()
  // {
  //   for (int i = 0; i < paraManager.size(); i++) 
  //   {
  //     System.out.println(i + " " + "|" + " " + paraManager.get(i).getTitle());
  //   }
  //   System.out.println();
  // }


  // Initial start menu prompting the user if they would like to create a new paragaph or use
  // an existing one(implemented later).
  public void startMenu() {
    createHeader("Welcome to RacerType!\nCreated by Jonathan Dieu, John Pham, and Ryan Black");

    System.out.println("Would you like to create a new paragraph to practice on? Y/N");
    String res = sc.next();
  
    if (res != "Y")
       splashOptions();
    
    paraManager.enterParagraph();
    splashOptions();
    
  }

  // // Function that creates our beautiful header.
  public void createHeader(String header)
  {
    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-==-=-=-=-=-=-=-=-=-");
    System.out.println(header);
    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-==-=-=-=-=-=-=-=-=-\n\n");
  }
  // // The paragraph editor menu :D
  // public void paragraphEditorMenu()
  // {
  //   createHeader("Paragraph Editor\nHere's what you've saved so far:");
  //   titleList(); 
  //   createHeader("1: Start a game.\n2: Paragraph editor.\n3: Exit game")
  // }
  
  
 
//  public void enterParagraph()
//   {
//     String input;
//     Paragraph paragraph = new Paragraph();

//     System.out.println("Please enter a title for your paragraph:");
//     paragraph.setTitle(sc.next);

//     System.out.println("NOTE: Enter @@ when you finish typing your paragraph!");
//     System.out.println("Please enter your paragraph:");
  
//     while (input != "@@") 
//     {
//         input = sc.next();
//         paragraph.add(input);
//     }
  
//     blockLoader.add(paragraph);
//  }

//  public void addToParagraph(int paragraph)
//  {
//    while (true)
//    {
//      System.out.println("Enter in a sentence to add; @@ to leave");
//      String input = sc.nextLine();

//      if (input.isEmpty())
//      {
//        continue;
//      }
//      if (input.equals("@@"))
//      {
//        return;
//      }
//      blockLoader.get(paragraph).add(input);     
//    }

//  }
  // Method that prints out your options
  // And helper methods for each option
  
  

  // Functionality for the game
  // Times users and compares their input to what is being held in blockLoader
  public void startGame(int paragraph, int difficulty)
  {
    int count = 0;
    double overallTime = 0;
    
    // string = 
    // System.out.println(string);
    LinkedList temp = paraManager.get(paragraph).getBlock();
    System.out.println("")
    for (int i = 0; i < temp.size(); i++)
    {
      final long start = System.nanoTime();
      String userInput = sc.nextLine();
      final long stop = System.nanoTime();

      double totalTime = (stop - start) / 1e9;

      if (totalTime >= timeLimit * difficulty || !userInput.equals(temp.get(i)))
        typingError(temp.get(i), userInput, timeLimit);
      
      else if (++count % 3 == 0)
        typingSuccess();
    }

    // IMPLEMENT LATER
    // A report screen that will display some cool stats to the user
    // reportPrint(paragraph, difficulty, overallTime);
  }

  // Occurs when the user can't type a word correctly or on time
  public void typingError(String sentence, String userInput, double totalTime)
  {
    System.out.println("Your input: " + userInput + "\nYour time: " + totalTime + " seconds");
    System.out.println("Oops! Looks like you couldn't finish correctly or on time, let's try this again");
    System.out.println("Try typing this sentence again:\n" + sentence + "\nTake your time, you can do it!");

    String input = sc.nextLine();
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

  // public static void countdown()
  // {
  //   System.out.println("Get ready...");
  //   {timer = new Timer(); timer.schedule(new DisplayCountdown(), 1000);} // Last parameter is the interval in which the coundown is displayed (frequency wise)

  //  class DisplayCountdown extends TimerTask {int seconds = timeLimit;} // 2 errors
}
  
