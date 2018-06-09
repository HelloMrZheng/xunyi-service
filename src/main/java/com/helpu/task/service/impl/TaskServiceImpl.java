package com.helpu.task.service.impl;

import org.springframework.stereotype.Service;

import com.helpu.task.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

	public void save() {
		System.out.println("TaskServiceImpl save ...");
	}

}
