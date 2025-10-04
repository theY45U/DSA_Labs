import dataStructures.Chain;
public class MyChain extends Chain {
        public Object[] toArray() {
            Object[] elementsArray = new Object[size()];
            for (int index = 0; index < size(); index++) {
                elementsArray[index] = get(index);
            }
            return elementsArray;
        }

        public void addRange(Object[] newElements) {
            if (newElements == null) {
                throw new IllegalArgumentException("Null array өгч болохгүй!");
            }
            for (Object singleElement : newElements) {
                add(size(), singleElement);
            }
        }

        public MyChain union(MyChain otherChain) {
            if (otherChain == null) {
                throw new IllegalArgumentException("Null chain өгч болохгүй!");
            }

            MyChain resultChain = new MyChain();

            for (int index = 0; index < this.size(); index++) {
                resultChain.add(index, this.get(index));
            }

            for (int index = 0; index < otherChain.size(); index++) {
                Object element = otherChain.get(index);
                if (!resultChain.contains(element)) {
                    resultChain.add(resultChain.size(), element);
                }
            }

            return resultChain;
        }

        public MyChain intersection(MyChain otherChain) {
            if (otherChain == null) {
                throw new IllegalArgumentException("Null chain өгч болохгүй!");
            }

            MyChain resultChain = new MyChain();

            for (int index = 0; index < this.size(); index++) {
                Object element = this.get(index);
                if (otherChain.contains(element) && !resultChain.contains(element)) {
                    resultChain.add(resultChain.size(), element);
                }
            }

            return resultChain;
        }

        private boolean contains(Object searchElement) {
            for (int index = 0; index < this.size(); index++) {
                if (this.get(index).equals(searchElement)) {
                    return true;
                }
            }
            return false;
        }

        public void printChain() {
            for (int index = 0; index < this.size(); index++) {
                System.out.print(this.get(index) + " -> ");
            }
            System.out.println("null");
        }
    }
