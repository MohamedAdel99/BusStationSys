package stationPackage;


public class Passengers {
	private String fname;
	private String lname;
	public Passengers(String fname, String lname) {
		super();
		this.fname = fname;
		this.lname = lname;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public void initial(Passengers x[])
	   {
		   for(int i=0;i<100;i++)
			   x[i]= new Passengers(null, null);
	   }
	}