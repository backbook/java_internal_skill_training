package data.structure.linked;

/**
 * 链表操作
 *
 * @param <Data>
 */
public class LinkedList<Data> {

    private class Node<Data> {
        //定义数据类型
        Data data;
        //定义
        Node<Data> next;

        public Node(Data data) {
            this.data = data;
        }
    }

    private Node head;

    private Node last;

    private int size;

    public Node get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("超出链表节点范围");
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    private void addLast(Data data) {
        Node insertNode = new Node(data);
        if (size == 0) {
            head = insertNode;
            last = insertNode;
        } else {
            last.next = insertNode;
            last = insertNode;
        }
        size++;
    }

    private void deleteLast() {
        //当判断只有一位数 Head的时候，进行删除操作的时候，可以直接将head和last直接置空
        if (size <= 0) {
            throw new IndexOutOfBoundsException("链表数据已经为空");
        } else if (size == 1) {
            head = null;
            last = null;
        } else {
            Node<Data> node = get(size - 2);
            node.next = null;
            last = node;
        }
        size--;
    }


    private void insert(Data data, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出链表节点范围");
        }
        Node insertNode = new Node(data);
        //前两个方法是用来进行插入操作
        if (size == 0) {
            head = insertNode;
            last = insertNode;
        } else if (index == size) {
            last.next = insertNode;
            last = insertNode;
        } else if (index == 0) {
            insertNode.next = head;
            head = insertNode;
        } else {
            Node prevNode = get(index - 1);
            insertNode.next = prevNode.next;
            prevNode.next = insertNode;
        }
        size++;
    }


    /**
     * 使用递归对单链表进行翻转
     *    递归表达
     *    1 -> 2 -> 3 -> 4 -> null
     *    1 <- 2 <- 3 <- 4 <- last
     *  |    |    |     |
     *null  null  null  null
     * @return
     */
    public Node<Data> reverse(Node head){
        if (head.next == null) return head;
        Node last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void printFor() {

        for (Node p = head; p != null; p = p.next) {
            System.out.print(p.data + "->");
        }
        System.out.print("null");

    }


    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList();
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(4);
//        linkedList.deleteLast();

//        linkedList.deleteLast();
        linkedList.printFor();
        System.out.println();
        linkedList.head = linkedList.reverse(linkedList.head);
        linkedList.printFor();



    }


}
