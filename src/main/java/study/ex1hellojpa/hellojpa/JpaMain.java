package study.ex1hellojpa.hellojpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnitUtil;
import javax.persistence.TypedQuery;

import org.hibernate.Hibernate;

public class JpaMain {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin() ;
		
		try {
			
			Address address = new Address("city", "street", "10000");
			
			Member member = new Member();
			member.setUsername("member1");
			member.setHomeAddress(address);
			em.persist(member);
			
			Address copyAddress = new Address(address.getCity(), address.getStreet(), address.getZipCode());
			
			Member member2 = new Member();
			member2.setUsername("member1");
			member2.setHomeAddress(copyAddress);
			em.persist(member2);
			
			//
			member.getHomeAddress().setCity("newCity");
			
			tx.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();	
		} finally { }
		 
 		emf.close();
		
		
	}

}
