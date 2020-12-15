package day_06;

import java.io.File;
import java.io.FileNotFoundException;

import javax.print.attribute.HashAttributeSet;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

import java.util.*;

/**
 * day_06
 */
public class day_06 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("D:/CompSci/CodePersonal/Advent/A/Advent2020/day_06/day6input.txt");
        Scanner input = new Scanner(file);
        String str = "";
        while (input.hasNextLine()) {
            String line = input.nextLine();
            if (line.isEmpty())
                str += "\n";
            str += line + " ";
        }
        input.close();
        String[] tmp = str.split("\n");
        String[] tmp2 = new String[tmp.length];
        for (int k = 0; k < tmp2.length; k++) {
            tmp2[k] = tmp[k].trim();
        }

        List<String> questions = Arrays.asList(tmp2);

        // for (String s : questions)
        // {
        // System.out.println(s);
        // }

        numYes(questions);
    }

    public static int numYes(List<String> questions) {
        // int yesCount = 0;
        int allYesCount = 0;
        // List<Character> yes = new ArrayList<>();
        char[] ques = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
                'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
        Map<Character, Integer> numAns = new HashMap<>();

        for (String str : questions) {
            // Fill hashmap w/ blank alphabet
            for (char c : ques) {
                numAns.put(c, 0);
            }

            String[] pcs = str.split(" ");
            for (String s : pcs) {
                for (int k = 0; k < s.length(); k++) {
                    if (numAns.containsKey(s.charAt(k))) {
                        numAns.put(s.charAt(k), numAns.get(s.charAt(k)) + 1);
                    }
                }
            }

            System.out.println(numAns);
            for (int i : numAns.values()) {
                if (i == pcs.length) {
                    allYesCount++;
                }
            }
            System.out.println("allYesCount: " + allYesCount);
            // System.out.println(yes);
            // yesCount += yes.size();
            // System.out.println("yesCount: " + yesCount);
            // yes.clear();
            numAns.clear();
        }
        // System.out.println("Final count: " + yesCount);
        // return yesCount;
        System.out.println("Final count: " + allYesCount);
        return allYesCount;
    }
}