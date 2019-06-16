package lesson6.HW;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Server extends JFrame {
    private static final int SERVER_PORT = 8189;
    private JTextField msgInputField;
    private JTextArea area;
    private DataOutputStream out;
    private DataInputStream in;
    private Socket socket;
    private final String TERMINATED_COMMAND = "/end";
    private static final String SERVER_ADR = "localhost";

    public static void main(String[] args) {
        new Server();
    }

    private Server() {
        openConnection();
    }

    private void openConnection() {
        prepareGUI();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            System.out.println("Сервер запущен, ожидаем подключения...");
            socket = serverSocket.accept();
            System.out.println("Клиент подключился");
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            new Thread(() -> {
                try {
                    while (socket.isConnected()) {
                        String strFromClient = in.readUTF();
                        if (strFromClient.equals(TERMINATED_COMMAND)) {
                            socket.close();
                            System.exit(0);
                            break;
                        }
                        area.append(strFromClient);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
            while (socket.isConnected()) {
                String str = reader.readLine();
                sendMessage();
                area.append("Консольное сообщение: " + str + "\n");
                out.writeUTF("Консольное сообщение от сервера: " + str + "\n");
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void prepareGUI() {
        setBounds(600, 300, 500, 500);
        setTitle("Сервер " + SERVER_ADR + ":" + SERVER_PORT);
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

    private void sendMessage() {
        if (!msgInputField.getText().trim().isEmpty()) {
            String str = currentTime() + " Сервер: " + msgInputField.getText() + "\n";
            if (msgInputField.getText().equalsIgnoreCase(TERMINATED_COMMAND)){
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

    private String currentTime() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//dd/MM/yyyy
        Date now = new Date();
        return sdfDate.format(now);
    }
}
