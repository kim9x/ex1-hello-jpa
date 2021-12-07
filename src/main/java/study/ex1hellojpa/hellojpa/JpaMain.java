package study.ex1hellojpa.hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnitUtil;

import org.hibernate.Hibernate;

public class JpaMain {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try {
			
			Member member1 = new Member();
			member1.setUsername("member1");
			em.persist(member1);
			
//			Member member2 = new Member();
//			member2.setUsername("member2");
//			em.persist(member2);
			
			em.flush();
			em.clear();
			
			//
//			Member findMember = em.find(Member.class, member.getId());
//			Member findMember = em.getReference(Member.class, member1.getId());
			
//			Member m1 = em.find(Member.class, member1.getId());
//			Member m2 = em.getReference(Member.class, member2.getId());
			
//			System.out.println("m1 = " + m1.getClass());
			
			Member refMember = em.getReference(Member.class, member1.getId());
			System.out.println("refMember = " + refMember.getClass());
			System.out.println("isLoaded Before = " + emf.getPersistenceUnitUtil().isLoaded(refMember));
			refMember.getUsername();
			System.out.println("isLoaded After = " + emf.getPersistenceUnitUtil().isLoaded(refMember));
			
			Hibernate.initialize(refMember); // 강제 초기화
			
//			
//			logic(m1, m2);
			
			
			tx.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();	
		} finally { }
		 
 		emf.close();
		
		
	}

	private static void logic(Member m1, Member m2) {
//		System.out.println("m1 == m2: " + (m1.getClass() == m2.getClass()));
		System.out.println("m1 == Member: " + (m1 instanceof Member));
		System.out.println("m2 == Member: " + (m2 instanceof Member));
	}

}
