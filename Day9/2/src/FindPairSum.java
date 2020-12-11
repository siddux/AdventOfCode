import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class FindPairSum {

    private Long[] _input;
    private Long _sum;

    public FindPairSum(Long[] input, Long sum){
        this._input = input;
        this._sum   = sum;
    }

    public void setInput(Long[] input){
        this._input = input;
    }

    public boolean findPair(){
        Map<Long, Long> sumMap = new HashMap<Long, Long>();

        for (Long n : _input){
            if (sumMap.containsKey( n )){
                return false;
            }
            else{
                sumMap.put( _sum-n, n );
            }
        }

        return true;
    }

}
