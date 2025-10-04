public class Main {
    public static void main(String[] args) {
        MyChain firstChain = new MyChain();
        MyChain secondChain = new MyChain();

        firstChain.add(0, "A");
        firstChain.add(1, "B");
        firstChain.add(2, "C");

        secondChain.add(0, "B");
        secondChain.add(1, "C");
        secondChain.add(2, "D");

        System.out.print("FirstChain: ");
        firstChain.printChain();

        System.out.print("SecondChain: ");
        secondChain.printChain();

        // toArray test
        Object[] firstArray = firstChain.toArray();
        System.out.print("FirstChain toArray: ");
        for (Object element : firstArray) {
            System.out.print(element + " ");
        }
        System.out.println();

        // union test
        MyChain unionChain = firstChain.union(secondChain);
        System.out.print("Union: ");
        unionChain.printChain();

        // intersection test
        MyChain intersectionChain = firstChain.intersection(secondChain);
        System.out.print("Intersection: ");
        intersectionChain.printChain();

        // addRange test
        firstChain.addRange(new Object[]{"X", "Y", "Z"});
        System.out.print("FirstChain after addRange: ");
        firstChain.printChain();
    }
}

