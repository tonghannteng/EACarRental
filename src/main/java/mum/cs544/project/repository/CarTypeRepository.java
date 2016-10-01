package mum.cs544.project.repository;

import org.springframework.data.repository.CrudRepository;

import mum.cs544.project.domain.CarType;

public interface CarTypeRepository extends CrudRepository<CarType, Integer> {

}
