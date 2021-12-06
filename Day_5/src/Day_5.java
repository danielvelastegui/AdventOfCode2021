import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day_5 {
    public static void main(String[] args) throws FileNotFoundException {
        File linesVents = new File("src/linesVents.txt");
        Scanner input = new Scanner(linesVents);
        int size = max() + 1;
        int[][] diagram = new int[size][size];
        int count = 0;

        while (input.hasNext()){
            String[] coordinates = input.nextLine().split(" -> ");
            int x1 = Integer.parseInt(coordinates[0].split(",")[0]);
            int y1 = Integer.parseInt(coordinates[0].split(",")[1]);
            int x2 = Integer.parseInt(coordinates[1].split(",")[0]);
            int y2 = Integer.parseInt(coordinates[1].split(",")[1]);

            if (x1 == x2){
                if (y1 < y2){
                    for (int i = y1; i <= y2; i++){
                        diagram[i][x1] ++;
                        if (diagram[i][x1] == 2){
                            count++;
                        }
                    }
                }else {
                    for (int i = y2; i <= y1; i++){
                        diagram[i][x1] ++;
                        if (diagram[i][x1] == 2){
                            count++;
                        }
                    }
                }
            }else if (y1 == y2){
                if (x1 < x2){
                    for (int i = x1; i <= x2; i++){
                        diagram[y1][i] ++;
                        if (diagram[y1][i] == 2){
                            count++;
                        }
                    }
                }else{
                    for (int i = x2; i <= x1; i++){
                        diagram[y1][i] ++;
                        if (diagram[y1][i] == 2){
                            count++;
                        }
                    }
                }
            }else{
                if(x1 < x2 && y1 < y2){
                    while(x1 <= x2){
                        diagram[y1][x1] ++;
                        if (diagram[y1][x1] == 2){
                            count++;
                        }
                        x1++;
                        y1++;
                    }
                }else if(x1 > x2 && y1 > y2){
                    while(x1 >= x2){
                        diagram[y1][x1] ++;
                        if (diagram[y1][x1] == 2){
                            count++;
                        }
                        x1--;
                        y1--;
                    }
                }else if(x1 < x2 && y1 > y2){
                    while(x1 <= x2){
                        diagram[y1][x1] ++;
                        if (diagram[y1][x1] == 2){
                            count++;
                        }
                        x1++;
                        y1--;
                    }
                }else if(x1 > x2 && y1 < y2){
                    while(x1 >= x2){
                        diagram[y1][x1] ++;
                        if (diagram[y1][x1] == 2){
                            count++;
                        }
                        x1--;
                        y1++;
                    }
                }
            }

        }

        System.out.println(count);
    }

    static int max() throws FileNotFoundException {
        File linesVents = new File("src/linesVents.txt");
        Scanner input = new Scanner(linesVents);
        ArrayList<Integer> aux = new ArrayList<>();
        while (input.hasNext()) {
            String[] coordinates = input.nextLine().split(" -> ");
            int x1 = Integer.parseInt(coordinates[0].split(",")[0]);
            int y1 = Integer.parseInt(coordinates[0].split(",")[1]);
            int x2 = Integer.parseInt(coordinates[1].split(",")[0]);
            int y2 = Integer.parseInt(coordinates[1].split(",")[1]);
            aux.add(x1);
            aux.add(y1);
            aux.add(x2);
            aux.add(y2);
        }

        return Collections.max(aux);
    }
}
