package chatbot.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import chatbot.controller.ChatBotAppController;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
/**
 * 
 * @author Walker Hunter
 *
 */
public class ChatBotPanel extends JPanel
{
	private ChatBotAppController baseController;
	
	private JButton firstButton;
	private JTextField firstTextField;
	private SpringLayout baseLayout;
	private JTextArea chatArea;
	private JScrollPane chatPane;
	
	/**
      * 	
      * @param baseController
      */
	public ChatBotPanel(ChatBotAppController baseController)
	{
		this.baseController = baseController;
		
		firstButton = new JButton("click the button... it is so slicky :D");
		firstTextField = new JTextField(25);
		baseLayout = new SpringLayout();
		chatArea = new JTextArea(5, 20);
		chatPane = new JScrollPane(chatArea);
		
		setupPane();
		setupPanel();
		setupLayout();
		setupListeners();
	}

	private void setupPane()
	{
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
	}
	
	/**
	 * helper method for the panel.
	 */
	
	private void setupPanel()
	{
		this.setBackground(Color.MAGENTA);
		this.setSize(400, 400);
		this.setLayout(baseLayout);
		this.add(firstButton);
		this.add(firstTextField);
		this.add(chatPane);
	}
/**
 * layout settings
 */
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, firstTextField, 94, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, firstTextField, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, firstTextField, 216, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, firstButton, 21, SpringLayout.SOUTH, firstTextField);
		baseLayout.putConstraint(SpringLayout.WEST, firstButton, 0, SpringLayout.WEST, firstTextField);
		baseLayout.putConstraint(SpringLayout.NORTH, chatPane, 50, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatPane, 20, SpringLayout.WEST, this);
	}
	
	private void setupListeners()
	{
		firstButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				firstTextField.setText(firstTextField.getText()+ " :)");
			}
		});
	}
}
