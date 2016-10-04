package com.cfs.ems.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cfs.ems.dao.ListOfProjectAllocationDao;
import com.cfs.ems.model.ProjectAllocation;

/**
 * @author Priyanka Uppalwar
 * 
 */
@Service
public class ListOfProjectAllocationServiceImpl implements
		ListOfProjectAllocationService {

	@Autowired
	private ListOfProjectAllocationDao listOfProjectAllocationDao;

	public ListOfProjectAllocationServiceImpl(
			ListOfProjectAllocationDao listOfProjectAllocationDao) {

		this.listOfProjectAllocationDao = listOfProjectAllocationDao;
	}

	public List<ProjectAllocation> fetchAll() throws SQLException {

		List<ProjectAllocation> listOfProjects = listOfProjectAllocationDao.fetchAllToDb();
		System.out.println("ListOfProjectAllocationServiceImpl");

		System.out.println("In service:: "+listOfProjects);
		return listOfProjects;

	}

}
