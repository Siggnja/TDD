package is.ru.stringcalculator;

public class Calculator 
{
	public static int add(String text)
	{
		if(text.equals("")){
			return 0;
		}
		if(text.startsWith("//"))
		{		
			return sum(splitSpecialDelimNumbers(text));
		}
		else if(text.contains(","))
		{
			return sum(splitNumbers(text)) ;
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
		testNegativity(numbers.split(",|\n"));
	    return numbers.split(",|\n");
	}
    private static String[] splitSpecialDelimNumbers(String numbers)
    {
    	String[] res = numbers.split("\n",2);
		String special = res[0].substring(2);
		testNegativity(res[1].split(special));
		return res[1].split(special);

    }
    private static int sum(String[] numbers)
    {
 	    int total = 0;
        for(String number : numbers)
        {
        	int res = toInt(number);
			if(res <= 1000) total += toInt(number);
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
   			String message ="Negative not allowed: " + result[0];
   			if(count > 1)
   			{

	   			for(String temp : result)
   				{
   					if(temp == result[0]) continue;

   					message += "," + temp;
   				}
   			}
   			throw new IllegalArgumentException(message);
   		}
   	}
}