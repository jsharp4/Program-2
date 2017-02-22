/**
 * This is the structure for a singly linked list node
 * Consists of the data to be stored in the node
 * and the link to the next node in the list
 * @param <E>
 */
public class Listnode<E>{

    /** The data members
     * data: Holds the value of each node in the list
     * next: Holds the link to the next node in list
     */
    private E data;
    private Listnode<E> next;

    public Listnode(E data) {
        this.data = data;
        this.next = null;
    }

    public Listnode(E data, Listnode<E> next) {
        this.data = data;
        this.next = next;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Listnode<E> getNext() {
        return next;
    }

    public void setNext(Listnode<E> next) {
        this.next = next;
    }
}