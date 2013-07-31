package mocking;

import java.io.File;
import java.util.Collection;
import java.util.Collections;

public class DirCommandOutputParser extends OutputParser<Collection<File>> {
    @Override
    public Collection<File> parse(String output) {
        if(output.isEmpty()) {
            return Collections.EMPTY_LIST;
        }

        return Collections.EMPTY_LIST;
    }
}
