package fr.m2i.formation.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.m2i.formation.dto.Product;
import fr.m2i.formation.service.IProductManager;
import fr.m2i.formation.service.impl.ProductManagerImpl;

/**
 * Servlet implementation class ViewCatalog
 */
//@WebServlet("/ViewCatalog")
public class ViewCatalog extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	IProductManager manager = new ProductManagerImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewCatalog() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		//On modifie la méthode get car on a "mthoed = "post" dans le href de l'index.jsp
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//Catalogue cat = new Catalogue();
		HttpSession session = request.getSession();

		if (session.getAttribute("Identification").equals("OK")){
			
			List<Product> products =  manager.getProducts(); 
	
			
			
			
		//Appel méthode getProducts() créée
																			//Retourne une liste de Product
		
			request.setAttribute("products", products);		 																		//??????
		
			this.getServletContext().getRequestDispatcher("/catalogue.jsp").forward(request, response);
		}
		else{
		this.getServletContext().getRequestDispatcher("/authenticate").forward(request, response);}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
