package cpe200;

public class PList {

    public PList() {
        head = tail = null;
    }

    public void pushToHead(Object i) {
        head = new PNode(i, head, null);
        if (tail == null)
            tail = head;
        else
            head.next.prev = head;
        size++;
    }

    public void pushToTail(Object i) {
        tail = new PNode(i, null, tail);
        if (head == null)
            head = tail;
        else
            tail.prev.next = tail;
        size++;
    }

    public Object popHead() {
        Object data = head.data;
        PNode tmp = head;

        if (head == tail)
            head = tail = null;
        else {
            head = head.next;
            head.prev = null;
            tmp.next = null;
        }

        size--;

        return data;
    }

    public Object popTail() {
        Object data = tail.data;
        PNode tmp = tail;

        if (tail == head)
            tail = head = null;
        else {
            tail = tail.prev;
            tail.next = null;
            tmp.prev = null;
        }

        size--;

        return data;
    }

    public boolean remove(Object data) {
        PNode tmp=head;
        while (tmp!=null){
            if(tmp.data.equals(data)){
                if(tmp==head){
                    popHead();
                    return true;
                }else if(tmp==tail){
                    popTail();
                    return true;
                }else{
                    tmp.prev.next=tmp.next;
                    tmp.next.prev=tmp.prev;

                    return true;
                }

            }
            tmp=tmp.next;
        }
        return false;

        // implement your code here!!!
        // case 1: head of the list
        // case 2: tail of the list
        // case 3: somewhere in the middle
    }




    public Object elementAt(int index) {
        // implement your code here!!!
        // what if index is not in between 0 to (size-1)
        if (index<0||index>size-1){
            return null;
        }
        PNode tmp=head;
        for (int i=0;i<size-1;i++){
            if(i==index){
                return  tmp.data;
            }else{
            tmp=tmp.next;
            }
        }
        return  null;
    }

    // rename the search method to "found(Object data)"
    public boolean found(Object data) {
        // implement your code here!!!
        PNode tmp=head;
        while (tmp!=null){
            if (tmp.data.equals(data)){
                return  true;
            }
            tmp=tmp.next;
        }
        return false;
    }

    public boolean isEmpty() { return (head == null); }

    public void printForward() {
        PNode tmp = head;

        while (tmp != null) {
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
        System.out.println();
    }

    public void printBackward() {
        PNode tmp = tail;

        while (tmp != null) {
            System.out.println(tmp.data);
            tmp = tmp.prev;
        }
        System.out.println();
    }

    public int getSize() {
        return size;
    }

    private PNode head, tail;
    private int size=0;
}
