package chatbot.controller;

import javax.swing.JOptionPane;

import chatbot.model.ChatBot;
import chatbot.view.ChatBotFrame;
import chatbot.view.ChatBotView;

/**
 * Runs the ChatBot Project. Owns the model and associated views.
 * @author Walker Hunter
 * @version 1.2 10/2/14 - cleaned the quit method.
 */
public class ChatBotAppController
{
	private ChatBotView applicationView;
	/**
	 * The instance of the ChatBot, the model of this application
	 */
	private ChatBot mySillyChatBot;
	/**
	 * The message used when starting the application
	 */
	private String startMessage;
	/**
	 * The message provided when the user quits the application.
	 */
	private String quitMessage;
	/**
	 * Reference to the GUI JFRame object for the application
	 */
	private ChatBotFrame appFrame;
	
	
 	public ChatBotAppController()
	{
		applicationView = new ChatBotView(this);
		appFrame = new ChatBotFrame(this);
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

//		while(!mySillyChatBot.quitChecker(result))
//		{
//			result = mySillyChatBot.processText(result);
//			result = applicationView.showChatBotDialog(result);
//		}
//		quit();
	}

	private void quit()
	{
		applicationView.showChatBotMessage(quitMessage);
		System.exit(0);
	}
}
