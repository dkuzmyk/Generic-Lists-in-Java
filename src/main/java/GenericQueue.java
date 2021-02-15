import java.util.Iterator;

public class GenericQueue<I> extends GenericLists<I> {

    protected GenericQueue() {
        this.length = 0;
        this.head = null;
    }

    @Override
    public void add(I data) {                      // add method, add a new node with a data value
        Node<I> newNode = new Node<I>(data);       // create a new node
        newNode.next = null;                       // set next to null
        this.length++;                                  // increase length of linked list

        if (this.head == null) {                        // if list empty
            this.head = newNode;                        // set head to new node
        } else {
            Node<I> tail = this.head;                   // if list not empty, make a new tail node
            while (tail.next != null) {            // while we're not at the end of the list
                tail = tail.next;                  // move up the list
            }
            tail.next = newNode;                   // set the new node as the next of the tail
        }                                          // making it the very last node at this time
    }

    void enqueue(I data){add(data);}

    void dequeue(){
        //this.length--;
        //System.out.println("Length "+this.length); //debug
        delete();
    }

    @Override
    public Iterator<I> createIterator() {
        return new GLIterator<>(head);
    }
}