package day_05;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * day_05
 */
public class day_05 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("D:/CompSci/CodePersonal/Advent/A/Advent2020/day_05/day5input.txt");
        Scanner input = new Scanner(file);
        List<String> bp = new ArrayList<>();
        List<String> bpSplit = new ArrayList<>();

        while (input.hasNextLine()) {
            bp.add(input.nextLine());
        }
        input.close();

        for (String str : bp) {
            // System.out.println(str);
            bpSplit.add(str.substring(0, 7) + " " + str.substring(7, 10));
        }

        // for (String str : bpSplit)
        // {
        // System.out.println(str);
        // }
        process(bpSplit);
        // System.out.println(process(bpSplit));
    }

    public static int process(List<String> bpSplit) {
        List<Integer> uniqueId = new ArrayList<>();

        for (String str : bpSplit) {
            String[] pcs = str.split(" ");
            // System.out.println(pcs[0] + " : " + pcs[1]);
            int r = rowCalc(pcs[0]);
            int c = colCalc(pcs[1]);
            int sId = (r * 8) + c;
            // System.out.println("rowId: " + r + " colId: " + c + " sId: " + sId);
            uniqueId.add(sId);
        }

        Collections.sort(uniqueId);
        // Collections.reverse(uniqueId);
        // for (int x : uniqueId)
        // {
        // System.out.print(x + " ");
        // }

        missingIds(uniqueId);

        return uniqueId.get(0);
    }

    public static int rowCalc(String rowDir) {
        int minRow = 0;
        int maxRow = 127;
        int row = 0;

        for (int k = 0; k < rowDir.length(); k++) {
            if (rowDir.charAt(k) == 'F') {
                maxRow = (minRow + maxRow) / 2;
            }
            if (rowDir.charAt(k) == 'B') {
                minRow = ((minRow + maxRow) / 2) + 1;
            }
        }

        if (rowDir.endsWith("F"))
            row = minRow;
        else if (rowDir.endsWith("B"))
            row = maxRow;

        return row;
    }

    public static int colCalc(String colDir) {
        int minCol = 0;
        int maxCol = 7;
        int col = 0;

        for (int k = 0; k < colDir.length(); k++) {
            if (colDir.charAt(k) == 'L') {
                maxCol = (minCol + maxCol) / 2;
            }
            if (colDir.charAt(k) == 'R') {
                minCol = ((minCol + maxCol) / 2) + 1;
            }
        }

        if (colDir.endsWith("L"))
            col = minCol;
        else if (colDir.endsWith("R"))
            col = maxCol;
        return col;
    }

    public static void missingIds(List<Integer> uniqueId)
    {
        List<Integer> missIds = new ArrayList<>();
        int index = 0;
        int id = 78;
        while (index < 881)
        {
            System.out.println("index: " + index + " id: " + id + " uniqueId: " + uniqueId.get(index));
            if (uniqueId.get(index) != id)
            {
                missIds.add(id);
            }
            index++;
            id++;
        }

        System.out.println(missIds.get(0));
    }
}