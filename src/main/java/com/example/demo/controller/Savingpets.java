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

@RequestMapping("/savingpets")

public class Savingpets {
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
                "?Personne rdf:type ns:Acteur .\n" +
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
	
	@GetMapping("/Responsables")
    public String getAllResponsqbles() {

        String qexec = "PREFIX ns: <http://www.semanticweb.org/maiez/ontologies/2022/9/SavingPets#>\n" +
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "\n" +
                "\n" +
                "SELECT * WHERE {\n" +
                "?Responsables rdf:type ns:Responsable .\n" +
                "}";

        Model model = JenaEngine.readModel("data/SavingPets1.owl");

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
	
	@GetMapping("/Presidents")
    public String getAllPresidents() {

        String qexec = "PREFIX ns: <http://www.semanticweb.org/maiez/ontologies/2022/9/SavingPets#>\n" +
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "\n" +
                "\n" +
                "SELECT * WHERE {\n" +
                "?President rdf:type ns:Président .\n" +
                "}";

        Model model = JenaEngine.readModel("data/SavingPets1.owl");

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
	
	
	@GetMapping("/RspRelations")
    public String getAllRspRelations() {

        String qexec = "PREFIX ns: <http://www.semanticweb.org/maiez/ontologies/2022/9/SavingPets#>\n" +
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "\n" +
                "\n" +
                "SELECT * WHERE {\n" +
                "?Relations_externes rdf:type ns:Relation_externes .\n" +
                "}";

        Model model = JenaEngine.readModel("data/SavingPets1.owl");

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
	
	
	@GetMapping("/RspCommunication")
    public String getAllRspCommunication() {

        String qexec = "PREFIX ns: <http://www.semanticweb.org/maiez/ontologies/2022/9/SavingPets#>\n" +
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "\n" +
                "\n" +
                "SELECT * WHERE {\n" +
                "?Rsp_Communication rdf:type ns:Rsp_communication .\n" +
                "}";

        Model model = JenaEngine.readModel("data/SavingPets1.owl");

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
	
	@GetMapping("/RspFinances")
    public String getAllRspFinances() {

        String qexec = "PREFIX ns: <http://www.semanticweb.org/maiez/ontologies/2022/9/SavingPets#>\n" +
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "\n" +
                "\n" +
                "SELECT * WHERE {\n" +
                "?Rsp_finance rdf:type ns:Rsp_finance .\n" +
                "}";

        Model model = JenaEngine.readModel("data/SavingPets1.owl");

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
	
	
	@GetMapping("/RspSuivi")
    public String getAllRspSuivi() {

        String qexec = "PREFIX ns: <http://www.semanticweb.org/maiez/ontologies/2022/9/SavingPets#>\n" +
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "\n" +
                "\n" +
                "SELECT * WHERE {\n" +
                "?Rsp_suivi rdf:type ns:Rsp_suivi .\n" +
                "}";

        Model model = JenaEngine.readModel("data/SavingPets1.owl");

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
	
	
	@GetMapping("/tel")
    public String getAllTel() {

        String qexec = "PREFIX ns: <http://www.semanticweb.org/maiez/ontologies/2022/9/SavingPets#>\n" +
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "\n" +
                "\n" +
                "SELECT ?personne ?telephone\n" +
                "WHERE {\n" +
                "?personne rdf:type ns:Personne .\n" +
                "?personne ns:telephone ?telephone .\n" +
                "}";

        Model model = JenaEngine.readModel("data/SavingPets1.owl");

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
	
	
	@GetMapping("/VetExamine")
    public String getAllVetExamine() {

        String qexec = "PREFIX ns: <http://www.semanticweb.org/maiez/ontologies/2022/9/SavingPets#>\n" +
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "\n" +
                "\n" +
                "SELECT ?vétérinaire ?animaux\n" +
                "WHERE {\n" +
                "?vétérinaire rdf:type ns:Vétérinaire .\n" +
                "?vétérinaire ns:examine ?animaux .\n" +
                "}";

        Model model = JenaEngine.readModel("data/SavingPets1.owl");

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
	
	
	@GetMapping("/VetControle")
    public String getAllVetControle() {

        String qexec = "PREFIX ns: <http://www.semanticweb.org/maiez/ontologies/2022/9/SavingPets#>\n" +
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "\n" +
                "\n" +
                "SELECT ?vétérinaire ?animaux\n" +
                "WHERE {\n" +
                "?vétérinaire rdf:type ns:Vétérinaire .\n" +
                "?vétérinaire ns:controle ?animaux .\n" +
                "}";

        Model model = JenaEngine.readModel("data/SavingPets1.owl");

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
	
	
	@GetMapping("/NbLocauxPresident")
    public String getAllNbLocauxPresident() {

        String qexec = "PREFIX ns: <http://www.semanticweb.org/maiez/ontologies/2022/9/SavingPets#>\n" +
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "\n" +
                "\n" +
                "SELECT ?association $president (count(distinct ?locaux) as ?count) \n" +
                "WHERE {\n" +
                "?association rdf:type ns:Association .\n" +
                "?association ns:distribuée_en ?locaux .\n" +
                "?association ns:géneré_par ?president .\n" +
                "}\n" +
                "GROUP BY ?association $president";

        Model model = JenaEngine.readModel("data/SavingPets1.owl");

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
	
	
	@GetMapping("/CandidatureParPersonne")
    public String getAllCandidatureParPersonne() {

        String qexec = "PREFIX ns: <http://www.semanticweb.org/maiez/ontologies/2022/9/SavingPets#>\n" +
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "\n" +
                "\n" +
                "SELECT ?personne ?candidature \n" +
                "WHERE {\n" +
                "?personne rdf:type ns:Personne .\n" +
                "?personne ns:postule ?candidature .\n" +
                "}";

        Model model = JenaEngine.readModel("data/SavingPets1.owl");

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
	
	
	@GetMapping("/CandidatureBenevoleParPersonne")
    public String getAllCandidatureBenevoleParPersonne() {

        String qexec = "PREFIX ns: <http://www.semanticweb.org/maiez/ontologies/2022/9/SavingPets#>\n" +
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "\n" +
                "\n" +
                "SELECT ?personne ?candidature \n" +
                "WHERE {\n" +
                "?personne rdf:type ns:Personne .\n" +
                "?candidature rdf:type ns:C_bénévole .\n" +
                "?personne ns:postule ?candidature .\n" +
                "}";

        Model model = JenaEngine.readModel("data/SavingPets1.owl");

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
	
	
	@GetMapping("/CandidatureVeterinaireParPersonne")
    public String getAllCandidatureVeterinaireParPersonne() {

        String qexec = "PREFIX ns: <http://www.semanticweb.org/maiez/ontologies/2022/9/SavingPets#>\n" +
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "\n" +
                "\n" +
                "SELECT ?personne ?candidature \n" +
                "WHERE {\n" +
                "?personne rdf:type ns:Personne .\n" +
                "?candidature rdf:type ns:C_vétérinaire .\n" +
                "?personne ns:postule ?candidature .\n" +
                "}";

        Model model = JenaEngine.readModel("data/SavingPets1.owl");

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
	
	
	@GetMapping("/RdvBenevole")
    public String getAllRdvBenevole() {

        String qexec = "PREFIX ns: <http://www.semanticweb.org/maiez/ontologies/2022/9/SavingPets#>\n" +
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "\n" +
                "\n" +
                "SELECT ?benevole (count(distinct ?rdvs) as ?count) \n" +
                "WHERE {\n" +
                "?benevole rdf:type ?Personne .\n" +
                "?benevole ns:reserver_rdv ?rdvs .\n" +
                "}\n" +
                "GROUP BY ?benevole";

        Model model = JenaEngine.readModel("data/SavingPets1.owl");

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
