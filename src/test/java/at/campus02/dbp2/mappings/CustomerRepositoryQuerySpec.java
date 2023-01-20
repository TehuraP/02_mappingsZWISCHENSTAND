package at.campus02.dbp2.mappings;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class CustomerRepositoryQuerySpec {

    private Customer customer1;
    private Customer customer2;
    private Customer customer3;
    private Customer customer4;
    private Customer customer5;
    private Customer customer6;
    private Customer customer7;

    private void setupCommonTEstdata(){
        customer1 = new Customer();
        customer1.setFirstname("Albert");
        customer1.setLastname("Aarhus");
        customer1.setAccountType(AccountType.BASIC);
        customer1.setRegisteredSince(LocalDate.of(2022,1,1));

        customer2 = new Customer();
        customer2.setFirstname("Bernadette");
        customer2.setLastname("Brandtner");
        customer2.setAccountType(AccountType.PREMIUM);
        customer2.setRegisteredSince(LocalDate.of(2022,2,2));

        customer3 = new Customer();
        customer3.setFirstname("Charlie");
        customer3.setLastname("Chandler");
        customer3.setAccountType(AccountType.PREMIUM);
        customer3.setRegisteredSince(LocalDate.of(2022,3,3));

        customer4 = new Customer();
        customer4.setFirstname("Dorli");
        customer4.setLastname("Dornacher");
        customer4.setAccountType(AccountType.BASIC);
        customer4.setRegisteredSince(LocalDate.of(2022,4,4));

        customer5 = new Customer();
        customer5.setFirstname("Emil");
        customer5.setLastname("Eberhard");
        customer5.setAccountType(AccountType.PREMIUM);
        customer5.setRegisteredSince(LocalDate.of(2022,5,5));

        customer6 = new Customer();
        customer6.setFirstname("Charlotte");
        customer6.setLastname("Eberstolz");
        customer6.setAccountType(AccountType.BASIC);
        customer6.setRegisteredSince(LocalDate.of(2022,6,6));

        customer7 = new Customer();
        customer7.setFirstname("Bernhards");
        customer7.setLastname("Hornbacher");
        customer7.setAccountType(AccountType.BASIC);
        customer7.setRegisteredSince(LocalDate.of(2022,7,7));

        manager.getTransaction().begin();
        manager.persist(customer1);
        manager.persist(customer2);
        manager.persist(customer3);
        manager.persist(customer4);
        manager.persist(customer5);
        manager.persist(customer6);
        manager.persist(customer7);
        manager.getTransaction().commit();
    }

    private EntityManagerFactory factory;
    private EntityManager manager;
    private CustomerRepository repository;

    @BeforeEach
    public void beforeEach() {
        factory = Persistence.createEntityManagerFactory("persistenceUnitName");
        manager = factory.createEntityManager();
        repository = new CustomerRepositoryJpa(factory);
    }

    @AfterEach
    public void afterEach() {
        if(manager.isOpen())
            manager.close();
        if(factory.isOpen())
            factory.close();
    }

}
