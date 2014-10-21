package chatbot.view;

import javax.swing.JPanel;
import chatbot.controller.ChatBotAppController;

public class ChatBotPanel extends JPanel
{
	private ChatBotAppController baseController;
	
	public ChatBotPanel(ChatBotAppController baseController)
	{
		this.baseController = baseController;
	}

}
