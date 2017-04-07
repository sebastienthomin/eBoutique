package fr.m2i.formation.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.m2i.formation.dto.Catalogue;
import fr.m2i.formation.dto.Product;
import fr.m2i.formation.service.IProductManager;
import fr.m2i.formation.service.impl.ProductManagerImpl;

/**
 * Servlet implementation class createProduct
 */
// @WebServlet("/createProduct")
public class CreateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	IProductManager manager = new ProductManagerImpl();									//Création instance ProductManager (méthodes createProduct, getProducts, etc...)

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)											//On modifie la méthode doPost() car le formulaire createProduct.jsp a comme méthode : "post"
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
																											
		Catalogue cat = new Catalogue();																					//

		String name = request.getParameter("name");																			//Récupérer champs "nom" (name="name") du formulaire createProduct.jsp						
		Double price = Double.parseDouble(request.getParameter("price"));													//Récupérer champs "prix" *********************************************

		manager.createProduct(cat, name, price);
		//Appel méthode getProducts() créée
		List<Product> products =  manager.getProducts(); 																	//Retourne une liste de Product
		
		request.setAttribute("products", products);		 																	//??????
		
		this.getServletContext().getRequestDispatcher("/catalogue.jsp").forward(request, response);			//Voir ce à quoi correspond "this" (la Servlet elle-même) et le détail de 
																															//La méthode getServletContext()

	}

}
