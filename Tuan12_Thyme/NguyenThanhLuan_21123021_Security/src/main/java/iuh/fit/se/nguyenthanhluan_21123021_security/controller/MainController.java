package iuh.fit.se.nguyenthanhluan_21123021_security.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.Collection;

@Controller
public class MainController {

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcomePage(Model model,Principal principal) {
        model.addAttribute("userPrincipal", principal);
        model.addAttribute("title", "Welcome");
        model.addAttribute("message", "This is welcome page!");
        return "wellcomepage";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String home(Model model, HttpSession session) {
        model.addAttribute("session", session);
        return "loginpage";
    }

    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal) {
        model.addAttribute("userPrincipal", principal);
        String userName = principal.getName();
        System.out.println("User Name: " + userName);
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        System.out.println("User Name: " + loginedUser.getUsername());
        String userInfo = utilsUser(loginedUser);
        System.out.println("User Info: " + userInfo);
        model.addAttribute("userInfo", userInfo);
        return "userInfoPage";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {
        model.addAttribute("userPrincipal", principal);
        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();
            String userInfo = utilsUser(loginedUser);
            model.addAttribute("userInfo", userInfo);
            String message = "Hi " + principal.getName() + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);
        }
        return "403Page";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(Model model, Principal principal) {
        model.addAttribute("userPrincipal", principal);
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        String userInfo = utilsUser(loginedUser);
        model.addAttribute("userInfo", userInfo);
        return "adminPage";
    }

    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage() {
        return "logout";
    }

    public String utilsUser(User user) {
        StringBuilder sb = new StringBuilder();
        sb.append("UserName:").append(user.getUsername());
        Collection<GrantedAuthority> authorities = user.getAuthorities();
        if (authorities != null && !authorities.isEmpty()) {
            sb.append(" (");
            boolean first = true;
            for (GrantedAuthority a : authorities) {
                if (first) {
                    sb.append(a.getAuthority());
                    first = false;
                } else {
                    sb.append(", ").append(a.getAuthority());
                }
            }
            sb.append(")");
        }
        return sb.toString();
    }
}
