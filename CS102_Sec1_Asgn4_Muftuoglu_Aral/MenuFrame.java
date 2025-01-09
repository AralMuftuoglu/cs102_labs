import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.GridLayout;

public class MenuFrame extends JFrame {

    private String name;
    private int speed;
    public boolean openGame;

    private int frame_width = 400;
    private int frame_height = 300;

    final int field_weidth = 10;

    private JPanel panel_1;
    private JLabel label_1;
    private JTextField input_name;

    private JPanel panel_2;
    private JLabel label_2;
    private JTextField input_speed;

    private JButton button;


    public MenuFrame() {
        setLayout(new GridLayout(3, 1));
        setSize(frame_width, frame_height);

        createTextField();
        createPanel();
        createButton();

        setTitle("ShipGame");
    }

    private void createTextField() {
        label_1 = new JLabel("Name:");
        input_name = new JTextField(field_weidth);

        label_2 = new JLabel("Speed:");
        input_speed = new JTextField(field_weidth);

    }

    private void createButton() {
        button = new JButton("Start");

        ActionListener listener = new inputValueListener();
        button.addActionListener(listener);

        add(button);
    }

    private void createPanel() {
        panel_1 = new JPanel(new GridLayout(1, 2));
        panel_1.add(label_1);
        panel_1.add(input_name);
        add(panel_1);

        panel_2 = new JPanel(new GridLayout(1, 2));
        panel_2.add(label_2);
        panel_2.add(input_speed);
        add(panel_2);
    }

    public boolean willOpen() {
        return openGame;
    }

    class inputValueListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String text_1 = input_name.getText();
            String text_2 = input_speed.getText();

            if (text_1.length() == 0 && text_2.length() == 0) {
                JOptionPane.showMessageDialog(null, "Name and Speed cannot be empty!");
            } else if (text_1.length() == 0 && text_2.length() != 0) {
                JOptionPane.showMessageDialog(null, "Name cannot be empty!");
            } else if (text_1.length() != 0 && text_2.length() == 0) {
                JOptionPane.showMessageDialog(null, "Speed cannot be empty!");

            } else {

                openGame = true;

                boolean anyNotDigit = false;

                name = text_1;

                for (int i = 0; i < text_2.length(); i++) {
                    if (!Character.isDigit(text_2.charAt(i))) {
                        anyNotDigit = true;
                    }
                }

                if (anyNotDigit) {
                    openGame = false;
                    JOptionPane.showMessageDialog(null, "Speed should be only numbers!");
                } else {
                    speed = Integer.parseInt(text_2);
                    openGame = true;
                }
            }
            

            if(openGame==true)
            {
                JFrame game_Frame= new GameFrame(name,speed);
                
                game_Frame.setVisible(true);
            }
        }
    }
}
