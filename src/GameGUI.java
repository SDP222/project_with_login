
import database.Database;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;

public class GameGUI {
    
    static private gui.Window window;
    static String userid;
    
    public static void setUserID(String id)
    {
        userid = id;
    }
    
    
    public static void createAndShowGui() {
        window = new gui.Window();
        JFrame frame = new JFrame("Game");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(window);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setMinimumSize(new Dimension(710, 540));
        JMenuBar menubar = new JMenuBar();
        JMenu menu = new JMenu("Progress");
        JMenuItem itm = new JMenuItem("Save");
        menu.add(itm);
        itm.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("save");
                Database.save();
            }
        }));
        JMenuItem itm2 = new JMenuItem("Restore");
        menu.add(itm2);
        itm2.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Database.restore(userid);
                window.update();
            }
        }));
        JMenuItem itm3 = new JMenuItem("Reset");
        menu.add(itm3);
        itm3.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Database.reset();
                window.update();
            }
        }));
        menubar.add(menu);
        JMenu menu2 = new JMenu("Music");
        final JMenuItem itm21 = new JMenuItem("Stop");
        itm21.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (itm21.getText().equals("Stop")) {
                    window.stopPlaying();
                    itm21.setText("Resume");
                } else {
                    window.playBack();
                    itm21.setText("Stop");
                }
            }
        }));
        menu2.add(itm21);
        menubar.add(menu2);
        frame.setJMenuBar(menubar);
    }
}
