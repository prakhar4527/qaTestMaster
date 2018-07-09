package question1;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Please implement Dynamic Array Interface 
 * @author 
 *
 */
public class MyCollection implements DynamicArray{
// Uncomment commented section
	
	/**
	 * You can declare local/global variables as per your requirement
	 */
	@SuppressWarnings("unused")
	private int[] numArray;
	int cap;
	int addedSoFar=0;
	/**
	 * It constructs an empty Collection object with an array capacity specified by the integer
		parameter "arraySize".
	 */
	public MyCollection(int arraySize){
		numArray = new int[arraySize];
		cap=arraySize;
	}

	public int search(int searchingNum) {
		// TODO Auto-generated method stub
		int x=searchingNum;
		for(int i=0;i<numArray.length;i++)
		{
			if(numArray[i]==x)
			{
				return i;
			}
			else
			{
				return -1;
			}
		}
		return 0;
	}

	public boolean add(int numberToAdd) {
		// TODO Auto-generated method stub
		if(search(numberToAdd)!=-1)
		{
			if(numArray.length>=cap)
			{
				doubleCapacity();
			}
			for(int i=numArray.length;i>0;i--)
			{
				numArray[i]=numArray[i-1];
			}
			numArray[0]=numberToAdd;
			addedSoFar++;
			return true;
		}
		return false;
	}

	public void doubleCapacity() {
		// TODO Auto-generated method stub
		int[] newArray=new int[cap*2];
		for(int i=0;i<numArray.length;i++)
		{
			newArray[i]=numArray[i];
		}
		numArray=newArray;
	}

	public boolean remove(int numberToRemove) {
		// TODO Auto-generated method stub
		int index=search(numberToRemove);
		int[] newArray=new int[numArray.length];
		newArray=numArray;
		if(index != -1)
		{
			for(int i=newArray.length-1;i>index;i--)
			{
				int t=newArray[i-1];
				newArray[i-1]=newArray[i];
			}
			numArray=newArray;
			addedSoFar--;
			return true;
		}
		return false;
	}

	public int getCount() {
		// TODO Auto-generated method stub
		return addedSoFar;
	}

	public int[] rotate(int n) {
		// TODO Auto-generated method stub
		 for (int i = 0; i < n; i++)
		 {
			 int temp = numArray[0], j;
			   for (j = 0; j < numArray.length-1; j++)
				   numArray[j] = numArray[j+1];    
			   numArray[j] = temp;
		 }
		return numArray;
	}
	public String toString( )
	{
		/*String[] s=new String[numArray.length];
		for(int i=0;i<numArray.length;i++)
		{
			s[i]=String.valueOf(numArray[i]);
		}
		String a=
		for(int i=0;i<s.length;i++)
		{
			if(i!=0 && i!=s.length-1)
				a=a+",";
			a=a+s[i];
				
		}
		return "{"+a+"}";*/
		/*String a=Arrays.toString(numArray); //toString the List or Vector
		String ar[]=a.substring(1,a.length()-1).split(", ");
		List<String> arrayList = new ArrayList<>(); 
		Collections.addAll(arrayList, ar); 		//System.out.println(Arrays.toString(ar));
	//	return "{" + Arrays.toString(ar) + "}";
		return   Arrays.toString(ar) ;*/
		
		
			String result = "{";
		      for (int i = 0; i < addedSoFar; i++) {
		         if (i > 0) {
		            result = result + ",";
		         }
		         String item =Arrays.toString(numArray);
		         result = result + item;
		      }
		      result = result + "}";
		      return result;
		
	}
	

}
