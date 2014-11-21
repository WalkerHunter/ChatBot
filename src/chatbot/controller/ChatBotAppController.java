package chatbot.controller;

import javax.swing.JOptionPane;

import chatbot.model.ChatBot;
import chatbot.view.ChatBotFrame;
import chatbot.view.ChatBotPanel;
import chatbot.view.ChatBotView;

/**
 * Runs the ChatBot Project. Owns the model and associated views.
 * @author Walker Hunter
 * @version 1.2 10/2/14 - cleaned the quit method.
 */
public class ChatBotAppController
{
	/**
	 * The instance of the ChatBotView, the view of the application.
	 */
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
		mySillyChatBot = new ChatBot("LOLLIPOP");
		startMessage = "Welcome to the " + mySillyChatBot.getName() + " ChatBot. What is your name?";
		quitMessage = "goodbye cruel user :(";
	}
	
	
 	/**
 	 * Getter method for the applications ChatBot.
 	 * @return mySillyChatBot
 	 */
 	public ChatBot getMySillyChatBot()
	{
		return mySillyChatBot;
	}
	
	
	public void start()
	{
		((ChatBotPanel) appFrame.getContentPane()).showTextMessage(startMessage);
		
		//ChatBotPanel testPanel = (ChatBotPanel) appFrame.getContentPane();
		//textPanel.showTextMessage(startMessage);
	}
	
	public String getChatBotDialog(String input)
	{
		String result="";
		
		if(mySillyChatBot.quitChecker(input))
		{
			quit();
		}
		
		result = mySillyChatBot.processText(input);
		
		return result;
	}
/**
 * Quit method for the ChatBot application.
 */
	private void quit()
	{
		applicationView.showChatBotMessage(quitMessage);
		System.exit(0);
	}
}
