package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Cafe;
import models.Gestion;
import models.Viennoiserie;

/**
 * Servlet implementation class ServletListeViennoiserie
 */
@WebServlet("/ServletListeViennoiserie")
public class ServletListeViennoiserie extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Gestion gestion = new Gestion();       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListeViennoiserie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Viennoiserie> listeViennoiseries= gestion.afficherViennoiseriesList();
	    
        // Envoyer la liste des cafés à la JSP
        request.setAttribute("listeViennoiseries", listeViennoiseries);
        request.getRequestDispatcher("gestionViennoiserie.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
