package com.auth.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//8th
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse {
	String token;

	public void setToken(String token) {
		this.token = token;
	}
}
