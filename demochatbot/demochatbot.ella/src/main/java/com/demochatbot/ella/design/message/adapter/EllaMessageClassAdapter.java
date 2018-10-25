package com.demochatbot.ella.design.message.adapter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.demochatbot.ella.fb.model.Button;
import com.demochatbot.ella.fb.model.Element;
import com.demochatbot.ella.fb.model.Message;
import com.demochatbot.ella.model.GenericMessage;
import com.ibm.watson.developer_cloud.assistant.v1.model.DialogNode;
import com.ibm.watson.developer_cloud.assistant.v1.model.DialogNodeOutputOptionsElement;
import com.ibm.watson.developer_cloud.assistant.v1.model.MessageResponse;

@Component
public class EllaMessageClassAdapter extends EllaMessage implements EllaMessageAdapter {
	
	private static final String breakLine = "\n ";

	@Override
	public Message getFbMessage(MessageResponse genericMessage) {
		
			return convertWatsonMessagetoFbMessage( genericMessage);

	}

	@Override
	public MessageResponse getWatsonMessage(Object genericMessage) {

		return null;
	}

	protected MessageResponse convertFbMessagetoWatsonMessage() {
		return null;

	}

	protected Message convertWatsonMessagetoFbMessage(MessageResponse messageResponse) {
		StringBuilder stringBuilder = new StringBuilder(100);
		List<String> textList = messageResponse.getOutput().getText();
		Message msg = new Message();
		//getting text
		for (String string : textList) {
			stringBuilder.append(string);
			stringBuilder.append(breakLine);
		}
		//getting options and title
		//the option could be converted in buttons or list
		String title = "";
		List<DialogNodeOutputOptionsElement> options = null;
		if (!messageResponse.getOutput().getGeneric().isEmpty()) {
			title = messageResponse.getOutput().getGeneric().get(0).getTitle();
			title = (title!=null)?title:"";
			options = messageResponse.getOutput().getGeneric().get(0).getOptions();
			
		}
		
		
		stringBuilder.append(title);
		stringBuilder.append(breakLine);				
		
		if (options!=null) {
			Button[] optionButtons = new Button[options.size()];
			int count = 0;
			for (DialogNodeOutputOptionsElement dialogNode: options) {
				//buttons text format
				optionButtons[count]= new Button().setContentType("text").setTitle(dialogNode.getLabel()).setPayload(dialogNode.getValue().getInput().text());
				count++;
			}
				msg.setQuickReplies(optionButtons);			
		}

		if (!"".equals(stringBuilder.toString()) && null != stringBuilder.toString()) {
			msg.setText(stringBuilder.toString());
		}
		
		
		
		return msg;
	}

}
