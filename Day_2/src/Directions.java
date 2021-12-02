import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Directions {

    public static void main(String[] args) throws FileNotFoundException {
        File directions = new File("src/Directions.txt");
        String entireDirection;
        int horizontal = 0;
        int depth = 0;
        int aim = 0;
        Scanner input = new Scanner(directions);

        while (input.hasNext()) {
            entireDirection = input.nextLine();
            String[] direction = entireDirection.split("[ ]");
            switch (direction[0]) {
                case "forward":
                    horizontal += Integer.parseInt(direction[1]);
                    depth += (aim * Integer.parseInt(direction[1]));
                    break;
                case "down":
                    aim += Integer.parseInt(direction[1]);
                    break;
                case "up":
                    aim -= Integer.parseInt(direction[1]);
                    break;
                default:
                    System.out.println("Error en la lectura de las direcciones");
                    break;
            }

        }
        System.out.println("Horizontal position:" + horizontal);
        System.out.println("Depth position:" + depth);
        System.out.println("Aim: " + aim);
        System.out.println("Total:" + (horizontal * depth));

    }
}
