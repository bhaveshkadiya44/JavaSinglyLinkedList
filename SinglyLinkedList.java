class SinglyLinkedList<T> {

    protected SinglyNode<T> start;
    protected SinglyNode<T> end;
    public int size;

    public SinglyLinkedList() {
        start = null;
        end = null;
        size = 0;
    }

    public boolean isEmpty() {
        return start == null;
    }

    public int getSize() {
        return size;
    }

    /**
     * insert at the end of list.
     *
     * @param val
     */
    public void insert(T val) {
        SinglyNode nptr = new SinglyNode(val, null);
        size++;
        if (start == null) {
            start = nptr;
            end = start;
        } else {
            end.setNextlink(nptr);
            end = nptr;
        }
    }

    /**
     * delete greater than given value.
     *
     * @param value
     */
    public void deleteGT(Integer value) {
        SinglyNode prev = start;
        SinglyNode current = start;
        SinglyNode next = start;
        while (next != null) {
            prev = current;
            current = next;
            next = next.getNextLink();

            if (Integer.parseInt(current.dataItem.toString()) > value) {
                prev.nextLink = current.getNextLink();
                if (start == current) {
                    start = current.getNextLink();
                }
                if (end == current) {
                    end = current.getNextLink();
                }
                size--;
            }
        }
    }

    /**
     * delete last item of list.
     */
    public void delete() {

        if (start == end && size == 1) {
            start = null;
            end = null;
            size--;
            return;
        }

        SinglyNode next = start;
        SinglyNode prev = start;
        while (next != end) {
            prev = next;
            next = next.getNextLink();
        }
        end = prev;
        end.setNextlink(null);
        size--;
        return;
    }

    /**
     * print all values of list.
     */
    public void displayAll() {
        if (size == 0) {
            System.out.print("empty\n");
            return;
        }

        if (start.getNextLink() == null) {
            System.out.println(start.getData());
            return;
        }

        SinglyNode ptr = start;
        System.out.print(start.getData() + "->");
        ptr = start.getNextLink();
        while (ptr.getNextLink() != null) {
            System.out.print(ptr.getData() + "->");
            ptr = ptr.getNextLink();
        }

        System.out.print(ptr.getData() + "\n");
    }

}

class SinglyNode<T> {

    protected T dataItem;
    protected SinglyNode<T> nextLink;

    public SinglyNode(T d, SinglyNode n) {
        this.dataItem = d;
        this.nextLink = n;
    }

    /**
     * set next link
     *
     * @param n
     */
    public void setNextlink(SinglyNode<T> n) {
        this.nextLink = n;
    }

    /**
     * set data to node.
     *
     * @param data
     */
    public void setData(T data) {
        dataItem = data;
    }

    /**
     * get next link of node.
     *
     * @return
     */
    public SinglyNode getNextLink() {
        return nextLink;
    }

    /**
     * get data of node.
     *
     * @return
     */
    public T getData() {
        return dataItem;
    }

}
