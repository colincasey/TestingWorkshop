package mocking;

import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CommandExecutorTest {
    private Runtime mockRuntime;

    @Before
    public void setUp() throws Exception {
        mockRuntime = mock(Runtime.class);
    }

    @Test
    public void should_be_able_to_execute_a_command() throws Exception {
        CommandExecutor commandExecutor = new CommandExecutor(mockRuntime, "testCmd", "arg1", "arg2");
        Process mockProcess = mock(Process.class);

        when(mockRuntime.exec("testCmd", new String[] { "arg1", "arg2" })).thenReturn(mockProcess);
        when(mockProcess.waitFor()).thenReturn(0);
        when(mockProcess.getInputStream()).thenReturn(input("line1\nline2\nline3"));

        String output = commandExecutor.exec();

        assertThat(output, is("line1\nline2\nline3\n"));
        verify(mockRuntime).exec("testCmd", new String[] { "arg1", "arg2" });
    }

    @Test(expected = Exception.class)
    public void should_raise_error_if_command_does_not_exit_successfully() throws Exception {
        CommandExecutor commandExecutor = new CommandExecutor(mockRuntime, "testCmd", "arg1", "arg2");
        Process mockProcess = mock(Process.class);

        when(mockRuntime.exec("testCmd", new String[] { "arg1", "arg2" })).thenReturn(mockProcess);
        when(mockProcess.waitFor()).thenReturn(1);
        when(mockProcess.getInputStream()).thenReturn(input("line1\nline2\nline3"));

        commandExecutor.exec();
    }

    private InputStream input(String input) throws IOException {
        return new ByteArrayInputStream(input.getBytes());
    }
}
