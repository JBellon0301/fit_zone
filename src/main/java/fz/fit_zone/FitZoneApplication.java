package fz.fit_zone;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fz.fit_zone.model.Client;
import fz.fit_zone.service.IClientService;

@SpringBootApplication
public class FitZoneApplication implements CommandLineRunner {

	@Autowired
	private IClientService clientService;

	private static final Logger logger = 
			LoggerFactory.getLogger(FitZoneApplication.class);

	String nl = System.lineSeparator();

	public static void main(String[] args) {
		
		logger.info("Initializing the Application");
		//Release the Spring factory
		SpringApplication.run(FitZoneApplication.class, args);
		logger.info("Application finalized!");
	}

	@Override
	public void run(String... args) throws Exception {
		fitZoneAPP();
	}

	private void fitZoneAPP(){
		var leave = false;
		var console = new Scanner(System.in);
		while(!leave){
			var option = showMenu(console);
			leave = executeOptions(console, option);
			logger.info(nl);
		}
	}

	private int showMenu(Scanner console){
		logger.info("""
		\n *** Fit Zone Application ***
		1. List Clients
		2. Search Client
		3. Add Client
		4. Modify Client
		5. Remove Client
		6. Leave
		Chose and option:\n""");
		return Integer.parseInt(console.nextLine());
		
	}

	private boolean executeOptions(Scanner console, int option){
		var leave = false;
		switch (option){
			case 1 -> {
				logger.info(nl + "***Listing Clients***" + nl);
				List<Client> clients = clientService.listClient();
				clients.forEach(client -> logger.info(client.toString()+ nl));
			}
			case 2 -> {
				logger.info(nl + "***Search Client by Id***" + nl );
				var idClient = Integer.parseInt(console.nextLine());
				Client client = clientService.searchClientById(idClient);
				if(client != null)
					logger.info("Client founded: " + client + nl);
				else
					logger.info("Client not founded: " + client + nl);
			}

			case 3 ->{
				logger.info("***Add Client***" + nl);
				logger.info("Name: ");
				var name_client = console.nextLine();
				logger.info("Last name: ");
				var last_name = console.nextLine();
				logger.info("Email: ");
				var email_client = console.nextLine();
				var client = new Client();
				client.setName_client(name_client);
				client.setLast_name_client(last_name);
				client.setEmail_client(email_client);
				client.setDate_registered(new Date());
				clientService.saveClient(client);
				logger.info("Client added" + client + nl);
			}

			case 4 -> {
				logger.info("***Modify Client***" + nl);
				logger.info("Id client: ");
				var idClient = Integer.parseInt(console.nextLine());
				Client client = clientService.searchClientById(idClient);
				if(client != null){
					logger.info("Name: ");
					var name_client = console.nextLine();
					logger.info("Last Name: ");
					var last_name = console.nextLine();
					logger.info("Email: ");
					var email_client = console.nextLine();
					client.setName_client(name_client);
					client.setLast_name_client(last_name);
					client.setEmail_client(email_client);
					clientService.saveClient(client);
					logger.info("Client modified " + client + nl);
				}
				else
					logger.info("Client not founded " + client + nl);

			}

			case 5 -> {
				logger.info("***Remove Client***" + nl);
				logger.info("Id client: ");
				var idClient = Integer.parseInt(console.nextLine());
				var client = clientService.searchClientById(idClient);
				if(client != null){
					clientService.removeClient(client);
					logger.info("Client Removed: " + client + nl );
				}
				else
					logger.info("Client not removed " + client + nl);

			}

			case 6 ->{
				logger.info("See you later!" + nl + nl);
				leave = true;
			}
		}
		return leave;
	}
}
