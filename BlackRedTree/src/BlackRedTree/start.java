package BlackRedTree;

public class start {
    public static void main(String[] args){

        BST tree = new BST();
        tree.insert(10);
        tree.insert(4);
        tree.insert(5);
        tree.insert(12);
        tree.insert(53);
        tree.insert(6423);
        tree.insert(24);
        tree.insert(25);
        tree.insert(3);
        tree.insert(0);
        tree.insert(124);




        tree.printTree();
/*        for(int i = 1; i<=1000; i++){
            tree.insert(i);
            System.out.println(i);
        }*/
        tree.treeInfo();
    }
}
