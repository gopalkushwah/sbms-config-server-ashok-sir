**************************************************
# Config Server
*******************************************

It is based on the open-source Spring Cloud Config project, which provides a centralized server for delivering external configuration properties to an application and a central source for managing this configuration across deployment environments.


## How to develop a config server

-  Add this Dependency 

```
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-config-server</artifactId>
</dependency>
```

- Enable Config Server

~~~
@SpringBootApplication
@EnableConfigServer
public class SbmsConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbmsConfigServerApplication.class, args);
	}

}
~~~

- ``application.yml`` file

```
spring:
  application:
    name: SBMS_ConfigServer
  cloud:
    config:
      server:
        git:
          uri: https://github.com/gopalkushwah/sbms-config-server-ashok-sir    # git repo uri
          clone-on-start: true     # to clone the repo
          search-paths: config     
          default-label: ConfigYmlFiles   # repo name
```

- Now run the Application


*****************************************
# Config Client Developement
***********************************

- Create a spring boot config client application ( Rest Api )
- Add this Dependencies

```
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-config</artifactId>
</dependency>
```

- ``application.yml`` file only for specifying port number and config server information

```
spring:
  application:
    name: WELCOME    # application name must be same a the file name present on the git repo  -- welcome.yml
  config:
    import: optional:configserver:http://localhost:8080
    
server:
  port: 8082
```

put all the related configuration in greet.yml file which should be present in the git repo.
it may contain
   - smtp config
   - database config
   - and all other configurations

### create a rest controller

```
@RestController
public class GreetController {
	@Value("${msg}")   //used to get the value of msg property from yml file
	private String mesg;
	
	@GetMapping("/welcome")
	public String greetMsg() {
		return mesg;
	}
}
```





