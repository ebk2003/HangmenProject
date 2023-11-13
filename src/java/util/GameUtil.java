/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author USER
 */
public class GameUtil{
    static List<String> sentences=new ArrayList<>();
   public static String sentence;
    public static  StringBuilder sentenceToShow;
    public static int numOfTryings;
    static{
        sentences.add("sari");
        sentences.add("chani");
        sentences.add("malki");
        sentences.add("home");
        sentences.add("have a gooday");
        sentences.add("coffe");
        sentences.add("ester");
        sentences.add("good morning");
        chooseSentence();
        initSentenceToShow();
    }
    public static void chooseSentence(){
        Random rand = new Random();
        int num=rand.nextInt(sentences.size());
        sentence=sentences.get(num);
        
    }
    
    public static void initSentenceToShow(){
        sentenceToShow=new StringBuilder();
    
        for (int i = 0; i < sentence.length(); i++){
            if(sentence.charAt(i)==' '){
                sentenceToShow.append(" ");
            }
            else{
            sentenceToShow.append("-");
            }
            
        }
    }
    
    public static void updateSentenceToShow(char letter){
        
        for (int i = 0; i < sentence.length(); i++) {
          if( sentence.charAt(i) == letter || sentence.charAt(i) == ' ')
                sentenceToShow.setCharAt(i, letter);
        }
    }
        
    
     public static void increaseNumOfTryings(){
         numOfTryings++;
     }
         
     public boolean checkWinning(){
         for (int i = 0; i < sentenceToShow.length(); i++) {
             if(sentenceToShow.charAt(i)=='-'){
                 return false;
             }
         }
         return true;
     } 
}
