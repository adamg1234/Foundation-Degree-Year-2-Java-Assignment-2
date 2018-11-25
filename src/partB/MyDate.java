package partB;

public class MyDate implements Comparable{
	private int day,month,year;
	
	public MyDate()
	{
		this.day =1; this.month=1;this.year = 1900;
	}
	public MyDate(int day, int month, int year)
	{
		this.day =day; 
		this.month=month;
		this.year = year;
	}
	
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String toShortDate()
	{
		return String.format("%2d/%2d/%4d", this.day,this.month, this.year);
	}
	
	public String toMediumDate()
	{
		String [] monthNames={"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
		
		return String.format("%2d%5s%5d", this.day,monthNames[this.month-1], this.year);
	}
	
	public String toLongDate()
	{
		String [] monthNames={"January","Feburary","March","April","May","June","July","August","September","October","November","December"};
		String suffix;
		switch( this.day)
		{
		case 1 : case 21 : case 31 : suffix="st"; break;
		case 2 : case 22 		   : suffix="nd"; break;
		case 3 : case 23           : suffix="rd"; break;
		default :
			suffix="th";
		
		}
		return String.format("%2d%2s %10s %5d", this.day,suffix,monthNames[this.month-1], this.year);
	}
	
	public boolean compareTo(int nDay, int nMonth, int nYear)
	{
		boolean match=false;
		
		if(nDay==this.day)
			if(nMonth==this.month)
				if(nYear==this.year)
					match=true;
		
		
		return match;
	}
	public int compareTo(Object d)
	{
		int num1, num2;
		MyDate dd = (MyDate)d;
		
		num1 = this.year * 1000 + this.month * 100 + this.day;
		num2 = dd.getYear() * 1000 + dd.getMonth() * 100 + dd.getDay();
		return num1 - num2;
		
		
	}
}
