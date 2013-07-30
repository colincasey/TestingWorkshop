package mocking;

import java.io.File;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: ccasey
 * Date: 7/30/13
 * Time: 6:40 AM
 * To change this template use File | Settings | File Templates.
 */
public abstract class OutputParser<T> {
    public abstract T parse(String output);
}
