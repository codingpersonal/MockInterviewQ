/*In a game of chess, there is a horse which can move for 2.5 steps.
 * Horse needs to reach the other end, say x,y node on the other chess side.
 * Tell in how many min no of moves does the horse reach to the other end.
 * 
 * Sol: A knight can have 8 possible moves on chess board.
 * Find all the possible moves.
 * From each of the next move, make it as src and then find the path to des
 * Add + 1 for the original src to next possible move
 * get the min now from these 8 distances.
 * 
 * We also need a visited flag so that infinite loop is not reached.
 * 8*8 matrix is mapped into densed array*/



import java.util.ArrayList;
import java.util.HashSet;

public class ChessHorse {
	
	HashSet<Integer> visited = new HashSet<Integer>();
	
	ArrayList<Pair> getPossibleNextMove(int row, int col) {
		ArrayList<Pair> next = new ArrayList<>();
		int drow, dcol;
		
		//pos1 
		drow = row + 2;
		dcol = col + 1;
		 checkValidPos(drow, dcol, next);
		
		//pos2
		drow = row + 2;
		dcol = col - 1;
		 checkValidPos(drow, dcol, next);
		
		//pos3
		drow = row - 2;
		dcol = col + 1;
		 checkValidPos(drow, dcol, next);
		
		//pos4 
		drow = row - 2;
		dcol = col - 1;
		 checkValidPos(drow, dcol, next);
		
		//pos5 
		drow = row + 1;
		dcol = col + 2;
		 checkValidPos(drow, dcol, next);
		
		//pos6
		drow = row - 1;
		dcol = col + 2;
		 checkValidPos(drow, dcol, next);
		
		//pos7
		drow = row + 1;
		dcol = col - 2;
		 checkValidPos(drow, dcol, next);
		
		//pos8
		drow = row - 1;
		dcol = col - 2;
		 checkValidPos(drow, dcol, next);
		
		return next;
	}
	
	public static class Pair {
		public int row;
		public int col;
	}
	
	public void checkValidPos(int drow, int dcol, ArrayList<Pair> next) {
		if(drow >= 0 && drow <= 7 && dcol >=0 && dcol <= 7) {
			Pair p = new Pair();
			p.row = drow;
			p.col = dcol;
			next.add(p);
		}
	}
	
	public int getMinMoves(int src_row, int src_col, int des_Row, int des_Col) {
		if(src_row == des_Row && src_col == des_Col)
			return 0;

		int currPos = src_row* 8 + src_col;
		this.visited.add(currPos);
		
		ArrayList<Pair> next = getPossibleNextMove(src_row, src_col);
		int totMinMoves = 9999;
		
		for(int id = 0; id < next.size(); id++) {
			int next_row = next.get(id).row;
			int next_col = next.get(id).col;
			int nextPos = next_row * 8 + next_col;
			
			if(!this.visited.contains(nextPos)) {
				int tot = getMinMoves(next_row, next_col, des_Row, des_Col) + 1;
				totMinMoves = Math.min(tot, totMinMoves);
			}
		}
		return totMinMoves;
	}
	
	public static void main(String args[]) {
		ChessHorse ch = new ChessHorse();
		ArrayList<Pair> next = new ArrayList<>();
		next = ch.getPossibleNextMove(4,3);
		System.out.println("Final Moves:"+ch.getMinMoves(0, 3, 4, 3));
	}
}
