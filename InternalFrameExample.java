import javax.swing.*;

public class InternalFrameExample {
    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("Internal Frame Example");
        JDesktopPane desktop = new JDesktopPane();
        
        JInternalFrame internalFrame = new JInternalFrame("Internal Frame", true, true, true, true);
        internalFrame.setSize(200, 100);
        internalFrame.setVisible(true);
        
        desktop.add(internalFrame);
        mainFrame.add(desktop);
        
        mainFrame.setSize(400, 400);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }
}
