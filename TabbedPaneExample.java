import javax.swing.*;

public class TabbedPaneExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Tabbed Pane Example");
        JTabbedPane tabbedPane = new JTabbedPane();
        
        tabbedPane.addTab("Tab 1", new JLabel("Content for Tab 1"));
        tabbedPane.addTab("Tab 2", new JLabel("Content for Tab 2"));
        
        frame.add(tabbedPane);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
