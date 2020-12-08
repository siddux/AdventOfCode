import java.util.ArrayList;
import java.util.List;

public class Group {

    private List<String> _answers;
    private static final char[] ANSWER_TYPES = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};


    public Group (){
        this._answers = new ArrayList<>();
    }

    public void addPassangerAnswers(String s){
        _answers.add( s );
    }

    public int sumAnswers(){
        int sum = 0;
        for (char c : ANSWER_TYPES){
           for (String s : _answers){
               if(s.contains( String.valueOf( c ) )){
                   sum++;
                   break;
               }
           }
       }

        return sum;
    }

    @Override
    public String toString (){
        return "{Group answers = " + _answers +
               '}';
    }
}


