/**
 * @author Jonathan Hosler
 */
 import java.awt.*;
 import java.awt.event.*;
 import javax.swing.*;
 import javax.swing.UIManager.*;

public class GUI extends JFrame implements ActionListener{

    private JButton sendButton;
    private JButton leaveButton;
    private JButton exitButton;
    private JLabel usernameLabel;
    private JLabel chatMsgLabel;
    private JLabel chatIPLabel;
    private JLabel portLabel;
    private JScrollPane chatroomScrollPane;
    private JTextArea chatroomArea;
    private JTextField usernameField;
    private JTextField chatMsgField;
    private JTextField chatIPField;
    private JTextField portField;
    private JToggleButton joinButton;

    /**
     * Creates new form GUI
     */
    public GUI() {
        initComponents();
    }

    private void initComponents() {
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                UIManager.setLookAndFeel(info.getClassName());
                break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }

        usernameLabel = new JLabel();
        usernameField = new JTextField();
        chatroomScrollPane = new JScrollPane();
        chatroomArea = new JTextArea();
        chatMsgLabel = new JLabel();
        chatMsgField = new JTextField();
        chatIPLabel = new JLabel();
        chatIPField = new JTextField();
        portLabel = new JLabel();
        portField = new JTextField();
        joinButton = new JToggleButton();
        sendButton = new JButton();
        leaveButton = new JButton();
        exitButton = new JButton();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        usernameLabel.setText("Username:");

        usernameField.setText("default_user");

        chatroomArea.setEditable(false);
        chatroomArea.setColumns(20);
        chatroomArea.setRows(5);
        chatroomScrollPane.setViewportView(chatroomArea);

        chatMsgLabel.setText("Chat Message:");

        chatIPLabel.setText("Chat Group IP");

        chatIPField.setText("127.0.0.1");

        portLabel.setText("Port");

        portField.setText("2015");

        joinButton.setText("JOIN CHAT");
        joinButton.addActionListener(this);

        sendButton.setText("SEND MESSAGE");
        sendButton.addActionListener(this);

        leaveButton.setText("LEAVE CHAT");
        leaveButton.addActionListener(this);

        exitButton.setText("EXIT");
        exitButton.addActionListener(this);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(usernameLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(usernameField, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
                    .addComponent(chatroomScrollPane)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(chatMsgLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chatMsgField, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(chatIPField, GroupLayout.Alignment.LEADING)
                                    .addComponent(chatIPLabel, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(portField, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                                    .addComponent(portLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(leaveButton)
                                        .addGap(18, 18, 18)
                                        .addComponent(exitButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(joinButton, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(sendButton)))))
                        .addGap(0, 8, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(usernameField)
                    .addComponent(usernameLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(3, 3, 3)
                .addComponent(chatroomScrollPane, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(chatMsgLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chatMsgField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(chatIPLabel)
                            .addComponent(portLabel))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(chatIPField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(portField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(joinButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sendButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(leaveButton)
                            .addComponent(exitButton))))
                .addGap(17, 17, 17))
        );
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent event){
        if(event.getSource() == joinButton){
            //Connect To Chatroom
            if(joinButton.isSelected()){
                (new Thread(new MulticastJoin())).start();
                (new Thread(new MulticastListener())).start();
            }
            else if(!joinButton.isSelected()){
                //Disconnect
            }
        }
        if(event.getSource() == sendButton){
          if(joinButton.isSelected()){
            (new Thread(new MulticastSend())).start();
            (new Thread(new MulticastListener())).start();
          }
          else{}
        }
        if(event.getSource() == leaveButton){
            //Leave Chat
            joinButton.setSelected(false);
        }
        if(event.getSource() == exitButton){
            //Exit Program
            System.exit(0);
        }
    }

    public static void main(String[] args){
        GUI gui = new GUI();
    }
}
