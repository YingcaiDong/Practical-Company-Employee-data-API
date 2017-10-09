package com.Employee.DataManagement.titles;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TitleService {
	
	@Autowired
	private TitleRepository titleRepository;
	
	public List<Title> getTitlesByFromDate(Date fromDate) {
		return titleRepository.findByEmbeddedKeyFromDate(fromDate);
	}

	public List<Title> getTitles(String title) {
		return titleRepository.findByEmbeddedKeyTitle(title);
	}
	
	public Title getTitlesByEmpNo(Integer empNo) {
		return titleRepository.findByEmbeddedKeyEmployeeEmpNo(empNo);
	}

	public void addTitle(Title title) {
		titleRepository.save(title);
	}

	public void updateTitle(Title title) {
		titleRepository.save(title);
	}
	
	public void deleteTitleByEmpNo(Integer empNo) {
		titleRepository.deleteByEmbeddedKeyEmployeeEmpNo(empNo);
	}
	
	// string date format should be like 1992-02-13 (yyyy-MM-dd)
	public Date str2SDate(String strDate) throws ParseException {
		SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = sDateFormat.parse(strDate);
		return new java.sql.Date(date.getTime());
	}
}
