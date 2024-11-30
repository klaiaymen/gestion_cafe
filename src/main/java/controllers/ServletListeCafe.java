package controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Cafe;
import models.ConnectionDatabase;
import models.Gestion;

/**
 * Servlet implementation class ServletListeCafe
 */
@WebServlet("/ServletListeCafe")
public class ServletListeCafe extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Gestion gestion = new Gestion();       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListeCafe() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Cafe> listeCafes= gestion.afficherCafeList();
    
        // Envoyer la liste des cafés à la JSP
        request.setAttribute("listeCafes", listeCafes);
        request.getRequestDispatcher("gestionCafe.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
