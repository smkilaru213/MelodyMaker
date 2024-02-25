import java.util.LinkedList;
import java.util.Queue;

public class Runner {

	public Runner() {

	}

	public static void main(String[] args) {
		QueueProbs test = new QueueProbs();

		Queue<Integer> nums = new LinkedList<Integer>();	
		nums.offer(3);
		nums.offer(5);
		nums.offer(4);
		nums.offer(17);
		nums.offer(6);
		nums.offer(83);
		nums.offer(1);
		nums.offer(84);
		nums.offer(16);
		nums.offer(37);
		
		System.out.println(nums + " >>> " + test.evenFirst(nums));
		
		Queue<Integer> nums2 = new LinkedList<Integer>();	
		nums2.offer(3);
		nums2.offer(10);
		nums2.offer(12);
		nums2.offer(9);
		nums2.offer(12);
		nums2.offer(10);
		nums2.offer(3);

		Queue<Integer> nums3 = new LinkedList<Integer>();	
		nums3.offer(5);
		nums3.offer(3);
		nums3.offer(87);
		nums3.offer(95);
		nums3.offer(87);
		nums3.offer(10);
		nums3.offer(9);
		
		System.out.println(nums2 + " >>> " + test.numPalindrome(nums2));
		System.out.println(nums3 + " >>> " + test.numPalindrome(nums3));		
		System.out.println(test.eratosthenes(50));
		
	}

}
