package com.example.demo.controller;

import java.io.ByteArrayOutputStream;

import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.Model;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.tools.JenaEngine;

import javax.ws.rs.core.MediaType;

//import com.example.demo.tools.JenaEngine;


 



@CrossOrigin(origins = "http://localhost:3000/")
@RestController

@RequestMapping("/cinema")

public class CinemaOntologyRestController {
	@GetMapping("/hello")
    public String getAllToursByTitler() {

       return "hello";
    }
	
	
	@GetMapping("/Personnes")
    public String getAllPersonnes() {

        String qexec = "PREFIX ns: <http://www.semanticweb.org/hamza/ontologies/2022/9/Cinema#>\n" +
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "\n" +
                "SELECT * \n" +
                "WHERE {\n" +
                "?Personne rdf:type ns:Personne .\n" +
                "}";
        System.out.println(qexec);
        Model model = JenaEngine.readModel("data/CinemaOntology.owl");

        QueryExecution qe = QueryExecutionFactory.create(qexec, model);
        ResultSet results = qe.execSelect();

        // write to a ByteArrayOutputStream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        ResultSetFormatter.outputAsJSON(outputStream, results);

        // and turn that into a String
        String json = new String(outputStream.toByteArray());

        JSONObject j = new JSONObject(json);
        System.out.println(j.getJSONObject("results").getJSONArray("bindings"));

        JSONArray res = j.getJSONObject("results").getJSONArray("bindings");


        return j.getJSONObject("results").getJSONArray("bindings").toString();

    }
	
	@GetMapping("/Acteurs")
    public String getAllActeurs() {

		String qexec = "PREFIX ns: <http://www.semanticweb.org/hamza/ontologies/2022/9/Cinema#>\n" +
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "\n" +
                "SELECT * \n" +
                "WHERE {\n" +
                "?Acteur rdf:type ns:Acteur .\n" +
                "?Acteur ns:aUneSérie ?Série .\n"+
                "?Acteur ns:aUnFilm ?Film .\n"+
                "} \n";

        Model model = JenaEngine.readModel("data/CinemaOntology.owl");

        QueryExecution qe = QueryExecutionFactory.create(qexec, model);
        ResultSet results = qe.execSelect();

        // write to a ByteArrayOutputStream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        ResultSetFormatter.outputAsJSON(outputStream, results);

        // and turn that into a String
        String json = new String(outputStream.toByteArray());

        JSONObject j = new JSONObject(json);
        System.out.println(j.getJSONObject("results").getJSONArray("bindings"));

        JSONArray res = j.getJSONObject("results").getJSONArray("bindings");


        return j.getJSONObject("results").getJSONArray("bindings").toString();

    }
	
	@GetMapping("/Producteurs")
    public String getAllProducteurs() {

		String qexec = "PREFIX ns: <http://www.semanticweb.org/hamza/ontologies/2022/9/Cinema#>\n" +
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "\n" +
                "SELECT * \n" +
                "WHERE {\n" +
                "?Producteur rdf:type ns:Producteur .\n" +
                "?Producteur ns:aUneSérie ?Série .\n"+
                "?Producteur ns:aUnFilm ?Film .\n"+
                "}";

        Model model = JenaEngine.readModel("data/CinemaOntology.owl");

        QueryExecution qe = QueryExecutionFactory.create(qexec, model);
        ResultSet results = qe.execSelect();

        // write to a ByteArrayOutputStream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        ResultSetFormatter.outputAsJSON(outputStream, results);

        // and turn that into a String
        String json = new String(outputStream.toByteArray());

        JSONObject j = new JSONObject(json);
        System.out.println(j.getJSONObject("results").getJSONArray("bindings"));

        JSONArray res = j.getJSONObject("results").getJSONArray("bindings");


        return j.getJSONObject("results").getJSONArray("bindings").toString();

    }
	
	
	@GetMapping("/Réalisateur")
    public String getAllRéalisateurs() {

		String qexec = "PREFIX ns: <http://www.semanticweb.org/hamza/ontologies/2022/9/Cinema#>\n" +
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "\n" +
                "SELECT * \n" +
                "WHERE {\n" +
                "?Réalisateur rdf:type ns:Réalisateur .\n" +
                "?Réalisateur ns:aUneSérie ?Série .\n"+
                "?Réalisateur ns:aUnFilm ?Film .\n"+
                "}";

        Model model = JenaEngine.readModel("data/CinemaOntology.owl");

        QueryExecution qe = QueryExecutionFactory.create(qexec, model);
        ResultSet results = qe.execSelect();

        // write to a ByteArrayOutputStream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        ResultSetFormatter.outputAsJSON(outputStream, results);

        // and turn that into a String
        String json = new String(outputStream.toByteArray());

        JSONObject j = new JSONObject(json);
        System.out.println(j.getJSONObject("results").getJSONArray("bindings"));

        JSONArray res = j.getJSONObject("results").getJSONArray("bindings");


        return j.getJSONObject("results").getJSONArray("bindings").toString();

    }
	
	
	@GetMapping("/MiniSérie")
    public String getAllMiniSérie() {

		String qexec = "PREFIX ns: <http://www.semanticweb.org/hamza/ontologies/2022/9/Cinema#>\n" +
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "\n" +
                "SELECT * \n" +
                "WHERE {\n" +
                "?Mini_Serie rdf:type ns:Mini_Serie .\n" +
                "?Mini_Serie ns:aDesActeur ?Acteur .\n"+
                "?Mini_Serie ns:aUnRealisateur ?Réalisateur .\n"+
                "?Mini_Serie ns:aUnProducteur ?Producteur .\n"+
                "?Mini_Serie ns:aUnGenre ?Genre .\n"+
                "}";

        Model model = JenaEngine.readModel("data/CinemaOntology.owl");

        QueryExecution qe = QueryExecutionFactory.create(qexec, model);
        ResultSet results = qe.execSelect();

        // write to a ByteArrayOutputStream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        ResultSetFormatter.outputAsJSON(outputStream, results);

        // and turn that into a String
        String json = new String(outputStream.toByteArray());

        JSONObject j = new JSONObject(json);
        System.out.println(j.getJSONObject("results").getJSONArray("bindings"));

        JSONArray res = j.getJSONObject("results").getJSONArray("bindings");


        return j.getJSONObject("results").getJSONArray("bindings").toString();

    }
	
	@GetMapping("/SerieLimité")
    public String getAllSérieLimité() {

		String qexec = "PREFIX ns: <http://www.semanticweb.org/hamza/ontologies/2022/9/Cinema#>\n" +
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "\n" +
                "SELECT * \n" +
                "WHERE {\n" +
                "?Serie_Limité rdf:type ns:Serie_Limité .\n" +
                "?Serie_Limité ns:aDesActeur ?Acteur .\n"+
                "?Serie_Limité ns:aUnRealisateur ?Réalisateur .\n"+
                "?Serie_Limité ns:aUnProducteur ?Producteur .\n"+
                "?Serie_Limité ns:aUnGenre ?Genre .\n"+
                "}";

        Model model = JenaEngine.readModel("data/CinemaOntology.owl");

        QueryExecution qe = QueryExecutionFactory.create(qexec, model);
        ResultSet results = qe.execSelect();

        // write to a ByteArrayOutputStream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        ResultSetFormatter.outputAsJSON(outputStream, results);

        // and turn that into a String
        String json = new String(outputStream.toByteArray());

        JSONObject j = new JSONObject(json);
        System.out.println(j.getJSONObject("results").getJSONArray("bindings"));

        JSONArray res = j.getJSONObject("results").getJSONArray("bindings");


        return j.getJSONObject("results").getJSONArray("bindings").toString();

    }
	
	
	@GetMapping("/CourtMétrage")
    public String getAllCourtMétrage() {

		String qexec = "PREFIX ns: <http://www.semanticweb.org/hamza/ontologies/2022/9/Cinema#>\n" +
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "\n" +
                "SELECT * \n" +
                "WHERE {\n" +
                "?Court_Métrage rdf:type ns:Court_Métrage .\n" +
                "?Court_Métrage ns:aDesActeur ?Acteur .\n"+
                "?Court_Métrage ns:aUnRealisateur ?Réalisateur .\n"+
                "?Court_Métrage ns:aUnProducteur ?Producteur .\n"+
                "?Court_Métrage ns:aUnGenre ?Genre .\n"+
                "}";

        Model model = JenaEngine.readModel("data/CinemaOntology.owl");

        QueryExecution qe = QueryExecutionFactory.create(qexec, model);
        ResultSet results = qe.execSelect();

        // write to a ByteArrayOutputStream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        ResultSetFormatter.outputAsJSON(outputStream, results);

        // and turn that into a String
        String json = new String(outputStream.toByteArray());

        JSONObject j = new JSONObject(json);
        System.out.println(j.getJSONObject("results").getJSONArray("bindings"));

        JSONArray res = j.getJSONObject("results").getJSONArray("bindings");


        return j.getJSONObject("results").getJSONArray("bindings").toString();

    }
	
	
	@GetMapping("/LongMétrage")
    public String getAllLongMétrage() {

		String qexec = "PREFIX ns: <http://www.semanticweb.org/hamza/ontologies/2022/9/Cinema#>\n" +
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "\n" +
                "SELECT * \n" +
                "WHERE {\n" +
                "?Long_Métrage rdf:type ns:Long_Métrage .\n" +
                "?Long_Métrage ns:aDesActeur ?Acteur .\n"+
                "?Long_Métrage ns:aUnRealisateur ?Réalisateur .\n"+
                "?Long_Métrage ns:aUnProducteur ?Producteur .\n"+
                "?Long_Métrage ns:aUnGenre ?Genre .\n"+
                "} \n ";

        Model model = JenaEngine.readModel("data/CinemaOntology.owl");

        QueryExecution qe = QueryExecutionFactory.create(qexec, model);
        ResultSet results = qe.execSelect();

        // write to a ByteArrayOutputStream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        ResultSetFormatter.outputAsJSON(outputStream, results);

        // and turn that into a String
        String json = new String(outputStream.toByteArray());

        JSONObject j = new JSONObject(json);
        System.out.println(j.getJSONObject("results").getJSONArray("bindings"));

        JSONArray res = j.getJSONObject("results").getJSONArray("bindings");


        return j.getJSONObject("results").getJSONArray("bindings").toString();

    }
	
	@GetMapping("/AgeLeoDiCaprio")
	 public String getAllActeursAge() {

			String qexec = "PREFIX ns: <http://www.semanticweb.org/hamza/ontologies/2022/9/Cinema#>\n" +
	                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
	                "\n" +
	                "SELECT ?Age \n" +
	                "WHERE {\n" +
	                ":Leonardo_Di_Caprio :Age ?Age .\n" +
	                "} \n";

	        Model model = JenaEngine.readModel("data/CinemaOntology.owl");

	        QueryExecution qe = QueryExecutionFactory.create(qexec, model);
	        ResultSet results = qe.execSelect();

	        // write to a ByteArrayOutputStream
	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

	        ResultSetFormatter.outputAsJSON(outputStream, results);

	        // and turn that into a String
	        String json = new String(outputStream.toByteArray());

	        JSONObject j = new JSONObject(json);
	        System.out.println(j.getJSONObject("results").getJSONArray("bindings"));

	        JSONArray res = j.getJSONObject("results").getJSONArray("bindings");


	        return j.getJSONObject("results").getJSONArray("bindings").toString();

	    }
		
}
