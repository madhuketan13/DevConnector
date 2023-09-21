package com.dnb.devconnector;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.dnb.devconnector.dto.DevConnector;
import com.dnb.devconnector.dto.Profile;
import com.dnb.devconnector.service.DevConnectorService;
import com.dnb.devconnector.service.ProfileService;

@SpringBootApplication
public class DevConnectorApplication {

    private static DevConnectorService devConnectorService;
    private static ProfileService profileService;

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(DevConnectorApplication.class, args);

        devConnectorService = applicationContext.getBean(DevConnectorService.class);
        profileService = applicationContext.getBean(ProfileService.class);

        Scanner scanner = new Scanner(System.in);
        boolean run = true;

        while (run) {
            System.out.println("Choose an option:");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    registerUser();
                    break;
                case 2:
                	login();
                    break;
                case 3:
                	run = false;
                    break;
            }
        }
    }

    private static void registerUser() {
        DevConnector user = new DevConnector();
        Profile profile = new Profile();

        user.setUserName("naiksubh");
        user.setEmailAddress("naiksubh@gmail.com");
        user.setPassword("929382928");

        profile.setProfessionalStatus("developer");
        profile.setCompany("D&B");
        profile.setGithubUsername("naiksubh45");
        profile.setLocation("Hyderabad");
        profile.setSkills("HTML,CSS,JS");
        profile.setWebsite("www.github.com");

        DevConnector userWithProfile = devConnectorService.register(user, profile);
        profileService.createProfile(userWithProfile.getProfile());
    }
    
    private static void login() {
    	
    	Scanner sc = new Scanner(System.in);
    	
    	String email = sc.next();
    	String password = sc.next();
    	
    	DevConnector user = devConnectorService.findByemailAddress(email);
    	
    	if(user.getEmailAddress().equals(email) && user.getPassword().equals(password)) {
    		devConnectorService.findByemailAddress(email);
    	}
    }
    
    
}

