package LoveBabbarDSA_Sheet;
import java.util.*;
public class mergeSort 
{
	public static void mergeSort(int nums[] , int low , int high)
	{
		if(low < high)
		{
			int mid = low + (high-low)/2;
			mergeSort(nums,low,mid);
			mergeSort(nums,mid+1,high);
			merge(nums,low,mid,high);
		}
	}
	
	public static void merge(int nums[] , int low , int mid , int high)
	{
		int len1 = mid-low+1;
		int len2 = high-mid;
		int left[] = new int[len1];
		int right[] = new int[len2];
		int mainIndex = low;
		for(int i=0;i<len1;i++)
		{
			left[i] = nums[low + i];
		}
		
		for(int i=0;i<len2;i++)
		{
			right[i] = nums[mid + 1 + i];
		}
		
		int k = low;
		int i=0,j=0;
		while(i < len1 && j < len2)
		{
			if(left[i] <= right[j])
			{
				nums[k] = left[i];
				i++;
			}
			
			else
			{
				nums[k] = right[j];
				j++;
			}
			
			k++;
		}
		
		while(i < len1)
		{
			nums[k] = left[i];
			i++;
			k++;
		}
		
		while(j < len2)
		{
			nums[k] = right[j];
			j++;
			k++;
		}
		
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER NUMBER OF ELEMENTS IN THE ARRAY : ");
		int n = sc.nextInt();
		int nums[] = new int[n];
		for(int i=0;i<n;i++)
		{
			nums[i] = sc.nextInt();
		}
		
		System.out.println("YOUR ARRAY :");
		for(int i=0;i<n;i++)
		{
			System.out.print(nums[i]+" ");
		}
		System.out.println("\n");
		
		mergeSort(nums,0,n-1);
		
		for(int i=0;i<n;i++)
			System.out.print(nums[i]+" ");

	}

}
