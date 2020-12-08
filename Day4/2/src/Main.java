import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException{
        File myObj             = new File( "/Users/eduardriusmartinez/Desktop/AdventOfCode/Day4/2/src/input.txt");
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

            Map passportMap = pReader.passportCheck( passport );
            if (passportMap != null){
                if (pReader.infoCheck( passportMap )){
                    System.out.println(passportMap);
                    correctPassports++;
                }
            }


        }
        myReader.close();

       /*String passporte = "eyr:1972 cid:100 hcl:#18171d ecl:amb hgt:170 pid:186cm iyr:2018 byr:1926";

        Map passportMap = pReader.passportCheck( passporte );
        if (passportMap != null){
            System.out.println( pReader.infoCheck( passportMap ) );
            if ( pReader.infoCheck( passportMap ) ){
                correctPassports++;
            }
        }*/
        System.out.println(correctPassports);
    }

}
