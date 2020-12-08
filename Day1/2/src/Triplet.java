public class Triplet {

    private int _first;
    private int _second;
    private int _third;

    public Triplet (int first, int second, int third){
        this._first  = first;
        this._second = second;
        this._third  = third;
    }

    public int getNumber (int i){
        if (i==1){
            return _first;
        }
        else if (i == 2){
            return _second;
        }
        return _third;
    }

    public void setNum (int num, int i){
        if ( i == 1 ){
            _first = num;
        }
        else if ( i == 2){
            _second = num;
        }
        else{
            _third = num;
        }
    }

    public int[] getTriplet (){
        int[] array = {_first, _second, _third};
        return array;
    }

}
