/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seg;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class readfile {
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        File directory = new File(".");
        String path=directory.getCanonicalPath()+"\\hello.txt";
        File f=new File(path);
        FileReader fs=new FileReader(f);
        BufferedReader bf=new BufferedReader(fs);
        String line;
            while ((line = bf.readLine()) != null) 
            {
                //String elements[] = line.trim().split(",");//�з�
                //dict.add(elements[0]);//ֻ��ȡ�����ӵ�dict�б���
                System.out.println(line);
            }
            bf.close();
            fs.close();        
        //System.out.println(bf.readLine());
        
    }
}
