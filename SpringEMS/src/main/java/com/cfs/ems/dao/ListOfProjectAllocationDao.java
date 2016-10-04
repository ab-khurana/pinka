package com.cfs.ems.dao;

import java.sql.SQLException;
import java.util.List;

import com.cfs.ems.model.ProjectAllocation;


/**
 * @author Priyanka Uppalwar
 *
 */
public interface ListOfProjectAllocationDao {
	
	public List<ProjectAllocation> fetchAllToDb() throws SQLException;
}
