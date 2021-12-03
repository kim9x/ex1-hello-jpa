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
			
			// 특정 엔티티만 준영속 상태로 전환
//			em.detach(member);
			// 영속성 컨텍스트 초기화
			// 테스트 케이스 같은 것들 작성 할 때 쿼리 볼 때 사용할 수 있음.
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
