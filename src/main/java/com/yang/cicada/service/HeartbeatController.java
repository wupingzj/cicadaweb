package com.yang.cicada.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeartbeatController {
	@RequestMapping("/heartbeat")
	public String heartbeat(@RequestParam(value = "name", defaultValue = "World") String name) {
		return "This is heartbeat message from cicada web server.";
	}
}
