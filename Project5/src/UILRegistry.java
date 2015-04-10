import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class UILRegistry 
{
	private Map<String,List<String>> myRegistry;
	private ArrayList<String> passwords;
	
	public UILRegistry()
	{
		passwords = new ArrayList<String>();
		myRegistry = new TreeMap<String,List<String>>();
		Scanner scan;
		try {
			scan = new Scanner(new File("passwords.txt"));
			while(scan.hasNextLine())
			{
				String nextLine = scan.nextLine();
				passwords.add(nextLine);
			}
			scan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void addTeam(String School)
	{
		if(myRegistry.containsKey(School)==false)
		{
			ArrayList<String> a = new ArrayList<String>();
			a.add("team"+myRegistry.size());
			a.add(makePassword());
			a.add("\n");
			myRegistry.put(School, a);
		}
		else
		{	
			int count =0;
			for(String x:myRegistry.keySet())
			{
				if(School.equals(x))
				{
					count++;
				}
			}
			ArrayList<String> a = new ArrayList<String>();
			a.add("team"+myRegistry.size());
			a.add(makePassword());
			a.add("\n");
			myRegistry.put(School+"#"+count, a);
		}
	}
	
	public List<String> returnSchool(String School)
	{
		return myRegistry.get(School);
	}
	
	public Set<String> schoolList()
	{
		return myRegistry.keySet();
	}
	
	public String makePassword()
	{
		int x = (int)Math.random()*passwords.size();
		String passcode = passwords.get(x);
		passwords.remove(x);
		return passcode;
	}
	/*/
	public void sort()
	{
		for(String x:myRegistry.keySet())
		{
			if(myRegistry.get(x).size()>2)
			{
				int count = myRegistry.get(x).size()/2;
				while(count>0)
				{
					int revCount = 1;
					ArrayList<String> a = new ArrayList<String>();
					myRegistry.get(x).get(0);
					myRegistry.get(x).get(1);
					myRegistry.put(x+"#"+revCount,a);
					count--;
					revCount++;
				}
				myRegistry.remove(x);
			}
		}
	}
	//*/
	public String printAll()
	{
		String s = "";
		for(String x:schoolList())
		{
			s+=x;
			s+="\n";
			for(String y:myRegistry.get(x))
			{
				s+=y;
			}
		}
		return s;
		
	}
	
	void save(String fileName)
	{
		try {
			PrintWriter fout = new PrintWriter(fileName);
			for(String x: myRegistry.keySet())
			{
				String line = x;
				for(int i = 0; i<myRegistry.get(x).size()-1;i++)
				{
					x += "\\t"+ myRegistry.get(x).get(i);
				}
				
				fout.println(line);
				
			}
			fout.close();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
