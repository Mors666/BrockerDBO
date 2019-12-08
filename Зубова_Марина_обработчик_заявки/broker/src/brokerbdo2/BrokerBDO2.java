/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brokerbdo2;

import java.awt.List;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

 

/**
 *
 * @author user
 */
public class BrokerBDO2 {
    public static Map<String, ArrayList<Double>> banks = new HashMap<>();
     public static double[] weights = new double[5];
      
     
     
    @SuppressWarnings("empty-statement")
     public static void importPhysics() throws FileNotFoundException, IOException{
         weights[0]=0.438026785828152;
         weights[1]=0.219013392914076;
              weights[2]=0.0876053571656304;
                 weights[3]=0.145847767635104;
                 weights[4]=0.109506696457038;
        
          banks.clear();
          HSSFWorkbook myExcelBook = new HSSFWorkbook(new FileInputStream("banks.xls"));
          HSSFSheet myExcelSheet = myExcelBook.getSheet("ФЛ");
          for(int i = 0;i<=myExcelSheet.getLastRowNum();i++){
               HSSFRow   row1 = myExcelSheet.getRow(i);
                ArrayList <Double> info = new ArrayList<>();
                      String key = null;
                      key = row1.getCell(0).getStringCellValue();
		        
                           for (int j=1; j<row1.getLastCellNum();j++){
			  //if(row1.getCell(j).getStringCellValue()!=null){
		             info.add(Double.parseDouble(row1.getCell(j).toString()));//.getStringCellValue()));
		 //       }
                 }
                            banks.put(key, info);
          }
         
     }
     
      public static void importJuridical() throws FileNotFoundException, IOException{
            weights[0]=0.145847768;
                    weights[1]=0.219013393;
              weights[2]=0.438026786;
                 weights[3]=0.109506696;
                 weights[4]=0.087605357;
           banks.clear();
          HSSFWorkbook myExcelBook = new HSSFWorkbook(new FileInputStream("banks.xls"));
          HSSFSheet myExcelSheet = myExcelBook.getSheet("ЮЛ");
          for(int i = 0;i<=myExcelSheet.getLastRowNum();i++){
               HSSFRow   row1 = myExcelSheet.getRow(i);
                ArrayList <Double> info = new ArrayList<>();
                      String key = null;
                      key = row1.getCell(0).getStringCellValue();
		        
                           for (int j=1; j<row1.getLastCellNum();j++){
			  //if(row1.getCell(j).getStringCellValue()!=null){
		             info.add(Double.parseDouble(row1.getCell(j).toString()));//.getStringCellValue()));
		 //       }
                 }
                            banks.put(key, info);
          }
     }
      
      
      public static void importCorporative() throws FileNotFoundException, IOException{
            weights[0]= 0.109506696;
         weights[1]=0.219013393;
              weights[2]=0.438026786;
                 weights[3]=0.145847768;
                 weights[4]=0.087605357;
          banks.clear();
          HSSFWorkbook myExcelBook = new HSSFWorkbook(new FileInputStream("banks.xls"));
          HSSFSheet myExcelSheet = myExcelBook.getSheet("К");
          for(int i = 0;i<=myExcelSheet.getLastRowNum();i++){
               HSSFRow   row1 = myExcelSheet.getRow(i);
                ArrayList <Double> info = new ArrayList<>();
                      String key = null;
                      key = row1.getCell(0).getStringCellValue();
		        
                           for (int j=1; j<row1.getLastCellNum();j++){
			  //if(row1.getCell(j).getStringCellValue()!=null){
		             info.add(Double.parseDouble(row1.getCell(j).toString()));//.getStringCellValue()));
		 //       }
                 }
                            banks.put(key, info);
          }
     }
      
      
      
       public  static Map<Double, String> getBanks( ArrayList<Integer> criteriaChosen){
            Map< Double, String> answer = new TreeMap<>(Collections.reverseOrder());
            //Double newValue = 0.0;
          for (Map.Entry<String, ArrayList<Double>> entry : banks.entrySet()) {
             Double newValue = 0.0;
              for (int i=0; i<criteriaChosen.size();i++){
              newValue += entry.getValue().get(criteriaChosen.get(i))*weights[criteriaChosen.get(i)];
              }
              //newValue = 0.0
              answer.put(newValue,entry.getKey());
          }
            
            return answer;
       }
      
      
    
     
  
		 
		  
         
             
          
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
       // StartJPanel startJPanel;
        new StartJFrame().setVisible(true);
         
         //allCriteriaChosen(physicsCriteria);
    }
    
}
