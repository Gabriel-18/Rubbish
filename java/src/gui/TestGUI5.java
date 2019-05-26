package gui;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.UnsupportedEncodingException;

public class TestGUI5 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        JFrame f = new JFrame("��������");

        f.setSize(400, 300);
        f.setLocation(580, 200);
        f.setLayout(null);

        final JLabel l = new JLabel();

        ImageIcon i = new ImageIcon("D:\\code\\Java\\CS-Notes\\java\\src\\gui\\shana.png");
        l.setIcon(i);
        l.setBounds(50, 50, i.getIconWidth(), i.getIconHeight());

        f.addKeyListener(new KeyListener() {
            // һ���������϶���
            @Override
            public void keyTyped(KeyEvent e) {

            }

            // ��������
            @Override
            public void keyPressed(KeyEvent e) {

            }

            // ��������
            @Override
            public void keyReleased(KeyEvent e) {
                // ����
                int step = 10;
                // 38��������
                if (e.getKeyCode() == 38) {
                    l.setLocation(l.getX(), l.getY() - 10);
                }
                // 40��������
                if (e.getKeyCode() == 40) {
                    l.setLocation(l.getX(), l.getY() + 10);
                }
                // 37��������
                if (e.getKeyCode() == 37) {
                    l.setLocation(l.getX() - step, l.getY() + 10);
                }

                // 39��������
                if (e.getKeyCode() == 39) {
                    l.setLocation(l.getX() + 10, l.getY() );
                }

            }
        });



        f.add(l);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
