package mocking;

import java.io.File;
import java.util.Collection;
import java.util.Collections;

/**
 * Created with IntelliJ IDEA.
 * User: ccasey
 * Date: 7/30/13
 * Time: 7:09 AM
 * To change this template use File | Settings | File Templates.
 */
public class DirCommandOutputParser extends OutputParser<Collection<File>> {
    @Override
    public Collection<File> parse(String output) {
        if(output.isEmpty()) {
            return Collections.EMPTY_LIST;
        }

        return Collections.EMPTY_LIST;
    }
}
