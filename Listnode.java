/////////////////////////////////////////////////////////////////////////////
// Semester:         CS367 Spring 2017
// PROJECT:          Program 2
// FILE:             Listnode.java
//
// TEAM:    Team 35 Java Badgers
// Authors: Jon Sharp, Lindsey Bohr, Allison Quick
// Author1: Jon Sharp, jsharp4@wisc.edu, jsharp4, LEC 001
// Author2: Allison Quick, aquick2@wisc.edu, aquick2, LEC 001
// Author3: Lindsey Bohr, bohr@wisc.edu, bohr, LEC 001
// Author4: Kendra Raczek, raczek@wisc.edu, raczek, LEC 001
//
//////////////////////////// 80 columns wide //////////////////////////////////

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
    /*This constructor allows for the input of data and sets
     *the incoming data to this data and sets next to null. 
     *@param E data
     */
    public Listnode(E data) {
        this.data = data;
        this.next = null;
    } //closes constructor
    /*This constructor allows for the input of data and a Listnode,
     *then sets the incoming data to this data and next to this next. 
     *@param E data
     *@param Listnode<E> next
     */
    public Listnode(E data, Listnode<E> next) {
        this.data = data;
        this.next = next;
    } //closes the second constructor
    /*This accessor method returns the data.
     *@return data
     */
    public E getData() {
        return data;
    }//closes getData
   /*This mutator method sets this data to an incoming data.
     *@param E data
     */
    public void setData(E data) {
        this.data = data;
    }//closes setData(E data)
    /*This accessor method returns next.
     *@return next
     */
    public Listnode<E> getNext() {
        return next;
    }//closes getNext()
   /*This mutator method sets this next to an incoming next.
     *@paramListnode<E> next
     */
    public void setNext(Listnode<E> next) {
        this.next = next;
    }// closes setNext(Listnode<E> next)
} //closes Listnode
