package lesson6.HW;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Client extends JFrame {
    private final String SERVER_ADR = "localhost";
    private static final int SERVER_PORT = 8189;
    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;
    private final String TERMINATED_COMMAND = "/end";

    private JTextField msgInputField;
    private JTextArea area;

    private Client() {
        try {
            openConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        prepareGUI();
    }

    private void openConnection() throws IOException {
        socket = new Socket(SERVER_ADR, SERVER_PORT);
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        new Thread(() -> {
            try {
                while (true) {
                    String strFromServer = in.readUTF();
                    if (strFromServer.equals(TERMINATED_COMMAND)) {
                        socket.close();
                        System.exit(0);
//                        setVisible(false);
                        break;
                    }
                    area.append(strFromServer);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void closeConnection() {
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendMessage() {
        if (!msgInputField.getText().trim().isEmpty()) {
            String str = currentTime() + " Клиент: " + msgInputField.getText() + "\n";
            if (msgInputField.getText().equalsIgnoreCase(TERMINATED_COMMAND)) {
                try {
                    out.writeUTF(msgInputField.getText());
                    closeConnection();
                    System.exit(0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                area.append(str);
                out.writeUTF(str);
                msgInputField.setText("");
                msgInputField.grabFocus();
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Ошибка отправки сообщения");
            }
        }

    }

    private void prepareGUI() {
        setBounds(1200, 300, 500, 500);
        setTitle("Клиент " + SERVER_ADR + ":" + SERVER_PORT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        area = new JTextArea();
        area.setEditable(false);
        area.setLineWrap(true);
        add(new JScrollPane(area), BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        JButton btnSendMsg = new JButton("Отправить");
        bottomPanel.add(btnSendMsg, BorderLayout.EAST);
        msgInputField = new JTextField();
        add(bottomPanel, BorderLayout.SOUTH);
        bottomPanel.add(msgInputField, BorderLayout.CENTER);
        btnSendMsg.addActionListener(e -> sendMessage());
        msgInputField.addActionListener(e -> sendMessage());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                try {
                    out.writeUTF(TERMINATED_COMMAND);
                    closeConnection();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        setVisible(true);
    }

    private String currentTime() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//dd/MM/yyyy
        Date now = new Date();
        return sdfDate.format(now);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Client::new);
    }

}
