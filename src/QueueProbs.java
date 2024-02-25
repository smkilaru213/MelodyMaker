import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueProbs {
		
	public QueueProbs() {

	}

	//3
	public Queue<Integer> evenFirst(Queue<Integer> nums) {
		Queue<Integer> odd = new LinkedList<Integer>();	
		Queue<Integer> even = new LinkedList<Integer>();	

		while(nums.isEmpty() == false) {
			int x = nums.poll();
			if(x % 2 == 1) {
				odd.offer(x);
			} else {
				even.offer(x);
			}
		}
		while (odd.isEmpty() == false) {
			even.offer(odd.poll());
		}
		return even;
	}
	
	public boolean numPalindrome(Queue<Integer> nums) {
		int size = nums.size();
		Queue<Integer> copy = nums;
		int[] c = new int[nums.size()];
		
		for (int i = 0; i < size; i++) {
			c[i] = copy.poll();
		}
		
		for (int i = 0; i < (size / 2) + 1; i++) {
			if (c[i] != c[size - i - 1]) {
				return false;
			}   
		}
		return true;
	}
	
	public Stack<Integer> eratosthenes(int n){
		Queue<Integer> cont = new LinkedList<>();
		Stack<Integer> prime = new Stack<>();
		
		for (int i = 2; i <= n; i++) {
			cont.offer(i);
		}

		while (cont.isEmpty() == false) {
			prime.push(cont.poll());
			int contSize = cont.size();
			Queue<Integer> temp = new LinkedList<>();
			
			for (int i = 0; i < contSize; i++) {
				if (cont.peek() % prime.peek() != 0) {
					temp.offer(cont.poll());
				} else {
					cont.poll();
				}
			}
			cont = temp;
		}
		return prime;
	}
}
