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
			
			/*
			// 비영속
			Member member = new Member();
			member.setId(101L);
			member.setName("HelloJPA");
			
			// 영속
			System.out.println("=== BEFORE ===");
			em.persist(member);
			
			// 영속 해제
//			em.detach(member);
			System.out.println("=== AFTER ===");
			
			// commit 하는 시점에 영속성 컨텍스트에 잇는 것들의 쿼리가 날아감
			tx.commit();
			*/
			
			/*
			Member findMember1 = em.find(Member.class, 101L);
			Member findMember2 = em.find(Member.class, 101L);
			
			System.out.println("result = " + (findMember1 == findMember2));
			*/
			
			/*
			Member member1 = new Member(150L, "A");
			Member member2 = new Member(160L, "B");
			
			em.persist(member1);
			em.persist(member2);
			
			System.out.println("================");
			
			tx.commit();
			*/
			
			/*
			// 값만 바꿔도 update 쿼리를 쳐준다.
			// dirty checking(변경 감지)이라고 함
			// JPA는 collection처럼 다룬다.
			// collection의 값을 변경하고 다시 값을 저장해주지 않듯이
			// JPA 또한 같다.
			// 즉, 따고 persist 해주지 않아도 된다.!
			Member member = em.find(Member.class, 150L);
			member.setName("ZZZZZZ");
			
			System.out.println("===========================");
			tx.commit();
			*/
			
			
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();	
		} finally {
			em.close();			
		}
		 
		emf.close();
		
		
	}

}
