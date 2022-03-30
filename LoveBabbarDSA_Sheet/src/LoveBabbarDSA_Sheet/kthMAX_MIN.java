
package LoveBabbarDSA_Sheet;
import java.util.*;
public class kthMAX_MIN 
{
	public static int kthMax(int nums[] , int k)
	{
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		int n = nums.length;
		for(int i=0;i<k;i++)
		{
			pq.add(nums[i]);
		}
		
		for(int i=k;i<n;i++)
		{
			if(pq.peek() < nums[i])
			{
				pq.poll();
				pq.add(nums[i]);
			}
		}
		
		return pq.peek();
		
	}
	
	public static int kthMin(int nums[] , int k)
	{
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		int n = nums.length;
		for(int i=0;i<k;i++)
		{
			pq.add(nums[i]);
		}
		
		for(int i=k;i<n;i++)
		{
			if(pq.peek() > nums[i])
			{
				pq.poll();
				pq.add(nums[i]);
			}
		}
		
		return pq.peek();
	}

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER SIZE OF ARRAY : ");
		int n = sc.nextInt();
		int nums[] = new int[n];
		for(int i=0;i<n;i++)
		{
			nums[i] = sc.nextInt();
		}
		System.out.println("YOUR ARRAY");
		for(int i=0;i<n;i++)
			System.out.print(nums[i]+" ");
		System.out.println("\n");
		System.out.println("ENTER VALUE OF k");
		int k = sc.nextInt();
		/*int x = operate(nums,k,'A');
		int y = operate(nums,k,' ');*/
		int x = kthMax(nums,k);
		System.out.println("KTH MAXIMUM NUMBER : "+x);
		int y = kthMin(nums,k);
		System.out.println("KTH MINIMUM NUMBER : "+y);
	}

}
