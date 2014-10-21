package chatbot.view;

import javax.swing.JFrame;

import chatbot.controller.ChatBotAppController;

/**
 * GUI Frame class for ChatBot. Shows the basic framework code for a JFrame extension
 * @author Walker Hunter
 * @version 1.1 10/21/14
 */
public class ChatBotFrame extends JFrame
{
	private ChatBotPanel basePanel;
	
	public ChatBotFrame(ChatBotAppController baseController)
	{
		basePanel = new ChatBotPanel(baseController);
		
		setupFrame();
	}
	
	/**
	 * Helper method to load panel into frame, set size, and visibility.
	 */
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setSize(400, 400);
		this.setResizable(false);
		setVisible(true);
	}

}
