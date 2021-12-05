package study.ex1hellojpa.hellojpa;

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
			
			Team team = new Team();
			team.setName("TeamA");
			em.persist(team);
			
			Member member = new Member();
			member.setUsername("member1");
			/* 
			member.setTeamId(team.getId());
			em.persist(member);
			
			Member findMember = em.find(Member.class, member.getId());
			
			Long findTeamId = findMember.getTeamId();
			Team findTeam = em.find(Team.class, findTeamId);
			*/
			
			member.setTeam(team);
			em.persist(member);
			
//			em.flush();
//			em.clear();
			
			Member findMember = em.find(Member.class, member.getId());
			
			Team findTeam = findMember.getTeam();
			System.out.println("findTeam = " + findTeam);
			
			tx.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();	
		} finally { }
		 
		emf.close();
		
		
	}

}
