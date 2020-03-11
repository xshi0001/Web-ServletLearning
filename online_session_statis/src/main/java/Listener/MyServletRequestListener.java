package Listener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

import entity.User;
import utils.SessionUtil;

@WebListener
public class MyServletRequestListener implements ServletRequestListener {

    private ArrayList<User> userList;


    @Override
    public void requestInitialized(ServletRequestEvent arg0) {
        // 初始化
        userList = (ArrayList<User>) arg0.getServletContext().getAttribute("userList");

        if (userList == null) {
            userList = new ArrayList<User>();
        }

        HttpServletRequest request = (HttpServletRequest) arg0.getServletRequest();
        String sessionIdString = request.getSession().getId();

        if (SessionUtil.getUserBySessionId(userList, sessionIdString) == null) {
            // 判断user list里面有没有，没有则新建user
            User user = new User();
            user.setSessionIdString(sessionIdString);
            user.setFirstTimeString(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            user.setIpString(request.getRemoteAddr());
            userList.add(user);
        }
        arg0.getServletContext().setAttribute("userList", userList);
    }

    @Override
    public void requestDestroyed(ServletRequestEvent arg0) {

    }

}
