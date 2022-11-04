/*
Modified Blackjack Game: Blackjack - Twenty-Six
by Valerie Lin
Created on 28th October 2022 
*/

import java.util.Scanner;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class blackjack{
    public static void main(String[]arg) throws Exception
    {
        Scanner kb = new Scanner(System.in);
        String hitOrStay;
        int dealerMoney = 1000, playerMoney = 100, bet=0;
        Integer[] cardDeck = {1,1,1,1,2,2,2,2,3,3,3,3,4,4,4,4,5,5,5,5,6,6,6,6,7,7,7,7,8,8,8,8,9,9,9,9,10,10,10,10,11,11,11,11,12,12,12,12,13,13,13,13};
        ArrayList<Integer> playerCards = new ArrayList<Integer>();
        ArrayList<Integer> dealerCards = new ArrayList<Integer>();
        
        //INSTRUCTION//
            System.out.println("\n**BLACKJACK - Twenty-Six**\n");
            System.out.println("\tObject: ");
            System.out.println("\t\tPlayer attempts to beat the dealer by getting a count as close to 26 as possible, \n\t\twithout going over 26. ");
            System.out.println("\tCard Values: ");
            System.out.println("\t\tA = 1 ; J = 11 ; Q = 12 ; K = 13 ; any other card is its pip value");
            System.out.println("\tRules: ");
            System.out.println("\t\tDealer and player each gets 2 cards. Player can see both their cards, but only one \n\t\tof dealer's cards. ");
            System.out.println("\t\tPlayer decides to hit or stay. If they decide to hit, they get another card. If \n\t\ttheir card values exceed 26, they bust. Player can hit as many times as they wish \n\t\tunless they busted.  ");
            System.out.println("\t\tOnce they choose to stay, it's dealer's turn. Dealer can choose to hit as many times \n\t\tas they wish unless they busted. ");
            System.out.println("\t\tWhen either player or dealer bust, or both of them choose to stay, the game ends and \n\t\tthey reveal their cards. If one is busted, they automatically lose. Otherwise, \n\t\tthe person with the highest value wins. ");
            System.out.println("\tBetting: ");
            System.out.println("\t\tAt the start of the gamble, player has $100, dealer has $1000. Player places their \n\t\tbet. If they win, they get their bet back doubled. If they lose, they lose their \n\t\tbet. If player and dealer tie, player gets their bet back tripled. The first to \n\t\tgo bankrupt loses the gamble and the gamble ends. \n");
        //INSTRUCTION//

        //**************THE GAME**************//

            while (true)
            {
                //bet
                boolean betValid = false;
                do 
                {
                    try 
                    {
                        System.out.print("Place your bet to start: ");
                        bet = kb.nextInt();
                        if (bet>0 && bet<=playerMoney)
                        {
                            betValid = true;
                            playerMoney = playerMoney - bet;
                            System.out.println("Your money left: $" + playerMoney);
                        }
                        else if (bet <= 0)
                        {
                            System.out.println("You must place bet to start. ");
                        }
                        else if (bet > playerMoney)
                        {
                            System.out.println("Please place a bet that you can afford.");
                        }
                    }
                    catch (Exception e) 
                    {
                        System.out.println("Error. Try again.");
                    }
                } while (betValid == false);

                //shuffle
                List<Integer> intList = Arrays.asList(cardDeck);
                Collections.shuffle(intList);
                intList.toArray(cardDeck);
                int playerSum=0, dealerSum=0;
                int card = 0;
                playerCards.clear();
                dealerCards.clear();

                //draw cards 
                drawCardPlayer(playerCards, cardDeck, card);
                drawCardPlayer(playerCards, cardDeck, card);
                dealerCards.add((int)Array.get(cardDeck, card));
                card++;
                dealerCards.add((int)Array.get(cardDeck, card));
                card++;
                
                //show first cards
                playerSum = showCards(playerCards, dealerCards, playerSum);

                //hit or stay? 
                do {
                    System.out.print("Do you want to hit or stay? ");
                    hitOrStay = kb.next();
                    if (hitOrStay.equalsIgnoreCase("hit")||hitOrStay.equalsIgnoreCase("h"))
                    {
                        playerCards.add((int)Array.get(cardDeck, card));
                        card++;
                        playerSum = showCards(playerCards, dealerCards, playerSum);
                        
                    }
                    else if (hitOrStay.equalsIgnoreCase("stay")||hitOrStay.equalsIgnoreCase("s"))
                    {
                        break;
                    }
                } while (playerSum <= 26);

                //if burst, stop. Else, dealer's turn. 
                if (playerSum > 26)
                {
                    System.out.println ("Oops! BURST. You lost. ");
                }
                else 
                {
                    //dealer hit
                    while (dealerSum <= 18)
                    {
                        dealerCards.add((int)Array.get(cardDeck, card));
                        card++;
                        dealerSum = 0;
                        for(int i=0;i < dealerCards.size();i++)
                        {
                            dealerSum = dealerSum + dealerCards.get(i);
                        }
                    }
                }

                //show all cards 
                System.out.print("Press [ENTER] to reveal result ");
                try
                {
                    System.in.read();
                    System.in.skip(System.in.available());
                }
                catch(Exception e){e.printStackTrace();}
                showCardsPlayerFinal(playerCards, playerSum);
                showCardsDealerFinal(dealerCards, dealerSum);
                
                //declare winner and calculate bet result 
                if (playerSum > 26)
                {
                    System.out.println("Dealer wins because you bust");
                    dealerMoney = dealerMoney + bet;
                }
                else if (dealerSum > 26)
                {
                    System.out.println("You WIN because dealer bust");
                    dealerMoney = dealerMoney - bet;
                    playerMoney = playerMoney + bet + bet;
                }
                else if (dealerSum > playerSum)
                {
                    System.out.println("Dealer wins");
                    dealerMoney = dealerMoney + bet;
                }
                else if (playerSum > dealerSum)
                {
                    System.out.println("You WIN");
                    dealerMoney = dealerMoney - bet;
                    playerMoney = playerMoney + bet + bet;
                }
                else
                {
                    System.out.println("Tie.");
                    playerMoney = playerMoney + bet + bet + bet;
                    dealerMoney = dealerMoney - bet - bet;
                }
                System.out.println("Your cash: $" + playerMoney);
                System.out.println("Dealer's cash: $" + dealerMoney);

                //end gamble if someone bankrupt 
                if (playerMoney <= 0)
                {
                    System.out.println("You bankrupted. Sad :(");
                    break;
                }
                if (dealerMoney <= 0)
                {
                    System.out.println("Dealer bankrupt. Bye");
                    break;
                }
            }
            kb.close();
        //**************THE GAME**************//

    }


    private static void drawCardPlayer(ArrayList<Integer> playerCards, Integer[] cardDeck, int card)
    {
        playerCards.add((int)Array.get(cardDeck, card));
        card++;
    }

    private static int showCards(ArrayList<Integer> playerCards, ArrayList<Integer>dealerCards, int playerSum) throws Exception
    {
        System.out.println("\nYour cards: \n");
        playerSum = 0;
        for(int i=0;i< playerCards.size();i++)
        {
            if ((int)playerCards.get(i)>1 && (int)playerCards.get(i)<10)
            {
                System.out.println(":::::\n::" + playerCards.get(i) + "::\n:::::\n");
                Thread.sleep(200);
            }
            else if ((int)playerCards.get(i)==1)
            {
                System.out.println(":::::\n::A::\n:::::\n");
                Thread.sleep(200);
            }
            else if ((int)playerCards.get(i)==10)
            {
                System.out.println(":::::\n:10::\n:::::\n");
                Thread.sleep(200);
            }
            else if ((int)playerCards.get(i)==11)
            {
                System.out.println(":::::\n::J::\n:::::\n");
                Thread.sleep(200);
            }
            else if ((int)playerCards.get(i)==12)
            {
                System.out.println(":::::\n::Q::\n:::::\n");
                Thread.sleep(200);
            }
            else if ((int)playerCards.get(i)==13)
            {
                System.out.println(":::::\n::K::\n:::::\n");
                Thread.sleep(200);
            }
            playerSum = playerSum+playerCards.get(i);
            Thread.sleep(100);
        }
        
        System.out.println("Sum: " + playerSum + "\n");
        Thread.sleep(300);

        System.out.println("Dealer's cards: \n");
            if ((int)dealerCards.get(0)>1 && (int)dealerCards.get(0)<10)
            {
                System.out.println(":::::\n::" + dealerCards.get(0) + "::\n:::::\n");
                Thread.sleep(200);
            }
            else if ((int)dealerCards.get(0)==1)
            {
                System.out.println(":::::\n::A::\n:::::\n");
                Thread.sleep(200);
            }
            else if ((int)playerCards.get(0)==10)
            {
                System.out.println(":::::\n:10::\n:::::\n");
                Thread.sleep(200);
            }
            else if ((int)dealerCards.get(0)==11)
            {
                System.out.println(":::::\n::J::\n:::::\n");
                Thread.sleep(200);
            }
            else if ((int)dealerCards.get(0)==12)
            {
                System.out.println(":::::\n::Q::\n:::::\n");
                Thread.sleep(200);
            }
            else if ((int)dealerCards.get(0)==13)
            {
                System.out.println(":::::\n::K::\n:::::\n");
                Thread.sleep(200);
            }
            for(int i=1;i< dealerCards.size();i++)
            {
                System.out.println(":::::\n:::::\n:::::\n");
                Thread.sleep(200);
            }
     return playerSum;   
    }

    private static void showCardsPlayerFinal(ArrayList<Integer> playerCards, int playerSum) throws Exception
    {
        System.out.println("\nYour cards: \n");
        playerSum = 0;
        for(int i=0;i< playerCards.size();i++)
        {
            if ((int)playerCards.get(i)>1 && (int)playerCards.get(i)<10)
            {
                System.out.println(":::::\n::" + playerCards.get(i) + "::\n:::::\n");
                Thread.sleep(200);
            }
            else if ((int)playerCards.get(i)==1)
            {
                System.out.println(":::::\n::A::\n:::::\n");
                Thread.sleep(200);
            }
            else if ((int)playerCards.get(i)==10)
            {
                System.out.println(":::::\n:10::\n:::::\n");
                Thread.sleep(200);
            }
            else if ((int)playerCards.get(i)==11)
            {
                System.out.println(":::::\n::J::\n:::::\n");
                Thread.sleep(200);
            }
            else if ((int)playerCards.get(i)==12)
            {
                System.out.println(":::::\n::Q::\n:::::\n");
                Thread.sleep(200);
            }
            else if ((int)playerCards.get(i)==13)
            {
                System.out.println(":::::\n::K::\n:::::\n");
                Thread.sleep(200);
            }
            playerSum = playerSum+playerCards.get(i);
        }
        
        System.out.println("Sum: " + playerSum +"\n");
        Thread.sleep(100);
    }

    private static int showCardsDealerFinal(ArrayList<Integer>dealerCards, int dealerSum) throws Exception
    {
        System.out.println("\nDealers' cards: \n");
        dealerSum = 0;
        for(int i=0;i < dealerCards.size();i++)
        {
            if ((int)dealerCards.get(i)>1 && (int)dealerCards.get(i)<10)
            {
                System.out.println(":::::\n::" + dealerCards.get(i) + "::\n:::::\n");
                Thread.sleep(200);
            }
            else if ((int)dealerCards.get(i)==1)
            {
                System.out.println(":::::\n::A::\n:::::\n");
                Thread.sleep(200);
            }
            else if ((int)dealerCards.get(i)==10)
            {
                System.out.println(":::::\n:10::\n:::::\n");
                Thread.sleep(200);
            }
            else if ((int)dealerCards.get(i)==11)
            {
                System.out.println(":::::\n::J::\n:::::\n");
                Thread.sleep(200);
            }
            else if ((int)dealerCards.get(i)==12)
            {
                System.out.println(":::::\n::Q::\n:::::\n");
                Thread.sleep(200);
            }
            else if ((int)dealerCards.get(i)==13)
            {
                System.out.println(":::::\n::K::\n:::::\n");
                Thread.sleep(200);
            }
            dealerSum = dealerSum + dealerCards.get(i);
        }
        System.out.println("Sum: " + dealerSum +"\n");
        return dealerSum;
    }

}
