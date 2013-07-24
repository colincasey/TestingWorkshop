package nondeterministic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ObjectStoreTest {
    @Test
    public void testCount() throws Exception {
        ObjectStore objectStore = new ObjectStore();
        assertEquals(0, objectStore.size());
    }

    @Test
    public void testAddObject() throws Exception {
        // arrange
        ObjectStore objectStore = new ObjectStore();
        String testObject = "my test object";

        // act
        objectStore.add(testObject);

        // assert
        assertEquals(1, objectStore.size());
        assertEquals(testObject, objectStore.getAll()[0]);
    }
}
