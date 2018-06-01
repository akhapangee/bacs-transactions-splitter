package com.akhilesh;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
@author Akhilesh
 */
public class BacsTransactionSplitter {

    public static void split(String content, int txnPerSplit, String splitFileName, String parentFileName,String fileExtenstion) throws IOException {
        java.io.InputStream inputStream = new java.io.ByteArrayInputStream(content.getBytes(java.nio.charset.Charset.forName("UTF-8")));
        java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(inputStream));
        if (bufferedReader.readLine() != null) {
            int lineLength = bufferedReader.readLine().length() + 2;

            int startIndex = 0;
            int endIndex = lineLength * txnPerSplit;
            StringBuilder currentMessage = new StringBuilder();

            int parentFileNumber = 1;
            int splitFileNumber = 1;
            boolean processComplete = false;

            while (!processComplete && txnPerSplit > 0) {
                File splitFile = new File(splitFileName + (splitFileNumber++) + fileExtenstion);
                File parentFile = new File(parentFileName + (parentFileNumber++) + fileExtenstion);
                if (endIndex >= content.length()) {
                    currentMessage.append(content.substring(startIndex));
                    content = "";
                    processComplete = true;
                } else {
                    currentMessage.append(content.substring(startIndex, endIndex));
                    startIndex = endIndex;
                    endIndex += startIndex;
                }
                if (!processComplete) {
                    content = content.substring(startIndex);
                    startIndex = 0;
                    endIndex = lineLength * txnPerSplit;
                }
                if (!String.valueOf(currentMessage).isEmpty()) {
                    try (FileWriter fw = new FileWriter(splitFile); BufferedWriter writer = new BufferedWriter(fw)) {
                        writer.write(currentMessage.toString());
                        currentMessage.delete(0, currentMessage.length());
                    }
                }
                if (!content.isEmpty()) {
                    try (FileWriter fw = new FileWriter(parentFile); BufferedWriter writer = new BufferedWriter(fw)) {
                        writer.write(content);
                    }
                }
            }

        }
    }
}
