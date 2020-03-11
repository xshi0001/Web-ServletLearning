package Listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @program: servlettotals
 * @description:
 * @author: JClearLove
 * @Date: 2020/03/10 11:19
 */
@WebListener
public class MyHttpSessionListener implements HttpSessionListener {

    private int userNumber = 0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        userNumber++;
        se.getSession().getServletContext().setAttribute("userNumber", userNumber);


    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        userNumber--;
        se.getSession().getServletContext().setAttribute("userNumber", userNumber);

    }
}

