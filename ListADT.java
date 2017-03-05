/////////////////////////////////////////////////////////////////////////////
// Semester:         CS367 Spring 2017
// PROJECT:          Program 2
// FILE:             ListADT.java
//
// TEAM:    Team 35 Java Badgers
// Authors: Jon Sharp, Lindsey Bohr, Allison Quick
// Author1: Jon Sharp, jsharp4@wisc.edu, jsharp4, LEC 001
// Author2: Allison Quick, aquick2@wisc.edu, aquick2, LEC 001
// Author3: Lindsey Bohr, bohr@wisc.edu, bohr, LEC 001
//
//////////////////////////// 80 columns wide //////////////////////////////////
/**
 * This interface extends Iterable and is used in: JobList?
 *
 * <p>Bugs: None that we are aware of
 *
 * @author Jon Sharp, Lindsey Bohr, Allison Quick
 */
public interface ListADT<E> extends Iterable<E>{

    /** Allows a class to add an item at the end of the list
     * @param item
     *              an item to add to the list
     */

    void add(E item);

    /** Allows a class to add an item at any position in the list
     * @param item
     *              an item to be added to the list
     * @param pos
     *              position at which the item must be added. Indexing starts from 0
     */

    void add(int pos, E item);

    /** Allows a class to check if a particular item exists in the list
     * @param item
     *              the item to be checked for in the list
     */

    boolean contains(E item);

    /** Allows a class to return the item at a particular position
     * @param E
     *            item to be returned at a given position
     */

    E get(int pos);

    /** Allows a class to return true if the list is empty
      */

    boolean isEmpty();

    /** Allows a class to remove the item at the given positions
     * @param pos
     *          the position of the item to be deleted from the list
     */

    E remove(int pos);

    /** Allows a class to return the size of the singly linked list
     */

    int size();


}//closes ListADT
