package mocking;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class LsCommandOutputParser extends OutputParser<Collection<File>> {
    @Override
    public Collection<File> parse(String output) {
        if(output.isEmpty()) {
            return Collections.EMPTY_LIST;
        }

        String[] filenames = output.split("\n");
        ArrayList<File> files = new ArrayList<File>(filenames.length);
        for(String filename : filenames) {
            files.add(new File(filename));
        }
        return files;
    }
}
