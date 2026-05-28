# Console Blackjack

A text-based Blackjack game built in Java, designed around object-oriented principles. This project was developed for CS 3300 (Software Engineering) and emphasizes clean class design, inheritance, and input handling over a six-class architecture.

## Overview

The game simulates a single player against a dealer, following standard Blackjack rules. The player starts with a balance, places bets each round, and plays until they run out of money. The dealer follows the standard "hit until 17" rule, and the game correctly handles the dual value of Aces (1 or 11).

The architecture was modeled with a UML class diagram before any code was written, defining class responsibilities and relationships up front.

## Features

- **Full Blackjack game loop** — betting, dealing, player turns, dealer turns, and payout resolution
- **Inheritance** — `Dealer` extends `Player`, reusing hand and balance logic while adding dealer-specific behavior
- **Recursive Ace handling** — a recursive algorithm downgrades Aces from 11 to 1 when a hand would otherwise bust
- **Exception handling** — invalid (non-numeric) bet inputs are caught and re-prompted rather than crashing the program
- **Balance-aware betting** — bets are constrained to the player's available balance
- **Type safety** — card suits and ranks are modeled with enums rather than raw strings or integers

## Architecture

The project is organized into six classes, each with a single responsibility:

| Class | Responsibility |
|-------|----------------|
| `Card` | Represents a single card; holds suit/rank enums and returns card value |
| `Deck` | Builds, shuffles, and deals from a 52-card deck |
| `Player` | Manages a player's hand, balance, and hand-total calculation (including Ace logic) |
| `Dealer` | Extends `Player`; adds dealer hit logic and hidden-card display |
| `Game` | Orchestrates the game loop, betting, turns, and winner determination |
| `Main` | Entry point; instantiates and starts the game |

### Design highlights

**Inheritance:** `Dealer` extends `Player` because a dealer *is* a player with added rules. This avoids duplicating hand and balance management and keeps dealer-specific behavior (`shouldHit()`, `showHiddenCard()`) isolated.

**Recursive hand evaluation:** Aces are valued at 11 by default. When a hand total exceeds 21, the `calculateTotal()` method recursively reduces one Ace's value by 10 and re-checks, preventing unnecessary busts:

```java
public int calculateTotal(ArrayList<Card> hand, int total) {
    if (total <= 21) {
        return total;                       // base case: valid total
    }
    for (Card c : hand) {
        if (c.getValue() == 11) {
            return calculateTotal(hand, total - 10);  // downgrade an Ace and re-check
        }
    }
    return total;                           // base case: no Aces left to downgrade
}
```

**Input validation:** Bet entry is wrapped in a `try/catch` for `InputMismatchException`, so a non-numeric entry prompts the user again instead of crashing.


## Possible Improvements

- Add support for split and double-down actions
- Implement a graphical interface (JavaFX or Swing)
- Add unit tests (JUnit) for hand evaluation and payout logic
- Support multiple players at one table

## Tech Stack

Java · Object-Oriented Programming · Recursion · Exception Handling · UML

---

*Built as a course project for CS 3300 (Software Engineering) at the University of Houston-Downtown.*
