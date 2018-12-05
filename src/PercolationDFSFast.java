/**
 * performing depth-first search for determining if the top is connected to the bottom 
 * @author Jai Eun Huh
 */

public class PercolationDFSFast extends PercolationDFS{
	
	
	public PercolationDFSFast(int size) {
		super(size);
	}
	
	/**
	 * Overriding the updateOnOpen method from PercolationDFS
	 * if myGrid[row][col] is the top cell or connected to neighboring cells that are full, call dfs(row,col) 
	 * 
	 * @param row
	 *            is the row coordinate of the cell being checked/marked
	 * @param col
	 *            is the col coordinate of the cell being checked/marked
	 */
	
	@Override
	public void updateOnOpen(int row, int col) {
		
		boolean check = false; 
		
		if (row == 0) {
			check = true;
		}
		
		if (inBounds(row,col+1) && myGrid[row][col+1] == FULL) {
			check = true;
		}
		
		if (inBounds(row,col-1) && myGrid[row][col-1] == FULL) {
			check = true;
		}
		
		if (inBounds(row+1,col) && myGrid[row+1][col] == FULL) {
			check = true;
		}
		
		if (inBounds(row-1,col) && myGrid[row-1][col] == FULL) {
			check = true;
		}
	
		if (check) dfs(row,col);
	    
	}
}
