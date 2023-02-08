package com.angelehl.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningController {
	
	@GetMapping("/v1/person")
	public PersonV1 getFirstVersion() {
		
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping("/v2/person")
	public PersonV2 getSecondVersion() {
		
		return new PersonV2(new Name("Bob", "Charlie"));
	}
	
	@GetMapping(path = "/person",params = "version=1")
	public PersonV1 getFirstVersionAndParams() {
		
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping(path = "/person",params = "version=2")
	public PersonV2 getSecondVersionAndParams() {
		
		return new PersonV2(new Name("Bob", "Charlie"));
	}
	
	@GetMapping(path = "/person/header",headers = "X-API-VERSION=1")
	public PersonV1 getFirstVersionAndHeader() {
		
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping(path = "/person/header",headers = "X-API-VERSION=2")
	public PersonV2 getSecondVersionAndHeaders() {
		
		return new PersonV2(new Name("Bob", "Charlie"));
	}
	
	@GetMapping(path = "/person/accept",produces = "application/vnd.company.app-v1+json")//"produces" needs to match with the header in request
	public PersonV1 getFirstVersionAndAcceptHeaders() {
		
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping(path = "/person/accept",produces = "application/vnd.company.app-v2+json")//"produces" needs to match with the header in request
	public PersonV2 getSecondVersionAndAcceptHeaders() {
		
		return new PersonV2(new Name("Bob", "Charlie"));
	}
	
	
}
