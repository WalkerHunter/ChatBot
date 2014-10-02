package chatbot.controller;

import javax.swing.JOptionPane;

import chatbot.model.ChatBot;
import chatbot.view.ChatBotView;

/**
 * Runs the ChatBot Project. Owns the model and associated views.
 * @author Walker Hunter
 * @version 1.2 10/2/14 - cleaned the quit method.
 */
public class ChatBotAppController
{
	private ChatBotView applicationView;
	private ChatBot mySillyChatBot;
	private String startMessage;
	private String quitMessage;
	
	
	
	public ChatBotAppController()
	{
		applicationView = new ChatBotView(this);
		mySillyChatBot = new ChatBot("Derf");
		startMessage = "Welcome to the " + mySillyChatBot.getName() + " chatbot. What is your name?";
		quitMessage = "goodbye cruel user :(";
	}
	
	public ChatBot getMySillyChatBot()
	{
		return mySillyChatBot;
	}
	
	
	public void start()
	{
		String result = applicationView.showChatBotDialog(startMessage);

		while(!mySillyChatBot.quitChecker(result))
		{
			result = mySillyChatBot.processText(result);
			result = applicationView.showChatBotDialog(result);
		}
		quit();
	}

	private void quit()
	{
		applicationView.showChatBotMessage(quitMessage);
		System.exit(0);
	}
}
