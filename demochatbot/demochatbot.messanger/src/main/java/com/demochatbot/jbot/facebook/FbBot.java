package com.demochatbot.jbot.facebook;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;

import com.demochatbot.ella.model.GenericMessage;
import com.demochatbot.jbot.core.common.Controller;
import com.demochatbot.jbot.core.common.EventType;
import com.demochatbot.jbot.core.common.JBot;
import com.demochatbot.jbot.core.facebook.Bot;
import com.demochatbot.jbot.core.facebook.models.*;
import com.demochatbot.jbot.service.EllaService;
import com.demochatbot.jbot.service.impl.EllaServiceImpl;

/**
 * A simple Facebook Bot. You can create multiple bots by just
 * extending {@link Bot} class like this one. Though it is
 * recommended to create only bot per jbot instance.
 * 
 * @author amercado
 * 
 */
@JBot
@Profile("facebook")
public class FbBot extends Bot {
	@Autowired
	EllaServiceImpl ellaService;
    /**
     * Set this property in {@code application.properties}.
     */
    @Value("${fbBotToken}")
    private String fbToken;

    /**
     * Set this property in {@code application.properties}.
     */
    @Value("${fbPageAccessToken}")
    private String pageAccessToken;

    @Override
    public String getFbToken() {
        return fbToken;
    }

    @Override
    public String getPageAccessToken() {
        return pageAccessToken;
    }

    /**
     * Sets the "Get Started" button with a payload "hi". It also set the "Greeting Text" which the user sees when it
     * opens up the chat window. Uncomment the {@code @PostConstruct} annotation only after you have verified your 
     * webhook.
     */
    //@PostConstruct
    public void init() {
        setGetStartedButton("hi");
        setGreetingText(new Payload[]{new Payload().setLocale("default").setText("JBot is a Java Framework to help" +
                " developers make Facebook, Slack and Twitter bots easily. You can see a quick demo by clicking " +
                "the \"Get Started\" button.")});
    }
    
    @Controller(events = {EventType.MESSAGE, EventType.POSTBACK}, pattern = "[A-Za-z]")
    public void onWatson(Event event) {
    	GenericMessage genericMessage = new GenericMessage();
    	genericMessage.setUsername("angel");
    	genericMessage.setSource("fb");
    	genericMessage.setText(event.getMessage().getText());
        Message fbMessage = ellaService.getMessageResponse(genericMessage);
        Button[] quickReplies = new Button[]{
                new Button().setContentType("text").setTitle("Sure").setPayload("yes"),
                new Button().setContentType("text").setTitle("Nope").setPayload("no")
        };
        reply(event,fbMessage);
//        reply(event, new Message().setText("Hello, I am JBot. Would you like to see more?").setQuickReplies(quickReplies));
    }

    /**
     * This method gets invoked when a user clicks on the "Get Started" button or just when someone simply types
     * hi, hello or hey. When it is the former, the event type is {@code EventType.POSTBACK} with the payload "hi"
     * and when latter, the event type is {@code EventType.MESSAGE}.
     *
     * @param event
     */
    @Controller(events = {EventType.MESSAGE, EventType.POSTBACK}, pattern = "^(?i)(hi|hello|hey)$")
    public void onGetStarted(Event event) {
        // quick reply buttons
        Button[] quickReplies = new Button[]{
                new Button().setContentType("text").setTitle("Sure").setPayload("yes"),
                new Button().setContentType("text").setTitle("Nope").setPayload("no")
        };
        reply(event, new Message().setText("Hello, I am JBot. Would you like to see more?").setQuickReplies(quickReplies));
    }

    /**
     * This method gets invoked when the user clicks on a quick reply button whose payload is either "yes" or "no".
     *
     * @param event
     */
    @Controller(events = EventType.QUICK_REPLY, pattern = "(yes|no)")
    public void onReceiveQuickReply(Event event) {
        if ("yes".equals(event.getMessage().getQuickReply().getPayload())) {
            reply(event, "Cool! You can type: \n 1) Show Buttons \n 2) Show List \n 3) Setup meeting");
        } else {
            reply(event, "See you soon!");
        }
    }

    /**
     * This method is invoked when the user types "Show Buttons" or something which has "button" in it as defined
     * in the {@code pattern}.
     *
     * @param event
     */
    @Controller(events = EventType.MESSAGE, pattern = "(?i:button)")
    public void showButtons(Event event) {
        Button[] buttons = new Button[]{
                new Button().setType("web_url").setUrl("http://blog.ramswaroop.me").setTitle("JBot Docs"),
                new Button().setType("web_url").setUrl("https://goo.gl/uKrJWX").setTitle("Buttom Template")
        };
        reply(event, new Message().setAttachment(new Attachment().setType("template").setPayload(new Payload()
                .setTemplateType("button").setText("These are 2 link buttons.").setButtons(buttons))));
    }

    /**
     * This method is invoked when the user types "Show List" or something which has "list" in it as defined
     * in the {@code pattern}.
     *
     * @param event
     */
    @Controller(events = EventType.MESSAGE, pattern = "(?i:atms)")
    public void showList(Event event) {
        Element[] elements = new Element[]{
                new Element().setTitle("ATM Toluca").setSubtitle("10 KM route 1")
                        .setImageUrl("https://i.imgur.com/mM82YXg.png")
                        .setDefaultAction(new Button().setType("web_url").setMessengerExtensions(true)
                        .setUrl("https://www.google.com/maps/search/hsbc+metepec/@19.2701668,-99.6178967,14z/data=!3m1!4b1")
                        )
                        ,
                new Element().setTitle("Atm Metepec").setSubtitle("9 KM route 2")
                        .setImageUrl("https://i.imgur.com/mM82YXg.png")
                        .setDefaultAction(new Button().setType("web_url").setMessengerExtensions(true)
                        .setUrl("https://www.google.com/maps/search/hsbc+metepec/@19.2701668,-99.6178967,14z/data=!3m1!4b1")
                        )
                        };
        reply(event, new Message().setAttachment(new Attachment().setType("template").setPayload(new Payload()
                .setTemplateType("list").setElements(elements))));
    }

    /**
     * Show the github project url when the user says bye.
     *
     * @param event
     */
    @Controller(events = EventType.MESSAGE, pattern = "(?i)(bye|tata|ttyl|cya|see you)")
    public void showGithubLink(Event event) {
        reply(event, new Message().setAttachment(new Attachment().setType("template").setPayload(new Payload()
                .setTemplateType("button").setText("Bye").setButtons(new Button[]{new Button()
                        .setType("web_url").setTitle("our site").setUrl("https://www.hsbc.com.mx/1/2//es")}))));
    }


    // Conversation feature of JBot

    /**
     * Type "setup meeting" to start a conversation with the bot. Provide the name of the next method to be
     * invoked in {@code next}. This method is the starting point of the conversation (as it
     * calls {@link Bot#startConversation(Event, String)} within it. You can chain methods which will be invoked
     * one after the other leading to a conversation.
     *
     * @param event
     */
    @Controller(pattern = "(?i)(setup meeting)", next = "confirmTiming")
    public void setupMeeting(Event event) {
        startConversation(event, "confirmTiming");   // start conversation
        reply(event, "Cool! At what time (ex. 15:30) do you want me to set up the meeting?");
    }

    /**
     * This method will be invoked after {@link FbBot#setupMeeting(Event)}. You need to
     * call {@link Bot#nextConversation(Event)} to jump to the next question in the conversation.
     *
     * @param event
     */
    @Controller(next = "askTimeForMeeting")
    public void confirmTiming(Event event) {
        reply(event, "Your meeting is set at " + event.getMessage().getText() +
                ". Would you like to repeat it tomorrow?");
        nextConversation(event);    // jump to next question in conversation
    }

    /**
     * This method will be invoked after {@link FbBot#confirmTiming(Event)}. You can
     * call {@link Bot#stopConversation(Event)} to end the conversation.
     *
     * @param event
     */
    @Controller(next = "askWhetherToRepeat")
    public void askTimeForMeeting(Event event) {
        if (event.getMessage().getText().contains("yes")) {
            reply(event, "Okay. Would you like me to set a reminder for you?");
            nextConversation(event);    // jump to next question in conversation  
        } else {
            reply(event, "No problem. You can always schedule one with 'setup meeting' command.");
            stopConversation(event);    // stop conversation only if user says no
        }
    }

    /**
     * This method will be invoked after {@link FbBot#askTimeForMeeting(Event)}. You can
     * call {@link Bot#stopConversation(Event)} to end the conversation.
     *
     * @param event
     */
    @Controller
    public void askWhetherToRepeat(Event event) {
        if (event.getMessage().getText().contains("yes")) {
            reply(event, "Great! I will remind you tomorrow before the meeting.");
        } else {
            reply(event, "Okay, don't forget to attend the meeting tomorrow :)");
        }
        stopConversation(event);    // stop conversation
}
}
