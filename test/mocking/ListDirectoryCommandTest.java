package mocking;

import org.junit.Test;

import java.io.File;
import java.util.Collection;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ListDirectoryCommandTest {
    @Test
    public void should_get_a_directory_listing() throws Exception {
        CommandExecutor mockCommandExecutor = mock(CommandExecutor.class);
        OutputParser<Collection<File>> mockOutputParser = (OutputParser<Collection<File>>) mock(OutputParser.class);
        ListDirectoryCommand listDirectoryCommand = new ListDirectoryCommand(mockCommandExecutor, mockOutputParser);

        when(mockCommandExecutor.exec()).thenReturn("test");

        listDirectoryCommand.execute();

        verify(mockCommandExecutor).exec();
        verify(mockOutputParser).parse("test");
    }
}
