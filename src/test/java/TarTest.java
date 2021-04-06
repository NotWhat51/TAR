import org.junit.Test;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;


public class TarTest {

    public static String readFile(String file) {
        try {
            FileReader nnn = new FileReader(file);
            BufferedReader reader = new BufferedReader(nnn);
            String line;
            StringBuilder stringBuilder = new StringBuilder();
            String ls = System.getProperty("line.separator");
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            return stringBuilder.toString();
        } catch (Exception e) {
            return null;
        }
    }

    @Test
    public void test1() {
        String[] args = {"input\\input1.txt", "input\\input2.txt", "-out", "output\\output12.txt"};
        Tar.main(args);
        assertEquals(readFile("input\\input12.txt"), readFile("output\\output12.txt"));
    }

    @Test
    public void test2() {
        String[] args = {"input\\input1.txt", "input\\input2.txt", "input\\input3.txt", "-out", "output\\output123.txt"};
        Tar.main(args);
        assertEquals(readFile("input\\input123.txt"), readFile("output\\output123.txt"));
    }

    @Test
    public void test3() {
        String[] args = {"-u", "input\\input12.txt"};
        Tar.main(args);
        assertEquals(readFile("output1.txt"), readFile("output\\output1.txt"));
        assertEquals(readFile("output2.txt"), readFile("output\\output2.txt"));
    }

    @Test
    public void test4() {
        String[] args = {"-u", "input\\input123.txt"};
        Tar.main(args);
        assertEquals(readFile("output1.txt"), readFile("output\\output1.txt"));
        assertEquals(readFile("output2.txt"), readFile("output\\output2.txt"));
        assertEquals(readFile("output3.txt"), readFile("output\\output3.txt"));
    }
}
