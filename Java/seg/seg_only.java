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
public class seg_only {
    int pos=0;
    int len=4;
    String result="";
    ArrayList<String> dict=new ArrayList<String>();
    
    
    public static void main(String[] args)
    {
        seg_only s=new seg_only();
        s.readDict();
        s.MM("研究生命的起源.",4, 0);
        System.out.println(s.result);
    }
    
    public void MM(String source, int len, int npos)
    {//一把青菜  pos=0, len=3
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
