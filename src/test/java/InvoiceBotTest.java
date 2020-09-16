import org.junit.*;

import java.io.*;
import java.nio.file.*;

public class InvoiceBotTest {

    //Don't Change this File

    @Test
    public void test0() throws Exception {
        test("test0");
    }
    @Test
    public void test1() throws Exception {
        test("test1");
    }
    @Test
    public void test2() throws Exception {
        test("test2");
    }
    @Test
    public void test3() throws Exception {
        test("test3");
    }

    private void test(String test) throws IOException {
        String expected = Files.readString(Path.of("src/test/resources", test, "/result.txt"));
        StringBuilder actual = new StringBuilder();
        new InvoiceBot(new File("src/main/resources", test), line -> actual.append(line).append('\n')).parseData();
        Assert.assertEquals(expected.trim(), actual.toString().trim());
    }


}