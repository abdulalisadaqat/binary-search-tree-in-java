public class Demo {
  public static void main(String[] args) {
    BinaryTree tree = new BinaryTree();
    tree.insert(50);
    tree.insert(5);
    tree.insert(8);
    tree.insert(23);
    tree.traverseTree();
    tree.find(5);
    tree.find(1);
    tree.delete(8);
    tree.traverseTree();
  }
}
