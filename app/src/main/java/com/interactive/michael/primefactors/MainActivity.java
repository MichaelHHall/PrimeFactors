package com.interactive.michael.primefactors;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    int[][] primeSets = new int[9][6];
    int[] primes = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,97,101,103,107,109,113,127,131,137,139,149,151,157,163,167,173,179,181,191,193,197,199,211,223,227,229,233,239,241,251};
    int currentSet = 0;
    Button p1,p2,p3,p4,p5,p6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void init() {
        int p = 0;
        for(int x = 0; x<9;x++)
        {
            for(int y = 0; y<6;y++)
            {
                primeSets[x][y] = primes[p++];
            }
        }
        p1 = (Button)findViewById(R.id.Prime1);
        p2 = (Button)findViewById(R.id.Prime2);
        p3 = (Button)findViewById(R.id.Prime3);
        p4 = (Button)findViewById(R.id.Prime4);
        p5 = (Button)findViewById(R.id.Prime5);
        p6 = (Button)findViewById(R.id.Prime6);
    }
    public void minusClicked()
    {
        if(currentSet>0)
        {
            currentSet--;
            setButtons();
        }
    }
    public void plusClicked()
    {
        if(currentSet<8)
        {
            currentSet++;
            setButtons();
        }
    }
    public void setButtons()
    {
        p1.setText(primeSets[currentSet][0]);
        p2.setText(primeSets[currentSet][1]);
        p3.setText(primeSets[currentSet][2]);
        p4.setText(primeSets[currentSet][3]);
        p5.setText(primeSets[currentSet][4]);
        p6.setText(primeSets[currentSet][5]);
    }
}
