/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seg;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author ����_
 */
public class seg_only {
    int pos=0;
    int len=4;
    String result="";
    ArrayList<String> dict=new ArrayList<String>();
    
    
    public static void main(String[] args)
    {
        seg_only s=new seg_only();
        s.readDict();
        s.MM("�о���������Դ.",4, 0);
        System.out.println(s.result);
    }
    
    public void MM(String source, int len, int npos)
    {//һ�����  pos=0, len=3
        int lenh=source.length();
        if(npos+1>=lenh) return;
        while((npos+len)>lenh)
        {
            len=len-1;
        }
        String substr=source.substring(npos,npos+len);
        if(dict.contains(substr))
        {
            System.out.println(substr);
            npos=npos+len;
            result=result+substr+"/ ";
            len=4;
            MM(source,len,npos);
        }
        else
        {
            if(len>=1)
            {
                len=len-1;
                MM(source,len,npos);
            }
        }
        
    }
    public String getResult() {
        return result;
    }
    public void readDict() {//���ֵ��е����ݷŵ������У���ʱ�����Ǳ�ע    
        try 
        {
            File directory = new File(".");
            String path=directory.getCanonicalPath()+"\\chineseDic.txt";
            System.out.println(path);
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String elements[] = line.trim().split(",");//�з�
                dict.add(elements[0]);//ֻ��ȡ�����ӵ�dict�б���
                //System.out.println(elements[0]);
            }
            br.close();
            fr.close();
        }
        catch (Exception ex) 
        {
        }
    }
}
