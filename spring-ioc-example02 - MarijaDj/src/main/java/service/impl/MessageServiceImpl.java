package service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import repository.IRepository;
import service.MessageService;

@Service(value = "messageService")
public class MessageServiceImpl implements MessageService {
	private IRepository repository;
	
	private MessageService messageService;
	
	
	public MessageServiceImpl(MessageService messageService) {
		super();
		this.messageService = messageService;
	}

	/*
	public MessageServiceImpl(IRepository repository) {
		this.repository = repository;
	}
	*/
	
	public void save(String message) {
		repository.save(message);
	}
	
	/*
	@Autowired
	@Qualifier(value ="xmlRepository")
	*/
	
	@Resource(name = "xmlRepository")
	public void setRepository(IRepository repository) {
		this.repository = repository;
	}
	
	
}
