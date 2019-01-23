package rubik;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Moves {
	
	public static String[][][] solved={{{"F1","F2","F3"},{"F4","F5","F6"},{"F7","F8","F9"}},
            {{"S1","S2","S3"},{"S4","S5","S6"},{"S7","S8","S9"}},
            {{"B1","B2","B3"},{"B4","B5","B6"},{"B7","B8","B9"}}};
	
	public static String[][][] rubik={{{"F1","F2","F3"},{"F4","F5","F6"},{"F7","F8","F9"}},
            {{"S1","S2","S3"},{"S4","S5","S6"},{"S7","S8","S9"}},
            {{"B1","B2","B3"},{"B4","B5","B6"},{"B7","B8","B9"}}};
	
	public static String[][][] rubikOld={{{"F1","F2","F3"},{"F4","F5","F6"},{"F7","F8","F9"}},
            {{"S1","S2","S3"},{"S4","S5","S6"},{"S7","S8","S9"}},
            {{"B1","B2","B3"},{"B4","B5","B6"},{"B7","B8","B9"}}}; //
	
	public static String move = ""; // rotacija koja treba da se animira
	public static Boolean moveFlag = false; // true ako je potrebno animirati neku rotaciju, u suprotnom false
	public static Boolean moveFlagOld = false;
	
	public static Boolean isScrambling = false; // za sprecavanje mesanja kocke ako je mesanje vec u toku
	
	public static int movesCount = 0;
	public static Boolean newGame = false; // za startovanje tajmera i  brojaca poteza
	public static Boolean gameInProgressOld = false;
	public static Boolean gameInProgress = false;
	
	public Moves() {
		// TODO Auto-generated constructor stub
	}
	
	public static void turn(String move){ 
        if(move.equals("L"))
        {
        	String F1 = rubik[0][0][0];
    		String F4 = rubik[0][1][0];
    		String F7 = rubik[0][2][0];
    		String S7 = rubik[1][2][0];
    		
            rubik[0][0][0] = rubik[2][0][0];
            rubik[0][1][0] = rubik[1][0][0];
            rubik[0][2][0] = F1;
            
            rubik[1][0][0] = rubik[2][1][0];
            rubik[1][2][0] = F4;
            
            rubik[2][0][0] = rubik[2][2][0];
            rubik[2][1][0] = S7;
            rubik[2][2][0] = F7;
        }
        else if(move.equals("Li"))
        {
        	String F1 = rubik[0][0][0];
    		String F4 = rubik[0][1][0];
    		String S1 = rubik[1][0][0];
    		String B1 = rubik[2][0][0];
    		
            rubik[0][0][0] = rubik[0][2][0];
            rubik[0][1][0] = rubik[1][2][0];
            rubik[0][2][0] = rubik[2][2][0];
            
            rubik[1][0][0] = F4;
            rubik[1][2][0] = rubik[2][1][0];
            
            rubik[2][0][0] = F1;
            rubik[2][1][0] = S1;
            rubik[2][2][0] = B1;
        }
        else if(move.equals("R"))
        {
        	String F3 = rubik[0][0][2];
        	String F6 = rubik[0][1][2];
        	String S3 = rubik[1][0][2];
        	String B3 = rubik[2][0][2];
        	
        	rubik[0][0][2] = rubik[0][2][2];
        	rubik[0][1][2] = rubik[1][2][2];
        	rubik[0][2][2] = rubik[2][2][2];
        	
        	rubik[1][0][2] = F6;
        	rubik[1][2][2] = rubik[2][1][2];
        	
        	rubik[2][0][2] = F3;
        	rubik[2][1][2] = S3;
        	rubik[2][2][2] = B3;
        }
        else if(move.equals("Ri"))
        {
        	String F3 = rubik[0][0][2];
        	String F6 = rubik[0][1][2];
            String F9 = rubik[0][2][2];
            String S9 = rubik[1][2][2];
            
            rubik[0][0][2] = rubik[2][0][2];
        	rubik[0][1][2] = rubik[1][0][2];
        	rubik[0][2][2] = F3;
        	
        	rubik[1][0][2] = rubik[2][1][2];
        	rubik[1][2][2] = F6;
        	
        	rubik[2][0][2] = rubik[2][2][2];
        	rubik[2][1][2] = S9;
        	rubik[2][2][2] = F9;
        }
        else if(move.equals("F"))
        {
        	String F1 = rubik[0][0][0];
        	String F2 = rubik[0][0][1];
            String F3 = rubik[0][0][2];
            String F6 = rubik[0][1][2];
            
            rubik[0][0][0] = rubik[0][2][0];
        	rubik[0][0][1] = rubik[0][1][0];
        	rubik[0][0][2] = F1;
        	
        	rubik[0][1][0] = rubik[0][2][1];
        	rubik[0][1][2] = F2;
        	
        	rubik[0][2][0] = rubik[0][2][2];
        	rubik[0][2][1] = F6;
        	rubik[0][2][2] = F3;
        }
        else if(move.equals("Fi"))
        {
        	String F1 = rubik[0][0][0];
            String F2 = rubik[0][0][1];
            String F4 = rubik[0][1][0];
            String F7 = rubik[0][2][0];
            
            rubik[0][0][0] = rubik[0][0][2];
        	rubik[0][0][1] = rubik[0][1][2];
        	rubik[0][0][2] = rubik[0][2][2];
        	
        	rubik[0][1][0] = F2;
        	rubik[0][1][2] = rubik[0][2][1];
        	
        	rubik[0][2][0] = F1;
        	rubik[0][2][1] = F4;
        	rubik[0][2][2] = F7;
        }
        else if(move.equals("B"))
        {
        	String B1 = rubik[2][0][0];
            String B2 = rubik[2][0][1];
            String B4 = rubik[2][1][0];
            String B7 = rubik[2][2][0];
            
            rubik[2][0][0] = rubik[2][0][2];
        	rubik[2][0][1] = rubik[2][1][2];
        	rubik[2][0][2] = rubik[2][2][2];
        	
        	rubik[2][1][0] = B2;
        	rubik[2][1][2] = rubik[2][2][1];
        	
        	rubik[2][2][0] = B1;
        	rubik[2][2][1] = B4;
        	rubik[2][2][2] = B7;
        }
        else if(move.equals("Bi"))
        {
        	String B1 = rubik[2][0][0];
            String B2 = rubik[2][0][1];
            String B3 = rubik[2][0][2];
            String B6 = rubik[2][1][2];
            
            rubik[2][0][0] = rubik[2][2][0];
        	rubik[2][0][1] = rubik[2][1][0];
        	rubik[2][0][2] = B1;
        	
        	rubik[2][1][0] = rubik[2][2][1];
        	rubik[2][1][2] = B2;
        	
        	rubik[2][2][0] = rubik[2][2][2];
        	rubik[2][2][1] = B6;
        	rubik[2][2][2] = B3;
        }
        else if(move.equals("U"))
        {
        	String F1 = rubik[0][0][0];
            String F2 = rubik[0][0][1];
            String S1 = rubik[1][0][0];
            String B1 = rubik[2][0][0];
            
            rubik[0][0][0] = rubik[0][0][2];
        	rubik[0][0][1] = rubik[1][0][2];
        	rubik[0][0][2] = rubik[2][0][2];
        	
        	rubik[1][0][0] = F2;
        	rubik[1][0][2] = rubik[2][0][1];
        	
        	rubik[2][0][0] = F1;
        	rubik[2][0][1] = S1;
        	rubik[2][0][2] = B1;
        }
        else if(move.equals("Ui"))
        {
        	String F1 = rubik[0][0][0];
            String F2 = rubik[0][0][1];
            String F3 = rubik[0][0][2];
            String S3 = rubik[1][0][2];
            
            rubik[0][0][0] = rubik[2][0][0];
        	rubik[0][0][1] = rubik[1][0][0];
        	rubik[0][0][2] = F1;
        	
        	rubik[1][0][0] = rubik[2][0][1];
        	rubik[1][0][2] = F2;
        	
        	rubik[2][0][0] = rubik[2][0][2];
        	rubik[2][0][1] = S3;
        	rubik[2][0][2] = F3;
        }
        else if(move.equals("D"))
        {
        	String F7 = rubik[0][2][0];
            String F8 = rubik[0][2][1];
            String F9 = rubik[0][2][2];
            String S9 = rubik[1][2][2];
            
            rubik[0][2][0] = rubik[2][2][0];
        	rubik[0][2][1] = rubik[1][2][0];
        	rubik[0][2][2] = F7;
        	
        	rubik[1][2][0] = rubik[2][2][1];
        	rubik[1][2][2] = F8;
        	
        	rubik[2][2][0] = rubik[2][2][2];
        	rubik[2][2][1] = S9;
        	rubik[2][2][2] = F9;
        }
        else if(move.equals("Di"))
        {
        	String F7 = rubik[0][2][0];
            String F8 = rubik[0][2][1];
            String S7 = rubik[1][2][0];
            String B7 = rubik[2][2][0];
            
            rubik[0][2][0] = rubik[0][2][2];
        	rubik[0][2][1] = rubik[1][2][2];
        	rubik[0][2][2] = rubik[2][2][2];
        	
        	rubik[1][2][0] = F8;
        	rubik[1][2][2] = rubik[2][2][1];
        	
        	rubik[2][2][0] = F7;
        	rubik[2][2][1] = S7;
        	rubik[2][2][2] = B7;
        }
        
        movesCount++;
        if(isSolved())
        {
        	gameInProgressOld = gameInProgress;
        	gameInProgress = false;
        }
//        System.out.println("Solved = " + isSolved());
	}
	
	// funckcija za rotiranje cele kocke oko X, Y i Z ose
	public static void turnCube(String move){ 
        if(move.equals("X"))
        {
        	// rubik
        	String F1 = rubik[0][0][0];
    		String F2 = rubik[0][0][1];
    		String F3 = rubik[0][0][2];
    		String F4 = rubik[0][1][0];
    		String F5 = rubik[0][1][1];
    		String F6 = rubik[0][1][2];
    		String S1 = rubik[1][0][0];
    		String S2 = rubik[1][0][1];
    		String S3 = rubik[1][0][2];
    		String B1 = rubik[2][0][0];
    		String B2 = rubik[2][0][1];
    		String B3 = rubik[2][0][2];
    		
            rubik[0][0][0] = rubik[0][2][0];
            rubik[0][0][1] = rubik[0][2][1];
            rubik[0][0][2] = rubik[0][2][2];
            rubik[0][1][0] = rubik[1][2][0];
            rubik[0][1][1] = rubik[1][2][1];
            rubik[0][1][2] = rubik[1][2][2];
            rubik[0][2][0] = rubik[2][2][0];
            rubik[0][2][1] = rubik[2][2][1];
            rubik[0][2][2] = rubik[2][2][2];
            
            rubik[1][0][0] = F4;
            rubik[1][0][1] = F5;
            rubik[1][0][2] = F6;
            rubik[1][2][0] = rubik[2][1][0];
            rubik[1][2][1] = rubik[2][1][1];
            rubik[1][2][2] = rubik[2][1][2];
            
            rubik[2][0][0] = F1;
            rubik[2][0][1] = F2;
            rubik[2][0][2] = F3;
            rubik[2][1][0] = S1;
            rubik[2][1][1] = S2;
            rubik[2][1][2] = S3;
            rubik[2][2][0] = B1;
            rubik[2][2][1] = B2;
            rubik[2][2][2] = B3;
            
         // solved
        	F1 = solved[0][0][0];
    		F2 = solved[0][0][1];
    		F3 = solved[0][0][2];
    		F4 = solved[0][1][0];
    		F5 = solved[0][1][1];
    		F6 = solved[0][1][2];
    		S1 = solved[1][0][0];
    		S2 = solved[1][0][1];
    		S3 = solved[1][0][2];
    		B1 = solved[2][0][0];
    		B2 = solved[2][0][1];
    		B3 = solved[2][0][2];
    		
            solved[0][0][0] = solved[0][2][0];
            solved[0][0][1] = solved[0][2][1];
            solved[0][0][2] = solved[0][2][2];
            solved[0][1][0] = solved[1][2][0];
            solved[0][1][1] = solved[1][2][1];
            solved[0][1][2] = solved[1][2][2];
            solved[0][2][0] = solved[2][2][0];
            solved[0][2][1] = solved[2][2][1];
            solved[0][2][2] = solved[2][2][2];
            
            solved[1][0][0] = F4;
            solved[1][0][1] = F5;
            solved[1][0][2] = F6;
            solved[1][2][0] = solved[2][1][0];
            solved[1][2][1] = solved[2][1][1];
            solved[1][2][2] = solved[2][1][2];
            
            solved[2][0][0] = F1;
            solved[2][0][1] = F2;
            solved[2][0][2] = F3;
            solved[2][1][0] = S1;
            solved[2][1][1] = S2;
            solved[2][1][2] = S3;
            solved[2][2][0] = B1;
            solved[2][2][1] = B2;
            solved[2][2][2] = B3;
        }
        else if(move.equals("Xi"))
        {
        	// rubik
        	String F1 = rubik[0][0][0];
    		String F2 = rubik[0][0][1];
    		String F3 = rubik[0][0][2];
    		String F4 = rubik[0][1][0];
    		String F5 = rubik[0][1][1];
    		String F6 = rubik[0][1][2];
    		String F7 = rubik[0][2][0];
    		String F8 = rubik[0][2][1];
    		String F9 = rubik[0][2][2];
    		String S7 = rubik[1][2][0];
    		String S8 = rubik[1][2][1];
    		String S9 = rubik[1][2][2];
    		
            rubik[0][0][0] = rubik[2][0][0];
            rubik[0][0][1] = rubik[2][0][1];
            rubik[0][0][2] = rubik[2][0][2];
            rubik[0][1][0] = rubik[1][0][0];
            rubik[0][1][1] = rubik[1][0][1];
            rubik[0][1][2] = rubik[1][0][2];
            rubik[0][2][0] = F1;
            rubik[0][2][1] = F2;
            rubik[0][2][2] = F3;
            
            rubik[1][0][0] = rubik[2][1][0];
            rubik[1][0][1] = rubik[2][1][1];
            rubik[1][0][2] = rubik[2][1][2];
            rubik[1][2][0] = F4;
            rubik[1][2][1] = F5;
            rubik[1][2][2] = F6;
            
            rubik[2][0][0] = rubik[2][2][0];
            rubik[2][0][1] = rubik[2][2][1];
            rubik[2][0][2] = rubik[2][2][2];
            rubik[2][1][0] = S7;
            rubik[2][1][1] = S8;
            rubik[2][1][2] = S9;
            rubik[2][2][0] = F7;
            rubik[2][2][1] = F8;
            rubik[2][2][2] = F9;
            
         // solved
        	F1 = solved[0][0][0];
    		F2 = solved[0][0][1];
    		F3 = solved[0][0][2];
    		F4 = solved[0][1][0];
    		F5 = solved[0][1][1];
    		F6 = solved[0][1][2];
    		F7 = solved[0][2][0];
    		F8 = solved[0][2][1];
    		F9 = solved[0][2][2];
    		S7 = solved[1][2][0];
    		S8 = solved[1][2][1];
    		S9 = solved[1][2][2];
    		
            solved[0][0][0] = solved[2][0][0];
            solved[0][0][1] = solved[2][0][1];
            solved[0][0][2] = solved[2][0][2];
            solved[0][1][0] = solved[1][0][0];
            solved[0][1][1] = solved[1][0][1];
            solved[0][1][2] = solved[1][0][2];
            solved[0][2][0] = F1;
            solved[0][2][1] = F2;
            solved[0][2][2] = F3;
            
            solved[1][0][0] = solved[2][1][0];
            solved[1][0][1] = solved[2][1][1];
            solved[1][0][2] = solved[2][1][2];
            solved[1][2][0] = F4;
            solved[1][2][1] = F5;
            solved[1][2][2] = F6;
            
            solved[2][0][0] = solved[2][2][0];
            solved[2][0][1] = solved[2][2][1];
            solved[2][0][2] = solved[2][2][2];
            solved[2][1][0] = S7;
            solved[2][1][1] = S8;
            solved[2][1][2] = S9;
            solved[2][2][0] = F7;
            solved[2][2][1] = F8;
            solved[2][2][2] = F9;
        }
        else if(move.equals("Y"))
        {
        	// rubik
        	String F1 = rubik[0][0][0];
    		String F2 = rubik[0][0][1];
    		String F4 = rubik[0][1][0];
    		String F5 = rubik[0][1][1];
    		String F7 = rubik[0][2][0];
    		String F8 = rubik[0][2][1];
    		String S1 = rubik[1][0][0];
    		String S4 = rubik[1][1][0];
    		String S7 = rubik[1][2][0];
    		String B1 = rubik[2][0][0];
    		String B4 = rubik[2][1][0];
    		String B7 = rubik[2][2][0];
    		
            rubik[0][0][0] = rubik[0][0][2];
            rubik[0][0][1] = rubik[1][0][2];
            rubik[0][0][2] = rubik[2][0][2];
            rubik[0][1][0] = rubik[0][1][2];
            rubik[0][1][1] = rubik[1][1][2];
            rubik[0][1][2] = rubik[2][1][2];
            rubik[0][2][0] = rubik[0][2][2];
            rubik[0][2][1] = rubik[1][2][2];
            rubik[0][2][2] = rubik[2][2][2];
            
            rubik[1][0][0] = F2;
            rubik[1][0][2] = rubik[2][0][1];
            rubik[1][1][0] = F5;
            rubik[1][1][2] = rubik[2][1][1];
            rubik[1][2][0] = F8;
            rubik[1][2][2] = rubik[2][2][1];
            
            rubik[2][0][0] = F1;
            rubik[2][0][1] = S1;
            rubik[2][0][2] = B1;
            rubik[2][1][0] = F4;
            rubik[2][1][1] = S4;
            rubik[2][1][2] = B4;
            rubik[2][2][0] = F7;
            rubik[2][2][1] = S7;
            rubik[2][2][2] = B7;
            
         // solved
        	F1 = solved[0][0][0];
    		F2 = solved[0][0][1];
    		F4 = solved[0][1][0];
    		F5 = solved[0][1][1];
    		F7 = solved[0][2][0];
    		F8 = solved[0][2][1];
    		S1 = solved[1][0][0];
    		S4 = solved[1][1][0];
    		S7 = solved[1][2][0];
    		B1 = solved[2][0][0];
    		B4 = solved[2][1][0];
    		B7 = solved[2][2][0];
    		
            solved[0][0][0] = solved[0][0][2];
            solved[0][0][1] = solved[1][0][2];
            solved[0][0][2] = solved[2][0][2];
            solved[0][1][0] = solved[0][1][2];
            solved[0][1][1] = solved[1][1][2];
            solved[0][1][2] = solved[2][1][2];
            solved[0][2][0] = solved[0][2][2];
            solved[0][2][1] = solved[1][2][2];
            solved[0][2][2] = solved[2][2][2];
            
            solved[1][0][0] = F2;
            solved[1][0][2] = solved[2][0][1];
            solved[1][1][0] = F5;
            solved[1][1][2] = solved[2][1][1];
            solved[1][2][0] = F8;
            solved[1][2][2] = solved[2][2][1];
            
            solved[2][0][0] = F1;
            solved[2][0][1] = S1;
            solved[2][0][2] = B1;
            solved[2][1][0] = F4;
            solved[2][1][1] = S4;
            solved[2][1][2] = B4;
            solved[2][2][0] = F7;
            solved[2][2][1] = S7;
            solved[2][2][2] = B7;
        }
        else if(move.equals("Yi"))
        {
        	// rubik
        	String F1 = rubik[0][0][0];
    		String F2 = rubik[0][0][1];
    		String F3 = rubik[0][0][2];
    		String F4 = rubik[0][1][0];
    		String F5 = rubik[0][1][1];
    		String F6 = rubik[0][1][2];
    		String F7 = rubik[0][2][0];
    		String F8 = rubik[0][2][1];
    		String F9 = rubik[0][2][2];
    		String S3 = rubik[1][0][2];
    		String S6 = rubik[1][1][2];
    		String S9 = rubik[1][2][2];
    		
            rubik[0][0][0] = rubik[2][0][0];
            rubik[0][0][1] = rubik[1][0][0];
            rubik[0][0][2] = F1;
            rubik[0][1][0] = rubik[2][1][0];
            rubik[0][1][1] = rubik[1][1][0];
            rubik[0][1][2] = F4;
            rubik[0][2][0] = rubik[2][2][0];
            rubik[0][2][1] = rubik[1][2][0];
            rubik[0][2][2] = F7;
            
            rubik[1][0][0] = rubik[2][0][1];
            rubik[1][0][2] = F2;
            rubik[1][1][0] = rubik[2][1][1];
            rubik[1][1][2] = F5;
            rubik[1][2][0] = rubik[2][2][1];
            rubik[1][2][2] = F8;
            
            rubik[2][0][0] = rubik[2][0][2];
            rubik[2][0][1] = S3;
            rubik[2][0][2] = F3;
            rubik[2][1][0] = rubik[2][1][2];
            rubik[2][1][1] = S6;
            rubik[2][1][2] = F6;
            rubik[2][2][0] = rubik[2][2][2];
            rubik[2][2][1] = S9;
            rubik[2][2][2] = F9;
            
         // solved
        	F1 = solved[0][0][0];
    		F2 = solved[0][0][1];
    		F3 = solved[0][0][2];
    		F4 = solved[0][1][0];
    		F5 = solved[0][1][1];
    		F6 = solved[0][1][2];
    		F7 = solved[0][2][0];
    		F8 = solved[0][2][1];
    		F9 = solved[0][2][2];
    		S3 = solved[1][0][2];
    		S6 = solved[1][1][2];
    		S9 = solved[1][2][2];
    		
            solved[0][0][0] = solved[2][0][0];
            solved[0][0][1] = solved[1][0][0];
            solved[0][0][2] = F1;
            solved[0][1][0] = solved[2][1][0];
            solved[0][1][1] = solved[1][1][0];
            solved[0][1][2] = F4;
            solved[0][2][0] = solved[2][2][0];
            solved[0][2][1] = solved[1][2][0];
            solved[0][2][2] = F7;
            
            solved[1][0][0] = solved[2][0][1];
            solved[1][0][2] = F2;
            solved[1][1][0] = solved[2][1][1];
            solved[1][1][2] = F5;
            solved[1][2][0] = solved[2][2][1];
            solved[1][2][2] = F8;
            
            solved[2][0][0] = solved[2][0][2];
            solved[2][0][1] = S3;
            solved[2][0][2] = F3;
            solved[2][1][0] = solved[2][1][2];
            solved[2][1][1] = S6;
            solved[2][1][2] = F6;
            solved[2][2][0] = solved[2][2][2];
            solved[2][2][1] = S9;
            solved[2][2][2] = F9;
        }
        else if(move.equals("Z"))
        {
        	// rubik
        	String F1 = rubik[0][0][0];
    		String F2 = rubik[0][0][1];
    		String F3 = rubik[0][0][2];
    		String F6 = rubik[0][1][2];
    		String S1 = rubik[1][0][0];
    		String S2 = rubik[1][0][1];
    		String S3 = rubik[1][0][2];
    		String S6 = rubik[1][1][2];
    		String B1 = rubik[2][0][0];
    		String B2 = rubik[2][0][1];
    		String B3 = rubik[2][0][2];
    		String B6 = rubik[2][1][2];
    		
            rubik[0][0][0] = rubik[0][2][0];
            rubik[0][0][1] = rubik[0][1][0];
            rubik[0][0][2] = F1;
            rubik[0][1][0] = rubik[0][2][1];
            rubik[0][1][2] = F2;
            rubik[0][2][0] = rubik[0][2][2];
            rubik[0][2][1] = F6;
            rubik[0][2][2] = F3;
            
            rubik[1][0][0] = rubik[1][2][0];
            rubik[1][0][1] = rubik[1][1][0];
            rubik[1][0][2] = S1;
            rubik[1][1][0] = rubik[1][2][1];
            rubik[1][1][2] = S2;
            rubik[1][2][0] = rubik[1][2][2];
            rubik[1][2][1] = S6;
            rubik[1][2][2] = S3;
            
            rubik[2][0][0] = rubik[2][2][0];
            rubik[2][0][1] = rubik[2][1][0];
            rubik[2][0][2] = B1;
            rubik[2][1][0] = rubik[2][2][1];
            rubik[2][1][2] = B2;
            rubik[2][2][0] = rubik[2][2][2];
            rubik[2][2][1] = B6;
            rubik[2][2][2] = B3;
            
         // solved
        	F1 = solved[0][0][0];
    		F2 = solved[0][0][1];
    		F3 = solved[0][0][2];
    		F6 = solved[0][1][2];
    		S1 = solved[1][0][0];
    		S2 = solved[1][0][1];
    		S3 = solved[1][0][2];
    		S6 = solved[1][1][2];
    		B1 = solved[2][0][0];
    		B2 = solved[2][0][1];
    		B3 = solved[2][0][2];
    		B6 = solved[2][1][2];
    		
            solved[0][0][0] = solved[0][2][0];
            solved[0][0][1] = solved[0][1][0];
            solved[0][0][2] = F1;
            solved[0][1][0] = solved[0][2][1];
            solved[0][1][2] = F2;
            solved[0][2][0] = solved[0][2][2];
            solved[0][2][1] = F6;
            solved[0][2][2] = F3;
            
            solved[1][0][0] = solved[1][2][0];
            solved[1][0][1] = solved[1][1][0];
            solved[1][0][2] = S1;
            solved[1][1][0] = solved[1][2][1];
            solved[1][1][2] = S2;
            solved[1][2][0] = solved[1][2][2];
            solved[1][2][1] = S6;
            solved[1][2][2] = S3;
            
            solved[2][0][0] = solved[2][2][0];
            solved[2][0][1] = solved[2][1][0];
            solved[2][0][2] = B1;
            solved[2][1][0] = solved[2][2][1];
            solved[2][1][2] = B2;
            solved[2][2][0] = solved[2][2][2];
            solved[2][2][1] = B6;
            solved[2][2][2] = B3;
        }
        else if(move.equals("Zi"))
        {
        	// rubik
        	String F1 = rubik[0][0][0];
    		String F2 = rubik[0][0][1];
    		String F4 = rubik[0][1][0];
    		String F7 = rubik[0][2][0];
    		String S1 = rubik[1][0][0];
    		String S2 = rubik[1][0][1];
    		String S4 = rubik[1][1][0];
    		String S7 = rubik[1][2][0];
    		String B1 = rubik[2][0][0];
    		String B2 = rubik[2][0][1];
    		String B4 = rubik[2][1][0];
    		String B7 = rubik[2][2][0];
    		
            rubik[0][0][0] = rubik[0][0][2];
            rubik[0][0][1] = rubik[0][1][2];
            rubik[0][0][2] = rubik[0][2][2];
            rubik[0][1][0] = F2;
            rubik[0][1][2] = rubik[0][2][1];
            rubik[0][2][0] = F1;
            rubik[0][2][1] = F4;
            rubik[0][2][2] = F7;
            
            rubik[1][0][0] = rubik[1][0][2];
            rubik[1][0][1] = rubik[1][1][2];
            rubik[1][0][2] = rubik[1][2][2];
            rubik[1][1][0] = S2;
            rubik[1][1][2] = rubik[1][2][1];
            rubik[1][2][0] = S1;
            rubik[1][2][1] = S4;
            rubik[1][2][2] = S7;
            
            rubik[2][0][0] = rubik[2][0][2];
            rubik[2][0][1] = rubik[2][1][2];
            rubik[2][0][2] = rubik[2][2][2];
            rubik[2][1][0] = B2;
            rubik[2][1][2] = rubik[2][2][1];
            rubik[2][2][0] = B1;
            rubik[2][2][1] = B4;
            rubik[2][2][2] = B7;
            
        	// solved
        	F1 = solved[0][0][0];
    		F2 = solved[0][0][1];
    		F4 = solved[0][1][0];
    		F7 = solved[0][2][0];
    		S1 = solved[1][0][0];
    		S2 = solved[1][0][1];
    		S4 = solved[1][1][0];
    		S7 = solved[1][2][0];
    		B1 = solved[2][0][0];
    		B2 = solved[2][0][1];
    		B4 = solved[2][1][0];
    		B7 = solved[2][2][0];
    		
            solved[0][0][0] = solved[0][0][2];
            solved[0][0][1] = solved[0][1][2];
            solved[0][0][2] = solved[0][2][2];
            solved[0][1][0] = F2;
            solved[0][1][2] = solved[0][2][1];
            solved[0][2][0] = F1;
            solved[0][2][1] = F4;
            solved[0][2][2] = F7;
            
            solved[1][0][0] = solved[1][0][2];
            solved[1][0][1] = solved[1][1][2];
            solved[1][0][2] = solved[1][2][2];
            solved[1][1][0] = S2;
            solved[1][1][2] = solved[1][2][1];
            solved[1][2][0] = S1;
            solved[1][2][1] = S4;
            solved[1][2][2] = S7;
            
            solved[2][0][0] = solved[2][0][2];
            solved[2][0][1] = solved[2][1][2];
            solved[2][0][2] = solved[2][2][2];
            solved[2][1][0] = B2;
            solved[2][1][2] = solved[2][2][1];
            solved[2][2][0] = B1;
            solved[2][2][1] = B4;
            solved[2][2][2] = B7;
        }
	}
	
	public static void copy()
	{
		for(int i=0; i<3; i++)
			for(int j=0; j<3; j++)
				for(int k=0; k<3; k++)
					rubikOld[i][j][k] = rubik[i][j][k];
	}
	
	public static void copy(String x[][][], String y[][][])
	{
		for(int i=0; i<3; i++)
			for(int j=0; j<3; j++)
				for(int k=0; k<3; k++)
					y[i][j][k] = x[i][j][k];
	}
	
	public static void printState() 
	{
		for(int i=0; i<3; i++)
		{	
			if(i==0) System.out.println("Front:\n");
			else if(i==1) System.out.println("Standing:\n");
			else if(i==2) System.out.println("Back:\n");
			
			for(int j=0; j<3; j++)
			{	
				for(int k=0; k<3; k++)
					System.out.print(rubik[i][j][k] + " ");
				System.out.println();
			}
			System.out.println();
		}
		System.out.println("=============================================\n");
	}

	public static Boolean isSolved()
	{
		Boolean isSolved = true;
		
		for(int i=0; i<3; i++)
			for(int j=0; j<3; j++)
				for(int k=0; k<3; k++)
					if(!rubik[i][j][k].equals(solved[i][j][k]))
						isSolved = false;
		
		return isSolved;
	}
	
	public static void Scramble(int n)
	{
		gameInProgress = false;
		gameInProgressOld = false;
		
		String[] moves = {"F", "Fi", "B", "Bi", "L", "Li", "R", "Ri", "U", "Ui", "D", "Di"};
		List<String> scramble = new ArrayList<String>();
		int k=0;
		
		isScrambling = true;
		
		System.out.print("Scramble: ");
		
		while(k<n)
		{
			int i = new Random().nextInt(moves.length);
			if(scramble.size() == 0 || !(scramble.get(scramble.size()-1).contains(moves[i]) || moves[i].contains(scramble.get(scramble.size()-1))))
			{
				scramble.add(moves[i]);
				System.out.print(moves[i] + " ");
				k++;
			}
		}
		System.out.println();
		
		scramble.forEach(s -> {
			copy();
			turn(s);
			move = s;
			moveFlagOld = moveFlag;
			moveFlag = true;
			try {
				Thread.sleep(600);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		isScrambling = false;
		resetMoves();
		newGame = true;
		gameInProgress = true;
	}
	
	public static void resetMoves()
	{
		movesCount = 0;
	}
}
