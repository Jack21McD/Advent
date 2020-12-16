package day_07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * day_07
 */
public class day_07 {

    static List<String> luggageRules = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        String file = "D:/CompSci/CodePersonal/Advent/A/Advent2020/day_07/day7input.txt";
        processFile(file);
        solution(luggageRules);
    }

    public static void processFile(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner input = new Scanner(file);

        while (input.hasNextLine()) {
            String line = input.nextLine();
            luggageRules.add(line);
        }
        input.close();
    }

    public static void solution(List<String> luggageRules) {
        int numContainShinyGold = 0;
        for (String rule : luggageRules) {
            String[] pcs = rule.split("contain");
            String[] pcsTrimmed = new String[pcs.length];
            for (int k = 0; k < pcsTrimmed.length; k++) {
                pcsTrimmed[k] = pcs[k].trim();
            }
            // System.out.println("[" + pcsTrimmed[0] + "] [" + pcsTrimmed[1] + "]");
            // recurse(pcsTrimmed, luggageRules);
            String[] contains = pcs[1].trim().split(", ");
            for (String s : contains) {
                System.out.println(s);
                String[] indPcs = s.split(" ");
                // System.out.println("[" + indPcs[0] + "] [" + indPcs[1] +"] [" + indPcs[2]
                // +"]");
                int numContain;
                if (!indPcs[0].contains("no"))
                    numContain = Integer.parseInt(indPcs[0]);
                else {
                    numContain = 0;
                }

                if ((numContain >= 1) && (indPcs[1].equals("shiny")) && (indPcs[2].equals("gold"))) {
                    numContainShinyGold++;
                    System.out.println("[" + indPcs[0] + "] [" + indPcs[1] + "] [" + indPcs[2] + "]");
                }

            }
            System.out.println("numContainShinyGold: " + numContainShinyGold);
        }
    }

    // public static void recurse(String[] pcs, List<String> luggageRules) {
    // List<String> list = new ArrayList<>();
    // for (String l : pcs)
    // {
    // list.add(l);
    // }
    // }
}