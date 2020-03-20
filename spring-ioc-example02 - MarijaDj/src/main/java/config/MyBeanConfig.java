package config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import main.Main;
import service.MessageService;
import service.impl.MessageServiceImpl;

@ComponentScan(basePackages = {
		"repository",
		"service"
})
public class MyBeanConfig {
	
	@Bean (name = "main")
	public Main getMain() {
		return new Main();
	}
	
	@Bean (name = "messageTxtRepositoryService")
	public MessageService getMessageTxtRepositoryService(@Qualifier("txtRepository") MessageService messageService) {
		return new MessageServiceImpl(messageService);
	}
	
	@Bean (name = "messageXmlRepositoryService")
	public MessageService getMessageXmlRepositoryService(@Qualifier("xmlRepository") MessageService messageService) {
		return new MessageServiceImpl(messageService);
	}
	
	/*
	@Bean (name = "userServiceLinkedList")
	public UserService getUserServiceLinkedList (@Qualifier("linkedListDao") UserDao userDao) {
		return new UserServiceImpl(userDao);
	}
	@Bean (name = "userServiceArrayList")
	public UserService getUserServiceArrayList (@Qualifier("arrayListDao") UserDao userDao) {
		return new UserServiceImpl(userDao);
	}
	 */
	
//	@Bean (name = "txtRepository")
//	public IRepository getTxtRepository() {
//		return new TxtRepository();
//	}
//	
//	@Bean (name = "xmlRepository")
//	public IRepository getXMLRepository() {
//		return new XMLRepository();
//	}
//	
////	@Bean (name = "messageService")
////	public MessageService getMessageService() {
////		return new MessageServiceImpl(getXMLRepository());
////	}
//	
//	@Bean (name = "messageService")
//	public MessageService getMessageService() {
//		return new MessageServiceImpl();
//	}
//	MOZEMO I BEZ OVIH BINOVA SA ANOTACIJOM GORE
}
