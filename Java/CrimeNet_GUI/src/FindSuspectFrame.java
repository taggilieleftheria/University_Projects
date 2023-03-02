
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



public  class FindSuspectFrame extends JFrame {
	private JPanel panel;
	
	private JButton createButton= new JButton("Find");
	private JFrame frame = new JFrame();
	private JTextField nameField;
	private Registry reg;
	


	public FindSuspectFrame(Registry r)  {
		reg = r;
		panel= new JPanel();
		nameField= new JTextField("Please enter a suspects's name");
	
			panel.add(nameField);
			panel.add(createButton);
			
			frame.setContentPane(panel);
		
			ButtonListener listener = new ButtonListener();
			createButton.addActionListener(listener);
			
	
			frame.setVisible(true);
			frame.setSize(500,400);
			frame.setTitle("Find Suspect");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
	}

	class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Suspect suspectName = reg.FindSuspect(nameField.getText()) ;
			if(suspectName== null) {
				JOptionPane.showMessageDialog(frame, "Suspect " +  nameField.getText() +" Not Found");
				
			}else  {
				new SuspectFrame(suspectName,reg);
				dispose();
			}
	}

}
}