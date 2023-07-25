
public class Main {

	public static void main(String[] args) {
		
		while(true) {
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
							   +"Виселица.\n\n"	
							   +"Начать новую игру(Н).\n"
							   +"Выйти из игры(В).\n"
							   +"Введите букву \"Н\" или букву \"В\".\n");

			switch (Utils.scanner.nextLine().toUpperCase()) {
			case "Н": Game.playGame(); break;
			case "В": System.out.print("Возвращайтесь еще!"); System.exit(0); break;
			default:  System.out.println("Вы ввели неверную команду.");				
			}
		}
	}	
}
