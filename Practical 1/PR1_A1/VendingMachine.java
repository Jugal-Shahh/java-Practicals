import java.util.Scanner;
enum Coin
{
  ONE ,
  TWO ,
  FIVE ,
  TEN 
}

public class VendingMachine
{
  public static void main(String args[])
  {
    Scanner sc = new Scanner(System.in);
    int sum =0 ;
  int charge = 15;
  System.out.println("Enter Coin :");
  while(sum<15)
  {
    System.out.println("Enter Coin(ONE ,TWO ,FIVE ,TEN) :");
    String inp = sc.nextLine().toUpperCase() ;
    Coin coinType = Coin.valueOf(inp);

    int coin=0;

    switch(coinType)
    {
      case ONE :
        coin = 1;
        break;

        case TWO :
        coin = 2;
        break;

        case FIVE :
        coin = 5;
        break;

        case TEN :
        coin = 10;
        break;

        default :
        System.out.println("Enter a valid coin");
    }
    sum = sum + coin;
  };
  int change = sum -15;
  System.out.println("The Total is : "+ sum);
  System.out.println("Paid"+"."+ " Charge: "+change);
    sc.close();
  }

}