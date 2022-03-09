import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Network {
    private List<Node> nodes = new ArrayList<>();

    public List<Node> getNodes() {
        return nodes;
    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    public void sortAllNodes() {
        Collections.sort(this.nodes);
    }

    @Override
    public String toString() {
        return "Network{" + "nodes=" + nodes + '}';
    }
}