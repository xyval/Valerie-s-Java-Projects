/* 
Killing Monster With Maths 
by Valerie Lin & Valerie Siao 
created 29th November 2022
*/ 

//imports: 
import java.util.*;

public class KillingMonsterWithMath
{
    public static void main(String[]arg)  
    {
        //variables declaration
        int score = 0;
        int round = 0;
        int correctA = 0;
        int userA = 0;
        
        //game: 
        intro();
        int topic = askTopic();
        while (topic != 4)
        {
            round++;
            correctA = Q(topic);
            userA = userAns();
            if (userA == correctA)
            {
                score++;
                System.out.println("CORRECT!");
                System.out.print("Press [ENTER] to bite the Monster (The Monster should appear as a window somewhere on your computer) ");
                try
                {
                    System.in.read();
                    System.in.skip(System.in.available());
                }
                catch(Exception e){e.printStackTrace();}
                showMonster(round, score);
            }
            else if (score != 0)
            {
                score--;
                System.out.println("WRONG");
                System.out.print("Press [ENTER] to see the Monster (The Monster should appear as a window somewhere on your computer) ");
                try
                {
                    System.in.read();
                    System.in.skip(System.in.available());
                }
                catch(Exception e){e.printStackTrace();}
                showMonster(round, score);
            }
            
            if (score >= 10)
            {
                System.out.println("Congratulation! You killed the Monster!");
                break;
            }
            topic = askTopic();
        }
        if (score < 10)
        {
            System.out.println("You lost.");
        }
        System.out.println("Accuracy: " + ((double) score/(double) round) + " %");
    }

    //introduction
    public static void intro ()
    {
        System.out.println("Welcome to killing monster with maths! ");
        System.out.println("This is a game with maths");
        System.out.println("If you want to kill the monster, you will need to complete a series of maths problem");
        System.out.println("OR you can surrender to the monster");
        System.out.println("There are three topics within the maths problem");
        System.out.println("The three choices are artithmetic, system of equations and quadratic function");
        System.out.println("In order to kill the monster, you will need to pass the questions.");
        System.out.println("If you answer correctly you will receive 1 bite");
        System.out.println("BUT if you answer wrong you will get 1 bite off");
        System.out.println("You will need a total of 10 bite to successfully kill the monster");
        System.out.println("GOOD LUCK!");
    }

    //ask for topic 
    public static int askTopic ()
    {
        int topic = 0;
        do {
            try {
                Scanner k1 = new Scanner(System.in);
                System.out.println("\nChoose a topic: ");
                System.out.println("   1. Arithmetic ");
                System.out.println("   2. System of equations ");
                System.out.println("   3. Quadratic function ");
                System.out.println("   4. Surrender to Monster");
                System.out.print("> ");
                topic = k1.nextInt(); 
                if (topic < 1 || topic > 4)
                {
                    System.out.println("Input invalid. Please try again. ");
                }
                System.out.println();
            } catch (Exception e) {
                System.out.println("Input invalid. Please try again. ");
                System.out.println();
            }
        } while (topic < 1 || topic > 4);
        return topic;
    }

    //generate question, print question, return correct answer 
    public static int Q (int topic) 
    {
        Random r = new Random();
        int correctA=0;
        switch (topic)
        {
            case 1: 
            //topic 1: Arithmatics (+-*/)
                int type = r.nextInt(4);
                int a = r.nextInt(1, 100);
                int b = r.nextInt(1, 100); 
                switch (type)
                {
                    case 0: //addition: a + b = correctA
                        correctA = a+b;
                        System.out.println(a + " + " + b + " = ");
                        break;
                        
                    case 1: //subtraction: a - b = correctA
                        correctA = a-b;
                        System.out.println(a + " - " + b + " = ");
                        break;
                        
                    case 2: //multiplication: a × b = correctA
                        correctA = a*b;
                        System.out.println(a + " × " + b + " = ");
                        break;
                        
                    case 3: //division: a ÷ b = correctA
                        correctA = a/b;
                        System.out.println(a + " ÷ " + b + " = ");
                        break;
                }
                break;
                
            case 2:
            //topic 2: system of equations 
                int x = r.nextInt(1,10);
                int y = r.nextInt(1, 10);
                a = r.nextInt(1, 10);   
                b = r.nextInt(1, 10); 
                int c = r.nextInt(1, 10); 
                int d = r.nextInt(1, 10); 
                int e = a*x + b*y;
                int f = c*x + d*y;
                
                System.out.println("Find the x value for this system of equations:");
                System.out.println(a + "x + " + b + "y = " + e);
                System.out.println(c + "x + " + d + "y = " + f);
                correctA = x;
                //ax + by = e
                //cx - dy = f 
                //correctA = x
                break;
                
            case 3:
            //topic 3: quadratic function 
                x = r.nextInt(1, 10);
                a = r.nextInt(1, 5);
                b = (-1) * 2  * a * x;
                c = r.nextInt(1, 50);
                System.out.println("Find the x value for the minimum of this function: ");
                System.out.println("f(x) = " + a + "x^2 - " + -b + "x + " + c);
                correctA = x;
                //f(x) = ax^2 + bx + c 
                //correctA = x
                break;
        }
        return correctA;
    }
    
    //get user input
    public static int userAns ()
    {
        Scanner k2 = new Scanner(System.in);
        System.out.print("> ");
        int userAns = k2.nextInt();
        return userAns;
    }

    //show result Monster 
    public static void showMonster (int round, int score)
    {
        switch (score)
        {
            case 1:
                Monster1.draw(round);
                break;
            case 2:
                Monster2.draw(round);
                break;
            case 3:
                Monster3.draw(round);
                break;
            case 4:
                Monster4.draw(round);
                break;
            case 5:
                Monster5.draw(round);
                break;
            case 6:
                Monster6.draw(round);
                break;
            case 7:
                Monster7.draw(round);
                break;
            case 8:
                Monster8.draw(round);
                break;
            case 9:
                Monster9.draw(round);
                break;
            case 10:
                Monster10.draw(round);
                break;
            default:
                Monster0.draw(round);
                break;
        }
    }
}
