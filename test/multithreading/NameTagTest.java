package multithreading;

import org.junit.Assert;
import org.junit.Test;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NameTagTest {
    @Test
    public void test01() throws InterruptedException, ExecutionException {
        test(1);
    }

    @Test
    public void test02() throws InterruptedException, ExecutionException {
        test(2);
    }

    @Test
    public void test04() throws InterruptedException, ExecutionException {
        test(4);
    }

    @Test
    public void test08() throws InterruptedException, ExecutionException {
        test(8);
    }

    @Test
    public void test16() throws InterruptedException, ExecutionException {
        test(16);
    }

    @Test
    public void test32() throws InterruptedException, ExecutionException {
        test(32);
    }

    @Test
    public void test64() throws InterruptedException, ExecutionException {
        test(64);
    }

    @Test
    public void test128() throws InterruptedException, ExecutionException {
        test(128);
    }

    @Test
    public void test256() throws InterruptedException, ExecutionException {
        test(256);
    }

    @Test
    public void test512() throws InterruptedException, ExecutionException {
        test(512);
    }

    @Test
    public void test1024() throws InterruptedException, ExecutionException {
        test(1024);
    }

    private void test(final int threadCount) throws InterruptedException, ExecutionException {
        // arrange
        final NameTag nameTag = new NameTag();
        int padding = ((Integer) threadCount).toString().length();

        JspWriter out = new StringJspWriter();
        PageContext mockPageContext = mock(PageContext.class);
        when(mockPageContext.getOut()).thenReturn(out);

        nameTag.setPageContext(mockPageContext);

        ArrayList<Callable<String>> tasks = new ArrayList<Callable<String>>(threadCount);
        for(int i=0; i < threadCount; i++) {
            String id = "" + i;
            while(id.length() < padding) {
                id = "0" + id;
            }
            final String name = "user-" + id;
            tasks.add(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    nameTag.setName(name);
                    nameTag.doStartTag();
                    return name;
                }
            });
        }

        // act
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        List<Future<String>> futures = executorService.invokeAll(tasks);

        // assert
        ArrayList<String> actualResults = new ArrayList<String>(threadCount);
        for (Future<String> future : futures) {
            actualResults.add(future.get());
        }

        String jspOutput = out.toString();
        String[] scripts = jspOutput.split("\n");
        List<String> outputResults = new ArrayList<String>(threadCount);
        for(String script : scripts) {
            if(!script.isEmpty()) {
                outputResults.add(script);
            }
        }

        Assert.assertEquals(threadCount, actualResults.size());
        Assert.assertEquals(threadCount, outputResults.size());

        Collections.sort(actualResults);
        Collections.sort(outputResults);
        Assert.assertEquals(actualResults, outputResults);
    }

    private class StringJspWriter extends JspWriter {
        private final PrintStream out;
        private final ByteArrayOutputStream bytes;

        private StringJspWriter() {
            super(UNBOUNDED_BUFFER, false);
            bytes = new ByteArrayOutputStream();
            out = new PrintStream(bytes);
        }

        @Override
        public void newLine() throws IOException {
            out.println();
        }

        @Override
        public void print(boolean b) throws IOException {
            out.print(b);
        }

        @Override
        public void print(char c) throws IOException {
            out.print(c);
        }

        @Override
        public void print(int i) throws IOException {
            out.print(i);
        }

        @Override
        public void print(long l) throws IOException {
            out.print(l);
        }

        @Override
        public void print(float v) throws IOException {
            out.print(v);
        }

        @Override
        public void print(double v) throws IOException {
            out.print(v);
        }

        @Override
        public void print(char[] chars) throws IOException {
            out.print(chars);
        }

        @Override
        public void print(String s) throws IOException {
            out.print(s);
        }

        @Override
        public void print(Object o) throws IOException {
            out.print(o);
        }

        @Override
        public void println() throws IOException {
            out.println();
        }

        @Override
        public void println(boolean b) throws IOException {
            out.println(b);
        }

        @Override
        public void println(char c) throws IOException {
            out.println(c);
        }

        @Override
        public void println(int i) throws IOException {
            out.println(i);
        }

        @Override
        public void println(long l) throws IOException {
            out.println(l);
        }

        @Override
        public void println(float v) throws IOException {
            out.println(v);
        }

        @Override
        public void println(double v) throws IOException {
            out.println(v);
        }

        @Override
        public void println(char[] chars) throws IOException {
            out.println(chars);
        }

        @Override
        public void println(String s) throws IOException {
            out.println(s);
        }

        @Override
        public void println(Object o) throws IOException {
            out.println(o);
        }

        @Override
        public void clear() throws IOException {
        }

        @Override
        public void clearBuffer() throws IOException {
        }

        @Override
        public void write(char[] chars, int start, int end) throws IOException {
            for(int i = start; i < end; i++) {
                out.write(chars[i]);
            }
        }

        @Override
        public void flush() throws IOException {
            out.flush();
        }

        @Override
        public void close() throws IOException {
            out.close();
        }

        @Override
        public int getRemaining() {
            return 0;
        }

        @Override
        public String toString() {
            try {
                return bytes.toString("UTF-8");
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        }
    }
}
