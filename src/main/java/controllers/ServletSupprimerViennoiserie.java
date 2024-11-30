package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Gestion;

/**
 * Servlet implementation class ServletSupprimerViennoiserie
 */
@WebServlet("/ServletSupprimerViennoiserie")
public class ServletSupprimerViennoiserie extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Gestion gestion= new Gestion();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSupprimerViennoiserie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String nomViennoiserie = request.getParameter("nomViennoiserie");        
		gestion.supprimerViennoiserie(nomViennoiserie);
        // Redirection vers la liste des cafés après suppression
        response.sendRedirect("ServletListeViennoiserie");
		//request.getRequestDispatcher("ServletListeCafe").forward(request,response);
	}

}
