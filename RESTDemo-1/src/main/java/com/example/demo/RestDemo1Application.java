package com.example.demo;

import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class RestDemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(RestDemo1Application.class, args);
	}
}

@RestController
class DocRestController{
	
	@RequestMapping("/doctor")
	Collection<Doctor> doctor(){
		return this.docrepo.findAll();
	}
	@Autowired 	DoctorRepo docrepo;
}

@Entity
class Doctor{
	@Id @GeneratedValue
	private Long ID;
	private String Name;
	public Doctor(String Name) {
		super();
		this.Name= Name;
	}
	
	public Doctor() {
	}
	public Long getID() {
		return ID;
	}
	
	public String getName() {
		return Name;
	}
	
	public void setID(Long iD) {
		ID = iD;
	}
	
	public void setName(String name) {
		Name = name;
	}
	
	@Override
	public String toString() {
		return "Doctor [ID=" + ID + ", Name=" + Name + "]";
	}	
}

@Component
class DemoCommandLineRunner implements CommandLineRunner{

	@Override
	public void run(String... arg0) throws Exception {
		for(Doctor d: this.Docrepo.findAll())
			System.out.println(d.toString());
	}
	@Autowired DoctorRepo Docrepo;
	
}
interface DoctorRepo extends JpaRepository<Doctor, Long>{
	
	Collection<Doctor> findbyName(String Name);
}

