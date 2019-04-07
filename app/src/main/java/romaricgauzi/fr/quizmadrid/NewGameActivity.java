package romaricgauzi.fr.quizmadrid;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class NewGameActivity extends AppCompatActivity {

    public static String TEAM_NAME_MESSAGE = "TEAM_NAME_MESSAGE";

    private EditText editText;

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

        this.editText = findViewById(R.id.teamName);
    }

    public void startGame(View view) {
        String txt = editText.getText().toString();
        if(txt.equalsIgnoreCase("")) {
            Toast.makeText(this, "Il faut avoir le code professeur pour lancer le quiz",
                    Toast.LENGTH_SHORT).show();
        }else{
            if(txt.equalsIgnoreCase("9347")){
                Intent intent = new Intent(this, Home.class);
                intent.putExtra(TEAM_NAME_MESSAGE, txt);
                startActivity(intent);
                finish();
            }else{
                Toast.makeText(this, "Code incorrecte!",
                        Toast.LENGTH_SHORT).show();
            }
        }
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