package it.academy;

import java.io.*;
import java.util.Objects;

public class StartServlet {
    private static final long serialVersionUID = 1L;

    public StartServlet() {
    }

    private int count;
    private static final String path = "D:\\jd2_hm\\cookie\\src\\main\\resources\\counter.txt";

    public void write() throws IOException {

        final String line;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            line = bufferedReader.readLine();
        }

        count = Integer.parseInt(line);
        count++;

        try (final FileWriter writer = new FileWriter(path, false)) {
            final String str = Integer.toString(count);
            writer.write(str);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    public void clean() {
        try (final FileWriter writer = new FileWriter(path, false)) {
            writer.write("0");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "MyWriter{" +
                "count=" + count +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StartServlet startServlet = (StartServlet) o;
        return count == startServlet.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }
}





