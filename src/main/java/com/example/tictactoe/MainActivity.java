package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean gameactive = true;
    // 0 - X
    // 1 - O
    int activeplayer = 0;
    int[] gamestate = {2,2,2,2,2,2,2,2,2};
    int[][] winpos = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    public void playertap(View view)
    {
        ImageView img = (ImageView) view;
        int tappedimg = Integer.parseInt(img.getTag().toString());
        if(!gameactive)
        {
            reset(view);
        }
        if(gamestate[tappedimg]== 2) {
            gamestate[tappedimg] = activeplayer;
            img.setTranslationY(-1000f);
            if (activeplayer == 1) {
                img.setImageResource(R.drawable.circle);
                activeplayer = 0;
                TextView status = findViewById(R.id.status);
                status.setText("X's Turn - Tap to play");
            } else {
                img.setImageResource(R.drawable.cross);
                activeplayer = 1;
                TextView status = findViewById(R.id.status);
                status.setText("O's Turn - Tap to play");
            }



            img.animate().translationYBy(1000f).setDuration(300);
        }
        for(int[] winpos: winpos)
        {
            if(gamestate[winpos[0]] == gamestate[winpos[1]] && gamestate[winpos[0]] == gamestate[winpos[2]] && gamestate[0]!=2)
            {
                String winnerstr;
                gameactive = false;
                if(gamestate[winpos[0]] == 0)
                {
                    winnerstr = "X has won!";
                }
                else
                {
                    winnerstr = "O has won!";
                }

                TextView status = findViewById(R.id.status);
                status.setText(winnerstr);
            }

        }
    }
    public void reset(View view)
    {
        gameactive = true;
        activeplayer = 0;
        for(int i=0; i<gamestate.length; i++)
        {
            gamestate[i] = 2;
        }
        ((ImageView)findViewById(R.id.ImageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);


        TextView status = findViewById(R.id.status);
        status.setText("X's Turn - Tap to play");
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
