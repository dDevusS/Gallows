
public class Game {
	
	static String question;    //Подсказка	
	static String secretWord;		  //Загаданное слово
	static String commentary="";
	private static int countAttempt;   //Счетчик попыток

 	public static void playGame() {
		countAttempt=6;
		secretWord=Utils.getWord();
		StringBuilder hiddenWord=Utils.doHiddenWord(secretWord);
		StringBuilder listOfUsedLetter=new StringBuilder(" ");

		while(checkStatusGame(hiddenWord)==2) {
			Utils.doVisualisationGameProcess(hiddenWord, listOfUsedLetter, countAttempt);
			System.out.println("Введите одну букву: ");
			doPlayersTurn(hiddenWord, listOfUsedLetter, Utils.scanner.nextLine().toUpperCase());
		}
		if(checkStatusGame(hiddenWord)==0) {
			Utils.doVisualisationGameProcess(hiddenWord, listOfUsedLetter, countAttempt);
			System.out.println("\nПоздравляю! Вы отгадали слово "+secretWord+".\n"
							 + "Чтобы продолжить нажмите любую клвавишу...");
			Utils.scanner.nextLine();	
		}
		else if(checkStatusGame(hiddenWord)==1) {
			Utils.doVisualisationGameProcess(hiddenWord, listOfUsedLetter, countAttempt);
			System.out.println("\nК сожалению, у вас закончились попытки и вы не смогли отгадать слово "+secretWord+".\n"
					         + "Чтобы продолжить нажмите любую клвавишу...");
			Utils.scanner.nextLine();
		}		
	}
	
	public static int checkStatusGame(StringBuilder hiddenWord) {		
		//0-victory; 1-attempts are over; 2-in progress. 		
		int status=2;
		if (secretWord.contentEquals(hiddenWord)) {
			status=0;
		}
		else if (countAttempt==0) {
			status=1;
		}
		return status;
	}
	
	public static void doPlayersTurn(StringBuilder hiddenWord, StringBuilder listOfUsedLetter, String playersLetter) {		
		switch (Utils.isCorrectLetter(playersLetter, secretWord, listOfUsedLetter)) {
		case "bingo": 
			listOfUsedLetter.append(playersLetter.charAt(0)).append(" ");
			for (int indexLetter=0; indexLetter<secretWord.length(); indexLetter++) {
				if(playersLetter.charAt(0)==secretWord.charAt(indexLetter)) {
					hiddenWord.setCharAt(indexLetter, playersLetter.charAt(0));
				}
			}
			commentary="Есть такая буква!";
			break;
		case "missed":
			commentary="Такой буквы здесь нет.";
			countAttempt--;
			listOfUsedLetter.append(playersLetter.charAt(0)).append(" ");
			break;
		case "isUsed": commentary="Вы уже вводили эту букву."; break;
		case "incorrect": commentary="Вы должны ввести только одну кириллическую букву."; break;
		}
	}
}

