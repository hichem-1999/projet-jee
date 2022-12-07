

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pizzariaa.Commande;
import pizzariaa.Pizza;

/**
 * Servlet implementation class Commander
 */
@WebServlet("/Commander")
public class Commander extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Commander() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application = getServletConfig().getServletContext();
		HttpSession session = request.getSession(false);
		
		if(application.getAttribute("commandes") == null) {
			application.setAttribute("commandes", new ArrayList<>());
		}
		Commande commande = new Commande(request.getParameter("nom"), request.getParameter("prenom"), request.getParameter("adresse"), (List<Pizza>) session.getAttribute("pizzas"), (int) session.getAttribute("prix"));
		List<Commande> commandes = (List<Commande>) application.getAttribute("commandes");
		commandes.add(commande);
		application.setAttribute("commandes", commandes);
		session.setAttribute("pizzas", new ArrayList<>());
		session.setAttribute("prix", 0);
		response.sendRedirect("/pizzariaa/menu.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
