package Lab1;

//Sumit Savaliya
//LAB2 
//E19CSE006

import java.util.Scanner;

public class movieCategoryPrediction {

	// TestData = No of actions , No of comedy , category
	static int testData[][] = { { 100, 0, 1 }, { 0, 100, 0 }, { 90, 17, 1 }, { 21, 80, 0 } };

	static double pointDistances[] = new double[4];

	public static double distance(int x1, int x2, int y1, int y2) {

		double k = Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2);
		double dist = Math.sqrt(k);
		return dist;

	}

	public static int indexOfSmallest(double[] arr) {
		int imin = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < arr[imin]) {
				imin = i;
			}
		}
		return imin;
	}

	public static void predictMovie(int actionScenes, int comedyScenes) {

		int x = 0; // Actions Reference
		int y = 1; // Comedy Reference
		int z = 2; // Category Reference

		for (int i = 0; i < testData.length; i++) {
			double d = distance(actionScenes, testData[i][x], comedyScenes, testData[i][y]);
			pointDistances[i] = d;
		}

		System.out.println();

		if (testData[indexOfSmallest(pointDistances)][z] == 0) {
			System.out.println("It is a Comedy Movie");
		} else {
			System.out.println("It is an Action Movie");
		}

	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		System.out.print("Enter No. of Action Scenes: ");
		int actionScenes = in.nextInt();

		System.out.println();

		System.out.print("Enter No. of Comedy Scenes: ");
		int comedyScenes = in.nextInt();

		predictMovie(actionScenes, comedyScenes);

		in.close();
	}

}
