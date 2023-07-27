

public class Gallows {
	
	public static void makeGallows(Integer countAttempt) {	
		
		switch (countAttempt) {
		case 6:
			System.out.println("""
					________________					
					||          |
					||
					||
					||
					||
					||
					||
				             """);
			break;	
		case 5:
			System.out.println("""
					________________					
					||          |
					||          0
					||
					||
					||
					||
					||
				             """);
			break;
		case 4:
			System.out.println("""
					________________					
					||          |
					||          0
					||          |
					||          |
					||
					||
					||
				             """);
			break;
		case 3:
			System.out.println("""
					________________					
					||          |
					||          0
					||         /|
					||          |
					||
					||
					||
				             """);
			break;
		case 2:
			System.out.println("""
					________________					
					||          |
					||          0
					||         /|\\
					||          |
					||
					||
					||
				             """);
			break;
		case 1:
			System.out.println("""
					________________					
					||          |
					||          0
					||         /|\\
					||          |
					||         /
					||
					||
				             """);
			break;
		case 0:
			System.out.println("""
					________________					
					||          |
					||          0
					||         /|\\
					||          |
					||         / \\
					||
					||
				             """);
			break;		
		}
	}
}
