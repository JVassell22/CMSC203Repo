import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TwoDimRaggedArrayUtilityTest {
	File file1,file2,file3,file4;
	Scanner in;
	double[][] arr = new double[3][];
	@BeforeEach
	void setUp() throws Exception {
		file1 = new File("dataSet1.txt");
		file2 = new File("dataSet2.txt");
		file3 = new File("dataSet3.txt");
		file4 = new File("test.txt");
		arr[0] = new double[2];
		arr[1] = new double[1];
		arr[2] = new double[2];
		arr[0][0] = 1;
		arr[0][1] = 2;
		arr[1][0] = 3;
		arr[2][0] = 4;
		arr[2][1] = 5;
	}
	@AfterEach
	void tearDown() throws Exception {
		file1 = null;
		file2 = null;
		file3 = null;
		file4 = null;
		arr = null;
	}

	@Test
	void testReadFile() throws FileNotFoundException {
		double count = 1;
		for(int i = 0; i <TwoDimRaggedArrayUtility.readFile(file1).length; i++) {
			for(int j = 0; j < TwoDimRaggedArrayUtility.readFile(file1)[i].length;j++) {
				assertEquals(count,TwoDimRaggedArrayUtility.readFile(file1)[i][j]);
				count++;
			}
		}
	}
	@Test
	void testGetTotal() {
		assertEquals(TwoDimRaggedArrayUtility.getTotal(arr),15.0);
	}
	@Test
	void testGetAverage() {
		assertEquals(TwoDimRaggedArrayUtility.getAverage(arr),3.0);
	}
	@Test
	void testGetRowTotal() {
		assertEquals(TwoDimRaggedArrayUtility.getRowTotal(arr,0),3.0);
	}
	@Test
	void testGetColumnTotal() {
		assertEquals(TwoDimRaggedArrayUtility.getColumnTotal(arr,0),8.0);
	}
	@Test
	void testGetHighestInRow() {
		assertEquals(TwoDimRaggedArrayUtility.getHighestInRow(arr,0),2.0);
	}
	@Test
	void testGetHighestInRowIndex() {
		assertEquals(TwoDimRaggedArrayUtility.getHighestInRowIndex(arr,0),1);
	}
	@Test
	void testGetLowestInRow() {
		assertEquals(TwoDimRaggedArrayUtility.getLowestInRow(arr,0),1);
	}
	@Test
	void testGetLowestInRowIndex() {
		assertEquals(TwoDimRaggedArrayUtility.getLowestInRowIndex(arr,0),0);
	}
	@Test
	void testGetHighestInColumn() {
		assertEquals(TwoDimRaggedArrayUtility.getHighestInColumn(arr,0),4);
	}
	@Test
	void testGetHighestInColumnIndex() {
		assertEquals(TwoDimRaggedArrayUtility.getHighestInColumnIndex(arr,0),2);
	}
	@Test
	void testGetLowestInColumn() {
		assertEquals(TwoDimRaggedArrayUtility.getLowestInColumn(arr,0),1);
	}
	@Test
	void testGetLowestInColumnIndex() {
		assertEquals(TwoDimRaggedArrayUtility.getLowestInColumnIndex(arr,0),0);
	}
	@Test
	void testGetHighestInArray() {
		assertEquals(TwoDimRaggedArrayUtility.getHighestInArray(arr),5.0);
	}
	@Test
	void testGetLowestInArray() {
		assertEquals(TwoDimRaggedArrayUtility.getLowestInArray(arr),1.0);
	}
	

}
