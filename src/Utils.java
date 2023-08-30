
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Utils {
	
	public static Scanner scanner=new Scanner(System.in);
	
	public static String getWord() {	
		File fileOfWords=new File("src"+File.separator+"Words.txt");
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
			System.out.print("File Words.txt not found!");
			scanner.nextLine();
			System.exit(0);
		}	
		String[] temp=secretWord.split("/");
		Game.question=temp[1];
		return temp[0].toUpperCase();
	}
	
	public static StringBuilder doHiddenWord(String secretWord) { 
		StringBuilder hiddenWord=new StringBuilder();
		for (int indexLetter=0; indexLetter<secretWord.length(); indexLetter++) {
			hiddenWord.append("_");
		}
		return hiddenWord;
	  }

	private static String getFieldOfSecretWord(StringBuilder hiddenWord) {
		StringBuilder word=new StringBuilder();
		for (int indexLetter=0; indexLetter<hiddenWord.length(); indexLetter++) {
			word.append(hiddenWord.charAt(indexLetter)+" ");
		}
		return word.toString();
	}
	
	public static void doVisualisationGameProcess(StringBuilder hiddenWord, StringBuilder listOfUsedLetter, Integer countAttempt) {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		Gallows.makeGallows(countAttempt);
		System.out.println("Загаданное слово: "+Utils.getFieldOfSecretWord(hiddenWord)+"      Осталось "+countAttempt+" попыток.");
		System.out.println(Game.question);
		System.out.print("Вы вводили бувы: "+listOfUsedLetter.toString());
		System.out.println("\n\n"+Game.commentary+"\n");
	}
	
	public static String isCorrectLetter(String playersLetter, String secretWord, StringBuilder listOfUsedLetter) {		
		if(!isLetter(playersLetter)) {
			return "incorrect";
			}
		boolean isCorrectLetter=false;	//Проверка на правильно угаданную букву	
		for (int indexLetter=0; indexLetter<secretWord.length(); indexLetter++) {
			if (secretWord.charAt(indexLetter)==playersLetter.charAt(0)) {isCorrectLetter=true; break;}
		}
		
		if (!isUsedLetter(playersLetter.charAt(0), listOfUsedLetter)) {
			if (isCorrectLetter) {
				return "bingo";
			}
			else {		
				return "missed";
			}	
		}
		else {	
			return "isUsed";
		}
	}
	
	private static boolean isLetter(String playerLetter) {
		boolean isLetter=false;
		if (playerLetter.length()!=0&&playerLetter.charAt(0)>='А'&&playerLetter.charAt(0)<='Я') {
					return isLetter=true;
		}
		return isLetter;
	}
	
	private static boolean isUsedLetter(char playersChar, StringBuilder listOfUsedLetter) {
		boolean isUsedLetter=false;   //Проверка на уже введеные буквы
		for (int indexLetter=0; indexLetter<listOfUsedLetter.length(); indexLetter++) {
			if (playersChar==listOfUsedLetter.charAt(indexLetter)) {isUsedLetter=true; break;}
		}
		return isUsedLetter;
	}
}