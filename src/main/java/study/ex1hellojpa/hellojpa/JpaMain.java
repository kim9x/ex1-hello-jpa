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
			
			Member member = new Member();
			member.setUsername("hello");
			member.setHomeAddress(new Address("city", "street", "1000"));
			member.setWorkPeriod(new Period());
			
			em.persist(member);
			
			tx.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();	
		} finally { }
		 
 		emf.close();
		
		
	}

}
