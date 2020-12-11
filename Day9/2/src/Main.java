import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException{
        File file = new File( "/Users/eduardriusmartinez/Desktop/AdventOfCode/Day9/2/src/input.txt" );
        Scanner myReader = new Scanner( file );
        ArrayList<Long> numberList = new ArrayList<Long>();
        int i = 0;
        Long sum = 0L;
        int myValue = 400480901;
        int firstValue = 0;
        boolean flag = false;

        while (myReader.hasNextLine()){
            numberList.add( Long.valueOf( myReader.nextLine() ) );
        }
        myReader.close();

        while (sum != myValue){
            if (sum < myValue){
                sum += numberList.get( i );
                i++;
            }
            if (sum > myValue){
                sum -= numberList.get( firstValue );
                firstValue++;
            }
        }

        ArrayList<Long> encriptationArray = new ArrayList<Long>();
        for (int z = firstValue; z <i; z++){
            encriptationArray.add( numberList.get( z ) );
        }

        Long max = Collections.max( encriptationArray);
        Long min = Collections.min( encriptationArray);

        System.out.println("Encriptation weakness: " + (max+min));


    }


}
