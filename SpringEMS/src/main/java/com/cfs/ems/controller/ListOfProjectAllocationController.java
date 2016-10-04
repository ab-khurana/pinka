package com.cfs.ems.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cfs.ems.model.ProjectAllocation;
import com.cfs.ems.service.ListOfProjectAllocationService;

/**
 * @author Priyanka Uppalwar
 * 
 */
@Controller
public class ListOfProjectAllocationController {

	@Autowired
	private ListOfProjectAllocationService listOfProjectAllocationService;

	public ListOfProjectAllocationController(
			ListOfProjectAllocationService listOfProjectAllocationService) {

		this.listOfProjectAllocationService = listOfProjectAllocationService;
		System.out.println("ListOfProjectAllocationController");
	}

	
	@RequestMapping(value = "/listOfProjectAllocation")
	public ModelAndView welcome(ProjectAllocation projectAllocation) throws Exception{
		
		List<ProjectAllocation> list = listOfProjectAllocationService
				.fetchAll();
		
		System.out.println("in test"+list);
		
		for(ProjectAllocation pa:list){
			
			System.out.println("inside test"+pa.getProjectAllId());
			System.out.println(pa.getEmployeeId());
		}
		
		ModelAndView view = new ModelAndView();
		
		view.setViewName("listOfProjectAllocation");
		view.addObject("list", list);
		
		return view;
		
	}
	
	/*@RequestMapping(value = "/listOfProjectAllocation")
	public ModelAndView welcome(ProjectAllocation projectAllocation, HttpSession session) throws Exception{

		List<ProjectAllocation> list = listOfProjectAllocationService
				.fetchAll();
		session.setAttribute("empId", status.getEmpId());
	
	*/
	
	
	
}
