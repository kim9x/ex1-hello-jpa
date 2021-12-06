package study.ex1hellojpa.hellojpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Locker {
	
	@Id @GeneratedValue
	private Long id;
	
	@OneToOne(mappedBy = "locker")
	private String name;

}
