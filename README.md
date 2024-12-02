<b>Phase 3 README file</b>

Group Name:
Team 12

Group Member(s):
Samuel Poulis (cut14@txstate.edu)

CS.3354 Fall Semester 2024 Object Oriented Programming and Design


ChessGUI Screenshots to Show off User interface:


First up, we got the endgame message! (This has since been updated to the checkmate message)

![endgame](https://github.com/user-attachments/assets/47ee5964-0849-4a13-a24b-1e6bfa6191ef)






Now we have got a game in-action:


![7moves](https://github.com/user-attachments/assets/f2af7a95-c2d1-40ba-bae8-793a149b1588)






The message displayed when there is an invalid move, including protecting the king if you are moving into line of fire:
![image](https://github.com/user-attachments/assets/5f7a112c-f975-40bc-8490-ea11a16731cf)





Now whenever a king is in check:

![image](https://github.com/user-attachments/assets/8c539e16-8cf2-470c-88ac-6fc0146e2375)




Black Promoted to Queen from pawn, and white in Check:

![image](https://github.com/user-attachments/assets/24ccdfe7-65ce-41c8-9235-12cd65f016e6)





Finally, the checkmate message:

![image](https://github.com/user-attachments/assets/7c6e685f-821a-4f66-be6b-8b7d334b8b00)









Here is the UML class diagram for the chess game, the arrows represent the structure or hiarchy of execution and the relationships between differnt components of the game:
![image](https://github.com/user-attachments/assets/3aaa5054-6cd6-4241-bbb8-ce7b3cabbd28)




HOW TO RUN THE CHESS GAME:

1.) Clone the repository
2.) Navigate to the source directory and run the command 'javac board/*.java pieces/*.java utils/*.java *.java' to recompile the program for your javac version.
3.) Use java Main.java to run the program.
NOTE: Make sure you use the same javac and java versions to compile and run the program or you may run in to errors. 




FEATURES CHECKLIST:

- Chess game console logic
- Board movement logic
- Chess pieces logic for each piece type
- Graphical User Interface (GUI) with pieces *.png files found on the internet
- Drag and drop style user interface
- Chess piece movement rules for check
- Game rules logic
- Check logic and message
- Checkmate logic and message
- Promotion from pawn with selection for piece type
- Achieved Fully functional chess game with GUI

