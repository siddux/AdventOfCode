import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Group {

    private List<String> _answers;
    private static final char[] ANSWER_TYPES = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    private Map<Character, Integer> _commonAnswers;


    public Group (){
        this._answers       = new ArrayList<>();
        this._commonAnswers = new HashMap<Character, Integer>();
    }

    public void addPassangerAnswers(String s){
        _answers.add( s );
    }

    public int sumAnswers(){
        int sum = 0;
        for (char c : ANSWER_TYPES){
           for (int i = 0; i < _answers.size(); i++){
               if(_answers.get( i ).contains( String.valueOf( c ) )){
                   _commonAnswers.put( c, 1 );

               }
               else{
                   _commonAnswers.put( c, 0);
                   break;
               }
           }
           sum = sum + _commonAnswers.get( c );
       }
        return sum;
    }

    @Override
    public String toString (){
        return "{Group answers = " + _answers +
               '}';
    }
}


