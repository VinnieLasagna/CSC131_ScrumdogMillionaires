package sample;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadCSV {
    public ReadCSV() {
    }

    public List<String[]> read() throws Exception {
        String line = "";
        List<String[]> arr = new ArrayList();
        String path = "C:\\Users\\Admin\\Desktop\\Java Programs\\movie app\\src\\sample\\datahubio_oscar_data_csv.csv";

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));

            while((line = br.readLine()) != null) {
                arr.add(line.split(","));

                for(int i = 0; i < arr.size(); ++i) {
                }
            }
        } catch (FileNotFoundException var6) {
            var6.printStackTrace();
        } catch (IOException var7) {
            var7.printStackTrace();
        }

        return arr;
    }

    public static void main(String[] args) throws Exception {
    }
}