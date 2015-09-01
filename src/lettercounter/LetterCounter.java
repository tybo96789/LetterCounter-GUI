package lettercounter;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Tyler Atiburcio
 */
public class LetterCounter extends JFrame{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new LetterCounter();
        
    }
    
    Scanner fileScanner;
    String filePath;
    String findWhat;

    JPanel panel;
    JButton countButton;
    JLabel fileLabel, findLabel, counterLabel;
    JTextField fileField, findField, counterField;

    public LetterCounter()
    {
        this.panel = new JPanel();
        this.panel.setLayout(new GridLayout(2,4));
        
        this.fileLabel = new JLabel("File Path");
        this.panel.add(this.fileLabel);
        
        this.fileField = new JTextField();
        this.panel.add(this.fileField);
        
        this.findLabel = new JLabel("Find what?");
        this.panel.add(this.findLabel);
        
        this.findField = new JTextField();
        this.panel.add(this.findField);
        
        this.counterLabel = new JLabel("Instances Found");
        this.panel.add(this.counterLabel);
        
        this.counterField = new JTextField();
        this.counterField.setEditable(false);
        this.panel.add(this.counterField);
        
        this.countButton = new JButton("Count");
        this.panel.add(this.countButton);
        
        this.countButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                filePath = fileField.getText().trim();
                findWhat = findField.getText().trim();
                try {
                    fileScanner = new Scanner(new File(filePath));
                    int counter = 0;
                    while(fileScanner.hasNext())
                    {
                        String temp = fileScanner.nextLine();
                        for (int i = 0; i < temp.length(); i++) {
                            if(temp.charAt(i) == findWhat.charAt(0))
                                counter++;
                        }
                    }
                    counterField.setText(""+ counter);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(LetterCounter.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        this.add(this.panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
