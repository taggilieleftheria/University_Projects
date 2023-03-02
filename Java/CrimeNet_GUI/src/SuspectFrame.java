
import java.awt.Color;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;


public class SuspectFrame  extends JFrame{
	private Suspect suspect ;
	private Registry registry;
	private JPanel fieldPanel = new JPanel();
	private JTextField textNumberField = new JTextField("Please enter a suspect's number");
	private JButton createbackButton = new JButton ("Back to Search Screen ");
	private JButton createSMSButton = new JButton ("Find SMS ");
	private JLabel labelforpartners = new JLabel("Partners  ");
	private JLabel labelforsugesstedpartners = new JLabel("Suggested Partners---->  ");
	public JTextField textNameField  = new JTextField(" Suspect's name");
	private JTextArea textNameArea = new JTextArea();
	private JTextArea textCodeNameArea = new JTextArea();
	private JTextArea textNumberArea = new JTextArea();
	private JTextArea textSMSArea = new JTextArea();
	private JTextArea textPartnersArea = new JTextArea();
	private JTextArea textSuggestedPartnersArea = new JTextArea();
	private ArrayList<SMS> sms = new ArrayList<SMS>();
	private JPanel fieldPanel2;
	private JPanel fieldPanel1;
	private JPanel fieldPanel4;
	private JPanel fieldPanel3;
	

	public SuspectFrame(Suspect susp, Registry reg) {
		suspect = susp;
		registry=reg;	
		
			fieldPanel = new JPanel();
			fieldPanel1 = new JPanel();
			fieldPanel1.setLayout(new FlowLayout(4,4,4));
			fieldPanel.setBorder(new LineBorder(Color.BLACK,1));
			fieldPanel2 = new JPanel();
			fieldPanel2.setLayout(new FlowLayout(4,4,4));
			fieldPanel2.setBorder(new LineBorder(Color.BLACK,1));
			fieldPanel3 = new JPanel();
			fieldPanel3.setLayout(new FlowLayout(4,4,4));
			fieldPanel3.setBorder(new LineBorder(Color.BLACK,1));
			fieldPanel4= new JPanel();
			fieldPanel4.setLayout(new FlowLayout(4,4,4));
			fieldPanel4.setBorder(new LineBorder(Color.BLACK,1));
			
			DefaultListModel modelpotentialpartners = new DefaultListModel();
			
			
			for(Suspect sus: suspect.getPotentialPartners()) {
				modelpotentialpartners.addElement(sus.getName() + " , " + sus.getCodeName());
			}
			ArrayList<String> name = Collections.list(modelpotentialpartners.elements());
			Collections.sort(name);
			for(String name1 : name) {
				textPartnersArea .append(name1 + " \n");
			}
						
		
			DefaultListModel modelsuggestedpartners = new DefaultListModel();
		
				
				for(Suspect sus: suspect.getSuggestedSuspects()) {
					modelsuggestedpartners.addElement(sus.getName() + " , " + sus.getCodeName());
			}
		
				ArrayList<String> suggestedname = Collections.list(modelsuggestedpartners.elements());
				Collections.sort(suggestedname);
				for(String name1 : suggestedname) {
					textSuggestedPartnersArea.append(name1 + " \n");
				}
				
					
				 textCodeNameArea.setText(suspect.getCodeName());
				 textNameArea.setText(suspect.getName());
				 textNumberArea.setText(suspect.getPhoneNumber().toString());
				 textNumberArea.setBorder(new LineBorder(Color.BLACK,1));
				 textSMSArea.setText(sms.toString());
				 textSuggestedPartnersArea.setText(suspect.getSuggestedSuspects().toString());
					
				 
				 modelpotentialpartners.addElement(suspect.getPotentialPartners().toString());

		
				fieldPanel1.add(textNameArea);
				fieldPanel1.add(textCodeNameArea);
				fieldPanel1.add(textNumberArea);
				fieldPanel.add(fieldPanel1);
				
				fieldPanel2.add(textNumberField);
				fieldPanel2.add(textSMSArea);
				fieldPanel2.add(createSMSButton);
				fieldPanel.add(fieldPanel2);

				fieldPanel3.add(labelforpartners);
				fieldPanel3.add(textPartnersArea);
				fieldPanel.add(fieldPanel3);
				
				fieldPanel4.add(labelforsugesstedpartners);
				fieldPanel4.add( textSuggestedPartnersArea);
				fieldPanel.add(fieldPanel4);
				
				fieldPanel.add(createbackButton);
				
				
				this.setContentPane(fieldPanel);

				ButtonListener listener = new ButtonListener();
				createbackButton.addActionListener(listener);
				createSMSButton.addActionListener(listener);
				this.setVisible(true);
				this.setSize(400,400);
				this.setTitle("Suspect Page");
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			}

	class ButtonListener implements ActionListener{

		private String smstext= " ";

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource().equals(createbackButton)){
				new FindSuspectFrame(registry);
				dispose();
				
			}else if (e.getSource().equals(createSMSButton)) {
				for(String num:suspect.getPhoneNumber()) {
					sms.addAll(registry.getMessagesBetween(num, textNumberField.getText()));
				}
				for(SMS smsp : sms) {
					smstext += smsp.getContext() + "\n";
				}
				
				textSMSArea.setText(smstext);
				
			}
}
	}
}