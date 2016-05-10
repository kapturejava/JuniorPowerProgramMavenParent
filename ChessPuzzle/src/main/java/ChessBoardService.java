import java.util.*;

/**
 * Created by cromhjo on 10/05/2016.
 */
public class ChessBoardService {



    Set<Tile> occupiedTiles = new HashSet<>();

    public Collection<Tile> getOccupiedTiles(Tile tile, ChessBoard chessBoard) {
        occupiedTiles.add(tile); //moet er voor beide opties staan

        //OPTIE 1
        List<Tile> moves = chessBoard.doHorseMove(tile);
        for (Tile t: moves){
            if(occupiedTiles.add(t)){
                occupiedTiles.addAll(getOccupiedTiles(t,chessBoard));
            }
        }

        //OPTIE 2
        /*Queue<Tile> toProcess = new LinkedList<>();
        Set<Tile> done = new HashSet<>();
        while (tile != null){
            List<Tile> moves = chessBoard.doHorseMove(tile);
            done.add(tile);
            occupiedTiles.addAll(moves);
            for (Tile t: moves) {
                if(!done.contains(t)){
                    toProcess.add(t);
                }
            }
            tile = toProcess.poll();
        }*/


        return occupiedTiles;
    }
}
