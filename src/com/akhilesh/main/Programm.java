package com.akhilesh.main;

import com.akhilesh.BacsTransactionSplitter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author Akhilesh
 */
public class Programm {

    public static void main(String[] args) throws IOException {
        //give file name here
        String fileName = "files/bacs split/STD18_daily_test_with txns only.txt";
        String content = new String(Files.readAllBytes(Paths.get(fileName)));
        
        //set transactions per split
        int txnPerSplit = 2;
        String splitFileName = "files/bacs split/output/_split";
        String parentFileName = "files/bacs split/output/parent";
        String fileExtenstion = ".txt";
        
        BacsTransactionSplitter.split(content, txnPerSplit, splitFileName, parentFileName, fileExtenstion);
       
    }
}
