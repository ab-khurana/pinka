package com.cfs.ems.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cfs.ems.model.ProjectAllocation;

/**
 * @author Priyanka Uppalwar
 * 
 */
@Repository
public class ListOfProjectAllocationDaoImpl implements
		ListOfProjectAllocationDao {

	public List<ProjectAllocation> fetchAllToDb() throws SQLException {

		Connection con = null;
		ResultSet rs = null;
		List<ProjectAllocation> listOfProjects = new LinkedList<ProjectAllocation>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/ems", "root", "root");

			String sql = "SELECT project_allocations.project_all_id, project_details.project_id, project_details.project_name, employee_details.employee_id, employee_details.first_name, employee_details.last_name, project_allocations.designation, project_allocations.start_date, project_allocations.end_date, project_allocations.status FROM ems.project_allocations, ems.project_details, ems.employee_details WHERE ems.project_allocations.project_id = ems.project_details.project_id AND ems.project_allocations.employee_id = ems.employee_details.employee_id AND ems.project_allocations.status = 'active';";

			PreparedStatement ps = con.prepareStatement(sql);

			rs = ps.executeQuery(sql);

			while (rs.next()) {

				ProjectAllocation pa = new ProjectAllocation();
				pa.setProjectAllId(rs.getString(1));
				pa.setProjectId(rs.getString(2));
				pa.setProjectName(rs.getString(3));
				pa.setEmployeeId(rs.getString(4));
				pa.setDesignation(rs.getString(7));
				pa.setStartDate(rs.getDate(8));
				pa.setEndDate(rs.getDate(9));
				pa.setStatus(rs.getString(10));
				listOfProjects.add(pa);
				
				}
			

		}

		catch (Exception e) {

			System.out.println("in dao   " + e);
		}

		finally {

			con.close();
		}
		return listOfProjects;

	}
}
