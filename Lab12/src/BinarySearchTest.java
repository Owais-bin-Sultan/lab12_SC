import static org.junit.Assert.*;
import org.junit.Test;
import java.util.List;

public class BinarySearchTest {

    @Test
    public void testBinarySearchRecursive() {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        assertEquals(3, BinarySearch.binarySearchRecursive(array, 4, 0, array.length - 1));
        assertEquals(-1, BinarySearch.binarySearchRecursive(array, 10, 0, array.length - 1));
    }

    @Test
    public void testBinarySearchRecursiveStrings() {
        String[] array = {"apple", "banana", "cherry"};
        assertEquals(1, BinarySearchStrings.binarySearchRecursive(array, "banana", 0, array.length - 1));
        assertEquals(-1, BinarySearchStrings.binarySearchRecursive(array, "date", 0, array.length - 1));
    }

    @Test
    public void testBinarySearchAllIndices() {
        int[] array = {1, 2, 3, 3, 3, 4};
        List<Integer> indices = BinarySearchAllIndices.binarySearchAllIndices(array, 3, 0, array.length - 1);
        assertEquals(List.of(2, 3, 4), indices);

        indices = BinarySearchAllIndices.binarySearchAllIndices(array, 5, 0, array.length - 1);
        assertTrue(indices.isEmpty());
    }

}