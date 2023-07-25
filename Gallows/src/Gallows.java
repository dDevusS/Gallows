

public class Gallows {
	
	public static void makeGallows(Integer countAttempt) {	
		
		switch (countAttempt) {
		case 6:
			System.out.println("________________\n"
				         	 + "||          |\n"
				             + "||\n"
				             + "||\n"
				             + "||\n"
				             + "||\n"
				             + "||\n"
				             + "||");
			break;	
		case 5:
			System.out.println("________________\n"
				         	 + "||          |\n"
				             + "||          0\n"
				             + "||\n"
				             + "||\n"
				             + "||\n"
				             + "||\n"
				             + "||");
			break;
		case 4:
			System.out.println("________________\n"
				         	 + "||          |\n"
				             + "||          0\n"
				             + "||          |\n"
				             + "||\n"
				             + "||\n"
				             + "||\n"
				             + "||");
			break;
		case 3:
			System.out.println("________________\n"
				         	 + "||          |\n"
				             + "||          0\n"
				             + "||         /|\n"
				             + "||\n"
				             + "||\n"
				             + "||\n"
				             + "||");
			break;
		case 2:
			System.out.println("________________\n"
				         	 + "||          |\n"
				             + "||          0\n"
				             + "||         /|\\\n"
				             + "||\n"
				             + "||\n"
				             + "||\n"
				             + "||");
			break;
		case 1:
			System.out.println("________________\n"
				         	 + "||          |\n"
				             + "||          0\n"
				             + "||         /|\\\n"
				             + "||         /\n"
				             + "||\n"
				             + "||\n"
				             + "||");
			break;
		case 0:
			System.out.println("________________\n"
				         	 + "||          |\n"
				             + "||          0\n"
				             + "||         /|\\\n"
				             + "||         / \\\n"
				             + "||\n"
				             + "||\n"
				             + "||");
			break;		
		}
	}
}
