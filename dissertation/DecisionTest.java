/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dissertation;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Chris Cullen
 */
public class DecisionTest {
    
    public DecisionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of emptySpace method, of class Decision.
     */
    @Test
    public void testEmptySpace() {
        System.out.println("emptySpace");
        char[][] state = new char[3][3];
        Decision instance = new Decision();
        state= instance.initialiseBoard();
        state[0][1]='X';
        state[0][2]='O';
        state[1][0]='O';
        state[2][0]='O';
        state[2][1]='X';
        state[2][2]='X';
        instance.emptySpace(state);
        System.out.println(instance.available);
        state[1][1]='X';
        instance.available.clear();
        instance.emptySpace(state);
        System.out.println(instance.available);  
    }

    /**
     * Test of alphaBetaPrune method, of class Decision.
     */
    @Test
    public void testAlphaBetaPrune() {
        System.out.println("alphaBetaPrune");
        Decision instance = new Decision();
        char[][] state = new char[3][3];
        char player2 ='O';
        char player1 ='X';
         
        state= instance.initialiseBoard();
        state[0][0]='O';
        state[0][1]='O';
        state[0][2]='X';
        state[1][0]='X';
        state[1][1]='X';
        state[2][0]='O';
        state[2][1]='O';
        state[2][2]='X';
        instance.setCurrBoard(state);
        instance.alphaBetaPrune(state,player1,3);
        System.out.println(instance.bestMaxMove.getPosition());
        System.out.println(instance.available);
        System.out.println(instance.bestMinMove.getPosition());
    }

@Test
    public void testAlphaBetaPrune2() {
        System.out.println("alphaBetaPrune2");
        Decision instance = new Decision();
        char[][] state = new char[3][3];
        char player2 ='O';
        char player1 ='X';
        Move bestMove= new Move();
        state= instance.initialiseBoard();
        state[0][0]='O';
        state[0][1]='O';
        state[0][2]='X';
        state[1][0]='X';
        state[1][1]='X';
        state[2][0]='O';
        state[2][1]='O';
        state[2][2]='X';
        state[1][2]='X';
        instance.setCurrBoard(state);
        instance.alphaBetaPrune(state,player1,3);
        System.out.println(instance.bestMaxMove.getPosition());
        System.out.println(instance.bestMaxMove.getScore());
        System.out.println(instance.available);
        System.out.println(instance.bestMinMove.getPosition());
        
    }
    
    @Test
    public void testAlphaBetaPrune3() {
        System.out.println("alphaBetaPrune3");
        Decision instance = new Decision();
        char[][] state = new char[3][3];
        char player2 ='O';
        char player1 ='X';
        Move bestMove= new Move();
        state= instance.initialiseBoard();
        state[0][1]='X';
        state[0][2]='O';
        state[1][0]='O';
        state[2][0]='O';
        state[2][1]='X';
        state[2][2]='X';
        
        instance.setCurrBoard(state);
        instance.alphaBetaPrune(state,player1,3);
        System.out.println(instance.available); 
    }
@Test
    public void testAlphaBetaPrune4() {
        System.out.println("alphaBetaPrune4");
        Decision instance = new Decision();
        char[][] state = new char[3][3];
        char player2 ='O';
        char player1 ='X';
        Move bestMove= new Move();
        state= instance.initialiseBoard();
        state[0][1]='X';
        state[2][0]='O';
        instance.setCurrBoard(state);
        instance.alphaBetaPrune(state,player1,3);
        System.out.println(instance.bestMaxMove.getScore());
        System.out.println(instance.available);
        
    }
    
    
     @Test
    public void test2AlphaBetaPrune() {
        System.out.println("alphaBetaPruneEVAL2");
        Decision instance = new Decision();
        char[][] state = new char[3][3];
        char player2 ='O';
        char player1 ='X';
         
        state= instance.initialiseBoard();
        state[0][0]='O';
        state[0][1]='O';
        state[0][2]='X';
        state[1][0]='X';
        state[1][1]='X';
        state[2][0]='O';
        state[2][1]='O';
        state[2][2]='X';
        instance.setCurrBoard(state);
        instance.alphaBetaPrune(state,player1,2);
        System.out.println(instance.bestMaxMove.getPosition());
        System.out.println(instance.available);
        System.out.println(instance.bestMinMove.getPosition());
    }

@Test
    public void test2AlphaBetaPrune2() {
        System.out.println("alphaBetaPrune2EVAL2");
        Decision instance = new Decision();
        char[][] state = new char[3][3];
        char player2 ='O';
        char player1 ='X';
        Move bestMove= new Move();
        state= instance.initialiseBoard();
        state[0][0]='O';
        state[0][1]='O';
        state[0][2]='X';
        state[1][0]='X';
        state[1][1]='X';
        state[2][0]='O';
        state[2][1]='O';
        state[2][2]='X';
        state[1][2]='X';
        instance.setCurrBoard(state);
        instance.alphaBetaPrune(state,player1,2);
        System.out.println(instance.bestMaxMove.getPosition());
        System.out.println(instance.bestMaxMove.getScore());
        System.out.println(instance.available);
        System.out.println(instance.bestMinMove.getPosition());
        
    }
    
    @Test
    public void test2AlphaBetaPrune3() {
        System.out.println("alphaBetaPrune3EVAL2");
        Decision instance = new Decision();
        char[][] state = new char[3][3];
        char player2 ='O';
        char player1 ='X';
        Move bestMove= new Move();
        state= instance.initialiseBoard();
        state[0][1]='X';
        state[0][2]='O';
        state[1][0]='O';
        state[2][0]='O';
        state[2][1]='X';
        state[2][2]='X';
        
        instance.setCurrBoard(state);
        instance.alphaBetaPrune(state,player1,2);
        System.out.println(instance.available); 
    }
@Test
    public void test2AlphaBetaPrune4() {
        System.out.println("alphaBetaPrune4EVAL2");
        Decision instance = new Decision();
        char[][] state = new char[3][3];
        char player2 ='O';
        char player1 ='X';
        Move bestMove= new Move();
        state= instance.initialiseBoard();
        state[0][1]='X';
        state[2][0]='O';
        instance.setCurrBoard(state);
        instance.alphaBetaPrune(state,player1,2);
        System.out.println(instance.bestMaxMove.getScore());
        System.out.println(instance.available);
        
    }
    
    /**
     * Test of maxValue method, of class Decision.
     */
    @Test
    public void testMaxValue() {
        System.out.println("maxValue");
        char[][] state = null;
        int a = 0;
        int b = 0;
        int depth = 0;
        Decision instance = new Decision();
        int expResult = 0;
        int result = instance.maxValue(state, a, b, depth);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of minValue method, of class Decision.
     */
    @Test
    public void testMinValue() {
        System.out.println("minValue");
        char[][] state = null;
        int a = 0;
        int b = 0;
        int depth = 0;
        Decision instance = new Decision();
        int expResult = 0;
        int result = instance.minValue(state, a, b, depth);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of endGame method, of class Decision.
     */
    @Test
    public void testEndGame() {
        System.out.println("endGame");
        Decision instance = new Decision();
        char[][] state = new char[3][3];
        char player2 ='O';
        char player1 ='X';
        Move bestMove= new Move();
        state= instance.initialiseBoard();
        state[0][0]='O';
        state[0][1]='O';
        state[0][2]='X';
        state[1][0]='X';
        state[1][1]='X';
        state[2][0]='O';
        state[2][1]='O';
        state[2][2]='X';
        state[1][2]='X';
        instance.setCurrBoard(state);
        System.out.println(instance.endGame(instance.currBoard, instance.player1));
    }
    
    @Test
    public void testEndGame2() {
        System.out.println("endGame2");
        Decision instance = new Decision();
        char[][] state = new char[3][3];
        char player2 ='O';
        char player1 ='X';
        Move bestMove= new Move();
        state= instance.initialiseBoard();
        state[0][0]='O';
        state[0][1]='X';
        state[0][2]='X';
        state[1][0]='X';
        state[1][1]='X';
        state[2][1]='O';
        state[2][0]='O';
        state[2][2]='X';
        state[1][2]='O';
        instance.setCurrBoard(state);
        System.out.println(instance.endGame(instance.currBoard, instance.player1));
    }
    
    @Test
    public void testEndGame3() {
        System.out.println("endGame3");
        Decision instance = new Decision();
        char[][] state = new char[3][3];
        char player2 ='O';
        char player1 ='X';
        Move bestMove= new Move();
        state= instance.initialiseBoard();
        state[0][0]='X';
        state[0][1]='O';
        state[0][2]='X';
        state[1][0]='X';
        state[1][1]='X';
        state[2][1]='X';
        state[2][0]='O';
        state[2][2]='O';
        state[1][2]='O';
        instance.setCurrBoard(state);
        System.out.println(instance.endGame(instance.currBoard, instance.player2));
        
    }
    @Test
    public void testEndGame4() {
        System.out.println("endGame4");
        Decision instance = new Decision();
        char[][] state = new char[3][3];
        char player2 ='O';
        char player1 ='X';
        Move bestMove= new Move();
        state= instance.initialiseBoard();
        state[0][0]='O';
        state[0][1]='X';
        state[0][2]='X';
        state[1][0]='X';
        state[1][1]='O';
        state[2][1]='O';
        state[2][0]='X';
        state[2][2]='O';
        state[1][2]='X';
        instance.setCurrBoard(state);
        System.out.println(instance.endGame(instance.currBoard, instance.player2));
    }
    
    @Test
    public void testEndGame5() {
        System.out.println("endGame5");
        Decision instance = new Decision();
        char[][] state = new char[3][3];
        char player2 ='O';
        char player1 ='X';
        Move bestMove= new Move();
        state= instance.initialiseBoard();
        state[0][0]='O';
        state[0][2]='X';
        state[1][1]='O';
        state[2][0]='X';
        state[2][2]='O';
        state[1][2]='X';
        instance.setCurrBoard(state);
        System.out.println(instance.endGame(instance.currBoard, instance.player2)); 
    }
    
    @Test
    public void testEndGame6() {
        System.out.println("endGame6");
        Decision instance = new Decision();
        char[][] state = new char[3][3];
        char player2 ='O';
        char player1 ='X';
        Move bestMove= new Move();
        state= instance.initialiseBoard();
        state[0][0]='O';
        state[0][2]='X';
        state[1][1]='O';
        state[2][0]='X';
        state[1][2]='O';
        state[2][2]='X';
        instance.setCurrBoard(state);
        System.out.println(instance.endGame(instance.currBoard, instance.player2));
    }

    /**
     * Test of evalFunc method, of class Decision.
     */
    @Test
    public void testEvalFunc() {
        System.out.println("evalFunc");
        char[][] state = null;
        Decision instance = new Decision();
        instance.evalFunc(state);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrBoard method, of class Decision.
     */
    @Test
    public void testGetCurrBoard() {
        System.out.println("getCurrBoard");
        Decision instance = new Decision();
        char[][] expResult = null;
        char[][] result = instance.getCurrBoard();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrBoard method, of class Decision.
     */
    @Test
    public void testSetCurrBoard() {
        System.out.println("setCurrBoard");
        Decision instance = new Decision();
        char[][] state = new char[3][3];
        char player2 ='O';
        char player1 ='X';
         
        state= instance.initialiseBoard();
        state[0][0]='X';
        state[0][1]='O';
        state[0][2]='X';
        state[1][1]='X';
        state[2][0]='O';
        state[2][1]='O';
        instance.setCurrBoard(state);
        for(int row=0; row<3;row++){
            for(int col=0; col<3; col++){
            System.out.println(instance.currBoard[col][row]);
            }
        
        }
    }

 
    /**
     * Test of result method, of class Decision.
     */
    @Test
    public void testResult() {
        System.out.println("result test");
        Decision instance= new Decision();
         char[][] state = new char[3][3];
        char player2 ='O';
        char player1 ='X';
         
        state= instance.initialiseBoard();
        state[0][0]='X';
        state[0][1]='O';
        state[2][0]='X';
        state[2][1]='O';
        state[2][2]='X';
        instance.setCurrBoard(state);
        for(int row=0; row<3;row++){
            for(int col=0; col<3; col++){
            System.out.println(instance.currBoard[col][row]);
            }
        }
        System.out.println(instance.emptySpace(state));
        instance.result(state, "11", player1);
        for(int row=0; row<3;row++){
            for(int col=0; col<3; col++){
            System.out.println(instance.currBoard[col][row]);
            }
        }
        instance.available.clear();
        System.out.println(instance.emptySpace(state));
    }

    /**
     * Test of initialiseBoard method, of class Decision.
     */
    @Test
    public void testInitialiseBoard() {
        System.out.println("initialiseBoard");
        Decision instance = new Decision();
        instance.initialiseBoard();
        for(int row=0; row<3;row++){
            for(int col=0; col<3; col++){
            System.out.println(instance.currBoard[col][row]);
            }
        
        }
    }
    
    @Test
    public void testSecondEvalFunc() {
        System.out.println("TestSecondEvalFunc");
        Decision instance = new Decision();
        char[][] state = new char[3][3];
        char player2 ='O';
        char player1 ='X';
         
        state= instance.initialiseBoard();
        state[0][0]='O';
        state[0][1]='O';
        state[0][2]='X';
        state[1][0]='X';
        state[1][1]='X';
        state[2][0]='O';
        state[2][1]='O';
        state[2][2]='X';
        instance.setCurrBoard(state);
        System.out.println(instance.evalFunc2(state));
        //System.out.println(instance.available);
        //System.out.println(instance.bestMinMove2.getPosition());
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
    @Test
    public void winningState1Eval1() {
        System.out.println("Test Winning state1EVAL1");
        Decision instance = new Decision();
        char[][] state = new char[3][3];
        char player2 ='O';
        char player1 ='X';
         
        state= instance.initialiseBoard();
        state[0][0]='O';
        state[0][1]='O';
        state[0][2]='X';
        state[1][0]='X';
        state[1][1]='X';
        state[1][2]='X';
        state[2][0]='X';
        state[2][1]='O';
        state[2][2]='O';
        instance.setCurrBoard(state);
        System.out.println(instance.evalFunc(state));
        
    }
    
   @Test
    public void winningState2Eval1() {
        System.out.println("Test Winning state2EVAL1");
        Decision instance = new Decision();
        char[][] state = new char[3][3];
        char player2 ='O';
        char player1 ='X';
         
        state= instance.initialiseBoard();
        state[0][0]='X';
        state[0][1]='X';
        state[0][2]='O';
        state[1][0]='X';
        state[1][1]='X';
        state[1][2]='O';
        state[2][0]='O';
        state[2][1]='O';
        state[2][2]='X';
        instance.setCurrBoard(state);
        System.out.println(instance.evalFunc(state));    
    }
     @Test
    public void winningState3Eval1() {
        System.out.println("Test state3 Draw EVAL1");
        Decision instance = new Decision();
        char[][] state = new char[3][3];
        char player2 ='O';
        char player1 ='X';
         
        state= instance.initialiseBoard();
        state[0][0]='O';
        state[0][1]='X';
        state[0][2]='X';
        state[1][0]='X';
        state[1][1]='O';
        state[1][2]='O';
        state[2][0]='X';
        state[2][1]='O';
        state[2][2]='X';
        instance.setCurrBoard(state);
        System.out.println(instance.evalFunc(state));   
    }
     @Test
    public void winningState4Eval1() {
        System.out.println("Test state4  Draw2 EVAL1");
        Decision instance = new Decision();
        char[][] state = new char[3][3];
        char player2 ='O';
        char player1 ='X';
         
        state= instance.initialiseBoard();
        state[0][0]='O';
        state[0][1]='O';
        state[0][2]='X';
        state[1][0]='X';
        state[1][1]='X';
        state[1][2]='O';
        state[2][0]='O';
        state[2][1]='X';
        state[2][2]='X';
        instance.setCurrBoard(state);
        System.out.println(instance.evalFunc(state));   
    }
    @Test
    public void winningState1Eval2() {
        System.out.println("Test Winning state1EVAL2");
        Decision instance = new Decision();
        char[][] state = new char[3][3];
        char player2 ='O';
        char player1 ='X';
         
        state= instance.initialiseBoard();
        state[0][0]='O';
        state[0][1]='O';
        state[0][2]='X';
        state[1][0]='X';
        state[1][1]='X';
        state[1][2]='X';
        state[2][0]='X';
        state[2][1]='O';
        state[2][2]='O';
        instance.setCurrBoard(state);
       
        System.out.println(instance.evalFunc2(state)); 
    }
    
   @Test
    public void winningState2Eval2() {
        System.out.println("Test Winning state2EVAL2");
        Decision instance = new Decision();
        char[][] state = new char[3][3];
        char player2 ='O';
        char player1 ='X';
         
        state= instance.initialiseBoard();
        state[0][0]='X';
        state[0][1]='X';
        state[0][2]='O';
        state[1][0]='X';
        state[1][1]='X';
        state[1][2]='O';
        state[2][0]='O';
        state[2][1]='O';
        state[2][2]='X';
        instance.setCurrBoard(state);
        System.out.println(instance.evalFunc2(state));
        
    }
     @Test
    public void winningState3Eval2() {
        System.out.println("Test state3 Draw EVAL2");
        Decision instance = new Decision();
        char[][] state = new char[3][3];
        char player2 ='O';
        char player1 ='X';
         
        state= instance.initialiseBoard();
        state[0][0]='O';
        state[0][1]='X';
        state[0][2]='X';
        state[1][0]='X';
        state[1][1]='O';
        state[1][2]='O';
        state[2][0]='X';
        state[2][1]='O';
        state[2][2]='X';
        instance.setCurrBoard(state);
        System.out.println(instance.evalFunc2(state));    
    }
     @Test
    public void winningState4Eval2() {
        System.out.println("Test state4  Draw2 EVAL2");
        Decision instance = new Decision();
        char[][] state = new char[3][3];
        char player2 ='O';
        char player1 ='X';
         
        state= instance.initialiseBoard();
        state[0][0]='O';
        state[0][1]='O';
        state[0][2]='X';
        state[1][0]='X';
        state[1][1]='X';
        state[1][2]='O';
        state[2][0]='O';
        state[2][1]='X';
        state[2][2]='X';
        instance.setCurrBoard(state);
        System.out.println(instance.evalFunc2(state));   
    }
     @Test
    public void Eval1fork() {
        System.out.println("EVAL1 fork board");
        Decision instance = new Decision();
        char[][] state = new char[3][3];
        char player2 ='O';
        char player1 ='X';
         
        state= instance.initialiseBoard();
        state[0][0]='X';
        state[0][1]='X';
        state[2][0]='X';
        state[1][0]='O';
        state[1][2]='O';
        state[2][2]='O';
  
        instance.setCurrBoard(state);
        System.out.println(instance.evalFunc(state));   
    }
    @Test
    public void turn3OfOwnGame() {
        System.out.println("Turn3 of game two to see how eval two values these positions");
        Decision instance = new Decision();
        char[][] state = new char[3][3];
        char player2 ='O';
        char player1 ='X';
         
        state= instance.initialiseBoard();
        state[0][0]='X';
        state[1][0]='X';
        state[2][2]='X';
        state[0][2]='O';
        state[1][2]='O';
        
        
        instance.setCurrBoard(state);
        System.out.println(instance.evalFunc2(state));
        // TODO review the generated test code and remove the default call to fail.
        
    }
    @Test
    public void turn4OfOwnGame() {
        System.out.println("Turn4 of game two to see how eval two values these positions");
        Decision instance = new Decision();
        char[][] state = new char[3][3];
        char player2 ='O';
        char player1 ='X';
         
        state= instance.initialiseBoard();
        state[0][0]='X';
        state[1][0]='X';
        state[2][2]='X';
        state[0][2]='O';
        state[1][2]='O';
        state[1][1]='O';
        
        
        instance.setCurrBoard(state);
        System.out.println(instance.evalFunc2(state));
        // TODO review the generated test code and remove the default call to fail.
        
    }
    @Test
    public void turn4ofgameWithWinPos() {
        System.out.println("Turn four of game two with winning pos to see eval");
        Decision instance = new Decision();
        char[][] state = new char[3][3];
        char player2 ='O';
        char player1 ='X';
         
        state= instance.initialiseBoard();
        state[0][0]='X';
        state[1][0]='X';
        state[2][2]='X';
        state[0][2]='O';
        state[1][2]='O';
        state[1][1]='O';
        state[2][0]='X';
        
        
        instance.setCurrBoard(state);
        System.out.println(instance.evalFunc2(state));
        // TODO review the generated test code and remove the default call to fail.
        
    }
     @Test
    public void turn4ofgameWithWinPos2() {
        System.out.println("Turn four of game two with winning pos to see eval");
        Decision instance = new Decision();
        char[][] state = new char[3][3];
        char player2 ='O';
        char player1 ='X';
         
        state= instance.initialiseBoard();
        state[0][0]='X';
        state[1][0]='X';
        state[2][2]='X';
        state[0][2]='O';
        state[1][2]='O';
        state[1][1]='O';
        state[2][0]='X';
        
        
        instance.setCurrBoard(state);
        System.out.println(instance.endGame(state, player1));
        System.out.println(instance.evalFunc(state));
        // TODO review the generated test code and remove the default call to fail.
        
    }
    @Test
    public void symmetricBoardEval1() {
        System.out.println("Symmetric Board eval function one");
        Decision instance = new Decision();
        char[][] state = new char[3][3];
        char player2 ='O';
        char player1 ='X';
         
        state= instance.initialiseBoard();
        state[0][0]='X';
        state[1][0]='X';
        state[0][2]='X';
        state[1][2]='O';
        state[2][2]='O';
        state[2][0]='O';        
        instance.setCurrBoard(state);
        
        System.out.println(instance.evalFunc(state)); 
    }
    @Test
    public void symmetricBoardEval2() {
        System.out.println("Symmetric Board eval function TWO");
        Decision instance = new Decision();
        char[][] state = new char[3][3];
        char player2 ='O';
        char player1 ='X';
         
        state= instance.initialiseBoard();
        state[0][0]='X';
        state[1][0]='X';
        state[0][2]='X';
        state[1][2]='O';
        state[2][2]='O';
        state[2][0]='O';

        instance.setCurrBoard(state);
        System.out.println(instance.evalFunc2(state));
    }
    @Test
    public void symmetricBoard2Eval1() {
        System.out.println("Symmetric Board2 eval function one");
        Decision instance = new Decision();
        char[][] state = new char[3][3];
        char player2 ='O';
        char player1 ='X';
         
        state= instance.initialiseBoard();
        state[0][0]='O';
        state[1][0]='X';
        state[2][0]='O';
        state[0][2]='X';
        state[1][2]='O';
        state[2][2]='X';
        
        instance.setCurrBoard(state);
        System.out.println(instance.evalFunc(state));  
    }
    @Test
    public void symmetricBoard2Eval2() {
        System.out.println("Symmetric Board2 eval function two");
        Decision instance = new Decision();
        char[][] state = new char[3][3];
        char player2 ='O';
        char player1 ='X';
         
        state= instance.initialiseBoard();
        state[0][0]='O';
        state[1][0]='X';
        state[2][0]='O';
        state[0][2]='X';
        state[1][2]='O';
        state[2][2]='X';
        
        
        instance.setCurrBoard(state);
        System.out.println(instance.evalFunc2(state));  
    }
     @Test
    public void Eval2Fork() {
        System.out.println("EVAL2 fork board");
        Decision instance = new Decision();
        char[][] state = new char[3][3];
        char player2 ='O';
        char player1 ='X';
         
        state= instance.initialiseBoard();
        state[0][0]='X';
        state[0][1]='X';
        state[2][0]='X';
        state[1][0]='O';
        state[1][2]='O';
        state[2][2]='O';
        instance.setCurrBoard(state);
        System.out.println(instance.evalFunc2(state));
      
    }
    
    @Test
    public void PlayGameTurn1() {
        System.out.println("Turn1 EVAL1X turn");
        Decision instance = new Decision();
        char[][] state = new char[3][3];
        char player2 ='O';
        char player1 ='X';
         
        state= instance.initialiseBoard();
        
        instance.setCurrBoard(state);
        instance.alphaBetaPrune(state, player1,3);
        
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test
    public void PlayGameTurn2() {
        System.out.println("Turn2 EVAL2O turn");
        Decision instance = new Decision();
        char[][] state = new char[3][3];
        char player2 ='O';
        char player1 ='X';
        state= instance.initialiseBoard();
        
        state[2][2]='O';
        instance.setCurrBoard(state);
        instance.alphaBetaPrune(state, player1,2);
        
        // TODO review the generated test code and remove the default call to fail.
    }
    @Test
    public void PlayGameTurn3() {
        System.out.println("Turn3 EVAL1X turn");
        Decision instance = new Decision();
        char[][] state = new char[3][3];
        char player2 ='O';
        char player1 ='X';
        state= instance.initialiseBoard();
        
        state[2][2]='X';
        state[0][2]='O';
        instance.setCurrBoard(state);
        instance.alphaBetaPrune(state, player1,3);
        
        // TODO review the generated test code and remove the default call to fail. 
    }
     @Test
    public void PlayGameTurn4() {
        System.out.println("Turn4 EVAL2O turn");
        Decision instance = new Decision();
        char[][] state = new char[3][3];
        char player2 ='O';
        char player1 ='X';
        state= instance.initialiseBoard();
        
        state[2][2]='O';
        state[0][2]='X';
        state[1][2]='O';
        instance.setCurrBoard(state);
        instance.alphaBetaPrune(state, player1,2);
        
        // TODO review the generated test code and remove the default call to fail. 
    }
     @Test
    public void PlayGameTurn5() {
        System.out.println("Turn5 EVAL1X turn");
        Decision instance = new Decision();
        char[][] state = new char[3][3];
        char player2 ='O';
        char player1 ='X';
        state= instance.initialiseBoard();
        
        state[2][2]='X';
        state[0][2]='O';
        state[1][2]='X';
        state[1][1]='O';
        instance.setCurrBoard(state);
        instance.alphaBetaPrune(state, player1,3);
        
        // TODO review the generated test code and remove the default call to fail. 
    }
    @Test
    public void PlayGameTurn6() {
        System.out.println("Turn6 EVAL2O turn");
        Decision instance = new Decision();
        char[][] state = new char[3][3];
        char player2 ='O';
        char player1 ='X';
        state= instance.initialiseBoard();
        
        state[2][2]='O';
        state[0][2]='X';
        state[1][2]='O';
        state[1][1]='X';
        state[2][1]='O';
        instance.setCurrBoard(state);
        instance.alphaBetaPrune(state, player1,2);
        
        // TODO review the generated test code and remove the default call to fail. 
    }
    @Test
    public void PlayGame2Turn1() {
        System.out.println("Turn1  SECOND GAME EVAL2X turn");
        Decision instance = new Decision();
        char[][] state = new char[3][3];
        char player2 ='O';
        char player1 ='X';
         
        state= instance.initialiseBoard();
        
        instance.setCurrBoard(state);
        instance.alphaBetaPrune(state, player1,2);
        
        // TODO review the generated test code and remove the default call to fail.
    }
    @Test
    public void PlayGame2Turn2() {
        System.out.println("Turn2  SECOND GAME EVAL1O turn");
        Decision instance = new Decision();
        char[][] state = new char[3][3];
        char player2 ='O';
        char player1 ='X';
        state= instance.initialiseBoard();
        
        state[1][1]='O';
        instance.setCurrBoard(state);
        instance.alphaBetaPrune(state, player1,3);
        
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test
    public void PlayGame2Turn3() {
        System.out.println("Turn3  SECOND GAME EVAL2X turn");
        Decision instance = new Decision();
        char[][] state = new char[3][3];
        char player2 ='O';
        char player1 ='X';
        state= instance.initialiseBoard();
        
        state[1][1]='X';
        state[2][2]='O';
        instance.setCurrBoard(state);
        instance.alphaBetaPrune(state, player1,2);
        
        // TODO review the generated test code and remove the default call to fail.
    }
    
     @Test
    public void PlayGame2Turn4() {
        System.out.println("Turn4  SECOND GAME EVAL1O turn");
        Decision instance = new Decision();
        char[][] state = new char[3][3];
        char player2 ='O';
        char player1 ='X';
        state= instance.initialiseBoard();
        
        state[1][1]='O';
        state[2][2]='X';
        state[0][2]='O';
        instance.setCurrBoard(state);
        instance.alphaBetaPrune(state, player1,3);
        
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test
    public void PlayGame2Turn5() {
        System.out.println("Turn5  SECOND GAME EVAL2X turn");
        Decision instance = new Decision();
        char[][] state = new char[3][3];
        char player2 ='O';
        char player1 ='X';
        state= instance.initialiseBoard();
        
        state[1][1]='X';
        state[2][2]='O';
        state[0][2]='X';
        state[1][2]='O';
        instance.setCurrBoard(state);
        instance.alphaBetaPrune(state, player1 ,2);
        
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test
    public void testDraw1() {
        System.out.println("Test isDraw1");
        Decision instance = new Decision();
        char[][] state = new char[3][3];
        char player2 ='O';
        char player1 ='X';
         
        state= instance.initialiseBoard();
        state[0][0]='O';
        state[0][1]='X';
        state[0][2]='X';
        state[1][0]='X';
        state[1][1]='O';
        state[1][2]='O';
        state[2][0]='X';
        state[2][1]='O';
        state[2][2]='X';
        instance.setCurrBoard(state);
        System.out.println(instance.isDraw(state, player1));  
    }
    
    @Test
    public void testDraw2() {
        System.out.println("Test isDraw case2");
        Decision instance = new Decision();
        char[][] state = new char[3][3];
        char player2 ='O';
        char player1 ='X';
         
        state= instance.initialiseBoard();
        state[0][0]='X';
        state[0][1]='X';
        state[0][2]='X';
        state[1][0]='X';
        state[1][1]='O';
        state[1][2]='O';
        state[2][0]='O';
        state[2][1]='O';
        state[2][2]='X';
        instance.setCurrBoard(state);
        System.out.println(instance.isDraw(state, player1));   
    }
    
    @Test
    public void testDraw3() {
        System.out.println("Test isDraw case3");
        Decision instance = new Decision();
        char[][] state = new char[3][3];
        char player2 ='O';
        char player1 ='X';
         
        state= instance.initialiseBoard();
        state[0][0]='X';
        state[0][2]='O';
        state[1][0]='O';
        state[1][2]='X';
        state[2][1]='O';
        state[2][2]='X';
        instance.setCurrBoard(state);
        System.out.println(instance.isDraw(state, player1));
        
    }
    
    @Test
    public void testDraw4() {
        System.out.println("Test isDraw case4");
        Decision instance = new Decision();
        char[][] state = new char[3][3];
        char player2 ='O';
        char player1 ='X';
         
        state= instance.initialiseBoard();
        state[0][0]='X';
        state[1][2]='O';
        state[1][1]='X';
        state[1][0]='O';
        state[2][2]='X';
        instance.setCurrBoard(state);
        System.out.println(instance.isDraw(state, player1)); 
    }
        // TODO review the generated test code and remove the default call to fail.
    /*
    @Test
    public void what() {
        System.out.println("Broski what ?");
        Decision instance = new Decision();
        char[][] state = new char[3][3];
        char player2 ='O';
        char player1 ='X';
        state= instance.initialiseBoard();
        
        state[1][2]='O';
        state[2][2]='X';
        state[0][2]='O';
        state[2][1]='X';
        state[1][1]='O';
        state[1][0]='X';
        instance.setCurrBoard(state);
        System.out.println(instance.evalFunc(state));
        
        // TODO review the generated test code and remove the default call to fail.
    }
    @Test
    public void PlayGame2Turn6Take2() {
        System.out.println("Second edition of wrong value");
        Decision instance = new Decision();
        char[][] state = new char[3][3];
        char player2 ='O';
        char player1 ='X';
        state= instance.initialiseBoard();
        
        state[1][2]='O';
        state[2][2]='X';
        state[0][2]='O';
        state[2][1]='X';
        state[1][1]='O';
        state[1][0]='X';
        instance.setCurrBoard(state);
        System.out.println(instance.evalFunc(state));
        
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test
    public void PlayGame2Turn6Take3() {
        System.out.println("Second edition of wrong value 2");
        Decision instance = new Decision();
        char[][] state = new char[3][3];
        char player2 ='O';
        char player1 ='X';
        state= instance.initialiseBoard();
        
        state[2][0]='O';
        state[1][1]='O';
        state[0][1]='X';
        state[0][0]='X';
        state[1][0]='O';
        instance.setCurrBoard(state);
       instance.alphaBetaPrune(state, player1);
        
        // TODO review the generated test code and remove the default call to fail.
    }*/
}
