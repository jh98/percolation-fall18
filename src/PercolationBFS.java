
import java.util.LinkedList;
import java.util.Queue;

/**
 * performing breadth-first search for determining if the top is connected to the bottom 
 * @author Jai Eun Huh
 */


public class PercolationBFS extends PercolationDFSFast {
	
	public PercolationBFS(int n) {
		super(n);
	}
	
	
	/**
	 * Overriding the dfs method from PercolationDFS
	 * Marking all cells that are reachable as full 
	 * 
	 * @param row
	 *            is the row coordinate of the cell being checked/marked
	 * @param col
	 *            is the col coordinate of the cell being checked/marked
	 */
	
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
