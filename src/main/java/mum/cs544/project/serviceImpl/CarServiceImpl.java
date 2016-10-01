package mum.cs544.project.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mum.cs544.project.domain.Car;
import mum.cs544.project.repository.CarRepository;
import mum.cs544.project.repository.CarTypeRepository;
import mum.cs544.project.service.CarService;

@Service
@Transactional
public class CarServiceImpl implements CarService {

	@Autowired
	CarRepository carRepository;

	@Autowired
	CarTypeRepository carTypeRepository;

	@Override
	public Car save(Car car) {
		// TODO Auto-generated method stub
		carRepository.save(car);
		return car;
	}

	@Override
	public List<Car> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Car> getAll() {
		// TODO Auto-generated method stub
		return (List<Car>) carRepository.findAll();
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		carRepository.delete(id);

	}

	@Override
	public Car findById(int id) {
		// TODO Auto-generated method stub
		return carRepository.findOne(id);
	}

	@Override
	public void edit(Car car) {
		// TODO Auto-generated method stub
		Car carToUpdate = carRepository.findOne(car.getId());
		car.getCarType().setId(carToUpdate.getCarType().getId());
		carRepository.save(car);
		carTypeRepository.save(car.getCarType());
	}

	@Override
	public Car findByCarname(String carName) {
		// TODO Auto-generated method stub
		return carRepository.findByName(carName);
	}

}
