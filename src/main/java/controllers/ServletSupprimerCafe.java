package controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.ConnectionDatabase;
import models.Gestion;

/**
 * Servlet implementation class ServletSupprimerCafe
 */
@WebServlet("/ServletSupprimerCafe")
public class ServletSupprimerCafe extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Gestion gestion = new Gestion();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSupprimerCafe() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String nomCafe = request.getParameter("nomCafe");        
		gestion.supprimerCafe(nomCafe);
        // Redirection vers la liste des cafés après suppression
        response.sendRedirect("ServletListeCafe");
		//request.getRequestDispatcher("ServletListeCafe").forward(request,response);
	}

}
