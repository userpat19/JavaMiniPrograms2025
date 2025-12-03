import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Dashboard {

    static Connection db_connection(){
        //DATABASE LOG IN CREDENTIALS
        String URl = "jdbc:mysql://localhost:3306/airline_reservation_system";
        String user = "root";
        String password = "DATABASE_PSS";

        //CREATING THE CONNECTION OBJECT AND THE STATEMENT OBJECT
        try{
            return DriverManager.getConnection(URl, user,password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    static void INSERT_TO_DATABASE(Connection conn, String name, String flightNum, String flightDate, String flightTime, String seatClass, Double ticketPrice ) throws SQLException {
        try {
            String insertion_query = "INSERT INTO booked_flights(passenger_name, flight_number, flight_date, flight_time, seat_class, ticket_price) values(?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(insertion_query);
            pst.setString(1, name);
            pst.setString(2, flightNum);
            pst.setString(3, flightDate);
            pst.setString(4, flightTime);
            pst.setString(5, seatClass);
            pst.setDouble(6, ticketPrice);
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    static int get_EconomySeats(Connection conn){
        try{
            String the_query = "select Economy from Seat_Count where id = 1;";
            PreparedStatement pst = conn.prepareStatement(the_query);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                return rs.getInt("Economy");
            }else{
                return 0;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    static int get_PremiumEconomySeats(Connection conn){
        try{
            String the_query = "select Premium_Economy from Seat_Count where id = 1;";
            PreparedStatement pst = conn.prepareStatement(the_query);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                return rs.getInt("Premium_Economy");
            }else{
                return 0;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    static int get_BusinessSeats(Connection conn){
        try{
            String the_query = "select Business from Seat_Count where id = 1;";
            PreparedStatement pst = conn.prepareStatement(the_query);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                return rs.getInt("Business");
            }else{
                return 0;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    static boolean check_SeatAvailability(Connection conn, String selected_class){
        try{
            String the_query = "Select " + selected_class +  " from Seat_Count where id = 1;";
            PreparedStatement pst = conn.prepareStatement(the_query);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                if(rs.getInt(selected_class) != 0){
                    return true;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    static void decrementSeatCount(Connection conn, String selected_class){

        try{
            String the_query = "Update seat_count set " + selected_class + " = " + selected_class + " - 1;";
            PreparedStatement pst = conn.prepareStatement(the_query);
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }






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
        label5.setBounds(390,180,900,20);
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
        label10.setBounds(185,20,300,35);
        midsection_panel_header3.add(label10);

        JLabel label11 = new JLabel();
        label11.setText("Date");
        label11.setFont(new Font("Arial", Font.PLAIN, 15));
        label11.setBounds(390,40,900,20);
        label11.setForeground(Color.darkGray);
        midsection_panel.add(label11);

        JLabel label12 = new JLabel();
        label12.setText("Time");
        label12.setFont(new Font("Arial", Font.PLAIN, 15));
        label12.setBounds(390,110,900,20);
        label12.setForeground(Color.darkGray);
        midsection_panel.add(label12);

        //DATEPICKER

        JSpinner dateSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor editor = new JSpinner.DateEditor(dateSpinner, "yyyy-MM-dd");
        dateSpinner.setEditor(editor);
        dateSpinner.setBounds(390, 60, 150, 30);
        midsection_panel.add(dateSpinner);

        //TIMEPICKER

        JSpinner timeSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm");
        timeSpinner.setEditor(timeEditor);
        timeSpinner.setBounds(390, 130, 150, 30);
        midsection_panel.add(timeSpinner);



        //RADIOBUTTON FOR FLIGHT SELECTION

        JRadioButton flight1 = new JRadioButton("Flight 101 – Manila → Cebu");
        JRadioButton flight2 = new JRadioButton("Flight 202 – Manila → Davao");
        JRadioButton flight3 = new JRadioButton("Flight 303 – Cebu → Manila");
        JRadioButton flight4 = new JRadioButton("Flight 404 – Manila → Taiwan");

        flight1.setActionCommand("Flight 101");
        flight2.setActionCommand("Flight 202");
        flight3.setActionCommand("Flight 303");
        flight4.setActionCommand("Flight 404");

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

        String[] classes = {"Economy(" + get_EconomySeats(db_connection()) + " seat/s)", "Premium_Economy(" + get_PremiumEconomySeats(db_connection()) + " seat/s)", "Business(" + get_BusinessSeats(db_connection()) + " seat/s)"};
        JComboBox<String> comboBox1 = new JComboBox<>(classes);
        comboBox1.setBounds(390, 200, 150, 30);

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
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            Date selected_date = (Date) dateSpinner.getValue();
            Date present = new Date();
            ButtonModel validity = flight_group.getSelection();
            if(validity == null){
                JOptionPane.showMessageDialog(null, "Cannot proceed, please pick a flight");
            }else if(sf.format(selected_date).equals(sf.format(present)) || selected_date.before(present)){
                JOptionPane.showMessageDialog(null, "Invalid Flight Schedule");
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
                String selected_flight = flight_group.getSelection().getActionCommand();
                String selected_class = String.valueOf(comboBox1.getSelectedItem());
                String selected_class_trimed = selected_class.substring(0, selected_class.indexOf("("));
                double ticket_price = 0;
                switch (selected_flight){
                    case "Flight 101":
                        if(selected_class_trimed.equals("Economy")){
                            ticket_price = 1500;
                        }else if(selected_class_trimed.equals("Premium_Economy")){
                            ticket_price = 1500 * 1.3;
                        }else if(selected_class_trimed.equals("Business")){
                            ticket_price = 1500 * 2.5;
                        }
                        break;
                    case "Flight 202":
                        if(selected_class_trimed.equals("Economy")){
                            ticket_price = 2100;
                        }else if(selected_class_trimed.equals("Premium_Economy")){
                            ticket_price = 2100 * 1.3;
                        }else if(selected_class_trimed.equals("Business")){
                            ticket_price = 2100 * 2.5;
                        }
                        break;
                    case "Flight 303":
                        if(selected_class_trimed.equals("Economy")){
                            ticket_price = 1600;
                        }else if(selected_class_trimed.equals("Premium_Economy")){
                            ticket_price = 1600 * 1.3;
                        }else if(selected_class_trimed.equals("Business")){
                            ticket_price = 1600 * 2.5;
                        }
                        break;
                    case "Flight 404":
                        if(selected_class_trimed.equals("Economy")){
                            ticket_price = 2800;
                        }else if(selected_class_trimed.equals("Premium_Economy")){
                            ticket_price = 2800 * 1.3;
                        }else if(selected_class_trimed.equals("Business")){
                            ticket_price = 2800 * 2.5;
                        }
                        break;
                    default:
                        System.out.println("ERROR ENCOUNTERED ON SWITCH STATEMENT - > ticket price assignment");
                }
                Date selected_date = (Date) dateSpinner.getValue();
                Date selected_time = (Date) timeSpinner.getValue();
                SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat time_format = new SimpleDateFormat("HH:mm");
                String date_string = date_format.format(selected_date);
                String time_string = time_format.format(selected_time);
                String summary_content = "\nName: " + passenger_name.getText() + "\n\n" + "Flight Number: " + selected_flight + "\n\n"+ "Date: " + date_string + "\n\n" + "Time: " + time_string + "\n\n" + "Seat Class: "+ selected_class_trimed + "\n\n" + "Ticket Price: ₱" + ticket_price;
                payment_summary.setText(summary_content);
                midsection_panel_header3.setVisible(true);
                midsection_panel3.setVisible(true);
            }
        });
        midsection_panel2.add(proceed_btn2);

        JButton proceed_btn3 = new JButton("Confirm");
        proceed_btn3.setFont(new Font("arial", Font.PLAIN, 12));
        proceed_btn3.setBounds(465, 245, 120, 40);
        proceed_btn3.setBackground(Color.decode("#74ED74"));
        proceed_btn3.setForeground(Color.white);
        proceed_btn3.addActionListener(_ ->{

            int name_line = 1; // nickname: nl
            int fl_number_line = 3; // nickname: fnl
            int date_line = 5; // nickname: dl
            int time_line = 7; // nickname: tl
            int seat_class_line = 9; // nickname: scl
            int ticket_price_line = 11; // nickname: tpl

            try{

                // Check first if Seat Class is valid
                String selected_class = String.valueOf(comboBox1.getSelectedItem());
                String selected_class_trimed = selected_class.substring(0, selected_class.indexOf("("));
                if(check_SeatAvailability(db_connection(), selected_class_trimed)){
                    //GETTING THE SPECIFIC START/END INDEX FOR EACH LINE

                    int nl_startIndex = payment_summary.getLineStartOffset(name_line);
                    int nl_endIndex = payment_summary.getLineEndOffset(name_line);

                    int fnl_startIndex = payment_summary.getLineStartOffset(fl_number_line);
                    int fnl_endIndex = payment_summary.getLineEndOffset(fl_number_line);

                    int dl_startIndex = payment_summary.getLineStartOffset(date_line);
                    int dl_endIndex = payment_summary.getLineEndOffset(date_line);

                    int tl_startIndex = payment_summary.getLineStartOffset(time_line);
                    int tl_endIndex = payment_summary.getLineEndOffset(time_line);

                    int scl_startIndex = payment_summary.getLineStartOffset(seat_class_line);
                    int scl_endIndex = payment_summary.getLineEndOffset(seat_class_line);

                    int tpl_startIndex = payment_summary.getLineStartOffset(ticket_price_line);
                    int tpl_endIndex = payment_summary.getLineEndOffset(ticket_price_line);

                    //GETTING THE FULL CONTENTS OF EACH LINE

                    String nl_fullContent = payment_summary.getText().substring(nl_startIndex, nl_endIndex);
                    String fnl_fullContent = payment_summary.getText().substring(fnl_startIndex, fnl_endIndex);
                    String dl_fullContent = payment_summary.getText().substring(dl_startIndex, dl_endIndex);
                    String tl_fullContent = payment_summary.getText().substring(tl_startIndex, tl_endIndex);
                    String scl_fullContent = payment_summary.getText().substring(scl_startIndex, scl_endIndex);
                    String tpl_fullContent = payment_summary.getText().substring(tpl_startIndex, tpl_endIndex);

                    //GETTING THE ACTUAL VALUES TO BE INSERTED ON THE DATABASE

                    String passengerName = nl_fullContent.substring((nl_fullContent.indexOf(":") + 2));
                    String flightNumber = fnl_fullContent.substring((fnl_fullContent.indexOf(":") + 2));
                    String flightDate = dl_fullContent.substring((dl_fullContent.indexOf(":") + 2));
                    String flightTime = tl_fullContent.substring((tl_fullContent.indexOf(":") + 2));
                    String seatClass = scl_fullContent.substring((scl_fullContent.indexOf(":") + 2));
                    Double ticketPrice = Double.parseDouble(tpl_fullContent.substring((tpl_fullContent.indexOf("₱") + 1)));

                    //INSERTING BOOKING DETAILS TO THE DATABASE USING A METHOD
                    INSERT_TO_DATABASE(db_connection(),passengerName, flightNumber, flightDate, flightTime, seatClass, ticketPrice);

                    //Decreasing the seat count by one in the dbase for the selected seat class using a method
                    decrementSeatCount(db_connection(), selected_class_trimed);

                    //Displaying a confirmation button that the flight details are registered successfully

                    JOptionPane.showMessageDialog(null, "FLIGHT DETAILS REGISTERED SUCCESSFULLY, THANK YOU!");
                    payment_summary.setText("");
                    midsection_panel3.setVisible(false);
                    midsection_panel_header3.setVisible(false);
                    passenger_name.setText("");
                    passenger_age.setText("");
                    passenger_contactNum.setText("");
                    flight_group.clearSelection();
                    midsection_panel_header.setVisible(true);
                    midsection_panel.setVisible(true);

                    comboBox1.removeAllItems();
                    comboBox1.addItem("Economy(" + get_EconomySeats(db_connection()) + " seat/s)");
                    comboBox1.addItem("Premium_Economy(" + get_PremiumEconomySeats(db_connection()) + " seat/s)");
                    comboBox1.addItem("Business(" + get_BusinessSeats(db_connection()) + " seat/s)");




                }
                else {
                    JOptionPane.showMessageDialog(null, "SELECTED SEAT CLASS IS INVALID");
                }
            }catch (BadLocationException | SQLException e){
                e.printStackTrace();
            }
        });

        midsection_panel3.add(proceed_btn3);



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
        previous_btn2.setBounds(465, 195, 120, 40);
        previous_btn2.setBackground(Color.decode("#E7E746"));
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












