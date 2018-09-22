package com.javalesson.collections.list;

public class Note {
//    ArrayList
//    ElementNumber Address Int element
//    0             10000   100
//    1             10004   200
//    2             10008   300
//    3             10012   400
//    4             10016   900
//    5             10020   500
//    6             10024   600
//    7             10028   700   O(n)
//    8             10032   800


//      LinkedList
//      ElementNumber    Address   StringElement
//           0             10000     January -----
//           ^                                    |
//           |                                    |
//           1             20010     February <----
//           ^                                    |
//           |                                    |
//           2             15000     March <------|
//           ^                                    |
//           |                                    |
//           4             20010     May   <------
//           5             15000     June
//           6             10000     July
//           7             20010     August
//           8             15000     September
//           9             10000     October
//           10            20010     November
//           11            15000     December

}
   /* private boolean addInAlphabeticalOrder(String task){
        ListIterator<String> listIter = toDoList.listIterator();
        while (listIter.hasNext()){
            int compared = listIter.next().compareTo(task);
            if(compared == 0){
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
    }*/