public class Map {
    private char[][] _map;
    private int _rows;
    private int _columns;
    private int[] _slope;

    public Map(char[][] map, int right, int down){
        this._map = map;
        _rows     = map.length;
        _columns  = map[0].length;
        _slope    = new int[2];
        _slope[0] = right;
        _slope[1] = down;
    }

    public int countTrees(){
        int i = 0;
        int j = 0;
        int trees = 0;

        while (i < _rows){
            char pos = _map[i][j];
            if (pos == '#'){
                trees ++;
            }
            i += _slope[1];
            j += _slope[0];
            if(j >= _columns){
                j = j - _columns;
            }
        }

        return trees;

    }

}
