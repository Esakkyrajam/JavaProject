package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.LocationStates;
import com.example.demo.services.CoronaVirusDataServices;
import com.example.demo.services.CoronaVirusDataServicesRepository;

@Controller
public class HomeController 
{
	
	CoronaVirusDataServices crnService;
	private CoronaVirusDataServicesRepository cvdsRepo;
	public HomeController(CoronaVirusDataServicesRepository cvdsRepo) {
				this.cvdsRepo = cvdsRepo;
	}
	
	
	@Autowired
	public void setCrnService(CoronaVirusDataServices crnService) {
		this.crnService = crnService;
	}


	@GetMapping("/")
	public String home(Model model)
	{
		List<LocationStates> allstates=crnService.getAllstates();
		int totalDeathsReported=allstates.stream().mapToInt(stat->stat.getLatestTotalDeaths()).sum();
		model.addAttribute("LocationStates",allstates);
		model.addAttribute("totalDeathsReported",totalDeathsReported);
		cvdsRepo.saveAll(allstates);
		return "home";
	}
	
	
	@RequestMapping(path="/ChartData",produces = {"application/json"})
	@ResponseBody
	public List<LocationStates> chartData(Model model) {
		List<LocationStates> allstates=crnService.getAllstates();
		int totalDeathsReported=allstates.stream().mapToInt(stat->stat.getLatestTotalDeaths()).sum();
		model.addAttribute("LocationStates",allstates);
		model.addAttribute("totalDeathsReported",totalDeathsReported);
			        return allstates;
		
	}
	
	@RequestMapping(path="/ChartData/top={count}", produces = {"application/json"})
	@ResponseBody
	public List<LocationStates> chartDataFindTopCount(@PathVariable("count") int count, Model model) {
		List<LocationStates> allstates = cvdsRepo.findTopNByLatestTotalDeaths(count);
		model.addAttribute("LocationStates",allstates);
		return allstates;
	}
	
	@RequestMapping(path="/ChartData/{id}", produces = {"application/json"})
	@ResponseBody
	public List<LocationStates> chartDataFindId(@PathVariable("id") int id, Model model) {
		List<LocationStates> allstates = cvdsRepo.findIdByTotalDeaths(id);
		model.addAttribute("LocationStates",allstates);
		return allstates;
	}
	
	
	 @GetMapping("/ChartData/country='{name}'")
	    @ResponseBody
	    public List<LocationStates> chartDataFindCountryName(@PathVariable("name") String name,  Model model) {
	  
	        List<LocationStates> allStates = cvdsRepo.findByCountryTotalDeaths(name);
	        model.addAttribute("LocationStates", allStates);
	        return allStates;
	    }
	
	 
	 @RequestMapping(value = "/chart-view", method = RequestMethod.GET)
		public ModelAndView chartView() {
			 return new ModelAndView("chartview").addObject("myurl", new String("http://localhost:8082/ChartData"));
		}
	
	@GetMapping("/chart-view/top={count}")
	public String chartDataFindTopCountHTML(@PathVariable("count") int count, Model model) {
	    model.addAttribute("myurl", "http://localhost:8082/ChartData/top="+count);
	    return "chartview";
	}

	@GetMapping("/chart-view/{id}")
	public String viewChartById(@PathVariable("id") int id, Model model) {
	   model.addAttribute("myurl", "http://localhost:8082/ChartData/"+id);
	    return "chartview";
	}
	
	@GetMapping("/chart-view/country='{name}'")
	public String viewChartByName(@PathVariable("name") String name, Model model) {
	    model.addAttribute("myurl", "http://localhost:8082/ChartData/country='"+name+"'");
	    return "chartview";
	}
	


}
