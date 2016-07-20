# poker-hands
This is a poker back-end logic for comparing 2 hands of 5 cards and picking the winner hand. This is still a WIP with lots of room for improvements.


Instructions:

Download the poker-hands-0.0.1-SNAPSHOT.jar located on the target directory ("/target/poker-hands-0.0.1-SNAPSHOT.jar") and execute the application by running on your terminal:

java -jar poker-hands-0.0.1-SNAPSHOT.jar

A prompt will ask for user input for the first hand.


Allowed card values:
  2, 3, 4, 5, 6, 7, 8, 9, T, J, Q, K, A
  
  where T = 10, J = Jack, Q = Queen, K = King, A = Ace
  
Allowed card suites:
  C, D, H, S
  
  where C = Clubs, D = Diamonds, H = Hearts, S = Spades


Valid inputs follows this example:

2C 3D TH QS AD

Where the first character is the card value and the second is the card suit. They must be paired and cards separated by spaces, tabs or an enter key. You can also input one card at a time or even pick the card suite first followed by a value. 

Expect some input validation. The software will request another card if the input isn't a card or when the card was already picked before.

The following example is valid as well:

d4 Kc

4h

S7 tS

Using the inputs above, the software will produce the following output:

Hand #1

A of DIAMONDS

Q of SPADES

T of HEARTS

3 of DIAMONDS

2 of CLUBS

Rank: HIGH_CARD

Hand #2

4 of HEARTS

4 of DIAMONDS

K of CLUBS

T of SPADES

7 of SPADES

Rank: PAIR

Hand #2 wins with PAIR
