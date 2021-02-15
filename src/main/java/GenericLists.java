import java.util.Iterator;

public abstract class GenericLists<I> implements CreateIterator<I> {

    protected static class Node<T>{                   // node subclass
        T data;                                     // data in node
        Node<T>next;                                // pointer to next

        protected Node(T val){                        // constructor
            this.data = val;                        // set default values
            this.next = null;
        }
    }

    protected int length;                                     // data in GenericLists
    protected Node<I> head;                                   // head of linked list

    protected GenericLists(){                 // constructor
        this.length = 0;                           // set default values
        this.head = null;
    }

    public void print(){                               // print method
        //System.out.println("my print head: "+this.head); debug
        Node<I> printNode = this.head;                 // create a temporary pointer to head
        while(printNode != null){                      // iterate thro the list
            System.out.println(printNode.data);        // print each data
            printNode = printNode.next;                // move on the list
        }
        //System.out.println("Length "+this.length);            // debug check





    }

    // create a node and add value
    // the node is referenced to genericLists
    public abstract void add(I data);

    /*
    public void add(I data) {                       // add method, add a new node with a data value
        Node<I> newNode = new Node<I>(data);        // create a new node
        newNode.next = null;                        // set next to null
        length++;                                   // increase length of linked list

        if (head == null) {                         // if list empty
            head = newNode;                         // set head to new node
        } else {
            Node<I> tail = head;                    // if list not empty, make a new tail node
            while (tail.next != null) {             // while we're not at the end of the list
                tail = tail.next;                   // move up the list
            }
            tail.next = newNode;                    // set the new node as the next of the tail
        }                                           // making it the very last node at this time
    }
    */
    //public abstract I delete();

    public I delete() {                            // delete method, eliminate 1st node and return value
        //System.out.println("my delete head: " + this.head);  //debug
        if (this.head == null) {                        // if list is empty
            System.out.println("List empty");     // warn of the fact
            return null;                          // return nothing
        } else {                                    // otherwise
            length--;
            Node<I> del = head;                   // mark the head node
            head = head.next;                     // move head to next node
            del.next = null;                      // delink the marked node
            return del.data;                      // return the value of that node
        }                                         // shall garbage collection be with you
    }

}

