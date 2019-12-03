package com.bridgelabz.foodcourt;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FoodCart
 */
@WebServlet("/FoodCart")
public class FoodCart extends HttpServlet {
	//private static final  = 1L;
protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
	
    String[] fooditems= {"biryani","roti","fish","chicken65"}; 
	request.setAttribute("fooditems", fooditems);
	RequestDispatcher requestdispatcher=request.getRequestDispatcher("show-food.jsp");
	requestdispatcher.forward(request, response);

	}

}
