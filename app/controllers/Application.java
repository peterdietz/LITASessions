package controllers;


import models.Session;
import org.codehaus.jackson.JsonNode;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.front;

import com.csvreader.CsvReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Application extends Controller {

    public enum HeaderFields {
        Date, Time, Topic, Description, Presenter, Room
    }
    
    public static String[] headers;
  
  public static Result index() throws IOException {
      // Get all data from the Google Docs spreadsheet, and convert to a list of Sessions.


      String contentURL = "https://docs.google.com/spreadsheet/pub?key=0AjHQr6EmDdMLdE9MX05uOWx0OHg0aDdQYm45WUctM1E&single=true&gid=0&output=csv";
      HttpURLConnection conn;
      URL url = new URL(contentURL);

      conn = (HttpURLConnection) url.openConnection();
      conn.setRequestMethod("GET");
      conn.setRequestProperty("Accept", "text/csv");

      if (conn.getResponseCode() != 200) {
          throw new MalformedURLException("Non-200 response: " + conn.getResponseMessage());
      }



      CsvReader csvReader = new CsvReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
      csvReader.readHeaders();
      headers = csvReader.getHeaders();

      int rowNumber = 1;
      List sessions = new ArrayList<Session>();
      while(csvReader.readRecord()) {
          String[] currentLine = csvReader.getValues();
          Session session = parseSessionFromCSVString(currentLine);
          sessions.add(session);
      }

    return ok(front.render("LITA Forum Schedule 2012", sessions));
  }

    private static Session parseSessionFromJSON(JsonNode json) {

        Session session = new Session();


        session.date = json.get("Date").asText();
        session.description = json.get("Description").asText();
        session.presenter = json.get("Presenter").asText();
        session.room = json.get("Room").asText();
        session.time = json.get("Time").asText();
        session.topic = json.get("Topic").asText();

        //List<String> sidebarText = commnityJSON.findValuesAsText("sidebarText");
        return session;
    }
    
    private static Session parseSessionFromCSVString(String[] csvRow) {
        Session session = new Session();
        session.date = csvRow[HeaderFields.Date.ordinal()];
        session.description = csvRow[HeaderFields.Description.ordinal()];
        session.presenter = csvRow[HeaderFields.Presenter.ordinal()];
        session.room = csvRow[HeaderFields.Room.ordinal()];
        session.time = csvRow[HeaderFields.Time.ordinal()];
        session.topic = csvRow[HeaderFields.Topic.ordinal()];

        //List<String> sidebarText = commnityJSON.findValuesAsText("sidebarText");
        return session;
    }

  
}