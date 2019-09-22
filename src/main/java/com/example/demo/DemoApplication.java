package com.example.demo;

import com.example.demo.dao.PrivilegeEntity;
import com.example.demo.dao.RoleEntity;
import com.example.demo.dao.UserEntity;
import com.example.demo.dao.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class DemoApplication  implements WebMvcConfigurer, CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {

		UserEntity userEntity = new UserEntity();

		Set<RoleEntity> roles = new HashSet<>();
		RoleEntity roleEntity1 = new RoleEntity();
		roleEntity1.setRoleName("Role1");
		roles.add(roleEntity1);
		RoleEntity roleEntity2 = new RoleEntity();
		roleEntity1.setRoleName("Role2");
		roles.add(roleEntity2);
		RoleEntity roleEntity3 = new RoleEntity();
		roleEntity1.setRoleName("Role3");
		roles.add(roleEntity3);
		userEntity.setRoles(roles);

		Set<PrivilegeEntity> privilegeEntities = new HashSet<>();
		PrivilegeEntity privilegeEntity1 = new PrivilegeEntity();
		privilegeEntity1.setPrivilegeName("Privilege1");
		privilegeEntities.add(privilegeEntity1);
		PrivilegeEntity privilegeEntity2 = new PrivilegeEntity();
		privilegeEntity1.setPrivilegeName("Privilege2");
		privilegeEntities.add(privilegeEntity2);

		roles.forEach(roleEntity -> {

			roleEntity.setPrivileges(privilegeEntities);
		});
	//	userRepository.save(userEntity);

	}

	@Bean
	public MappingJackson2HttpMessageConverter jacksonMessageConverter(){
		MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
		ObjectMapper mapper = new ObjectMapper();
		//Registering Hibernate4Module to support lazy objects
		Hibernate5Module module = new Hibernate5Module();

		mapper.registerModule(new Hibernate5Module());
		messageConverter.setObjectMapper(mapper);
		return messageConverter;

	}


	public void configureMessageConverters(List<HttpMessageConverter<?>> messageConverters) {
		//Here we add our custom-configured HttpMessageConverter

		//messageConverters.add(jacksonMessageConverter());
		System.out.printf("ccc");
	}
}
