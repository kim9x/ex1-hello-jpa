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
			
			Member member = em.find(Member.class, 150L);
			member.setName("AAAAA");
			
			// Ư�� ��ƼƼ�� �ؿ��� ���·� ��ȯ
//			em.detach(member);
			// ���Ӽ� ���ؽ�Ʈ �ʱ�ȭ
			// �׽�Ʈ ���̽� ���� �͵� �ۼ� �� �� ���� �� �� ����� �� ����.
			em.clear();
			
			System.out.println("=================");
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
