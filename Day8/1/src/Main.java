import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException{

        File file        = new File( "/Users/eduardriusmartinez/Desktop/AdventOfCode/Day8/1/src/input.txt" );
        Scanner myReader = new Scanner( file );
        List<int[]> instructionsTable = new LinkedList<int[]>();
        int acc = 0;
        int i = 0;

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

        while (i < instructionsTable.size()){
            int[] line = instructionsTable.get( i );
            if (line[2] == 0){
                if (line[0] == 1){
                    acc += line[1];
                    line[2] = 1;
                    i++;
                }
                else if (line[0] == 2){
                    i += line[1];
                    line[2] = 1;

                }
                else{
                    line[2] = 1;
                    i++;
                }
            }
            else{
                break;
            }
        }

        System.out.println(acc);

    }
}
