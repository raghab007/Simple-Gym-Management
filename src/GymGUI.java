import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GymGUI implements ActionListener {
    ArrayList<GymMember> members = new ArrayList<>();

    private JFrame mainFrame,activateMembershipFrame, deactivateMembershipFrame, markAttendanceFrame,upgradePlanFrame,calculateDiscountFrame,payDueAmountFrame;
    private JButton buttonAddRegularMember, buttonAddPremiumMember, buttonActivateMembership, buttonDeactivateMemberShip, buttonMarkAttendance, buttonUpgradePlan, buttonCalculateDiscount, buttonRevertMember, buttonPayDueAmount, buttonDisplay, buttonClear, buttonSaveToFile, buttonReadFromFile,buttonActivateMembership2,buttonDeactivateMemberShip2, buttonMarkAttendance2, buttonCalculateDiscount2, buttonUpgradePlan2, buttonPayDueAmount2;

    private JRadioButton male, female;
    private JTextField tfId, tfName, tfLocation, tfPhone, tfEmail, tfDOB, tfMembershipStartDate, tfReferralSource, tfTrainersName, tfActivateMembership, tfDeactivateMembership, tfMarkAttendance, tfCalculateDiscount,tfUpgradePlan,tfPayDueAmount,tfDueAmount;
    private JTextField tfRegularPlanPrice; // Non-editable field
    private JComboBox<String> planComboBox, changePlanComboBox; // Plan selection for regular members

    public GymGUI() {
        mainFrame = new JFrame();
        mainFrame.setTitle("Gym Management System");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(1300, 750); // Increased size to fit all components
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
        buttonAddRegularMember.setBackground(new Color(0, 102, 204)); // Blue button
        buttonAddRegularMember.setForeground(Color.WHITE);
        buttonAddRegularMember.addActionListener(this);
        buttonAddRegularMember.setFocusable(false);
        regularPanel.add(buttonAddRegularMember);

        buttonActivateMembership = new JButton("Activate membership");
        buttonActivateMembership.setBounds(1050, 60, 200, 30);
        buttonActivateMembership.setBackground(new Color(54, 231, 40)); // Green button
        buttonActivateMembership.setForeground(Color.black);
        buttonActivateMembership.addActionListener(this);
        buttonActivateMembership.setFocusable(false);
        mainFrame.add(buttonActivateMembership);

        buttonDeactivateMemberShip = new JButton("Deactivate membership");
        buttonDeactivateMemberShip.setBounds(1050, 130, 200, 30);
        buttonDeactivateMemberShip.setBackground(new Color(231, 46, 40)); // Red button
        buttonDeactivateMemberShip.setForeground(Color.white);
        buttonDeactivateMemberShip.addActionListener(this);
        buttonDeactivateMemberShip.setFocusable(false);
        mainFrame.add(buttonDeactivateMemberShip);

        buttonMarkAttendance = new JButton("Mark attendance");
        buttonMarkAttendance.setBounds(1050, 200, 200, 30);
        buttonMarkAttendance.setBackground(new Color(255, 153, 51)); // Orange button
        buttonMarkAttendance.setForeground(Color.WHITE);
        buttonMarkAttendance.addActionListener(this);
        buttonMarkAttendance.setFocusable(false);
        mainFrame.add(buttonMarkAttendance);

        buttonUpgradePlan = new JButton("Upgrade plan");
        buttonUpgradePlan.setBounds(1050, 270, 200, 30);
        buttonUpgradePlan.setBackground(new Color(102, 102, 255)); // Light blue button
        buttonUpgradePlan.setForeground(Color.WHITE);
        buttonUpgradePlan.addActionListener(this);
        buttonUpgradePlan.setFocusable(false);
        mainFrame.add(buttonUpgradePlan);

        buttonCalculateDiscount = new JButton("Calculate Discount");
        buttonCalculateDiscount.setBounds(1050, 340, 200, 30);
        buttonCalculateDiscount.setBackground(new Color(0, 153, 153)); // Teal button
        buttonCalculateDiscount.setForeground(Color.WHITE);
        buttonCalculateDiscount.setFocusable(false);
        buttonCalculateDiscount.addActionListener(this);
        mainFrame.add(buttonCalculateDiscount);


        buttonRevertMember = new JButton("Revert Member");
        buttonRevertMember.setBounds(1050,410,200,30);
        buttonRevertMember.setBackground(new Color(194, 92, 140));
        buttonRevertMember.addActionListener(this);
        buttonRevertMember.setFocusable(false);
        mainFrame.add(buttonRevertMember);


        buttonPayDueAmount = new JButton("Pay due amount");
        buttonPayDueAmount.setBounds(1050,480, 200,30);
        buttonPayDueAmount.setBackground(new Color(14, 227, 168, 82));
        buttonPayDueAmount.addActionListener(this);
        buttonPayDueAmount.setFocusable(false);
        mainFrame.add(buttonPayDueAmount);


        buttonDisplay = new JButton("Display");
        buttonDisplay.setBounds(120,650,200,30);
        buttonDisplay.setBackground(new Color(26, 170, 197));
        mainFrame.add(buttonDisplay);



        buttonClear = new JButton("Clear");
        buttonClear.setBounds(350,650,200,30);
        buttonClear.setBackground(new Color(194, 175, 217));
        mainFrame.add(buttonClear);


        buttonSaveToFile = new JButton("Save to file");
        buttonReadFromFile  = new JButton("Read from file");
        buttonReadFromFile.setBounds(580,650,200,30);
        buttonReadFromFile.setBackground(new Color(200, 30, 89));
        mainFrame.add(buttonSaveToFile);



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
        buttonAddPremiumMember.setBackground(new Color(153, 0, 153)); // Purple button
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

    public void openFrameToActivateMembership() {
         activateMembershipFrame = new JFrame();
        activateMembershipFrame.setLayout(null);
        activateMembershipFrame.setVisible(true);
        activateMembershipFrame.setBounds(400, 50, 400, 400);
        tfActivateMembership = new JTextField();
        tfActivateMembership.setBounds(100, 50, 200, 30);
        tfActivateMembership.setText("Enter id to activate membership");
        buttonActivateMembership2= new JButton("Activate membership");
        buttonActivateMembership2.setBounds(100, 150, 200,30);
        buttonActivateMembership2.addActionListener(this);
        activateMembershipFrame.add(tfActivateMembership);
        activateMembershipFrame.add(buttonActivateMembership2);
    }

    public void activateMembership(){
        String text = tfActivateMembership.getText();
        boolean activated = false;
        try {
            int id = Integer.parseInt(text);
            for (GymMember gymMember:members){
                if (gymMember.getId()==id){
                    gymMember.activateMembership();
                    JOptionPane.showMessageDialog(activateMembershipFrame, "Membership activated", "Success", JOptionPane.INFORMATION_MESSAGE);
                    activated = true;
                    break;
                }
            }
            if (!activated){
                JOptionPane.showMessageDialog(activateMembershipFrame, "User with this id doesn't exists", "Error", JOptionPane.WARNING_MESSAGE);
            }
        }catch (NumberFormatException numberFormatException){
            JOptionPane.showMessageDialog(activateMembershipFrame, "ID must be a number. Please enter a valid ID.", "Error", JOptionPane.WARNING_MESSAGE);

        }

    }


    public  void deactivateMembership(){
        String text = tfDeactivateMembership.getText();
        boolean activated = false;
        try {
            int id = Integer.parseInt(text);
            for (GymMember gymMember:members){
                if (gymMember.getId()==id){
                    gymMember.deactivateMembership();
                    JOptionPane.showMessageDialog(deactivateMembershipFrame, "Membership deactivated", "Success", JOptionPane.INFORMATION_MESSAGE);
                    activated = true;
                    break;
                }
            }
            if (!activated){
                JOptionPane.showMessageDialog(deactivateMembershipFrame, "User with this id doesn't exists", "Error", JOptionPane.WARNING_MESSAGE);
            }
        }catch (NumberFormatException numberFormatException){
            JOptionPane.showMessageDialog(deactivateMembershipFrame, "ID must be a number. Please enter a valid ID.", "Error", JOptionPane.WARNING_MESSAGE);

        }

    }
    public void openFrameToDeactivateMembership() {
        deactivateMembershipFrame = new JFrame();
        deactivateMembershipFrame.setLayout(null);
        deactivateMembershipFrame.setVisible(true);
        deactivateMembershipFrame.setBounds(400, 50, 400, 400);
        tfDeactivateMembership = new JTextField();
        tfDeactivateMembership.setBounds(100, 50, 200, 30);
        tfDeactivateMembership.setText("Enter id to deactivate membership");
        buttonDeactivateMemberShip2= new JButton("Deactivate membership");
        buttonDeactivateMemberShip2.setBounds(100, 150, 200,30);
        buttonDeactivateMemberShip2.addActionListener(this);
        deactivateMembershipFrame.add(tfDeactivateMembership);
        deactivateMembershipFrame.add(buttonDeactivateMemberShip2);
    }

    public void markAttendanceFrame() {
        markAttendanceFrame = new JFrame();
        markAttendanceFrame.setLayout(null);
        markAttendanceFrame.setVisible(true);
        markAttendanceFrame.setBounds(400, 50, 400, 400);
        tfMarkAttendance = new JTextField();
        tfMarkAttendance.setBounds(100, 50, 200, 30);
        tfMarkAttendance.setText("Enter id to activate membership");
        buttonMarkAttendance2= new JButton("Activate membership");
        buttonMarkAttendance2.setBounds(100, 150, 200,30);
        buttonMarkAttendance2.addActionListener(this);
        markAttendanceFrame.add(tfMarkAttendance);
        markAttendanceFrame.add(buttonMarkAttendance2);
    }

    public void upgradePlanFrame(){
        upgradePlanFrame = new JFrame();
        upgradePlanFrame.setLayout(null);
        upgradePlanFrame.setVisible(true);
        upgradePlanFrame.setBounds(400, 50, 400, 400);
        tfUpgradePlan= new JTextField();
        changePlanComboBox = new JComboBox<>(new String[]{"Basic", "Standard", "Deluxe"});
        tfUpgradePlan.setBounds(100, 50, 200, 30);
        tfUpgradePlan.setText("Enter id to upgrade plan");
        changePlanComboBox.setBounds(150,150,100,30);
        buttonUpgradePlan2= new JButton("Calculate Discount");
        buttonUpgradePlan2.setBounds(100, 250, 200,30);
        buttonUpgradePlan2.addActionListener(this);
        upgradePlanFrame.add(tfUpgradePlan);
        upgradePlanFrame.add(changePlanComboBox);
        upgradePlanFrame.add(buttonUpgradePlan2);
    }

    public void calculateDiscountFrame(){
        calculateDiscountFrame = new JFrame();
        calculateDiscountFrame.setLayout(null);
        calculateDiscountFrame.setVisible(true);
        calculateDiscountFrame.setBounds(400, 50, 400, 400);
        tfCalculateDiscount = new JTextField();
        tfCalculateDiscount.setBounds(100, 50, 200, 30);
        tfCalculateDiscount.setText("Enter id to calculate discount");
        buttonCalculateDiscount2= new JButton("Calculate Discount");
        buttonCalculateDiscount2.setBounds(100, 150, 200,30);
        buttonCalculateDiscount2.addActionListener(this);
        calculateDiscountFrame.add(tfCalculateDiscount);
        calculateDiscountFrame.add(buttonCalculateDiscount2);

    }




    public  void payDueAmountFrame(){
        payDueAmountFrame = new JFrame();
        payDueAmountFrame.setLayout(null);
        payDueAmountFrame.setVisible(true);
        payDueAmountFrame.setBounds(400,50,400,400);
        tfPayDueAmount = new JTextField();
        tfPayDueAmount.setBounds(100, 50, 200, 30);
        tfPayDueAmount.setText("Enter id to pay due amount");
        tfDueAmount = new JTextField();
        tfDueAmount.setBounds(100,150,200,30);
        tfDueAmount.setText("Enter Amount to pay");
        buttonPayDueAmount2= new JButton("Pay Amount");
        buttonPayDueAmount2.setBounds(100, 250, 200,30);
        buttonPayDueAmount2.addActionListener(this);
        payDueAmountFrame.add(tfPayDueAmount);
        payDueAmountFrame.add(tfDueAmount);
        payDueAmountFrame.add(buttonPayDueAmount2);
    }

    public void payDueAmount(){

        String idinString = tfPayDueAmount.getText();
        String amountinString = tfDueAmount.getText();

        try{
            int id = Integer.parseInt(idinString);
            int amount = Integer.parseInt(amountinString);
            for (GymMember gymMember:members){
                if (gymMember.getId()==id && gymMember instanceof  PremiumMember){
                    String result = ((PremiumMember) gymMember).payDueAmount(amount);
                    JOptionPane.showMessageDialog(deactivateMembershipFrame, result, "Message", JOptionPane.INFORMATION_MESSAGE);
                   return;

                }
            }
            JOptionPane.showMessageDialog(deactivateMembershipFrame, "Id does not exists", "Message", JOptionPane.WARNING_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(deactivateMembershipFrame, "ID or amount must be a number. Please enter a valid ID.", "Error", JOptionPane.WARNING_MESSAGE);

        }
    }


    public  void  upgradePlan(){
        String text = tfUpgradePlan.getText();
        String plan =(String)changePlanComboBox.getSelectedItem();
        try{
            int id = Integer.parseInt(text);
            GymMember gymMember = null;
            for (GymMember member:members){
                if (member.getId()==id && member instanceof  RegularMember){
                    gymMember = member;
                    break;
                }
            }
            if (gymMember!=null){
                RegularMember regularMember = (RegularMember) gymMember;
                String s = regularMember.upgradePlan(plan);
                JOptionPane.showMessageDialog(deactivateMembershipFrame, s, "message", JOptionPane.INFORMATION_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(deactivateMembershipFrame, "User with this ID doesnot exists. Please enter a valid ID.", "Error", JOptionPane.WARNING_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(deactivateMembershipFrame, "ID must be a number. Please enter a valid ID.", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }


    public void calculateDiscount(){
        String text = tfCalculateDiscount.getText();
        try{
            int id  = Integer.parseInt(text);
            for (GymMember member :members){
                if (member.getId()==id && member instanceof  PremiumMember){
                    PremiumMember premiumMember = (PremiumMember)  member;
                    String s = premiumMember.calculateDiscount();
                    JOptionPane.showMessageDialog(deactivateMembershipFrame, s, "Message", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            }
            JOptionPane.showMessageDialog(deactivateMembershipFrame, "User with this id doesnot exists", "Message", JOptionPane.INFORMATION_MESSAGE);
        }catch (NumberFormatException exception){
            JOptionPane.showMessageDialog(deactivateMembershipFrame, "ID must be a number. Please enter a valid ID.", "Error", JOptionPane.WARNING_MESSAGE);
        }
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
        } else if (e.getSource() == buttonActivateMembership) {
            openFrameToActivateMembership();
        } else if (e.getSource() == buttonDeactivateMemberShip) {
            openFrameToDeactivateMembership();
        } else if (e.getSource() == buttonMarkAttendance) {
            markAttendanceFrame();
        }else if (e.getSource()==buttonActivateMembership2){
            activateMembership();
        }else if (e.getSource()==buttonDeactivateMemberShip2){
            deactivateMembership();
        }else if (e.getSource()==buttonCalculateDiscount){
            calculateDiscountFrame();
        }else if (e.getSource()==buttonUpgradePlan){
            upgradePlanFrame();
        } else if (e.getSource()==buttonUpgradePlan2) {
            upgradePlan();

        }else  if (e.getSource()==buttonCalculateDiscount2){
            calculateDiscount();
        }else if (e.getSource()==buttonPayDueAmount){
            payDueAmountFrame();
        }else if (e.getSource()==buttonPayDueAmount2){
            payDueAmount();
        }
    }
}