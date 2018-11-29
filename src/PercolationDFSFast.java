

public class PercolationDFSFast extends PercolationDFS{
	
	
	public PercolationDFSFast(int size) {
		super(size);
	}
	
	@Override
	public void updateOnOpen(int row, int col) {
		if (row == 0) {
			dfs(row,col);
		}
		
		if (myGrid[row][col+1] == FULL || myGrid[row +1][col] == FULL || myGrid[row-1][col] == FULL || myGrid[row][col-1] == FULL) {
			dfs(row,col);
		}
	}
}
