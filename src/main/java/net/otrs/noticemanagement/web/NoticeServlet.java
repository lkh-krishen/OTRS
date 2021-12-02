package net.otrs.noticemanagement.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.otrs.noticemanagement.dao.NoticeDAO;
import net.otrs.noticemanagement.model.Notice;

/**
 * 
============================================================================================================================================
============================================================================================================================================
  
                     THIS SERVLET ACTS AS A PAGE CONTROLLER FOR THE APPLICATION, HANDLING ALL REQUESTS FROM THE USER
   
============================================================================================================================================
============================================================================================================================================
*  
**/

@WebServlet("/")  /** Any servlet request will be sent to this class **/
public class NoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NoticeDAO noticeDAO;
	
	public void init() {
		noticeDAO = new NoticeDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response); /** Handle all the requests using doGet method **/
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath(); /** Get action from request object by using getServletPath **/

		try {
			
			/**Switch statement to handle all requests**/
			
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertNotice(request, response);
				break;
			case "/delete":
				deleteNotice(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateNotice(request, response);
				break;
			case "/display":
				displayNotice(request, response);
				break;
			default: // handle list
				listNotice(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listNotice(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		List<Notice> listNotice = noticeDAO.selectAllNotices();                         // Returns all notices stored in the database as a list object.
		request.setAttribute("listNotice", listNotice);                                 // Set list of notices to listNotice key using setAttribute method of request object
		RequestDispatcher dispatcher = request.getRequestDispatcher("notice-list.jsp"); // Redirects to notice-list page.
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("notice-form.jsp"); //Creating requestDispatcher object and forward request to notice-form page.
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Notice existingNotice = noticeDAO.selectNotice(id);                             // Get notice object by using select notice method
		RequestDispatcher dispatcher = request.getRequestDispatcher("notice-form.jsp"); // forward notice object to notice-form.jsp page
		request.setAttribute("notice", existingNotice);                                 // Pass notice object to request object using set attribute
		dispatcher.forward(request, response);
	}

	private void insertNotice(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int priority = Integer.parseInt(request.getParameter("priority"));  // Extract notice details from the request object
		String title = request.getParameter("title");                       // and create notice object and pass details to constructor
		String description = request.getParameter("description");           // and call insert notice method of noticedao object and save notice to database
		String email = request.getParameter("email");                       // and redirect to list request(list is unavailable in the switch statement, so it passes
		Notice newNotice = new Notice(priority, title, description, email); // to the default section)
		noticeDAO.insertNotice(newNotice);
		response.sendRedirect("list");
	}

	private void updateNotice(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));               // Retrieve all notice
		int priority = Integer.parseInt(request.getParameter("priority"));   // details from request object
		String title = request.getParameter("title");                        // using getParameter method
		String description = request.getParameter("description");            
		String email = request.getParameter("email");                        
		Notice notice = new Notice(id, priority, title, description, email); // create notice object
		noticeDAO.updateNotice(notice);                                      // call updateNotice method and pass notice object
		response.sendRedirect("list");                                       // redirect to list page
	}

	private void deleteNotice(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id")); // Get id from request object
		noticeDAO.deleteNotice(id);                            // Call corresponding method to delete notice from database
		response.sendRedirect("list");                         // Once notice is deleted from database, redirect to list page

	}

	private void displayNotice(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		List<Notice> displayNotice = noticeDAO.selectAllNotices();                       // Returns all notices stored in the database as a list object.
		request.setAttribute("displayNotice", displayNotice);                            // Set list of notices to listNotice key using setAttribute method of request object
		RequestDispatcher dispatcher = request.getRequestDispatcher("notice-board.jsp"); // Redirects to notice-board.jsp page.
		dispatcher.forward(request, response);
	}
}
