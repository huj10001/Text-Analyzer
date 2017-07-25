package textAnalyzer;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;



public class textAnalyzer {
private static Hashtable<String, ArrayList<String>> ht_schedule = new Hashtable<String, ArrayList<String>>();

static String filepath = null;

	public static void main(String[] args) throws IOException {
		Hashtable<String, ArrayList<String>> ht = new Hashtable<String, ArrayList<String>>();
		int NUM_OF_FILES = 4;
		int NUM_OF_LINES = 9999;
		
		// TODO Auto-generated method stub
//		new textAnalyzer();
//		System.out.println(String.format("%8s %40s %20s", "Device1", "Timestamp", "Device2"));
//		System.out.println("------------------------------------------------------------------------------------------------------");
		
//		/* file chooser test start*/
//		JFrame mainframe = new JFrame("Upload File");
//		mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		mainframe.pack();
//		mainframe.setVisible(true); 
//		mainframe.setSize(400,400);
//		JPanel controlpanel = new JPanel();
//		mainframe.add(controlpanel);
//		JButton uploadbutton = new JButton("Upload and Run");
//		JButton filebutton1 = new JButton("Choose File1"); 
//		JLabel label1 = new JLabel("No file1 chosen");
//		JButton filebutton2 = new JButton("Choose File2"); 
//		JLabel label2 = new JLabel("No file2 chosen");
//		JButton filebutton3 = new JButton("Choose File3"); 
//		JLabel label3 = new JLabel("No file3 chosen");
//		JButton filebutton4 = new JButton("Choose File4"); 
//		JLabel label4 = new JLabel("No file4 chosen");
//		
//		filebutton1.addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent e){
//				FileChooser();
//				label1.setText(filepath);
//			}
//		});
//		BufferedReader br1 = new BufferedReader(new FileReader(filepath));
//		filebutton2.addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent e){
//				FileChooser();
//				label2.setText(filepath);
//			}
//		});
//		BufferedReader br2 = new BufferedReader(new FileReader(filepath));
//		filebutton3.addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent e){
//				FileChooser();
//				label3.setText(filepath);
//			}
//		});
//		BufferedReader br3 = new BufferedReader(new FileReader(filepath));
//		filebutton4.addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent e){
//				FileChooser();
//				label4.setText(filepath);
//			}
//		});
//		
//		controlpanel.add(filebutton1); 
//		controlpanel.add(label1);
//		
//		controlpanel.add(filebutton2);
//		controlpanel.add(label2);
//		
//		controlpanel.add(filebutton3);
//		controlpanel.add(label3);
//		
//		controlpanel.add(filebutton4);
//		controlpanel.add(label4);
//		
//		controlpanel.add(uploadbutton);
//		
//		controlpanel.setLayout(new BoxLayout(controlpanel, BoxLayout.Y_AXIS));
//		/* file chooser test end */
		
		
		BufferedReader br1 = new BufferedReader(new FileReader(FileChooser()));
		BufferedReader br2 = new BufferedReader(new FileReader(FileChooser()));
		BufferedReader br3 = new BufferedReader(new FileReader(FileChooser()));
		BufferedReader br4 = new BufferedReader(new FileReader(FileChooser()));
		
//		BufferedReader br1 = new BufferedReader(new FileReader("/Users/huj10001/Documents/systemview/log1-4/log1.log"));
//		BufferedReader br2 = new BufferedReader(new FileReader("/Users/huj10001/Documents/systemview/log1-4/log2.log"));
//		BufferedReader br3 = new BufferedReader(new FileReader("/Users/huj10001/Documents/systemview/log1-4/log3.log"));
//		BufferedReader br4 = new BufferedReader(new FileReader("/Users/huj10001/Documents/systemview/log1-4/log4.log"));
		
		String line1, line2, line3, line4;
		Queue<String> queue1 = new LinkedList<String>();
		Queue<String> queue2 = new LinkedList<String>(); 
//		while(br1.readLine() != null || br2.readLine() != null || br3.readLine() != null || br4.readLine() != null){
//			NUM_OF_LINES++;
//		}
		String[][] log = new String[NUM_OF_FILES+1][NUM_OF_LINES];
		int index1 = 0;
		String asn1 = null;
		while((line1 = br1.readLine()) != null){			
//			queue1.add(line1);
			index1++;
			line1 = line1.replace("0>", "").trim();
			log[1][index1] = line1;
			String temp_line1 = ApiConv(line1);
			
//			if(Integer.valueOf(line1.split(",")[0],16) == 45||
//					Integer.valueOf(line1.split(",")[0],16) == 48||
//					Integer.valueOf(line1.split(",")[0],16) == 49||
//					Integer.valueOf(line1.split(",")[0],16) == 50||
//					Integer.valueOf(line1.split(",")[0],16) == 51){
//				 System.out.println(ApiConv(line1)) ;
//			}
			
//			System.out.println(line1.split(",")[0]);
			if(temp_line1.contains("ASN")){
				asn1 = line1.split(",")[2];
				ht.put(asn1, new ArrayList<String>(Arrays.asList(temp_line1,"","","")));
			}
			else{
				if(asn1 != null){
					String prev = ht.get(asn1).get(0);
					temp_line1 = prev + " | " + temp_line1;
					ht.get(asn1).set(0, temp_line1);
				}
			}
//			System.out.println("------------");
		}
//		for(String string : ht_schedule.get("20")){
//			System.out.println(string);
//		}		
//		if(checkSchedule(br1) == true){
//			System.out.println("Device1 is running on schedule.");
//		}
//		else{
//			System.out.println("Device1 has missing operations by schedule.");
//		}
//		br1.close();

		int index2 = 0;
		String asn2 = null;
//		System.out.println(ht.get("6800"));
		while((line2 = br2.readLine()) != null){		
//			queue2.add(line2);
			index2++;
			line2 = line2.replace("0>", "").trim();
			log[2][index2] = line2;
			String temp_line2 = ApiConv(line2);
			
//			if(Integer.valueOf(line2.split(",")[0],16) == 45||
////			Integer.valueOf(line2.split(",")[0],16) == 47||
//			Integer.valueOf(line2.split(",")[0],16) == 48||
//			Integer.valueOf(line2.split(",")[0],16) == 49||
//			Integer.valueOf(line2.split(",")[0],16) == 50||
//			Integer.valueOf(line2.split(",")[0],16) == 51){
//		 System.out.println(ApiConv(line2)) ;
//	}
			
			if(temp_line2.contains("ASN")){
//				System.out.println(line2.split(",")[2]);
				asn2 = line2.split(",")[2];
				if(ht.get(asn2) != null){
					ht.get(asn2).set(1, temp_line2);;
				}
				else{
				ht.put(asn2, new ArrayList<String>(Arrays.asList("",temp_line2,"","")));
				}
			}
			else{
				if(asn2 != null){
					String prev = ht.get(asn2).get(1);
					temp_line2 = prev + " | " + temp_line2;
					ht.get(asn2).set(1, temp_line2);
				}
			}
		}
//		if(checkSchedule(br2) == true){
//			System.out.println("Device2 is running on schedule.");
//		}
//		else{
//			System.out.println("Device2 has missing operations by schedule.");
//		}
//		br2.close();
//		System.out.println(ht.get("6800"));
//		ht.get("6800").add("2F,0,6800");
//		System.out.println(ht.get("6800"));
		
		int index3 = 0;
		String asn3 = null;
		while((line3 = br3.readLine()) != null){			
			index3++;
			line3 = line3.replace("0>", "").trim();
			log[3][index3] = line3;
			String temp_line3 = ApiConv(line3);
			if(temp_line3.contains("ASN")){
				asn3 = line3.split(",")[2];
				if(ht.get(asn3) != null){
					ht.get(asn3).set(2, temp_line3);
				}
				else{
					ht.put(asn3, new ArrayList<String>(Arrays.asList("","",temp_line3,"")));
				}
			}
			else{
				if(asn3 != null){
					String prev = ht.get(asn3).get(2);
					temp_line3 = prev + " | " + temp_line3;
					ht.get(asn3).set(2, temp_line3);
				}
			}
		}
//		if(checkSchedule(br3) == true){
//			System.out.println("Device3 is running on schedule.");
//		}
//		else{
//			System.out.println("Device3 has missing operations by schedule.");
//		}
//		br3.close();
		
		int index4 = 0;
		String asn4 = null;
		while((line4 = br4.readLine()) != null){			
			index4++;
			line4 = line4.replaceAll("0>", "").trim();
			log[4][index4] = line4;
			String temp_line4 = ApiConv(line4);
			if(temp_line4.contains("ASN")){
				asn4 = line4.split(",")[2];
				if(ht.get(asn4) != null){
					ht.get(asn4).set(3, temp_line4);
				}
				else{
					ht.put(asn4, new ArrayList<String>(Arrays.asList("","","",temp_line4)));
				}
			}
			else{
				if(asn4 != null){
					String prev = ht.get(asn4).get(3);
					temp_line4 = prev + " | " + temp_line4;
					ht.get(asn4).set(3, temp_line4);
				}
			}
		}
//		if(checkSchedule(br4) == true){
//			System.out.println("Device4 is running on schedule.");
//		}
//		else{
//			System.out.println("Device4 has missing operations by schedule.");
//		}
//		br4.close();
		
//		while(!queue1.isEmpty() || !queue2.isEmpty()){
//			String info1 = queue1.peek();
//			String info2 = queue2.peek();
//			String[] array1 = info1.split("\t");
//			String[] array2 = info2.split("\t");
//			int timestamp1 = Integer.valueOf(array1[1].replace(".", "").replace(" ", ""));
//			int timestamp2 = Integer.valueOf(array2[1].replace(".", "").replace(" ", ""));
//			if(timestamp1 < timestamp2){
//				System.out.println(String.format("%s:%s %30s %30s%s", array1[3], array1[4], array1[1], " ", " "));
//				System.out.println("------------------------------------------------------------------------------------------------------");
//				queue1.remove();
//			}
//			else if(timestamp1 > timestamp2){
//				System.out.println(String.format("%s%s %40s %15s:%s", " ", " ", array2[1], array2[3], array2[4]));
//				System.out.println("------------------------------------------------------------------------------------------------------");
//				queue2.remove();
//			}
//			else if(timestamp1 == timestamp2){
//				System.out.println(String.format("%s:%s %20s %10s:%s", array1[3], array1[4], array1[1], array2[3], array2[4]));
//				System.out.println("------------------------------------------------------------------------------------------------------");
//				queue1.remove();
//				queue2.remove();
//			}
//			else{	
//			}
//		}
		System.out.println("Parsing is finished.");
		
		Object[] keys = ht.keySet().toArray();
		Arrays.sort(keys);
		
		for(Object key : keys){
			char send_flow = ' ';
			char recv_flow = ' ';
			int sender = 0, receiver = 0;
			
			System.out.println(key+"\t");
			for(int i  = 0; i<ht.get(key).size(); i++){
				
//				System.out.println(ht.get(key).size());
//			System.out.println(ht.get(key).get(i));
			if(ht.get(key).get(i) != ""){
			System.out.println("Device"+(i+1)+":"+"\t"+ht.get(key).get(i));}
			if(ht.get(key).get(i).contains("RADIOSEND")){
				send_flow = ht.get(key).get(i).charAt(ht.get(key).get(i).indexOf("flow=")+5);
				sender = i+1;
			}
			if(ht.get(key).get(i).contains("RADIORECV")){
				recv_flow = ht.get(key).get(i).charAt(ht.get(key).get(i).indexOf("flow=")+5);
				receiver = i+1;
			}
			}
//			if(send_flow != -1 && recv_flow != -1){
				if(send_flow != ' ' && recv_flow != ' ' && send_flow == recv_flow){
					System.out.println("flow="+send_flow+": "+"Device"+sender+"->"+"Device"+receiver);
				}
//			}
		}
////		
		System.out.println();
//		br1.close();
		br1 = new BufferedReader(new FileReader("/Users/huj10001/Documents/311/systemview/log1-4/log1.log"));
		br2 = new BufferedReader(new FileReader("/Users/huj10001/Documents/311/systemview/log1-4/log2.log"));
		br3 = new BufferedReader(new FileReader("/Users/huj10001/Documents/311/systemview/log1-4/log3.log"));
		br4 = new BufferedReader(new FileReader("/Users/huj10001/Documents/311/systemview/log1-4/log4.log"));

		System.out.print("Device1 ");
		checkSchedule(br1);
		
		System.out.print("Device2 ");
		checkSchedule(br2);

		System.out.print("Device3 ");
		checkSchedule(br3);

		System.out.print("Device4 ");
		checkSchedule(br4);
		
		br1.close();
		br2.close();
		br3.close();
		br4.close();

		
//		System.out.println(send_flow);
//		System.out.println(recv_flow);
//		System.out.println(' ' == ' ');
//		System.out.println(ht.get("6518").get(0).contains("RADIOSEND"));
//		System.out.println(ht.get("6518").get(1).contains("RADIORECV"));
//		int temp1 = ht.get("6518").get(0).indexOf("flow=");
//		int temp2 = ht.get("6518").get(1).indexOf("flow=");
//		char flow1 = ht.get("6518").get(0).charAt(temp1+5);
//		char flow2 = ht.get("6518").get(1).charAt(temp2+5);

//		if(flow1 == flow2){
//			System.out.println("flow="+flow1+": "+"Device1"+"->"+"Device2");
//		}
	}

	private static String FileChooser() {
		File sf = null;
		JFileChooser fc = new JFileChooser();
		fc.setCurrentDirectory(new File("/Users/huj10001/Documents/311/systemview/log1-4"));
		int result = fc.showOpenDialog(new JFrame());
		if(result == fc.APPROVE_OPTION){
			sf = fc.getSelectedFile();
			System.out.println("Selected file: " + sf.getAbsolutePath());
		}
		return sf.getAbsolutePath();
	}

	private static boolean checkSchedule(BufferedReader br) throws IOException {
		String line;
		int numOp = 0;
//		Queue<String[]> queue = new LinkedList<String[]>();
		ArrayList<String[]> queue = new ArrayList<String[]>();
//		return br.readLine() != null;
		while((line = br.readLine()) != null){
			line = line.replace("0>", "").trim();
			String[] info = line.split(",");
			
//			stack.push("3");
			if(Integer.valueOf(info[0],16) == 45){
				numOp++;
				if(Integer.valueOf(info[3],16)==1){
					queue.add(info);
				}
				
				else if(Integer.valueOf(info[3],16)==2){
					queue.add(info);
				}
				else if(Integer.valueOf(info[3],16)==4){
					queue.add(info);
				}
				else if(Integer.valueOf(info[3],16)==6){
					queue.add(info);
				}
			}
			else if(Integer.valueOf(info[0],16) == 48){
				if(queue.isEmpty()){
					
				}
//				else if(Integer.valueOf(queue.peek()[3],16) == 1){
//					if(Integer.valueOf(info[1],16) == Integer.valueOf(queue.peek()[2], 16)){
//						queue.poll();
//					}
//				}
//				else{
////					result = "TX FAIL";
//				}
				for(String[] string : queue){
					if(Integer.valueOf(string[3], 16) == 1){
						if(Integer.valueOf(info[1], 16) == Integer.valueOf(string[2], 16)){
							queue.remove(string);
							break;
						}
					}
				}
			}
			else if(Integer.valueOf(info[0],16) == 49){
				if(queue.isEmpty()){
					
				}
//				else if(Integer.valueOf(queue.peek()[3],16) == 2){
//					if(Integer.valueOf(info[1],16) == Integer.valueOf(queue.peek()[2], 16)){
//						queue.poll();
//					}
//				}
//				else{
////					result = "RX FAIL";
//				}
				for(String[] string : queue){
					if(Integer.valueOf(string[3], 16) == 2){
						if(Integer.valueOf(info[1], 16) == Integer.valueOf(string[2], 16)){
							queue.remove(string);
							break;
						}
					}
				}
			}
			else if(Integer.valueOf(info[0],16) == 50){
				if(queue.isEmpty()){
					
				}
//				else if(Integer.valueOf(queue.peek()[3],16) == 6){
//					if(Integer.valueOf(info[1],16) == Integer.valueOf(queue.peek()[2], 16)){
//						queue.poll();
//					}
//				}
//				else{
////					result = "SERIALTX FAIL";
//				}
				for(String[] string : queue){
					if(Integer.valueOf(string[3], 16) == 6){
						if(Integer.valueOf(info[1], 16) == Integer.valueOf(string[2], 16)){
							queue.remove(string);
							break;
						}
					}
				}
			}
			else if(Integer.valueOf(info[0],16) == 51){
				if(queue.isEmpty()){
					
				}
//				else if(Integer.valueOf(queue.peek()[3],16) == 4){
//					if(Integer.valueOf(info[1],16) == Integer.valueOf(queue.peek()[2], 16)){
//						queue.poll();
//					}
//				}
//				else{
////					result = "SERIALRX FAIL";
//				}
				for(String[] string : queue){
					if(Integer.valueOf(string[3], 16) == 4){
						if(Integer.valueOf(info[1], 16) == Integer.valueOf(string[2], 16)){
							queue.remove(string);
							break;
						}
					}
				}
			}
		}
		if(queue.isEmpty()){
			System.out.println("is running on schedule."+"\n");
		}
		else{
			System.out.println("has " + queue.size() + "/"+numOp +" missing operations by schedule: ");
		for(String[] s : queue){
			if(Integer.valueOf(s[3],16) == 1){
				System.out.println("slotOffset="+Integer.valueOf(s[1],16)+" TX FAIL.");
			}
			else if(Integer.valueOf(s[3], 16) == 2){
				System.out.println("slotOffset="+Integer.valueOf(s[1],16)+" RX FAIL.");
			}
			else if(Integer.valueOf(s[3], 16) == 4){
				System.out.println("slotOffset="+Integer.valueOf(s[1],16)+" SERIALRX FAIL.");
			}
			else if(Integer.valueOf(s[3], 16) == 6){
				System.out.println("slotOffset=" +Integer.valueOf(s[1],16)+" SERIALTX FAIL.");
			}
		}
		System.out.println();
		}
		return queue.isEmpty();
	}


	private static String ApiConv(String token) {
		// TODO Auto-generated method stub
		String result = "";
		String[] info = token.split(",");
		switch(info[0]){
		case "21":
			return result = String.format("FRAME");
		case "22":
			return result = String.format("SLOT	slotOffset=%d ASN="+info[2], Integer.valueOf(info[1],16));
		case "23":
			return result = String.format("FSM	state="+stateConv(info[1]));
		case "2B":
			return result = String.format("TASK	id=%d v=%d slotOffset=%d", Integer.valueOf(info[1],16), Integer.valueOf(info[2],16), Integer.valueOf(info[3],16));
		case "2C":
			return result = String.format("EDF");
		case "2D":
			return result = String.format("ADDSLOT	slotOffset=%d flow=%d type="+celltypeConv(info[3]), Integer.valueOf(info[1],16), Integer.valueOf(info[2],16));
		case "2E":
			return result = String.format("RMSLOT	slotOffset=%d", Integer.valueOf(info[1],16));
		case "2F":
			return result = String.format("ACTIVESLOT	slotOffset=%d ASN="+info[2], Integer.valueOf(info[1],16));
		case "30":
			return result = String.format("RADIOSEND	flow=%d", Integer.valueOf(info[1],16));
		case "31":
			return result = String.format("RADIORECV	flow=%d", Integer.valueOf(info[1],16));
		case "32":
			return result = String.format("BRSEND	flow=%d", Integer.valueOf(info[1],16));
		case "33":
			return result = String.format("BRRECV	flow=%d", Integer.valueOf(info[1],16));
		}
		return result;
	}

	private static String stateConv(String string) {
		String result = "";
		switch(string){
		case "0":
			return result = "S_SLEEP";
		case "1":
			return result = "S_SYNCLISTEN";
		case "2":
			return result = "S_SYNCRX";
		case "3":
			return result = "S_SYNCPROC";
		case "4":
			return result = "S_TXDATAOFFSET";
		case "5":
			return result = "S_TXDATAPREPARE";
		case "6":
			return result = "S_TXDATAREADY";
		case "7":
			return result = "S_TXDATADELAY";
		case "8":
			return result = "S_TXDATA";
		case "9":
			return result = "S_RXACKOFFSET";
		case "10":
			return result = "S_RXACKPREPARE";
		case "11":
			return result = "S_RXACKREADY";
		case "12":
			return result = "S_RXACKLISTEN";
		case "13":
			return result = "S_RXACK";
		case "14":
			return result = "S_TXPROC";
		case "15":
			return result = "S_RXDATAOFFSET";
		case "16":
			return result = "S_RXDATAPREPARE";
		case "17":
			return result = "S_RXDATAREADY";
		case "18":
			return result = "S_RXDATALISTEN";
		case "19":
			return result = "S_RXDATA";
		case "20":
			return result = "S_TXACKOFFSET";
		case "21":
			return result = "S_TXACKPREPARE";
		case "22":
			return result = "S_TXACKREADY";
		case "23":
			return result = "S_TXACKDELAY";
		case "24":
			return result = "S_TXACK";
		case "25":
			return result = "S_RXPROC";
		}
		return result;
	}

	private static Object celltypeConv(String string) {
		String result = "";
		switch(string){
		case "0":
			return result = "OFF";
		case "1":
			return result = "TX";
		case "2":
			return result = "RX";
		case "3":
			return result = "TXRX";
		case "4":
			return result = "SERIALRX";
		case "5":
			return result = "MORESERIALRX";
		case "6":
			return result = "SERIALTX";	
		}
		return result;
	}

}
