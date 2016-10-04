package com.cfs.ems.service;

import java.sql.SQLException;
import java.util.List;

import com.cfs.ems.model.ProjectAllocation;


/**
 * @author Priyanka Uppalwar
 *
 */
public interface ListOfProjectAllocationService {

	public List<ProjectAllocation> fetchAll(/*ProjectAllocation projectAllocation*/) throws SQLException;
}
