# Lottery Bet Checker

Lottery Bet Checker is a JavaFX application that helps you verify if your bets are winners based on past lottery results. The program allows you to input your bets and the past results of the lottery, and it will calculate how many numbers you got right in each bet. You can also customize the criteria for winning (e.g., how many correct numbers are required to consider a bet a winner).

## Features

- **Input lottery past results**: Upload a CSV file with past lottery results.
- **Input your bets**: Upload a CSV file containing your bets.
- **Customize winning criteria**: Define how many numbers must match to consider a bet a winner (e.g., 4, 5, or 6 numbers).
- **Detailed output**: View which bets are winners and how many numbers matched.

## How It Works

1. **Upload Inputs**:
   - Upload a CSV file containing past lottery results.
   - Upload a CSV file containing your bets.

2. **Set Winning Criteria**:
   - Specify how many numbers you want to consider as a winner (e.g., 4, 5, or 6 correct numbers).

3. **View Results**:
   - The program displays all bets that meet the winning criteria along with the count of matched numbers.

## Example

Imagine a lottery that requires 6 numbers to win the main prize. If you want to see all bets that match at least 4 numbers, you can set the winning criteria to 4. The program will then show all bets with 4, 5, or 6 correct numbers.

## File Formats

To ensure the program works correctly, your input files should follow these formats using semi-colon:
- 1;12;23;34;45;56
- 3;14;27;38;42;49
- 10;20;30;40;50;60;04;03

## Requirements

- Java 17 or higher
- JavaFX library
- CSV files for input (formatted with each row representing a set of numbers)
