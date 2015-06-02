import java.util.Vector;

public class Android_Library implements Comparable<Object>  
{
	public String name;
	public int frequency;
	
	public Android_Library(String lib_name)
	{
		this.name = lib_name;
		frequency = 0;
	}
	
	public String toString()
	{
		return this.name + " , " + this.frequency;
	}

	@Override
	// we want it to be reverse:
	public int compareTo(Object anotherLib)
	{
		Android_Library other =  (Android_Library)anotherLib; 
        if (this.frequency > other.frequency)
        	return -1; 
        if (this.frequency < other.frequency)
        	return 1; 
        return 0;
	}
	
	public static int find_lib_in_Vector(Vector<Android_Library> libs, String given_lib_name)
	{
		for (int i=0; i<libs.size(); i++)
		{
			Android_Library l = libs.elementAt(i);
			if (l.name.equalsIgnoreCase(given_lib_name))
				return i;
		}	
		return -1;
	}
}
