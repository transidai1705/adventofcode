public class Example2 {
	
	private static final int INITIAL_SIZE = 5;

	public static void main(String[] args) {
		
		int numberToCheck = 312051;

		int size = INITIAL_SIZE;
		int currentSum = 0;
		
		int[][] map = new int[size][size];
		map[size/2][size/2] = 1;
		int currentX = 2;
		int currentY = 3;
		Direction direction = Direction.RIGHT;

		do 
		{
			if (currentX == (size - 2) && currentY == (size - 1))
			{
				currentX++;
				currentY++;
				size += 2;  
				map = populateDataToNewMap(size, map);
			}
			currentSum = getSumOfCurrentCell(map, currentX, currentY);
			map[currentX][currentY] = currentSum;
			switch (direction) {
			case LEFT:
				if (map[currentX + 1][currentY] == 0) {
					direction = Direction.DOWN;
					currentX = currentX + 1;
				} else {
					direction = Direction.LEFT;
					currentY = currentY - 1;
				}
				break;
			case RIGHT:
				if (map[currentX - 1][currentY] == 0) {
					direction = Direction.UP;
					currentX = currentX - 1;
				} else {
					direction = Direction.RIGHT;
					currentY = currentY + 1;
				}
				break;
			case UP:
				if (map[currentX][currentY - 1] == 0) {
					direction = Direction.LEFT;
					currentY = currentY - 1;
				} else {
					direction = Direction.UP;
					currentX = currentX - 1;
				}
				break;
			case DOWN:
				if (map[currentX][currentY + 1] == 0) {
					direction = Direction.RIGHT;
					currentY = currentY + 1;
				} else {
					direction = Direction.DOWN;
					currentX = currentX + 1;
				}
				break;
			default:
				break;
			}
		} 
		while (currentSum < numberToCheck);
		
		System.out.println(currentSum);
		
	}

	private static int[][] populateDataToNewMap(int size, int[][] map) {
		int[][] newMap = new int[size][size];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++)
			{
				newMap[i + 1][j + 1] = map[i][j];
			}
		}
		return newMap;
	}
	
	private static int getSumOfCurrentCell(int[][] map, int currentY, int currentX)
	{
		return map[currentY + 1][currentX] + map[currentY - 1][currentX] + map[currentY][currentX + 1]
				+ map[currentY][currentX - 1] + map[currentY + 1][currentX + 1] + map[currentY + 1][currentX - 1]
				+ map[currentY - 1][currentX + 1] + map[currentY - 1][currentX - 1];
	}

	enum Direction	{
		LEFT, RIGHT, UP, DOWN;
	}
	
	
}
