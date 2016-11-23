import com.google.gson.Gson;
import datastore.DataStore;
import game.Connect4Game;
import org.json.simple.JSONObject;

import javax.jws.Oneway;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Radu on 22.11.2016.
 */
@WebServlet(urlPatterns = {"/game/*"}, loadOnStartup = 1)
public class MainServlet extends HttpServlet{

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        Connect4Game game;
        if(request.getParameter("force") != null){
            game = new Connect4Game();
        } else {
            game = DataStore.getInstance().getGame(request.getSession().getId());
        }
        request.getSession().setAttribute("Game", game);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status","Game Ready! Red Turn");
        Gson gson = new Gson();
        jsonObject.put("matrix",gson.toJson(game.getMatrix()));
        response.getOutputStream().print(jsonObject.toJSONString());
    }

    @Override
    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException{
        Connect4Game game = (Connect4Game) request.getSession().getAttribute("Game");
        JSONObject jsonObject = new JSONObject();
        if(game.isGameOver()){
            jsonObject.put("status", "Game is Over! Please restart");
        } else {
            String status = game.addToken(Integer.parseInt(request.getParameter("column"))).getText();
            DataStore.getInstance().saveGame(request.getSession().getId(), game);
            jsonObject.put("status",status);
        }

        Gson gson = new Gson();
        jsonObject.put("matrix",gson.toJson(game.getMatrix()));

        response.getOutputStream().print(jsonObject.toJSONString());

    }
}
