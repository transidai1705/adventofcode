import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Day4_Part2 {
	
	public static void main(String[] args) {
		InputStream inputStream = Day4_Part2.class.getResourceAsStream("input.txt");
		
		int countValid = 0;
		
		Scanner scanner = new Scanner(inputStream);
		while (scanner.hasNext())
		{
			String nextLine = scanner.nextLine();
			String[] keywordList = nextLine.split("\\s+");
			
			boolean valid = true;
			for (int i = 0; i < keywordList.length; i++)
			{
				for (int j = i + 1; j < keywordList.length; j++)
				{
					if (anagram(keywordList[i], keywordList[j]))
					{
						valid = false;
						break;
					}
				}
				if (!valid)		
				{
					break;
				}
			}
			if (valid)
			{
				countValid++;
			}
			
		}
		scanner.close();
		
		System.out.println(countValid);
	}

	private static boolean anagram(String s, String t) {
		if (s.length() != t.length())
		{
			return false;
		}
		char[] sArray = s.toCharArray();
		char[] tArray = t.toCharArray();
		Arrays.sort(sArray);
		Arrays.sort(tArray);
		return String.valueOf(sArray).equals(String.valueOf(tArray));
	}
}
