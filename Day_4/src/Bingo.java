import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Bingo {
    public static void main(String[] args) throws FileNotFoundException {
        File bingo = new File("src/boards.txt");
        Scanner input = new Scanner(bingo);
        String numbers = input.nextLine();
        String[] chosenNumbers = numbers.split(",");
        ArrayList<String[][]> boards = new ArrayList<>();

        while (input.hasNext()) {
            String[][] board = new String[5][5];
            input.nextLine();
            for (int i = 0; i < 5; i++) {
                String[] number = input.nextLine().split(" ");
                int k = 0;
                for (String s : number) {
                    if (!s.isEmpty()) {
                        board[i][k] = s;
                        k++;
                    }
                }
            }
            boards.add(board);
        }

        for (String chosenNumber : chosenNumbers) {
            game(boards, chosenNumber);
        }

    }

    private static void game(ArrayList<String[][]> boards, String chosenNumber) {
        String[][] completeRow = checkRows(boards, chosenNumber);
        String[][] completeColumn = checkColumns(boards, chosenNumber);

        if (completeRow != null || completeColumn != null) {
            String[][] winnerBoard;
            winnerBoard = Objects.requireNonNullElse(completeRow, completeColumn);

            if (boards.size() > 1) {
                boards.remove(winnerBoard);
                game(boards, chosenNumber);
            } else {
                int sum = 0;
                int result;

                for (int l = 0; l < 5; l++) {
                    for (int k = 0; k < 5; k++) {
                        sum += Integer.parseInt(winnerBoard[l][k]);
                    }
                }

                result = sum * Integer.parseInt(chosenNumber);
                System.out.println(result);
            }
        }
    }

    public static String[][] checkRows(ArrayList<String[][]> boards, String chosenNumber) {
        for (String[][] board : boards) {
            int count = 0;
            for (int i = 0; i < 5; i++) {
                count = 0;
                for (int j = 0; j < 5; j++) {
                    if (board[i][j].equals(chosenNumber)) {
                        board[i][j] = "0";
                    }
                    if (board[i][j].equals("0")) {
                        count++;
                    }
                }
                if (count == 5) {
                    return board;
                }
            }
        }

        return null;
    }

    public static String[][] checkColumns(ArrayList<String[][]> boards, String chosenNumber) {

        for (String[][] board : boards) {
            int count = 0;
            for (int i = 0; i < 5; i++) {
                count = 0;
                for (int j = 0; j < 5; j++) {
                    if (board[j][i].equals("0")) {
                        count++;
                    }
                }
                if (count == 5) {
                    return board;
                }
            }
        }

        return null;
    }
}
