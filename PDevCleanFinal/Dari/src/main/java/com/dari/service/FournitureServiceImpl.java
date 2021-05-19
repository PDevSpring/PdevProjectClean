package com.dari.service;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.dari.model.FileDB;
import com.dari.model.Fourniture;
import com.dari.model.FournitureType;
import com.dari.model.User;
import com.dari.repository.FileDBRepository;
import com.dari.repository.FournitureRepository;
import com.dari.repository.UserRepository;

@Service
public class FournitureServiceImpl implements FournitureService {

	@Autowired
	FournitureRepository fourrep;
	@Autowired
	UserRepository userrep;

	@Autowired
	private FileDBRepository fileDBRepository;

	@Override
	public Fourniture updateFourniture (Fourniture four) {
		return fourrep.save(four);
	}

	@Override
	public Fourniture AddFour(Fourniture f,Long userid) {
	    
		
		f.setType(true);
		f.setUser(userrep.findById(userid).get());
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
	     f.setPubDate(dateFormat.format(date));
	   		fourrep.save(f);
		return f;
	}
	
	@Override
	public void deleteFour (long FournitureId) {
	 	fourrep.deleteById(FournitureId);}
	
	@Override
	public Fourniture findFourniture (long id) {
		return fourrep.findById(id).get() ;
		}
	
	@Override
	public List<Fourniture> getallfourniture(){
		List<Fourniture> fours = (List<Fourniture>) fourrep.findAll();
		return fours;
	}
	
	
	
	
	@Override
	public Fourniture BuyFourniturebyid (long fid) {
		Fourniture four = findFourniture(fid);
		if(four.isType() == true)
		{
	
			four.setQuantity(0);
			four.setType(false);
			fourrep.save(four);
			return four;

			}
					
			
			else
			{
				return null ;
			}
		
	}
	
	@Override
	public List<Fourniture> getOwner (Long userid){
		List<Fourniture> list = getallfourniture();
		User u = userrep.findById(userid).get();
		List<Fourniture> Foun = new ArrayList<>();
		for(Fourniture f : list) {
			if(f.getUser().getId() == u.getId()) {
				Foun.add(f);
			}
		}return Foun;
	}
	
	
	@Override
	public FileDB saveImage(FileDB p) {
		return fileDBRepository.save(p);

	}
	@Override
	public FileDB store(Fourniture f,MultipartFile file) throws IOException {
	    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
	    FileDB FileDB = new FileDB(fileName, file.getContentType(), file.getBytes());
	    FileDB.setFourniture(f);
	    return fileDBRepository.save(FileDB);
	  }
	@Override
	public FileDB getim(Long id) {
	    return fileDBRepository.findById(id).get();
	  }
		
}
