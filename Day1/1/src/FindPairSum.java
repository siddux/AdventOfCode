import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class FindPairSum {

    private int[] _input;
    private int _sum;

    public FindPairSum(int[] input, int sum){
        this._input = input;
        this._sum   = sum;
    }

    public Optional<Pair> findPair(){
        Map<Integer, Integer> sumMap = new HashMap<Integer, Integer>();

        for (int n : _input){
            if (sumMap.containsKey( n )){
                return Optional.of( new Pair( n, sumMap.get( n ) ));
            }
            else{
                sumMap.put( _sum-n, n );
            }
        }

        return Optional.empty();
    }

    public int findProduct(){
        Optional<Pair> opt = findPair();
        Pair sumPair = opt.get();
        return sumPair.getNumber( 1 ) * sumPair.getNumber( 2 );
    }


}
