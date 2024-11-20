class BinarySearchTree {

  class Node {

    int data;
    Node left, right;

    Node(int data) {
      this.data = data;
      left = right = null;
    }
  }

  private Node root;

  public void insert(int data) {
    root = insertRec(root, data);
  }

  private Node insertRec(Node root, int data) {
    if (root == null) {
      root = new Node(data);
      return root;
    }
    if (data < root.data) {
      root.left = insertRec(root.left, data);
    } else if (data > root.data) {
      root.right = insertRec(root.right, data);
    }
    return root;
  }

  public boolean search(int key) {
    return searchRec(root, key) != null;
  }

  private Node searchRec(Node root, int key) {
    if (root == null || root.data == key) {
      return root;
    }
    if (key < root.data) {
      return searchRec(root.left, key);
    }
    return searchRec(root.right, key);
  }

  public void displayInOrder() {
    System.out.print("In-order: ");
    inOrderRec(root);
    System.out.println();
  }

  private void inOrderRec(Node root) {
    if (root != null) {
      inOrderRec(root.left);
      System.out.print(root.data + " ");
      inOrderRec(root.right);
    }
  }

  public static void main(String[] args) {
    BinarySearchTree bst = new BinarySearchTree();
    bst.insert(50);
    bst.insert(30);
    bst.insert(20);
    bst.insert(40);
    bst.insert(70);
    bst.insert(60);
    bst.insert(80);

    bst.displayInOrder();

    System.out.println("Search 40: " + bst.search(40));
    System.out.println("Search 90: " + bst.search(90));
  }
}
