import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException{

        File myObj             = new File( "/Users/eduardriusmartinez/Desktop/AdventOfCode/Day5/2/src/input.txt");
        Scanner myReader       = new Scanner( myObj);
        ArrayList<String> input = new ArrayList();

        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            input.add( data );
        }
        myReader.close();

        CodeFinder finder = new CodeFinder();
        int max = 0;

        for (String s : input){
            finder.calculateCode( s );
        }

        finder.findMyCode();
    }
}
