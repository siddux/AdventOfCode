public class Pair {

    private int _first;
    private int _second;

    public Pair (int first, int second){
        this._first  = first;
        this._second = second;
    }

    public int getNumber (int i){

        return (i == 1)? _first : _second;
    }

    public void setNum (int num, int i){
        if ( i == 1 ){
            _first = num;
        }
        else{
            _second = num;
        }
    }

    public int[] getPair (){
        int[] array = {_first, _second};
        return array;
    }

}
