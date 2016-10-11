package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text)
	{
		if(text.equals("")){
			return 0;
		}
		else if(text.contains(","))
		{
			testNegativity(splitNumbers(text));
			return sum(splitNumbers(text));
		}
		else
			return 1;
	}

	private static int toInt(String number)
	{
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers)
	{
	    return numbers.split(",|\n");
	}
      
    private static int sum(String[] numbers)
    {
 	    int total = 0;
        for(String number : numbers)
        {
		    total += toInt(number);
		}
		return total;
    }

    private static void testNegativity(String[] numbers)
   	{
   		String result[] = new String[numbers.length];
   		int count = 0;
   		for(String temp : numbers)
   		{
   			if(toInt(temp) < 0)
   			{
   				result[count++] = temp;
   			}
   		}
   		if(count > 0)
   		{
   			String message ="Negative not allowed: ";
   			for(String temp : result)
   			{
   				message += temp;
   			}
   			throw new IllegalArgumentException(message);
   		}
   	}

}