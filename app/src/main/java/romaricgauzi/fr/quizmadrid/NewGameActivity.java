package romaricgauzi.fr.quizmadrid;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class NewGameActivity extends AppCompatActivity {

    public static String TEAM_NAME_MESSAGE = "TEAM_NAME_MESSAGE";

    private EditText teamName;
    private EditText profCode;

    private TextView amountDisplayer;

    private List<String> players = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.new_game);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        this.teamName = findViewById(R.id.teamName);
        this.profCode = findViewById(R.id.profCode);

        this.amountDisplayer = findViewById(R.id.playerAmountDisplayer);
    }

    public void startGame(View view) {
        String teamNameTxt = this.teamName.getText().toString();
        String txt = profCode.getText().toString();
        if(txt.equalsIgnoreCase("")) {
            Toast.makeText(this, "Il faut avoir le code professeur pour lancer le quiz",
                    Toast.LENGTH_SHORT).show();
        }
        else if(teamNameTxt.equalsIgnoreCase("")){
            Toast.makeText(this, "Il faut donner un nom à votre équipe",
                    Toast.LENGTH_SHORT).show();
        }
        else{
            if(txt.equalsIgnoreCase("9347")){
                Intent intent = new Intent(this, Home.class);
                Home.TEAM_NAME = teamNameTxt;
                Home.PLAYERS = this.players.toArray(new String[0]);

                startActivity(intent);
                finish();
            }else{
                Toast.makeText(this, "Code incorrecte!",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void addPlayer(View view){
        final Dialog d = new Dialog(this);
        d.setTitle("Ajouter un joueur à votre équipe");
        d.setContentView(R.layout.add_player_dialog);
        d.show();

        final TextView playerName = d.findViewById(R.id.playerName);
        d.findViewById(R.id.addButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = playerName.getText().toString();
                if(name.equalsIgnoreCase("")){
                    Toast.makeText(NewGameActivity.this, "Il faut donner un nom au joueur" + name, Toast.LENGTH_SHORT).show();
                }else{
                    players.add(name);
                    playerName.setText("");
                    amountDisplayer.setText(String.valueOf(players.size()));
                    Toast.makeText(NewGameActivity.this, "Le joueur a bien été ajouté", Toast.LENGTH_SHORT).show();
                }
            }
        });
        d.findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d.dismiss();
            }
        });
    }

    public void getCode(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Le code doit etre donné par votre professeur, guide, ou autres.");
        builder.setCancelable(true);
        builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}