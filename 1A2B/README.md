This is a game called 1A2B. In this game, the computer randomly generates a number where there are no repeated digits for the user to guess. After guessing, the computer calculates the result of A (the number of digits that are correct and in the right position) and the result of B (the number of digits that are correct but in the wrong position). The the computer prints the results out as a table for the user to use as a hint. The process repeats until the user guesses the correct answer. 

After running the program, the computer will first ask the user if they want to play. The program will stop if the answer is "no." Then, it will ask how many digits the user wants to play. Next, the computer asks if the user knows how to play the game. If the answer is "no", the computer prints out the instruction. After that, the game begins. 

This process repeats until the user guesses the answer: 
1. The computer asks for the user's guess. 
2. The computer calculates the results. 
3. The computer prints out a table showing all results of the user's guesses. 

When the user finally guesses the answer, the computer says congratulations and goes back to ask the user if they want to play again. 

I encountered several problems when I was making this game: 
1. I didn't know how to record all the guesses the user made. 
    > I googled array and found array list. It is very useful. 
2. I didn't know how to separate the digits from a number so I made the user key in a digit at a time, which was very difficult to explain. 
    > I solved it using the fact that after dividing, java doesn't round numbers. 
3. The first scanner input was skipped in while loop. 
    > I changed from using *nextLine()* to *next()*. I also deleted the *kb.close()* in the methods. I forgot which one worked but it worked. 
4. When the user input a invalid guess, the program still tries to make sense out of it. 
    > I made it so that if the input is out of range, it prints out "???" as a reply. I still don't know what to do if the user type in something that is not an integer. 
5. VS Code keeps saying there's resource leak because I didn't close the scanner. 
    > Since it doesn't really matter, I ignored it. 

I don't know what I would have done differenly if I can do it again, but I think next time, I will do this in class if I have time, so I can just ask Ms. Tina if I have questions. It would be so much easier and faster than googling. 
