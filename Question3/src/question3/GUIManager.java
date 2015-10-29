package question3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
 
public class GUIManager implements ActionListener{
    //globals
    JLabel charSelected;
    JFrame gameTitle;
    JOptionPane charPane;
    JOptionPane loadPane;
    JOptionPane startPane;
    JDialog dialog;
    Timer gameStart;
   
    public void displayTitleScreen(){
        //initialize content
        charSelected = new JLabel("Character Chosen");
        charSelected.setVisible(false);
        JButton char1 = new JButton("Character 1");
        JButton char2 = new JButton("Character 2");
        char1.addActionListener(this);
        char2.addActionListener(this);
        final JComponent[] charOptions = new JComponent[] {charSelected, char1, char2};
       
        //create panes for dialogs
        charPane = new JOptionPane(charOptions);
 
        //Create Title Screen / Character Selection
        dialog = new JDialog();
        dialog.setTitle("The Game");
        dialog.setModal(true);
        
        //Embed Dialog for character choice
        dialog.setContentPane(charPane);
        dialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        dialog.pack();
        dialog.setSize(500,500);
        dialog.setVisible(true);
    }
 
	//handle clicking options for character select
	@Override
	public void actionPerformed(ActionEvent e) {
	    ///Create local timer to load final start screen for any character selected
	    int delay = 2000; //milliseconds
	    ActionListener beginGameAction = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                JOptionPane.showConfirmDialog(dialog, "Game Started!", "Entering Game World...", JOptionPane.PLAIN_MESSAGE);
                gameStart.stop();
                startPane = new JOptionPane("The Game Has Started!");
            }
	    };
	    gameStart = new Timer(delay, beginGameAction);
	   
	    // switch case to handle result of choice
	    switch(e.getActionCommand()){
            case "Character 1":
                //show dialog for character 1 details and choice
                int result = JOptionPane.showConfirmDialog(dialog, "Character 1 can fly, but can't swim.\n Is this the hero of your choosing?", "Character 1 - The Flyer", JOptionPane.OK_CANCEL_OPTION);
                if(result == JOptionPane.YES_OPTION){
                    charSelected.setVisible(true);
                    loadPane = new JOptionPane("You have chosen " + e.getActionCommand() + "!\nNow Loading...");
                    dialog.setContentPane(loadPane);
                    gameStart.start();
                }
                break;
            case "Character 2":
                //show dialog for character 1 details and choice
                System.out.println("You clicked Character 2");
                int result2 = JOptionPane.showConfirmDialog(dialog, "Character 2 can sprint forever and swim, but can't fly.\n Is this the hero of your choosing?", "Character 2 - The Sprinter", JOptionPane.OK_CANCEL_OPTION);
                if(result2 == JOptionPane.YES_OPTION){
                    charSelected.setVisible(true);
                    loadPane = new JOptionPane("You have chosen " + e.getActionCommand() + "!\nNow Loading...");
                    dialog.setContentPane(loadPane);
                    gameStart.start();
                }
                break;
            default:
                System.out.println("Somehow, you got through my defenses");                             
	    }
	}
}
