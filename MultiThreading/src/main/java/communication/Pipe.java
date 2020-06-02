package communication;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class Pipe {
    /**
     * 管道是基于“管道流”的通信方式。
     * JDK提供了PipedWriter、 PipedReader、 PipedOutputStream、 PipedInputStream。
     * 其中，前面两个是基于字符的，后面两个是基于字节流的。
     */

    /**
     * 我们通过线程的构造函数，传入了PipedWrite和PipedReader对象。可以简单分析一下这个示例代码的执行流程：
     *      1 线程ReaderThread开始执行，
     *      2 线程ReaderThread使用管道reader.read()进入”阻塞“，
     *      3 线程WriterThread开始执行，
     *      4 线程WriterThread用writer.write("test")往管道写入字符串，
     *      5 线程WriterThread使用writer.close()结束管道写入，并执行完毕，
     *      6 线程ReaderThread接受到管道输出的字符串并打印，
     *      7 线程ReaderThread执行完毕。
     *
     * 管道通信的应用场景：
     *      使用管道多半与I/O流相关。
     *      当我们一个线程需要与另一个线程发送一个信息（比如字符串）或者文件等等时，就需要使用管道通信了。
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        PipedWriter writer = new PipedWriter();
        PipedReader reader = new PipedReader();
        writer.connect(reader); // 这里注意一定要连接，才能通信

        new Thread(new ReaderThread(reader)).start();
        Thread.sleep(1000);
        new Thread(new WriterThread(writer)).start();
    }



    static class ReaderThread implements Runnable {
        private PipedReader reader;

        public ReaderThread(PipedReader reader) {
            this.reader = reader;
        }

        @Override
        public void run() {
            System.out.println("this is PipedReader");
            int receive = 0;
            try {
                while ((receive = reader.read()) != -1) {
                    System.out.print((char)receive);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static class WriterThread implements Runnable {

        private PipedWriter writer;

        public WriterThread(PipedWriter writer) {
            this.writer = writer;
        }

        @Override
        public void run() {
            System.out.println("this is WriterThread");
            int receive = 0;
            try {
                writer.write("test");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
