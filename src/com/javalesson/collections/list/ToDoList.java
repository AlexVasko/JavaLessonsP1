package com.javalesson.collections.list;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class ToDoList  {

   private LinkedList<String> toDoList = new LinkedList<>();


   public void addToList(String task){
//       toDoList.add(task);
       addInAlphabeticalOrder(task);
   }

   private boolean addInAlphabeticalOrder(String task){
       ListIterator<String> listIter = toDoList.listIterator();
       while (listIter.hasNext()){
           int compared = listIter.next().compareTo(task);
           if(compared == 0 ){
               System.out.println("Task already exists in the list");
               return true;
           } else if (compared > 0){
               listIter.previous();
               listIter.add(task);
               return true;
           }
       }
       toDoList.add(task);
       return true;
   }



   public void addToListAtPosition(int position, String task){
       toDoList.add(position,task);
   }

   public void printToDoList(){
//       for(int i=0; i<toDoList.size(); i++){
//           System.out.println(i+" - "+toDoList.get(i));
//       }
       Iterator<String> iterator = toDoList.iterator();
       while (iterator.hasNext()){
           System.out.println("Element "+iterator.next());
       }
   }

   public void changeTask(int index, String newTask){
       toDoList.set(index, newTask);
   }

   public void  removeTask(String task){
       toDoList.remove(task);
   }

   public int getTaskPriority(String task){
       return toDoList.indexOf(task);
   }





}
