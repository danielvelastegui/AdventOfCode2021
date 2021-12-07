import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Day_7 {
    public static void main(String[] args) throws FileNotFoundException {
        File positions = new File("src/Positions.txt");
        Scanner input = new Scanner(positions);
        String[] strPositions = input.nextLine().split(",");
        ArrayList<Integer> intPositions = new ArrayList<>();
        ArrayList<Integer> possibleFuel = new ArrayList<>();
        int fuel = 0;

        for(String s: strPositions){
            intPositions.add(Integer.parseInt(s));
        }

        for (int i = 1; i <= Collections.max(intPositions); i++){
            for(int aux: intPositions){
                int auxfuel = Math.abs(i-aux);
                fuel += ((auxfuel*(auxfuel+1))/2);
            }
            possibleFuel.add(fuel);
            fuel = 0;
        }


        System.out.println(Collections.min(possibleFuel));

    }
}
