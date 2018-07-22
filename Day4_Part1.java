import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Day4_Part1 {
	
	public static void main(String[] args) {
		InputStream inputStream = Day4_Part1.class.getResourceAsStream("input.txt");
		
		int countValid = 0;
		
		Scanner scanner = new Scanner(inputStream);
		while (scanner.hasNext())
		{
			String nextLine = scanner.nextLine();
			String[] keywordList = nextLine.split("\\s+");
			System.out.println(Arrays.toString(keywordList));
			Set<String> uniqueWords = new HashSet<String>(Arrays.asList(keywordList));
			if (uniqueWords.size() == keywordList.length)
			{
				countValid++;
			}
		}
		
		System.out.println(countValid);
	}
}
