package chatbot.view;

import javax.swing.JOptionPane;

import chatbot.controller.ChatBotAppController;

public class ChatBotView
{
	private ChatBotAppController baseController;

	public ChatBotView(ChatBotAppController baseController)
	{
		this.baseController = baseController;
	}

	public String showChatBot(String currentInput)
	{
		String result = "";

		JOptionPane.showMessageDialog(null, "Hello, " + currentInput);
		result = JOptionPane.showInputDialog(null, "are you done?");

		return result;
	}

}
