import org.junit.Test;

import java.io.*;
import java.util.PriorityQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Liu
 * @date 2021/3/26 22:41
 */
public class ChooseTest {
    @Test
    public void test() {
        char s = '\u0639';
        System.out.println(s);
        Object o = 'f';
        System.out.println(o);
        String str = "hello, world\0";
        System.out.println(str);
        Double d = 100.2;
        Float f = 1.0f;
        LinkedBlockingQueue queue = new LinkedBlockingQueue();
        PriorityQueue queue1 = new PriorityQueue();

        try {
            System.out.println("ok");
        } finally {

        }
    }

    @Test
    public void testFile() throws IOException {
        FileOutputStream fos = new FileOutputStream("test.txt");
        DataOutputStream dos = new DataOutputStream(fos);
        dos.close();
        fos.close();
    }
}
