package ck.naver;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DrawImage {
    public static void main(String[] args) throws Exception {
//        File file = new File("c:/Temp/yolo-test.jpg");
//        BufferedImage img = ImageIO.read(file);
//        JLabel label = new JLabel(new ImageIcon(img));
//        JFrame f = new JFrame("이미지 그리기");
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        f.getContentPane().add(label);
//        f.pack();
//        f.setLocation(2000, 200);
//        f.setVisible(true);
        
        new GraphicsDrawImageEx1();
    }
}

class GraphicsDrawImageEx1 extends JFrame{
    GraphicsDrawImageEx1(){
        this.setTitle("drawImage 사용 예제1");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyPanel panel = new MyPanel();
        this.add(panel, BorderLayout.CENTER);
        this.pack();
//        this.setLocationRelativeTo(null);
        this.setLocation(2000, 200);
        this.setSize(800, 540);
        this.setVisible(true);
    }
    class MyPanel extends JPanel{
        ImageIcon icon = new ImageIcon("c:/Temp/yolo-test.jpg");
        Image img = icon.getImage();
        int width = img.getWidth(getFocusOwner());
        int height = img.getHeight(getFocusOwner());
                
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(img, 0, 0, this);
            int y = (int) (0.429077 * width);
            int x = (int) (0.0936808 * height);
            int h = (int) ((0.999302-0.429077) * width);
            int w = (int) ((0.281285-0.0936808) * height);
            g.setColor(Color.RED);
            g.drawRect(x, y, w, h);
        }
    }
}