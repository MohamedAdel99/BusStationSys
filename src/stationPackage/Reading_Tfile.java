package stationPackage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Reading_Tfile {
	
	public int loading(Trips[] t) {
		try {
				File TripFile = new File("Trips.txt");
				Scanner s = new Scanner(TripFile);
				String dest;
				String date;
				String type;
				int c=0;
				Trips ob1 = new Trips(null, null, null);
				ob1.initial(t);
				while(s.hasNext())
				{
					String word = s.nextLine();
					String[] line = word.split(",");
				dest = line[0];
				type = line[1];
				date = line[2];
		        t[c].setDate(date);
		        t[c].setTypes(type);
		        t[c].setDest(dest);
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
public int savings(Trips[] t,int nT)
{
	  try {
		   File Tripsfile = new File("Trips.txt");
		   PrintStream writer = new PrintStream(Tripsfile);
		   int count = 0;
		   while(count < nT)
		   {
			   if(t[count]!=null)
			   {
				   writer.println(t[count].getDest()+","+t[count].getTypes()+","+t[count].getDate());
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
	  return nT;
}
}
