public class main {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.insert(13);
        list.insert(15);
        list.insert(2);
        list.insert(1);
        list.displayAll();

        list.delete(); // remove tail element.
        list.displayAll();

        list.deleteGT(5);
        list.displayAll();
    }
}
