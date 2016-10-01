package mum.cs544.project.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mum.cs544.project.domain.User;
import mum.cs544.project.repository.UserRepository;
import mum.cs544.project.service.UserService;


@Service
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
	UserRepository userRepository;
	
	@Override
	public User save(User user) {
		//user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		return user;
	}

	@Override
	public List<User> findByName(String firstName) {
		return null;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return (List<User>) userRepository.findAll();
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		userRepository.delete(id);
		
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return userRepository.findOne(id);
	}

	@Override
	public void edit(User user) {
		userRepository.save(user);
		
		
	}

	@Override
	public User findByUsername(String userName) {
		// TODO Auto-generated method stub
		return userRepository.findByUserName(userName);
	}

	
}
