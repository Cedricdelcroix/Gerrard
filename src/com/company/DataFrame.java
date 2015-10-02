package com.company;

import sun.font.AttributeValues;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by cedric on 02/10/15.
 */
public class DataFrame {
    private String fileName = "save.txt";
    private String money;
    private ArrayList<Player> playersToBuy;
    private ArrayList<Player> playerSell;

    public ArrayList<Player> getPlayersToBuy() {
        return playersToBuy;
    }

    public ArrayList<Player> getPlayerSell() {
        return playerSell;
    }

    public String makeContent(int money, ArrayList<Player> playersToBuy, ArrayList<Player> playerSell){
        String content="";
        content += "money:"+ money+"\n";
        if (!playersToBuy.isEmpty()){
            content+="PlayerToBuy:";
        }
        for (Player p : playersToBuy){
            content+=p.getName()+","+p.getAvgPrice()+","+p.getBuyPrice()+","+p.getSellprice()+";";
        }
        content+="\n";
        if (!playerSell.isEmpty()){
            content+="PlayerSell:";
        }
        for (Player p : playerSell){
            content+=p.getName()+","+p.getAvgPrice()+","+p.getBuyPrice()+","+p.getSellprice()+";";
        }
        return content;
    }
    public void writeFile(int money, ArrayList<Player> playersToBuy, ArrayList<Player> playerSell){
        try {
            String content = makeContent(money,playersToBuy,playerSell);
            File file = new File(fileName);
            if(!file.exists()){
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fileWriter);
            bw.write(content);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void readFile() {
        try {
            File f = new File(fileName);
            FileReader fileReader = new FileReader(f);
            BufferedReader bf = new BufferedReader(fileReader);
            playersToBuy = new ArrayList<Player>();
            playerSell = new ArrayList<Player>();
            while (true){
                String line = bf.readLine();
                    if (line!=null){
                    if (line.startsWith("money")) {
                        this.money = line.replace("money:", "");
                    } else if (line.startsWith("PlayerToBuy")) {
                        line = line.replace("PlayerToBuy:", "");
                        String[] data = line.split(";");
                        for (String s : data) {
                            String name = s.split(",")[0];
                            String avgPrice = s.split(",")[1];
                            String buyPrice = s.split(",")[2];
                            String sellPrice = s.split(",")[3];
                            playersToBuy.add(new Player(name, Integer.parseInt(avgPrice), Integer.parseInt(buyPrice), Integer.parseInt(sellPrice)));
                        }
                    } else if (line.startsWith("PlayerSell")) {
                        line = line.replace("PlayerSell:", "");
                        String[] data = line.split(";");
                        for (String s : data) {
                            String name = s.split(",")[0];
                            String avgPrice = s.split(",")[1];
                            String buyPrice = s.split(",")[2];
                            String sellPrice = s.split(",")[3];
                            playerSell.add(new Player(name, Integer.parseInt(avgPrice), Integer.parseInt(buyPrice), Integer.parseInt(sellPrice)));

                        }
                    }
                    }else {
                        break;
                    }
                }

        } catch (FileNotFoundException exception) {
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
