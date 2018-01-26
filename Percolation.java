import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import edu.princeton.cs.algs4.QuickFindUF;
import edu.princeton.cs.algs4.StdStats;

public class Percolation {
	private int[][] site_graph;
	private boolean[][] is_open_marker;
	private int num_open=0;
	public Percolation(int n){
		this.site_graph=new int[n][n];
		this.is_open_marker=new boolean[n][n];
		for(int i=0;i<n;++i){
			for(int j=0;j<n;++j){
				this.site_graph[i][j]=n*i+j;
				this.is_open_marker[i][j]=false;
			}
		}
	}
	public void print_site(){
		for(int i=0;i<this.site_graph[0].length;++i){
			for(int j=0;j<this.site_graph[0].length;++j){
				System.out.print(this.site_graph[i][j]+"\t");
			}
			System.out.print("\n");
		}
	}
	public static void main(String args[]){
		Percolation o1=new Percolation(4);
		o1.print_site();
	}
}
