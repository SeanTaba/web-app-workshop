package com.revature.p1.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Dispatcher
{
    public void dispatch(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        response.getWriter().println("From the dispatcher:" + request.getRequestURI());

        switch (request.getRequestURI())
        {
            case "/p1_1/login":
                response.getWriter().println("<h2> We got it here in the dispatcher </h2>");
                //System.out.println(request.getRequestURI());
                break;
            case "/p1_1/data":
                response.getWriter().println("data we are good!");
                //System.out.println(request.getRequestURI());
                break;
        }

        //System.out.println(request.getRequestURI());

    }
}
