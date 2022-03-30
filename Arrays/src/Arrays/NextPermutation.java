package Arrays;
import java.util.*;
public class NextPermutation 
{
	public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
        
        for(int element : nums)
        	System.out.print(element+" ");
        System.out.println();
    }

    private static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER SIZE OF ARRAY");
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++)
		{
			System.out.println("ENTER DIGIT OF YOUR NUMBER");
			arr[i] = sc.nextInt();
		}
		System.out.println("YOUR NUMBER");
		for(int i=0;i<n;i++)
			System.out.print(arr[i]+" ");
		System.out.println("\nNEXT BIGGER PERMUTATION OF THIS NUMBER");
		nextPermutation(arr);
	}

}
