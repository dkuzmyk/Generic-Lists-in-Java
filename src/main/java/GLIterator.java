import java.util.Iterator;

public class GLIterator<I> implements Iterator <I>{

    private GenericLists.Node<I> tempCurrent = null;        // create pointer for current position
    private GenericLists.Node<I> tempHead = null;           // crete pointer for head position

    GLIterator(GenericLists.Node<I> head) {                 // constructor to import head from other classes
        tempHead = head;
    }

    @Override
    public boolean hasNext() {                              // check for next node
        if(tempCurrent == null && tempHead != null)         // if current position is null & head exists
            return true;                                    // we have a next, 1st node
        else if(tempHead == null)                           // if head doesn't exist, return 0
            return false;
        else
            return tempCurrent.next != null;                // else, return next node
    }

    @Override
    public I next() {                                       // next method
        if(tempCurrent == null && tempHead != null) {       // if current is null and head exists
            tempCurrent = tempHead;                         // set current to head
            return tempHead.data;                       // return the data from head
        }
        else if(tempCurrent != null) {                      // else, if in the middle of the list
            tempCurrent = tempCurrent.next;                 // move on to next node
            return tempCurrent.data;                        // return the previous value
        }
        else
            return null;                                    // nothing exists
    }
}