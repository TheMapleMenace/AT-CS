package heap1;
import java.util.List;
import java.util.ArrayList;

public class Heap
{
	private List<Integer> list;

	public Heap()
	{
		list = new ArrayList<Integer>();
		list.add(null);
		System.out.println(list);
	}

	public void add(int value)
	{
		list.add(value);
		swapUp(list.size()-1);
	}

	public void swapUp(int bot)
	{
		if(bot <= 1)
			return;
		
		if(list.get(bot/2) < list.get(bot)){
			swap(bot, bot/2);
		}
		
		swapUp(bot/2);
	}

	public void remove( )
	{
		list.set(1,list.get(list.size()-1));
		list.remove(list.size()-1);
		swapDown(list.get(1));
	}

	public void swapDown(int top)
	{
		//base
		if(top*2 >= list.size())
			return;
		
		System.out.print("SD");
		
		if(list.get(top*2) > list.get(top)){
			swap(top*2, top);
			swapDown(top*2);
		}
		
		else if(list.get(top*2 + 1) > list.get(top)){
			swap(top*2 + 1, top);
			swapDown(top*2+1);
		}
		
		
	}

	private void swap(int start, int finish)
	{
		int temp = list.get(finish);
		
		list.set(finish, list.get(start));
		list.set(start,  temp);
	}

	public void print()
	{
		System.out.println("\n\nPRINTING THE HEAP!\n\n");
//		System.out.println(print(1, ""));
		System.out.println(toString());
	}

	public String print(int ind, String s){
		if(ind >= list.size())
			return s+"";
		
		s+=list.get(ind)+" ";
		if(ind%2 != 0)
			s+="\n";
		
		
		return(print(ind+1, s));
	}
	
	public String toString()
	{
		return list.toString();
	}
}