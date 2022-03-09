public abstract class Node implements Comparable<Node> {
    private String name;

    public Node(String name) {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Node other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return "Node{" + "name='" + name + '\'' + '}' + '\n';
    }

}
