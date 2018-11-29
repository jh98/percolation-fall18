

public class PercolationDFSFast extends PercolationDFS{
	
	
	public PercolationDFSFast(int size) {
		super(size);
	}
	
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
