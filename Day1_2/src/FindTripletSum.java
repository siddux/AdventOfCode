import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class FindTripletSum {

    private int[] _input;
    private int _sum;
    private Map<Integer,Integer> _sumMap;

    public FindTripletSum(int[] input, int sum){
        this._input  = input;
        this._sum    = sum;
        this._sumMap = new HashMap<Integer, Integer>();
        pairSumMap();
    }

    public void pairSumMap(){
        for (int n : _input){
            _sumMap.put( _sum-n, n );
        }
    }

    public Optional<Triplet> findTriplet(){
        Map<Integer, Integer> sumMap = new HashMap<Integer, Integer>();

        for (int n : _input){
            for (int m : _input){
                if(_sumMap.containsKey( n + m )){
                    return Optional.of( new Triplet(n,m,_sumMap.get( n + m )) );
                    }
                }
            }

        return Optional.empty();
    }

    public int findProduct(){
        Optional<Triplet> opt = findTriplet();
        Triplet sumPair = opt.get();
        return sumPair.getNumber( 1 ) * sumPair.getNumber( 2 ) * sumPair.getNumber( 3 );
    }


}
