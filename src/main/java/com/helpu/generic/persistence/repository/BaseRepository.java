package com.helpu.generic.persistence.repository;

public class BaseRepository<T> {

	public void save(Object targetObject) {
		System.out.println("save " + targetObject + "...");
	}
	
	public void delete(Object targetObject) {
		System.out.println("delete " + targetObject + "...");
	}
	
	public void update(Object targetObject) {
		System.out.println("update " + targetObject + "...");
	}
	
	public Object getBeanById(String id) {
		System.out.println("get bean by " + id + "...");
		return null;
	}
}
