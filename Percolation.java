import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import edu.princeton.cs.algs4.StdRandom;	
import edu.princeton.cs.algs4.StdStats;

public class Percolation {
	private int num_open;
	private int sze;
	private int top;
	private int bottom;
	private boolean[][] site_mark;
	private WeightedQuickUnionUF var_1;
	public Percolation(int N){
		num_open=0;
		sze=N;
		top =0;
		bottom=N*N+1;
		site_mark=new boolean[N][N];
		for(int i=0;i<N;++i)
		{
			for(int j=0;j<N;++j)
			{
				this.site_mark[i][j]=false;
				}
			}
		var_1=new WeightedQuickUnionUF(N*N+2);
	}
	
	public void print_Arr(){
		int[] var = var_1.get_arr();
		for(int i=0;i<var.length;++i){
			System.out.print(var[i]+" ");
		}
		System.out.print("\n");
	}
	public void open(int row,int col){
		if(row>sze||col>sze||row<1||col<1){
			throw new java.lang.IllegalArgumentException("Please enter value less than the size of site");
		}
		site_mark[row-1][col-1]=true;
		++num_open;
		if(row==1){
			var_1.union(top,site_Num(row, col));
		}
			
			if(row>1 && isOpen(row-1,col)){
				var_1.union(site_Num(row-1, col),site_Num(row, col));
			}
			if(row<sze && isOpen(row+1,col)){
				var_1.union(site_Num(row+1, col),site_Num(row, col));
			}
			if(col>1 && isOpen(row,col-1)){
				var_1.union(site_Num(row, col-1),site_Num(row, col));
			}
			if(col<sze && isOpen(row,col+1)){
				var_1.union(site_Num(row, col+1),site_Num(row, col));
			}
			
		if (row==sze){
			var_1.union(bottom,site_Num(row, col));
		}

			
	}
	
	
	public boolean isFull(int row,int col){
		return var_1.connected(site_Num(row,col), top);	
	}
	
	public int numberOfOpenSites(){
		return num_open;
	}
	
	public boolean percolates(){
		return var_1.connected(bottom, top);
	}
	
	public boolean isOpen(int row,int col){
		return site_mark[row-1][col-1];
	}
	
	private int site_Num(int row,int col){
		return sze*(row-1)+col;
		
	}

	public static void main(String args[]){
		Percolation o1=new Percolation(3);
		o1.open(1,1);
		o1.open(2, 1);
		o1.open(3,1);
		o1.print_Arr();
		System.out.print(o1.percolates());
//		o1.print_Arr();
//		o1.open(3, 1);
	}
	

}

