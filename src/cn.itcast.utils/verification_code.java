package cn.itcast.utils;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class verification_code extends HttpServlet {
    public static final int WIDTH = 115;
    public static final int HEIGHE = 25;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        test5(resp);
        return;
    }
    private void test5(HttpServletResponse resp) throws IOException {
        resp.setDateHeader("expries",-1);
        /*获取一个图片*/
        BufferedImage image = new BufferedImage(WIDTH,HEIGHE,BufferedImage.TYPE_INT_RGB);
        Graphics graphics= image.getGraphics();
        /*设置背景色*/
        serBackGround(graphics);
        /*设置边框*/
        serBorder(graphics);
        /*设置干扰线*/
        drawRandomLine(graphics);
        //写随机数
        random_number((Graphics2D)graphics);
        /*写给浏览器*/
        resp.setContentType("image/jpeg");
        ImageIO.write(image,"jpg",resp.getOutputStream());
    }

    private void random_number(Graphics2D graphics) {
        graphics.setColor(Color.RED);
        graphics.setFont(new Font("宋体",Font.BOLD,20));
        int x = 10;
        String verification_code = "";
        for (int i = 0;i<4;i++){
            int degree = new Random().nextInt(10);
            int  randomshu = new Random().nextInt(9);
            verification_code = verification_code+randomshu;
            graphics.rotate(degree*Math.PI/180,x,20);
            graphics.drawString(String.valueOf(randomshu),x,20);
            graphics.rotate(-degree*Math.PI/180,x,20);
            x=x+30;
        }
        ServletContext servletContext = this.getServletConfig().getServletContext();
        servletContext.setAttribute("verification_code",verification_code);
    }
    private void drawRandomLine(Graphics graphics) {
        graphics.setColor(Color.GREEN);
        for (int i =0;i<5;i++){
            int x1 = new Random().nextInt(WIDTH);
            int y1 = new Random().nextInt(HEIGHE);

            int x2 = new Random().nextInt(WIDTH);
            int y2 = new Random().nextInt(HEIGHE);
            graphics.drawLine(x1,y1,x2,y2);
        }
    }
    private void serBorder(Graphics graphics) {
        graphics.setColor(Color.BLUE);
        graphics.drawRect(1,1,WIDTH-2,HEIGHE-2);
    }
    private void serBackGround(Graphics graphics) {
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0,0,WIDTH,HEIGHE);
    }

}
