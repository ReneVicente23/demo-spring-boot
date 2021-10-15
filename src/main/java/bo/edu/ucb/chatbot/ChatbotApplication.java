package bo.edu.ucb.chatbot;

import bo.edu.ucb.chatbot.bl.FilmSearchBl;
import bo.edu.ucb.chatbot.dao.FilmDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class ChatbotApplication {

	@Bean
	public FilmDao filmDao(DataSource dataSource) {
		return new FilmDao(dataSource);
	}

	@Bean
	public FilmSearchBl filmSearchBl(FilmDao filmDao) {
		return new FilmSearchBl(filmDao);
	}

	public static void main(String[] args) throws  Exception{
		SpringApplication.run(ChatbotApplication.class, args);
	}

//	@Value("${myapp.store}")
//	private String store;
//
//	@Bean
//	public PersonStore personStore() {
//		if("mysql".equals(store)) {
//			return new PersonMysql();
//		} else {
//			return new PersonFirebase();
//		}
//	}
//
//	@Bean
//	public PersonBL personBL(PersonStore personStore) {
//		return new PersonBL(personStore);
//	}
//
//	public static void main(String[] args) throws  Exception{
//		ApplicationContext context = SpringApplication.run(ChatbotApplication.class, args);
//		PersonBL personBL = context.getBean(PersonBL.class);
//		personBL.mainLogic();
//
////		PersonBL personBL = new PersonBL();
////		personBL.mainLogic();
//
///*
//		PersonStore personStore = (PersonStore) Class.forName(args[0]).newInstance();
//		//PersonStore personStore = new PersonMysql();
//		personStore.persistPerson(new Person("Juan", "Perez"));
// */
//	}

}
