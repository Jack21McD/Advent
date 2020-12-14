package day_03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day03 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("D:/CompSci/CodePersonal/Advent/A/Advent2020/day_03/day03input.txt");
        Scanner user = new Scanner(file);
        
        char[][] mtn = new char[323][10013];
        int row = 0;
        //int col = 0;

        while (user.hasNextLine())
        {
            String line = user.nextLine();
            String repatedLine = repeatString(line, 323);
            for (int k = 0; k < repatedLine.length(); k++)
            {
                mtn[row][k] = repatedLine.charAt(k);
            }
            row++;
        }

        //Mtn(mtn);
        System.out.println(treesHit(mtn));

    }

    public static String repeatString(String str, int x)
    {
        String copy = str;
        for (int k = 0; k < x - 1; k++)
        {
            str += copy;
        }
        return str;
    }

    public static void Mtn(char[][] mtn)
    {
        //int row = 1;
        for (int rows = 0; rows < mtn.length; rows++)
        {
            for (int cols =  0; cols < mtn[0].length; cols++)
            {
                System.out.print(mtn[rows][cols]);
            }
            System.out.print(" (row " + rows + ")");
            System.out.println();
        }
    }

    public static int treesHit(char[][] mtn)
    {
        int row = 0;
        int col = 0;
        int numTreesHit = 0;
        while (row < 323)
        {
            if (mtn[row][col] == '#')
            {
                numTreesHit++;
            }
            // 1/3 slope
            row += 2;
            col += 1;
            // slope 1 : 55
            // slope 1/3 : 250
            // slope 1/5 : 54
            // slope 1/7 : 55
            // slope 2 : 39
            // multiplied : 1592662500
        }
        return numTreesHit;

        // for (int row = 1; row < 323; row++)
        // {
        //     for (int col = 2; col < mtn[0].length; col += 3)
        //     {
        //         if (mtn[row][col] == '#')
        //         {
        //             numTreesHit++;
        //         }
        //     }
        // }
        // return numTreesHit;
    }
}
