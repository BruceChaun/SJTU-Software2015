package com.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.DBserver;
import com.entity.Brick;
import com.entity.Combine;
import com.entity.Contain;

/**
 * Servlet implementation class Upload
 */
@WebServlet("/Upload")
public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DBserver db = new DBserver();
	private static Combine combine = new Combine();
	private static Contain contain = new Contain();
	private static Brick brick = new Brick();
       
    /**
     * NOT NEEDED
     * @see HttpServlet#HttpServlet()
     */
    //public Upload() {
    //    super();
        // TODO Auto-generated constructor stub
    //}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		/*
		 * change code here to map interface names between webpage and servlet
		 * i.e. the name in getParameter(*) should be the same as one in front page
		 * You should add/delete/modify some attributes, like the given format
		 * to make the logic correct
		 * ALSO, DO NOT forget change related files, e.g. codes in 'DBserver.java'
		 */
		String Com_id = request.getParameter("Com_id");
		String Ctype = request.getParameter("Ctype");
		String CDes = request.getParameter("CDes");
		String Bri_id = request.getParameter("Bri_id");
		String Btype = request.getParameter("Btype");
		String Uses = request.getParameter("Uses");
		String BDes = request.getParameter("BDes");
		int bsta = Integer.parseInt(request.getParameter("bsta"));
		int Bend = Integer.parseInt(request.getParameter("Bend"));
		
		/*combine.setCom_id(Com_id);
		combine.setCtype(Ctype);
		combine.setDes(CDes);
		brick.setBri_id(Bri_id);
		brick.setBtype(Btype);
		brick.setUses(Uses);
		brick.setDes(BDes);
		contain.setBend(Bend);
		contain.setBri_id(Bri_id);
		contain.setBsta(bsta);
		contain.setCom_id(Com_id);*/
		db.insertCombine(Com_id, Ctype, CDes);
		db.insertBrick(Bri_id, Btype, BDes, Uses);
		db.insertContain(Com_id, bsta, Bend, Bri_id);
	}

}
