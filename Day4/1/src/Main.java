import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException{
        File myObj             = new File( "/Users/eduardriusmartinez/Desktop/AdventOfCode/Day4/1/src/input.txt");
        Scanner myReader       = new Scanner( myObj);
        PassportReader pReader = new PassportReader();
        int correctPassports   = 0;

        while (myReader.hasNextLine()) {
            String passport     = "";
            String data         = myReader.nextLine();
            passport            =  data;
            boolean lastLine    = false;
            boolean preLastLine = false;

            while(data.equals( "" ) == false && myReader.hasNextLine()){
                data = myReader.nextLine();
                passport = passport + " " + data;
            }

            if (pReader.passportCheck( passport )){
                correctPassports++;
            }

        }
        myReader.close();
        System.out.println(correctPassports);
    }

}
