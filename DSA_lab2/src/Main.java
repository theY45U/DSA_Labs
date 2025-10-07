import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        MyChain firstChain = new MyChain();
        MyChain secondChain = new MyChain();

        System.out.print("Эхний жагсаалтад хэдэн элемент оруулах вэ: ");
        int firstCount = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < firstCount; i++) {
            System.out.print((i + 1) + "-р элемент: ");
            Object element = scanner.nextLine();
            firstChain.add(firstChain.size(), element);
        }

        System.out.print("\nХоёр дахь жагсаалтад хэдэн элемент оруулах вэ: ");
        int secondCount = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < secondCount; i++) {
            System.out.print((i + 1) + "-р элемент: ");
            Object element = scanner.nextLine();
            secondChain.add(secondChain.size(), element);
        }

        System.out.println("\nЭхний жагсаалт:");
        firstChain.display();

        System.out.println("Хоёр дахь жагсаалт:");
        secondChain.display();

        MyChain unionResult = firstChain.union(secondChain);
        MyChain intersectionResult = firstChain.intersection(secondChain);

        System.out.println("\nUnion :");
        unionResult.display();

        System.out.println("Intersection :");
        intersectionResult.display();
    }
}
