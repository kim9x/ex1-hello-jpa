package study.ex1hellojpa.hellojpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try {
			// code 
//			Member member = new Member();
//			member.setId(2L);
//			member.setName("HelloB");
			
//			Member findMember = em.find(Member.class, 1L);
//			findMember.setName("HelloJPA");
//			System.out.println("findMember.id = " + findMember.getId());
//			System.out.println("findMember.name = " + findMember.getName());
			
//			em.remove(findMember);
			
			List<Member> result = em.createQuery("select m from Member m", Member.class)
									.setFirstResult(5)
									.setMaxResults(8)
									.getResultList();
			
			for (Member member : result) {
				System.out.println("member = " + member.getName()); 
			}
			
//			em.persist(member);
			
			tx.commit(); 
			
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();	
		} finally {
			em.close();			
		}
		 
		emf.close();
		
		
	}

}
