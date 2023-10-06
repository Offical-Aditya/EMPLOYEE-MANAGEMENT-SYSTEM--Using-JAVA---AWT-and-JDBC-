import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class AddEmployee extends JFrame implements ActionListener {

    JTextField TFFname, TFname, TFaadhar, TFsalary, TFPhone, TFEmail, TFdesignation, TFaddress;
    JDateChooser dcdob;
    JButton add, back;
    JComboBox cbeducation;
    JLabel lempId;

    Random ran = new Random();
    int Number = ran.nextInt(999999);

    public AddEmployee() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(
                ClassLoader.getSystemResource("icons/add_employee.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1120, 630);
        add(image);

        JLabel heading = new JLabel("Add Employee Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SARIF", Font.BOLD, 25));
        image.add(heading);

        JLabel lName = new JLabel("Name");
        lName.setBounds(50, 150, 150, 30);
        lName.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(lName);

        TFname = new JTextField();
        TFname.setBounds(200, 150, 150, 30);
        image.add(TFname);

        JLabel lFName = new JLabel("Fathers's Name");
        lFName.setBounds(400, 150, 150, 30);
        lFName.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(lFName);

        TFFname = new JTextField();
        TFFname.setBounds(600, 150, 150, 30);
        image.add(TFFname);

        JLabel lDob = new JLabel("Date of Birth");
        lDob.setBounds(50, 200, 150, 30);
        lDob.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(lDob);

        dcdob = new JDateChooser();
        dcdob.setBounds(200, 200, 150, 30);
        image.add(dcdob);

        JLabel lSalary = new JLabel("Salary");
        lSalary.setBounds(400, 200, 150, 30);
        lSalary.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(lSalary);

        TFsalary = new JTextField();
        TFsalary.setBounds(600, 200, 150, 30);
        image.add(TFsalary);

        JLabel laddress = new JLabel("Address");
        laddress.setBounds(50, 250, 150, 30);
        laddress.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(laddress);

        TFaddress = new JTextField();
        TFaddress.setBounds(200, 250, 150, 30);
        image.add(TFaddress);

        JLabel lPhone = new JLabel("Phone");
        lPhone.setBounds(400, 250, 150, 30);
        lPhone.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(lPhone);

        TFPhone = new JTextField();
        TFPhone.setBounds(600, 250, 150, 30);
        image.add(TFPhone);

        JLabel lEmail = new JLabel("Email");
        lEmail.setBounds(50, 300, 150, 30);
        lEmail.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(lEmail);

        TFEmail = new JTextField();
        TFEmail.setBounds(200, 300, 150, 30);
        image.add(TFEmail);

        JLabel leducation = new JLabel("Higest Education");
        leducation.setBounds(400, 300, 150, 30);
        leducation.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(leducation);

        String course[] = { "BBA", "BCA", "BA", "B.SC", "B.Com", "B.Tech", "MBA", "MCA", "MA", "M.Tech", "M.SC",
                "PHD" };
        cbeducation = new JComboBox(course);
        cbeducation.setBounds(600, 300, 150, 30);
        cbeducation.setBackground(Color.white);
        image.add(cbeducation);

        JLabel ldesignation = new JLabel("Designation");
        ldesignation.setBounds(50, 350, 150, 30);
        ldesignation.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(ldesignation);

        TFdesignation = new JTextField();
        TFdesignation.setBounds(200, 350, 150, 30);
        image.add(TFdesignation);

        JLabel laadhar = new JLabel("Aadhar Number");
        laadhar.setBounds(400, 350, 150, 30);
        laadhar.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(laadhar);

        TFaadhar = new JTextField();
        TFaadhar.setBounds(600, 350, 150, 30);
        image.add(TFaadhar);

        JLabel laempId = new JLabel("Employee Id");
        laempId.setBounds(50, 400, 150, 30);
        laempId.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(laempId);

        lempId = new JLabel("" + Number);
        lempId.setBounds(200, 400, 150, 30);
        lempId.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(lempId);

        add = new JButton("Add  Datails");
        add.setBounds(250, 550, 150, 40);
        add.setBackground(Color.black);
        add.setForeground(Color.white);
        add.addActionListener(this);
        image.add(add);

        back = new JButton("Back");
        back.setBounds(450, 550, 150, 40);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 650);
        setLocation(250, 50);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == add) {

            String name = TFname.getText();
            String fname = TFFname.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String salary = TFsalary.getText();
            String address = TFaddress.getText();
            String phone = TFPhone.getText();
            String email = TFEmail.getText();
            String education = (String) cbeducation.getSelectedItem();
            String designation = TFdesignation.getText();
            String aadhar = TFaadhar.getText();
            String empId = lempId.getText();

            try {

                Conn conn = new Conn();
                String query = "insert employee values('" + name + "', '" + fname + "', '" + dob + "', '" + salary
                        + "','" + address + "', '" + phone + "','" + email + "','" + education + "','" + designation
                        + "','" + aadhar + "','" + empId + "')";

                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details addes Successfully");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            setVisible(false);
            new Home();

        }

    }

    public static void main(String[] args) {

        new AddEmployee();

    }

}
