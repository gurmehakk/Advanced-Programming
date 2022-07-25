package apA2;
import apA2.Main.general;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


interface Instructor extends general{
	
    Scanner sc = new Scanner(System.in);
	static String[] addclassmaterial(int instlogin,int imat) {
		 if(imat == 1) {
			 System.out.println("Enter topic of slides:");
			 String stop = sc.next();
			 System.out.println("Enter number of slides:");
             int nslides = sc.nextInt();
             String[] slides = new String[nslides+3];
             if(instlogin==0)slides[0]="I0";
             if(instlogin==1)slides[0]="I1";
             slides[1] = stop;
             String a = String.valueOf(nslides);
             slides[2] = a;
			 System.out.println("Enter content of slides :");
			 int c = 3;
			 for(int i = 1;i<=nslides;i++) {
				 System.out.println("Content of slide" + i+ ": ");
				 String cont = sc.next();
				 slides[c] = cont;
				 c++;
			 }
			 return slides;
		 }if(imat == 2) {
			 System.out.println("Enter topic of video:");
			 String vtop = sc.next();
			 
			 System.out.println("Enter filename of video:");
			 String vfname = sc.next();
             String[] videos = new String[3];
             if(instlogin==0)videos[0]="I0";
             if(instlogin==1)videos[0]="I1";
             videos[1] = vtop;
             videos[2] = vfname;
             return videos;
		 }
		return null;
		
			 
			 
			 
	}
	static void addassesments(int instlogin, int iass , String[] assign, String[] qz) {
		if(iass == 1) {
			System.out.println("Enter problem statement:");
			String ps = sc.next();
			System.out.println("Enter max marks:");
            int mm = sc.nextInt();
            if(instlogin==0)assign[0]="I0";
            if(instlogin==1)assign[0]="I1";
            assign[1] = ps;
            String a = String.valueOf(mm);
            assign[2] = a;
            assign[3] = "Pending";
            assign[4] = "Ungraded";
            assign[5] = "Open";
		 }
		if(iass == 2) {
			 System.out.println("Enter quiz question: ");
			 String ques = sc.next();
            if(instlogin==0)qz[0]="I0";
            if(instlogin==1)qz[0]="I1";
            qz[1] = ques;
            qz[2] = "1";
            qz[3] = "Pending";
            qz[4] = "Ungraded";
            qz[5] = "Open";
		 }	
	}
	static void gradeassesments(int instlogin,HashMap<Integer, String[]> assignment,HashMap<Integer, String[]> quiz,HashMap<String, String[]> s0,
			HashMap<String, String[]> s1,HashMap<String, String[]> s2) {
		System.out.println("List of assessments:");
		general.viewassesments(assignment, quiz);
		System.out.println("Enter ID of assessment to view submissions:");
		String id = sc.next();
		String[] ab = new String[10];
		if(id.charAt(0)=='A') {
			int n = general.sti(id);
			if(assignment.containsKey(n)) {
				ab = assignment.get(n);	
			}
		}else if(id.charAt(0)=='Q') {
			int n = general.sti(id);
			if(quiz.containsKey(n)) {
				ab = quiz.get(n);
		   }
		}
		System.out.println("Choose ID from these ungraded submissions :");
		if(s0.containsKey(id)) {
			System.out.println("0. S0");
		}if(s1.containsKey(id)) {
			System.out.println("1. S1");
		}if(s2.containsKey(id)) {
			System.out.println("0. S2");
		}
		int enter = sc.nextInt();
		if(enter==0) {
			
			String a1[] = s0.get(id);
			System.out.println("Submission: " + a1[9]);
			System.out.println("-------------------------------------------------/n");
			System.out.println("Max Marks : "+ a1[2]);
			System.out.println("Marks scored: ");
			int m = sc.nextInt();
			a1[8] = String.valueOf(m);
			if(instlogin==0)a1[7]="I0";
	        if(instlogin==1)a1[7]="I1";
	        a1[4] = "Graded";
			s0.replace(id, a1);
		}if(enter==1) {
			String a2[] = s1.get(id);
			System.out.println("Submission: " + a2[9]);
			System.out.println("-------------------------------------------------/n");
			System.out.println("Max Marks : "+ a2[2]);
			System.out.println("Marks scored: ");
			int m = sc.nextInt();
			a2[8] = String.valueOf(m);
			if(instlogin==0)a2[7]="I0";
	        if(instlogin==1)a2[7]="I1";
	        a2[4]= "Graded";
			s1.replace(id, a2);
		}if(enter==2) {
			String a3[] = s2.get(id);
			System.out.println("Submission: " + a3[9]);
			System.out.println("-------------------------------------------------/n");
			System.out.println("Max Marks : "+ a3[2]);
			System.out.println("Marks scored: ");
			int m = sc.nextInt();
			a3[8] = String.valueOf(m);
			if(instlogin==0)a3[7]="I0";
	        if(instlogin==1)a3[7]="I1";
	        a3[4] = "Graded";
			s2.replace(id, a3);
		}
		
	}
      static void closeassesment(HashMap<Integer, String[]> assignment, HashMap<Integer, String[]> quiz) {
    	  System.out.println("List of Open Assignments:");
    	  general.viewassesments(assignment, quiz);
    	  System.out.println("Enter id of assignment to close:");
    	  String ca = sc.next();
    	  String[] cd = new String[10];
    	  if(ca.charAt(0)=='A') {
  			int n = general.sti(ca);
  			if(assignment.containsKey(n)) {
  				cd = assignment.get(n);	
  				cd[5] = "Close";
  				assignment.replace(n, cd);
  			}
  		}else if(ca.charAt(0)=='Q') {
  			int n = general.sti(ca);
  			if(quiz.containsKey(n)) {
  				cd = quiz.get(n);
  				cd[5] = "Close";
  				quiz.replace(n, cd);
  		   }
  		}
	}

}
class I0 implements Instructor{
}
class I1 implements Instructor{	
}
