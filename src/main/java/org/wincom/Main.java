package org.wincom;

import java.util.*;


public class Main {
    public static void main(String[] args) {


        String [] keywords = {"Pandora", "Pinterest", "Paypal", "Pg&e", "Project free tv", "Priceline", "Press democrat", "Progressive", "Project runway",
                "Proactive", "Programming", "Progeria", "Progesterone", "Progenex", "Procurable", "Processor", "Proud", "Print", "Prank",
                "Bowl", "Owl", "River", "Phone", "Kayak", "Stamps", "Reprobe"};

        KeywordsFilter keywordsFilter = new KeywordsFilter(keywords);

        System.out.println("Hello Wincom team :) ");
        System.out.println("Please, type any letter/letters or exit to finish");
        Scanner scanner = new Scanner(System.in);

        while(true) {
           System.out.print("> ");
           String param = scanner.nextLine();
           if (param.equals("exit")) {
               break;
           }
           if (!param.trim().isEmpty()) {
               List<String> result = keywordsFilter.filterBy(param);

               if (result.isEmpty()) {
                   System.out.println("Word no available");
               }
               else {
                   System.out.println(result);
               }
           }else{
               System.out.println("You have to write a character");
           }
       }

    }
}