/*package com.trabajoFinal.app.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.trabajoFinal.app.Model.Login;
import com.trabajoFinal.app.Repository.ILoginRepository;

@Service
public class LoginServiceImpl implements ILoginService{

	@Autowired
	private ILoginRepository iloginRepository;


	@Override
	@Transactional(readOnly=true)
	public Iterable<Login> findAll() {
		return iloginRepository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Page<Login> findAll(org.springframework.data.domain.Pageable pageable) {
		return iloginRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Login> findById(Long id) {
		return iloginRepository.findById(id);
	}

	@Override
	@Transactional
	public Login save(Login login) {
		return iloginRepository.save(login);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		iloginRepository.deleteById(id);
	}

}
*/
