package com.player.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * Proxy interface for authorization service
 */
@FeignClient(name = "authorization-service", url = "http://localhost:8081}")
public interface AuthorizationClient {

	/**
	 * Method for validating the token
	 * 
	 * @param token
	 * @return This returns true if token is valid else returns false
	 */
	@GetMapping("/getToken")
	public String getToken(@RequestHeader(name = "Authorization") String token);
}