package chatbot.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import chatbot.controller.ChatBotAppController;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import java.awt.event.KeyAdapter;

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
		chatPane = new JScrollPane();
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
		this.setBackground(Color.DARK_GRAY);
		this.setSize(400, 400);
		this.setLayout(baseLayout);
		this.add(firstButton);
		this.add(firstTextField);
		this.add(chatPane);
		add(chatArea);

	}

	/**
	 * layout settings
	 */
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, chatPane, 50, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatPane, 20, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatArea, -79, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, chatArea, 0, SpringLayout.NORTH, chatPane);
		baseLayout.putConstraint(SpringLayout.WEST, chatArea, 17, SpringLayout.EAST, chatPane);
		baseLayout.putConstraint(SpringLayout.EAST, chatArea, 364, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, firstTextField, -29, SpringLayout.NORTH, firstButton);
		baseLayout.putConstraint(SpringLayout.WEST, firstTextField, 39, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, firstTextField, -6, SpringLayout.NORTH, firstButton);
		baseLayout.putConstraint(SpringLayout.EAST, firstTextField, -36, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, firstButton, 101, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, firstButton, -10, SpringLayout.SOUTH, this);
	}


	private void setupListeners()
	{
		firstButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				chatArea.append("\n" + (firstTextField.getText()));
				String currentInput = firstTextField.getText();
				String result = baseController.getChatBotDialog(currentInput);
				showTextMessage(currentInput);
				showTextMessage(result);
				firstTextField.setText("");
			}
		});
	
		
		
		firstTextField.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent event)
			{
				if (event.getKeyCode() == KeyEvent.VK_ENTER)
				{
					chatArea.append("\n" + (firstTextField.getText()));
					firstTextField.setText("");
				}
			}
		});
	
	}
	
	public void showTextMessage(String userInput)
	{
		chatArea.append("\n" + userInput);
	}
}
