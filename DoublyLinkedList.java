class DoublyLinkedList {

  class Node {

    int data;
    Node next, prev;

    Node(int data) {
      this.data = data;
      this.next = this.prev = null;
    }
  }

  private Node head;

  public void insertAtEnd(int data) {
    Node newNode = new Node(data);
    if (head == null) {
      head = newNode;
      return;
    }
    Node temp = head;
    while (temp.next != null) {
      temp = temp.next;
    }
    temp.next = newNode;
    newNode.prev = temp;
  }

  public void delete(int key) {
    if (head == null) return;

    if (head.data == key) {
      head = head.next;
      if (head != null) {
        head.prev = null;
      }
      return;
    }

    Node temp = head;
    while (temp != null && temp.data != key) {
      temp = temp.next;
    }

    if (temp == null) {
      System.out.println("Key not found");
      return;
    }

    if (temp.next != null) {
      temp.next.prev = temp.prev;
    }
    temp.prev.next = temp.next;
  }

  public void display() {
    if (head == null) {
      System.out.println("List is empty");
      return;
    }
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.data + " <-> ");
      temp = temp.next;
    }
    System.out.println("null");
  }

  public static void main(String[] args) {
    DoublyLinkedList list = new DoublyLinkedList();
    list.insertAtEnd(10);
    list.insertAtEnd(20);
    list.insertAtEnd(30);
    list.display();
    list.delete(20);
    list.display();
  }
}
