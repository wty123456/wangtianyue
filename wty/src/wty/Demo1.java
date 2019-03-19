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
		sb2=getFile();//StringBuffer文件读入
		
		
		 
      //单词截取
		 List<String> lists = new ArrayList<String>();  //存储过滤后单词的列表  
	          String str2 = sb2.toString();
	            String[] wordsArr1 = str2.split("[^a-zA-Z]");  //过滤出只含有字母的  
	            for (String word : wordsArr1) {  
	                if(word.length() != 0){  //去除长度为0的行 
	                	System.out.println(word);
	                    lists.add(word);  
	                }  
	            }  
	        
 
 
 
	
		 
		 for(String str: lists) {//单词计数加入TreeMap
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
		 
		 Set<StringBuffer> ks1 = ts.keySet();//遍历TreeMap
		 for(StringBuffer s2:ks1) {
			 System.out.println("单词："+s2.toString()+"            出现次数："+ts.get(s2));
			 try {
				setFile ("单词："+s2.toString()+"            出现次数："+ts.get(s2));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
		 }
		System.out.println("文件成功读入到指定路径下");//
	}
	//  sadsfsafas  saasfsa  sdasdsad   sdsadsadas
	public static StringBuffer getFile () { //文件读入函数
		String str=null;//定义一个字符串类型变量str
		StringBuffer sb1=  new  StringBuffer();
		try {//try代码块，当发生异常时会转到catch代码块中
            //读取指定的文件
            BufferedReader in = new BufferedReader(new FileReader("src/1.txt"));
            
            while ((str = in.readLine())!= null) {//readLine()方法, 用于读取一行,只要读取内容不为空就一直执行
               
            	sb1.append(str);
            }
            in.close();
           
        } catch (IOException e) {//当try代码块有异常时转到catch代码块
        	System.out.println("读取有误");
            e.printStackTrace();//printStackTrace()方法是打印异常信息在程序中出错的位置及原因
        }
		System.out.println(sb1);//输出sb1
		return sb1; 
		 
	}
public static void setFile (String s) throws IOException { //文件写入函数
		               byte[] bs = s.getBytes();//定义字节数组用来当作缓冲区
		                 
		
		FileOutputStream fos=new FileOutputStream("src/result.txt");
		
	        try {
				fos.write(bs);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//从缓冲区字节数组中以字节流形式取出
	        fos.close();//关闭读取流
	        
	        
	        File file=new File("src/result.txt");//创建文件对象
	        if(file.exists()){//if语句的条件，调用exists方法判断文件是否存在
	            // System.out.println("文件成功读入到指定路径下");//若文件存在，则输出文件存在
	        }
	        else{//否则
	             System.out.println("输出文件不存在");//输出文件不存在
	        }
		
		
	}
	
}
