package fr.m2i.formation.controller;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

public class PanValidation extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

	
		try {

			JSONObject jObj = new JSONObject(request.getParameter("cart"));			//Panier ?

			Iterator it = jObj.keys(); //gets all the keys

			while(it.hasNext())
			{
			    Object key = it.next(); // get key
			    JSONObject o = (JSONObject) jObj.get(key.toString()); // get value

			    System.out.println(key + " : " +  o); // print the key and value
			    System.out.println(o.get("prixCart")); // print the key and value
			}	

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}