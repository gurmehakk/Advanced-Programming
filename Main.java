package apA2;
import java.util.Date;
import java.util.*;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

import ap.Citizen;
import ap.Vaccine;

public class Main {

	public static void main(String[] args) {
		HashMap<Date, String[]> lslides =new HashMap<>();
		HashMap<Date, String[]> lvideos =new HashMap<>();
		HashMap<Integer, String[]> assignment =new HashMap<>();
		HashMap<Integer, String[]> quiz =new HashMap<>();
		HashMap<Date, String[]> comments =new HashMap<>();
		HashMap<String, String[]> s0 =new HashMap<>();
		HashMap<String, String[]> s1 =new HashMap<>();
		HashMap<String, String[]> s2 =new HashMap<>();
		//key-s0/s1/s2 ,0-quiz/assign,1-
		String member = "";
		String[] assign = new String[10]; 
		//0-inst 1-ps 2-mm 3-pending/done 4-graded/ungraded 5-open/close
		String[] qz = new String[10];

		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("Welcome to Backpack\n" +
	                "1. Enter as instructor\n" +
	                "2. Enter as student\n" +
	                "3. Exit\n");
			int input = sc.nextInt();
			if(input == 1) {
				System.out.println("Instructors:\n" +
                "0 - I0\n" +
                "1 - I1\n" +
                "Choose id:\n");
				 int instlogin = sc.nextInt();
				 if(instlogin==0) {
					 member="I0";
					 System.out.println("Welcome I0");
				 }else if(instlogin==1) {
					 member="I1";
					 System.out.println("Welcome I1");
				 }
				 while(true) {
					 System.out.println("Instructor Menu : \n"+
								"1. Add class material\r\n"
								+ "2. Add assessments\r\n"
								+ "3. View lecture materials\r\n"
								+ "4. View assessments\r\n"
								+ "5. Grade assessments\r\n"
								+ "6. Close assessment\r\n"
								+ "7. View comments\r\n"
								+ "8. Add comments\r\n"
								+ "9. Logout");
			 int imenuchoice = sc.nextInt();
			 if(imenuchoice==1) {
				 System.out.println("1. Add Lecture Slide\r\n"
				 		+ "2. Add Lecture Video\r\n");
				 int imat = sc.nextInt();
				 if(imat == 1) {
					 String[] slides = Instructor.addclassmaterial(instlogin, imat);
					 if(slides!=null) {
						 Date d = new Date();
						 lslides.put(d , slides);
					 }
					 			
				 }if(imat == 2) {
					 String[] videos = Instructor.addclassmaterial(instlogin, imat);
					 if(videos!=null) {
						 Date d = new Date();
						 lvideos.put(d , videos); 
					 } 
				 } 
			 }if(imenuchoice==2) {
				 System.out.println("1. Add Assignment\r\n"
				 		+ "2. Add Quiz");
				 int iass = sc.nextInt();
				 int n1 = 0;
				 int n2 = 0;
				 if(iass == 1) {
					 Instructor.addassesments(instlogin, iass , assign , qz);
					 assignment.put( n1 , assign);
					 n1++;
					 
					 			
				 }if(iass == 2) {
					 Instructor.addassesments(instlogin, iass , assign , qz);
					 quiz.put( n2 , qz);
					 n2++; 
					 } 
				 
			 }if(imenuchoice==3) {
				 general.viewlectmaterial(lslides, lvideos);
				 
			 }if(imenuchoice==4) {
				 general.viewassesments(assignment, quiz);
				 
			 }if(imenuchoice==5) {
				 Instructor.gradeassesments(instlogin,assignment,quiz,s0,s1,s2);
				 
			 }if(imenuchoice==6) {
				 Instructor.closeassesment(assignment,quiz);
				 
			 }if(imenuchoice==7) {
				 general.viewcomments(comments);
			 }
				 
			 if(imenuchoice==8) {
		         System.out.println("Enter comment: ");
		         String inp = sc.next();
		         general.addcomments(member,inp,comments);
				 
			 }if(imenuchoice==9) {
				 general.logout();
				 break;
			 }
			 
			 
		} 
				 }
				 else if(input == 2) {
				System.out.println("Students :\n" +
		                "0 - S0\n" +
		                "1 - S1\n" +
		                "2 - S2\n" +
		                "Choose id:\n");
						 int stlogin = sc.nextInt();
						 if(stlogin==0) {
							 member="S0";
							 System.out.println("Welcome S0");
						 }else if(stlogin==1) {
							 member="S1";
							 System.out.println("Welcome S1");
						 }if(stlogin==2) {
							 member="S2";
							 System.out.println("Welcome S2");
						 }
						 Student.addassign(stlogin, s0, s1, s2, assignment, quiz);
						 while(true) {
							 System.out.println("Student Menu : \n"+
										"1. View lecture materials\r\n"
										+ "2. View assessments\r\n"
										+ "3. Submit assessment\r\n"
										+ "4. View grades\r\n"
										+ "5. View comments\r\n"
										+ "6. Add comments\r\n"
										+ "7. Logout\r\n");
					        int smenuchoice = sc.nextInt();
							if(smenuchoice==1) {
								general.viewlectmaterial(lslides, lvideos);
						   }if(smenuchoice==2) {
							   Student.viewpending(stlogin,s0,s1,s2);
							   
								 
						   }if(smenuchoice==3) {
							   System.out.println("Pending assessments:");
							   Student.viewpending(stlogin,s0,s1,s2);
							   System.out.println("Enter ID of assessment(string):");
							   String idas = sc.next();
							   System.out.println("Enter filename of assignment:");
							   String file = sc.next();
							   String ss1 = ".mp4";
							   String ss2 = ".zip";
							   if(file.contains(ss1)||file.contains(ss2)) {
								   Student.submitassesment(stlogin,s0,s1,s2,idas,file);
							   }else {
								   System.out.println("wrong submission format");
								   continue;
							   }
						   }if(smenuchoice==4) {
							   Student.viewgrade(stlogin, s0, s1, s2);
								 
						   }if(smenuchoice==5) {
							   general.viewcomments(comments);
								 
						   }if(smenuchoice==6) {
						      System.out.println("Enter comment: ");
						      String inp = sc.next();
						      general.addcomments(member,inp,comments);
								 
						   }if(smenuchoice==7) {
							   general.logout();
								 break;
								 
							 }
						 }
						
			}
			else if(input == 3) {
				System.out.println("Thankyou");
				System.out.println("-------------------------------------------------------------------------------------------------\n");
				
				
			}
			else {
				System.out.println("Invalid input");
				continue;
			}
			
		}
		
		
		
	

	}
	interface general{
		public static void viewlectmaterial(HashMap<Date, String[]> lslides , HashMap<Date, String[]> lvideos) {
			for (Map.Entry<Date, String[]> set : lslides.entrySet()) {
				String[] arr = set.getValue();
                System.out.println("Title :" + arr[1]);
				System.out.println("Number of slides: "+ arr[2]);
				int temp = Integer.valueOf(arr[2]);
				int s = 3;
				for(int j = 1;j<=temp;j++) {
					 System.out.println("Slide " + j+ ": ");
					 System.out.println(arr[s]);
					 s++;
				 }
				System.out.println("Date of Upload: "+ set.getKey());
				System.out.println("Uploaded by : " + arr[0]);	
			}
			for (Map.Entry<Date, String[]> set2 : lvideos.entrySet()) {
				String[] ar = set2.getValue();
                System.out.println("Title of video:" + ar[1]);
				System.out.println("Video file: "+ ar[2]);
				System.out.println("Date of Upload: "+ set2.getKey());
				System.out.println("Uploaded by : " + ar[0]);
				
			}		
		}
		public static void viewassesments(HashMap<Integer, String[]> assignment, HashMap<Integer, String[]> quiz) {
			for (Map.Entry<Integer, String[]> set : assignment.entrySet()) {
				String[] ass = set.getValue();
				if(ass[5]=="Open") {
					System.out.println("ID: A"+ set.getKey());
	                System.out.println("Assignment: " + ass[1]);
					System.out.println("Maximum marks: "+ ass[2]);
				}	
			}System.out.println("-----------------------------------------/n");	
			for (Map.Entry<Integer, String[]> set : quiz.entrySet()) {
				String[] qzz = set.getValue();
				if(qzz[4]=="Open") {
					System.out.println("ID: Q"+ set.getKey());
	                System.out.println("Question: " + qzz[1]);
				}
				
				}System.out.println("-----------------------------------------/n");	
		}
		static void viewcomments(HashMap<Date, String[]> comments) {
			for (Entry<Date, String[]> set : comments.entrySet()) {
				String[] cm = set.getValue();
				System.out.println(cm[1] + " - " + cm[0]);
				System.out.println(set.getKey());
			}
		}
		static void addcomments(String member ,String inp, HashMap<Date, String[]> comments) {
			Date dt = new Date();
			String[] com = new String[2];
			com[0]=member;
			com[1]=inp;
			comments.put(dt, com);
		}
		static void logout() {
			System.out.println("Logged Out!");
		}
		static int sti(String s) {
			String temp = "";
			if(s.length()>=0) {
				for(int i = 1;i<s.length();i++) {
					temp+=s.charAt(i);
				}

				
			}
		    int n = Integer.valueOf(temp);
			return n;

		}
	}

}
