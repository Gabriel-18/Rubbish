package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;

public class TestGUI {
    public static void main(String[] args) throws UnsupportedEncodingException {
        JFrame f = new JFrame("��������");

        f.setSize(400, 300);
        f.setLocation(580, 200);
        f.setLayout(null);

        final JLabel l = new JLabel();

        ImageIcon i = new ImageIcon("D:\\code\\Java\\CS-Notes\\java\\src\\gui\\shana.png");
        l.setIcon(i);
        l.setBounds(50, 50, i.getIconWidth(), i.getIconHeight());

        JButton b = new JButton("����ͼƬ");
        b.setBounds(100, 200, 100, 30);

        // ����ť ���� ����
        b.addActionListener(new ActionListener() {
            // �����ťʱ, �ͻᴥ��ActionEvent�¼�
            @Override
            public void actionPerformed(ActionEvent e) {
                l.setVisible(false);
            }
        });
        f.add(l);
        f.add(b);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
