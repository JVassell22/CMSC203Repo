package Lab1;

import java.util.Scanner;

public class MovieDriver {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		String sentinel = " ";
		while(!sentinel.equals("n")){
			
			Movie m1 = new Movie();
			System.out.println("Input the movie's title: ");
			m1.setTitle(in.nextLine());
		
			System.out.println("Input this movie's rating: ");
			m1.setRating(in.nextLine());
		
			System.out.println("Input the number of tickets sold: ");
			m1.setSoldTickets(in.nextInt());
		
			System.out.println(m1.toString());
			
			System.out.println("If you wish to end the program, press \'n\', otherwise press any other key to input another movie: ");
			in.nextLine();
			sentinel = in.nextLine();
			
		}
		System.out.println("Goodbye ! ");
		in.close();	
	}

}
