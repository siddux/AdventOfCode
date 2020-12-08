import java.util.HashSet;
import java.util.Set;

public class PassportReader {

    private Set<String> _passportInfo;
    private static final String[] INFO_ID = {"byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"};

    public PassportReader(){
        _passportInfo = new HashSet<>();
        for (String s : INFO_ID){
            _passportInfo.add( s );
        }
    }

    public boolean passportCheck(String passport){

        String [] data = passport.split( " " );
        int dataIDs = 0;

        for(String s : data){
            s = s.substring( 0,3 );
            if(_passportInfo.contains( s ) || s == "cid"){
                dataIDs++;
            }
        }
        return (dataIDs < INFO_ID.length) ? false : true;

    }
}
