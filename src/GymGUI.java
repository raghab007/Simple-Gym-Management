import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GymGUI implements ActionListener {
    ArrayList<GymMember> members = new ArrayList<>();

    private JFrame mainFrame;
    private JButton buttonAddRegularMember, buttonAddPremiumMember, buttonActivateMembership, buttonDeactivateMemberShip, buttonMarkAttendance, buttonUpgradePlan, buttonCalculateDiscount, buttonRevertMember, buttonPayDueAmount, buttonDisplay, buttonClear, buttonSaveToFile, buttonReadFromFile;


    private JRadioButton male, female;
    private JTextField tfId, tfName, tfLocation, tfPhone, tfEmail, tfDOB, tfMembershipStartDate, tfReferralSource, tfTrainersName,tfActivateMembership;
    private JTextField tfRegularPlanPrice; // Non-editable field
    private JComboBox<String> planComboBox; // Plan selection for regular members

    public GymGUI() {
        mainFrame = new JFrame();
        mainFrame.setTitle("Gym Management System");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(1300, 700); // Increased size to fit all components
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setLayout(null); // No Layout Manager
        mainFrame.getContentPane().setBackground(new Color(240, 240, 240)); // Light gray background

        // Heading Label
        JLabel lblHeading = new JLabel("Enter All Fields to Add Regular or Premium Member");
        lblHeading.setBounds(300, 20, 400, 30);
        lblHeading.setFont(new Font("Arial", Font.BOLD, 16));
        lblHeading.setForeground(new Color(50, 50, 50)); // Dark gray text
        mainFrame.add(lblHeading);

        // Common Fields (Centered)
        JPanel commonPanel = new JPanel();
        commonPanel.setBounds(50, 60, 900, 300);
        commonPanel.setBackground(new Color(255, 255, 255)); // White background
        commonPanel.setBorder(BorderFactory.createTitledBorder("Common Fields"));
        commonPanel.setLayout(null);
        mainFrame.add(commonPanel);

        JLabel lblId = new JLabel("ID:");
        lblId.setBounds(20, 30, 100, 25);
        commonPanel.add(lblId);

        tfId = new JTextField();
        tfId.setBounds(130, 30, 200, 25);
        tfId.setBackground(Color.WHITE);
        commonPanel.add(tfId);

        JLabel lblName = new JLabel("Name:");
        lblName.setBounds(20, 70, 100, 25);
        commonPanel.add(lblName);

        tfName = new JTextField();
        tfName.setBounds(130, 70, 200, 25);
        tfName.setBackground(Color.WHITE);
        commonPanel.add(tfName);

        JLabel lblLocation = new JLabel("Location:");
        lblLocation.setBounds(20, 110, 100, 25);
        commonPanel.add(lblLocation);

        tfLocation = new JTextField();
        tfLocation.setBounds(130, 110, 200, 25);
        tfLocation.setBackground(Color.WHITE);
        commonPanel.add(tfLocation);

        JLabel lblPhone = new JLabel("Phone:");
        lblPhone.setBounds(20, 150, 100, 25);
        commonPanel.add(lblPhone);

        tfPhone = new JTextField();
        tfPhone.setBounds(130, 150, 200, 25);
        tfPhone.setBackground(Color.WHITE);
        commonPanel.add(tfPhone);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(20, 190, 100, 25);
        commonPanel.add(lblEmail);

        tfEmail = new JTextField();
        tfEmail.setBounds(130, 190, 200, 25);
        tfEmail.setBackground(Color.WHITE);
        commonPanel.add(tfEmail);

        JLabel lblDOB = new JLabel("DOB:");
        lblDOB.setBounds(20, 230, 100, 25);
        commonPanel.add(lblDOB);

        tfDOB = new JTextField();
        tfDOB.setBounds(130, 230, 200, 25);
        tfDOB.setBackground(Color.WHITE);
        commonPanel.add(tfDOB);

        JLabel lblMembershipStartDate = new JLabel("Membership Start Date:");
        lblMembershipStartDate.setBounds(350, 30, 150, 25);
        commonPanel.add(lblMembershipStartDate);

        tfMembershipStartDate = new JTextField();
        tfMembershipStartDate.setBounds(510, 30, 200, 25);
        tfMembershipStartDate.setBackground(Color.WHITE);
        commonPanel.add(tfMembershipStartDate);

        JLabel lblGender = new JLabel("Gender:");
        lblGender.setBounds(350, 70, 100, 25);
        commonPanel.add(lblGender);

        male = new JRadioButton("Male");
        male.setBounds(510, 70, 80, 25);
        male.setBackground(Color.WHITE);
        commonPanel.add(male);

        female = new JRadioButton("Female");
        female.setBounds(600, 70, 80, 25);
        female.setBackground(Color.WHITE);
        commonPanel.add(female);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        // Regular Member Specific Fields (Left Side)
        JPanel regularPanel = new JPanel();
        regularPanel.setBounds(50, 380, 400, 250);
        regularPanel.setBackground(new Color(255, 255, 255)); // White background
        regularPanel.setBorder(BorderFactory.createTitledBorder("Regular Member Fields"));
        regularPanel.setLayout(null);
        mainFrame.add(regularPanel);

        JLabel lblReferralSource = new JLabel("Referral Source:");
        lblReferralSource.setBounds(20, 30, 120, 25);
        regularPanel.add(lblReferralSource);

        tfReferralSource = new JTextField();
        tfReferralSource.setBounds(150, 30, 200, 25);
        tfReferralSource.setBackground(Color.WHITE);
        regularPanel.add(tfReferralSource);

        JLabel lblRegularPlanPrice = new JLabel("Regular Plan Price:");
        lblRegularPlanPrice.setBounds(20, 70, 120, 25);
        regularPanel.add(lblRegularPlanPrice);

        tfRegularPlanPrice = new JTextField();
        tfRegularPlanPrice.setText("6500");
        tfRegularPlanPrice.setBounds(150, 70, 200, 25);
        tfRegularPlanPrice.setBackground(Color.WHITE);
        tfRegularPlanPrice.setEditable(false);
        regularPanel.add(tfRegularPlanPrice);

        JLabel lblPlan = new JLabel("Plan:");
        lblPlan.setBounds(20, 110, 120, 25);
        regularPanel.add(lblPlan);

        planComboBox = new JComboBox<>(new String[]{"Basic", "Standard", "Deluxe"});
        planComboBox.setBounds(150, 110, 200, 25);
        regularPanel.add(planComboBox);

        buttonAddRegularMember = new JButton("Add Regular Member");
        buttonAddRegularMember.setBounds(100, 170, 200, 30);
        buttonAddRegularMember.setBackground(new Color(50, 150, 250)); // Blue button
        buttonAddRegularMember.setForeground(Color.black);
        buttonAddRegularMember.addActionListener(this);
        regularPanel.add(buttonAddRegularMember);


        buttonActivateMembership = new JButton("Activate membership");
        buttonActivateMembership.setBounds(1000,60,200,30);
        buttonActivateMembership.setForeground(Color.DARK_GRAY);
        buttonActivateMembership.addActionListener(this);
        mainFrame.add(buttonActivateMembership);


        buttonDeactivateMemberShip = new JButton("Deactivate membership");
        buttonDeactivateMemberShip.setBounds(1000,130,200,30);
        buttonDeactivateMemberShip.setForeground(Color.black);
        buttonDeactivateMemberShip.setBackground(Color.red);
        buttonDeactivateMemberShip.addActionListener(this);
        mainFrame.add(buttonDeactivateMemberShip);



        buttonMarkAttendance = new JButton("Mark attendance");
        buttonMarkAttendance.setBounds(1000,200,200,30);
        buttonMarkAttendance.setForeground(Color.black);
        buttonMarkAttendance.setBackground(Color.green);
        buttonMarkAttendance.addActionListener(this);
        mainFrame.add(buttonMarkAttendance);





        buttonUpgradePlan = new JButton("Upgrade plan");
        buttonUpgradePlan.setBounds(1000,270,200,30);
        buttonUpgradePlan.setForeground(Color.black);
        buttonUpgradePlan.setBackground(Color.gray);
        buttonUpgradePlan.addActionListener(this);

        mainFrame.add(buttonUpgradePlan);



        buttonCalculateDiscount = new JButton("Calculate Discount");
        buttonCalculateDiscount.setBounds(1000,340,200,30);
        buttonCalculateDiscount.setForeground(Color.BLACK);
        buttonCalculateDiscount.setBackground(Color.GREEN);
        buttonCalculateDiscount.addActionListener(this);
        mainFrame.add(buttonCalculateDiscount);
        // Premium Member Specific Fields (Right Side)
        JPanel premiumPanel = new JPanel();
        premiumPanel.setBounds(530, 380, 400, 250);
        premiumPanel.setBackground(new Color(255, 255, 255)); // White background
        premiumPanel.setBorder(BorderFactory.createTitledBorder("Premium Member Fields"));
        premiumPanel.setLayout(null);
        mainFrame.add(premiumPanel);

        JLabel lblTrainersName = new JLabel("Trainer’s Name:");
        lblTrainersName.setBounds(20, 30, 120, 25);
        premiumPanel.add(lblTrainersName);

        tfTrainersName = new JTextField();
        tfTrainersName.setBounds(150, 30, 200, 25);
        tfTrainersName.setBackground(Color.WHITE);
        premiumPanel.add(tfTrainersName);

        buttonAddPremiumMember = new JButton("Add Premium Member");
        buttonAddPremiumMember.setBounds(100, 170, 200, 30);
        buttonAddPremiumMember.setBackground(new Color(200, 0, 100)); // Red button
        buttonAddPremiumMember.setForeground(Color.WHITE);
        buttonAddPremiumMember.addActionListener(this);
        premiumPanel.add(buttonAddPremiumMember);

        // Show the frame
        mainFrame.setVisible(true);
    }

    public void addRegularMember() {
        try {
            int id = Integer.parseInt(tfId.getText());
            String name = tfName.getText();
            String location = tfLocation.getText();
            String phone = tfPhone.getText();
            String email = tfEmail.getText();
            String gender = male.isSelected() ? "Male" : "Female";
            String DOB = tfDOB.getText();
            String memberShipStartDate = tfMembershipStartDate.getText();
            String referralSource = tfReferralSource.getText();
            if (name.isEmpty() || location.isEmpty() || phone.isEmpty() || email.isEmpty() || gender.isEmpty() || DOB.isEmpty() || memberShipStartDate.isEmpty() || referralSource.isEmpty()) {
                JOptionPane.showMessageDialog(mainFrame, "All fields are required. Please fill in all fields.", "Error", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            boolean alreadyExists = checkId(id);
            if (alreadyExists) {
                JOptionPane.showMessageDialog(mainFrame, "User with this ID already exists. Enter a new ID.", "Duplicate ID", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            GymMember gymMember = new RegularMember(id, name, location, phone, email, gender, DOB, memberShipStartDate, referralSource);
            members.add(gymMember);
            JOptionPane.showMessageDialog(mainFrame, "Regular Member Added Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(mainFrame, "ID must be a number. Please enter a valid ID.", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void addPremiumMember() {
        try {
            int id = Integer.parseInt(tfId.getText());
            String name = tfName.getText();
            String location = tfLocation.getText();
            String phone = tfPhone.getText();
            String email = tfEmail.getText();
            String gender = male.isSelected() ? "Male" : "Female";
            String DOB = tfDOB.getText();
            String memberShipStartDate = tfMembershipStartDate.getText();
            String personalTrainer = tfTrainersName.getText();

            if (name.isEmpty() || location.isEmpty() || phone.isEmpty() || email.isEmpty() || gender.isEmpty() || DOB.isEmpty() || memberShipStartDate.isEmpty() || personalTrainer.isEmpty()) {
                JOptionPane.showMessageDialog(mainFrame, "All fields are required. Please fill in all fields.", "Error", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            boolean alreadyExists = checkId(id);
            if (alreadyExists) {
                JOptionPane.showMessageDialog(mainFrame, "User with this ID already exists. Enter a new ID.", "Duplicate ID", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            GymMember gymMember = new PremiumMember(id, name, location, phone, email, gender, DOB, memberShipStartDate, personalTrainer);
            members.add(gymMember);
            JOptionPane.showMessageDialog(mainFrame, "Premium Member Added Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(mainFrame, "ID must be a number. Please enter a valid ID.", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    public boolean checkId(int id) {
        for (GymMember member : members) {
            if (member.getId() == id) {
                return true;
            }
        }
        return false;
    }


    public void openFrameToActivateMembership(){
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setBounds(400,50,400,400);
        tfActivateMembership = new JTextField();
        tfActivateMembership.setBounds(50, 50, 100, 30);
    }


    public void openFrameToDeactivateMembership(){
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setBounds(400,50,400,400);
        tfActivateMembership = new JTextField();
        tfActivateMembership.setBounds(50, 50, 100, 30);
    }

    public  void markAttendanceFrame(){
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setBounds(400,50,400,400);
        tfActivateMembership = new JTextField();
        tfActivateMembership.setBounds(50, 50, 100, 30);
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
        }else if (e.getSource()==buttonActivateMembership){
            openFrameToActivateMembership();
        }else if (e.getSource()==buttonDeactivateMemberShip){
            openFrameToDeactivateMembership();
        } else if ( e.getSource()==buttonMarkAttendance) {
            markAttendanceFrame();

        }
    }
}