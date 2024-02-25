import java.util.*;

public class Melody {

	private Queue<Note> notes;

	public Melody(Queue<Note> song) {
		notes = song;
	}
	
	public double getTotalDuration() {
		double duration = 0;
		boolean repeat = false;
		int size = notes.size();
			for (int i = 0; i < size; i++) {
				Note x = notes.poll();
				if (x.isRepeat() == true && repeat == false) {
					repeat = true;
					duration += x.getDuration() * 2;
				} else if (repeat == true && x.isRepeat() == false) {
					duration += x.getDuration() * 2;
				} else if(x.isRepeat() == true && repeat == true) {
					repeat = false;
					duration += x.getDuration() * 2;
				} else {
					duration += x.getDuration();
				}
				notes.offer(x);
			}
		return duration;
	}
	
	public String toString() {
		String ret = "";
		int size = notes.size();
		for (int i = 0; i < size; i++) {	
			Note x = notes.poll();
			ret += x.toString() + "\n";
			notes.offer(x);
		}
		return ret;
	}

	public void changeTempo(double tempo) {
		int size = notes.size();
		for (int i = 0; i < size; i++) {
			Note x = notes.poll();
			double duration = x.getDuration();
			x.setDuration(duration * tempo);
			notes.offer(x);
		}
	}
	
	public void reverse() {
		Stack<Note> stack = new Stack<Note>();
		int size = notes.size();
		for (int i = 0; i < size; i++) {
			stack.push(notes.poll());
		}
		while (stack.size() > 0) {
			notes.offer(stack.pop());
		}
	}
	
	public void append(Melody other) {
		Queue<Note> notes2 = other.getNotes();
		int size = notes2.size();
	
		for (int i = 0; i < size; i++) {
			Note note = notes2.poll();
			notes.offer(note);
			notes2.offer(note);
		}
	}
	
	public void play() {
		int size = notes.size();
		Queue<Note> notes2 = new LinkedList<Note>();
		int size2;
		int count = 0;
		
		for (int i = 0; i < size; i++) {
			if (notes.peek().isRepeat() == true) {
				count++;
			}
			
			if (count == 0) {
				Note note = notes.poll();
				note.play();
				notes.offer(note);
			} else if (count == 1) {
				notes2.offer(notes.peek());
				Note note = notes.poll();
				note.play();
				notes.offer(note);
			} else if (count == 2) {
				notes2.offer(notes.peek());
				Note note = notes.poll();
				note.play();
				notes.offer(note);
				
				size2 = notes2.size();
				for (int x = 0; x < size2; x++) {
					Note note2 = notes2.poll();
					note2.play();
					notes2.offer(note2);
				}
				count = 0;
			}
		}
	}

	public Queue<Note> getNotes() {
		return notes;
	}
}
