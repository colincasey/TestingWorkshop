package mocking;

import org.junit.Test;

import java.io.File;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.hasItems;

public class LsCommandOutputParserTest {
    @Test
    public void should_return_empty_list_if_no_output() throws Exception {
        LsCommandOutputParser parser = new LsCommandOutputParser();
        Collection<File> result = parser.parse("");
        assertThat(result.size(), equalTo(0));
    }

    @Test
    public void should_be_able_to_parse_generic_ls_command_output() throws Exception {
        String output = "README.md\n" +
                "TestingWorkshop.iml\n" +
                "someOtherFile.txt\n" +
                "lib\n";
        LsCommandOutputParser parser = new LsCommandOutputParser();

        Collection<File> result = parser.parse(output);

        assertThat(result.size(), equalTo(output.split("\n").length));
        assertThat(result, hasItems(file("README.md"), file("TestingWorkshop.iml"), file("someOtherFile.txt"), file("lib")));
    }

    private File file(String filename) {
         return new File(filename);
    }
}
