import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException{
        File file = new File( "/Users/eduardriusmartinez/Desktop/AdventOfCode/Day9/1/src/input.txt" );
        Scanner myReader = new Scanner( file );
        ArrayList<Long> numberList = new ArrayList<Long>();
        int i = 0;
        boolean flag = false;

        while (myReader.hasNextLine()){
            numberList.add( Long.valueOf( myReader.nextLine() ) );
        }
        myReader.close();

        while (i + 25 < numberList.size() && !flag){

            Long[] input = new Long[25];
            int n = 0;
            for (int j = i; j<i+25; j++){
                input[n] = numberList.get( j );
                n++;
            }

            FindPairSum sumPair = new FindPairSum( input, numberList.get( 25+i ) );
            flag = sumPair.findPair();
            i++;

        }

        System.out.println(numberList.get( 25+i-1 ));

    }


}
