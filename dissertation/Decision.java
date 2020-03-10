/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dissertation;
import java.util.*;
/**
 *
 * @author Chris Cullen
 */
public class Decision {
public char player1 ='X';
public char player2 = 'O';

public String takeAction;
public Move[] moves = new Move[9];
public Move bestMaxMove= new Move();
public Move bestMinMove = new Move();
public char[][] currBoard = new char[3][3];
ArrayList<String> available = new ArrayList<String>();
int EV = 0 ;
  
  
    public ArrayList<String> emptySpace(char[][] state){
    for(int row=0; row<3; row++){
        for(int col=0;col<3;col++){
           if(state[col][row]=='f'){available.add(Integer.toString(col)+Integer.toString(row));}
           }
       }
    return available;
    }
  
    public Move alphaBetaPrune(char[][] state, char player, int func){
        
        if(endGame(state,player1)){bestMaxMove.setScore(400); return bestMaxMove;}
        else if(endGame(state,player2)){ bestMinMove.setScore(-400); return bestMinMove;}
        else if(isDraw(state, player1)){bestMaxMove.setScore(0); return bestMaxMove;}
        else {bestMaxMove.setScore(0);}
        if(player=='X'){bestMaxMove.setScore(maxValue(state,-1000,1000,3,'X',func));}
        System.out.println("best max pos"+ bestMaxMove.getPosition());
        System.out.println(bestMaxMove.getScore());
       return bestMaxMove;
     
    }
    
    public int maxValue(char[][] state, int a, int b, int depth,char player, int func){ 
        
       if(endGame(state,player1)){return EV=400;}
       else if(endGame(state,player2)){return EV=-400;}
       else if(isDraw(state, player1)){return EV=0;}
       else if(depth <= 0){ 
                if(func==3){ return evalFunc(state);}
                if(func==2){return evalFunc2(state);}
        }
        
        EV=a;
        available.clear();
        available =emptySpace(state);
                    
        for(int i=0 ; i < available.size(); i++){
            Move move = new Move();
            move.setPosition(available.get(i));
            
            state=result(state,move.getPosition(),player1);
            EV= Math.max(EV, minValue((state),a,b,depth= depth-1, 'O',func));
            
            if(minValue((state),a,b,depth= depth-1, 'O',func)>=EV){
                bestMaxMove.setPosition(move.getPosition());
                }
            bestMaxMove.setScore(EV);
            available.clear();
            state=result(state,move.getPosition(), 'f');
                   
            available =emptySpace(state);
            depth=depth+1;
            if(EV>=b){
                return EV;}
            a = Math.max(a,EV);
        }            
        return EV;
    }
    
    
    public int minValue(char[][] state, int a, int b,int depth, char player, int func){ //returns int
        
        if(endGame(state,player1)){return EV=400;}
        else if(endGame(state,player2)){return EV=-400;}
        else if(isDraw(state, player2)){return EV=0;}
        else if(depth <= 0){ 
            if(func==3){ return evalFunc(state);}
            if(func==2){return evalFunc2(state);}
        
        }
        EV=b;
        available.clear();
        available =emptySpace(state);
               
        for(int i=0 ; i < available.size(); i++){
          Move move = new Move();
          move.setPosition(available.get(i));
          state=result(state,move.getPosition(),player2);
          
          
          EV= Math.min(EV, maxValue(result(state,move.getPosition(), player2),a,b,depth= depth-1,'X',func));
          if(maxValue((state),a,b,depth= depth-1, 'X',func)>=EV){
              bestMaxMove.setPosition(move.getPosition());
          }
        
          bestMinMove.setScore(EV);
          available.clear();
          state=result(state,move.getPosition(), 'f');           
          available =emptySpace(state); 
          depth=depth+1;
          if(EV<=a){
             return EV;}
          b = Math.min(b,EV);
        }     
        return EV;
    }
    
    /**
     * @param state
     * @param player
     * @return the currBoard
     */
    public boolean endGame(char[][] state,char player){ 
        
    return (state[0][0]==player&&state[1][1]==player&&state[2][2]==player)||
    (state[0][0]==player&&state[1][0]==player&&state[2][0]==player)||
    (state[0][0]==player&&state[0][1]==player&&state[0][2]==player)||
    (state[0][1]==player&&state[1][1]==player&&state[2][1]==player)||
    (state[0][2]==player&&state[1][2]==player&&state[2][2]==player)||
    (state[1][0]==player&&state[1][1]==player&&state[1][2]==player)||
    (state[2][0]==player&&state[2][1]==player&&state[2][2]==player)||
    (state[0][2]==player&&state[1][1]==player&&state[2][0]==player);                   
    }
    
    public boolean isDraw(char[][] state, char player){
    available.clear();
    available=emptySpace(state);
    return endGame(state, player)==false&&available.isEmpty();
    }
    
    public int evalFunc(char[][] state){
    // evaluation function that assigns one point for owning a square, and minus one point for the opponent owning a square.
    // the code also awards 10 points for being able to produce two connecting squares, and minus 10 points for if the opponent has two connecting squares.
    int sum=0;
    for(int row=0; row<3; row++){
        for(int col=0;col<3;col++){
            if(state[col][row]==player1){sum=sum+1;}
            if(state[col][row]==player2){sum=sum-1;}
           }
       }
    for(int row=0; row<3; row++){
        if(state[0][row]==state[1][row]&&state[0][row]==player1){sum=sum+10;}
        if(state[0][row]==state[1][row]&&state[0][row]==player2){sum=sum-10;}
        
        if(state[2][row]==state[1][row]&&state[2][row]==player1){sum=sum+10;}
        if(state[2][row]==state[1][row]&&state[2][row]==player2){sum=sum-10;}
        }
    
    for(int col=0; col<3; col++){
        if(state[col][0]==state[col][1]&&state[col][0]==player1){sum=sum+10;}
        if(state[col][0]==state[col][1]&&state[col][0]==player2){sum=sum-10;}
        
        if(state[col][2]==state[col][1]&&state[col][2]==player1){sum=sum+10;}
        if(state[col][2]==state[col][1]&&state[col][2]==player2){sum=sum-10;}
        }
    for(int row=0; row<2; row++){
        if(state[0][row]==state[1][row+1]&&state[0][row]==player1){sum=sum+10;}
        if(state[0][row]==state[1][row+1]&&state[0][row]==player2){sum=sum-10;}
    
        if(state[2][row]==state[1][row+1]&&state[2][row]==player1){sum=sum+10;}
        if(state[2][row]==state[1][row+1]&&state[2][row]==player2){sum=sum-10;}
    }
    
    for(int row=2; row>0; row--){
        if(state[0][row]==state[1][row-1]&&state[0][row]==player1){sum=sum+10;}
        if(state[0][row]==state[1][row-1]&&state[0][row]==player2){sum=sum-10;}
    
        if(state[2][row]==state[1][row-1]&&state[2][row]==player1){sum=sum+10;}
        if(state[2][row]==state[1][row-1]&&state[2][row]==player2){sum=sum-10;}
    }
    if(endGame(state,player1)==true){
         sum=sum+400;}
    if(endGame(state,player2)==true){
         sum=sum-400;}
        
    return sum;
    }
    
    public int evalFunc2(char [][] state){
        //code that checks if the player is one move off winning or needs to block the opponents move
        //checkes all three combinations of being one move off winning for all eight lines.
        int sum = 0 ;
        for(int row=0; row<3; row++){
        if(state[0][row]==state[1][row]&&state[2][row]=='f'&&state[0][row]==player1){sum=sum+100;}
        if(state[0][row]==state[1][row]&&state[0][row]==player2&&state[2][row]=='f'){sum=sum+40;}
        
        if(state[2][row]==state[1][row]&&state[0][row]=='f'&&state[2][row]==player1){sum=sum+100;}
        if(state[2][row]==state[1][row]&&state[2][row]==player2&&state[0][row]=='f'){sum=sum+40;}
        
        if(state[0][row]==state[2][row]&&state[1][row]=='f'&&state[2][row]==player1){sum=sum+100;}
        if(state[0][row]==state[2][row]&&state[2][row]==player2&&state[1][row]=='f'){sum=sum+40;}
        }
    
    for(int col=0; col<3; col++){
        if(state[col][0]==state[col][1]&&state[col][2]=='f'&&state[col][0]==player1){sum=sum+100;}
        if(state[col][0]==state[col][1]&&state[col][0]==player2&&state[col][2]=='f'){sum=sum+40;}
        
        if(state[col][2]==state[col][1]&&state[col][0]=='f'&&state[col][0]==player1){sum=sum+100;}
        if(state[col][2]==state[col][1]&&state[col][2]==player2&&state[col][0]=='f'){sum=sum+40;}
        
        if(state[col][2]==state[col][0]&&state[col][1]=='f'&&state[col][0]==player1){sum=sum+100;}
        if(state[col][2]==state[col][0]&&state[col][0]==player2&&state[col][1]=='f'){sum=sum+40;}
        }
    
        if(state[0][0]==state[1][1]&&state[2][2]=='f'&&state[0][0]==player1){sum=sum+100;}
        if(state[0][0]==state[1][1]&&state[2][2]==player2){sum=sum+40;}
    
        if(state[2][2]==state[1][1]&&state[0][0]=='f'&&state[2][2]==player1){sum=sum+100;}
        if(state[2][2]==state[1][1]&&state[2][2]==player2&&state[0][0]=='f'){sum=sum+40;}
    
        if(state[0][2]==state[1][1]&&state[2][0]=='f'&&state[0][2]==player1){sum=sum+100;}
        if(state[0][2]==state[1][1]&&state[0][2]==player2&&state[2][0]=='f'){sum=sum+40;}
    
        if(state[2][0]==state[1][1]&&state[0][2]=='f'&&state[2][0]==player1){sum=sum+100;}
        if(state[2][0]==state[1][1]&&state[0][2]==player2&&state[0][2]=='f'){sum=sum+40;}
        
        //create an array for this that loops the coordinates in a circle this block of code checks every main fork possible
        //and assess's whether or not the opponent or player can make a fork.
        char[] fork = new char[4];
         fork[0] = state[0][0];
         fork[1] = state[0][2];
         fork[2] = state[2][2];
         fork[3] = state[2][0];
         for(int i=0; i<4; i++){
            if(i==3){
                if(fork[i]==fork[0]&&state[1][1]=='f'&&fork[i]==player1){sum=sum+25;}
                if(fork[i]==state[1][1]&&fork[0]=='f'&&fork[i]==player1){sum=sum+25;}
                if(state[1][1]==fork[0]&&fork[i]=='f'&&fork[0]==player1){sum=sum+25;}
                if(fork[i]==fork[0]&&state[1][1]=='f'&&fork[i]==player2){sum=sum+20;}
                if(fork[i]==state[1][1]&&fork[0]=='f'&&fork[i]==player2){sum=sum+20;}
                if(state[1][1]==fork[0]&&fork[i]=='f'&&fork[0]==player2){sum=sum+20;}
            }
            else if(fork[i]==fork[i+1]&&state[1][1]=='f'&&fork[i]==player1){sum=sum+25;}
            else if(state[1][1]==fork[i+1]&&fork[i]=='f'&&fork[i+1]==player1){sum=sum+25;}
            else if(state[1][1]==fork[i]&&fork[i+1]=='f'&&fork[i]==player1){sum=sum+25;}
            else if(fork[i]==fork[i+1]&&state[1][1]=='f'&&fork[i]==player2){sum=sum+20;}
            else if(state[1][1]==fork[i+1]&&fork[i]=='f'&&fork[i+1]==player2){sum=sum+20;}
            else if(state[1][1]==fork[i]&&fork[i+1]=='f'&&fork[i]==player2){sum=sum+20;}
         
         }
         
         //place in a position that will allow you to win the most possible ways, 4 ways for middle square 3 ways for corner squares and 2 ways for middle row and column squares
         if(state[1][1]==player1){sum=sum+10;}
         for(int i=0; i<4; i++){
         if(fork[i]==player1){sum=sum+5;}
         
         }

        if(endGame(state,player1)==true){
         sum=sum+400;}
        if(endGame(state,player2)==true){
         sum=sum-400;}
        
    return sum;
    }
    
    public char[][] getCurrBoard() {
        return currBoard;
    }

    /**
     * @param currBoard the currBoard to set
     */
    public void setCurrBoard(char[][] currBoard) {
        this.currBoard = currBoard;
    }
    
    public char[][] result(char[][] s, String action, char player){
    s[Character.getNumericValue(action.charAt(0))][Character.getNumericValue(action.charAt(1))]=player;
    return s;
    }
    
    public char[][] initialiseBoard(){
        for(int row=0; row<3; row++){
        for(int col=0;col<3;col++){
           currBoard[col][row]='f';}
           }
        return currBoard;
       }
 }

