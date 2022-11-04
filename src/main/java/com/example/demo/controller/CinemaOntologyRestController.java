package com.example.demo.controller;


import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.jena.atlas.json.io.parser.JSONParser;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.RDFNode;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.tools.JenaEngine;

//import com.example.demo.tools.JenaEngine;


 



@CrossOrigin(origins = "http://localhost:3000/")
@RestController

@RequestMapping("/cinema")

public class CinemaOntologyRestController {
	@GetMapping("/hello")
    public String getAllToursByTitler() {

       return "hello";
    }
	@GetMapping({"/personnes"})
	public List<JSONObject> ListPersonnes()
	{
		List<JSONObject> list=new ArrayList();
		Model model = JenaEngine.readModel("data/CinemaOntology.owl");
		//System.out.print("+++++++++"+model);
		// apply our rules on the owlInferencedModel
		Model inferedModel = JenaEngine.readInferencedModelFromRuleFile(model, "data/rules.txt");
		// query on the model after inference
		String queryString = " "
				+ "PREFIX ns: <http://www.semanticweb.org/hamza/ontologies/2022/9/Cinema#>"
				+"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
				+ "SELECT *"
				+ "WHERE{ "
				+ "?personne rdf:type ns:Personne ."
				+"?personne ns:Age ?Age ."
				//+ "FILTER (?Age='"+age+"') ."
				+ "} ";
				Query query = QueryFactory.create(queryString);
		QueryExecution qexec = QueryExecutionFactory.create(query, inferedModel);
		    ResultSet results = qexec.execSelect() ;
		    while (results.hasNext())
		    {
		    	QuerySolution soln = results.nextSolution() ;
		    	
		    	RDFNode x = soln.get("personne") ;
			    RDFNode y = soln.get("Age") ;
                JSONObject obj = new JSONObject();
                obj.put("personne" ,x.toString().split("#")[1]);
	            obj.put("Age" ,y.toString());
				list.add(obj);
		    }
		System.out.println(list);
		return list;
	}
	

	@GetMapping({"/acteurs"})
	public List<JSONObject> ListActeurs()
	{
		List<JSONObject> list=new ArrayList();
		Model model = JenaEngine.readModel("data/CinemaOntology.owl");
		// apply our rules on the owlInferencedModel
		Model inferedModel = JenaEngine.readInferencedModelFromRuleFile(model, "data/rules.txt");
		// query on the model after inference
		String queryString = "PREFIX ns: <http://www.semanticweb.org/hamza/ontologies/2022/9/Cinema#>\n" +
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "\n" +
                "SELECT * \n" +
                "WHERE {\n" +
                "?Acteur rdf:type ns:Acteur .\n" +
				"?Acteur ns:Age ?Age ." +
				"?Acteur ns:Salaire ?Salaire ." +
				"?Acteur ns:Name ?Name .\n" +

                "} \n"
                + "ORDER BY DESC(?Age)";
				Query query = QueryFactory.create(queryString);
		QueryExecution qexec = QueryExecutionFactory.create(query, inferedModel);
		    ResultSet results = qexec.execSelect() ;
		    while (results.hasNext())
		    {
		    	QuerySolution soln = results.nextSolution() ;
		    	
		    	RDFNode x = soln.get("Acteur") ;
			    RDFNode y = soln.get("Age") ;
			    RDFNode a = soln.get("Name") ;
			    RDFNode z = soln.get("Salaire") ;

                JSONObject obj = new JSONObject();
                obj.put("Acteur" ,x.toString().split("#")[1]);
	            obj.put("Age" ,y.toString());
	            obj.put("Salaire" ,z.toString());
	            obj.put("Name" ,a.toString());

				list.add(obj);
		    }
		System.out.println(list);
		return list;
	}
	

	@GetMapping({"/acteurs/{name}"})
	public List<JSONObject> ListActeurs(@PathVariable("name") String name)
	{
		List<JSONObject> list=new ArrayList();
		Model model = JenaEngine.readModel("data/CinemaOntology.owl");
		// apply our rules on the owlInferencedModel
		Model inferedModel = JenaEngine.readInferencedModelFromRuleFile(model, "data/rules.txt");
		// query on the model after inference
		String queryString = "PREFIX ns: <http://www.semanticweb.org/hamza/ontologies/2022/9/Cinema#>\n" +
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "\n" +
                "SELECT * \n" +
                "WHERE {\n" +
                "?Acteur rdf:type ns:Acteur .\n" +
				"?Acteur ns:Age ?Age .\n" +
				"?Acteur ns:Name ?Name .\n" +
				"?Acteur ns:Salaire ?Salaire .\n" +
				"?Acteur ns:aUneSérie ?Série .\n"+
	            "?Acteur ns:aUnFilm ?Film .\n"+
                "FILTER (?Name='"+name+"') ."+
                "} \n";
        

		System.out.println(queryString);
				Query query = QueryFactory.create(queryString);
		QueryExecution qexec = QueryExecutionFactory.create(query, inferedModel);
		    ResultSet results = qexec.execSelect() ;
		    while (results.hasNext())
		    {
		    	QuerySolution soln = results.nextSolution() ;
		    	
		    	RDFNode x = soln.get("Acteur") ;
			    RDFNode y = soln.get("Age") ;
			    RDFNode c = soln.get("Name") ;
			    RDFNode z = soln.get("Salaire") ;
			    RDFNode a = soln.get("Série") ;
			    RDFNode b = soln.get("Film") ;
                JSONObject obj = new JSONObject();
                obj.put("Acteur" ,x.toString().split("#")[1]);
	            obj.put("Age" ,y.toString());
	            obj.put("Name" ,c.toString());
	            obj.put("Salaire" ,z.toString());
	            obj.put("Série" ,a.toString().split("#")[1]);
	            obj.put("Film" ,b.toString().split("#")[1]);
				list.add(obj);
		    }
		System.out.println(list);
		return list;
	}

	@GetMapping({"/acteurBySerie/{serie}"})
	public List<JSONObject> acteurBySerie(@PathVariable("serie") String serie)
	{
		List<JSONObject> list=new ArrayList();
		Model model = JenaEngine.readModel("data/CinemaOntology.owl");
		// apply our rules on the owlInferencedModel
		Model inferedModel = JenaEngine.readInferencedModelFromRuleFile(model, "data/rules.txt");
		// query on the model after inference
		String queryString = "PREFIX ns: <http://www.semanticweb.org/hamza/ontologies/2022/9/Cinema#>\n" +
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "\n" +
                "SELECT * \n" +
                "WHERE {\n" +
                "?Acteur rdf:type ns:Acteur .\n" +
				"?Acteur ns:Age ?Age ." +
				"?Acteur ns:Salaire ?Salaire ." +
                "?Acteur ns:aUneSérie ?Série .\n"+
                "FILTER (ns:aUneSérie='"+serie+"') ."+
                "} \n";
		System.out.println(queryString);
				Query query = QueryFactory.create(queryString);
		QueryExecution qexec = QueryExecutionFactory.create(query, inferedModel);
		    ResultSet results = qexec.execSelect() ;
		    while (results.hasNext())
		    {
		    	QuerySolution soln = results.nextSolution() ;
		    	
		    	RDFNode x = soln.get("Acteur") ;
			    RDFNode y = soln.get("Age") ;
			    RDFNode z = soln.get("Salaire") ;
			    RDFNode a = soln.get("Série") ;
                JSONObject obj = new JSONObject();
                obj.put("Acteur" ,x.toString().split("#")[1]);
	            obj.put("Age" ,y.toString());
	            obj.put("Salaire" ,z.toString());
	            obj.put("Série" ,a.toString().split("#")[1]);
				list.add(obj);
		    }
		System.out.println(list);
		return list;
	}
	

	@GetMapping({"/producteurs"})
	public List<JSONObject> ListProducteurs()
	{
		List<JSONObject> list=new ArrayList();
		Model model = JenaEngine.readModel("data/CinemaOntology.owl");
		// apply our rules on the owlInferencedModel
		Model inferedModel = JenaEngine.readInferencedModelFromRuleFile(model, "data/rules.txt");
		// query on the model after inference
		String queryString = "PREFIX ns: <http://www.semanticweb.org/hamza/ontologies/2022/9/Cinema#>\n" +
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "\n" +
                "SELECT * \n" +
                "WHERE {\n" +
                "?Producteur rdf:type ns:Producteur .\n" +
				"?Producteur ns:Age ?Age ." +
				"?Producteur ns:Salaire ?Salaire ." +
				"?Producteur ns:Name ?Name ." +
                "}";
				Query query = QueryFactory.create(queryString);
		QueryExecution qexec = QueryExecutionFactory.create(query, inferedModel);
		    ResultSet results = qexec.execSelect() ;
		    while (results.hasNext())
		    {
		    	QuerySolution soln = results.nextSolution() ;
		    	
		    	RDFNode x = soln.get("Producteur") ;
			    RDFNode y = soln.get("Age") ;
			    RDFNode z = soln.get("Salaire") ;
			    RDFNode a = soln.get("Name") ;
                JSONObject obj = new JSONObject();
                obj.put("Producteur" ,x.toString().split("#")[1]);
	            obj.put("Age" ,y.toString());
	            obj.put("Salaire" ,z.toString());
	            obj.put("Name" ,a.toString());
				list.add(obj);
		    }
		System.out.println(list);
		return list;
	}
	

	@GetMapping({"/réalisateurs"})
	public List<JSONObject> ListRéalisateur()
	{
		List<JSONObject> list=new ArrayList();
		Model model = JenaEngine.readModel("data/CinemaOntology.owl");
		// apply our rules on the owlInferencedModel
		Model inferedModel = JenaEngine.readInferencedModelFromRuleFile(model, "data/rules.txt");
		// query on the model after inference
		String queryString = "PREFIX ns: <http://www.semanticweb.org/hamza/ontologies/2022/9/Cinema#>\n" +
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "\n" +
                "SELECT * \n" +
                "WHERE {\n" +
                "?Réalisateur rdf:type ns:Réalisateur .\n" +
				"?Acteur ns:Age ?Age ." +
				"?Acteur ns:Salaire ?Salaire ." +
                "?Réalisateur ns:aUneSérie ?Série .\n"+
                "?Réalisateur ns:aUnFilm ?Film .\n"+
                "}";
				Query query = QueryFactory.create(queryString);
		QueryExecution qexec = QueryExecutionFactory.create(query, inferedModel);
		    ResultSet results = qexec.execSelect() ;
		    while (results.hasNext())
		    {
		    	QuerySolution soln = results.nextSolution() ;
		    	
		    	RDFNode x = soln.get("Réalisateur") ;
			    RDFNode y = soln.get("Age") ;
			    RDFNode z = soln.get("Salaire") ;
			    RDFNode a = soln.get("Série") ;
			    RDFNode b = soln.get("Film") ;
                JSONObject obj = new JSONObject();
                obj.put("Réalisateur" ,x.toString().split("#")[1]);
	            obj.put("Age" ,y.toString());
	            obj.put("Salaire" ,z.toString());
	            obj.put("Série" ,a.toString().split("#")[1]);
	            obj.put("Film" ,b.toString().split("#")[1]);
				list.add(obj);
		    }
		System.out.println(list);
		return list;
	}
	

	@GetMapping({"/mini-serie"})
	public List<JSONObject> ListMiniSerie()
	{
		List<JSONObject> list=new ArrayList();
		Model model = JenaEngine.readModel("data/CinemaOntology.owl");
		// apply our rules on the owlInferencedModel
		Model inferedModel = JenaEngine.readInferencedModelFromRuleFile(model, "data/rules.txt");
		// query on the model after inference
		String queryString = "PREFIX ns: <http://www.semanticweb.org/hamza/ontologies/2022/9/Cinema#>\n" +
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "\n" +
                "SELECT * \n" +
                "WHERE {\n" +
                "?Mini_Serie rdf:type ns:Mini_Serie .\n" +
                "?Mini_Serie ns:Name ?Name .\n"+
				"?Mini_Serie ns:DateSortie ?DateSortie ." +
				"?Mini_Serie ns:SociétéDeProduction ?SociétéDeProduction ." +
                "}";
				Query query = QueryFactory.create(queryString);
		QueryExecution qexec = QueryExecutionFactory.create(query, inferedModel);
		    ResultSet results = qexec.execSelect() ;
		    while (results.hasNext())
		    {
		    	QuerySolution soln = results.nextSolution() ;
		    	
		    	RDFNode x = soln.get("Mini_Serie") ;
			    RDFNode y = soln.get("Name") ;
			    RDFNode c = soln.get("DateSortie") ;
			    RDFNode d = soln.get("SociétéDeProduction") ;
                JSONObject obj = new JSONObject();
                obj.put("Mini_Serie" ,x.toString().split("#")[1]);
	            obj.put("Name" ,y.toString());
	            obj.put("DateSortie" ,c.toString());
	            obj.put("SociétéDeProduction" ,d.toString());
				list.add(obj);
		    }
		System.out.println(list);
		return list;
	}
	
	@GetMapping({"/mini-serie/{name}"})
	public List<JSONObject> MiniSerie(@PathVariable("name") String name)
	{
		List<JSONObject> list=new ArrayList();
		Model model = JenaEngine.readModel("data/CinemaOntology.owl");
		// apply our rules on the owlInferencedModel
		Model inferedModel = JenaEngine.readInferencedModelFromRuleFile(model, "data/rules.txt");
		// query on the model after inference
		String queryString = "PREFIX ns: <http://www.semanticweb.org/hamza/ontologies/2022/9/Cinema#>\n" +
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "\n" +
                "SELECT * \n" +
                "WHERE {\n" +
                "?Mini_Serie rdf:type ns:Mini_Serie .\n" +
                "?Mini_Serie ns:aDesActeur ?Acteur .\n"+
				"?Mini_Serie ns:DateSortie ?DateSortie ." +
				"?Mini_Serie ns:SociétéDeProduction ?SociétéDeProduction ." +
                "?Mini_Serie ns:aUnRealisateur ?Réalisateur .\n"+
                "?Mini_Serie ns:aUnProducteur ?Producteur .\n"+
                "?Mini_Serie ns:aUnGenre ?Genre .\n"+
				"?Mini_Serie ns:Name ?Name .\n" +
                "FILTER (?Name='"+name+"') ."+
                "} \n";
        

		System.out.println(queryString);
				Query query = QueryFactory.create(queryString);
		QueryExecution qexec = QueryExecutionFactory.create(query, inferedModel);
		    ResultSet results = qexec.execSelect() ;
		    while (results.hasNext())
		    {
		    	QuerySolution soln = results.nextSolution() ;
		    	
		    	RDFNode x = soln.get("Mini_Serie") ;
			    RDFNode y = soln.get("Acteur") ;
			    RDFNode z = soln.get("Réalisateur") ;
			    RDFNode a = soln.get("Producteur") ;
			    RDFNode b = soln.get("Genre") ;
			    RDFNode c = soln.get("DateSortie") ;
			    RDFNode d = soln.get("SociétéDeProduction") ;
			    RDFNode e = soln.get("Name") ;
                JSONObject obj = new JSONObject();
                obj.put("Mini_Serie" ,x.toString().split("#")[1]);
	            obj.put("Acteur" ,y.toString().split("#")[1]);
	            obj.put("Réalisateur" ,z.toString().split("#")[1]);
	            obj.put("Producteur" ,a.toString().split("#")[1]);
	            obj.put("Genre" ,b.toString().split("#")[1]);
	            obj.put("DateSortie" ,c.toString());
	            obj.put("SociétéDeProduction" ,d.toString());
	            obj.put("Name" ,e.toString());
				list.add(obj);
		    }
		System.out.println(list);
		return list;
	}

	

	@GetMapping({"/serie-limite"})
	public List<JSONObject> ListSerieLimite()
	{
		List<JSONObject> list=new ArrayList();
		Model model = JenaEngine.readModel("data/CinemaOntology.owl");
		// apply our rules on the owlInferencedModel
		Model inferedModel = JenaEngine.readInferencedModelFromRuleFile(model, "data/rules.txt");
		// query on the model after inference
		String queryString = "PREFIX ns: <http://www.semanticweb.org/hamza/ontologies/2022/9/Cinema#>\n" +
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "\n" +
                "SELECT * \n" +
                "WHERE {\n" +
                "?Serie_Limité rdf:type ns:Serie_Limité .\n" +
                "?Serie_Limité ns:aDesActeur ?Acteur .\n"+
                "?Serie_Limité ns:aUnRealisateur ?Réalisateur .\n"+
                "?Serie_Limité ns:aUnProducteur ?Producteur .\n"+
                "?Serie_Limité ns:aUnGenre ?Genre .\n"+
				"?Serie_Limité ns:DateSortie ?DateSortie ." +
				"?Serie_Limité ns:SociétéDeProduction ?SociétéDeProduction ." +
                "}";
				Query query = QueryFactory.create(queryString);
		QueryExecution qexec = QueryExecutionFactory.create(query, inferedModel);
		    ResultSet results = qexec.execSelect() ;
		    while (results.hasNext())
		    {
		    	QuerySolution soln = results.nextSolution() ;
		    	
		    	RDFNode x = soln.get("Serie_Limité") ;
			    RDFNode y = soln.get("Acteur") ;
			    RDFNode z = soln.get("Réalisateur") ;
			    RDFNode a = soln.get("Producteur") ;
			    RDFNode b = soln.get("Genre") ;
			    RDFNode c = soln.get("DateSortie") ;
			    RDFNode d = soln.get("SociétéDeProduction") ;
                JSONObject obj = new JSONObject();
                obj.put("Serie_Limité" ,x.toString().split("#")[1]);
	            obj.put("Acteur" ,y.toString().split("#")[1]);
	            obj.put("Réalisateur" ,z.toString().split("#")[1]);
	            obj.put("Producteur" ,a.toString().split("#")[1]);
	            obj.put("Genre" ,b.toString().split("#")[1]);
	            obj.put("DateSortie" ,c.toString());
	            obj.put("SociétéDeProduction" ,d.toString());
				list.add(obj);
		    }
		System.out.println(list);
		return list;
	}
	

	@GetMapping({"/court-metrage"})
	public List<JSONObject> ListCourt_Métrage()
	{
		List<JSONObject> list=new ArrayList();
		Model model = JenaEngine.readModel("data/CinemaOntology.owl");
		// apply our rules on the owlInferencedModel
		Model inferedModel = JenaEngine.readInferencedModelFromRuleFile(model, "data/rules.txt");
		// query on the model after inference
		String queryString = "PREFIX ns: <http://www.semanticweb.org/hamza/ontologies/2022/9/Cinema#>\n" +
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "\n" +
                "SELECT * \n" +
                "WHERE {\n" +
                "?Court_Métrage rdf:type ns:Court_Métrage .\n" +
                "?Court_Métrage ns:aUnRealisateur ?Réalisateur .\n"+
                "?Court_Métrage ns:aUnProducteur ?Producteur .\n"+
                "?Court_Métrage ns:aUnGenre ?Genre .\n"+
                "?Court_Métrage ns:Name ?Name .\n"+
				"?Court_Métrage ns:DateSortie ?DateSortie ." +
				"?Court_Métrage ns:SociétéDeProduction ?SociétéDeProduction ." +
                "}";
		System.out.println(queryString);
				Query query = QueryFactory.create(queryString);
		QueryExecution qexec = QueryExecutionFactory.create(query, inferedModel);
		    ResultSet results = qexec.execSelect() ;
		    while (results.hasNext())
		    {
		    	QuerySolution soln = results.nextSolution() ;
		    	
		    	RDFNode x = soln.get("Court_Métrage") ;
			    RDFNode z = soln.get("Réalisateur") ;
			    RDFNode a = soln.get("Producteur") ;
			    RDFNode b = soln.get("Genre") ;
			    RDFNode n = soln.get("Name") ;
			    RDFNode c = soln.get("DateSortie") ;
			    RDFNode d = soln.get("SociétéDeProduction") ;
                JSONObject obj = new JSONObject();
                obj.put("Court_Métrage" ,x.toString().split("#")[1]);
	            obj.put("Réalisateur" ,z.toString().split("#")[1]);
	            obj.put("Producteur" ,a.toString().split("#")[1]);
	            obj.put("Genre" ,b.toString().split("#")[1]);
	            obj.put("DateSortie" ,c.toString());
	            obj.put("Name" ,n.toString());
	            obj.put("SociétéDeProduction" ,d.toString());
				list.add(obj);
		    }
		System.out.println(list);
		return list;
	}
	
	@GetMapping({"/court-metrage/{name}"})
	public List<JSONObject> ListCourt_MétrageByName(@PathVariable("name") String name)
	{
		List<JSONObject> list=new ArrayList();
		Model model = JenaEngine.readModel("data/CinemaOntology.owl");
		// apply our rules on the owlInferencedModel
		Model inferedModel = JenaEngine.readInferencedModelFromRuleFile(model, "data/rules.txt");
		// query on the model after inference
		String queryString = "PREFIX ns: <http://www.semanticweb.org/hamza/ontologies/2022/9/Cinema#>\n" +
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "\n" +
                "SELECT * \n" +
                "WHERE {\n" +
                "?Court_Métrage rdf:type ns:Court_Métrage .\n" +
                "?Court_Métrage ns:aDesActeur ?Acteur .\n"+
                "?Court_Métrage ns:aUnRealisateur ?Réalisateur .\n"+
                "?Court_Métrage ns:aUnProducteur ?Producteur .\n"+
                "?Court_Métrage ns:aUnGenre ?Genre .\n"+
                "?Court_Métrage ns:Name ?Name .\n"+
				"?Court_Métrage ns:DateSortie ?DateSortie ." +
				"?Court_Métrage ns:SociétéDeProduction ?SociétéDeProduction ." +
				"FILTER (?Name='"+name+"') ."+
                "}";
		System.out.println(queryString);
				Query query = QueryFactory.create(queryString);
		QueryExecution qexec = QueryExecutionFactory.create(query, inferedModel);
		    ResultSet results = qexec.execSelect() ;
		    while (results.hasNext())
		    {
		    	QuerySolution soln = results.nextSolution() ;
		    	
		    	RDFNode x = soln.get("Court_Métrage") ;
			    RDFNode y = soln.get("Acteur") ;
			    RDFNode z = soln.get("Réalisateur") ;
			    RDFNode a = soln.get("Producteur") ;
			    RDFNode b = soln.get("Genre") ;
			    RDFNode n = soln.get("Name") ;
			    RDFNode c = soln.get("DateSortie") ;
			    RDFNode d = soln.get("SociétéDeProduction") ;
                JSONObject obj = new JSONObject();
                obj.put("Court_Métrage" ,x.toString().split("#")[1]);
	            obj.put("Acteur" ,y.toString().split("#")[1]);
	            obj.put("Réalisateur" ,z.toString().split("#")[1]);
	            obj.put("Producteur" ,a.toString().split("#")[1]);
	            obj.put("Genre" ,b.toString().split("#")[1]);
	            obj.put("DateSortie" ,c.toString());
	            obj.put("Name" ,n.toString());
	            obj.put("SociétéDeProduction" ,d.toString());
				list.add(obj);
		    }
		System.out.println(list);
		return list;
	}
	

	@GetMapping({"/long-metrage"})
	public List<JSONObject> ListLong_Métrage()
	{
		List<JSONObject> list=new ArrayList();
		Model model = JenaEngine.readModel("data/CinemaOntology.owl");
		// apply our rules on the owlInferencedModel
		Model inferedModel = JenaEngine.readInferencedModelFromRuleFile(model, "data/rules.txt");
		// query on the model after inference
		String queryString = "PREFIX ns: <http://www.semanticweb.org/hamza/ontologies/2022/9/Cinema#>\n" +
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "\n" +
                "SELECT * \n" +
                "WHERE {\n" +
                "?Long_Métrage rdf:type ns:Long_Métrage .\n" +
                "?Long_Métrage ns:aUnGenre ?Genre .\n"+
				"?Long_Métrage ns:DateSortie ?DateSortie ." +
				"?Long_Métrage ns:SociétéDeProduction ?SociétéDeProduction ." +
                "}";
				Query query = QueryFactory.create(queryString);
		QueryExecution qexec = QueryExecutionFactory.create(query, inferedModel);
		    ResultSet results = qexec.execSelect() ;
		    while (results.hasNext())
		    {
		    	QuerySolution soln = results.nextSolution() ;
		    	
		    	RDFNode x = soln.get("Long_Métrage") ;
			    RDFNode b = soln.get("Genre") ;
			    RDFNode c = soln.get("DateSortie") ;
			    RDFNode d = soln.get("SociétéDeProduction") ;
                JSONObject obj = new JSONObject();
                obj.put("Long_Métrage" ,x.toString().split("#")[1]);
	            obj.put("Genre" ,b.toString().split("#")[1]);
	            obj.put("DateSortie" ,c.toString());
	            obj.put("SociétéDeProduction" ,d.toString());
				list.add(obj);
		    }
		System.out.println(list);
		return list;
	}
	@GetMapping({"/producteurs/{name}"})
	public List<JSONObject> ListProducteurs(@PathVariable("name") String name)
	{
		List<JSONObject> list=new ArrayList();
		Model model = JenaEngine.readModel("data/CinemaOntology.owl");
		// apply our rules on the owlInferencedModel
		Model inferedModel = JenaEngine.readInferencedModelFromRuleFile(model, "data/rules.txt");
		// query on the model after inference
		String queryString = "PREFIX ns: <http://www.semanticweb.org/hamza/ontologies/2022/9/Cinema#>\n" +
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "\n" +
                "SELECT * \n" +
                "WHERE {\n" +
                "?Producteur rdf:type ns:Producteur .\n" +
				"?Producteur ns:Age ?Age .\n" +
				"?Producteur ns:Name ?Name .\n" +
				"?Producteur ns:Salaire ?Salaire .\n" +
				"?Producteur ns:aUneSérie ?Série .\n"+
	            "?Producteur ns:aUnFilm ?Film .\n"+
                "FILTER (?Name='"+name+"') ."+
                "} \n";
        

		System.out.println(queryString);
				Query query = QueryFactory.create(queryString);
		QueryExecution qexec = QueryExecutionFactory.create(query, inferedModel);
		    ResultSet results = qexec.execSelect() ;
		    while (results.hasNext())
		    {
		    	QuerySolution soln = results.nextSolution() ;
		    	
		    	RDFNode x = soln.get("Producteur") ;
			    RDFNode y = soln.get("Age") ;
			    RDFNode c = soln.get("Name") ;
			    RDFNode z = soln.get("Salaire") ;
			    RDFNode a = soln.get("Série") ;
			    RDFNode b = soln.get("Film") ;
                JSONObject obj = new JSONObject();
                obj.put("Producteur" ,x.toString().split("#")[1]);
	            obj.put("Age" ,y.toString());
	            obj.put("Name" ,c.toString());
	            obj.put("Salaire" ,z.toString());
	            obj.put("Série" ,a.toString().split("#")[1]);
	            obj.put("Film" ,b.toString().split("#")[1]);
				list.add(obj);
		    }
		System.out.println(list);
		return list;
	}
}