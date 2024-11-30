package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Gestion;

/**
 * Servlet implementation class ServletAjouterCafe
 */
@WebServlet("/ServletAjouterCafe")
public class ServletAjouterCafe extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAjouterCafe() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Redirection vers la page d'ajout de café
        request.getRequestDispatcher("ajouterCafe.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		// Récupérer les données du formulaire
        String nomCafe = request.getParameter("nomCafe");
        int foId = Integer.parseInt(request.getParameter("foId"));
        float prix = Float.parseFloat(request.getParameter("prix"));
        int ventes = Integer.parseInt(request.getParameter("ventes"));
         Gestion gestion = new Gestion();
        // Ajouter le café dans la base de données
        gestion.ajouterCafe(nomCafe, foId, prix, ventes);

        // Rediriger vers la liste des cafés
        //response.sendRedirect("ServletListeCafe");
        request.getRequestDispatcher("gestionCafe.jsp").forward(request,response); 
	}

}
