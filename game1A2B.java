import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
public class game1A2B 
{
    public static void main (String [] arg)
	{

		int digit;
		String play;


		//actual game
		System.out.println("\n\n\n\nLet's play 1A2B! :D");
        while (true)
		{
			Scanner kb = new Scanner(System.in);
			//play or not
			System.out.print("Do you want to play? (yes/no): ");
            play = kb.next();
			if (play.equals("no"))
			{
				System.out.println("Oh, so sad.");
				break;
			}
            

            //how many digits? 
            System.out.print("how many digits do you want to play? (3/4): ");
            digit = kb.nextInt();

            if (digit==3)
            {
                threeDigitsGame();
            }
            else if (digit==4)
            {
                fourDigitsGame();
            }
            else 
            {
                System.out.println("???");
            }

        }

        
    }


    private static void threeDigitsGame()
    {
        Random r = new Random();
		Scanner kb2 = new Scanner(System.in);


        //declare variables 
		boolean repeat=true; 
		int n1=0, n2=0, n3=0, answer;
		ArrayList<Integer> g1 = new ArrayList<Integer>();
		ArrayList<Integer> g2 = new ArrayList<Integer>();
		ArrayList<Integer> g3 = new ArrayList<Integer>();
		ArrayList<Integer> guess = new ArrayList<Integer>();
		ArrayList<Integer> resultA = new ArrayList<Integer>();
		ArrayList<Integer> resultB = new ArrayList<Integer>();
		int guessNumber;
		int A=0,B=0;
		int error=0;
        String intro;


        //index 0 of the array lists
		g1.add(0,1);
		g2.add(0,1);
		g3.add(0,1);
		guess.add(0,1);
		resultA.add(0,1);
		resultB.add(0,1);


        //randomly generate the answer 
			while (repeat==true) 
			{
				n1 = r.nextInt(1,10);
				n2 = r.nextInt(0,10);
				n3 = r.nextInt(0,10);
				if (n1 != n2 && n1 != n3 && n2 != n3)
				{ 
					repeat=false;
				}
			}
			answer = n1*100 + n2*10 + n3;

			
			//rule explanation 
			System.out.print("Do you know the rules? (yes/no): ");
			intro = kb2.nextLine();
			if (intro.equals("no"))
			{
				System.out.println("\nHere is how the game work: ");
                System.out.println("    I'm thinking of a non-repeating-three-digit number and you are going to guess it. ");
                System.out.println("    Enter a three-digit number you want to guess.");
                System.out.println("    Then, I will compare your guess with my number.");
                System.out.println("    If a digit you guessed is a digit in the answer, and it is in its right position, \n    it is an \"A\", if it is in a wrong position, it is a \"B\".");
                System.out.println("    I will show your result in a table that looks like this: ");
                System.out.println("");
                System.out.println("      Guess  |  Result ");
                System.out.println("    ---------+----------");
                System.out.println("       123   |   1A2B  ");
                System.out.println("       456   |   0A2B  ");
                System.out.println("       234   |   1A1B  ");
                System.out.println("");
                System.out.println("    You will use the results to figure out my number. ");
			}


			//start game 
			System.out.println("\nLet's PLAY!!!! \\(≧ ▽ ≦ *)o ");
			

			//repeated guessing part (800 bc 720 possibilities, in case someone decides to try out all the possible numbers and/or mistype smt)
			for (int x=1;x<=800;x++)
			{
				
				//get guesses input from user
				System.out.print("\n\n\nYour guess: ");
				guessNumber = kb2.nextInt();
				guess.add(x,guessNumber);


				//test if guess is valid 
				if (guessNumber < 999 && guessNumber > 99)
				{


					//get data of the digits 
					g1.add(x,(guessNumber/100));
					g2.add(x,((guessNumber-g1.get(x)*100)/10));
					g3.add(x,(guessNumber-g1.get(x)*100-g2.get(x)*10));


					//calculate result
					A=0;
					if (g1.get(x)==n1){A=A+1;}
					if (g2.get(x)==n2){A=A+1;}
					if (g3.get(x)==n3){A=A+1;}
					resultA.add(x,A);
					B=0;
					if (g1.get(x)==n2 || g1.get(x)==n3){B=B+1;}
					if (g2.get(x)==n1 || g2.get(x)==n3){B=B+1;}
					if (g3.get(x)==n1 || g3.get(x)==n2){B=B+1;}
					resultB.add(x,B);


					//print result table
					System.out.println("");
					System.out.println("Result Table: ");
					System.out.println("");
					System.out.println("\tGuess  |  Result  ");
					System.out.println("---------------+---------------");
					for (int i=1;i<g1.size();i++)
					{
						System.out.println(i + "\t " + guess.get(i) + "   |   " + resultA.get(i) + "A" + resultB.get(i) + "B");
					}
				}


				else 
				{
					System.out.println("Please enter a valid guess. ");
					x--;
					error=error+1;
				}
				
				
				if (guess.get(x)==answer)
				{
					break;
				}
				

			}


			System.out.println("\nWoohoo! You guessed it! Congratulations!");
			System.out.println("Attempts: " + (guess.size()-1-error) + "\n\n");

    }

    private static void fourDigitsGame()
    {
        Random r = new Random();
		Scanner kb3 = new Scanner(System.in);


        //declare variables 
		boolean repeat=true; 
		int n1=0, n2=0, n3=0, n4=0, answer;
		ArrayList<Integer> g1 = new ArrayList<Integer>();
		ArrayList<Integer> g2 = new ArrayList<Integer>();
		ArrayList<Integer> g3 = new ArrayList<Integer>();
        ArrayList<Integer> g4 = new ArrayList<Integer>();
		ArrayList<Integer> guess = new ArrayList<Integer>();
		ArrayList<Integer> resultA = new ArrayList<Integer>();
		ArrayList<Integer> resultB = new ArrayList<Integer>();
		int guessNumber;
		int A=0,B=0;
		int error=0;
        String intro;


        //index 0 of the array lists
		g1.add(0,1);
		g2.add(0,1);
		g3.add(0,1);
        g4.add(0,1);
		guess.add(0,1);
		resultA.add(0,1);
		resultB.add(0,1);


        //randomly generate the answer 
		while (repeat==true) 
		{
			n1 = r.nextInt(1,10);
			n2 = r.nextInt(0,10);
			n3 = r.nextInt(0,10);
			n4 = r.nextInt(0,10);
			if (n1 != n2 && n1 != n3 && n1 != n4 && n2 != n3 && n2 != n4 && n3 != n4)
			{ 
				repeat=false;
			}
		}
		answer = n1*1000 + n2*100 + n3*10 + n4;

		
		//rule explanation 
		System.out.print("Do you know the rules? (yes/no): ");
		intro = kb3.nextLine();
		if (intro.equals("no"))
		{
			System.out.println("\nHere is how the game work: ");
			System.out.println("    I'm thinking of a non-repeating-four-digit number and you are going to guess it. ");
			System.out.println("    Enter a four-digit number you want to guess.");
			System.out.println("    Then, I will compare your guess with my number.");
			System.out.println("    If a digit you guessed is a digit in the answer, and it is in its right position, \n    it is an \"A\", if it is in a wrong position, it is a \"B\".");
			System.out.println("    I will show your result in a table that looks like this: ");
			System.out.println("");
			System.out.println("      Guess  |  Result ");
			System.out.println("    ---------+----------");
			System.out.println("      1234   |   1A2B  ");
			System.out.println("      4567   |   0A2B  ");
			System.out.println("      2348   |   1A1B  ");
			System.out.println("");
			System.out.println("    You will use the results to figure out my number. ");
		}


		//start game 
		System.out.println("\nLet's PLAY!!!! \\(≧ ▽ ≦ *)o ");
		

		//repeated guessing part (5500 bc 5040 possibilities, in case someone decides to try out all the possible numbers and/or mistype smt)
		for (int x=1;x<=5500;x++)
		{
			
			
			//get guesses input from user
			System.out.print("\n\n\nYour guess: ");
			guessNumber = kb3.nextInt();
			guess.add(x,guessNumber);


			//test if guess is valid 
			if (guessNumber < 9999 && guessNumber > 999)
			{


				//get data of the digits 
				g1.add(x,(guessNumber/1000));
				g2.add(x,((guessNumber-g1.get(x)*1000)/100));
				g3.add(x,((guessNumber-g1.get(x)*1000-g2.get(x)*100))/10);
				g4.add(x,(guessNumber-g1.get(x)*1000-g2.get(x)*100-g3.get(x)*10));


				//calculate result
				A=0;
				if (g1.get(x)==n1){A=A+1;}
				if (g2.get(x)==n2){A=A+1;}
				if (g3.get(x)==n3){A=A+1;}
				if (g4.get(x)==n4){A=A+1;}
				resultA.add(x,A);
				B=0;
				if (g1.get(x)==n2 || g1.get(x)==n3 || g1.get(x)==n4){B=B+1;}
				if (g2.get(x)==n1 || g2.get(x)==n3 || g2.get(x)==n4){B=B+1;}
				if (g3.get(x)==n1 || g3.get(x)==n2 || g3.get(x)==n4){B=B+1;}
				if (g4.get(x)==n1 || g4.get(x)==n2 || g4.get(x)==n3){B=B+1;}
				resultB.add(x,B);


				//print result table
				System.out.println("");
				System.out.println("Result Table: ");
				System.out.println("");
				System.out.println("\tGuess  |  Result  ");
				System.out.println("---------------+---------------");
				for (int i=1;i<g1.size();i++)
				{
					System.out.println(i + "\t" + guess.get(i) + "   |   " + resultA.get(i) + "A" + resultB.get(i) + "B");
				}
			}


			else 
			{
				System.out.println("Please enter a valid guess. ");
				x--;
				error=error+1;
			}
			
			
			if (guess.get(x)==answer)
			{
				break;
			}
			
			
		}


		System.out.println("\nWoohoo! You guessed it! Congratulations!");
		System.out.println("Attempts: " + (guess.size()-1-error) + "\n\n");

	}
}
