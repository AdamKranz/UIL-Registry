import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;


public class Project5Gui 
{
	private UILRegistry myRegistry;
	public Project5Gui()
	{
		myRegistry = new UILRegistry();
		final JFrame frame = new JFrame("Foo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(600,400));
		frame.setLocation(400,200);
		
		Box vBox = Box.createVerticalBox();
		frame.add(vBox);
		
		Box titleBox = Box.createHorizontalBox();
		Box lineBox = Box.createHorizontalBox();
		Box wordBox = Box.createHorizontalBox();
		Box buttonBox = Box.createHorizontalBox();
		Box defBox = Box.createHorizontalBox();
		
		vBox.add(titleBox);
		vBox.add(lineBox);
		vBox.add(wordBox);
		vBox.add(buttonBox);
		vBox.add(defBox);
		vBox.add(Box.createVerticalStrut(25));
		
		//titleBox
		
				JLabel leftStar = new JLabel();
				JLabel title = new JLabel("Welcome to 'The Registry'");
				JLabel rightStar = new JLabel();
				title.setFont(new Font("Viner Hand ITC", Font.BOLD,28 ));
				
				Icon star = new ImageIcon("Star.png");
				leftStar.setIcon(star);
				rightStar.setIcon(star);
				
				//titleBox.add(Box.createHorizontalStrut(150));
				titleBox.add(leftStar);
				titleBox.add(title);
				titleBox.add(rightStar);
				//titleBox.add(Box.createHorizontalStrut(150));
				
				//wordBox
				JLabel wordLabel = new JLabel("Team?");
				final JTextField wordField = new JTextField();
				wordLabel.setFont(new Font("Viner Hand ITC", Font.BOLD, 14));
				
				wordBox.add(Box.createHorizontalStrut(100));
				wordBox.add(wordLabel);
				wordBox.add(wordField);
				wordBox.add(Box.createHorizontalStrut(100));
				
				wordField.setMaximumSize(new Dimension(350,50));
				
				//buttonBox
				final JButton doneButton = new JButton("Done?");
				final JButton resetButton = new JButton("Print?");
				
				doneButton.setFont(new Font("Viner Hand ITC", Font.BOLD, 14));
				resetButton.setFont(new Font("Viner Hand ITC", Font.BOLD, 14));
				
				buttonBox.add(doneButton);
				
				buttonBox.add(Box.createHorizontalStrut(130));
				buttonBox.add(resetButton);

				//defBox
						JLabel defLabel = new JLabel("Teams");
						final JTextPane defPane = new JTextPane();
						JScrollPane defScroll = new JScrollPane(defPane);
						
						defBox.add(Box.createHorizontalStrut(70));
						defBox.add(defLabel);
						defBox.add(defScroll);
						defBox.add(Box.createHorizontalStrut(100));
						
						defLabel.setFont(new Font("Viner Hand ITC", Font.BOLD, 14));
		
		
		
		
						doneButton.addActionListener(new ActionListener(){

							@Override
							public void actionPerformed(ActionEvent arg0) {
								myRegistry.addTeam(wordField.getText());
							}});
						
						resetButton.addActionListener(new ActionListener(){

							@Override
							public void actionPerformed(ActionEvent e) {
								defPane.setText(myRegistry.printAll());
							}});
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		frame.pack();
		frame.setVisible(true);
	}

	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				new Project5Gui();
				
			}});
	}

}
