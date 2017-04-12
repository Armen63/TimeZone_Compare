package am.aca.TimeZones.controller;

import am.aca.TimeZones.comman.model.CompareByConutryCode;
import am.aca.TimeZones.comman.model.CompareByTimeZone;
import am.aca.TimeZones.comman.model.Zone;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Armen on 4/12/2017.
 */
public class Controller {
    public void execute() throws IOException {

        FileReader timeZonesFromFile = new FileReader("C:\\Users\\Armen\\IdeaProjects\\TimeZone\\src\\am\\aca\\TimeZones\\resource\\zone.csv");
        BufferedReader fileReader = new BufferedReader(timeZonesFromFile);
        String tempString;
        Zone[] zones = new Zone[424];
        int i = 0;
        while((tempString = fileReader.readLine()) != null){
            tempString = tempString.replace('"', ' ');

            String [] getLineFromFile = tempString.split(",");
            zones[i] = new Zone();

            zones[i].setID(getLineFromFile[0]);
            zones[i].setCountryCode(getLineFromFile[1]);
            zones[i].setTimeZone(getLineFromFile[2]);

            i += 1;
        }
        timeZonesFromFile.close();
        System.out.println("@st inchi sortavrel " +
                "\n 1: By Country code " +
                "\n 2: By Time Zone" );
        Scanner input = new Scanner(System.in);
        int inputByUser = input.nextInt();

        switch (inputByUser) {
            case 1:
                Arrays.sort(zones, new CompareByConutryCode());
                printSortedCountries(zones);
                break;
            case 2:
                Arrays.sort(zones, new CompareByTimeZone());
                printSortedCountries(zones);
                break;

        }
    }
    public void printSortedCountries(Zone[] zones){
        for (Zone zone : zones) {
            System.out.println(zone.getID()+ " " + zone.getCountryCode() + " " + zone.getTimeZone());
        }
    }
}
