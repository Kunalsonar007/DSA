class TreeTraversal {

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

  public void displayTraversals() {
    System.out.print("In-order: ");
    inOrder(root);
    System.out.println();

    System.out.print("Pre-order: ");
    preOrder(root);
    System.out.println();

    System.out.print("Post-order: ");
    postOrder(root);
    System.out.println();
  }

  private void inOrder(Node root) {
    if (root != null) {
      inOrder(root.left);
      System.out.print(root.data + " ");
      inOrder(root.right);
    }
  }

  private void preOrder(Node root) {
    if (root != null) {
      System.out.print(root.data + " ");
      preOrder(root.left);
      preOrder(root.right);
    }
  }

  private void postOrder(Node root) {
    if (root != null) {
      postOrder(root.left);
      postOrder(root.right);
      System.out.print(root.data + " ");
    }
  }

  public static void main(String[] args) {
    TreeTraversal tree = new TreeTraversal();
    tree.insert(50);
    tree.insert(30);
    tree.insert(20);
    tree.insert(40);
    tree.insert(70);
    tree.insert(60);
    tree.insert(80);

    tree.displayTraversals();
  }
}
