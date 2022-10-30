package com.dto.modelmapper;

import com.dto.modelmapper.model.Location;
import com.dto.modelmapper.model.User;
import com.dto.modelmapper.repository.LocationRepository;
import com.dto.modelmapper.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DtoModelMapper implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DtoModelMapper.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();

	}

	@Autowired
	private UserRepository userRepository;


	@Autowired
	private LocationRepository locationRepository;

	@Override
	public void run(String... args) throws Exception {

		Location location = new Location();
		location.setPlace("pune");
		location.setDescription("pune is  great place to live");
		location.setLongitude(40.5);
		location.setLatitude(30.6);
		locationRepository.save(location);

		User user1 = new User();
		user1.setFirstName("Ramesh");
		user1.setLastName("angulo");
		user1.setEmail("carles1981@gmail.com");
		user1.setPassword("aokkok");
		user1.setLocation(location);
		userRepository.save(user1);

		User user2 = new User();
		user2.setFirstName("julian");
		user2.setLastName("angulo");
		user2.setEmail("carles1981@gmail.com");
		user2.setPassword("aokkok");
		user2.setLocation(location);
		userRepository.save(user2);


	}
}