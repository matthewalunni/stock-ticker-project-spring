package com.StockTickerProject.model;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

@Service
public class StockTickerDataService {

    List<StockTickerEntry> DB;

    public StockTickerDataService() {
        DB = new ArrayList<>();
        try {
            String _path = "src/main/java/com/StockTickerProject/model/dow_jones_index.data";
            FileInputStream fis = new FileInputStream(_path);
            UploadFileData(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * UploadFileData reads data from file and converts it to a collection of StockTickerEntry objects
     * to be added to the DB
     * Note that for this to be successful the file must have a header line
     * @param fis file to be read
     * @throws FileNotFoundException
     */
    private void UploadFileData(FileInputStream fis) throws FileNotFoundException {
        try {
            Scanner sc = new Scanner(fis);
            sc.nextLine(); // to skip headers
            while (sc.hasNextLine()) {
                String nextLine = sc.nextLine();
                String[] line = nextLine.split(",");
                for (int i = 0; i < line.length; i++) {
                    if (line[i].contains("$")) {
                        line[i] = line[i].replace("$", "");
                    }
                    if (line[i].isEmpty() || line[i].isBlank()) {
                        line[i] = "0";
                    }
                }

                StockTickerEntry ste = new StockTickerEntry(
                        UUID.randomUUID(),
                        line[0],
                        line[1],
                        line[2],
                        line[3],
                        line[4],
                        line[5],
                        line[6],
                        line[7],
                        line[8],
                        line[9],
                        line[10],
                        line[11],
                        line[12],
                        line[13],
                        line[14],
                        line[15]
                );
                DB.add(ste);
            }
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public List<StockTickerEntry> getAllStockTickerData() {
        return DB;
    }

    public void uploadSubmit(StockTickerEntry stockTickerEntry) {
        DB.add(stockTickerEntry);
    }

    public void uploadManySubmit(MultipartFile file) throws IOException {
        UploadFileData((FileInputStream) file.getInputStream());
    }
}
