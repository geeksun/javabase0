package com.base.data;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 姜志强
 * 1. 企业分类数据
 * 2. 把文本数据变成 sql 并写入数据库里
 * // insert into industry (id,name,fid,language) values(1,'--工 业 品--',null,0); 
 */
public class FileMain {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String filePath  =   " t.txt " ; 
        Pattern pattern  =  Pattern.compile( " ^[0-9]+\\.(.+) " );
        
        InputStreamReader read  =   new  InputStreamReader(
                 new  FileInputStream(
                        FileMain. class .getClassLoader().getResource(filePath).getPath()), " UTF-8 " 
        );
        
        StringBuffer buffer  =   new  StringBuffer();
        
        BufferedReader reader  =   new  BufferedReader(read); 
        String stmp  =   null ;
         int  titleii  =   0  ;
         while((stmp = reader.readLine()) != null && !stmp.trim().equals("")){
            Matcher matcher  =  pattern.matcher(stmp) ;
             if ( matcher.find()){
                titleii ++  ;
                buffer.append( " \n\n " );
                buffer.append(getIndustryInsertSql(titleii + "" ,matcher.group( 1 ), " null " , " 0 " ));
                      while ((stmp = reader.readLine()) != null && ! stmp.trim().equals("") && 
                                      ! pattern.matcher(stmp).find() ){
                          int  cii  =   0  ;
                          for (String csql : stmp.split( " \\| " )){
                              if (csql != null   &&   ! csql.trim().equals( "" ))
                                 buffer.append(getIndustryInsertSql( (titleii + 10000 ) + "" + ( ++ cii) ,csql.trim(),titleii + "" , " 0 " ));
                         }
                  }
            }
        }
        System.out.println( buffer );
    }
    
     /**
     * @param id
     * @param name
     * @param fid
     * @param language
     * @return  获得插入的 sql 语句
     */
    public  static  String getIndustryInsertSql(String id,String name,String fid,String language){
        String sqlt  =   " insert into industry (id,name,fid,language) values(:id,':name',:fid,:language);\n " ;
        sqlt  =  sqlt.replaceAll( " :id " , id);
        sqlt  =  sqlt.replaceAll( " :name " , name);
        sqlt  =  sqlt.replaceAll( " :fid " , fid);
        sqlt  =  sqlt.replaceAll( " :language " ,language);
        
        return  sqlt ;
    }
}
