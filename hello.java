import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class hello extends JFrame implements ActionListener 
{
    private JTextField nameField, idField, projectField, projectIdField, projectNameField, projectDescField;
    private JButton addButton, displayButton;
    private JTable table;
    private DefaultTableModel model;
    public hello() 
    {
        setTitle("Digital Service Agency");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(7, 2));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        inputPanel.add(new JLabel("Employee Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Employee ID:"));
        idField = new JTextField();
        inputPanel.add(idField);

        inputPanel.add(new JLabel("Project Name:"));
        projectField = new JTextField();
        inputPanel.add(projectField);
        inputPanel.add(new JLabel("Project ID:"));
        projectIdField = new JTextField();
        inputPanel.add(projectIdField);
        inputPanel.add(new JLabel("Project Name:"));
        projectNameField = new JTextField();
        inputPanel.add(projectNameField);
        inputPanel.add(new JLabel("Project Description:"));
        projectDescField = new JTextField();
        inputPanel.add(projectDescField);

        addButton = new JButton("Add Employee");
        addButton.addActionListener(this);
        inputPanel.add(addButton);

        JPanel displayPanel = new JPanel(new BorderLayout());
        displayPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        displayButton = new JButton("Display Employees");
        displayButton.addActionListener(this);
        displayPanel.add(displayButton, BorderLayout.NORTH);

        model = new DefaultTableModel();
        model.addColumn("Employee Name");
        model.addColumn("Employee ID");
        model.addColumn("Project Name");
        model.addColumn("Project ID");
        model.addColumn("Project Description");
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        displayPanel.add(scrollPane, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.NORTH);
        add(displayPanel, BorderLayout.CENTER);
    }
@Override
public void actionPerformed(ActionEvent e) 
{
    if (e.getSource() == addButton) 
    {
        String[] rowData = 
        {
            nameField.getText(),
            idField.getText(),
            projectField.getText(),
            projectIdField.getText(),
            projectNameField.getText(),
            projectDescField.getText()
        };

        model.addRow(rowData);
        clearFields();
    }
}

private void clearFields() 
{
    nameField.setText("");
    idField.setText("");
    projectField.setText("");
    projectIdField.setText("");
    projectNameField.setText("");
    projectDescField.setText("");
}
public static void main(String[] args) 
{
    SwingUtilities.invokeLater(() -> {
    hello labEx10 = new hello();
    labEx10.setVisible(true);
    });
}
}