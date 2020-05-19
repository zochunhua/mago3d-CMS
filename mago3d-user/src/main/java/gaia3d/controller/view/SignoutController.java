package gaia3d.controller.view;

import gaia3d.domain.*;
import gaia3d.listener.Gaia3dHttpSessionBindingListener;
import gaia3d.service.RoleService;
import gaia3d.service.SigninService;
import gaia3d.support.PasswordSupport;
import gaia3d.support.RoleSupport;
import gaia3d.support.SessionUserSupport;
import gaia3d.utils.WebUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

/**
 * Sign Out 처리
 * 
 * @author jeongdae
 */
@Slf4j
@Controller
@RequestMapping("/sign")
public class SignoutController {

	/**
	 * Sign out
	 * @param request
	 * @return
	 */
	@GetMapping(value = "/signout")
	public String signout(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		UserSession userSession = (UserSession)session.getAttribute(Key.USER_SESSION.name());
		
		if(userSession == null) {
			return "redirect:/sign/signin";
		}
		
		session.removeAttribute(userSession.getUserId());
		session.removeAttribute(Key.USER_SESSION.name());
		session.invalidate();
		
		return "redirect:/sign/signin";
	}
}
