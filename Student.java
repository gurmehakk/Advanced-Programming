package apA2;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import apA2.Main.general;

interface Student extends general{
    static void submitassesment(int stlogin,HashMap<String, String[]> s0, HashMap<String, String[]> s1, HashMap<String, String[]> s2,String idas,String file) {
    	if(stlogin==0) S0.submit(s0,idas,file);
    	if(stlogin==1) S1.submit(s1,idas,file);
    	if(stlogin==2) S2.submit(s2,idas,file);
    }
    static void viewpending(int stlogin,HashMap<String, String[]> s0, HashMap<String, String[]> s1, HashMap<String, String[]> s2) {
    	if(stlogin==0) S0.view(s0);
    	if(stlogin==1) S1.view(s1);
    	if(stlogin==2) S2.view(s2);
    }
	static void viewgrade(int stlogin,HashMap<String, String[]> s0, HashMap<String, String[]> s1, HashMap<String, String[]> s2) {
		if(stlogin==0) S0.grade(s0);
    	if(stlogin==1) S1.grade(s1);
    	if(stlogin==2) S2.grade(s2);
		
		
	}
	static void addassign(int stlogin, HashMap<String, String[]> s0, HashMap<String, String[]> s1, HashMap<String, String[]> s2,HashMap<Integer, String[]> assignment, 
			HashMap<Integer, String[]> quiz) {
		String a = Student.asskey(assignment);
		int n = general.sti(a);
		if(assignment.containsKey(n)) {
			String[] ab = assignment.get(n);	
			if(stlogin==0)s0.put(a, ab);
			if(stlogin==1)s1.put(a, ab);
			if(stlogin==2)s2.put(a, ab);
		}
		String b = Student.qzkey(quiz);
		int m = general.sti(a);
		if(quiz.containsKey(m)) {
			String[] ab = quiz.get(m);	
			if(stlogin==0)s0.put(b, ab);
			if(stlogin==1)s1.put(b, ab);
			if(stlogin==2)s2.put(b, ab);
		}
	}
	
	static String asskey(HashMap<Integer, String[]> assignment ) {
		for (Entry<Integer, String[]> set : assignment.entrySet()) {
			String aid = "A";
			String[] cm = set.getValue();
			if(cm[5]=="Open") {
				int id = set.getKey();
				aid += String.valueOf(id);
				return aid;
			}	
		}
		return null;
		
	}
	static String qzkey(HashMap<Integer, String[]> quiz) {
		for (Entry<Integer, String[]> set : quiz.entrySet()) {
			String aid = "Q";
			String[] cm = set.getValue();
			if(cm[5]=="Open") {
				int id = set.getKey();
				aid += String.valueOf(id);
				return aid;
			}	
		}
		return null;

	}

}
class S0 implements Student{
	

	public static void grade(HashMap<String, String[]> s0) {
		System.out.println("Graded Submissions : ");
		for (Entry<String, String[]> set : s0.entrySet()) {
			String[] s = set.getValue();
			if(s[4]=="Graded") {
				System.out.println("Submission: "+ s[9]);
                System.out.println("Marks sscored: " + s[8]);
				System.out.println("Graded by: "+ s[7]);
			}
	}   System.out.println("Unraded Submissions : ");
		for (Entry<String, String[]> set : s0.entrySet()) {
		String[] s = set.getValue();
		if(s[4]=="Ungraded"&& s[3]=="Done") {
			System.out.println("Submission: "+ s[9]);
		}
}
}
	

	public static void view(HashMap<String, String[]> s0) {
		for (Entry<String, String[]> set : s0.entrySet()) {
			String[] ass = set.getValue();
			if(ass[3]=="Pending") {
				System.out.println("ID: "+ set.getKey());
                System.out.println("Assignment: " + ass[1]);
				System.out.println("Maximum marks: "+ ass[2]);
			}	
		}System.out.println("-----------------------------------------/n");	
		for (Entry<String, String[]> set : s0.entrySet()) {
			String[] qzz = set.getValue();
			if(qzz[2]=="Pending") {
				System.out.println("ID: "+ set.getKey());
                System.out.println("Question: " + qzz[1]);
			}
			
			}System.out.println("-----------------------------------------/n");	
		
	}

	public static void submit(HashMap<String, String[]> s0,String idas,String file) {
		if(s0.containsKey(idas)) {
			String[] arr = s0.get(idas);
			if(arr[3]=="Pending") {
				arr[3] = "Done";
				arr[9] = file;
				s0.replace(idas, arr);
			}
	    }
		
		
		
	}

	

	
}
	class S1 implements Student{
		public static void view(HashMap<String, String[]> s1) {
			for (Entry<String, String[]> set : s1.entrySet()) {
				String[] ass = set.getValue();
				if(ass[3]=="Pending") {
					System.out.println("ID: "+ set.getKey());
	                System.out.println("Assignment: " + ass[1]);
					System.out.println("Maximum marks: "+ ass[2]);
				}	
			}System.out.println("-----------------------------------------/n");	
			for (Entry<String, String[]> set : s1.entrySet()) {
				String[] qzz = set.getValue();
				if(qzz[2]=="Pending") {
					System.out.println("ID: "+ set.getKey());
	                System.out.println("Question: " + qzz[1]);
				}
				
				}System.out.println("-----------------------------------------/n");	
			
		}
		public static void grade(HashMap<String, String[]> s1) {
			System.out.println("Graded Submissions : ");
			for (Entry<String, String[]> set : s1.entrySet()) {
				String[] s = set.getValue();
				if(s[4]=="Graded") {
					System.out.println("Submission: "+ s[9]);
	                System.out.println("Marks sscored: " + s[8]);
					System.out.println("Graded by: "+ s[7]);
				}
		}   System.out.println("Unraded Submissions : ");
			for (Entry<String, String[]> set : s1.entrySet()) {
			String[] s = set.getValue();
			if(s[4]=="Ungraded"&& s[3]=="Done") {
				System.out.println("Submission: "+ s[9]);
			}
	}
			
		}
		public static void submit(HashMap<String, String[]> s1,String idas,String file) {
			if(s1.containsKey(idas)) {
				String[] arr = s1.get(idas);
		        if(arr[3]=="Pending") {
					arr[3] = "Done";
					arr[9] = file;
					s1.replace(idas, arr);
				}
		    }	
		}


		

	
		
		
		
	}class S2 implements Student{
			public static void view(HashMap<String, String[]> s2) {
				for (Entry<String, String[]> set : s2.entrySet()) {
					String[] ass = set.getValue();
					if(ass[3]=="Pending") {
						System.out.println("ID: "+ set.getKey());
		                System.out.println("Assignment: " + ass[1]);
						System.out.println("Maximum marks: "+ ass[2]);
					}	
				}System.out.println("-----------------------------------------/n");	
				for (Entry<String, String[]> set : s2.entrySet()) {
					String[] qzz = set.getValue();
					if(qzz[2]=="Pending") {
						System.out.println("ID: "+ set.getKey());
		                System.out.println("Question: " + qzz[1]);
					}
					
					}System.out.println("-----------------------------------------/n");	
				
			}
			public static void grade(HashMap<String, String[]> s2) {
				System.out.println("Graded Submissions : ");
				for (Entry<String, String[]> set : s2.entrySet()) {
					String[] s = set.getValue();
					if(s[4]=="Graded") {
						System.out.println("Submission: "+ s[9]);
		                System.out.println("Marks sscored: " + s[8]);
						System.out.println("Graded by: "+ s[7]);
					}
			}   System.out.println("Unraded Submissions : ");
				for (Entry<String, String[]> set : s2.entrySet()) {
				String[] s = set.getValue();
				if(s[4]=="Ungraded"&& s[3]=="Done") {
					System.out.println("Submission: "+ s[9]);
				}
		}
				
			}
			public static void submit(HashMap<String, String[]> s2,String idas,String file) {
				if(s2.containsKey(idas)) {
					String[] arr = s2.get(idas);
					if(arr[3]=="Pending") {
						arr[3] = "Done";
						arr[9] = file;
						s2.replace(idas, arr);
					}
			    }
				
				
				
			}

			
			
			
			
			
	}
	
	

