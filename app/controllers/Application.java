package controllers;



import models.Session;
import org.codehaus.jackson.JsonNode;
import play.*;
import play.libs.Json;
import play.mvc.*;

import views.html.*;

import java.util.ArrayList;
import java.util.List;

public class Application extends Controller {
  
  public static Result index() {



      JsonNode scheduleJson = Json.parse("[\n" +
              "\t{\n" +
              "\t\t\"Date\": \"10/4/2012\",\n" +
              "\t\t\"Time\": \"1:00 p.m. - 5:00 p.m.\",\n" +
              "\t\t\"Topic\": \"PRECONFERENCE I\",\n" +
              "\t\t\"Description\": \"Developing a Web Analytics Strategy for Your Library: Using Data to Measure Success\",\n" +
              "\t\t\"Presenter\": \"Tabatha Farney, Nina McHale\",\n" +
              "\t\t\"Room\": \"Delaware D\"\n" +
              "\t},\n" +
              "\t{\n" +
              "\t\t\"Date\": \"10/4/2012\",\n" +
              "\t\t\"Time\": \"1:00 p.m. - 5:00 p.m.\",\n" +
              "\t\t\"Topic\": \"PRECONFERENCE II\",\n" +
              "\t\t\"Description\": \"Everything You Never Wanted to Know About Running Your Systems (And Are Afraid to Ask!)\",\n" +
              "\t\t\"Presenter\": \"Christopher Manly\",\n" +
              "\t\t\"Room\": \"Delaware C\"\n" +
              "\t},\n" +
              "\t{\n" +
              "\t\t\"Date\": \"10/5/2012\",\n" +
              "\t\t\"Time\": \"8:00 a.m. - Noon\",\n" +
              "\t\t\"Topic\": \"PRECONFERENCE I, cont.\",\n" +
              "\t\t\"Description\": \"Developing a Web Analytics Strategy for Your Library: Using Data to Measure Success\",\n" +
              "\t\t\"Presenter\": \"Tabatha Farney, Nina McHale\",\n" +
              "\t\t\"Room\": \"Delaware D\"\n" +
              "\t},\n" +
              "\t{\n" +
              "\t\t\"Date\": \"10/5/2012\",\n" +
              "\t\t\"Time\": \"8:00 a.m. - Noon\",\n" +
              "\t\t\"Topic\": \"PRECONFERENCE II, cont.\",\n" +
              "\t\t\"Description\": \"Everything You Never Wanted to Know About Running Your Systems (And Are Afraid to Ask!)\",\n" +
              "\t\t\"Presenter\": \"Christopher Manly\",\n" +
              "\t\t\"Room\": \"Delaware C\"\n" +
              "\t},\n" +
              "\t{\n" +
              "\t\t\"Date\": \"10/5/2012\",\n" +
              "\t\t\"Time\": \"1:00 p.m. - 2:30 p.m.\",\n" +
              "\t\t\"Topic\": \"OPENING GENERAL SESSION\",\n" +
              "\t\t\"Description\": \"\",\n" +
              "\t\t\"Presenter\": \"Eric Hellman\",\n" +
              "\t\t\"Room\": \"Union\"\n" +
              "\t},\n" +
              "\t{\n" +
              "\t\t\"Date\": \"10/5/2012\",\n" +
              "\t\t\"Time\": \"2:30 p.m. - 3:10 p.m.\",\n" +
              "\t\t\"Topic\": \"REFRESHMENT BREAK/First Time Attendee Orientation\",\n" +
              "\t\t\"Description\": \"\",\n" +
              "\t\t\"Presenter\": \"\",\n" +
              "\t\t\"Room\": \"Lobby\"\n" +
              "\t},\n" +
              "\t{\n" +
              "\t\t\"Date\": \"10/5/2012\",\n" +
              "\t\t\"Time\": \"3:10 p.m. - 4:00 p.m.\",\n" +
              "\t\t\"Topic\": \"CONCURRENT SESSION 1\",\n" +
              "\t\t\"Description\": \"11 Digital Publishing Trends to Watch This Year and Their Potential Impact on Libraries\",\n" +
              "\t\t\"Presenter\": \" Aaron K. Shrimplin, Eli Sullivan\",\n" +
              "\t\t\"Room\": \"Fayette\"\n" +
              "\t},\n" +
              "\t{\n" +
              "\t\t\"Date\": \"10/5/2012\",\n" +
              "\t\t\"Time\": \"3:10 p.m. - 4:00 p.m.\",\n" +
              "\t\t\"Topic\": \"CONCURRENT SESSION 1\",\n" +
              "\t\t\"Description\": \"Persona Most Grata: Invoking the User from Data to Design\",\n" +
              "\t\t\"Presenter\": \"Alexa Pearce, Nadaleen Tempelman-Kluit\",\n" +
              "\t\t\"Room\": \"Fairfield\"\n" +
              "\t},\n" +
              "\t{\n" +
              "\t\t\"Date\": \"10/5/2012\",\n" +
              "\t\t\"Time\": \"3:10 p.m. - 4:00 p.m.\",\n" +
              "\t\t\"Topic\": \"CONCURRENT SESSION 1\",\n" +
              "\t\t\"Description\": \"Where's that Book? Transforming Bib. Data into Item-Level Collection Maps in the Web PAC\",\n" +
              "\t\t\"Presenter\": \"Geoffrey Timms, Jeremy Brown\",\n" +
              "\t\t\"Room\": \"Madison\"\n" +
              "\t},\n" +
              "\t{\n" +
              "\t\t\"Date\": \"10/5/2012\",\n" +
              "\t\t\"Time\": \"3:10 p.m. - 4:00 p.m.\",\n" +
              "\t\t\"Topic\": \"CONCURRENT SESSION 1\",\n" +
              "\t\t\"Description\": \"Mobile Library Catalog using Z39.50\",\n" +
              "\t\t\"Presenter\": \"James Paul Muir\",\n" +
              "\t\t\"Room\": \"Knox\"\n" +
              "\t},\n" +
              "\t{\n" +
              "\t\t\"Date\": \"10/5/2012\",\n" +
              "\t\t\"Time\": \"3:10 p.m. - 4:00 p.m.\",\n" +
              "\t\t\"Topic\": \"CONCURRENT SESSION 1\",\n" +
              "\t\t\"Description\": \"Human Factors in Library Resource Discovery Systems: A Study of Information Seeking Patterns in a Modern Academic Environment\",\n" +
              "\t\t\"Presenter\": \"Haihua Li, Jason Battles\",\n" +
              "\t\t\"Room\": \"Marion\"\n" +
              "\t},\n" +
              "\t{\n" +
              "\t\t\"Date\": \"10/5/2012\",\n" +
              "\t\t\"Time\": \"3:10 p.m. - 4:00 p.m.\",\n" +
              "\t\t\"Topic\": \"CONCURRENT SESSION 1\",\n" +
              "\t\t\"Description\": \"Building Collections in IR from External Data Sources\",\n" +
              "\t\t\"Presenter\": \"Sai Deng, Susan Matveyeva\",\n" +
              "\t\t\"Room\": \"Morrow\"\n" +
              "\t},\n" +
              "\t{\n" +
              "\t\t\"Date\": \"10/5/2012\",\n" +
              "\t\t\"Time\": \"4:00 p.m. - 4:20 p.m.\",\n" +
              "\t\t\"Topic\": \"BREAK\",\n" +
              "\t\t\"Description\": \"\",\n" +
              "\t\t\"Presenter\": \"\",\n" +
              "\t\t\"Room\": \"\"\n" +
              "\t},\n" +
              "\t{\n" +
              "\t\t\"Date\": \"10/5/2012\",\n" +
              "\t\t\"Time\": \"4:20 p.m. - 5:10 p.m.\",\n" +
              "\t\t\"Topic\": \"CONCURRENT SESSION 2\",\n" +
              "\t\t\"Description\": \"JQuery Mobile Framework: an easy and professional way to create a mobile website\",\n" +
              "\t\t\"Presenter\": \"Don Kim\",\n" +
              "\t\t\"Room\": \"Fayette\"\n" +
              "\t},\n" +
              "\t{\n" +
              "\t\t\"Date\": \"10/5/2012\",\n" +
              "\t\t\"Time\": \"4:20 p.m. - 5:10 p.m.\",\n" +
              "\t\t\"Topic\": \"CONCURRENT SESSION 2\",\n" +
              "\t\t\"Description\": \"Library Analytics Toolkit\",\n" +
              "\t\t\"Presenter\": \"Carli Spina\",\n" +
              "\t\t\"Room\": \"Fairfield\"\n" +
              "\t},\n" +
              "\t{\n" +
              "\t\t\"Date\": \"10/5/2012\",\n" +
              "\t\t\"Time\": \"4:20 p.m. - 5:10 p.m.\",\n" +
              "\t\t\"Topic\": \"CONCURRENT SESSION 2\",\n" +
              "\t\t\"Description\": \"Doctoring Strange Results (or, how I learned to stop worrying and love my Discovery tool)\",\n" +
              "\t\t\"Presenter\": \"Josh Petrusa, Courtney Greene\",\n" +
              "\t\t\"Room\": \"Madison\"\n" +
              "\t},\n" +
              "\t{\n" +
              "\t\t\"Date\": \"10/5/2012\",\n" +
              "\t\t\"Time\": \"4:20 p.m. - 5:10 p.m.\",\n" +
              "\t\t\"Topic\": \"CONCURRENT SESSION 2\",\n" +
              "\t\t\"Description\": \"Library Favorites and Resource Modeling\",\n" +
              "\t\t\"Presenter\": \"Ken Varnum\",\n" +
              "\t\t\"Room\": \"Knox\"\n" +
              "\t},\n" +
              "\t{\n" +
              "\t\t\"Date\": \"10/5/2012\",\n" +
              "\t\t\"Time\": \"4:20 p.m. - 5:10 p.m.\",\n" +
              "\t\t\"Topic\": \"CONCURRENT SESSION 2\",\n" +
              "\t\t\"Description\": \"The Dream of Data Integration\",\n" +
              "\t\t\"Presenter\": \"Kara Reuter, Stefan Langer\",\n" +
              "\t\t\"Room\": \"Marion\"\n" +
              "\t}\n" +
              "]");

      List sessionList = new ArrayList<Session>();

      for(JsonNode sessionNode : scheduleJson) {
          sessionList.add(parseSessionFromJSON(sessionNode));
      }

    return ok(front.render("Your new application is ready.", sessionList));
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
  
}