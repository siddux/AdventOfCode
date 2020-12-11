import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException{
        File file = new File( "/Users/eduardriusmartinez/Desktop/AdventOfCode/Day10/1/src/input.txt" );
        Scanner myReader = new Scanner( file );
        ArrayList<Integer> numberList = new ArrayList<Integer>();
        int sum = 0;
        int diff1 = 0;
        int diff2 = 0;
        int diff3 = 0;
        int myVoltage = 0;

        while (myReader.hasNextLine()){
            numberList.add( Integer.valueOf( myReader.nextLine() ) );
        }
        myReader.close();

        int ratedJoltage = Collections.max( numberList) + 3;
        numberList.sort( Integer::compareTo );


        for (int i = 0; i<numberList.size(); i++){
            int preVoltage = myVoltage;
            myVoltage     = numberList.get( i );

            int difVoltage = myVoltage - preVoltage;
            if (difVoltage == 1){
                diff1++;
            }
            else if(difVoltage == 2){
                diff2++;
            }
            else{
                diff3++;
            }
        }
        diff3++;

        System.out.println("Result: " + String.valueOf( (diff1 * diff3) ) );


    }


}
