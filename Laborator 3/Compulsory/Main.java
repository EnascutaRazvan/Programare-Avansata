public class Main {
    public static void main(String[] args) {

        Network networkRouting = new Network();


        Node n1 = new Router("Router 1");
        ((Router) n1).setAddress("3.1.2.0");
        networkRouting.addNode(n1);

        Node n2 = new Computer("Computer 1");
        ((Computer) n2).setAddress("1.0.1.0");
        ((Computer) n2).setStorageCapacity(125);
        networkRouting.addNode(n2);

        Node n3 = new Computer("Computer 2");
        ((Computer) n3).setAddress("5.0.1.0");
        ((Computer) n3).setStorageCapacity(20);
        networkRouting.addNode(n3);

        Node n4 = new Switch("Switch 2");
        networkRouting.addNode(n4);

        networkRouting.sortAllNodes();

        System.out.println(networkRouting);
    }
}
