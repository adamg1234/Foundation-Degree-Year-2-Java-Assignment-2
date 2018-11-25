package partA;

public class ProductException extends Exception
{
	private String output;
	
	ProductException(String s)
	{
		output =s;
	}
	
	public String toString()
	{
		return output;
	}

	
	
}
