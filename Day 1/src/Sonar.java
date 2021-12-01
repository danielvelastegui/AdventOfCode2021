import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Sonar {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Integer> sonarReport = new ArrayList<>();
        ArrayList<Integer> sonarReportSum = new ArrayList<>();
        File report = new File("src/Report.txt");
        Scanner input = new Scanner(report);
        int sonarSweepIncreased = 0;

        while(input.hasNext()){
            sonarReport.add(input.nextInt());
        }

        for(int i = 2; i < sonarReport.size(); i++){
            int sum = sonarReport.get(i) + sonarReport.get(i-1) + sonarReport.get(i-2);
            sonarReportSum.add(sum);
        }

        for(int i = 0; i < sonarReportSum.size(); i++){
            if (i==0){
                System.out.println(sonarReportSum.get(i) + "\t(N/A - no previous measurement)");
            }else if (sonarReportSum.get(i) > sonarReportSum.get(i-1)){
                System.out.println(sonarReportSum.get(i) + "\t(increased)");
                sonarSweepIncreased++;
            }else if (sonarReportSum.get(i) < sonarReportSum.get(i-1)){
                System.out.println(sonarReportSum.get(i) + "\t(decreased)");
            }else{
                System.out.println(sonarReportSum.get(i) + "\t(no change)");
            }
        }

        System.out.println( sonarSweepIncreased + " measurements are larger than the previous measurement");
    }

}
