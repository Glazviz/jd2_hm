package it.academy;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SimpleCountServletSecond extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String path = "D:\\jd2_hm\\simplecountservletsecond\\src\\main\\resources\\counter.txt";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String line;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            line = bufferedReader.readLine();
        }
        int count = 0;
        count = Integer.parseInt(line);
        count++;

        resp.setContentType("image/jpeg");

        BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        graphics.setFont(new Font("Arial", Font.ITALIC, 25));
        graphics.setColor(Color.red);
        graphics.drawString(String.valueOf(count), 100, 140);

        ServletOutputStream out = resp.getOutputStream();
        ImageIO.write(image, "jpeg", out);
        try (final FileWriter writer = new FileWriter(path, false)) {
            final String str = Integer.toString(count);
            writer.write(str);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
