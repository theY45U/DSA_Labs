import dataStructures.Chain;

public class MyChain extends Chain {

    public Object[] toArray() {
        int listSize = size();
        Object[] array = new Object[listSize];
        for (int i = 0; i < listSize; i++) {
            array[i] = get(i);
        }
        return array;
    }

    public void addRange(Object[] elements) {
        if (elements == null || elements.length == 0) {
            System.out.println("Нэмэх элементүүд байхгүй байна.");
            return;
        }

        for (Object element : elements) {
            add(size(), element);
        }
    }

    public MyChain union(MyChain otherChain) {
        MyChain result = new MyChain();

        for (int i = 0; i < this.size(); i++) {
            result.add(result.size(), this.get(i));
        }

        for (int i = 0; i < otherChain.size(); i++) {
            result.add(result.size(), otherChain.get(i));
        }

        return result;
    }

    public MyChain intersection(MyChain otherChain) {
        MyChain result = new MyChain();

        for (int i = 0; i < this.size(); i++) {
            Object element = this.get(i);
            if (contains(otherChain, element)) {
                result.add(result.size(), element);
            }
        }

        return result;
    }

    private boolean contains(MyChain chain, Object element) {
        for (int i = 0; i < chain.size(); i++) {
            if (chain.get(i).equals(element)) {
                return true;
            }
        }
        return false;
    }

    public void display() {
        if (size() == 0) {
            System.out.println("Жагсаалт хоосон байна.");
            return;
        }
        for (int i = 0; i < size(); i++) {
            System.out.print(get(i) + " ");
        }
        System.out.println();
    }
}
