
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
	
	public static int countAttempt;   //Счетчик попыток
	public static String question;    //Подсказка	
	public static String word;		  //Загаданное слово
	static String commentary="";
	
 	public static void playGame() {
		String[][] arraySecretWord=Utils.doArraySecretWord(Utils.getWord());
		countAttempt=6;
		List<String> listOfUsedLetter=new ArrayList<>();

		while(checkStatusGame(arraySecretWord)==2) {
			Utils.doVisualisation(arraySecretWord, listOfUsedLetter);
			System.out.println("Введите одну букву: ");
			String playersLetter=Utils.scanner.nextLine().toUpperCase();
			doPlayersTurn(arraySecretWord, playersLetter, listOfUsedLetter);
		}
		if(checkStatusGame(arraySecretWord)==0) {
			Utils.doVisualisation(arraySecretWord, listOfUsedLetter);
			System.out.println("\nПоздравляю! Вы отгадали слово "+word+".\n"
							 + "Чтобы продолжить нажмите любую клвавишу...");
			String anyKey=Utils.scanner.nextLine();	
		}
		else if(checkStatusGame(arraySecretWord)==1) {
			Utils.doVisualisation(arraySecretWord, listOfUsedLetter);
			System.out.println("\nК сожалению, у вас закончились попытки и вы не смогли отгадать слово "+word+".\n"
					         + "Чтобы продолжить нажмите любую клвавишу...");
			String anyKey=Utils.scanner.nextLine();
		}		
	}
	
	public static int checkStatusGame(String[][] arraySecretWord) {		
		//0-victory; 1-attempts are over; 2-in progress. 		
		int status=2;
		if (Arrays.equals(arraySecretWord[0], arraySecretWord[1])) {
			status=0;
		}
		else if (countAttempt==0) {
			status=1;
		}
		return status;
	}
	
	public static void doPlayersTurn(String[][]arraySecretWord, String playersLetter, List<String> listOfUsedLetter) {		
		switch (Utils.isCorrectLetter(playersLetter, arraySecretWord, listOfUsedLetter)) {
		case "bingo": 
			listOfUsedLetter.add(playersLetter);
			for (int index=0; index<arraySecretWord[0].length; index++) {
				if(playersLetter.equals(arraySecretWord[0][index])) {
					arraySecretWord[1][index]=playersLetter;
				}
			}
			commentary="Есть такая буква!";
			break;
		case "missed":
			commentary="Такой буквы здесь нет.";
			countAttempt--;
			listOfUsedLetter.add(playersLetter);
			break;
		case "isUsed": commentary="Вы уже вводили эту букву."; break;
		case "incorrect": commentary="Вы должны ввести только одну кириллическую букву."; break;
		}
	}
}

