import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.io.*;

public class GymGUI {
    private JFrame frame;
    private ArrayList<GymMember> members = new ArrayList<>();
    private JTabbedPane tabbedPane;
    
    // Regular Member Components
    private JTextField regIdField, regNameField, regLocationField, regPhoneField, regEmailField, regReferralField;
    private JRadioButton regMaleRadio, regFemaleRadio;
    private ButtonGroup regGenderGroup;
    private JComboBox<String> regDobYear, regDobMonth, regDobDay, regStartYear, regStartMonth, regStartDay, regPlanCombo;
    private JCheckBox regTermsCheck;
    private JTextField regPriceField;
    
    // Premium Member Components
    private JTextField premIdField, premNameField, premLocationField, premPhoneField, premEmailField, premTrainerField;
    private JRadioButton premMaleRadio, premFemaleRadio;
    private ButtonGroup premGenderGroup;
    private JComboBox<String> premDobYear, premDobMonth, premDobDay, premStartYear, premStartMonth, premStartDay;
    private JCheckBox premTermsCheck;
    private JTextField premChargeField, premDiscountField, premPaidAmountField;
    
    private JTextArea outputArea;

    public GymGUI() {
        frame = new JFrame("Gym Management System");
        frame.setSize(1000, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        
        frame.getContentPane().setBackground(new Color(245, 245, 245)); // Light gray background
        
        // Add header
        JLabel header = new JLabel("Gym Management System", SwingConstants.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 20));
        header.setBackground(new Color(245, 245, 245));
        header.setOpaque(true);
        header.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
        frame.add(header, BorderLayout.NORTH);
        
        tabbedPane = new JTabbedPane();
        tabbedPane.setFont(new Font("Arial", Font.PLAIN, 14));
        tabbedPane.addTab("Regular Members", createRegularMemberPanel());
        tabbedPane.addTab("Premium Members", createPremiumMemberPanel());
        
        outputArea = new JTextArea(5, 50);
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Arial", Font.PLAIN, 12));
        JScrollPane outputScrollPane = new JScrollPane(outputArea);
        outputScrollPane.setBorder(BorderFactory.createTitledBorder("Output"));
        
        // Create JSplitPane to make output section adjustable
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, tabbedPane, outputScrollPane);
        splitPane.setOneTouchExpandable(true);
        splitPane.setDividerSize(10);
        splitPane.setResizeWeight(0.8); // 80% for tabs, 20% for output
        splitPane.setDividerLocation(0.8); // Initial divider at 80% of height
        
        frame.add(splitPane, BorderLayout.CENTER);
        
        frame.setVisible(true);
    }

    private JPanel createRegularMemberPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBackground(new Color(245, 245, 245)); // Light gray background
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JLabel title = new JLabel("Regular Member Management", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
        panel.add(title, BorderLayout.NORTH);
        
        // Create content panel to hold form and buttons
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBackground(new Color(245, 245, 245));
        
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(Color.WHITE); // White background for form
        formPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200)),
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Font labelFont = new Font("Arial", Font.BOLD, 14);
        Font fieldFont = new Font("Arial", Font.PLAIN, 14);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        JLabel regPersonalInfo = new JLabel("Personal Information");
        regPersonalInfo.setFont(new Font("Arial", Font.BOLD, 16));
        formPanel.add(regPersonalInfo, gbc);
        
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        JLabel regId = new JLabel("Member ID:");
        regId.setFont(labelFont);
        formPanel.add(regId, gbc);
        gbc.gridx = 1;
        regIdField = new JTextField(15);
        regIdField.setFont(fieldFont);
        regIdField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        formPanel.add(regIdField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel regName = new JLabel("Name:");
        regName.setFont(labelFont);
        formPanel.add(regName, gbc);
        gbc.gridx = 1;
        regNameField = new JTextField(15);
        regNameField.setFont(fieldFont);
        regNameField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        formPanel.add(regNameField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        JLabel regLocation = new JLabel("Location:");
        regLocation.setFont(labelFont);
        formPanel.add(regLocation, gbc);
        gbc.gridx = 1;
        regLocationField = new JTextField(15);
        regLocationField.setFont(fieldFont);
        regLocationField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        formPanel.add(regLocationField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        JLabel regPhone = new JLabel("Phone:");
        regPhone.setFont(labelFont);
        formPanel.add(regPhone, gbc);
        gbc.gridx = 1;
        regPhoneField = new JTextField(15);
        regPhoneField.setFont(fieldFont);
        regPhoneField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        formPanel.add(regPhoneField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        JLabel regEmail = new JLabel("Email:");
        regEmail.setFont(labelFont);
        formPanel.add(regEmail, gbc);
        gbc.gridx = 1;
        regEmailField = new JTextField(15);
        regEmailField.setFont(fieldFont);
        regEmailField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        formPanel.add(regEmailField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 6;
        JLabel regGender = new JLabel("Gender:");
        regGender.setFont(labelFont);
        formPanel.add(regGender, gbc);
        gbc.gridx = 1;
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        genderPanel.setBackground(Color.WHITE);
        regMaleRadio = new JRadioButton("Male");
        regFemaleRadio = new JRadioButton("Female");
        regMaleRadio.setFont(fieldFont);
        regFemaleRadio.setFont(fieldFont);
        regMaleRadio.setBackground(Color.WHITE);
        regFemaleRadio.setBackground(Color.WHITE);
        regGenderGroup = new ButtonGroup();
        regGenderGroup.add(regMaleRadio);
        regGenderGroup.add(regFemaleRadio);
        genderPanel.add(regMaleRadio);
        genderPanel.add(regFemaleRadio);
        formPanel.add(genderPanel, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 7;
        JLabel regDOB = new JLabel("DOB:");
        regDOB.setFont(labelFont);
        formPanel.add(regDOB, gbc);
        gbc.gridx = 1;
        JPanel dobPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        dobPanel.setBackground(Color.WHITE);
        String[] years = generateYears(1950, 2025);
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        String[] days = generateDays(1, 31);
        
        regDobYear = new JComboBox<>(years);
        regDobMonth = new JComboBox<>(months);
        regDobDay = new JComboBox<>(days);
        regDobYear.setFont(fieldFont);
        regDobMonth.setFont(fieldFont);
        regDobDay.setFont(fieldFont);
        regDobYear.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        regDobMonth.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        regDobDay.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        dobPanel.add(regDobYear);
        dobPanel.add(regDobMonth);
        dobPanel.add(regDobDay);
        formPanel.add(dobPanel, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 8;
        JLabel regMembershipStartDate = new JLabel("Membership Start Date:");
        regMembershipStartDate.setFont(labelFont);
        formPanel.add(regMembershipStartDate, gbc);
        gbc.gridx = 1;
        JPanel startDatePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        startDatePanel.setBackground(Color.WHITE);
        regStartYear = new JComboBox<>(years);
        regStartMonth = new JComboBox<>(months);
        regStartDay = new JComboBox<>(days);
        regStartYear.setFont(fieldFont);
        regStartMonth.setFont(fieldFont);
        regStartDay.setFont(fieldFont);
        regStartYear.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        regStartMonth.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        regStartDay.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        startDatePanel.add(regStartYear);
        startDatePanel.add(regStartMonth);
        startDatePanel.add(regStartDay);
        formPanel.add(startDatePanel, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 9;
        JLabel regReferralSource = new JLabel("Referral Source:");
        regReferralSource.setFont(labelFont);
        formPanel.add(regReferralSource, gbc);
        gbc.gridx = 1;
        regReferralField = new JTextField(15);
        regReferralField.setFont(fieldFont);
        regReferralField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        formPanel.add(regReferralField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 10;
        JLabel regPlan = new JLabel("Plan:");
        regPlan.setFont(labelFont);
        formPanel.add(regPlan, gbc);
        gbc.gridx = 1;
        regPlanCombo = new JComboBox<>(new String[]{"Basic", "Standard", "Deluxe"});
        regPlanCombo.setFont(fieldFont);
        regPlanCombo.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        formPanel.add(regPlanCombo, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 11;
        JLabel regPriceLabel = new JLabel("Regular Plan Price:");
        regPriceLabel.setFont(labelFont);
        formPanel.add(regPriceLabel, gbc);
        gbc.gridx = 1;
        regPriceField = new JTextField("6500");
        regPriceField.setFont(fieldFont);
        regPriceField.setEditable(false);
        regPriceField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        formPanel.add(regPriceField, gbc);
        
        // Add ItemListener to update price based on plan selection
        regPlanCombo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selectedPlan = (String) regPlanCombo.getSelectedItem();
                    switch (selectedPlan) {
                        case "Basic":
                            regPriceField.setText("6500");
                            break;
                        case "Standard":
                            regPriceField.setText("12500");
                            break;
                        case "Deluxe":
                            regPriceField.setText("18500");
                            break;
                    }
                }
            }
        });
        
        gbc.gridx = 0;
        gbc.gridy = 12;
        gbc.gridwidth = 2;
        regTermsCheck = new JCheckBox("I agree to the terms and conditions");
        regTermsCheck.setFont(labelFont);
        regTermsCheck.setBackground(Color.WHITE);
        formPanel.add(regTermsCheck, gbc);

        JPanel buttonPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        buttonPanel.setBackground(new Color(245, 245, 245));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        Font buttonFont = new Font("Arial", Font.PLAIN, 14);
        
        JButton addRegularBtn = new JButton("Add Regular Member");
        styleButton(addRegularBtn, buttonFont);
        addRegularBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(regIdField.getText().trim());
                    if (isDuplicateId(id)) {
                        showError("Member ID already exists");
                        return;
                    }
                    
                    String name = regNameField.getText().trim();
                    String location = regLocationField.getText().trim();
                    String phone = regPhoneField.getText().trim();
                    String email = regEmailField.getText().trim();
                    String referralSource = regReferralField.getText().trim();
                    
                    if (name.isEmpty() || location.isEmpty() || phone.isEmpty() || email.isEmpty()) {
                        showError("Please fill all required fields");
                        return;
                    }
                    
                    String gender = regMaleRadio.isSelected() ? "Male" : regFemaleRadio.isSelected() ? "Female" : "";
                    if (gender.isEmpty()) {
                        showError("Please select gender");
                        return;
                    }
                    
                    String dob = regDobDay.getSelectedItem() + "-" + 
                                regDobMonth.getSelectedItem() + "-" + 
                                regDobYear.getSelectedItem();
                    String startDate = regStartDay.getSelectedItem() + "-" + 
                                     regStartMonth.getSelectedItem() + "-" + 
                                     regStartYear.getSelectedItem();
                    
                    if (!regTermsCheck.isSelected()) {
                        showError("Please agree to terms and conditions");
                        return;
                    }
                    
                    RegularMember member = new RegularMember(id, name, location, phone, email, 
                                          gender, dob, startDate, referralSource);
                    String selectedPlan = (String) regPlanCombo.getSelectedItem();
                    if (!selectedPlan.equalsIgnoreCase("Basic")) {
                        String result = member.upgradePlan(selectedPlan.toLowerCase());
                        if (result.contains("Invalid")) {
                            showError(result);
                            return;
                        }
                        regPriceField.setText(String.valueOf(member.getPrice()));
                    }
                    
                    members.add(member);
                    showSuccess("Regular member added successfully!");
                    clearRegularFields();
                    
                } catch (NumberFormatException ex) {
                    showError("Please enter a valid ID number");
                } catch (Exception ex) {
                    showError("Error adding member: " + ex.getMessage());
                }
            }
        });

        JButton displayRegularBtn = new JButton("Display Member");
        styleButton(displayRegularBtn, buttonFont);
        displayRegularBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(regIdField.getText().trim());
                    RegularMember member = findRegularMember(id);
                    
                    if (member != null) {
                        outputArea.setText("");
                        StringBuilder info = new StringBuilder("REGULAR MEMBER\n");
                        info.append("ID: ").append(member.getId()).append("\n");
                        info.append("Name: ").append(member.getName()).append("\n");
                        info.append("Location: ").append(member.getLocation()).append("\n");
                        info.append("Phone: ").append(member.getPhone()).append("\n");
                        info.append("Email: ").append(member.getEmail()).append("\n");
                        info.append("Gender: ").append(member.getGender()).append("\n");
                        info.append("DOB: ").append(member.getDOB()).append("\n");
                        info.append("Membership Start: ").append(member.getMembershipStartDate()).append("\n");
                        info.append("Referral: ").append(member.getReferralSource()).append("\n");
                        info.append("Plan: ").append(member.getPlan()).append("\n");
                        info.append("Price: ").append(member.getPrice()).append("\n");
                        info.append("Attendance: ").append(member.getAttendance()).append("/").append(member.getAttendanceLimit()).append("\n");
                        info.append("Loyalty Points: ").append(member.getLoyaltyPoints()).append("\n");
                        info.append("Status: ").append(member.isActiveStatus() ? "Active" : "Inactive").append("\n");
                        String removalReason = member.getRemovalReason();
                        if (!removalReason.isEmpty()) {
                            info.append("Removal Reason: ").append(removalReason).append("\n");
                        }
                        outputArea.setText(info.toString());
                        showSuccess("Member details displayed successfully!");
                    } else {
                        showError("Regular member not found with ID: " + id);
                    }
                } catch (NumberFormatException ex) {
                    showError("Please enter a valid ID number");
                }
            }
        });

        JButton markAttendanceBtn = new JButton("Mark Attendance");
        styleButton(markAttendanceBtn, buttonFont);
        markAttendanceBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(regIdField.getText().trim());
                    RegularMember member = findRegularMember(id);
                    
                    if (member != null) {
                        member.markAttendance();
                        showSuccess("Attendance marked for member ID: " + id + 
                                  "\nAttendance: " + member.getAttendance() + 
                                  "\nLoyalty Points: " + member.getLoyaltyPoints());
                    } else {
                        showError("Regular member not found with ID: " + id);
                    }
                } catch (NumberFormatException ex) {
                    showError("Please enter a valid ID number");
                }
            }
        });

        JButton upgradePlanBtn = new JButton("Upgrade Plan");
        styleButton(upgradePlanBtn, buttonFont);
        upgradePlanBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(regIdField.getText().trim());
                    RegularMember member = findRegularMember(id);
                    
                    if (member != null) {
                        if (member.isActiveStatus()) {
                            String newPlan = (String) regPlanCombo.getSelectedItem();
                            String result = member.upgradePlan(newPlan.toLowerCase());
                            regPriceField.setText(String.valueOf(member.getPrice()));
                            showSuccess(result);
                        } else {
                            showError("Cannot upgrade plan - membership is not active");
                        }
                    } else {
                        showError("Regular member not found with ID: " + id);
                    }
                } catch (NumberFormatException ex) {
                    showError("Please enter a valid ID number");
                }
            }
        });

        JButton revertBtn = new JButton("Revert Regular Member");
        styleButton(revertBtn, buttonFont);
        revertBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(regIdField.getText().trim());
                    RegularMember member = findRegularMember(id);
                    
                    if (member != null) {
                        String reason = JOptionPane.showInputDialog(frame, "Enter reason for reverting:");
                        if (reason != null && !reason.trim().isEmpty()) {
                            member.revertRegularMember(reason);
                            regPriceField.setText("6500");
                            showSuccess("Regular member reverted successfully");
                        } else {
                            showError("Please provide a valid reason");
                        }
                    } else {
                        showError("Regular member not found with ID: " + id);
                    }
                } catch (NumberFormatException ex) {
                    showError("Please enter a valid ID number");
                }
            }
        });

        JButton activateBtn = new JButton("Activate Membership");
        styleButton(activateBtn, buttonFont);
        activateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(regIdField.getText().trim());
                    RegularMember member = findRegularMember(id);
                    
                    if (member != null) {
                        member.activateMembership();
                        showSuccess("Membership activated for ID: " + id);
                    } else {
                        showError("Member not found with ID: " + id);
                    }
                } catch (NumberFormatException ex) {
                    showError("Please enter a valid ID number");
                }
            }
        });

        JButton deactivateBtn = new JButton("Deactivate Membership");
        styleButton(deactivateBtn, buttonFont);
        deactivateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(regIdField.getText().trim());
                    RegularMember member = findRegularMember(id);
                    
                    if (member != null) {
                        member.deactivateMembership();
                        showSuccess("Membership deactivated for ID: " + id);
                    } else {
                        showError("Member not found with ID: " + id);
                    }
                } catch (NumberFormatException ex) {
                    showError("Please enter a valid ID number");
                }
            }
        });

        JButton clearBtn = new JButton("Clear");
        styleButton(clearBtn, buttonFont);
        clearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearRegularFields();
                showSuccess("Fields cleared successfully");
            }
        });

        JButton saveToFileBtn = new JButton("Save to File");
        styleButton(saveToFileBtn, buttonFont);
        saveToFileBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (PrintWriter writer = new PrintWriter(new FileWriter("MemberDetails.txt"))) {
                    writer.println(String.format("%-5s %-15s %-15s %-15s %-25s %-20s %-10s %-10s %-10s %-15s %-10s", 
                        "ID", "Name", "Location", "Phone", "Email", "Membership Start", "Plan", "Price", 
                        "Attendance", "Loyalty Points", "Status"));
                    
                    for (GymMember member : members) {
                        if (member instanceof RegularMember rm) {
                            writer.println(String.format("%-5d %-15s %-15s %-15s %-25s %-20s %-10s %-10.2f %-10d %-15.2f %-10s", 
                                rm.getId(), rm.getName(), rm.getLocation(), rm.getPhone(), rm.getEmail(),
                                rm.getMembershipStartDate(), rm.getPlan(), rm.getPrice(), rm.getAttendance(),
                                rm.getLoyaltyPoints(), rm.isActiveStatus() ? "Active" : "Inactive"));
                        } else if (member instanceof PremiumMember pm) {
                            writer.println(String.format("%-5d %-15s %-15s %-15s %-25s %-20s %-10s %-10.2f %-10d %-15.2f %-10s", 
                                pm.getId(), pm.getName(), pm.getLocation(), pm.getPhone(), pm.getEmail(),
                                pm.getMembershipStartDate(), "Premium", pm.getPremiumCharge(), pm.getAttendance(),
                                pm.getLoyaltyPoints(), pm.isActiveStatus() ? "Active" : "Inactive"));
                        }
                    }
                    showSuccess("Member details saved to file successfully!");
                } catch (IOException ex) {
                    showError("Error saving to file: " + ex.getMessage());
                }
            }
        });

        JButton readFromFileBtn = new JButton("Read from File");
        styleButton(readFromFileBtn, buttonFont);
        readFromFileBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (BufferedReader reader = new BufferedReader(new FileReader("MemberDetails.txt"))) {
                    outputArea.setText("");
                    String line;
                    while ((line = reader.readLine()) != null) {
                        outputArea.append(line + "\n");
                    }
                    showSuccess("Member details loaded from file successfully!");
                } catch (FileNotFoundException ex) {
                    showError("File not found. Please save data first.");
                } catch (IOException ex) {
                    showError("Error reading from file: " + ex.getMessage());
                }
            }
        });

        buttonPanel.add(addRegularBtn);
        buttonPanel.add(displayRegularBtn);
        buttonPanel.add(markAttendanceBtn);
        buttonPanel.add(upgradePlanBtn);
        buttonPanel.add(revertBtn);
        buttonPanel.add(activateBtn);
        buttonPanel.add(deactivateBtn);
        buttonPanel.add(clearBtn);
        buttonPanel.add(saveToFileBtn);
        buttonPanel.add(readFromFileBtn);

        // Add form and button panels to content panel
        contentPanel.add(formPanel);
        contentPanel.add(Box.createVerticalStrut(10)); // Spacer
        contentPanel.add(buttonPanel);
        
        // Wrap content panel in scroll pane
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        
        panel.add(scrollPane, BorderLayout.CENTER);
        
        return panel;
    }

    private JPanel createPremiumMemberPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBackground(new Color(245, 245, 245)); // Light gray background
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JLabel title = new JLabel("Premium Member Management", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
        panel.add(title, BorderLayout.NORTH);
        
        // Create content panel to hold form and buttons
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBackground(new Color(245, 245, 245));
        
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(Color.WHITE); // White background for form
        formPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200)),
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Font labelFont = new Font("Arial", Font.BOLD, 14);
        Font fieldFont = new Font("Arial", Font.PLAIN, 14);

        String[] years = generateYears(1950, 2025);
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        String[] days = generateDays(1, 31);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        JLabel premPersonalInfo = new JLabel("Personal Information");
        premPersonalInfo.setFont(new Font("Arial", Font.BOLD, 16));
        formPanel.add(premPersonalInfo, gbc);
        
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        JLabel premId = new JLabel("Member ID:");
        premId.setFont(labelFont);
        formPanel.add(premId, gbc);
        gbc.gridx = 1;
        premIdField = new JTextField(15);
        premIdField.setFont(fieldFont);
        premIdField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        formPanel.add(premIdField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel premName = new JLabel("Name:");
        premName.setFont(labelFont);
        formPanel.add(premName, gbc);
        gbc.gridx = 1;
        premNameField = new JTextField(15);
        premNameField.setFont(fieldFont);
        premNameField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        formPanel.add(premNameField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        JLabel premLocation = new JLabel("Location:");
        premLocation.setFont(labelFont);
        formPanel.add(premLocation, gbc);
        gbc.gridx = 1;
        premLocationField = new JTextField(15);
        premLocationField.setFont(fieldFont);
        premLocationField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        formPanel.add(premLocationField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        JLabel premPhone = new JLabel("Phone:");
        premPhone.setFont(labelFont);
        formPanel.add(premPhone, gbc);
        gbc.gridx = 1;
        premPhoneField = new JTextField(15);
        premPhoneField.setFont(fieldFont);
        premPhoneField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        formPanel.add(premPhoneField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        JLabel premEmail = new JLabel("Email:");
        premEmail.setFont(labelFont);
        formPanel.add(premEmail, gbc);
        gbc.gridx = 1;
        premEmailField = new JTextField(15);
        premEmailField.setFont(fieldFont);
        premEmailField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        formPanel.add(premEmailField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 6;
        JLabel premGender = new JLabel("Gender:");
        premGender.setFont(labelFont);
        formPanel.add(premGender, gbc);
        gbc.gridx = 1;
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        genderPanel.setBackground(Color.WHITE);
        premMaleRadio = new JRadioButton("Male");
        premFemaleRadio = new JRadioButton("Female");
        premMaleRadio.setFont(fieldFont);
        premFemaleRadio.setFont(fieldFont);
        premMaleRadio.setBackground(Color.WHITE);
        premFemaleRadio.setBackground(Color.WHITE);
        premGenderGroup = new ButtonGroup();
        premGenderGroup.add(premMaleRadio);
        premGenderGroup.add(premFemaleRadio);
        genderPanel.add(premMaleRadio);
        genderPanel.add(premFemaleRadio);
        formPanel.add(genderPanel, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 7;
        JLabel premDOB = new JLabel("DOB:");
        premDOB.setFont(labelFont);
        formPanel.add(premDOB, gbc);
        gbc.gridx = 1;
        JPanel dobPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        dobPanel.setBackground(Color.WHITE);
        premDobYear = new JComboBox<>(years);
        premDobMonth = new JComboBox<>(months);
        premDobDay = new JComboBox<>(days);
        premDobYear.setFont(fieldFont);
        premDobMonth.setFont(fieldFont);
        premDobDay.setFont(fieldFont);
        premDobYear.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        premDobMonth.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        premDobDay.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        dobPanel.add(premDobYear);
        dobPanel.add(premDobMonth);
        dobPanel.add(premDobDay);
        formPanel.add(dobPanel, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 8;
        JLabel premMembershipStartDate = new JLabel("Membership Start Date:");
        premMembershipStartDate.setFont(labelFont);
        formPanel.add(premMembershipStartDate, gbc);
        gbc.gridx = 1;
        JPanel startDatePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        startDatePanel.setBackground(Color.WHITE);
        premStartYear = new JComboBox<>(years);
        premStartMonth = new JComboBox<>(months);
        premStartDay = new JComboBox<>(days);
        premStartYear.setFont(fieldFont);
        premStartMonth.setFont(fieldFont);
        premStartDay.setFont(fieldFont);
        premStartYear.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        premStartMonth.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        premStartDay.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        startDatePanel.add(premStartYear);
        startDatePanel.add(premStartMonth);
        startDatePanel.add(premStartDay);
        formPanel.add(startDatePanel, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 9;
        JLabel premPersonalTrainer = new JLabel("Personal Trainer:");
        premPersonalTrainer.setFont(labelFont);
        formPanel.add(premPersonalTrainer, gbc);
        gbc.gridx = 1;
        premTrainerField = new JTextField(15);
        premTrainerField.setFont(fieldFont);
        premTrainerField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        formPanel.add(premTrainerField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 10;
        JLabel premChargeLabel = new JLabel("Premium Plan Charge:");
        premChargeLabel.setFont(labelFont);
        formPanel.add(premChargeLabel, gbc);
        gbc.gridx = 1;
        premChargeField = new JTextField("50000");
        premChargeField.setFont(fieldFont);
        premChargeField.setEditable(false);
        premChargeField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        formPanel.add(premChargeField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 11;
        JLabel premDiscountLabel = new JLabel("Discount Amount:");
        premDiscountLabel.setFont(labelFont);
        formPanel.add(premDiscountLabel, gbc);
        gbc.gridx = 1;
        premDiscountField = new JTextField("0");
        premDiscountField.setFont(fieldFont);
        premDiscountField.setEditable(false);
        premDiscountField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        formPanel.add(premDiscountField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 12;
        JLabel premPaidAmountLabel = new JLabel("Paid Amount:");
        premPaidAmountLabel.setFont(labelFont);
        formPanel.add(premPaidAmountLabel, gbc);
        gbc.gridx = 1;
        premPaidAmountField = new JTextField(15);
        premPaidAmountField.setFont(fieldFont);
        premPaidAmountField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        formPanel.add(premPaidAmountField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 13;
        gbc.gridwidth = 2;
        premTermsCheck = new JCheckBox("I agree to the terms and conditions");
        premTermsCheck.setFont(labelFont);
        premTermsCheck.setBackground(Color.WHITE);
        formPanel.add(premTermsCheck, gbc);

        JPanel buttonPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        buttonPanel.setBackground(new Color(245, 245, 245));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        Font buttonFont = new Font("Arial", Font.PLAIN, 14);
        
        JButton addPremiumBtn = new JButton("Add Premium Member");
        styleButton(addPremiumBtn, buttonFont);
        addPremiumBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(premIdField.getText().trim());
                    if (isDuplicateId(id)) {
                        showError("Member ID already exists");
                        return;
                    }
                    
                    String name = premNameField.getText().trim();
                    String location = premLocationField.getText().trim();
                    String phone = premPhoneField.getText().trim();
                    String email = premEmailField.getText().trim();
                    String personalTrainer = premTrainerField.getText().trim();
                    
                    if (name.isEmpty() || location.isEmpty() || phone.isEmpty() || email.isEmpty()) {
                        showError("Please fill all required fields");
                        return;
                    }
                    
                    String gender = premMaleRadio.isSelected() ? "Male" : premFemaleRadio.isSelected() ? "Female" : "";
                    if (gender.isEmpty()) {
                        showError("Please select gender");
                        return;
                    }
                    
                    String dob = premDobDay.getSelectedItem() + "-" + 
                                premDobMonth.getSelectedItem() + "-" + 
                                premDobYear.getSelectedItem();
                    String startDate = premStartDay.getSelectedItem() + "-" + 
                                     premStartMonth.getSelectedItem() + "-" + 
                                     premStartYear.getSelectedItem();
                    
                    if (!premTermsCheck.isSelected()) {
                        showError("Please agree to terms and conditions");
                        return;
                    }
                    
                    PremiumMember member = new PremiumMember(id, name, location, phone, email, 
                                          gender, dob, startDate, personalTrainer);
                    members.add(member);
                    showSuccess("Premium member added successfully!");
                    clearPremiumFields();
                    
                } catch (NumberFormatException ex) {
                    showError("Please enter a valid ID number");
                } catch (Exception ex) {
                    showError("Error adding member: " + ex.getMessage());
                }
            }
        });

        JButton makePaymentBtn = new JButton("Pay Due Amount");
        styleButton(makePaymentBtn, buttonFont);
        makePaymentBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(premIdField.getText().trim());
                    PremiumMember member = findPremiumMember(id);
                    
                    if (member != null) {
                        if (!member.isActiveStatus()) {
                            showError("Cannot process payment - membership is not active");
                            return;
                        }
                        String amountStr = premPaidAmountField.getText().trim();
                        if (amountStr.isEmpty()) {
                            showError("Please enter a payment amount");
                            return;
                        }
                        double amount = Double.parseDouble(amountStr);
                        if (amount <= 0) {
                            showError("Payment amount must be greater than zero");
                            return;
                        }
                        String result = member.payDueAmount(amount);
                        if (member.isFullPayment()) {
                            member.calculateDiscount();
                            premDiscountField.setText(String.format("%.2f", member.getDiscountAmount()));
                            showSuccess(result + "\nDiscount applied: " + member.getDiscountAmount());
                        } else {
                            premDiscountField.setText("0.00");
                            showSuccess(result);
                        }
                    } else {
                        showError("Premium member not found with ID: " + id);
                    }
                } catch (NumberFormatException ex) {
                    showError("Please enter valid numbers for ID and amount");
                } catch (Exception ex) {
                    showError("Error processing payment: " + ex.getMessage());
                }
            }
        });

        JButton displayPremiumBtn = new JButton("Display Member");
        styleButton(displayPremiumBtn, buttonFont);
        displayPremiumBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(premIdField.getText().trim());
                    PremiumMember member = findPremiumMember(id);
                    
                    if (member != null) {
                        outputArea.setText("");
                        StringBuilder info = new StringBuilder("PREMIUM MEMBER\n");
                        info.append("ID: ").append(member.getId()).append("\n");
                        info.append("Name: ").append(member.getName()).append("\n");
                        info.append("Location: ").append(member.getLocation()).append("\n");
                        info.append("Phone: ").append(member.getPhone()).append("\n");
                        info.append("Email: ").append(member.getEmail()).append("\n");
                        info.append("Gender: ").append(member.getGender()).append("\n");
                        info.append("DOB: ").append(member.getDOB()).append("\n");
                        info.append("Membership Start: ").append(member.getMembershipStartDate()).append("\n");
                        info.append("Personal Trainer: ").append(member.getPersonalTrainer()).append("\n");
                        info.append("Premium Charge: ").append(member.getPremiumCharge()).append("\n");
                        info.append("Paid Amount: ").append(member.getPaidAmount()).append("\n");
                        info.append("Remaining: ").append(member.getPremiumCharge() - member.getPaidAmount()).append("\n");
                        info.append("Full Payment: ").append(member.isFullPayment() ? "Yes" : "No").append("\n");
                        if (member.isFullPayment()) {
                            info.append("Discount: ").append(member.getDiscountAmount()).append("\n");
                        }
                        String removalReason = member.getRemovalReason();
                        if (removalReason != null && !removalReason.isEmpty()) {
                            info.append("Removal Reason: ").append(removalReason).append("\n");
                        }
                        info.append("Attendance: ").append(member.getAttendance()).append("\n");
                        info.append("Loyalty Points: ").append(member.getLoyaltyPoints()).append("\n");
                        info.append("Status: ").append(member.isActiveStatus() ? "Active" : "Inactive").append("\n");
                        outputArea.setText(info.toString());
                        showSuccess("Member details displayed successfully!");
                    } else {
                        showError("Premium member not found with ID: " + id);
                    }
                } catch (NumberFormatException ex) {
                    showError("Please enter a valid ID number");
                }
            }
        });

        JButton revertBtn = new JButton("Revert Premium Member");
        styleButton(revertBtn, buttonFont);
        revertBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(premIdField.getText().trim());
                    PremiumMember member = findPremiumMember(id);
                    
                    if (member != null) {
                        String reason = JOptionPane.showInputDialog(frame, "Enter reason for reverting:");
                        if (reason != null && !reason.trim().isEmpty()) {
                            member.revertPremiumMember(reason);
                            premDiscountField.setText("0.00");
                            premPaidAmountField.setText("");
                            showSuccess("Premium member reverted successfully");
                        } else {
                            showError("Please provide a valid reason");
                        }
                    } else {
                        showError("Premium member not found with ID: " + id);
                    }
                } catch (NumberFormatException ex) {
                    showError("Please enter a valid ID number");
                }
            }
        });

        JButton calculateDiscountBtn = new JButton("Calculate Discount");
        styleButton(calculateDiscountBtn, buttonFont);
        calculateDiscountBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(premIdField.getText().trim());
                    PremiumMember member = findPremiumMember(id);
                    
                    if (member != null) {
                        if (!member.isActiveStatus()) {
                            showError("Cannot calculate discount - membership is not active");
                            return;
                        }
                        if (member.isFullPayment()) {
                            member.calculateDiscount();
                            premDiscountField.setText(String.format("%.2f", member.getDiscountAmount()));
                            showSuccess("Discount calculated: " + member.getDiscountAmount());
                        } else {
                            showError("Full payment not made yet - cannot calculate discount");
                        }
                    } else {
                        showError("Premium member not found with ID: " + id);
                    }
                } catch (NumberFormatException ex) {
                    showError("Please enter a valid ID number");
                }
            }
        });

        JButton activateBtn = new JButton("Activate Membership");
        styleButton(activateBtn, buttonFont);
        activateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(premIdField.getText().trim());
                    PremiumMember member = findPremiumMember(id);
                    
                    if (member != null) {
                        member.activateMembership();
                        showSuccess("Membership activated for ID: " + id);
                    } else {
                        showError("Member not found with ID: " + id);
                    }
                } catch (NumberFormatException ex) {
                    showError("Please enter a valid ID number");
                }
            }
        });

        JButton deactivateBtn = new JButton("Deactivate Membership");
        styleButton(deactivateBtn, buttonFont);
        deactivateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(premIdField.getText().trim());
                    PremiumMember member = findPremiumMember(id);
                    
                    if (member != null) {
                        member.deactivateMembership();
                        showSuccess("Membership deactivated for ID: " + id);
                    } else {
                        showError("Member not found with ID: " + id);
                    }
                } catch (NumberFormatException ex) {
                    showError("Please enter a valid ID number");
                }
            }
        });

        JButton markAttendanceBtn = new JButton("Mark Attendance");
        styleButton(markAttendanceBtn, buttonFont);
        markAttendanceBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(premIdField.getText().trim());
                    PremiumMember member = findPremiumMember(id);
                    
                    if (member != null) {
                        if (member.isActiveStatus()) {
                            member.markAttendance();
                            showSuccess("Attendance marked for member ID: " + id + 
                                      "\nAttendance: " + member.getAttendance() + 
                                      "\nLoyalty Points: " + member.getLoyaltyPoints());
                        } else {
                            showError("Cannot mark attendance - membership is not active");
                        }
                    } else {
                        showError("Premium member not found with ID: " + id);
                    }
                } catch (NumberFormatException ex) {
                    showError("Please enter a valid ID number");
                }
            }
        });

        JButton saveToFileBtn = new JButton("Save to File");
        styleButton(saveToFileBtn, buttonFont);
        saveToFileBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (PrintWriter writer = new PrintWriter(new FileWriter("MemberDetails.txt"))) {
                    writer.println(String.format("%-5s %-15s %-15s %-15s %-25s %-20s %-10s %-10s %-10s %-15s %-10s", 
                        "ID", "Name", "Location", "Phone", "Email", "Membership Start", "Plan", "Price", 
                        "Attendance", "Loyalty Points", "Status"));
                    
                    for (GymMember member : members) {
                        if (member instanceof PremiumMember pm) {
                            writer.println(String.format("%-5d %-15s %-15s %-15s %-25s %-20s %-10s %-10.2f %-10d %-15.2f %-10s", 
                                pm.getId(), pm.getName(), pm.getLocation(), pm.getPhone(), pm.getEmail(),
                                pm.getMembershipStartDate(), "Premium", pm.getPremiumCharge(), pm.getAttendance(),
                                pm.getLoyaltyPoints(), pm.isActiveStatus() ? "Active" : "Inactive"));
                        } else if (member instanceof RegularMember rm) {
                            writer.println(String.format("%-5d %-15s %-15s %-15s %-25s %-20s %-10s %-10.2f %-10d %-15.2f %-10s", 
                                rm.getId(), rm.getName(), rm.getLocation(), rm.getPhone(), rm.getEmail(),
                                rm.getMembershipStartDate(), rm.getPlan(), rm.getPrice(), rm.getAttendance(),
                                rm.getLoyaltyPoints(), rm.isActiveStatus() ? "Active" : "Inactive"));
                        }
                    }
                    showSuccess("Premium member details saved to file successfully!");
                } catch (IOException ex) {
                    showError("Error saving to file: " + ex.getMessage());
                }
            }
        });

        JButton readFromFileBtn = new JButton("Read from File");
        styleButton(readFromFileBtn, buttonFont);
        readFromFileBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (BufferedReader reader = new BufferedReader(new FileReader("MemberDetails.txt"))) {
                    outputArea.setText("");
                    String line;
                    while ((line = reader.readLine()) != null) {
                        outputArea.append(line + "\n");
                    }
                    showSuccess("Member details loaded from file successfully!");
                } catch (FileNotFoundException ex) {
                    showError("File not found. Please save data first.");
                } catch (IOException ex) {
                    showError("Error reading from file: " + ex.getMessage());
                }
            }
        });

        JButton clearBtn = new JButton("Clear");
        styleButton(clearBtn, buttonFont);
        clearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearPremiumFields();
                showSuccess("Fields cleared successfully");
            }
        });

        buttonPanel.add(addPremiumBtn);
        buttonPanel.add(makePaymentBtn);
        buttonPanel.add(displayPremiumBtn);
        buttonPanel.add(revertBtn);
        buttonPanel.add(calculateDiscountBtn);
        buttonPanel.add(activateBtn);
        buttonPanel.add(deactivateBtn);
        buttonPanel.add(markAttendanceBtn);
        buttonPanel.add(saveToFileBtn);
        buttonPanel.add(readFromFileBtn);
        buttonPanel.add(clearBtn);
        // Add an empty label to fill the last cell for even layout
        buttonPanel.add(new JLabel(""));

        // Add form and button panels to content panel
        contentPanel.add(formPanel);
        contentPanel.add(Box.createVerticalStrut(10)); // Spacer
        contentPanel.add(buttonPanel);
        
        // Wrap content panel in scroll pane
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        
        panel.add(scrollPane, BorderLayout.CENTER);
        
        return panel;
    }

    // Helper method to style buttons
    private void styleButton(JButton button, Font font) {
        button.setFont(font);
        button.setBackground(new Color(59, 130, 246)); // Blue background
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    // Helper methods
    private boolean isDuplicateId(int id) {
        for (GymMember member : members) {
            if (member.getId() == id) {
                return true;
            }
        }
        return false;
    }

    private RegularMember findRegularMember(int id) {
        for (GymMember member : members) {
            if (member instanceof RegularMember && member.getId() == id) {
                return (RegularMember) member;
            }
        }
        return null;
    }

    private PremiumMember findPremiumMember(int id) {
        for (GymMember member : members) {
            if (member instanceof PremiumMember && member.getId() == id) {
                return (PremiumMember) member;
            }
        }
        return null;
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(frame, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    private void showSuccess(String message) {
        JOptionPane.showMessageDialog(frame, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    private void clearRegularFields() {
        regIdField.setText("");
        regNameField.setText("");
        regLocationField.setText("");
        regPhoneField.setText("");
        regEmailField.setText("");
        regReferralField.setText("");
        regGenderGroup.clearSelection();
        regDobYear.setSelectedIndex(0);
        regDobMonth.setSelectedIndex(0);
        regDobDay.setSelectedIndex(0);
        regStartYear.setSelectedIndex(0);
        regStartMonth.setSelectedIndex(0);
        regStartDay.setSelectedIndex(0);
        regPlanCombo.setSelectedIndex(0);
        regTermsCheck.setSelected(false);
        regPriceField.setText("6500"); // Reset to Basic plan price
    }

    private void clearPremiumFields() {
        premIdField.setText("");
        premNameField.setText("");
        premLocationField.setText("");
        premPhoneField.setText("");
        premEmailField.setText("");
        premTrainerField.setText("");
        premPaidAmountField.setText("");
        premDiscountField.setText("0");
        premGenderGroup.clearSelection();
        premDobYear.setSelectedIndex(0);
        premDobMonth.setSelectedIndex(0);
        premDobDay.setSelectedIndex(0);
        premStartYear.setSelectedIndex(0);
        premStartMonth.setSelectedIndex(0);
        premStartDay.setSelectedIndex(0);
        premTermsCheck.setSelected(false);
    }

    private String[] generateYears(int startYear, int endYear) {
        int length = endYear - startYear + 1;
        String[] years = new String[length];
        for (int i = 0; i < length; i++) {
            years[i] = String.valueOf(startYear + i);
        }
        return years;
    }

    private String[] generateDays(int startDay, int endDay) {
        int length = endDay - startDay + 1;
        String[] days = new String[length];
        for (int i = 0; i < length; i++) {
            days[i] = String.valueOf(startDay + i);
        }
        return days;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GymGUI());
    }
}

// PremiumMember class definition
class PremiumMember extends GymMember {
    private String personalTrainer;
    private double premiumCharge;
    private double paidAmount;
    private double discountAmount;

    public PremiumMember(int id, String name, String location, String phone, String email,
                        String gender, String DOB, String membershipStartDate, String personalTrainer) {
        super(id, name, location, phone, email, gender, DOB, membershipStartDate);
        this.personalTrainer = personalTrainer;
        this.premiumCharge = 50000.0;
        this.paidAmount = 0.0;
        this.discountAmount = 0.0;
        this.attendance = 0;
        this.loyaltyPoints = 0.0;
        this.activeStatus = false;
    }

    public String getPersonalTrainer() {
        return personalTrainer;
    }

    public double getPremiumCharge() {
        return premiumCharge;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public boolean isFullPayment() {
        return paidAmount >= premiumCharge;
    }

    @Override
    public void markAttendance() {
        if (activeStatus) {
            attendance++;
            loyaltyPoints += 10; // Higher points for premium members
        } else {
            System.out.println("Membership is not active. Cannot mark attendance.");
        }
    }

    public String payDueAmount(double amount) {
        if (!activeStatus) {
            return "Cannot process payment - membership is not active.";
        }
        if (amount <= 0) {
            return "Payment amount must be greater than zero.";
        }
        if (paidAmount + amount > premiumCharge) {
            return "Payment exceeds remaining amount. Remaining: " + (premiumCharge - paidAmount);
        }
        paidAmount += amount;
        return "Payment of " + amount + " processed. Remaining: " + (premiumCharge - paidAmount);
    }

    public String calculateDiscount() {
        if (!activeStatus) {
            return "Cannot calculate discount - membership is not active.";
        }
        if (isFullPayment()) {
            discountAmount = premiumCharge * 0.10; // 10% discount on full payment
            return "Discount calculated: " + discountAmount;
        }
        return "No discount applicable until full payment is made.";
    }

    public void revertPremiumMember(String removalReason) {
        resetMember();
        this.paidAmount = 0.0;
        this.discountAmount = 0.0;
        this.setRemovalReason(removalReason);
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Personal Trainer: " + personalTrainer);
        System.out.println("Premium Charge: " + premiumCharge);
        System.out.println("Paid Amount: " + paidAmount);
        System.out.println("Remaining: " + (premiumCharge - paidAmount));
        System.out.println("Full Payment: " + (isFullPayment() ? "Yes" : "No"));
        if (isFullPayment()) {
            System.out.println("Discount: " + discountAmount);
        }
        String removalReason = getRemovalReason();
        if (removalReason != null && !removalReason.isEmpty()) {
            System.out.println("Removal Reason: " + removalReason);
        }
    }

    // Setter for removal reason (assuming it's needed)
    public void setRemovalReason(String removalReason) {
        // This method would need to be added to GymMember as well if not already present
    }

    
    public String getRemovalReason() {
        // This method would need to be added to GymMember as well if not already present
        return null; // Placeholder, implement if required
    }
}