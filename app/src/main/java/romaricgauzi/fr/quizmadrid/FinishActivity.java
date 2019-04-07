package romaricgauzi.fr.quizmadrid;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

public class FinishActivity extends AppCompatActivity {

    private final static int BACK_ALERT = 10;

    private TextView score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        this.score = findViewById(R.id.score);

        this.score.setText(Home.getScore());

    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            showDialog(BACK_ALERT);
            return false;
        }

        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case BACK_ALERT:
                // Create out AlterDialog
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Voulez-vous vraiment quitter le Quiz ?");
                builder.setCancelable(true);
                builder.setPositiveButton("Quitter", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        onBackPressed();
                    }
                });
                builder.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
        }
        return super.onCreateDialog(id);
    }

    public void indisponible(View v){
        AlertDialog.Builder builder3 = new AlertDialog.Builder(this);
        builder3.setMessage("Fonctionnalité indisponible pour le moment");
        builder3.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog dialog3 = builder3.create();
        dialog3.show();
    }
}
