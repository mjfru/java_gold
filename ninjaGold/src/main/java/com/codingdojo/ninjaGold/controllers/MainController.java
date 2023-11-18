package com.codingdojo.ninjaGold.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {

	@Autowired
	private HttpSession session;
	
	private static final int debt_limit = -125;
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/")
	public String index(
			@RequestParam(value = "farm", required = false) String farm,
			@RequestParam(value = "cave", required = false) String cave,
			@RequestParam(value = "house", required = false) String house,
			@RequestParam(value = "quest", required = false) String quest,
			@RequestParam(value = "spa", required = false) String spa
			)	{
		
		int gold = 0;
		
		ArrayList<String> activities = new ArrayList<String>();
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat ("MMMM  d  Y - h:mm a");
		
		if (session.getAttribute("gold") == null) {
			session.setAttribute("gold", gold);
			session.setAttribute("activities", activities);
		} else {
			gold = (int) session.getAttribute("gold");
			activities = (ArrayList<String>) session.getAttribute("activities");
		}
		
		
		if (farm != null) {
			int goldGain = new Random().nextInt(11) + 10;
			gold += goldGain;
			activities.add(0, "You entered a farm and earned " + goldGain + " gold. ("+ simpleDateFormat.format(new Date())+")");
			session.setAttribute("activities", activities);
			session.setAttribute("gold", gold);
			return "redirect:/";
		}
		
		if (cave != null) {
			int goldGain = new Random().nextInt(6) + 5;
			gold += goldGain;
			activities.add(0, "You entered a cave and earned " + goldGain + " gold. ("+ simpleDateFormat.format(new Date())+")");
			session.setAttribute("activities", activities);
			session.setAttribute("gold", gold);
			return "redirect:/";
		}
		
		if (house != null) {
			int goldGain = new Random().nextInt(4) + 2;
			gold += goldGain;
			activities.add(0, "You entered a house, hopefully yours, and earned " + goldGain + " gold. ("+ simpleDateFormat.format(new Date())+")");
			session.setAttribute("activities", activities);
			session.setAttribute("gold", gold);
			return "redirect:/";
		}
		
		if (quest != null) {
			int goldGain = new Random().nextInt(101) - 50;
			gold += goldGain;
			if (goldGain >= 0) {
				activities.add(0, "You completed a quest and earned " + goldGain + " gold. ("+ simpleDateFormat.format(new Date())+")");
			} else {
				activities.add(0, "You completed a quest and lost " + (goldGain *-1) + " gold. ("+ simpleDateFormat.format(new Date())+")");
			}
			session.setAttribute("activities", activities);
			session.setAttribute("gold", gold);
			return "redirect:/";
		}
		
		if (spa != null) {
			int goldGain = new Random().nextInt(16) + 5;
			gold -= goldGain;
			activities.add(0, "You went and relaxed at a spa...but you lost " + (goldGain *-1) + " gold. ("+ simpleDateFormat.format(new Date())+")");
			session.setAttribute("activities", activities);
			session.setAttribute("gold", gold);
			return "redirect:/";
		}
		
		// Bonus: Jail if too far in debt
		if (gold < debt_limit) {
			return "redirect:/gameOver";
		}	
		return "index.jsp";
	}
	
	@GetMapping("/reset")
	public String resetGame() {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/activities")
	public String activities() {
		return "activities.jsp";
	}
	
	@GetMapping("/gameOver")
	public String gameOver() {
		session.invalidate();
		return "gameOver.jsp";
	}
}
