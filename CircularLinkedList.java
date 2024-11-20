class CircularLinkedList {

  class Node {

    int data;
    Node next;

    Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  private Node head;

  public void insertAtEnd(int data) {
    Node newNode = new Node(data);
    if (head == null) {
      head = newNode;
      newNode.next = head;
      return;
    }
    Node temp = head;
    while (temp.next != head) {
      temp = temp.next;
    }
    temp.next = newNode;
    newNode.next = head;
  }

  public void delete(int key) {
    if (head == null) return;

    if (head.data == key && head.next == head) {
      head = null;
      return;
    }

    Node last = head, temp = head;

    // If head is to be deleted
    if (head.data == key) {
      while (last.next != head) {
        last = last.next;
      }
      head = head.next;
      last.next = head;
      return;
    }

    // Search for the key to be deleted
    while (temp.next != head && temp.next.data != key) {
      temp = temp.next;
    }

    if (temp.next.data == key) {
      temp.next = temp.next.next;
    } else {
      System.out.println("Key not found");
    }
  }

  public void display() {
    if (head == null) {
      System.out.println("List is empty");
      return;
    }
    Node temp = head;
    do {
      System.out.print(temp.data + " -> ");
      temp = temp.next;
    } while (temp != head);
    System.out.println("(back to head)");
  }

  public static void main(String[] args) {
    CircularLinkedList list = new CircularLinkedList();
    list.insertAtEnd(10);
    list.insertAtEnd(20);
    list.insertAtEnd(30);
    list.display();
    list.delete(20);
    list.display();
  }
}
