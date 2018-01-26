import edu.princeton.cs.algs4.StdRandom;	
import edu.princeton.cs.algs4.StdStats;
public class PercolationStats {
	private double[] p_arr;
	private int sze;
	private int n_trial;
	public PercolationStats(int n,int trials){
		sze=n;
		n_trial=trials;
		p_arr = new double[trials];
		for(int i=0;i<trials;++i){
			p_arr[i]=perc_wrapper(n);
		}
	}
	
	private double perc_wrapper(int n){
		Percolation perc = new Percolation(n);
		while(!perc.percolates()){
			
			int row = StdRandom.uniform(1, n+1);
			int col = StdRandom.uniform(1, n+1);
			perc.open(row, col);
		}
		return perc.numberOfOpenSites()/((float)n*n);
	}
	public double mean(){
		return StdStats.mean(p_arr);
	}

	public double stddev(){
		return StdStats.stddev(p_arr);
	}

	
	public double confidenceLo(){
		return StdStats.(p_arr);
	}
	
	public double mean(){
		return StdStats.mean(p_arr);
	}
	
	public double print_arr(){
		double sum=0;
		for(int i=0;i<p_arr.length;++i){
			sum+=p_arr[i];
		}	
		return  sum/p_arr.length;
	}
	public static void main(String args[]){
		PercolationStats pStats=new PercolationStats(1000,100);
		System.out.print(pStats.print_arr());
	}
}
