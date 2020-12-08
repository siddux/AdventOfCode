public class Map {
    private char[][] _map;
    private int _rows;
    private int _columns;

    public Map(char[][] map){
        this._map = map;
        _rows     = map.length;
        _columns  = map[0].length;
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
            i += 1;
            j += 3;
            if(j >= _columns){
                j = j - _columns;
            }
        }

        return trees;

    }

}
