package tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] field = new char[][]{
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };

        render(field);

        boolean isXTurn = true;
        int turnCount = 0;

        while (true) {
            int y = readUserInput(scanner);
            if (y == -1) {
                continue;
            }

            int x = readUserInput(scanner);
            if (x == -1) {
                continue;
            }

            if (!isValidCoordinates(y, x) || !isValidPosition(field, y, x)) {
                continue;
            }

            field[y - 1][x - 1] = isXTurn ? 'X' : 'O';
            isXTurn = !isXTurn;

            turnCount++;

            render(field);

            boolean isXWin;
            boolean isOWin;

            isXWin = checkWinner(field, 'X');
            isOWin = checkWinner(field, 'O');

            if (isXWin) {
                System.out.println("X wins");
                break;
            } else if (isOWin) {
                System.out.println("O wins");
                break;
            } else if (turnCount == 9) {
                System.out.println("Draw");
                break;
            }
        }

    }

    private static void render(char[][] field) {
        String grid = """
                ---------
                | %c %c %c |
                | %c %c %c |
                | %c %c %c |
                ---------""";

        System.out.printf(grid + "%n",
                field[0][0], field[0][1], field[0][2],
                field[1][0], field[1][1], field[1][2],
                field[2][0], field[2][1], field[2][2]
        );
    }

    private static int readUserInput(Scanner scanner) {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("You should enter numbers!");
            scanner.nextLine();
            return -1;
        }
    }

    private static boolean isValidCoordinates(int y, int x) {
        if (y < 1 || y > 3 || x < 1 || x > 3) {
            System.out.println("Coordinates should be from 1 to 3!");
            return false;
        }
        return true;
    }

    private static boolean isValidPosition(char[][] field, int y, int x) {
        if (field[y - 1][x - 1] != ' ') {
            System.out.println("This cell is occupied! Choose another one!");
            return false;
        }
        return true;
    }

    private static boolean checkWinner(char[][] field, char player) {
        return checkVertical(field, player) || checkHorizontal(field, player) || checkDiagonals(field, player);
    }

    private static boolean checkVertical(char[][] field, char player) {
        for (int i = 0; i < 3; i++) {
            if (field[0][i] == field[1][i] && field[1][i] == field[2][i]) {
                if (field[0][i] == player) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkHorizontal(char[][] field, char player) {
        for (int i = 0; i < 3; i++) {
            if (field[i][0] == field[i][1] && field[i][1] == field[i][2]) {
                if (field[i][0] == player) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkDiagonals(char[][] field, char player) {
        if (field[0][0] == field[1][1] && field[1][1] == field[2][2] ||
                field[2][0] == field[1][1] && field[1][1] == field[0][2]) {
            return field[1][1] == player;
        }
        return false;
    }

}
