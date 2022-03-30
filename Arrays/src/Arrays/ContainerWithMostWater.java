package Arrays;
import java.util.*;
public class ContainerWithMostWater //We went greedy in this implementation
{
	public static int maxArea(int height[])
	{
		int n = height.length;
		int start = 0;
		int end = n-1;
		int area = Integer.MIN_VALUE;
		while(start != end)
		{
			int temp = (end-start)*(Math.min(height[start], height[end]));
			if(temp > area)
				area = temp;
			
			if(height[start] < height[end])
				start++;
			else
				end--;
		}
		
		return area;
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER SIZE OF HEIGHT ARRAY\n");
		int n = sc.nextInt();
		int height[] = new int[n];
		
		for(int i=0;i<n;i++)
		{
			System.out.println("ENTER ELEMENT");
			height[i] = sc.nextInt();
		}
		
		System.out.println("YOUR ARRAY ");
		display(height);
		System.out.println("MAXIMUM AREA :");
		int x = maxArea(height);
		System.out.println(x);
	}
	
	public static void display(int nums[])
	{
		for(int i=0;i<nums.length;i++)
		{
			System.out.print(nums[i]+" ");
		}
		System.out.println("\n");
	}
}
