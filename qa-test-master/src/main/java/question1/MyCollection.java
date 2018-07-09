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
	int addedSoFar=0;
	/**
	 * It constructs an empty Collection object with an array capacity specified by the integer
		parameter "arraySize".
	 */
	public MyCollection(int arraySize){
		numArray = new int[arraySize];
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
		}
		return -1;
	}

	public boolean add(int numberToAdd) 
	{
		// TODO Auto-generated method stub
		if(search(numberToAdd)!=-1)
			return false;
		int count=getCount();
		if(count==numArray.length)
			doubleCapacity();
		if(search(numberToAdd)==-1 && count<numArray.length)
			/*for(int i=numArray.length;i>0;i--)
			{
				numArray[i]=numArray[i-1];
			}*/
			numArray[count]=numberToAdd;
		addedSoFar++;
			return true;
	}

	public void doubleCapacity() {
		// TODO Auto-generated method stub
		int[] newArray=new int[numArray.length*2];
		for(int i=0;i<addedSoFar;i++)
		{
			newArray[i]=numArray[i];
		}
		numArray=newArray;
	}

	public boolean remove(int numberToRemove) {
		// TODO Auto-generated method stub
		int index=search(numberToRemove);
		/*int[] newArray=new int[numArray.length];
		newArray=numArray;*/
		if(index != -1)
		{
			for(int i=index;i<addedSoFar;i++)
			{
				/*int t=newArray[i-1];
				newArray[i-1]=newArray[i];*/
				numArray[i]=numArray[i+1];
			}
			//numArray=newArray;
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
		/* for (int i = 0; i < n; i++)
		 {
			 int temp = numArray[0], j;
			   for (j = 0; j < numArray.length-1; j++)
				   numArray[j] = numArray[j+1];    
			   numArray[j] = temp;
		 }
		return numArray;*/
		int k=0;
		int arr[]= new int[n];
		for(int i=0;i<n;i++)
			arr[i]=numArray[i];
		for(int i=0;i<addedSoFar-n;i++)
			numArray[i]=numArray[i+n];
		for(int i=(addedSoFar)-n;i<addedSoFar;i++)
			numArray[i]=arr[k++];
		
		return numArray;
	}
	public String toString( )
	{
		String s="{";
		if( addedSoFar!=0) 
		{
			for(int i=0;i< addedSoFar-1;i++)
			{
				s=s+numArray[i]+",";
			}
			s=s+numArray[ addedSoFar-1]+"}";
		}
		if( addedSoFar==0) {
			return "{}";
		}
		return s;
	}
}
