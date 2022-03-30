package Arrays;
import java.util.*;
public class CombinationSum2 {
	static List<List<Integer>> list = new ArrayList<>();

	public static void findComb(int nums[], int target) {
		Arrays.sort(nums);
		helper(nums, new LinkedList<>(),target,0,list);

	}

	private static void helper(int[] candidates, LinkedList<Integer> comb, Integer remain, Integer curr,
			List<List<Integer>> results) {
		if (remain == 0) {
// copy the current combination to the final list.
			results.add(new ArrayList<Integer>(comb));
			return;
		}

		for (int nextCurr = curr; nextCurr < candidates.length; ++nextCurr) {
			if (nextCurr > curr && candidates[nextCurr] == candidates[nextCurr - 1])
				continue;

			Integer pick = candidates[nextCurr];
// optimization: early stopping
			if (remain - pick < 0)
				break;

			comb.addLast(pick);
			helper(candidates, comb, remain - pick, nextCurr + 1, results);
			comb.removeLast();
		}
	}

	public static void main(String ags[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER SIZE OF ARRAY");
		int n = sc.nextInt();
		int nums[] = new int[n];
		for (int i = 0; i < n; i++) {
			System.out.println("ENTER ELEMENT");
			nums[i] = sc.nextInt();
		}

		System.out.println("\nYOUR ARRAY");
		for (int i = 0; i < n; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();

		System.out.println("ENTER TARGET SUM");
		int tar = sc.nextInt();
		findComb(nums, tar);
		System.out.println("YOUR REQUIRED WAYS");
		for (List<Integer> el : list) {
			System.out.println(el);
		}

	}

}
