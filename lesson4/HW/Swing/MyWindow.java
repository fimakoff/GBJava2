package lesson4.HW.Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

class MyWindow extends JFrame {
    private static final String ICON_ADRESS = "img/icon.png";
    private static final String APP_NAME = "Chat window on swing";
    private static final String INPUT_MSG = "Введите сообщение";
    private static final String SEND = "Отправить";
    private static final String CLEAR = "Очистить";
    private static String TXT_FIELD_GET_TEXT;

    MyWindow(){
        Image icon = new ImageIcon(ICON_ADRESS).getImage();
        JFrame frame = new JFrame(APP_NAME);
        frame.setIconImage(icon);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(300, 300, 400, 400);
        JPanel southPanel = new JPanel();
        JButton clear = new JButton(CLEAR);
        JButton sendMsg = new JButton(SEND);
        JTextField txtField = new JTextField(INPUT_MSG);
        southPanel.add(txtField);
        southPanel.add(sendMsg);
        southPanel.add(clear);

        JTextArea txtArea = new JTextArea();
        txtArea.setLineWrap(true);
        txtArea.setWrapStyleWord(true);

        frame.add(txtArea);
        frame.add(southPanel, BorderLayout.SOUTH);



        frame.setVisible(true);

        txtField.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent e) {
                txtField.setText(null);
            }
            @Override
            public void focusLost(FocusEvent e) {
                TXT_FIELD_GET_TEXT = txtField.getText();
                txtField.setText(INPUT_MSG);
            }

        });
        sendMsg.addActionListener(e -> {
            txtArea.append(TXT_FIELD_GET_TEXT+"\n");
            TXT_FIELD_GET_TEXT = null;
        });
        clear.addActionListener(e -> txtArea.setText(""));

    }
}
