package BlackRedTree;

public class BST{

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";

    private Node root;
    private Node WARTOWNIK;

    BST(){
        WARTOWNIK = new Node();
        WARTOWNIK.setColor(0);
        WARTOWNIK.setLeft(null);
        WARTOWNIK.setRight(null);
        root = WARTOWNIK;
    }


    public void insert(int key) {
        Node node = new Node(null,WARTOWNIK,WARTOWNIK,key,1);
        Node y = null;
        Node x = this.root;

        while (x != WARTOWNIK) {             //szukamy nulla i podłączamy tam nasz element
            y = x;
            if (node.getValue() < x.getValue()) {
                x = x.getLeft();
            } else {
                x = x.getRight();
            }
        }

        node.setParent(y);
        if (y == null) {
            root = node;
        } else if (node.getValue() < y.getValue()) { //jak pierwszy element to jest korzeniem, jak nie to podłączamy go do ojca jako left lub right
            y.setLeft(node);
        } else {
            y.setRight(node);
        }

        // przygotowanie do naprawy, korzen na czarno i nie naprawiamy
        if (node.getParent() == null){
            node.setColor(0);//korzen=czarny
            return;
        }
        // tu to samo
        if (node.getParent().getParent() == null) {
            return;
        }

        fixInsert(node);
    }

    private void fixInsert(Node k){
        Node u;
        while (k.getParent().getColor() == 1) { //sprawdzenie czy sa dwa czerwone w pionie

            if (k.getParent() == k.getParent().getParent().getRight()) {  // sprawdzenie z jakiej strony sie znajdujemy, czy prawe czy lewe dziecko
                u = k.getParent().getParent().getLeft(); // brat ojca
                if (u.getColor() == 1) {//przypadek 1, braj ojca czerwony
                    u.setColor(0);
                    k.getParent().setColor(0);
                    k.getParent().getParent().setColor(1);
                    k = k.getParent().getParent();
                } else {//przypadek 2, braj ojca czarny
                    if (k == k.getParent().getLeft()) {//sprawdzamy czy jest lewym czy prawym dzieckiem
                        k = k.getParent();
                        rightRotate(k);
                    }//przyp3
                    k.getParent().setColor(0);
                    k.getParent().getParent().setColor(1);
                    leftRotate(k.getParent().getParent());
                }
            } else {// to samo ale symetrycznie
                u = k.getParent().getParent().getRight();
                if (u.getColor() == 1) {
                    u.setColor(0);
                    k.getParent().setColor(0);
                    k.getParent().getParent().setColor(1);
                    k = k.getParent().getParent();
                } else {
                    if (k == k.getParent().getRight()) {
                        k = k.getParent();
                        leftRotate(k);
                    }
                    k.getParent().setColor(0);
                    k.getParent().getParent().setColor(1);
                    rightRotate(k.getParent().getParent());
                }
            }
            // korzen to koniec naprawy
            if (k == root)break;
        }
        root.setColor(0);// korzen na czarno
    }

    public void leftRotate(Node x) {
        Node y = x.getRight();
        x.setRight(y.getLeft());
        if (y.getLeft() != WARTOWNIK) {
            y.getLeft().setParent(x);
        }
        y.setParent(x.getParent());
        if (x.getParent() == null) {
            this.root = y;
        } else if (x == x.getParent().getLeft()) {
            x.getParent().setLeft(y);
        } else {
            x.getParent().setRight(y);
        }
        y.setLeft(x);
        x.setParent(y);
    }

    public void rightRotate(Node x) {
        Node y = x.getLeft();
        x.setLeft(y.getRight());
        if (y.getRight() != WARTOWNIK) {
            y.getRight().setParent(x);
        }
        y.setParent(x.getParent());
        if (x.getParent() == null) {
            this.root = y;
        } else if (x == x.getParent().getRight()) {
            x.getParent().setRight(y);
        } else {
            x.getParent().setLeft(y);
        }
        y.setRight(x);
        x.setParent(y);
    }


    private void printTreeRec(Node node, String indent, boolean right) {
        if (node != null) {
            System.out.print(indent);
            if (right){
                if(node == root && node.getColor()==0)
                {
                    System.out.println(ANSI_BLACK + "KORZEN " + node.getValue() + ANSI_RESET);
                }
                else if(node.getColor()==1)
                {
                    System.out.println(ANSI_RED + "R---- " + node.getValue() + ANSI_RESET);
                }
                else if(node==WARTOWNIK){
                    System.out.println(ANSI_BLACK + "R---- W" + ANSI_RESET);
                }
                else{
                    System.out.println(ANSI_BLACK + "R---- " + node.getValue() + ANSI_RESET);
                }
                indent += "     ";
            }
            else {
                if(node.getColor()==1)
                {
                    System.out.println(ANSI_RED + "L---- " + node.getValue() + ANSI_RESET);
                }
                else if(node==WARTOWNIK){
                    System.out.println(ANSI_BLACK + "L---- W" + ANSI_RESET);
                }
                else{
                    System.out.println(ANSI_BLACK + "L---- " + node.getValue() + ANSI_RESET);
                }
                indent += "|    ";
            }
            printTreeRec(node.getLeft(), indent, false);
            printTreeRec(node.getRight(), indent, true);
        }
    }

    public void printTree() {
        printTreeRec(root, "", true);
        System.out.print("\n");
    }

    private int maxDepth(Node node)
    {
        if (node==null)
            return 0;

        int leftDepth = minDepth(node.getLeft());
        int rightDepth = minDepth(node.getRight());

        if (leftDepth > rightDepth)
            return (leftDepth + 1);
        else
            return (rightDepth + 1);
    }

    private int minDepth(Node node)
    {
        if (node==null)
            return 0;

        int leftDepth = minDepth(node.getLeft());
        int rightDepth = minDepth(node.getRight());

        if (leftDepth < rightDepth)
            return (leftDepth + 1);
        else
            return (rightDepth + 1);
    }

    private int redCount(Node node)
    {
        int red = 0;

        if (node == null)
            return 0;

        red += redCount(node.getLeft());
        red += redCount(node.getRight());

        red += node.getColor();

        return red;
    }

    public void treeInfo(){
        System.out.println("Max glebokosc: " + maxDepth(root));
        System.out.println("Min glebokosc: " + minDepth(root));
        System.out.println("Ilosc czerwonych: " + redCount(root));
    }

}
