package com.example.SpringDataJDBCSample;

import com.example.demo.entity.Member;
import com.example.demo.repository.MemberCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataJdbcSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJdbcSampleApplication.class, args)
				.getBean(SpringDataJdbcSampleApplication.class).execute();
	}

	@Autowired
	MemberCrudRepository repository;

	private void execute(){
		executeInsert();
		executeSelect();
	}
	private void executeInsert(){
		Member member = new Member(null, "이순신");
		member = repository.save(member);
		System.out.println("registered data: " + member);
	}

	private void executeSelect(){
		System.out.println("select entire data");
		Iterable<Member> members = repository.findAll();
		for (Member member: members){
			System.out.println(member);
		}
	}

}
