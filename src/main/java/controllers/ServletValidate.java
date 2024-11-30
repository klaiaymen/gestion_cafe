package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Gestion;

/**
 * Servlet implementation class ServletValidate
 */
@WebServlet("/ServletValidate")
public class ServletValidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Gestion gestion= new Gestion();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletValidate() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init() throws ServletException {
        super.init();
        Gestion gestion = new Gestion();
        gestion.creerTableUsers(); // Crée la table USERS si elle n'existe pas
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
		
		//recuperer le login et mdp
        String login= request.getParameter("login");
        String mdp= request.getParameter("mdp");
        if (login == null || mdp == null || login.isEmpty() || mdp.isEmpty()) {
        	response.getWriter().println("Login ou mot de passe vide !");
            return;
        }

        // Valider l'utilisateur
        boolean isValidUser = gestion.validateUser(login,mdp);

        if (isValidUser) {
        	request.getRequestDispatcher("/home.jsp").forward(request,response);
        } else {
            String msg="login ou mdp incorrects";
            request.setAttribute("msg",msg);
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
	}

}
