import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Day_6 {
    public static void main(String[] args) throws IOException {
        File lanternfish = new File("src/Lanternfish.txt");
        int days = 256;
        ArrayList<Integer> listFish = new ArrayList<>();
        Scanner input = new Scanner(lanternfish);
        String[] sListFish = input.nextLine().split(",");
        for(String s: sListFish){
            listFish.add(Integer.parseInt(s));
        }

        int daysLeft;

        for(int i = 0; i < days; i++){
            for (int j = 0; j < listFish.size(); j++){
                if (listFish.get(j) > 0){
                    daysLeft = listFish.get(j);
                    listFish.set(j, --daysLeft);
                }else if (listFish.get(j) == 0){
                    listFish.set(j, 6);
                    listFish.add(9);
                }
            }
        }

        System.out.println("El numero de peces es: " + listFish.size());

    }
}
