# Simple Tic Tac Toe Game

## Introduction
This game was created as part of the Jetbrains Academy Java Track curriculum.

## Project Structure

The project is divided into 3 classes,
1. `Main`: starts up the game
2. `Game`: contains core game methods
3. `Analyzer`: contains methods for checking the game state

## User Interaction

1. The game prints the starting board (empty by default)
2. The user is prompted to enter a coordinate to input the first symbol (currently hardcoded to X)
3. The game validates the input and places symbol if
   1. The coordinates are valid numbers
   2. The coordinates fall within the game board range
   3. The destination cell is not empty
4. The game checks and prints the state board after every move by the user.
5. There are 4 states that the game can be in
   1. "Game not finished"
   2. "X" or "O" wins
   3. "Draw"
   4. "Impossible": A future state yet to be implemented [#TODO]
6. The game will only continue accepting input on **state 1** but will stop, print the board and result on any other state
<br />
<br />
NOTE: The input coordinates start at 1 but are adjusted to correspond with proper array elements
## Main Topic Coverage
- Working with Multidimensional Arrays

## Future Improvements
- [ ] Choose first player
- [ ] Commands method so user chooses whether to start from scratch or enter existing game state
- [ ] choose which player goes first
- [ ] redo ability
- [ ] replay ability
- [ ] add history
- [ ] add custom game such as best of 3 or 5
- [ ] Add single player mode with AI

## Acknowledgements

- I would like to thank Jetbrains Academy for being such an amazing learning platform.
- GeeksForGeeks for being an invaluable reference resource
- Stackoverflow for having all the answers when am stuck 😂