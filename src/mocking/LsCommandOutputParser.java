package mocking;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created with IntelliJ IDEA.
 * User: ccasey
 * Date: 7/30/13
 * Time: 7:09 AM
 * To change this template use File | Settings | File Templates.
 */
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
