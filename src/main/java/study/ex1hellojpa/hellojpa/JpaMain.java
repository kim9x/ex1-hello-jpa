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
			// �񿵼�
			Member member = new Member();
			member.setId(101L);
			member.setName("HelloJPA");
			
			// ����
			System.out.println("=== BEFORE ===");
			em.persist(member);
			
			// ���� ����
//			em.detach(member);
			System.out.println("=== AFTER ===");
			
			// commit �ϴ� ������ ���Ӽ� ���ؽ�Ʈ�� �մ� �͵��� ������ ���ư�
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
			// ���� �ٲ㵵 update ������ ���ش�.
			// dirty checking(���� ����)�̶�� ��
			// JPA�� collectionó�� �ٷ��.
			// collection�� ���� �����ϰ� �ٽ� ���� ���������� �ʵ���
			// JPA ���� ����.
			// ��, ���� persist ������ �ʾƵ� �ȴ�.!
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
