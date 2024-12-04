import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class TwoDimRaggedArrayUtility {
	final static int MAX_ROW = 10, MAX_COLUMN = 10;
	static PrintWriter outFile;
	
	public TwoDimRaggedArrayUtility() {
		
	}
	
	
	public static double[][] readFile(File file) throws FileNotFoundException {
		Scanner inFile = new Scanner(file);
		String[] tempArr = new String[MAX_ROW];
		if(file.length() == 0) {
			inFile.close(); 
			return null;
		}
		int count = 0;
		do{
			tempArr[count]= inFile.nextLine();
			count++;
		}	
		while(inFile.hasNextLine());
		
		double[][] ragArr = new double[count][];
		for(int i = 0; i < count; i++) {
			String[] holder = tempArr[i].split(" ");
			ragArr[i] = new double[holder.length];
			for(int j = 0; j < holder.length; j++) {
				ragArr[i][j] = Double.parseDouble(holder[j]);
			}
		}
		
		inFile.close();
		return ragArr;
	}
	
	public static void writeToFile(double[][] data,File outputFile) throws FileNotFoundException {
		outFile = new PrintWriter(outputFile);
		for(int row = 0; row < data.length;row++) {
			for(int col = 0; col < data[row].length;col++) {
				outFile.print(data[row][col]+" ");
			}
			outFile.print("\n");
		}
	}
	
	public static double getTotal(double[][] data) {
		double total = 0;
		for(int row = 0; row < data.length;row++) {
			for(int col = 0; col < data[row].length;col++) {
				total+=data[row][col];
			}
		}
		return total;
	}
	public static double getAverage(double[][] data) {
		double total = 0, count = 0;
		for(int row = 0; row < data.length;row++) {
			for(int col = 0; col < data[row].length;col++) {
				total+=data[row][col];
				count++;
			}
		}
		return total/count;
	}
	public static double getRowTotal(double[][] data,int row) {
		double total = 0;
		for(int i = 0; i < data[row].length;i++) {
			total+=data[row][i];
		}
		return total;
	}
	public static double getColumnTotal(double[][] data,int col) {
		double total = 0;
		for(int i = 0; i < data.length;i++) {
			if(col < data[i].length) {
				total+=data[i][col];
			}
		}
		return total;
	}
	public static double getHighestInRow(double[][] data,int row) {
		double high = 0;
		for(int i = 0; i < data[row].length;i++) {
			if (high < data[row][i]) {
				high = data[row][i];
			}
		}
		return high;
	}
	public static int getHighestInRowIndex(double[][] data,int row) {
		int index = 0;
		double high = 0;
		for(int i = 0; i < data[row].length;i++) {
			if (high < data[row][i]) {
				high = data[row][i];
				index = i;
			}
		}
		return index;
	}
	public static double getLowestInRow(double[][] data,int row) {
		double low = Double.MAX_VALUE;
		for(int i = 0; i < data[row].length;i++) {
			if (low > data[row][i]) {
				low = data[row][i];
			}
		}
		return low;
	}
	public static int getLowestInRowIndex(double[][] data,int row) {
		double low = Double.MAX_VALUE;
		int index = 0;
		for(int i = 0; i < data[row].length;i++) {
			if (low > data[row][i]) {
				low = data[row][i];
				index = i;
			}
		}
		return index;
	}
	public static double getHighestInColumn(double[][] data,int col) {
		double element = 0;
		for(int i = 0; i < data.length;i++) {
			if(col < data[i].length) {
				if(data[i][col] > element) {
					element = data[i][col];
				}
			}
		}
		return element;
	}
	public static int getHighestInColumnIndex(double[][] data,int col) {
		double element = 0;
		int index = 0;
		for(int i = 0; i < data.length;i++) {
			if(col < data[i].length) {
				if(data[i][col] > element) {
					element = data[i][col];
					index = i;
				}
			}
		}
		return index;
	}
	public static double getLowestInColumn(double[][] data,int col) {
		double element = Double.MAX_VALUE;
		for(int i = 0; i < data.length;i++) {
			if(col < data[i].length) {
				if(data[i][col] < element) {
					element = data[i][col];
				}
			}
		}
		return element;
	}
	public static int getLowestInColumnIndex(double[][] data,int col) {
		double element = Double.MAX_VALUE;
		int index = 0;
		for(int i = 0; i < data.length;i++) {
			if(col < data[i].length) {
				if(data[i][col] < element) {
					element = data[i][col];
					index = i;
				}
			}
		}
		return index;
	}
	public static double getHighestInArray(double[][] data) {
		double high = 0;
		for(int i = 0; i < data.length; i ++) {
			for(int j = 0; j < data[i].length; j++) {
				if(data[i][j] > high) {
					high = data[i][j];
				}
			}
		}
		return high;
	}
	public static double getLowestInArray(double[][] data) {
		double low = Double.MAX_VALUE;
		for(int i = 0; i < data.length; i ++) {
			for(int j = 0; j < data[i].length; j++) {
				if(data[i][j] < low) {
					low = data[i][j];
				}
			}
		}
		return low;
	}

}
