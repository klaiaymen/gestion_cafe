package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Gestion;

/**
 * Servlet implementation class ServletAjouterViennoiserie
 */
@WebServlet("/ServletAjouterViennoiserie")
public class ServletAjouterViennoiserie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAjouterViennoiserie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Redirection vers la page d'ajout de viennoiserie
        request.getRequestDispatcher("ajouterViennoiserie.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		// Récupérer les données du formulaire
        String nomViennoiserie = request.getParameter("nomViennoiserie");
        int foId = Integer.parseInt(request.getParameter("foId"));
        float prix = Float.parseFloat(request.getParameter("prix"));
        int ventes = Integer.parseInt(request.getParameter("ventes"));
         Gestion gestion = new Gestion();
        // Ajouter le café dans la base de données
        gestion.ajouterViennoiserie(nomViennoiserie, foId, prix, ventes);

        // Rediriger vers la liste des cafés
        //response.sendRedirect("ServletListeCafe");
        request.getRequestDispatcher("gestionViennoiserie.jsp").forward(request,response); 
	}

}
