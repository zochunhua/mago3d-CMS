package mago3d.controller.view;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import mago3d.domain.Policy;
import mago3d.service.PolicyService;

@Controller
@RequestMapping("/policy")
public class PolicyController {

	@Autowired
	private PolicyService policyService;

	@GetMapping(value = "/modify")
	public String modify(HttpServletRequest reuqet, Model model) {
		Policy policy = policyService.getPolicy();

		model.addAttribute("policy", policy);

		return "/policy/modify";
	}
}
