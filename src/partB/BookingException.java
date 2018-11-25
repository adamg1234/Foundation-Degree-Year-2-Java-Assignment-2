package partB;

public class BookingException extends Exception
{
	private String output;
	
	BookingException(String s)
	{
		output =s;
	}
	
	public String toString()
	{
		return output;
	}
	
}
