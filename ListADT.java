public interface ListADT<E> extends Iterable<E>{

    /** Adds an item at the end of the list
    * @param item
     *              an item to add to the list
     *@throws IllegalArgumentException
     *              if item is null
     */

    void add(E item);

    /** Add an item at any position in the list
     * @param item
     *              an item to be added to the list
     * @param pos
     *              position at which the item must be added. Indexing starts from 0
     * @throws IllegalArgumentException
     *              if item is null
     * @throws IndexOutOfBoundsException
     *              if pos is less than 0 or greater than size() - 1
     */

    void add(int pos, E item);

    /** Check if a particular item exists in the list
     * @param item
     *              the item to be checked for in the list
     * @return true
     *              if value exists, else false
     * @throws IllegalArgumentException
     *              if item is null
     */

    boolean contains(E item);

    /** Returns the item at a particular position
     * @param E
     *            item to be returned at a given position
     * @throws IndexOutOfBoundsException
     *              if position is less than 0 or greater than size() - 1
     */

    E get(int pos);

    /** Returns true if the list is empty
     * @return value is true if the list is empty
     *              else false
     */

    boolean isEmpty();

    /** Removes the item at the given positions
     * @param pos
     *          the position of the item to be deleted from the list
     * @return returns the item deleted
     * @throws IndexOutOfBoundsException
     *          if the pos value is less than 0 or greater than size() - 1
     */

    E remove(int pos);

    /** Returns the size of the singly linked list
     * @return the size of the singly linked list
     */

    int size();


}
