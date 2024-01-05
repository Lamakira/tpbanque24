package bj.ifri.tpbanque23;

import bj.ifri.tpbanque23.entities.*;
import bj.ifri.tpbanque23.repositories.AgenceRepository;
import bj.ifri.tpbanque23.repositories.BanqueRepository;
import bj.ifri.tpbanque23.repositories.ClientRepository;
import bj.ifri.tpbanque23.repositories.CompteBancaireRepository;
import bj.ifri.tpbanque23.repositories.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;

import java.util.List;

@SpringBootApplication
@EnableAutoConfiguration
public class Tpbanque23Application {

	@Autowired
	private BanqueRepository banqueRepository;
	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private AgenceRepository agenceRepository;

	@Autowired
	private EmployeRepository employeRepository;

	@Autowired
	private CompteBancaireRepository compteBancaireRepository;

	public static void main(String[] args) {
		SpringApplication.run(Tpbanque23Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx){
		return args  -> {
            //Juste pour avoir des données dans la base de donnée au cas ou celle ci est vide

            List<Banque> banques = this.banqueRepository.findAll();
			//Create some banks
			Banque banque1 = new Banque("0001BOA", 12000000, "Cotonou Haie vive", new int[]{15, 12, 14}, new String[]{"cotonou", "parakou"});
			banque1 = this.banqueRepository.save(banque1);
			Banque banque2 = new Banque("0002NSAI", 19000000, "Cotonou Cadjehoun", new int[]{22, 87, 45}, new String[]{"cotonou", "portonovo", "abomey"});
			banque2 = this.banqueRepository.save(banque2);

			// Create some agences and associate them with the banks
			Agence agence1 = new Agence("000076", "Agence 1", "Segbeya", "Cotonou", "229", "ARIKAMA Said", "0001BOA");
			agence1.setBanque(banque1); // Associate agence1 with banque1
			this.agenceRepository.save(agence1); // Save agence1, which now has a reference to banque1

			Agence agence2 = new Agence("000077", "Agence 2", "Goho", "Abomey", "229", "AHOGNISSE Ariel", "0002NSAI");
			agence2.setBanque(banque1); // Associate agence2 with banque2
			this.agenceRepository.save(agence2); // Save agence2, which now has a reference to banque2

            //Create some employees
			Employe em1 = new Employe("DOSSA", "Paul", "Abomey", 350000, 5896, "0001BOA");
			Employe em2 = new Employe("FAVI", "Aristide", "Calavi", 350000, 5897, "0002NSAI");

            em1.setAgence(agence1);
			em2.setAgence(agence2);

			List<Employe> savedEmployes = this.employeRepository.saveAll(List.of(em1, em2));

			// Create Client instances
			Client client1 = new Client("CL0000000876", "RAIMI", "Nabil", "Cotonou", "BOKO", "Jean","Abomey");
			Client client2 = new Client("CL0000008776", "ALINKAN", "Ariel", "Abomey", "Doe", "John", "Calavi");
			Client client3 = new Client("CL0000001706", "DOE", "John", "Ouidah", "AMOUSSOU", "X", "Tankpe");

			// Set the Agence reference for each Client
			client1.setAgence(agence1); // Link first client to agence1
			client2.setAgence(agence1); // Link second client to agence1
			client3.setAgence(agence2); // Link third client to agence2
			client1.setEmploye_id(em1);
			client2.setEmploye_id(em1);
			client3.setEmploye_id(em2);

			// Save all clients to the database
			List<Client> savedClients = this.clientRepository.saveAll(List.of(client1, client2, client3));

			//Create some bank account
			CompteBancaire cb1 = new CompteBancaire("CB01", 250000, 010123, "ALIKAN", "Ariel", "000077", "0002NSAI");
			CompteBancaire cb2 = new CompteBancaire("CB02", 22550000, 010124, "ALIKAN", "Ariel", "000077", "0002NSAI");
			CompteBancaire cb3 = new CompteBancaire("CB03", 50000, 010223, "AMOUSSOU", "BRICE", "000076", "0001BOA");

			cb1.setClient_id(client1);
			cb2.setClient_id(client2);
			cb3.setClient_id(client3);

			List<CompteBancaire> savedCompteBancaires = this.compteBancaireRepository.saveAll(List.of(cb1, cb2, cb3));

			System.out.println("Banques enrégistrées avec succès au nombre de :" + banqueRepository.count());
			System.out.println("CB enrégistrées avec succès au nombre de : " + compteBancaireRepository.count());
			System.out.println("Agences enrégistrées avec succès au nombre de : " + agenceRepository.count());
        };
	}
}
