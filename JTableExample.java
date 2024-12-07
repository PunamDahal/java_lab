import javax.swing.*;

public class JTableExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JTable Example");
        
        String[] columns = {"ID", "Name", "Age"};
        Object[][] data = {
            {1, "John", 25},
            {2, "Anna", 30},
            {3, "Mike", 22}
        };
        
        JTable table = new JTable(data, columns);
        JScrollPane scrollPane = new JScrollPane(table);
        
        frame.add(scrollPane);
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
