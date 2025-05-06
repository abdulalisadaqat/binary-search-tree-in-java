public class BinaryTree {
  private Node root;

  // public methods (calling private methods)
  public void insert(int data) {
    root = insert(root, data);
  }

  public void delete(int key) {
    root = delete(root, key);
  }

  public void find(int key) {
    Node result = find(root, key);
    if (result != null) {
      System.out.printf("\nKey found: %d\n", result.data);
    } else {
      System.out.printf("\nKey not found: %d\n", key);
    }
  }

  public void traverseTree() {
    traverseTree(root);
  }

  // private methods
  // insert method
  private Node insert(Node root, int data) {
    if (root == null) {
      return new Node(data);
    }

    if (data < root.data) {
      root.leftChild = insert(root.leftChild, data);
    } else {
      root.rightChild = insert(root.rightChild, data);
    }
    return root;
  }

  // delete method
  private Node delete(Node root, int key) {
    if (root == null) {
      return null;
    }

    // finding the node to be deleted
    if (key < root.data) {
      root.leftChild = delete(root.leftChild, key);
    } else if (key > root.data) {
      root.rightChild = delete(root.rightChild, key);
    } else { // node found
      // case 1: no child
      if (root.leftChild == null && root.rightChild == null) {
        return null;
      }
      // case 2: one child
      else if (root.leftChild == null) {
        return root.rightChild;
      } else if (root.rightChild == null) {
        return root.leftChild;
      }
      // case 3: two children
      else {
        Node minNode = findMin(root.rightChild);
        root.data = minNode.data;
        root.rightChild = delete(root.rightChild, minNode.data);
      }
    }
    return root;
  }

  // findMin method (find the min node from two children)
  private Node findMin(Node root) {
    while (root.leftChild != null) {
      root = root.leftChild;
    }
    return root;
  }

  // find method
  private Node find(Node root, int key) {
    if (root == null) {
      return null;
    }
    if (key == root.data) {
      return root;
    } else if (key < root.data) {
      return find(root.leftChild, key);
    } else {
      return find(root.rightChild, key);
    }
  }

  // Inorder traversal
  private void traverseTree(Node root) {
    if (root != null) {
      traverseTree(root.leftChild);
      System.out.print(root.data + ", ");
      traverseTree(root.rightChild);
    }
  }
}
