import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MyChainTest {

    @Test
    public void testToArray() {
        MyChain chain = new MyChain();
        chain.add(0, "A");
        chain.add(1, "B");
        chain.add(2, "C");

        Object[] array = chain.toArray();

        assertEquals(3, array.length, "Жагсаалт 3 элементтэй байх ёстой");
        assertEquals("A", array[0]);
        assertEquals("B", array[1]);
        assertEquals("C", array[2]);
    }

    @Test
    public void testAddRange() {
        MyChain chain = new MyChain();
        Object[] elements = {"X", "Y", "Z"};
        chain.addRange(elements);

        assertEquals(3, chain.size(), "addRange дараа 3 элемент нэмэгдсэн байх ёстой");
        assertEquals("Y", chain.get(1));
    }

    @Test
    public void testUnion() {
        MyChain chain1 = new MyChain();
        chain1.addRange(new Object[]{"A", "B", "C"});

        MyChain chain2 = new MyChain();
        chain2.addRange(new Object[]{"C", "D"});

        MyChain unionResult = chain1.union(chain2);
        Object[] resultArray = unionResult.toArray();

        assertEquals(5, resultArray.length, "Union 5 элементтэй байх ёстой (A,B,C,D)");
        assertEquals("A", resultArray[0]);
        assertEquals("D", resultArray[4]);
    }

    @Test
    public void testIntersection() {
        MyChain chain1 = new MyChain();
        chain1.addRange(new Object[]{"A", "B", "C"});

        MyChain chain2 = new MyChain();
        chain2.addRange(new Object[]{"B", "C", "D"});

        MyChain intersectionResult = chain1.intersection(chain2);
        Object[] resultArray = intersectionResult.toArray();

        assertEquals(2, resultArray.length, "Огтлолцол 2 элементтэй байх ёстой (B,C)");
        assertEquals("B", resultArray[0]);
        assertEquals("C", resultArray[1]);
    }

    @Test
    public void testEmptyUnionIntersection() {
        MyChain emptyChain = new MyChain();
        MyChain chain = new MyChain();
        chain.addRange(new Object[]{"A", "B"});

        MyChain union = chain.union(emptyChain);
        MyChain intersection = chain.intersection(emptyChain);

        assertEquals(2, union.size(), "Хоосон жагсаалттай нэгдэл өөрчлөгдөхгүй");
        assertEquals(0, intersection.size(), "Хоосон жагсаалттай огтлолцол 0 байх ёстой");
    }
}
