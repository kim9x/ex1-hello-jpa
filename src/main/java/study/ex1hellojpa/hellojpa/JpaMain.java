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
		tx.begin();
		
		try {
			Team team = new Team();
			team.setName("teamA");
			em.persist(team);
			
			Member member1 = new Member();
			member1.setUsername("member1");
			member1.setTeam(team);
			em.persist(member1);  
			
			em.flush();
			em.clear();
			
//			Member m = em.find(Member.class, member1.getId());
			
//			System.out.println("m = " + m.getTeam().getClass());
			
//			System.out.println("====================");
//			m.getTeam().getName(); // 초기화
//			System.out.println("====================");
			
			// fetch 조인 사용 시 필요한 경우 쿼리 한번으로 관계된 데이터를 모두 가져옴
			List<Member> members = em.createQuery("select m from Member m join fetch m.team"  , Member.class)
											.getResultList();
			
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
