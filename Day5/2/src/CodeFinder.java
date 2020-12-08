import java.util.*;

public class CodeFinder {

    private Map<String, Integer> _rowsMap;
    private Map<String, Integer> _columnsMap;
    private SortedSet<Integer> _idSet;

    public CodeFinder (){
        this._rowsMap    = new HashMap<String, Integer>();
        this._columnsMap = new HashMap<String, Integer>();
        this._idSet      = new TreeSet<Integer>();
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

    public void calculateCode(String s){

        String row       = s.substring( 0, 7 );
        String column = s.substring( 7 );
        int rowNum    = _rowsMap.get( row );
        int colNum    = _columnsMap.get( column );

        _idSet.add( rowNum*8 + colNum );
    }

    public void findMyCode(){
        Iterator<Integer> iterator = _idSet.iterator();
        int previous = iterator.next();
        int actual = 0;
        while (iterator.hasNext()) {
            actual = iterator.next();
            if (actual-previous != 1){
                int mySeat = previous + (actual-previous)/2;
                System.out.println("Found! My seat is: " + mySeat);
            }
            previous = actual;
        }
    }


}

