//imports: 
import java.util.*;

public class KillingMonsterWithMath
{
    public static void main(String[]arg) 
    {
        int score = 0;
        int round = 0;
        int correctA = 0;
        int userA = 0;
        intro();
        int topic = askLevel();
        while (topic != 4)
        {
            round++;
            correctA = Q(topic);
            userA = userAns();
            if (userA == correctA)
            {
                score++;
            }
            else if (score != 0)
            {
                score--;
            }
            showMonster(round, score);
            topic = askLevel();
        }
        if (score >= 10)
        {
            System.out.println("Congratulation! You killed Monster!");
        }
        else 
        {
            System.out.println("You lost.");
        }
    }

    //print out rules & any welcome message or smt 
    public static void intro ()
    {

    }

    //ask for topic 
    public static int askLevel ()
    {
        int topic = 0;
        do {
            try {
                Scanner k1 = new Scanner(System.in);
                System.out.println("Choose a topic: ");
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
                //topic 1
            case 2:
            case 3:
        }
        return correctA;
    }
    
    //show question (maybe won't use)
    public static void showQ ()
    {

    }

    //get user's answer, show guide if they need help (or no)
    public static int userAns ()
    {
        Scanner k2 = new Scanner(System.in);
        int userAns = 0;
        return userAns;
    }

    public static void showMonster (int round, int score)
    {
        switch (score)
        {
            case 1:
                Monster1.draw(round);
            case 2:
                Monster2.draw(round);
            case 3:
                Monster3.draw(round);
            case 4:
                Monster4.draw(round);
            case 5:
                Monster5.draw(round);
            case 6:
                Monster6.draw(round);
            case 7:
                Monster7.draw(round);
            case 8:
                Monster8.draw(round);
            case 9:
                Monster9.draw(round);
            case 10:
                Monster10.draw(round);
            default:
                Monster0.draw(round);
        }
    }
}

/* For Planning:
    explain rules
    repeat: 
        ask for what topic
        generate question
        show question
        show guide if need help 
        get user's answer
        get correct answer
        check answer
        record score 
        add score # of circles 
        show monster 
 */