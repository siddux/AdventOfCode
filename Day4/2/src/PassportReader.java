import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PassportReader {

    private Set<String> _passportInfo;
    private Set<Character> _hclID;
    private static final String[] INFO_ID = {"byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"};
    private static final String[] ECL_ID  = {"amb", "blu", "brn", "gry", "grn", "hzl", "oth"};
    private static final char[] HCL_ID = {'0','1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'a', 'b', 'c', 'd', 'e', 'f'};


    public PassportReader(){
        _passportInfo = new HashSet<>();
        for (String s : INFO_ID){
            _passportInfo.add( s );
        }
        this._hclID = new HashSet<Character>();
        for (char c : HCL_ID){
            this._hclID.add( c);
        }

    }

    public Map passportCheck(String passport){

        String [] data = passport.split( " " );
        int dataIDs = 0;
        boolean cid = false;
        Map<String, String> passportMap = new HashMap<String, String>();
        for(String s : data){
            String id  = s.split( ":" )[0];
            String info = s.split( ":" )[1];
            if(_passportInfo.contains( id )){
                passportMap.put( id, info);
                dataIDs++;
            }
            if(id.equals( "cid" )){
                dataIDs++;
                cid = true;
            }
        }
        if (cid){
            return (dataIDs < 8) ? null : passportMap;
        }
        else{
            return (dataIDs < INFO_ID.length) ? null : passportMap;
        }

    }

    public boolean infoCheck(Map<String, String> passportMap){
        boolean isValid = true;
        for(String s : INFO_ID){
            String value = passportMap.get( s );
            if (isValid){
                switch (s) {
                    case "byr" : isValid = checkByr(value); break;
                    case "iyr" : isValid = checkIyr(value); break;
                    case "eyr" : isValid = checkEyr(value); break;
                    case "hgt" : isValid = checkHgt(value); break;
                    case "hcl" : isValid = checkHcl(value); break;
                    case "ecl" : isValid = checkEcl(value); break;
                    case "pid" : isValid = checkPid(value); break;
                }
            }

        }
        return isValid;
    }

    public boolean checkByr(String value){
        if (Integer.valueOf( value ) >= 1920 && Integer.valueOf( value ) <= 2002){
            return true;
        }
        return false;
    }  //funciona

    public boolean checkIyr(String value){
        if (Integer.valueOf( value ) >= 2010 && Integer.valueOf( value ) <= 2020){
            return true;
        }
        return false;
    } //funciona

    public boolean checkEyr(String value){
        if (Integer.valueOf( value ) >= 2020 && Integer.valueOf( value ) <= 2030){
            return true;
        }
        return false;
    } //funciona

    public boolean checkEcl(String value){
        for (String s : ECL_ID){
            if (s.equals( value )){
                return true;
            }
        }
        return false;
    }

    public boolean checkHcl(String value){
        if (value.charAt( 0 ) == '#'){
            value = value.substring( 1 );
            if (value.length() == 6){
                for (char c : value.toCharArray()){
                    if (!_hclID. contains( c ) ){
                        return false;
                        }
                    }
                return true;
                }
            }
        return false;
        }

    public boolean checkHgt(String value){
        String number = value.substring( 0, value.length()-2 );
        String unit   = value.substring( value.length() - 2 );

        if (unit.equals( "cm" )){
            if (Integer.valueOf( number ) >= 150 && Integer.valueOf( number ) <= 193){
                return true;
            }
        }
        else if (unit.equals( "in" ) ){
            if (Integer.valueOf( number ) >= 59 && Integer.valueOf( number ) <= 76){
                return true;
            }
        }
        return false;
    } //funciona

    public boolean checkPid(String value){
        if (value.length() == 9){
            try {
                int val = Integer.valueOf( value );
            }
            catch (Exception e){
                return false;
            }
            return true;
        }
        return false;
    }
}
