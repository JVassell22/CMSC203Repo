
public class HolidayBonus {
	final static private int MAX_BONUS = 5000, MIN_BONUS = 1000, BONUS = 2000;
	
	public HolidayBonus() {
		
	}
	//TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, i)
	//TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, i)
	public static double[] calculateHolidayBonus(double[][] data) {
		double[] arr = new double[data.length];
		for(int i = 0; i < data.length; i++) {
			arr[i] = 0;
		}
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[i].length; j++) {
				if(data[i][j] == TwoDimRaggedArrayUtility.getHighestInColumn(data, j)) {
					arr[i] += 5000;
				}
				if(data[i][j] == TwoDimRaggedArrayUtility.getLowestInColumn(data, j) && data[i][j] != TwoDimRaggedArrayUtility.getHighestInColumn(data, j)) {
					arr[i] += 1000;
				}
				if(data[i][j] > TwoDimRaggedArrayUtility.getLowestInColumn(data, j) && data[i][j] < TwoDimRaggedArrayUtility.getHighestInColumn(data, j)){
					arr[i]+=2000;
				}
			}
		}
		return arr;
	}
	
	public static double calculateTotalHolidayBonus(double[][] data) {
		double total = 0;
		double [] result = HolidayBonus.calculateHolidayBonus(data);
		for(double i: result) {
			total += i;
		}
		return total;
	}

}
