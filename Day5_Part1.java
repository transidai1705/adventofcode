public class Day5_Part1 {
	
	public static void main(String[] args) {
		
		long steps = 0;
		
		// transform the array horizontally
		List<Integer> maze = inverseTheMaze();
		
		int currentPosition = 0;
		int offset = maze.get(currentPosition);
		
		while (currentPosition + offset < maze.size())
		{
			steps++;
			maze.set(currentPosition, offset + 1);
			currentPosition += offset;
			offset = maze.get(currentPosition);
		}
		// one more step ecscaping the maze
		steps++;
		
		System.out.println(steps);
	}

	private static List<Integer> inverseTheMaze() {
		InputStream inputStream = Day5_Part1.class.getResourceAsStream("input.txt");
		List<Integer> maze = new ArrayList<>();
		Scanner scanner = new Scanner(inputStream);
		while (scanner.hasNextInt())
		{
			maze.add(scanner.nextInt());
		}
		scanner.close();
		return maze;
	}
}
