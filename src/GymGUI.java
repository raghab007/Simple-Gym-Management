import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GymGUI implements ActionListener {
    ArrayList<GymMember> members = new ArrayList<>();

    private JFrame mainFrame;
    private JPanel jRegularMember, jPremiumMember;
    private JButton buttonAddRegularMember, buttonAddPremiumMember;

    private JRadioButton male, female;
    private JTextField tfId, tfName, tfLocation, tfPhone, tfEmail, tfDOB, tfMembershipStartDate, tfReferralSource, tfPaidAmount, tfRemovalReason, tfTrainersName;
    private JTextField tfRegularPlanPrice, tfDiscountAmount; // Non-editable fields
    private JComboBox<String> planComboBox; // Plan selection for regular members

    public GymGUI() {
        mainFrame = new JFrame();
        mainFrame.setTitle("Gym Management System");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(800, 600); // Increased size to fit all components
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setLayout(null); // No Layout Manager
        mainFrame.getContentPane().setBackground(new Color(240, 240, 240)); // Light gray background

        // Labels and Text Fields (Left Column)
        JLabel lblId = new JLabel("ID:");
        lblId.setBounds(50, 30, 120, 25);
        mainFrame.add(lblId);

        tfId = new JTextField();
        tfId.setBounds(180, 30, 200, 25);
        tfId.setBackground(Color.WHITE); // White background for text fields
        mainFrame.add(tfId);

        JLabel lblName = new JLabel("Name:");
        lblName.setBounds(50, 70, 120, 25);
        mainFrame.add(lblName);

        tfName = new JTextField();
        tfName.setBounds(180, 70, 200, 25);
        tfName.setBackground(Color.WHITE);
        mainFrame.add(tfName);

        JLabel lblLocation = new JLabel("Location:");
        lblLocation.setBounds(50, 110, 120, 25);
        mainFrame.add(lblLocation);

        tfLocation = new JTextField();
        tfLocation.setBounds(180, 110, 200, 25);
        tfLocation.setBackground(Color.WHITE);
        mainFrame.add(tfLocation);

        JLabel lblPhone = new JLabel("Phone:");
        lblPhone.setBounds(50, 150, 120, 25);
        mainFrame.add(lblPhone);

        tfPhone = new JTextField();
        tfPhone.setBounds(180, 150, 200, 25);
        tfPhone.setBackground(Color.WHITE);
        mainFrame.add(tfPhone);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(50, 190, 120, 25);
        mainFrame.add(lblEmail);

        tfEmail = new JTextField();
        tfEmail.setBounds(180, 190, 200, 25);
        tfEmail.setBackground(Color.WHITE);
        mainFrame.add(tfEmail);

        JLabel lblDOB = new JLabel("DOB:");
        lblDOB.setBounds(50, 230, 120, 25);
        mainFrame.add(lblDOB);

        tfDOB = new JTextField();
        tfDOB.setBounds(180, 230, 200, 25);
        tfDOB.setBackground(Color.WHITE);
        mainFrame.add(tfDOB);

        // Labels and Text Fields (Right Column)
        JLabel lblMembershipStartDate = new JLabel("Membership Start Date:");
        lblMembershipStartDate.setBounds(450, 30, 150, 25);
        mainFrame.add(lblMembershipStartDate);

        tfMembershipStartDate = new JTextField();
        tfMembershipStartDate.setBounds(600, 30, 150, 25);
        tfMembershipStartDate.setBackground(Color.WHITE);
        mainFrame.add(tfMembershipStartDate);

        JLabel lblPaidAmount = new JLabel("Paid Amount:");
        lblPaidAmount.setBounds(450, 70, 120, 25);
        mainFrame.add(lblPaidAmount);

        tfPaidAmount = new JTextField();
        tfPaidAmount.setBounds(600, 70, 150, 25);
        tfPaidAmount.setBackground(Color.WHITE);
        mainFrame.add(tfPaidAmount);

        JLabel lblRemovalReason = new JLabel("Removal Reason:");
        lblRemovalReason.setBounds(450, 110, 120, 25);
        mainFrame.add(lblRemovalReason);

        tfRemovalReason = new JTextField();
        tfRemovalReason.setBounds(600, 110, 150, 25);
        tfRemovalReason.setBackground(Color.WHITE);
        mainFrame.add(tfRemovalReason);

        JLabel lblGender = new JLabel("Gender:");
        lblGender.setBounds(450, 150, 120, 25);
        mainFrame.add(lblGender);

        male = new JRadioButton("Male");
        male.setBounds(600, 150, 80, 25);
        male.setBackground(new Color(240, 240, 240)); // Match frame background
        mainFrame.add(male);

        female = new JRadioButton("Female");
        female.setBounds(690, 150, 80, 25);
        female.setBackground(new Color(240, 240, 240)); // Match frame background
        mainFrame.add(female);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        // Referral Source (Near Regular Member Button)
        JLabel lblReferralSource = new JLabel("Referral Source:");
        lblReferralSource.setBounds(50, 300, 120, 25);
        mainFrame.add(lblReferralSource);

        tfReferralSource = new JTextField();
        tfReferralSource.setBounds(180, 300, 200, 25);
        tfReferralSource.setBackground(Color.WHITE);
        mainFrame.add(tfReferralSource);

        // Trainer’s Name (Near Premium Member Button)
        JLabel lblTrainersName = new JLabel("Trainer’s Name:");
        lblTrainersName.setBounds(450, 300, 120, 25);
        mainFrame.add(lblTrainersName);

        tfTrainersName = new JTextField();
        tfTrainersName.setBounds(600, 300, 150, 25);
        tfTrainersName.setBackground(Color.WHITE);
        mainFrame.add(tfTrainersName);

        // Non-editable Text Fields
        JLabel lblRegularPlanPrice = new JLabel("Regular Plan Price:");
        lblRegularPlanPrice.setBounds(50, 340, 120, 25);
        mainFrame.add(lblRegularPlanPrice);

        tfRegularPlanPrice = new JTextField();
        tfRegularPlanPrice.setText("6500");
        tfRegularPlanPrice.setBounds(180, 340, 200, 25);
        tfRegularPlanPrice.setBackground(Color.WHITE);
        tfRegularPlanPrice.setEditable(false); // Non-editable
        mainFrame.add(tfRegularPlanPrice);



        // Plan ComboBox for Regular Members
        JLabel lblPlan = new JLabel("Plan:");
        lblPlan.setBounds(50, 380, 120, 25);
        mainFrame.add(lblPlan);

        planComboBox = new JComboBox<>(new String[]{"Basic", "Standard", "Deluxe"});
        planComboBox.setBounds(180, 380, 150, 25);
        mainFrame.add(planComboBox);

        // Buttons
        buttonAddRegularMember = new JButton("Add Regular Member");
        buttonAddRegularMember.setBounds(150, 420, 200, 30);
        buttonAddRegularMember.setBackground(new Color(50, 150, 250)); // Blue button
        buttonAddRegularMember.setForeground(Color.WHITE); // White text
        buttonAddRegularMember.addActionListener(this);
        mainFrame.add(buttonAddRegularMember);

        buttonAddPremiumMember = new JButton("Add Premium Member");
        buttonAddPremiumMember.setBounds(550, 420, 200, 30);
        buttonAddPremiumMember.setBackground(new Color(50, 150, 250)); // Blue button
        buttonAddPremiumMember.setForeground(Color.WHITE); // White text
        buttonAddPremiumMember.addActionListener(this);
        mainFrame.add(buttonAddPremiumMember);

        // Show the frame
        mainFrame.setVisible(true);
    }

    public void addRegularMember() {
        String id = tfId.getText();
        String name = tfName.getText();
        String location = tfLocation.getText();
        String phone = tfPhone.getText();
        String email = tfEmail.getText();
        String gender = male.isSelected() ? "Male" : "Female";
        String DOB = tfDOB.getText();
        String memberShipStartDate = tfMembershipStartDate.getText();
        String referralSource = tfReferralSource.getText();
        String plan = (String) planComboBox.getSelectedItem();


    }

    public void addPremiumMember() {
        String id = tfId.getText();
        String name = tfName.getText();
        String location = tfLocation.getText();
        String phone = tfPhone.getText();
        String email = tfEmail.getText();
        String gender = male.isSelected() ? "Male" : "Female";
        String DOB = tfDOB.getText();
        String memberShipStartDate = tfMembershipStartDate.getText();
        String personalTrainer = tfTrainersName.getText();


    }

    public static void main(String[] args) {
        new GymGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonAddRegularMember) {
            addRegularMember();
        } else if (e.getSource() == buttonAddPremiumMember) {
            addPremiumMember();
        }
    }
}