/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3dprintingrobot;

/**
 *
 * @author Dom
 */
    public class Direction {
      public String name;
      public Integer deltaRow;
      public Integer deltaCol;
   
       public Direction (String name, Integer dRow, Integer dCol){
         this.name = name;
         this.deltaRow = dRow;
         this.deltaCol = dCol;
      }
   
       public Integer getDeltaRow(){
         return this.deltaRow;}
   
       public Integer getDeltaCol(){
         return this.deltaCol;}
   
       public String getName(){
         return this.name;}
   
       public String toString(){
         return this.name+"\t"+this.deltaRow+"\t"+this.deltaCol;
      }
   }