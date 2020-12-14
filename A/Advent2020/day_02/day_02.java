package day_02;
/**
 * day_02
 */

import java.util.*;
import java.io.*;

public class day_02 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("D:/CompSci/CodePersonal/Advent/A/Advent2020/day_02/day02input.txt");
        Scanner user = new Scanner(file);
        ArrayList<String> pwds = new ArrayList<String>();

        // Adds the pwds from the file line by line into an arraylist to be processed
        // later.
        while (user.hasNextLine()) {
            pwds.add(user.nextLine());
        }

        // for(String pw : pwds)
        // {
        // System.out.println(pw);
        // }

        System.out.println(numValidPwds(pwds));
        System.out.println(numValidPwds2(pwds));
    }

    // Part 1
    public static int numValidPwds(ArrayList<String> pwds) {
        int numValid = 0;

        // runs through all of the pwds checking validity
        for (String pw : pwds) {
            // Splits the pw into 2 sections of instructions, and then pw
            String[] pcs = pw.split(" ");
            String[] minMax = pcs[0].split("-");
            int min = Integer.parseInt(minMax[0]);
            int max = Integer.parseInt(minMax[1]);
            char c = pcs[1].charAt(0);
            String pass = pcs[2];

            // Runs through the pw based on the given char requirement.
            int numChar = 0;
            for (int k = 0; k < pass.length(); k++) {
                if (pass.charAt(k) == c)
                    numChar++;
            }

            if ((numChar >= min) && (numChar <= max))
                numValid++;
        }
        return numValid;
    }

    public static int numValidPwds2(ArrayList<String> pwds) {
        int numValid = 0;

        for (String pw : pwds) {
            String[] pcs = pw.split(" ");
            String[] pos = pcs[0].split("-");
            int pos1 = Integer.parseInt(pos[0]);
            int pos2 = Integer.parseInt(pos[1]);
            char c = pcs[1].charAt(0);
            String pswd = pcs[2];

            if (((pswd.charAt(pos1 - 1) == c) && (pswd.charAt(pos2 - 1) == c))
                    || ((pswd.charAt(pos1 - 1) != c) && (pswd.charAt(pos2 - 1) != c))) {
                continue;
            } else if ((pswd.charAt(pos1 - 1) == c) && (pswd.charAt(pos2 - 1) != c)) {
                numValid++;
            } else if ((pswd.charAt(pos1 - 1) != c) && (pswd.charAt(pos2 - 1) == c)) {
                numValid++;
            }
        }
        return numValid;
    }

}