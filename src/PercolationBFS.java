
import java.util.LinkedList;
import java.util.Queue;

public class PercolationBFS extends PercolationDFSFast {
	
	public PercolationBFS(int n) {
		super(n);
	}
	
	
	@Override
	protected void dfs(int row, int col) {
		
		Queue<Integer> q = new LinkedList<>();
		myGrid[row][col] = FULL; 
		q.add(row*myGrid.length + col); 
		
		while (q.size() > 0) {
			int temp = q.remove();
			
			row = temp/myGrid.length;
			col = temp%myGrid.length;
					
			if (inBounds(row+1,col)&&!isFull(row+1,col) && isOpen(row+1,col)) {
				myGrid[row+1][col] = FULL;
				q.add((row+1)*myGrid.length + col);
			}
			if (inBounds(row,col+1)&&!isFull(row,col+1) && isOpen(row,col+1)) {
				myGrid[row][col+1] = FULL;
				q.add(row*myGrid.length + (col+1));
			}
			if (inBounds(row-1,col)&&!isFull(row-1,col) && isOpen(row-1,col)) {
				myGrid[row-1][col] = FULL;
				q.add((row-1)*myGrid.length + col);
			}
			if (inBounds(row,col-1)&&!isFull(row,col-1) && isOpen(row,col-1)) {
				myGrid[row][col-1] = FULL;
				q.add(row*myGrid.length + (col-1));
			}
			
			
		}
	}
}
