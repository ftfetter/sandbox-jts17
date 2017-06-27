package com.github.ftfetter.java.spring4.calculator.app;

import com.github.ftfetter.java.spring4.calculator.config.AppConfig;
import com.github.ftfetter.java.spring4.calculator.operations.Calculator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/")
public class Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Calculator useCalculator = (Calculator) applicationContext.getBean("calculator");

        useCalculator.calculate(1,2,"+");
        useCalculator.calculate(7,6,"*");
        useCalculator.calculate(4,8,"+");
        useCalculator.calculate(4,0,"/");
        useCalculator.calculate(7,3,"-");
        useCalculator.calculate(9,3,"/");
        useCalculator.calculate(5,7,"k");
        useCalculator.calculate(2,4,"^");
        out.print(useCalculator.printHistory());

        ((AnnotationConfigApplicationContext) applicationContext).close();

    }
}
