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
 * @author 高佬_
 */
public class seg_RMM {
    int pos=0;
    int len=4;
    String result="";
    ArrayList<String> dict=new ArrayList<String>();
    
    
    public static void main(String[] args)
    {
        seg_RMM s=new seg_RMM();
        s.readDict();
        String a = "研究生命的起源.";
        int lenh = a.length();
        s.RMM(a ,4, lenh-1);
        System.out.println(s.result);
    }
    
    public void RMM(String source, int len, int npos)
    {
        if(npos-1<0) return;
        while((npos-len)<0)
        {
            len=len-1;
        }
        String substr=source.substring(npos-len,npos);
        if(dict.contains(substr))
        {
            System.out.println(substr);
            npos=npos-len;
            result=substr+"/ "+result;
            len=4;
            RMM(source,len,npos);
        }
        else
        {
            if(len>=1)
            {
                len=len-1;
                RMM(source,len,npos);
            }
        }
        
    }
    public String getResult() {
        return result;
    }
    public void readDict() {//将字典中的内容放到容器中，暂时不考虑标注    
        try 
        {
            File directory = new File(".");
            String path=directory.getCanonicalPath()+"\\chineseDic.txt";
            System.out.println(path);
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String elements[] = line.trim().split(",");//切分
                dict.add(elements[0]);//只获取词语，添加到dict列表中
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
