package stationPackage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Reading_Pfile {
	
	public int loading(Passengers[] p) {
		try {
				File TripFile = new File("Passengers.txt");
				Scanner s = new Scanner(TripFile);
				String Fname;
				String Lname;
				int c=0;
				Passengers ob1 = new Passengers(null,null);
				ob1.initial(p);
				while(s.hasNext())
				{
				String word = s.nextLine();
				String[] line = word.split(",");
				Fname = line[0];
				Lname = line[1];
		        p[c].setFname(Fname);
		        p[c].setLname(Lname);
		        c++;
				}
				s.close();
				return c;
			}
		catch (FileNotFoundException es) {
			System.out.println("ERROR");
		}
		
		return 0;
	}
	public int saving(Passengers[] p,int nP,String trip)
	{
	try {
		   File Passengersfile = new File("Passengers.txt");
		   PrintStream writer = new PrintStream(Passengersfile);
		   int count = 0;
		   while(count < nP)
		   {
			   if(p[count]!=null)
			   {
				   writer.println(p[count].getFname()+","+p[count].getLname()+","+trip);
			   }
			   count++;
		   }
		   writer.close();
		   return count;
		   }
		   catch(FileNotFoundException fnf)
		   {
			   System.err.println("File Not Found!");
		   }
	return nP;}
}
