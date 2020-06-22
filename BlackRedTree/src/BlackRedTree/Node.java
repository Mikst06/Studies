package BlackRedTree;

public class Node {
    private int value;
    private Node parent;
    private Node left;
    private Node right;
    private int color;

    Node(){}

    Node(Node parent, Node left, Node right, int value, int color){
        this.parent = parent;
        this.left = left;
        this.right = right;
        this.value = value;
        this.color = color;
    }

    public int getValue(){ return value; }

    public Node getLeft(){ return left; }

    public Node getRight(){
        return right;
    }

    public Node getParent(){return parent;}

    public int getColor(){ return color;}

    public void setValue(int value){
        this.value = value;
    }

    public void setLeft(Node left){
        this.left = left;
    }

    public void setRight(Node right){
        this.right = right;
    }

    public void setParent(Node parent){ this.parent = parent;}

    public void setColor(int color){ this.color = color;}


}

