package romaricgauzi.fr.quizmadrid.utils;

import android.util.Log;

public class AccesMail implements AsyncResponse {

    private static final String SERVER_ADDRESS = "http://romaric.gauzi.fr/mail.php";

    @Override
    public void processFinish(String output) {
        Log.d("HTTP", output);
    }

    public void send(String teamName, String[] players, int score, int maxScore, String time){
        AccesHTTP accesHTTP = new AccesHTTP(this);

        accesHTTP.addParam("teamname", teamName);

        StringBuilder sb = new StringBuilder();
        for (String player : players){
            player.replace(",", "#");
            sb.append(player + ",");
        }

        accesHTTP.addParam("players", sb.toString());
        accesHTTP.addParam("score", String.valueOf(score));
        accesHTTP.addParam("maxscore", String.valueOf(maxScore));
        accesHTTP.addParam("time", time);

        accesHTTP.execute(SERVER_ADDRESS);
    }
}
