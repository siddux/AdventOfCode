import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.io.*;


public class Main {

    public static void main(String[] args) throws FileNotFoundException{

        File file        = new File( "/Users/eduardriusmartinez/Desktop/AdventOfCode/Day8/2/src/input.txt" );
        Scanner myReader = new Scanner( file );
        List<int[]> instructionsTable = new LinkedList<int[]>();
        List<int[]> originalInstructionsTable = new LinkedList<int[]>();
        int acc = 0;
        int i = 0;
        int previousI = -1;
        int[] previousLine = new int[3];
        boolean flag = false;

        while (myReader.hasNextLine()){

            String data = myReader.nextLine();
            int[] instructionLine = new int[3];
            int number = 0;

            String line[] = data.split( " " );
            String instruction = line[0];
            if (instruction.equals( "acc" )){
                instructionLine[0] = 1;
            }
            else if(instruction.equals( "jmp" )){
                instructionLine[0] = 2;
            }
            else if(instruction.equals( "nop" )){
                instructionLine[0] = 3;
            }

            if(line[1].charAt( 0 ) == '+'){
                number = Integer.valueOf(line[1].substring( 1 ));
                instructionLine[1] = number;
            }
            else{
                number = Integer.valueOf(line[1].substring( 1 ));
                number = number * -1;
                instructionLine[1] = number;
            }
            instructionLine[2] = 0;
            instructionsTable.add( instructionLine );

        }
        myReader.close();
        originalInstructionsTable = copyList( instructionsTable );
        flag = checkFix( instructionsTable );



        while (!flag){
            instructionsTable = copyList( originalInstructionsTable );

            instructionsTable = fixLine( instructionsTable, i );
            flag = checkFix( instructionsTable );
            i ++;

        }



        }

    private static boolean checkFix (List<int[]> table){

        int i = 0;
        int acc = 0;

        while (i < table.size()){

            int[] line = table.get( i );

            if (line[0] == 1){
                acc += line[1];
                line[2]++;
                i++;
            }
            else if (line[0] == 2){
                i += line[1];
                line[2]++;

            }
            else{
                line[2]++;
                i++;
            }

            if ( i == table.size()){
                System.out.println("ACC = " + acc);
                return true;
            }

            else if (line[2] > 1){
                return false;
            }


        }
        return true;
    }
    private static List<int[]> fixLine (List<int[]> table, int i){

        int[] line = table.get( i );
        if (line[0] == 1){
            return table;
        }
        else{
            if (line[0] == 2){
                line[0] = 3;
            }
            else{
                line[0] = 2;
            }
        }

        return table;
    }
    private static List<int[]> copyList (List <int[]> table){
        List<int[]> newList = new LinkedList<>();

        for ( int[] n : table){
            newList.add( n.clone() );
        }

        return newList;
    }


}



