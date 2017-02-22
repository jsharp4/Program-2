import java.util.Iterator;
import java.util.NoSuchElementException;

public class JobListIterator implements Iterator<Job> {
	private Listnode<Job> items;
	private int numItems;
	private int position;
	
	public JobListIterator(Listnode<Job> items, int numItems) {
		this.items = items;
		this.numItems = numItems;
		position = 0;
	}
	
	public boolean hasNext() {
		return position < numItems;
	}

	public Job next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		items = items.getNext();
		position++;
		return items.getData();
	}

}
