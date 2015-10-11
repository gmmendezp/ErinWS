package com.devon.controller;

import com.devon.model.component.Form;
import com.devon.model.component.Message;
import com.devon.service.ConflictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebsocketController {

	@Autowired
	ConflictService conflictService;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@MessageMapping("/Components/{conflictId}/Message")
	@SendTo("/Output/Components")
	public Message postConflictMessage(@RequestBody Message message, @DestinationVariable String conflictId) {
		conflictService.addConflictMessage(conflictId, message);
		return message;
	}

	@MessageMapping("/Components/{conflictId}/Form")
	@SendTo("/Output/Components")
	public Form postConflictForm(@RequestBody Form form, @DestinationVariable String conflictId) {
		conflictService.addConflictForm(conflictId, form);
		return form;
	}
}
