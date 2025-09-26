Tambola Game in Java

🎮 Overview

This is a console-based Tambola (Bingo) game implemented in Java using Object-Oriented Programming principles.
The game supports:
Playing with a bot (computer player)
Playing with friends (2–6 human players)
Manual strikes for every drawn number
Automatic strikes for bots
Color-coded console output for better user experience
Unique numbers in each ticket (no duplicates)
Ticket display after each draw

🕹️ How to Play
Run the game in the console.
Choose one of the options:
Play with Bot → 2 players: human + bot
Play with Friends → 2–6 human players
Each player receives a ticket with 3 rows and 9 columns.
Each row has 5 numbers filled randomly.
Numbers in each column follow Tambola rules:
Column 1 → 1–9
Column 2 → 10–19
…
Column 9 → 90–99
A random number (1–99) is drawn each turn.
Human players are prompted for every number:
Do you want to strike number X? (yes/no)
If the number is on their ticket, it is struck (XX).
If not, a warning is displayed.
Bots automatically strike numbers present on their ticket.
Tickets are displayed after every draw.
The first player to strike all their numbers wins the game.

📝 Features

Object-Oriented Design: Classes used:
Main → Game entry point
Game → Manages game logic, number drawing, and turns
Player → Abstract class for players
HumanPlayer → Extends Player
Bot → Extends Player with auto-strike logic
Ticket → Generates and manages the ticket
Red → Missed / Number not on ticket
Duplicate-free tickets: Ensures all numbers are unique across the ticket
