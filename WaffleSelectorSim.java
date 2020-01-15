// Simulation of Waffle Selection logic
import java.util.*;

class Waffle
{
  // variable string
  static ArrayList<String> waffleOrders = new ArrayList<String> ();

  public static void getOrderFromInput (String inpString)
  {
    String [] waffleBuffer = inpString.split(",");

    for (String waffles : waffleBuffer) //add waffle orders in waffleBuffer to the ArrayList
        waffleOrders.add (waffles);
  }

  public static int getPrice (String inpStringWaffle)
  {
    int price = 0; // dummy value
    switch (inpStringWaffle)
    {
      // PHP35
      case "PLA":
        price = 35;
        break;

      // PHP40
      case "CHO": case "CHE": case "PBU": case "CAR":
        price = 40;
        break;

      // PHP45
      case "STR": case "BLU": case "CUS": case "MPE": case "MFB":
        price = 45;
        break;

      // PHP50
      case "BCH": case "BCA": case "FBC": case "BPB":
        price = 50;
        break;

      // PHP55
      case "CCU": case "CAC": case "BBA": case "STB": case "STC":
      case "BCU": case "CCA":
        price = 55;
        break;
      // PHP60 - coming soon
      // PHP65 - coming soon

      // invalid flavor code
      default:
        System.out.println("Invalid code entered");
        break;
    }
    return price;
  }

  public static void showOrders ()
  {
    int totalCost = 0;
    for (String orders : waffleOrders)
    {
      int orderPrice = getPrice (orders);
      totalCost += orderPrice;
      System.out.println(orders + "\t" + " - " + "\t" + orderPrice);
    }
    System.out.println("Total Cost: "+ "\t" + " - " + "\t" + totalCost);

  }
} // end of class Waffle

class WaffleSelectorSim
{
  public static void main(String[] args)
  {
    Scanner input1 = new Scanner (System.in);
    Scanner input2 = new Scanner (System.in);
    Waffle waffleOrder = new Waffle (); // instantiate object of type waffle
    boolean contSim = true;
    String inpString;

    // start of order logic
    showMenu ();
    while (contSim == true)
    {
      System.out.print("Enter order string (separated by commas): ");
      inpString = input1.nextLine(); // get input from user
      waffleOrder.getOrderFromInput(inpString);
      waffleOrder.showOrders();
      System.out.print("Contine? (True/False): ");
      contSim = endSim(input2.nextLine());
    }
  }

  public static boolean endSim (String flagString)
  {
    boolean simFlag;
    switch(flagString)
    {
      case "True": case "true":
        simFlag = true;
        break;

      case "False": case "false":
        simFlag = false;
        break;

      default:
        System.out.println("Invalid input");
        simFlag = true;
        break;
    }

    return simFlag;
  }

  public static void showMenu ()
  {
    /* Note:
      The number codes simulates the push button interface of the GUI */

    // PHP35
    System.out.println("PHP 35\nPlain (PLA)\n\n");

    // PHP40
    System.out.println("PHP 40\nChocolate (CHO)\nCheddar Cheese (CHE)\nPeanut Butter (PBU)\nCaramel (CAR)\n\n");
    // PHP45
    System.out.println("PHP 45\nStrawberry (STR)\nBlueberry (BLU)\nCustard (CUS)\nMango Peach (MPE)\nMaple and French Butter (MFB)\n\n");
    // other flavor codes coming soon
    /*
    // PHP50
    System.out.println();
    // PHP55
    System.out.println();
    // PHP60
    System.out.println();
    // PHP65
    System.out.println();
    */
  }
} // end of Class WaffleSelectorSim
