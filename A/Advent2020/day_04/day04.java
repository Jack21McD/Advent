package day_04;

import java.io.*;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * day04
 */

public class day04 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("D:/CompSci/CodePersonal/Advent/A/Advent2020/day_04/day4input.txt");
        Scanner input = new Scanner(file);

        String str = "";
        while (input.hasNextLine()) {
            String line = input.nextLine();
            if (line.isEmpty()) {
                str += "\n";
            }
            str += line + " ";
        }
        String[] temp = str.split("\n");
        String[] temp2 = new String[temp.length];
        for (int k = 0; k < temp2.length; k++) {
            temp2[k] = temp[k].trim();
        }

        List<String> passports = Arrays.asList(temp2);

        // for (String s : passports) {
        // System.out.println(s);
        // }

        // System.out.println();
        System.out.println(validPassports(passports));

    }

    public static int validPassports(List<String> passports) {
        int validCount = 0;
        Map<String, String> keyVal = new HashMap<>();
        // String[] reqKeys = new String[] { "byr", "iyr", "eyr", "hgt", "hcl", "ecl",
        // "pid", "cid"};

        for (String str : passports) {

            String[] linePcs = str.split(" ");
            for (String pc : linePcs) {
                String[] keyVals = pc.split(":");
                // for (String s : keyVals)
                // {
                // // System.out.println(keyVals[0] + " : " + keyVals[1]);
                // // System.out.println();
                // }
                keyVal.put(keyVals[0], keyVals[1]);
                // System.out.println(pc);
            }

            // System.out.println(keyVal);

            if ((keyVal.containsKey("byr")) && (keyVal.containsKey("iyr")) && (keyVal.containsKey("eyr"))
                    && (keyVal.containsKey("hgt")) && (keyVal.containsKey("hcl")) && (keyVal.containsKey("ecl"))
                    && (keyVal.containsKey("pid"))) {
                int byear = Integer.parseInt(keyVal.get("byr"));
                int iyear = Integer.parseInt(keyVal.get("iyr"));
                int eyear = Integer.parseInt(keyVal.get("eyr"));
                String height = keyVal.get("hgt");
                int heightIn = 0;
                int heightCm = 0;
                if (height.endsWith("in")) {
                    heightIn = Integer.parseInt(height.replace("in", ""));
                } else if (height.endsWith("cm")) {
                    heightCm = Integer.parseInt(height.replace("cm", ""));
                }
                String hairColor = keyVal.get("hcl");
                String eyeColor = keyVal.get("ecl");
                String passportId = keyVal.get("pid");
                if (((byear >= 1920) && (byear <= 2002)) && ((iyear >= 2010) && (iyear <= 2020))
                        && ((eyear >= 2020) && (eyear <= 2030))
                        && (((heightIn >= 59) && (heightIn <= 76)) || ((heightCm >= 150) && (heightCm <= 193)))
                        && (hairColor.matches("#[a-f0-9]{6}"))
                        && (eyeColor.equals("amb") || eyeColor.equals("blu") || eyeColor.equals("brn")
                                || eyeColor.equals("grn") || eyeColor.equals("gry") || eyeColor.equals("hzl")
                                || eyeColor.equals("oth"))
                        && (passportId.matches("[0-9]{9}"))) {
                    validCount++;
                }
            }
            keyVal.clear();
            // System.out.println(keyVal);
        }

        return validCount;
    }
}