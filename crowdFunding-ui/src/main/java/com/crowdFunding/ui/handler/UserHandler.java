package com.crowdFunding.ui.handler;

import com.crowdFunding.common.api.UserManagerRemoteService;
import com.crowdFunding.common.constant.Constant;
import com.crowdFunding.common.dto.LoginInByAPInfoDTO;
import com.crowdFunding.common.dto.UserLogInSuccessDTO;
import com.crowdFunding.common.entity.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserHandler {

    @Autowired
    private UserManagerRemoteService userManagerRemoteService;

    /**
     * 跳转到登陆页面
     *
     * @return
     */
    @RequestMapping("/login/page")
    public String toLoginPage() {
        return "logIn";
    }

    /**
     * 登录
     *
     * @param loginInByAPInfoDTO
     * @param model
     * @param session
     * @return
     */
    @PostMapping("/log/in")
    public String userLogin(LoginInByAPInfoDTO loginInByAPInfoDTO, Model model, HttpSession session) {

        ResultEntity<UserLogInSuccessDTO> resultEntity = userManagerRemoteService.logInByAP(loginInByAPInfoDTO);

        if (ResultEntity.FAILED.equals(resultEntity.getStatus())) {
            model.addAttribute(Constant.ATTR_NAME_MESSAGE, resultEntity.getMessage());
            return "logIn";
        }
        UserLogInSuccessDTO userLogInSuccessDTO = resultEntity.getData();
        session.setAttribute(Constant.ATTR_NAME_LOGIN_USER, userLogInSuccessDTO);
        return "redirect:/";
    }

    /**
     * 退出登录
     *
     * @param session
     * @return
     */
    @RequestMapping("/log/out")
    public String logout(HttpSession session) {
        //1. 从session中获取UserLogInSuccessDTO对象（里面包含令牌token）
        UserLogInSuccessDTO userLogInSuccessDTO = (UserLogInSuccessDTO) session.getAttribute(Constant.ATTR_NAME_LOGIN_USER);
        if (userLogInSuccessDTO == null) {
            return "redirect:/";
        }
        //2. 获得token，调用远程方法将token从redis中删除,删除失败的话抛出异常
        String token = userLogInSuccessDTO.getToken();
        ResultEntity<String> resultEntity = userManagerRemoteService.logOut(token);
        if (ResultEntity.FAILED.equals(resultEntity.getStatus())) {
            throw new RuntimeException(resultEntity.getMessage());
        }
        //3. 删除成功,再将session删除,返回首页
        session.invalidate();
        return "redirect:/";
    }
}
