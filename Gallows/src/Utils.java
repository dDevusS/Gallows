
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Utils {
	
	public static Scanner scanner=new Scanner(System.in);
	
	public static String getWord() {
		
		File fileOfWords=new File("src"+File.separator+"Words");
		String secretWord=null;
		try {
			Scanner fileReader=new Scanner(fileOfWords);
			List<String> listOfWords=new ArrayList<>();
	        String word=fileReader.nextLine();
	       
	        while(true) {
	        	listOfWords.add(word);
	        	if(!fileReader.hasNextLine()) {break;}
	            word=fileReader.nextLine();}
	        
	        Random random=new Random();
	        secretWord =listOfWords.get(random.nextInt(listOfWords.size()));
	        fileReader.close();
			
		} 		
		catch (FileNotFoundException e) {
			System.out.print("File Words.TXT not found!");
			Scanner in=new Scanner(System.in);
			String worning=in.nextLine();
			in.close();
			System.exit(0);
		}
		
		String[] temp=secretWord.split("/");
		Game.word=temp[0].toUpperCase();
		Game.question=temp[1];
		return temp[0].toUpperCase();
		
	}

	public static String[][] doArraySecretWord(String secretWord) {
		String[][] arraySecretWord=new String[2][secretWord.length()];
		for (int indexOfLetter = 0; indexOfLetter < arraySecretWord[0].length; indexOfLetter++) {
			arraySecretWord[0][indexOfLetter]=secretWord.charAt(indexOfLetter)+"";
			arraySecretWord[1][indexOfLetter]="_";
		}
		return arraySecretWord;
		
	}	

	public static String getFieldOfSecretWord(String[][] arraySecretWord) {
		String word="";
		for (String letter : arraySecretWord[1]) {
			word+=letter+" ";
		}
		return word;
	}
	
	public static void doVisualisation(String[][] arraySecretWord, List<String> listOfUsedLetter) {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		Gallows.makeGallows(Game.countAttempt);
		System.out.println("Загаданное слово: "+Utils.getFieldOfSecretWord(arraySecretWord)+"      Осталось"+Game.countAttempt+" попыток.");
		System.out.println(Game.question);
		System.out.print("Вы вводили бувы: ");
		for(String usedLetter : listOfUsedLetter) {
			System.out.print(usedLetter+" ");
		}
		System.out.println("\n\n"+Game.commentary+"\n");
	}
	
	public static String isCorrectLetter(String playerLetter, String[][] arraySecretWord, List<String> listOfUsedLetter) {
		
		String markOfCorrect;
		
		boolean isLetter=false;  //Проверка на допустимые символы
		String stringOfCorrectLetter="А Б В Г Д Е Ё Ж З И Й К Л М Н О П Р С Т У Ф Х Ц Ч Ш Щ Ъ Ы Ь Э Ю Я";
		String[] listOfCorrectLetter=stringOfCorrectLetter.split(" ");
		for (String correctLetter : listOfCorrectLetter) {
			if(playerLetter.equals(correctLetter)) {
				isLetter=true; break;}
		}
		
		boolean isUsedLetter=false;   //Проверка на уже введеные буквы
		for (String usedLetter : listOfUsedLetter) {
			if (usedLetter.equals(playerLetter)) {isUsedLetter=true;}
		}
		
		boolean isCorrectLetter=false;	//Проверка на правильно угаданную букву	
		for (int index=0; index<arraySecretWord[0].length; index++) {
			if(playerLetter.equals(arraySecretWord[0][index])) {
				arraySecretWord[1][index]=playerLetter;
				isCorrectLetter=true;
			}
		}
		
		if (isLetter&&!isUsedLetter&&isCorrectLetter){
			return markOfCorrect="bingo"; //попадание
		}
		else if (isLetter&&!isUsedLetter&&!isCorrectLetter) {
			return markOfCorrect="missed"; //мимо
		}
		else if (isLetter&&isUsedLetter) {
			return markOfCorrect="isUsed"; //уже было
		}
		else {
			return markOfCorrect="incorrect"; //Неверный символ
		}
		
		
	}
}
