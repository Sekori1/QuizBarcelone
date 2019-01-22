package romaricgauzi.fr.quizmadrid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static String TEAM_NAME_MESSAGE = "TEAM_NAME_MESSAGE";

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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