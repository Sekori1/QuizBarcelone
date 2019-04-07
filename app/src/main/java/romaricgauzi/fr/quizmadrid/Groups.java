package romaricgauzi.fr.quizmadrid;

import android.widget.TextView;

public enum Groups {

    GREEN(0),
    YELLOW(1),
    BLUE(2),
    RED(3);

    private int id;

    Groups(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static Groups find(int id){
        for (Groups g : values() ) {
            if(g.id == id)return g;
        }
        return null;
    }

    public void changeGroupBackground(TextView textView){
        changeGroupBackground(this, textView);
    }

    public static void changeGroupBackground(Groups groups, TextView textView){
        int id = 0;
        switch (groups){
            case RED:
                id = R.drawable.question_red;
                break;
            case BLUE:
                id = R.drawable.question_blue;
                break;
            case GREEN:
                id = R.drawable.question_green;
                break;
            case YELLOW:
                id = R.drawable.question_yellow;
        }
        if(id != 0) {
            textView.setBackgroundResource(id);
        }
    }
}
