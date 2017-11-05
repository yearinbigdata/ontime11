package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.DelayDO;
import com.example.domain.totalDelayDO;
import com.example.page.PageMaker;
import com.example.page.PageVO;
import com.example.repository.DelayRepository;
import com.example.repository.TotalDelayRepository;
import com.querydsl.core.types.Predicate;

import lombok.extern.java.Log;

@Controller
@RequestMapping("/delay")
@Log
public class DelayController {

	@Autowired
	private DelayRepository repo;
	@Autowired
	private TotalDelayRepository repo2;
	
	@GetMapping("/home")
	public String home(@ModelAttribute("pageVO") PageVO vo, Model model) {
		
		log.info("home get");

		Pageable pageable = vo.makePageable(0, "carrierName");
		Predicate predicate = repo.makePredicate(vo.getType(), vo.getKeyword());

		Page<DelayDO> result = repo.findAll(predicate, pageable);

		model.addAttribute("pageMaker", new PageMaker(result));

		return "thymeleaf/delay/home";
		
	}
	
//	@GetMapping("/total")
//	public String total(@ModelAttribute("pageVO") PageVO vo, Model model) {
//		
//		Pageable pageable = vo.makePageable(0, "carrierName");
//		Predicate predicate = repo.makePredicate(vo.getType(), vo.getKeyword());
//
//		Page<DelayDO> result = repo.findAll(predicate, pageable);
//
//		model.addAttribute("pageMaker", new PageMaker(result));
//		
//
//		return "thymeleaf/delay/total";
//	}	
	
	@GetMapping("/total")
	public String total(@ModelAttribute("pageVO") PageVO vo, Model model) {
		
		Pageable pageable = vo.makePageable(0, "carrierName");
		Predicate predicate = repo.makePredicate(vo.getType(), vo.getKeyword());

		Page<DelayDO> result = repo.findAll(predicate, pageable);

		model.addAttribute("pageMaker", new PageMaker(result));
		
		List<totalDelayDO> totalDelays = repo2.findAll();
		model.addAttribute("totalDelays", totalDelays );
		

		return "thymeleaf/delay/total";
	}	
	
	@GetMapping("/total2")
	public String total(@ModelAttribute("totalDelay") totalDelayDO vo, Model model) {
		
		List<totalDelayDO> result = repo2.findAll();

		model.addAttribute("totalDelay", result );
		

		return "thymeleaf/delay/total2";
		
	}
	
	@GetMapping("/month")
	public String month(@ModelAttribute("pageVO") PageVO vo, Model model) {
		log.info("month get");

		Pageable pageable = vo.makePageable(0, "carrierName");
		Predicate predicate = repo.makePredicate(vo.getType(), vo.getKeyword());

		Page<DelayDO> result = repo.findAll(predicate, pageable);

		model.addAttribute("pageMaker", new PageMaker(result));

		return "thymeleaf/delay/month";
	}
	
	@GetMapping("/arrDep")
	public String arrDep(@ModelAttribute("pageVO") PageVO vo, Model model) {
		log.info("arrDep get");

		Pageable pageable = vo.makePageable(0, "carrierName");
		Predicate predicate = repo.makePredicate(vo.getType(), vo.getKeyword());

		Page<DelayDO> result = repo.findAll(predicate, pageable);

		model.addAttribute("pageMaker", new PageMaker(result));

		return "thymeleaf/delay/arrDep";
	}
	
	@GetMapping("/arrDepandMonth")
	public String arrDepandMonth(@ModelAttribute("pageVO") PageVO vo, Model model) {
		log.info("arrDepandMonth get");

		Pageable pageable = vo.makePageable(0, "carrierName");
		Predicate predicate = repo.makePredicate(vo.getType(), vo.getKeyword());

		Page<DelayDO> result = repo.findAll(predicate, pageable);

		model.addAttribute("pageMaker", new PageMaker(result));

		return "thymeleaf/delay/arrDepandMonth";
	}
	
	
	
	
}
