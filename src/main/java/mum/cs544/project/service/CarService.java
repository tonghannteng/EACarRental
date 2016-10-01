package mum.cs544.project.service;

import java.util.List;

import mum.cs544.project.domain.Car;

public interface CarService {
	
	public Car save(Car car);

	public List<Car> findByName(String name);

	public List<Car> getAll();

	void delete(Integer id);

	Car findById(int id);

	public void edit(Car car);
    
	Car findByCarname(String carName);

}
