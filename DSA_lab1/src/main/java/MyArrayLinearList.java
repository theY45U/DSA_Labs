import java.util.InputMismatchException;
import java.util.Scanner;

public class MyArrayLinearList {
    private int[] elements;
    private int size;

    public MyArrayLinearList(int capacity) {
        elements = new int[capacity];
        size = 0;
    }

    public void add(int value) {
        if (size == elements.length) {
            throw new RuntimeException("Жагсаалт дүүрсэн байна!");
        }
        elements[size++] = value;
        printList();
    }

    public int size() {
        return size;
    }

    public void printList() {
        if (size == 0) {
            System.out.println("Жагсаалт хоосон байна.");
            return;
        }
        System.out.print("Жагсаалт: ");
        for (int i = 0; i < size; i++) {
            System.out.print(elements[i] + " ");
        }
        System.out.println();
    }

    public int max() {
        if (size == 0) throw new RuntimeException("Жагсаалт хоосон!");
        int m = elements[0];
        for (int i = 1; i < size; i++) {
            if (elements[i] > m) {
                m = elements[i];
            }
        }
        printList();
        return m;
    }

    public int min() {
        if (size == 0) throw new RuntimeException("Жагсаалт хоосон!");
        int m = elements[0];
        for (int i = 1; i < size; i++) {
            if (elements[i] < m) {
                m = elements[i];
            }
        }
        printList();
        return m;
    }

    public int sum() {
        int s = 0;
        for (int i = 0; i < size; i++) {
            s += elements[i];
        }
        printList();
        return s;
    }

    public double average() {
        if (size == 0) throw new RuntimeException("Жагсаалт хоосон!");
        printList();
        return (double) sum() / size;
    }

    public void removeOdd() {
        int newSize = 0;
        for (int i = 0; i < size; i++) {
            if (elements[i] % 2 == 0) {
                elements[newSize++] = elements[i];
            }
        }
        size = newSize;
        System.out.println("Сондгой тоог устгалаа.");
        printList();
    }

    public void sort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (elements[i] > elements[j]) {
                    int temp = elements[i];
                    elements[i] = elements[j];
                    elements[j] = temp;
                }
            }
        }
        printList();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyArrayLinearList list = new MyArrayLinearList(100);

        while (true) {
            try {
                System.out.println("\n--- Цэс ---");
                System.out.println("1. Элемент нэмэх");
                System.out.println("2. Жагсаалтыг хэвлэх");
                System.out.println("3. Хамгийн их утга");
                System.out.println("4. Хамгийн бага утга");
                System.out.println("5. Нийлбэр");
                System.out.println("6. Дундаж");
                System.out.println("7. Сондгойг устгах");
                System.out.println("8. Эрэмбэлэх");
                System.out.println("9. Гарах");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Элемент оруул: ");
                        int val = sc.nextInt();
                        list.add(val);
                        break;
                    case 2:
                        list.printList();
                        break;
                    case 3:
                        System.out.println("Max: " + list.max());
                        break;
                    case 4:
                        System.out.println("Min: " + list.min());
                        break;
                    case 5:
                        System.out.println("Sum: " + list.sum());
                        break;
                    case 6:
                        System.out.println("Average: " + list.average());
                        break;
                    case 7:
                        list.removeOdd();
                        break;
                    case 8:
                        list.sort();
                        break;
                    case 9:
                        System.out.println("Програм дууслаа.");
                        return;
                    default:
                        System.out.println("Буруу сонголт!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Тоон утга оруулна уу!");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Алдаа: " + e.getMessage());
            }
        }
    }
}
