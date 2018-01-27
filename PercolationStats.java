import edu.princeton.cs.algs4.StdRandom;	
import edu.princeton.cs.algs4.StdStats;
public class PercolationStats {
	private double[] p_arr;
	private int n_trial;
	private double mean;
	private double stdDev;
	public PercolationStats(int n,int trials){
	if(n<1||trials<1)throw new java.lang.IllegalArgumentException("Enter matrix size and trials");
	n_trial=trials;
	p_arr = new double[trials];
		for(int i=0;i<trials;++i) p_arr[i]=perc_wrapper(n);
		mean = StdStats.mean(p_arr);
		stdDev = StdStats.stddev(p_arr); 
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
		return mean;
	}

	public double stddev(){
		return stdDev;
	}

	
	public double confidenceLo(){
		return mean-((1.96*stdDev)/Math.sqrt(n_trial));
	}
	
	public double confidenceHi(){
		return mean+((1.96*stdDev)/Math.sqrt(n_trial));
	}
	
	public static void main(String[] args){
		PercolationStats pStats = new PercolationStats(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
		System.out.println("mean                      ="+pStats.mean());
		System.out.println("stddev                    ="+pStats.stddev());
		System.out.println("confidence                ="+"["+pStats.confidenceLo()+" ,"+pStats.confidenceHi()+"]");
	}
}
