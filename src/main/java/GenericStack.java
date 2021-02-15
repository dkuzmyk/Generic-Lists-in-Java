import java.util.Iterator;

public class GenericStack<I> extends GenericLists<I> {

    protected GenericStack() {
        this.length = 0;
        this.head = null;
    }

    @Override
    public void add(I data) {                                 // add method, add a new node with a data value
        Node<I> newNode = new Node<I>(data);                  // create a new node
        newNode.next = null;                                  // set next to null
        this.length++;                                        // increase length of linked list

        if (this.head == null) {                              // if list empty
            this.head = newNode;                              // set head to new node
        } else {
            newNode.next = this.head;
            this.head = newNode;
        }                                                     // making it the very last node at this time
    }

    public void push(I data){add(data);}

    public void pop(){
        //this.length--;
        //System.out.println("Length "+this.length); //debug
        delete();
    }

    @Override
    public Iterator<I> createIterator() {
        return new GLIterator<>(head);
    }
}
