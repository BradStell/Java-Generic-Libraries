package com.ultronicsystems.library.textprocessing;

import java.io.*;
import java.util.*;

/**
 * Created by Ace on 2/7/15.
 */
public class LineByLineRegex {


    public void removeDuplicates(String filename){
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filename));

        Set<String> lines = new HashSet<String>(10000); // maybe should be bigger
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        reader.close();
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        for (String unique : lines) {
            writer.write(unique);
            writer.newLine();
        }
        writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    public void stripPatternRemoveDupes(String pattern, String file){
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));

            Set<String> lines = new HashSet<String>(10000); // maybe should be bigger
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line.replaceAll(pattern,""));
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for (String unique : lines) {
                writer.write(unique);
                writer.newLine();
            }
            writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public void reverseCommaNames(String file){
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));

            Set<String> lines = new HashSet<String>(10000); // maybe should be bigger
            String line;

            while ((line = reader.readLine()) != null) {

                if(line.contains(",")) {
                    String[] names = line.split(",");
                    System.out.println(line);

                    String name = "";

                    for (int i = names.length-1; i >= 0; i--) {
                        name = name + names[i] + " ";
                    }

                    lines.add(name);

                }
            }

            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for (String unique : lines) {
                writer.write(unique);
                writer.newLine();
            }
            writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public void sortTextFile(String file){
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));

            ArrayList<String> lines = new ArrayList<String>(10000); // maybe should be bigger
            String line;

            while ((line = reader.readLine()) != null) {
                    lines.add(line);
                }


            Collections.sort(lines,new SampleComparator());

            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for (String unique : lines) {
                writer.write(unique);
                writer.newLine();
            }
            writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

    }


    class SampleComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    }


}
