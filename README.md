# Blackjack - Twenty-Six

*Blackjack - Twenty-Six* is a modified simple blackjack game for one player against the computer. 

## **How to Launch the Game**
Simply run the program and follow the instruction. 

## **How the Game Works**
### **Game rules:** <sub>*(This is also included in the program)*<sub/>
Object: 

> Player attempts to beat the dealer by getting a count as close to 26 as possible, without going over 26. 

Card Values: 

> A = 1 ; J = 11 ; Q = 12 ; K = 13 ; any other card is its pip value

Rules: 

> Dealer and player each gets 2 cards. Player can see both their cards, but only one of dealer's cards. 
> 
> Player decides to hit or stay. If they decide to hit, they get another card. If their card values exceed 26, they bust. Player can hit as many times as they wish unless they busted.  
> 
> Once they choose to stay, it's dealer's turn. Dealer can choose to hit as many times as they wish unless they busted. 
> 
> When either player or dealer bust, or both of them choose to stay, the game ends and they reveal their cards. If one is busted, they automatically lose. Otherwise, the person with the highest value wins. 

Betting: 

> At the start of the gamble, player has $100, dealer has $1000. Player places their bet. If they win, they get their bet back doubled. If they lose, they lose their bet. If player and dealer tie, player gets their bet back tripled. The first to go bankrupt loses the gamble and the gamble ends. 

### **Program's function**
1. The program shows the user the game rules
2. The program asks the user to place the bet 
    - The bet must be valid or the program will ask the user again 
    - Amount of bet will be taken from player's money 
3. The program shuffles the card deck (an array stored with card values) 
4. The program gives two cards to the player and show them 
5. The program takes two cards and show only one to the player 
6. The program asks the user they want to hit or stay
   - The user can hit as many times as they want until the sum exceed 26 
   - Hit gives the user another card 
   - Stay ends user's turn  
7. The program draws card for dealer until the sum exceed 18. 
8. The program show all cards of both the user's and the dealer's and declare the winner 
9. The program calculates the money amount according to the amount of bet and the game result 
   - If player wins, they get double the amount of bet and dealer lose the amount of bet 
   - If dealer wins, dealer get the amount of bet 
   - If tie, player gets triple the amount of bet and dealer lose double the amount of bet 
10. The game repeats until player or dealer goes bankrupt

### **Inputs**
- Bet: 
  - Bet must be between 1 and the amount of player's cash (inclusive)
  - Bet must be an integer, no decimals and no units 
  - Any error in bet input will make the program ask the question again 
- Hit or Stay: 
  - Ignored case "HIT" or "H" means hit
  - Ignored case "STAY" or "S" means stay 
  - Any other input will make the program ask the question again  

## **Challenges Faced**

When I first wrote the code, I wrote it as a one round game, but once I start adding loops in to make it more interested, I encountered several issues, such as that the code goes into an infinite loop or the math is not correct. However, I solved these issues by thouroughly checking my code. I realised that I often put the {} in the wrong place or I forgot to re-initiate variables. Also, there was one problem that was only a problem because I didn't realize it printed so much words at the same time that I thought it didn't do anything at all. After solving the issues, I carefully checked all scenario and now I am confident that the game will run smoothly. 