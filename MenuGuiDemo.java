import javax.swing.*;
import java.awt.event.*;

public class MenuGuiDemo implements ActionListener {
    JFrame frame;
    JMenuBar menuBar;
    JMenu fileMenu, editMenu;
    JMenuItem openItem, saveItem, exitItem, copyItem, pasteItem;

    public MenuGuiDemo() {
        frame = new JFrame("Menu Example");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menuBar = new JMenuBar();

        fileMenu = new JMenu("File");
        openItem = new JMenuItem("Open");
        saveItem = new JMenuItem("Save");
        exitItem = new JMenuItem("Exit");

        openItem.addActionListener(this);
        saveItem.addActionListener(this);
        exitItem.addActionListener(this);

        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);

        editMenu = new JMenu("Edit");
        copyItem = new JMenuItem("Copy");
        pasteItem = new JMenuItem("Paste");

        copyItem.addActionListener(this);
        pasteItem.addActionListener(this);

        editMenu.add(copyItem);
        editMenu.add(pasteItem);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        frame.setJMenuBar(menuBar);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new MenuGuiDemo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem source = (JMenuItem) e.getSource();

        if (source == openItem) {
            JOptionPane.showMessageDialog(frame, "Open menu item clicked");
        } else if (source == saveItem) {
            JOptionPane.showMessageDialog(frame, "Save menu item clicked");
        } else if (source == exitItem) {
            int choice = JOptionPane.showConfirmDialog(frame, "Do you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        } else if (source == copyItem) {
            JOptionPane.showMessageDialog(frame, "Copy menu item clicked");
        } else if (source == pasteItem) {
            JOptionPane.showMessageDialog(frame, "Paste menu item clicked");
        }
    }
}
