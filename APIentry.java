import java.util.*;

public class APIentry {
	
	public String full_name;
	public String function_name;
	public String function_name_2nd_format;
	public String short_function_name;	
	
	public String parameters;
	public Vector<String> necessary_permissions;
	public Vector<String> optional_permissions;

	public APIentry(String APIfullname)
	{
		full_name = APIfullname;
		necessary_permissions = new Vector<String>();
		optional_permissions = new Vector<String>();
		this.parseFullName();
	}
	
	public void parseFullName()
	{	
		int start = full_name.indexOf("(");
		if (start == -1)
		{
			function_name = full_name;
			parameters = "";
		}
		else
		{
			function_name = full_name.substring(0, start).trim();
			int end = full_name.indexOf(")");
			if (end == -1)
				Util.Sys_err("API entry: " + full_name + ", has '(' but not has ')'");
			if ((end - start) == 1)
				parameters = "";
			else
				parameters = full_name.substring(start+1, end).trim();
		}
		function_name_2nd_format = function_name.replaceAll("\\.", "/");
		
		int index = this.function_name_2nd_format.lastIndexOf("/");
		this.short_function_name = this.function_name_2nd_format.substring(index+1, this.function_name_2nd_format.length());
	}
	
	public String toString()
	{
		String output;
		output = this.function_name + "(" + this.parameters + ")";
		if (this.necessary_permissions.size()>0)
			output += " N_permissions: [";
		for (int i=0; i<this.necessary_permissions.size(); i++)
		{
			if (i==0)
				output += this.necessary_permissions.elementAt(i);
			else
				output += " " + this.necessary_permissions.elementAt(i);
		}
		if (this.necessary_permissions.size()>0)
			output += "]";
		if (this.optional_permissions.size()>0)
			output += " O_permissions: (";
		for (int i=0; i<this.optional_permissions.size(); i++)
		{
			if (i==0)			
				output += this.optional_permissions.elementAt(i);
			else
				output += " " + this.optional_permissions.elementAt(i);
		}
		if (this.optional_permissions.size()>0)			
			output += ")";
		return output;		
	}
}
