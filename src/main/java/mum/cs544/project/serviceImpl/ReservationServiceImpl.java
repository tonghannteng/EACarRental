package mum.cs544.project.serviceImpl;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mum.cs544.project.domain.Car;
import mum.cs544.project.domain.Reservation;
import mum.cs544.project.domain.User;
import mum.cs544.project.repository.ReservationRepository;
import mum.cs544.project.service.CarSearchService;
import mum.cs544.project.service.ReservationService;
import mum.cs544.project.service.UserService;
import mum.cs544.project.utilities.mail.MailService;


@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {
	@Autowired
	ReservationRepository reservationRepository;
	@Autowired
	UserService userService;
	@Autowired
	CarSearchService carSearchService;
	@Autowired
	MailService mailService;
	@PostConstruct
	public void initmethod() {

	}
	@Override
	public Reservation save(Reservation reservation) {
		reservation.setId(10000);
		reservationRepository.save(reservation);
		return reservation;
	}

	@Override
	public List<Reservation> findById(Integer id) {
		return null;
	}

	@Override
	public List<Reservation> getAll() {
		// TODO Auto-generated method stub
		return (List<Reservation>) reservationRepository.findAll();
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		reservationRepository.delete(id);
		
	}

	@Override
	public Reservation findById(int id) {
		// TODO Auto-generated method stub
		return reservationRepository.findOne(id);
	}

	@Override
	public void edit(Reservation rTest) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String reserve(String carId, String fromLocation, String toLocation, Date fromDate, Date toDate) {
		User user = userService.findById(1);
		Car car = carSearchService.findById(Integer.parseInt(carId));
		Reservation reservation = new Reservation(fromDate, fromLocation, toDate, toLocation, car, user);
		save(reservation);
		mailService.setToAddress("esaaqo@gmail.com");
		mailService.setBody(fromDate + " " + fromLocation + " " + toDate + "" + toLocation);
		mailService.setSubject("Your reservation is successful");
		mailService.sendMail();
		return "success";
	}
}
