package nondeterministic;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class ObjectStoreTest {
    private File tmpFile;
    private ObjectStore objectStore;

    @Before
    public void setUp() throws Exception {
        tmpFile = File.createTempFile("objectstore", ".db", new File("tmp"));
        objectStore = new ObjectStore(tmpFile);
    }

    @After
    public void tearDown() throws Exception {
        if(tmpFile.exists()) {
            tmpFile.delete();
        }
    }

    @Test
    public void testCount() throws Exception {
        assertEquals(0, objectStore.size());
    }

    @Test
    public void testAddObject() throws Exception {
        // arrange
        String testObject = "my test object";

        // act
        objectStore.add(testObject);

        // assert
        assertEquals(1, objectStore.size());
        assertEquals(testObject, objectStore.getAll()[0]);
    }
}
