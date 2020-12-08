import java.util.HashMap;
import java.util.Map;

public class CodeFinder {

    private Map<String, Integer> _rowsMap;
    private Map<String, Integer> _columnsMap;

    public CodeFinder (){
        this._rowsMap    = new HashMap<String, Integer>();
        this._columnsMap = new HashMap<String, Integer>();
        generateColumnsStringCode();
        generateRowsStringCode();
    }

    private void generateColumnsStringCode(){
        for (int i = 0; i <8; i++){
            String s = Integer.toBinaryString( i );
            while (s.length()<3){
                s = "0" + s;
            }
            this._columnsMap.put( binaryToChar( s, "L", "R" ),i );
        }
    }

    private void generateRowsStringCode(){
        for (int i = 0; i <128; i++){
            String s = Integer.toBinaryString( i );
            while (s.length()<7){
                s = "0" + s;
            }
            this._rowsMap.put( binaryToChar( s, "F", "B" ),i );
        }
    }

    private String binaryToChar(String s, String zero, String one){
        String S = "";
        for (char c : s.toCharArray()){
            if (c == '0'){
                S = S + zero;
            }
            else{
                S = S + one;
            }
        }
        return S;
    }

    public int calculateCode(String s){

        String row       = s.substring( 0, 7 );
        String column = s.substring( 7 );
        int rowNum    = _rowsMap.get( row );
        int colNum    = _columnsMap.get( column );

        return rowNum*8 + colNum;
    }


}

