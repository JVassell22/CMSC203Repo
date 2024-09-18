
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;
import java.util.random.*;
public class ESPGame 
{
		/*
		 * Class: CMSC203 
		 * Instructor:
		 * Description: (Give a brief description for each Class)
		 * Due: MM/DD/YYYY
		 * Platform/compiler:
		 * I pledge that I have completed the programming assignment 
		* independently. I have not copied the code from a student or any source. I have not given my code to any student.
		 * Print your Name here: Jonathan Vassell 
		*/

		
		public static void main(String[]args) throws IOException 
		{
			String sentinel = "game";
			Random esp = new Random();
			Scanner in = new Scanner(System.in);
			Scanner inputFile = new Scanner ("Colors.txt");
			File colors = new File("Colors.txt");
			while(sentinel != "0")
			{
				int score = 0;
				String guess;
				
				for(int i = 0; i < 3; i++)
				{
					System.out.println("===============\n"
							+"Round "+(i + 1)+"\n===============");
					String answer = Files.readAllLines(Paths.get("Colors.txt")).get(esp.nextInt(15)+1).toLowerCase();
					guess = espTime(in).toLowerCase();
					if (guess.equals(answer))
					{
						score += 1;
					}
					System.out.println("I was thinking of "+answer+".");
				}
		
			finishGame(score);
			System.out.println("input 0 to quit, input any other character to play again");
			in.nextLine();
			sentinel = in.nextLine();
			}
		}
		public static String espTime(Scanner in)
		{
			String guess;
			System.out.println("I am thinking of a color.\nIs it one from the list of colors above? \r\n"
					+ "Enter your guess: \n");
			guess = in.nextLine();
			return guess; 
		}
		
		public static void finishGame(int score)
		{
			System.out.println("Game Over");
			System.out.println("You guessed "+score+" out of 3 correctly.");
			switch(score)
			{
			case 0:
				System.out.println("Beter luck next time");
				break;
			case 1:
				System.out.println("You could definitely improve.");
				break;
			case 2:
				System.out.println("Phsycic abilities are sweet huh.");
				break;
			case 3:
				System.out.println("You should quit your day job.");
				break;
			}
		}
		
 
}
