import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException{
        File myObj              = new File( "/Users/eduardriusmartinez/Desktop/AdventOfCode/Day6/1/src/input.txt");
        Scanner myReader        = new Scanner( myObj);
        ArrayList<Group> groups = new ArrayList<Group>();


        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            Group group = new Group();
            group.addPassangerAnswers( data );

            while(data.equals( "" ) == false && myReader.hasNextLine()){
                data = myReader.nextLine();
                if(!data.isBlank()){
                    group.addPassangerAnswers( data );
                }
            }
            groups.add( group );

        }
        myReader.close();

        int sum = 0;
        for (Group g : groups){
            sum += g.sumAnswers();
        }
        System.out.println(sum);
    }
}
