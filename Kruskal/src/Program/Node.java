package Program;

public class Node {
    private Node parent;
    private int rank;
    private int key;

    Node()
    {

    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Node getParent()
    {
        return parent;
    }

    public int getRank() {
        return rank;
    }

    public int getKey() {
        return key;
    }
}
