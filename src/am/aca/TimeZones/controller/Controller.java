package am.aca.TimeZones.controller;

import am.aca.TimeZones.comman.model.CustomComparator;
import am.aca.TimeZones.comman.model.Zone;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static am.aca.TimeZones.util.Constants.PATH;
import static am.aca.TimeZones.util.Constants.ZONE;

/**
 * Created by Armen on 4/12/2017.
 */

class Controller {
    void execute() throws IOException {
        List<Zone> data = fileRead();

        System.out.println("@st inchi sortavrel " +
                "\n 1: By Country code " +
                "\n 2: By Time Zone");
        Scanner input = new Scanner(System.in);

        int inputByUser = input.nextInt();
        switch (inputByUser) {
            case 1:
                data.sort(new CustomComparator.CompareByCountryCode());
                printSortedZones(data);
                break;
            case 2:
                data.sort(new CustomComparator.CompareByTimeZone());
                printSortedZones(data);
                break;
        }
    }

    private List<Zone> fileRead() throws IOException {
        FileReader timeZonesFromFile = new FileReader(PATH + ZONE);
        BufferedReader fileReader = new BufferedReader(timeZonesFromFile);
        String tempString;
        List<Zone> zones = new ArrayList<>();
        while ((tempString = fileReader.readLine()) != null) {
            Zone tempZone = new Zone();
            tempString = tempString.replace('"', ' ');
            tempString =tempString.replaceAll("\\s+","");


            String[] getLineFromFile = tempString.split(",");

            tempZone.setID(getLineFromFile[0]);
            tempZone.setCountryCode(getLineFromFile[1]);
            tempZone.setTimeZone(getLineFromFile[2]);

            zones.add(tempZone);
        }
        timeZonesFromFile.close();
        return zones;
    }

    private void printSortedZones(List<Zone> zones) {
        for (Zone zone : zones) {
//            System.out.println(String.format("%-20s= %s" , zone.getID(), zone.getCountryCode() ));
            System.out.println(zone.getID() + " " + zone.getCountryCode() + " " + zone.getTimeZone());
        }
    }
}
