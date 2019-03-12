package romaricgauzi.fr.quizmadrid;

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
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.new_game);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setSubtitle("Using ToolBar");

        this.editText = findViewById(R.id.teamName);
    }

    public void startGame(View view) {
        String txt = editText.getText().toString();
        if(txt.equalsIgnoreCase("")) {
            Toast.makeText(this, "Il faut donner un nom à votre équipe",
                    Toast.LENGTH_SHORT).show();
        }else{
            Intent intent = new Intent(this, HomelessnessList.class);
            intent.putExtra(TEAM_NAME_MESSAGE, txt);
            startActivity(intent);
            finish();
        }

    }
}