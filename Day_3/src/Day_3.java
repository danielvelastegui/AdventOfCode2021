import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day_3 {
    public static void main(String[] args) throws FileNotFoundException {
        File input = new File("src/Diagnostic.txt");
        String binGammaRate = "";
        String binEpsilonRate = "";
        int aux = 0;
        int gammaRate, epsilonRate;
        ArrayList<String> diagnosticArray = new ArrayList<>();
        Scanner diagnostic = new Scanner(input);

        while (diagnostic.hasNext()) {
            String diagnosticRow = diagnostic.nextLine();
            aux = diagnosticRow.length();
            diagnosticArray.add(diagnosticRow);
        }

        for (int i = 1; i < aux + 1; i++) {
            int aux1 = 0;
            int aux0 = 0;

            for (String s : diagnosticArray) {
                if (s.substring(i - 1, i).equalsIgnoreCase("1")) {
                    aux1++;
                } else {
                    aux0++;
                }
            }

            if (aux0 > aux1) {
                binGammaRate += "0";
                binEpsilonRate += "1";
            } else {
                binGammaRate += "1";
                binEpsilonRate += "0";
            }
        }
        System.out.println(binGammaRate);
        System.out.println(binEpsilonRate);

        ArrayList<String> oxygenDiagnostic = (ArrayList<String>) diagnosticArray.clone();
        ArrayList<String> coAux = (ArrayList<String>) diagnosticArray.clone();

        for (int i = 1; i < aux + 1; i++) {
            int aux1 = 0;
            int aux0 = 0;

            for (String s : oxygenDiagnostic) {
                if (s.substring(i - 1, i).equalsIgnoreCase("1")) {
                    aux1++;
                } else {
                    aux0++;
                }
            }

            if(oxygenDiagnostic.size() > 1){
                if (aux0 > aux1) {
                    for (int k = oxygenDiagnostic.size()-1; k > -1; k--) {
                        if (oxygenDiagnostic.get(k).substring(i - 1, i).equalsIgnoreCase("1")) {
                            oxygenDiagnostic.remove(k);
                        }
                    }
                } else {
                    for (int k = oxygenDiagnostic.size()-1; k > -1; k--) {
                        if (oxygenDiagnostic.get(k).substring(i - 1, i).equalsIgnoreCase("0")) {
                            oxygenDiagnostic.remove(k);
                        }
                    }

                }
            }

        }



        for (int i = 1; i < aux + 1; i++) {
            int aux1 = 0;
            int aux0 = 0;

            for (String s : coAux) {
                if (s.substring(i - 1, i).equalsIgnoreCase("1")) {
                    aux1++;
                } else {
                    aux0++;
                }


            }

            if(coAux.size() > 1){
                if (aux0 > aux1) {
                    for (int k = coAux.size()-1; k > -1; k--) {
                        if (coAux.get(k).substring(i - 1, i).equalsIgnoreCase("0")) {
                            coAux.remove(k);
                        }
                    }
                } else {
                    for (int k = coAux.size()-1; k > -1; k--) {
                        if (coAux.get(k).substring(i - 1, i).equalsIgnoreCase("1")) {
                            coAux.remove(k);
                        }
                    }

                }
            }
        }

        System.out.println(oxygenDiagnostic);
        System.out.println(coAux);

    }
}
