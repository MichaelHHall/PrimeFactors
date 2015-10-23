package com.interactive.michael.primefactors;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Vibrator;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    int[][] primeSets = new int[9][6];
    int[] primes = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101,103,107,109,113,127,131,137,139,149,151,157,163,167,173,179,181,191,193,197,199,211,223,227,229,233,239,241,251};
    int currentSet = 0;
    int currentNum = 0;
    Button p1,p2,p3,p4,p5,p6;
    TextView cNum,pList;
    ArrayList<Integer> currentPrimes = new ArrayList<Integer>();
    Vibrator v;
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
        v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        p1 = (Button)findViewById(R.id.Prime1);
        p2 = (Button)findViewById(R.id.Prime2);
        p3 = (Button)findViewById(R.id.Prime3);
        p4 = (Button)findViewById(R.id.Prime4);
        p5 = (Button)findViewById(R.id.Prime5);
        p6 = (Button)findViewById(R.id.Prime6);
        cNum = (TextView)findViewById(R.id.currentNum);
        pList = (TextView)findViewById(R.id.CurrentFactors);
        resetGame();
    }
    public void minusClicked(View view)
    {
        if(currentSet>0)
        {
            currentSet--;
            setButtons();
        }
    }
    public void plusClicked(View view)
    {
        if(currentSet<8)
        {
            currentSet++;
            setButtons();
        }
    }
    public void setButtons()
    {
        p1.setText(String.valueOf(primeSets[currentSet][0]));
        p2.setText(String.valueOf(primeSets[currentSet][1]));
        p3.setText(String.valueOf(primeSets[currentSet][2]));
        p4.setText(String.valueOf(primeSets[currentSet][3]));
        p5.setText(String.valueOf(primeSets[currentSet][4]));
        p6.setText(String.valueOf(primeSets[currentSet][5]));
    }
    public void resetGame() {
        currentSet = 0;
        setButtons();
        currentNum = (int) ((400 * Math.random()) + 100);
        cNum.setText(String.valueOf(currentNum));
        currentPrimes = new ArrayList<Integer>();
        setPrimeList();
    }
    public void prime1Pressed(View view){
        if(currentNum%primeSets[currentSet][0]==0)
        {
            currentNum = currentNum/primeSets[currentSet][0];
            cNum.setText(String.valueOf(currentNum));
            currentPrimes.add(primeSets[currentSet][0]);
            setPrimeList();
            checkWin();
        }
        else
        {
            resetGame();
            pList.setText("YOU LOSE");
            //want to vibrate here
            v.vibrate(500);
        }
    }
    public void prime2Pressed(View view){
        if(currentNum%primeSets[currentSet][1]==0)
        {
            currentNum = currentNum/primeSets[currentSet][1];
            cNum.setText(String.valueOf(currentNum));
            currentPrimes.add(primeSets[currentSet][1]);
            setPrimeList();
            checkWin();
        }
        else
        {
            resetGame();
            pList.setText("YOU LOSE");
            //want to vibrate here
            v.vibrate(500);
        }
    }
    public void prime3Pressed(View view){
        if(currentNum%primeSets[currentSet][2]==0)
        {
            currentNum = currentNum/primeSets[currentSet][2];
            cNum.setText(String.valueOf(currentNum));
            currentPrimes.add(primeSets[currentSet][2]);
            setPrimeList();
            checkWin();
        }
        else
        {
            resetGame();
            pList.setText("YOU LOSE");
            //want to vibrate here
            v.vibrate(500);
        }
    }
    public void prime4Pressed(View view){
        if(currentNum%primeSets[currentSet][3]==0)
        {
            currentNum = currentNum/primeSets[currentSet][3];
            cNum.setText(String.valueOf(currentNum));
            currentPrimes.add(primeSets[currentSet][3]);
            setPrimeList();
            checkWin();
        }
        else
        {
            resetGame();
            pList.setText("YOU LOSE");
            //want to vibrate here
            v.vibrate(500);
        }
    }
    public void prime5Pressed(View view){
        if(currentNum%primeSets[currentSet][4]==0)
        {
            currentNum = currentNum/primeSets[currentSet][4];
            cNum.setText(String.valueOf(currentNum));
            currentPrimes.add(primeSets[currentSet][4]);
            setPrimeList();
            checkWin();
        }
        else
        {
            resetGame();
            pList.setText("YOU LOSE");
            //want to vibrate here
            v.vibrate(500);
        }
    }
    public void prime6Pressed(View view){
        if(currentNum%primeSets[currentSet][5]==0)
        {
            currentNum = currentNum/primeSets[currentSet][5];
            cNum.setText(String.valueOf(currentNum));
            currentPrimes.add(primeSets[currentSet][5]);
            setPrimeList();
            checkWin();
        }
        else
        {
            resetGame();
            pList.setText("YOU LOSE");
            //want to vibrate here
            v.vibrate(500);
        }
    }
    public void setPrimeList(){
        String outp = "";
        for(int x = 0; x<currentPrimes.size();x++)
        {
            outp = outp+currentPrimes.get(x)+",";
        }
        outp = outp + "\b";
        pList.setText(outp);
    }
    public void checkWin(){
        if(isPrime(currentNum))
        {
            //you win
            resetGame();
            pList.setText("YOU WIN");
        }
    }
    public boolean isPrime(int c){
        for(int x = 0;x<primes.length;x++)
        {
            if(c==primes[x])
            {
                return true;
            }
        }
        return false;
    }
}
