package fr.m2i.formation.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.m2i.formation.dto.User;
import fr.m2i.formation.service.IUserManager;
import fr.m2i.formation.service.impl.UserManagerImpl;

/**
 * Servlet implementation class Authenticate
 */
//@WebServlet("/Authenticate")
public class Authenticate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	IUserManager manager = new UserManagerImpl();									//Cr�ation instance ProductManager (m�thodes createProduct, getProducts, etc...)
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Authenticate() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)											//On modifie la m�thode doPost() car le formulaire createProduct.jsp a comme m�thode : "post"
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
																											
																																//
																																
		String login = request.getParameter("login");																			//R�cup�rer champs "nom" (name="name") du formulaire createProduct.jsp						
		String password = request.getParameter("pwd");																			//R�cup�rer champs "prix" *********************************************

		User user = manager.authenticate(login, password);
		//Appel m�thode getProducts() cr��e
		
		if("Internaute".equals(user.getRole()))
		{
			
			HttpSession session = request.getSession();
			session.setAttribute("Identification", "OK");							//Ou String � la place de boolean ?
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/views/accueilInternaute.jsp").forward(request, response);
		}
		else if("Commercial".equals(user.getRole()))
		{
			
			HttpSession session = request.getSession();
			session.setAttribute("Identification", "OK");							//Ou String � la place de boolean ?
			
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/views/accueilCommercial.jsp").forward(request, response);
		}
		else
		{
		
			request.setAttribute("erreur", true);									//Ou String � la place de boolean ?
			
			
			this.getServletContext().getRequestDispatcher("/authenticate").forward(request, response);
		}
																			//Retourne une liste de Product
		
		//request.setAttribute("products", products);		 																	//??????
		
					//Voir ce � quoi correspond "this" (la Servlet elle-m�me) et le d�tail de 
																																//La m�thode getServletContext()

	}

}
