import javax.swing.*;
import java.awt.*;

public class Dashboard {



    public static void main(String[] args){



        //TOP SECTION PANEL
        JPanel topsection_panel = new JPanel();
        topsection_panel.setBackground(Color.DARK_GRAY);
        topsection_panel.setBounds(0, 0, 1500, 50);
        topsection_panel.setLayout(null);

        //MIDSECTION PANEL HEADER - > THIS IS FOR THE FLIGHT SELECTION

        JPanel midsection_panel_header = new ShadowPanel();
        midsection_panel_header.setOpaque(true);
        midsection_panel_header.setBackground(Color.DARK_GRAY);
        midsection_panel_header.setBounds(340, 200, 600, 80);
        midsection_panel_header.setLayout(null);

        //MIDSECTION PANEL HEADER - > THIS IS FOR THE PASSENGER INFO

        JPanel midsection_panel_header2 = new ShadowPanel();
        midsection_panel_header2.setOpaque(true);
        midsection_panel_header2.setBackground(Color.DARK_GRAY);
        midsection_panel_header2.setBounds(340, 200, 600, 80);
        midsection_panel_header2.setVisible(false);
        midsection_panel_header2.setLayout(null);

        //MIDSECTION PANEL HEADER - > THIS IS FOR THE PAYMENT SUMMARY

        JPanel midsection_panel_header3 = new ShadowPanel();
        midsection_panel_header3.setOpaque(true);
        midsection_panel_header3.setBackground(Color.DARK_GRAY);
        midsection_panel_header3.setBounds(340, 200, 600, 80);
        midsection_panel_header3.setVisible(false);
        midsection_panel_header3.setLayout(null);

        //MID SECTION PANEL - > THIS IS FOR THE FLIGHT SELECTION

        JPanel midsection_panel = new ShadowPanel();
        midsection_panel.setOpaque(true);
        midsection_panel.setBackground(Color.decode("#EEEEEE"));
        midsection_panel.setBounds(340, 260, 600, 300);
        midsection_panel.setLayout(null);

        //MID SECTION PANEL - > THIS IS FOR THE PASSENGER INFO

        JPanel midsection_panel2 = new ShadowPanel();
        midsection_panel2.setOpaque(true);
        midsection_panel2.setBackground(Color.decode("#EEEEEE"));
        midsection_panel2.setBounds(340, 260, 600, 300);
        midsection_panel2.setVisible(false);
        midsection_panel2.setLayout(null);

        //MID SECTION PANEL - > THIS IS FOR THE PAYMENT SUMMARY
        JPanel midsection_panel3 = new ShadowPanel();
        midsection_panel3.setOpaque(true);
        midsection_panel3.setBackground(Color.decode("#EEEEEE"));
        midsection_panel3.setBounds(340, 260, 600, 300);
        midsection_panel3.setVisible(false);
        midsection_panel3.setLayout(null);

        //CREATING THE MAIN FRAME
        JFrame main_frame = new JFrame();
        main_frame.setTitle("Airline Reservation System");
        main_frame.setSize(1500,750);
        main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main_frame.setResizable(false);
        main_frame.setLayout(null);


        //ADDING THE PANELS
        main_frame.add(topsection_panel);
        main_frame.add(midsection_panel_header);
        main_frame.add(midsection_panel);
        main_frame.add(midsection_panel_header2);
        main_frame.add(midsection_panel2);
        main_frame.add(midsection_panel_header3);
        main_frame.add(midsection_panel3);

        //SETTING AN ICON FOR THE WINDOW/FRAME
        ImageIcon window_icon = new ImageIcon("airplane_logo.png");
        main_frame.setIconImage(window_icon.getImage());

        //LABELS

        JLabel label1 = new JLabel();
        label1.setText("A  R  S");
        label1.setFont(new Font("Arial", Font.BOLD, 24));
        label1.setBounds(10,1,100,50);
        label1.setForeground(Color.white);
        topsection_panel.add(label1);

        JLabel label2 = new JLabel();
        label2.setText("Flight Selection");
        label2.setFont(new Font("Arial", Font.PLAIN, 24));
        label2.setBounds(205,20,300,30);
        label2.setForeground(Color.white);
        midsection_panel_header.add(label2);

        JLabel label3 = new JLabel();
        label3.setText("AIRLINE RESERVATION SYSTEM");
        label3.setFont(new Font("Arial", Font.PLAIN, 40));
        label3.setBounds(320,90,900,30);
        label3.setForeground(Color.darkGray);
        main_frame.add(label3);

        JLabel label5 = new JLabel();
        label5.setText("Seat Class");
        label5.setFont(new Font("Arial", Font.PLAIN, 15));
        label5.setBounds(390,110,900,20);
        label5.setForeground(Color.darkGray);
        midsection_panel.add(label5);

        JLabel label6 = new JLabel();
        label6.setText("Passenger Information");
        label6.setFont(new Font("Arial", Font.PLAIN, 24));
        label6.setBounds(175,20,300,30);
        label6.setForeground(Color.white);
        midsection_panel_header2.add(label6);

        JLabel label7 = new JLabel();
        label7.setText("Name");
        label7.setFont(new Font("arial", Font.PLAIN, 15));
        label7.setBounds(40, 45, 120, 30);
        label7.setForeground(Color.darkGray);
        midsection_panel2.add(label7);

        JLabel label8 = new JLabel();
        label8.setText("Age");
        label8.setFont(new Font("arial", Font.PLAIN, 15));
        label8.setBounds(40, 105, 120, 30);
        label8.setForeground(Color.darkGray);
        midsection_panel2.add(label8);

        JLabel label9 = new JLabel();
        label9.setText("Contact Number");
        label9.setFont(new Font("arial", Font.PLAIN, 15));
        label9.setBounds(40, 165, 120, 30);
        label9.setForeground(Color.darkGray);
        midsection_panel2.add(label9);

        JLabel label10 = new JLabel();
        label10.setText("Payment Summary");
        label10.setFont(new Font("Arial", Font.PLAIN, 24));
        label10.setForeground(Color.white);
        label10.setBounds(185,20,300,30);
        midsection_panel_header3.add(label10);

        //INT VARIABLES FOR CLASS SEAT QUANTITIES

        int economy_seat = 10;
        int premium_seat = 5;
        int business_seat = 3;

        //RADIOBUTTON FOR FLIGHT SELECTION

        JRadioButton flight1 = new JRadioButton("Flight 101 – Manila → Cebu");
        JRadioButton flight2 = new JRadioButton("Flight 202 – Manila → Davao");
        JRadioButton flight3 = new JRadioButton("Flight 303 – Cebu → Manila");
        JRadioButton flight4 = new JRadioButton("Flight 404 – Manila → Taiwan");

        flight1.setFont(new Font("Arial", Font.PLAIN, 15));
        flight2.setFont(new Font("Arial", Font.PLAIN, 15));
        flight3.setFont(new Font("Arial", Font.PLAIN, 15));
        flight4.setFont(new Font("Arial", Font.PLAIN, 15));

        flight1.setBounds(30, 40, 350, 50);
        flight2.setBounds(30, 100, 350, 50);
        flight3.setBounds(30, 160, 350, 50);
        flight4.setBounds(30, 220, 350, 50);

        //GROUP THE BUTTONS TO AVOID DUPLICATE SELECTIONS

        ButtonGroup flight_group = new ButtonGroup();
        flight_group.add(flight1);
        flight_group.add(flight2);
        flight_group.add(flight3);
        flight_group.add(flight4);

        midsection_panel.add(flight1);
        midsection_panel.add(flight2);
        midsection_panel.add(flight3);
        midsection_panel.add(flight4);

        //TEXTFIELDS

        JTextField passenger_name = new JTextField();
        passenger_name.setFont(new Font("Arial", Font.PLAIN, 15));
        passenger_name.setBounds(40, 70, 300, 30);
        midsection_panel2.add(passenger_name);

        JTextField passenger_age = new JTextField();
        passenger_age.setFont(new Font("Arial", Font.PLAIN, 15));
        passenger_age.setBounds(40, 130, 300, 30);
        midsection_panel2.add(passenger_age);

        JTextField passenger_contactNum = new JTextField();
        passenger_contactNum.setFont(new Font("Arial", Font.PLAIN, 15));
        passenger_contactNum.setBounds(40, 190, 300, 30);
        midsection_panel2.add(passenger_contactNum);

        //COMBO_BOX -> FOR CLASS SELECTION

        String[] classes = {"Economy(" + economy_seat + " seat/s)", "Premium Economy(" + premium_seat + " seat/s)", "Business(" + business_seat + " seat/s)"};
        JComboBox<String> comboBox1 = new JComboBox<>(classes);
        comboBox1.setBounds(390, 130, 170, 30);

        midsection_panel.add(comboBox1);

        //TEXT AREA -> USED FOR THE PAYMENT SUMMARY

        JTextArea payment_summary = new JTextArea(10, 30);
        payment_summary.setEditable(true);
        payment_summary.setFont(new Font("arial", Font.PLAIN, 14));
        payment_summary.setLineWrap(true);
        payment_summary.setWrapStyleWord(true);
        payment_summary.setBounds(30, 40, 400, 230);

        midsection_panel3.add(payment_summary);

        //BUTTONS

        JButton proceed_btn1 = new JButton("Proceed"); // this proceed button is for the flight selection section
        proceed_btn1.setFont(new Font("Arial", Font.PLAIN, 12));
        proceed_btn1.setBounds(465, 245, 120, 40);
        proceed_btn1.setBackground(Color.decode("#74ED74"));
        proceed_btn1.setForeground(Color.white);
        proceed_btn1.addActionListener( _ -> {

            ButtonModel validity = flight_group.getSelection();
            if(validity == null){
                JOptionPane.showMessageDialog(null, "Cannot proceed, please pick a flight");
            }else{
                midsection_panel.setVisible(false);
                midsection_panel_header.setVisible(false);
                midsection_panel_header2.setVisible(true);
                midsection_panel2.setVisible(true);
            }

        });
        midsection_panel.add(proceed_btn1);

        JButton proceed_btn2 = new JButton("Proceed"); // this proceed button is for the passenger info section
        proceed_btn2.setFont(new Font("Arial", Font.PLAIN, 12));
        proceed_btn2.setBounds(465, 245, 120, 40);
        proceed_btn2.setBackground(Color.decode("#74ED74"));
        proceed_btn2.setForeground(Color.white);
        proceed_btn2.addActionListener( _ -> {
            if(passenger_name.getText().trim().isEmpty() || passenger_age.getText().trim().isEmpty() || passenger_contactNum.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill up all the necessary passenger information");
            }
            else if(!(passenger_age.getText().matches("\\d+"))) {
                JOptionPane.showMessageDialog(null, "Age must be a digit");
            }else if(!(passenger_contactNum.getText().matches("\\d+"))){
                    JOptionPane.showMessageDialog(null, "Contact number invalid");
                }
            else{
                midsection_panel2.setVisible(false);
                midsection_panel_header2.setVisible(false);
                midsection_panel_header3.setVisible(true);
                midsection_panel3.setVisible(true);
            }
        });
        midsection_panel2.add(proceed_btn2);



        JButton previous_btn1 = new JButton("Previous"); // this proceed button is for the passenger info section
        previous_btn1.setFont(new Font("Arial", Font.PLAIN, 12));
        previous_btn1.setBounds(465, 195, 120, 40);
        previous_btn1.setBackground(Color.decode("#E7E746"));
        previous_btn1.setForeground(Color.white);
        previous_btn1.addActionListener( _ -> {
            midsection_panel2.setVisible(false);
            midsection_panel_header2.setVisible(false);
            midsection_panel.setVisible(true);
            midsection_panel_header.setVisible(true);
        });
        midsection_panel2.add(previous_btn1);

        JButton previous_btn2 = new JButton("Previous");
        previous_btn2.setFont(new Font("Arial", Font.PLAIN, 12));
        previous_btn2.setBounds(465, 245, 120, 40);
        previous_btn2.setBackground(Color.decode("#74ED74"));
        previous_btn2.setForeground(Color.white);
        previous_btn2.addActionListener(_ -> {

            midsection_panel_header3.setVisible(false);
            midsection_panel3.setVisible(false);
            midsection_panel_header2.setVisible(true);
            midsection_panel2.setVisible(true);
        });

        midsection_panel3.add(previous_btn2);


        // PLACED THIS AT THE VERY BOTTOM TO ENSURE ALL ELEMENTS ARE RENDERED PROPERLY
        main_frame.setVisible(true);


    }
}

class ShadowPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        int shadowSize = 8; // bigger number = bigger shadow
        // Draw shadow multiple times for soft spread
        for (int i = 1; i <= shadowSize; i++) {
            g2.setColor(new Color(0, 0, 0, 15)); // low alpha for softness
            g2.fillRoundRect(i, i, getWidth() - i*2, getHeight() - i*2, 20, 20);
        }

        // Draw panel background on top
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth() - shadowSize, getHeight() - shadowSize, 20, 20);

        g2.dispose();
    }

    public ShadowPanel() {
        setOpaque(false);
    }
}












