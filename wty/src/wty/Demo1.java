package wty;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
 

public class Demo1 {
 
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		TreeMap<StringBuffer,String > ts = new TreeMap<StringBuffer,String>(new Comparator<StringBuffer>(){
			@Override
			public int compare(StringBuffer sb1,StringBuffer sb2 ) {
				if(sb1==null&&sb2==null) {
					return 1;
				}
				
				
			
				String str1 = sb1.toString();
				String str2 = sb2.toString();
				if (str1.compareTo(str2)>0) {
					return 1;
					
				}else if (str1.compareTo(str2)<0) {
					return -1;
				}else{//(str1.compareTo(str2)=0)
					return 0;
				}
			}
	
		});
		StringBuffer sb2=  new  StringBuffer();
		sb2=getFile();//StringBuffer�ļ�����
		
		
		 
      //���ʽ�ȡ
		 List<String> lists = new ArrayList<String>();  //�洢���˺󵥴ʵ��б�  
	          String str2 = sb2.toString();
	            String[] wordsArr1 = str2.split("[^a-zA-Z]");  //���˳�ֻ������ĸ��  
	            for (String word : wordsArr1) {  
	                if(word.length() != 0){  //ȥ������Ϊ0���� 
	                	System.out.println(word);
	                    lists.add(word);  
	                }  
	            }  
	        
 
 
 
	
		 
		 for(String str: lists) {//���ʼ�������TreeMap
			  //System.out.print(s1+"=");
			 // System.out.println( hm.get(s1));
			  StringBuffer s2 = new StringBuffer( str);
			  int cout=1;
			  if (ts.containsKey(s2)) {
				  
				  cout++;
				  ts.put(s2, Integer.toString(cout));
			  }else {
				 
				  ts.put(s2, Integer.toString(cout));
			  }
			 
		  }
		 
		 Set<StringBuffer> ks1 = ts.keySet();//����TreeMap
		 for(StringBuffer s2:ks1) {
			 System.out.println("���ʣ�"+s2.toString()+"            ���ִ�����"+ts.get(s2));
			 try {
				setFile ("���ʣ�"+s2.toString()+"            ���ִ�����"+ts.get(s2));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
		 }
		System.out.println("�ļ��ɹ����뵽ָ��·����");//
	}
	//  sadsfsafas  saasfsa  sdasdsad   sdsadsadas
	public static StringBuffer getFile () { //�ļ����뺯��
		String str=null;//����һ���ַ������ͱ���str
		StringBuffer sb1=  new  StringBuffer();
		try {//try����飬�������쳣ʱ��ת��catch�������
            //��ȡָ�����ļ�
            BufferedReader in = new BufferedReader(new FileReader("src/1.txt"));
            
            while ((str = in.readLine())!= null) {//readLine()����, ���ڶ�ȡһ��,ֻҪ��ȡ���ݲ�Ϊ�վ�һֱִ��
               
            	sb1.append(str);
            }
            in.close();
           
        } catch (IOException e) {//��try��������쳣ʱת��catch�����
        	System.out.println("��ȡ����");
            e.printStackTrace();//printStackTrace()�����Ǵ�ӡ�쳣��Ϣ�ڳ����г����λ�ü�ԭ��
        }
		System.out.println(sb1);//���sb1
		return sb1; 
		 
	}
public static void setFile (String s) throws IOException { //�ļ�д�뺯��
		               byte[] bs = s.getBytes();//�����ֽ�������������������
		                 
		
		FileOutputStream fos=new FileOutputStream("src/result.txt");
		
	        try {
				fos.write(bs);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//�ӻ������ֽ����������ֽ�����ʽȡ��
	        fos.close();//�رն�ȡ��
	        
	        
	        File file=new File("src/result.txt");//�����ļ�����
	        if(file.exists()){//if��������������exists�����ж��ļ��Ƿ����
	            // System.out.println("�ļ��ɹ����뵽ָ��·����");//���ļ����ڣ�������ļ�����
	        }
	        else{//����
	             System.out.println("����ļ�������");//����ļ�������
	        }
		
		
	}
	
}
