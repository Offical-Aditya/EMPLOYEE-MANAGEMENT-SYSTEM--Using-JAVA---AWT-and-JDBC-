import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class UpdateEmployee extends JFrame implements ActionListener {

    JTextField TFFname, TFeducation, TFaadhar, TFsalary, TFPhone, TFEmail, TFdesignation, TFaddress;
    JButton add, back;
    JLabel lblempId;
    String empId;

    public UpdateEmployee(String empId) {

        this.empId = empId;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(
                ClassLoader.getSystemResource("icons/dt.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 600);
        add(image);

        JLabel heading = new JLabel("Update Employee Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SARIF", Font.BOLD, 25));
        image.add(heading);

        JLabel lName = new JLabel("Name");
        lName.setBounds(50, 150, 150, 30);
        lName.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(lName);

        JLabel lblname = new JLabel();
        lblname.setBounds(200, 150, 150, 30);
        image.add(lblname);

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

        JLabel lbldob = new JLabel();
        lbldob.setBounds(200, 200, 150, 30);
        image.add(lbldob);

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

        TFeducation = new JTextField();
        TFeducation.setBounds(600, 300, 150, 30);
        image.add(TFeducation);

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

        JLabel lblaadhar = new JLabel();
        lblaadhar.setBounds(600, 350, 150, 30);
        image.add(lblaadhar);

        JLabel laempId = new JLabel("Employee Id");
        laempId.setBounds(50, 400, 150, 30);
        laempId.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(laempId);

        lblempId = new JLabel();
        lblempId.setBounds(200, 400, 150, 30);
        lblempId.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(lblempId);

        try {

            Conn c = new Conn();
            String query = " select * from employee where empId = '" + empId + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                lblname.setText(rs.getString("name"));
                TFFname.setText(rs.getString("fname"));
                lbldob.setText(rs.getString("dob"));
                TFsalary.setText(rs.getString("salary"));
                TFaddress.setText(rs.getString("address"));
                TFPhone.setText(rs.getString("phone"));
                TFEmail.setText(rs.getString("email"));
                TFeducation.setText(rs.getString("education"));
                TFdesignation.setText(rs.getString("designation"));
                lblaadhar.setText(rs.getString("aadhar"));
                lblempId.setText(rs.getString("empId"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        add = new JButton("Update  Datails");
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

            String fname = TFFname.getText();
            String salary = TFsalary.getText();
            String address = TFaddress.getText();
            String phone = TFPhone.getText();
            String email = TFEmail.getText();
            String education = TFeducation.getText();
            String designation = TFdesignation.getText();

            try {

                Conn conn = new Conn();
                String query = "update employee set fname = '" + fname + "', salary = '" + salary + "' , address = '"
                        + address + "', phone = '" + phone + "', email = '" + email + "', education = '" + education +
                        "', designation =   '" + designation + "' where  empId = '" + empId + "'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details Updated Successfully");
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

        new UpdateEmployee("");

    }

}
