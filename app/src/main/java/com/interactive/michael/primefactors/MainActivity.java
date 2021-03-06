package com.interactive.michael.primefactors;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Vibrator;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    int[][] primeSets;
    int[] primes;
    int currentSet = 0;
    int currentNum = 0;
    int startNum = 0;
    Button p1,p2,p3,p4,p5,p6;
    TextView cNum,pList,tShit,subTit,subSub;
    ArrayList<Integer> currentPrimes = new ArrayList<Integer>();
    Vibrator v;
    int maxNum;
    int numSets=0;
    boolean dead = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    //Game Creation
    public void startGame(int kill){
        setContentView(R.layout.game_layout);
        init(kill);
    }
    public void init(int diff) {
        maxNum = diff;
        //int p = 0;
        //for(int x = 0; x<9;x++)
        //{
        //    for(int y = 0; y<6;y++)
        //    {
        //        primeSets[x][y] = primes[p++];
        //    }
        //}
        v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        p1 = (Button)findViewById(R.id.Prime1);
        p2 = (Button)findViewById(R.id.Prime2);
        p3 = (Button)findViewById(R.id.Prime3);
        p4 = (Button)findViewById(R.id.Prime4);
        p5 = (Button)findViewById(R.id.Prime5);
        p6 = (Button)findViewById(R.id.Prime6);
        cNum = (TextView)findViewById(R.id.currentNum);
        pList = (TextView)findViewById(R.id.CurrentFactors);
        tShit = (TextView)findViewById(R.id.topShit);
        subTit = (TextView)findViewById(R.id.subtitle);
        subSub = (TextView)findViewById(R.id.subsub);
        resetGame();
    }
    public void resetGame() {
        currentSet = 0;
        do
        {
            currentNum = (int) (((maxNum-100) * Math.random()) + 100);
        }while(isPrime(currentNum));
        startNum=currentNum;
        primes = generatePrimes(maxNum);
        cNum.setText(String.valueOf(currentNum));
        currentPrimes = new ArrayList<Integer>();
        primeSets = generatePrimeList();
        setButtons();
        setPrimeList();
        numSets = primes.length/6;
        tShit.setText("Choose all Prime Factors of");
        subTit.setText("Current Prime Factors");
        subSub.setText("Choose a Prime Factor");
    }
    public int[] generatePrimes(int m) {
        ArrayList<Integer> pp = new ArrayList<Integer>();
        for(int g = 2; g<Math.ceil(m/2);g++)
        {
            if(isPrime(g))
            {
                pp.add(g);
            }
        }
        int d =pp.get(pp.size()-1)+1;
        while(pp.size()%6!=0)
        {
            if(isPrime(d))
            {
                pp.add(d);
            }
            d++;
        }
        int[] p = new int[pp.size()];
        for(int x = 0; x<pp.size();x++)
        {
            p[x]=pp.get(x);
        }
        return p;
    }
    public int[][] generatePrimeList() {
        int[][] l = new int[primes.length/6][6];
        int f=0;
        for(int x=0;x<primes.length/6;x++)
        {
            for(int y=0;y<6;y++)
            {
                l[x][y] = primes[f];
                f++;
            }
        }
        return l;
    }

    //Button Pressing
    public void prime1Pressed(View view){
        if(dead)
        {
            dead = false;
            resetGame();
        }
        else if(currentNum%primeSets[currentSet][0]==0)
        {
            currentNum = currentNum/primeSets[currentSet][0];
            cNum.setText(String.valueOf(currentNum));
            currentPrimes.add(primeSets[currentSet][0]);
            setPrimeList();
            checkWin();
        }
        else
        {
            youLose(primeSets[currentSet][0]);
        }
    }
    public void prime2Pressed(View view){
        if(dead)
        {
            dead = false;
            resetGame();
        }
        else if(currentNum%primeSets[currentSet][1]==0)
        {
            currentNum = currentNum/primeSets[currentSet][1];
            cNum.setText(String.valueOf(currentNum));
            currentPrimes.add(primeSets[currentSet][1]);
            setPrimeList();
            checkWin();
        }
        else
        {
            youLose(primeSets[currentSet][1]);
        }
    }
    public void prime3Pressed(View view){
        if(dead)
        {
            dead = false;
            resetGame();
        }
        else if(currentNum%primeSets[currentSet][2]==0)
        {
            currentNum = currentNum/primeSets[currentSet][2];
            cNum.setText(String.valueOf(currentNum));
            currentPrimes.add(primeSets[currentSet][2]);
            setPrimeList();
            checkWin();
        }
        else
        {
            youLose(primeSets[currentSet][2]);
        }
    }
    public void prime4Pressed(View view){
        if(dead)
        {
            dead = false;
            resetGame();
        }
        else if(currentNum%primeSets[currentSet][3]==0)
        {
            currentNum = currentNum/primeSets[currentSet][3];
            cNum.setText(String.valueOf(currentNum));
            currentPrimes.add(primeSets[currentSet][3]);
            setPrimeList();
            checkWin();
        }
        else
        {
            youLose(primeSets[currentSet][3]);
        }
    }
    public void prime5Pressed(View view){
        if(dead)
        {
            dead = false;
            resetGame();
        }
        else if(currentNum%primeSets[currentSet][4]==0)
        {
            currentNum = currentNum/primeSets[currentSet][4];
            cNum.setText(String.valueOf(currentNum));
            currentPrimes.add(primeSets[currentSet][4]);
            setPrimeList();
            checkWin();
        }
        else
        {
            youLose(primeSets[currentSet][4]);
        }
    }
    public void prime6Pressed(View view){
        if(dead)
        {
            dead = false;
            resetGame();
        }
        else if(currentNum%primeSets[currentSet][5]==0)
        {
            currentNum = currentNum/primeSets[currentSet][5];
            cNum.setText(String.valueOf(currentNum));
            currentPrimes.add(primeSets[currentSet][5]);
            setPrimeList();
            checkWin();
        }
        else
        {
            youLose(primeSets[currentSet][5]);
        }
    }
    public void minusClicked(View view) {
        if(dead)
        {
            dead = false;
            resetGame();
        }
        else if(currentSet>0)
        {
            currentSet--;
            setButtons();
        }
    }
    public void plusClicked(View view) {
        if(dead)
        {
            dead = false;
            resetGame();
        }
        else if(currentSet<numSets)
        {
            currentSet++;
            setButtons();
        }
    }

    //Game Control
    public void setButtons() {
        p1.setText(String.valueOf(primeSets[currentSet][0]));
        p2.setText(String.valueOf(primeSets[currentSet][1]));
        p3.setText(String.valueOf(primeSets[currentSet][2]));
        p4.setText(String.valueOf(primeSets[currentSet][3]));
        p5.setText(String.valueOf(primeSets[currentSet][4]));
        p6.setText(String.valueOf(primeSets[currentSet][5]));
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
            String pout = "YOU WIN! Primes:\n";
            for(int x = 0; x<currentPrimes.size();x++)
            {
                pout = pout+currentPrimes.get(x)+",";
            }
            pout = pout + "\b";
            pList.setText(pout);
        }
    }
    public boolean isPrime(int c){
        for(int x = 2;x<c;x++)
        {
            if(c%x==0)
            {
                return false;
            }
        }
        return true;
    }
    public void youLose(int wrong){
        v.vibrate(500);
        dead = true;
        tShit.setText("You lose! Starting number:");
        cNum.setText(String.valueOf(startNum));
        subTit.setText("primes you got so far:");
        subSub.setText("You got out by guessing: "+wrong+"\nClick any button to restart");
    }

    public void startPressed(View view) {
        EditText edit = (EditText)findViewById(R.id.maxSelect);
        int d = Integer.valueOf(edit.getText().toString());
        startGame(d);
    }

}
