/**
 * Performing union find to determine if the top is connected to the bottom 
 * @author Jai Eun Huh
 */

public class PercolationUF implements IPercolate {
	
	boolean[][] myGrid; //has to be a boolean grid
	int myOpenCount;
	IUnionFind myFinder;
	private final int VTOP;
	private final int VBOTTOM;
	
	/**
	 * Initialize all cells so that they are all false
	 * @param size is the size of the simulated grid
	 */
	
	public PercolationUF(int size, IUnionFind finder) {
		VTOP = size*size;
		VBOTTOM = size*size+1;
		myGrid = new boolean[size][size];
		finder.initialize(size*size+2);
		myFinder = finder;
		
	}
	
	/**
	 * Checks to see if the cell is in bound
	 * @param row 
	 * 				is the row coordinate of the cell being checked
	 * @param col 
	 * 				is the col coordinate of the cell being checked
	 */
	
	public boolean inBounds(int row, int col) {
		if (row < 0 || row >= myGrid.length) return false;
		if (col < 0 || col >= myGrid[0].length) return false;
		return true;
	}

	
	/**
	 * Checks to see if the cell is not already open
	 * If not open, mark it as open and connects to open neighbors 
	 * @param row 
	 * 				is the row coordinate of the cell being checked
	 * @param col 
	 * 				is the col coordinate of the cell being checked
	 */
	
	@Override
	
	
	public void open(int row, int col) {
		if (!inBounds(row,col)) throw new IndexOutOfBoundsException("out of bound");
		if (isOpen(row,col)) return;
		
		myGrid[row][col] = true;
		myOpenCount++;
		
		if (row == 0) myFinder.union(row*myGrid.length+col, VTOP);
		if (row == myGrid.length-1) myFinder.union(row*myGrid.length+col, VBOTTOM);
		
		if (inBounds(row+1,col) && isOpen(row+1,col)) myFinder.union(row*myGrid.length+col, (row+1)*myGrid.length+col);
		if (inBounds(row,col+1) && isOpen(row,col+1)) myFinder.union(row*myGrid.length+col, row*myGrid.length+(col+1));
		if (inBounds(row-1,col) && isOpen(row-1,col)) myFinder.union(row*myGrid.length+col, (row-1)*myGrid.length+col);
		if (inBounds(row,col-1) && isOpen(row,col-1)) myFinder.union(row*myGrid.length+col, row*myGrid.length+(col-1));
		return;
	}
	
	/**
	 * Returns whether the cell is open or not
	 * @param row 
	 * 				is the row coordinate of the cell being checked
	 * @param col 
	 * 				is the col coordinate of the cell being checked
	 */

	@Override
	public boolean isOpen(int row, int col) {
		if (!inBounds(row,col)) throw new IndexOutOfBoundsException("out of bound");
		return myGrid[row][col];
	}
	
	/**
	 * Returns whether the cell is full or not 
     * @param row 
	 * 				is the row coordinate of the cell being checked
	 * @param col 
	 * 				is the col coordinate of the cell being checked
	 */

	@Override
	public boolean isFull(int row, int col) {
		if (!inBounds(row,col)) throw new IndexOutOfBoundsException("out of bound");
		return myFinder.connected(row*myGrid.length+col, VTOP);
	}
	
	/**
	 * Returns whether the grid percolates
	 */

	@Override
	public boolean percolates() {
		return myFinder.connected(VBOTTOM, VTOP);
	}
	
	/**
	 * Returns the number of open sites in the grid
	 */

	@Override
	public int numberOfOpenSites() {
		return myOpenCount;
	}

}
