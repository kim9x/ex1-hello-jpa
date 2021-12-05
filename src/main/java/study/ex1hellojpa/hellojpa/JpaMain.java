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
			Team team = new Team();
			team.setName("TeamA");
//			team.getMembers().add(member);
			em.persist(team);
			
			Member member = new Member();
			member.setUsername("member1");
//			member.changeTeam(team);
			em.persist(member);
			
//			team.getMembers().add(member);
			
			team.addMember(member);
			
//			em.flush();
//			em.clear();
			
			Team findTeam = em.find(Team.class, team.getId()); // 1Â÷ Ä³½Ã
			List<Member> members = findTeam.getMembers();
			
			System.out.println("==========================");
			for (Member m : members) {
				System.out.println("m = " + m.getUsername());
			}
				
//			System.out.println("members = " + findTeam);
			System.out.println("==========================");
			
			tx.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();	
		} finally { }
		 
		emf.close();
		
		
	}

}
