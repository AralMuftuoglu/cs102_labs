package CS102_Sec1_Asgn5_Muftuoglu_Aral;

import java.lang.Math;

public class patterns {
    
    public static char[][] rowsAndColumns;
    
    //createArray method
    public static void createArray (int numRows, int numColumns)
    {
        rowsAndColumns = new char[numRows][numColumns];
    }

    //recursive fillChar method
    public static void fillChar(char c, int rowStart, int rowEnd, int columnStart, int columnEnd)
    {
        fillRows(c, columnStart, columnEnd, rowStart);      

        if(rowStart+1!=rowEnd)
        {
            fillChar(c, rowStart+1, rowEnd, columnStart, columnEnd);
        }
    }
    //helper fillRows method
    private static void fillRows(char c, int columnStart,int columnEnd,int row)
    {
        rowsAndColumns[row][columnStart]=c;

        if(columnStart+1!=columnEnd)
        {
            fillRows(c, columnStart+1, columnEnd,row);
        }
    }
    
    //pattern1 
    public static void pattern1()
    {
       pattern1_helper('*', '#', 0, rowsAndColumns.length, 0, rowsAndColumns[0].length);
    }
    //pattern1 helper
    private static void pattern1_helper(char c1,char c2,int startRow,int endRow,int startColumn,int endColumn)
    {
        fillChar(c1, startRow, endRow, startColumn, endColumn);

        if(endRow-1<=startRow+1||endColumn-1<=startColumn+1)
        {
            return;
        }
        else
        {
            pattern1_helper(c2, c1, startRow+1, endRow-1, startColumn+1, endColumn-1);
        }
    }
   
    //pattern2
    public static void pattern2(int fillWidth, int shiftAmount)
    {
        fillChar('#', 0, rowsAndColumns.length, 0, rowsAndColumns[0].length);
        
        pattern2_helper(0, rowsAndColumns.length, 0, rowsAndColumns[0].length,fillWidth,shiftAmount);
    }
    //pattern2 helper
    private static void pattern2_helper(int startRow, int endRow, int startColumn,int endColumn,int width,int shift)
    {
        if(startColumn+width<=endColumn)
        {
            fillChar('*', startRow, startRow+1, startColumn, startColumn+width);
        }
        else
        {
            fillChar('*', startRow, startRow+1, startColumn, endColumn);
            fillChar('*', startRow, startRow+1, 0, width-endColumn+startColumn);
        }
        
        if(startRow+1!=endRow)
        {
            if(startColumn+shift<=endColumn)
            {
                pattern2_helper(startRow+1, endRow, startColumn+shift, endColumn, width, shift);
            }
            else
            {
                pattern2_helper(startRow+1, endRow, startColumn+shift-endColumn, endColumn, width, shift);
            }
        }
    }
    
    //pattern3
    public static void pattern3()
    {
        fillChar('1', 0, rowsAndColumns.length, 0, rowsAndColumns[0].length);
        
        pattern3_helper(1, rowsAndColumns.length, 1, rowsAndColumns[0].length-1);
    }
    //pattern3 helper method
    private static void pattern3_helper(int startRow,int endRow ,int startColumn,int endColumn)
    {
        char c;
        int numeric_c;

        int leftNeighbor=Character.getNumericValue(rowsAndColumns[startRow][startColumn-1]);
        int upNeighbor=Character.getNumericValue(rowsAndColumns[startRow-1][startColumn]);
        
        numeric_c=(upNeighbor+leftNeighbor)%10;

        c=String.valueOf(numeric_c).charAt(0);

        rowsAndColumns[startRow][startColumn]=c;

        if(startColumn!=endColumn)
        {
            pattern3_helper(startRow, endRow, startColumn+1, endColumn);
        }
        else
        {
            if(startRow+1!=endRow)
            {
                pattern3_helper(startRow+1, endRow, 1, endColumn);
            }
        }
    }
    
    //findMaxRowSum
    public static int findMaxRowSum()
    {

        int maxTotal= maxSum(rowsAndColumns.length-1);

        return maxTotal;
   
    }
    //helper
    private static int sumOfRow(int row,int startColumn, int endColumn)
    {
        int numeric_c=0;

        char c= rowsAndColumns[row][endColumn];

        numeric_c=Integer.parseInt(String.valueOf(c));
        
        if(endColumn-1>=0)
        {
            return numeric_c+sumOfRow(row, startColumn, endColumn-1);
        }
        else
        {
            return numeric_c;
        }
    }
    //helper
    private static int maxSum(int lastRow)
    {
        if(lastRow-1>=0)
        {
            return Math.max(sumOfRow(lastRow, 0, rowsAndColumns[0].length-1),maxSum(lastRow-1));    
        }
        else
        {
            return sumOfRow(lastRow, 0, 0);
        }
    }
   
   
   
   
   
   
    //recursive print method
    public static void print(int startRow)
    {
        printRow(startRow, 0);

        System.out.println();

        if(startRow+1!=rowsAndColumns.length)
        {
            print(startRow+1);
        }
    }
    //Helper printRow method
    public static void printRow(int row, int currentColumn)
    {
        if(rowsAndColumns[row][currentColumn]==Character.MIN_VALUE)
        {
            System.out.print(" ");
        }
        else
        {        
            System.out.print(rowsAndColumns[row][currentColumn]);
        }

        if(currentColumn+1!=rowsAndColumns[0].length)
        {
            printRow(row, currentColumn+1);
        }
    }

}   
