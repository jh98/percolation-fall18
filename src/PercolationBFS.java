
import java.util.LinkedList;
import java.util.Queue;

public class PercolationBFS extends PercolationDFSFast {
	
	public PercolationBFS(int n) {
		super(n);
	}
	
	//public int getIndex(int row, int col, int size) {
	//	return row * size + col;
	//}
	
	@Override
	public void dfs(int row, int col) {
		
		//row and col in bound
		//convert row + col > one single value before putting it into the queue
		//while 
		
		
		Queue<Integer> q = new LinkedList<>();
		myGrid[row][col] = FULL; //cell is FULL
		q.add(row*myGrid.length + col); //put the cell on queue
		
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
