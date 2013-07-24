package nondeterministic;

import java.io.*;
import java.util.ArrayList;

public class ObjectStore {
    private final File storageFile = new File("tmp/objectstore.db");
    private ArrayList<Object> objects = null;

    public int size() {
        return getObjects().size();
    }

    public void add(Serializable serializableObject) {
        getObjects().add(serializableObject);
        writeObjects();
    }

    public Object[] getAll() {
        return getObjects().toArray();
    }

    public void remove(Serializable serializableObject) {
        getObjects().remove(serializableObject);
        writeObjects();
    }

    public void removeAll() {
        getObjects().clear();
        writeObjects();
    }

    private ArrayList<Object> getObjects() {
        if(objects == null) {
            objects = readObjects();
        }
        return objects;
    }

    private ArrayList<Object> readObjects() {
        if(!storageFile.exists()) {
            return new ArrayList<Object>();
        }

        ObjectInputStream reader = null;
        try {
            reader = new ObjectInputStream(new FileInputStream(storageFile));
            return (ArrayList<Object>) reader.readObject();
        } catch(Exception e) {
            throw new RuntimeException("Could not read objects from ObjectStore!", e);
        } finally {
            try {
                reader.close();
            } catch (Exception e) {
                // no-op
            }
        }
    }

    private void writeObjects() {
        ObjectOutputStream writer = null;
        try {
            if(!storageFile.exists()) {
                storageFile.getParentFile().mkdirs();
            }
            writer = new ObjectOutputStream(new FileOutputStream(storageFile));
            writer.writeObject(objects);
        } catch (Exception e) {
            throw new RuntimeException("Could not write objects to ObjectStore!", e);
        } finally {
            try {
                writer.close();
            } catch (Exception e) {
                // no-op
            }
        }
    }
}
