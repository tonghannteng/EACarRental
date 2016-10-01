package mum.cs544.project.serviceImpl;

import java.util.Date;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mum.cs544.project.GPS.LocationUtility;
import mum.cs544.project.domain.Branch;
import mum.cs544.project.domain.Car;
import mum.cs544.project.repository.CarSearchRepository;
import mum.cs544.project.service.CarSearchService;


@Service
@Transactional
public class CarSearchServiceImpl implements CarSearchService {
	@Autowired
	CarSearchRepository carSearchRepository;
	@Autowired
	LocationUtility locationUtility;
	@Override
	public List<Car> search() {
		// TODO Auto-generated method stub
		return (List<Car>) carSearchRepository.search();
	}
	@Override
	public Car findById(Integer id){
		return carSearchRepository.findOne(id);
	}
	@Override
	public Branch atBranch(int carId) {
		return carSearchRepository.atBranch(carId);
	}

	@Override
	public JSONArray search(String fromLocation, String toLocation, Date fromDate, Date toDate) {

		// System.out.println(locationUtility.calculateDistance(locationUtility.getLocationFromAddress(fromLocation),
		// locationUtility.getLocationFromAddress(toLocation)));
		JSONArray CarsAvailable = new JSONArray();
		try {
			List<Car> Cars = search();
			for (int i = 0; i < Cars.size(); i++) {
				Car car = (Car) Cars.get(i);
				Branch branch = atBranch(car.getId());
				String addressString = branch.getAddress().getCity() + ", " + branch.getAddress().getState();
				double distToLocation = locationUtility.calculateDistance(locationUtility
						.getLocationFromAddress(addressString),
						locationUtility.getLocationFromAddress(toLocation));
				double distFromLocation = locationUtility.calculateDistance(
						locationUtility.getLocationFromAddress(addressString),
						locationUtility.getLocationFromAddress(fromLocation));
				JSONObject currentCar = new JSONObject();
				currentCar.put("id", car.getId());
				currentCar.put("name", car.getName());
				currentCar.put("price", car.getPricePerDay());
				currentCar.put("seats", car.getCarType().getNoOfPerson());
				currentCar.put("imageLink", car.getImageLink());
				currentCar.put("year", car.getYear());
				currentCar.put("distToLocation", distToLocation);
				currentCar.put("distFromLocation", distFromLocation);
				currentCar.put("brachId", branch.getId());
				currentCar.put("branchCity", branch.getAddress().getCity());
				currentCar.put("branchState", branch.getAddress().getState());
				currentCar.put("branchZip", branch.getAddress().getZip());
				CarsAvailable.add(currentCar);
			}
		} catch (Exception E) {
			E.printStackTrace();
		}
		return CarsAvailable;
	}
}
