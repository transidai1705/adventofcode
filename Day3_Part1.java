public class Day3_Part1 {
	
	 public static void main(String[] args)
	    {
	        int number = 312051;
	        if (number == 1)
	            System.out.println(0);
	        else
	        {
	            int[] circleAndPosition = detectCircleAndPosition(number);
	            int[] range = generateRange(circleAndPosition[0]);
	            System.out.println(range[(circleAndPosition[1] - 1) % range.length]);
	        }

	    }


	    private static int[] detectCircleAndPosition(int number)
	    {
	        int maxNumberInCircle = 1;
	        int circle = 1;
	        int position = 0;
	        for (int i = 1; i < number;)
	        {
	            int numOfNumberInCircle = ((2 * circle - 1) * 4 + 4);
	            if (number <= numOfNumberInCircle + maxNumberInCircle)
	            {
	                position = number - maxNumberInCircle;
	                return new int[] {circle, position};
	            }
	            else
	            {
	                maxNumberInCircle = maxNumberInCircle + numOfNumberInCircle;
	                circle++;
	                i += numOfNumberInCircle;
	            }
	        }
	        return null;
	    }


	    private static int[] generateRange(int circle)
	    {
	        int length = circle * 2;
	        int[] result = new int[length];
	        if (circle == 1)
	        {
	            result[0] = 1;
	            result[1] = 2;
	        }
	        else
	        {
	            for (int i = 0; i < length; i++)
	            {
	                int mid = length / 2;
	                for (int j = 0; j < mid; j++)
	                {
	                    if (j == 0)
	                    {
	                        result[j] = circle + mid - 1;
	                        result[j + mid] = circle + 1;
	                    }
	                    else
	                    {
	                        result[j] = result[j - 1] - 1;
	                        result[j + mid] = result[j + mid - 1] + 1;
	                    }
	                }
	            }
	        }
	        return result;
	    }
}
