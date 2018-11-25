package partB;

public class GuitarBooking implements java.io.Serializable 
{
	private char lessonType;
	private int noinParty;
	private String clientSurname,clientForename,instructorCode;
	
	public GuitarBooking()
	{
		this.lessonType='N';
		this.noinParty=0;
		this.clientSurname="";
		this.clientForename="";
		this.instructorCode="";
	}
	
	public GuitarBooking(char lessonType, int noinParty, String clientSurname, String clientForename, String instructorCode)
	{
		this.lessonType=lessonType;
		this.noinParty=noinParty;
		this.clientSurname=clientSurname;
		this.clientForename=clientForename;
		this.instructorCode=instructorCode;
	}

	public char getLessonType() {
		return lessonType;
	}

	public void setLessonType(char lessonType) {
		this.lessonType = lessonType;
	}

	public int getNoinParty() {
		return noinParty;
	}

	public void setNoinParty(int noinParty) {
		this.noinParty = noinParty;
	}

	public String getClientSurname() {
		return clientSurname;
	}

	public void setClientSurname(String clientSurname) throws BookingException
	{
		if (clientSurname.length() < 3 || clientSurname.length()>25)
			throw new BookingException("Must Enter a surname (3-25 characters)");
		else
			this.clientSurname = clientSurname;
	}

	public String getClientForename() {
		return clientForename;
	}

	public void setClientForename(String clientForename) throws BookingException
	{
		if (clientForename.length() < 2 || clientForename.length()>15)
			throw new BookingException("Must Enter a forename (2-15 characters)");
		else
			this.clientForename = clientForename;
	}

	public String getInstructorCode() {
		return instructorCode;
	}

	public void setInstructorCode(String instructorCode) {
		this.instructorCode = instructorCode;
	}

	@Override
	public String toString() 
	{
		String str="";
		String lesson="";
		
		
		if(this.lessonType=='J')
			 lesson="Jazz";
		else if(this.lessonType=='R')
			lesson="Rock";
		else if(this.lessonType=='C')
			lesson="Classical";
		
		str = String.format("    %-15s         %-10s   %-10s   %-10d  %-15s\n", 
				lesson, this.clientForename, this.clientSurname, this.noinParty,this.instructorCode);
		
		return str;
		}
	
	
}


