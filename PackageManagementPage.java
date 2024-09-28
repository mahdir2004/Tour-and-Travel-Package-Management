package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Entity.Package;
import EntityList.PackageList;
import Files.FileIO;

public class PackageManagementPage extends JFrame implements ActionListener {
    Font font20 = new Font("Cambria", Font.PLAIN, 20);
    Font font15 = new Font("Cambria", Font.BOLD, 15);
    Font font30 = new Font("Cambria", Font.PLAIN, 30);
    
    JTextField searchTextField, deleteTextField, idTextField, nameTextField, dayTextField, priceTextField, descriptionTextField;
    
    JButton insertBtn, updateBtn, searchBtn, deleteBtn, showAllBtn;
    JTextArea display;
	
    JComboBox<String> typeComboBox, destinationComboBox;

    PackageList packageList = new PackageList(100);
    
    public PackageManagementPage() {
        super("Package Management Page");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(900, 720); 
        this.setLocation(200, 50); 
        this.getContentPane().setBackground(new Color(218, 232, 252));
        this.setLayout(null);
        
        // Load Data From File
        FileIO.loadPackageFromFile(packageList);
        
        JLabel title = new JLabel("RMM Travellers");
        title.setBounds(300, 5, 500, 50);
        title.setFont(new Font("Cambria", Font.BOLD, 35));
        this.add(title);

        JLabel subTitle = new JLabel("Package Information");
        subTitle.setBounds(310, 45, 320, 50);
        subTitle.setFont(new Font("Cambria", Font.BOLD, 25));
        this.add(subTitle);

        int top = 100;
        int gap = 30;

        JLabel idLabel = new JLabel("Package ID");
        idLabel.setBounds(20, top, 200, 30);
        idLabel.setFont(font15);
        this.add(idLabel);
        
        idTextField = new JTextField();
        idTextField.setBounds(118, top, 100, 30);
        idTextField.setFont(font15);
        this.add(idTextField);
        
        JLabel nameLabel = new JLabel("Package Name");
        nameLabel.setBounds(20, top += gap, 200, 30);
        nameLabel.setFont(font15);
        this.add(nameLabel);
        
        nameTextField = new JTextField();
        nameTextField.setBounds(20, top += gap, 200, 30);
        nameTextField.setFont(font15);
        this.add(nameTextField);

        JLabel destinationLabel = new JLabel("Package Destination");
        destinationLabel.setBounds(20, top += gap, 200, 30);
        destinationLabel.setFont(font15);
        this.add(destinationLabel);

        destinationComboBox = new JComboBox<>(new String[]{"Bandarban", "Cox's Bazar", "Rangamati", "Sajek",
                "Srimangal", "St. Martin", "Sundarban", "Sylhet"});
        destinationComboBox.setBounds(20, top += gap, 200, 30);
        destinationComboBox.setFont(font15);
        this.add(destinationComboBox);

        JLabel typeLabel = new JLabel("Package Type");
        typeLabel.setBounds(20, top += gap, 200, 30);
        typeLabel.setFont(font15);
        this.add(typeLabel);

        typeComboBox = new JComboBox<>(new String[]{"Regular", "Premium", "Offer"});
        typeComboBox.setBounds(20, top += gap, 200, 30);
        typeComboBox.setFont(font15);
        this.add(typeComboBox);

        JLabel dayLabel = new JLabel("Amount of Days");
        dayLabel.setBounds(20, top += gap, 200, 30);
        dayLabel.setFont(font15);
        this.add(dayLabel);
        
        dayTextField = new JTextField();
        dayTextField.setBounds(20, top += gap, 200, 30);
        dayTextField.setFont(font15);
        this.add(dayTextField);
        
        JLabel priceLabel = new JLabel("Price");
        priceLabel.setBounds(20, top += gap, 200, 30);
        priceLabel.setFont(font15);
        this.add(priceLabel);
        
        priceTextField = new JTextField();
        priceTextField.setBounds(20, top += gap, 200, 30);
        priceTextField.setFont(font15);
        this.add(priceTextField);
        
        JLabel descriptionLabel = new JLabel("Description");
        descriptionLabel.setBounds(20, top += gap, 200, 30);
        descriptionLabel.setFont(font15);
        this.add(descriptionLabel);
        
        descriptionTextField = new JTextField();
        descriptionTextField.setBounds(20, top += gap, 200, 100);
        descriptionTextField.setFont(font15);
        this.add(descriptionTextField);
        
        insertBtn = new JButton("Insert");
        insertBtn.setBounds(20, top += gap + 90, 200, 30);
        insertBtn.setBackground(Color.GREEN);
        insertBtn.setFont(font15);
        insertBtn.addActionListener(this);
        this.add(insertBtn);
        
        updateBtn = new JButton("Update");
        updateBtn.setBounds(20, top += gap + 20, 200, 30);
        updateBtn.setBackground(Color.GREEN);
        updateBtn.setFont(font15);
        updateBtn.addActionListener(this);
        this.add(updateBtn);
        
        JLabel searchLabel = new JLabel("Search By Id");
        searchLabel.setBounds(250, 100, 200, 30);
        searchLabel.setFont(font15);
        this.add(searchLabel);
        
        searchTextField = new JTextField();
        searchTextField.setBounds(410, 100, 300, 30);
        searchTextField.setFont(font15);
        this.add(searchTextField);
        
        searchBtn = new JButton("SEARCH");
        searchBtn.setBounds(720, 100, 100, 30);
        searchBtn.setBackground(Color.YELLOW);
        searchBtn.setFont(font15);
        searchBtn.addActionListener(this);
        this.add(searchBtn);

        JLabel deleteLabel = new JLabel("Delete By Package ID");
        deleteLabel.setBounds(250, 580, 200, 30);
        deleteLabel.setFont(font15);
        this.add(deleteLabel);
        
        deleteTextField = new JTextField();
        deleteTextField.setBounds(410, 580, 300, 30);
        deleteTextField.setFont(font15);
        this.add(deleteTextField);
        
        deleteBtn = new JButton("DELETE");
        deleteBtn.setBounds(720, 580, 100, 30);
        deleteBtn.setBackground(Color.YELLOW);
        deleteBtn.setFont(font15);
        deleteBtn.addActionListener(this);
        this.add(deleteBtn);
        
        showAllBtn = new JButton("SHOW ALL");
        showAllBtn.setBounds(250, 630, 600, 30);
        showAllBtn.setBackground(Color.RED);
        showAllBtn.setForeground(Color.WHITE);
        showAllBtn.setFont(font15);
        showAllBtn.addActionListener(this);
        this.add(showAllBtn);

        display = new JTextArea();
        display.setFont(font15);
        display.setEditable(false);

        JScrollPane jsp = new JScrollPane(display);
        jsp.setBounds(250, 150, 600, 410);
        this.add(jsp);

        this.setVisible(true);
        reloadData();
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == insertBtn) {
            if (idTextField.getText().isEmpty() || nameTextField.getText().isEmpty() || 
                dayTextField.getText().isEmpty() || priceTextField.getText().isEmpty() || 
                descriptionTextField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fields are mandatory!");
                return;
            }
            
            if (packageList.getById(idTextField.getText()) != null) {
                JOptionPane.showMessageDialog(this, "Package ID already exists!");
            } else {
                try {
                    Package p = new Package(idTextField.getText(), nameTextField.getText(),
                            destinationComboBox.getSelectedItem().toString(),
                            typeComboBox.getSelectedItem().toString(),
                            Integer.parseInt(dayTextField.getText()),
                            Double.parseDouble(priceTextField.getText()),
                            descriptionTextField.getText());
                    packageList.insert(p);
                    FileIO.writePackageInFile(p);
                    JOptionPane.showMessageDialog(this, "Package Inserted Successfully");
                    reloadData();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Invalid input for days or price. Please enter valid numbers.");
                }
            }
        } else if (e.getSource() == updateBtn) {
            Package p = packageList.getById(idTextField.getText());
            if (p != null) {
                p.setPackageName(nameTextField.getText());
                p.setPackageDestination(destinationComboBox.getSelectedItem().toString());
                p.setPackageType(typeComboBox.getSelectedItem().toString());
                try {
                    p.setAmountOfDay(Integer.parseInt(dayTextField.getText()));
                    p.setPrice(Double.parseDouble(priceTextField.getText()));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Invalid input for days or price. Please enter valid numbers.");
                    return;
                }
                p.setDescription(descriptionTextField.getText());
                FileIO.writeAllPackagesToFile(packageList);
                JOptionPane.showMessageDialog(this, "Package Updated Successfully");
                reloadData();
            } else {
                JOptionPane.showMessageDialog(this, "Package ID does not exist!");
            }
        } else if (e.getSource() == searchBtn) {
            Package p = packageList.getById(searchTextField.getText());
            if (p != null) {
                display.setText(p.getAllPackageAsString());
            } else {
                JOptionPane.showMessageDialog(this, "No Package Found");
            }
        } else if (e.getSource() == deleteBtn) {
            if (packageList.deletePackage(deleteTextField.getText())) {
                FileIO.writeAllPackagesToFile(packageList); 
                JOptionPane.showMessageDialog(this, "Package Deleted Successfully");
                reloadData();
            } else {
                JOptionPane.showMessageDialog(this, "Package ID does not exist!");
            }
        } else if (e.getSource() == showAllBtn) {
            reloadData();
        }
    }

    public void reloadData() {
        display.setText(packageList.getAllPackageAsString());
    }
}
