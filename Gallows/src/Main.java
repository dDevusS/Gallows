
public class Main {

	public static void main(String[] args) {				
		printMenu();
		while(true) {
			switch (Utils.scanner.nextLine().toUpperCase()) {
			case "Н": Game.playGame(); printMenu(); break;
			case "В": System.out.print("Возвращайтесь еще!"); System.exit(0); break;
			default:  System.out.println("Вы ввели неверную команду.");
			}
		}
	}
	
	private static void printMenu() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("""
				   Виселица.
	
				   Начать новую игру(Н).
				   Выйти из игры(В).
				   Введите букву \"Н\" или букву \"В\"."
				   """);
	}
}
