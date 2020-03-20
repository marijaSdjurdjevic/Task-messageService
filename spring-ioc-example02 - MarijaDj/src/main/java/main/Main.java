package main;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.MyBeanConfig;
import repository.IRepository;
import service.MessageService;


public class Main {
	
	public static void main(String[] args) {

		//Main main = new Main();
		
		//2. main necemo da kreiramo preko new operatora
		BeanFactory container = new AnnotationConfigApplicationContext(MyBeanConfig.class);
		Main main = container.getBean("main", Main.class);
		
		main.annotationConfig();
		main.saveMessage("Gladan sam!!!");
	}

	private void annotationConfig() {
		BeanFactory container = new AnnotationConfigApplicationContext(MyBeanConfig.class);
		IRepository txtRepository = (IRepository)container.getBean("txtRepository");
		txtRepository.save("My plain message!");
		
		IRepository xmlRepository = container.getBean("xmlRepository", IRepository.class);
		xmlRepository.save("My xml message!");
		
		//ne bi bilo lose da zatvorimo  container svaki put kad zavrsimo
		((AnnotationConfigApplicationContext)container).close();
	}
	
	private void saveMessage(String message) { 
		//1. U zavisnosti od nekog uslova cuvamo poruku u txt repository ili xml repository
		
		
		BeanFactory container = new AnnotationConfigApplicationContext(MyBeanConfig.class);
		MessageService messageService = 
				container.getBean("messageService", MessageService.class);
		messageService.save(message);
		((AnnotationConfigApplicationContext)container).close();
	}
}
