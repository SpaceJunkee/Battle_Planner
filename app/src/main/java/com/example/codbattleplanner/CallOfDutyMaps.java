package com.example.codbattleplanner;

import java.util.ArrayList;

/**
 * Code written by Kevin Sandy
 * https://github.com/SpaceJunkee
 */
public class CallOfDutyMaps {

    //Gunfight image/names
    public String[][] returnGunFightImagesAndNames(){
        String[][] gunFightImagesAndNames = new String[7][2];

        gunFightImagesAndNames[0][0] = "https://gamewith-en.akamaized.net/img/fd2c975d21cf975979b1389004238b90.jpg";
        gunFightImagesAndNames[1][0] = "https://gamewith-en.akamaized.net/img/fd2c975d21cf975979b1389004238b90.jpg";
        gunFightImagesAndNames[2][0] = "https://gamewith-en.akamaized.net/img/fd2c975d21cf975979b1389004238b90.jpg";
        gunFightImagesAndNames[3][0] = "https://gamewith-en.akamaized.net/img/fd2c975d21cf975979b1389004238b90.jpg";
        gunFightImagesAndNames[4][0] = "https://gamewith-en.akamaized.net/img/fd2c975d21cf975979b1389004238b90.jpg";
        gunFightImagesAndNames[5][0] = "https://gamewith-en.akamaized.net/img/fd2c975d21cf975979b1389004238b90.jpg";
        gunFightImagesAndNames[6][0] = "https://gamewith-en.akamaized.net/img/fd2c975d21cf975979b1389004238b90.jpg";
        gunFightImagesAndNames[0][1] = "Gulag Showers";
        gunFightImagesAndNames[1][1] = "Docks";
        gunFightImagesAndNames[2][1] = "King";
        gunFightImagesAndNames[3][1] = "Pine";
        gunFightImagesAndNames[4][1] = "Speedball";
        gunFightImagesAndNames[5][1] = "Stack";
        gunFightImagesAndNames[6][1]= "Hill";

        return gunFightImagesAndNames;
    }

    public String[][] returnDominationImagesAndNames(){
        String[][] dominationImagesAndNames = new String[10][2];

        dominationImagesAndNames[0][0] = "https://gamewith-en.akamaized.net/img/fd2c975d21cf975979b1389004238b90.jpg";
        dominationImagesAndNames[1][0] = "https://gamewith-en.akamaized.net/img/fd2c975d21cf975979b1389004238b90.jpg";
        dominationImagesAndNames[2][0] = "https://gamewith-en.akamaized.net/img/fd2c975d21cf975979b1389004238b90.jpg";
        dominationImagesAndNames[3][0] = "https://gamewith-en.akamaized.net/img/fd2c975d21cf975979b1389004238b90.jpg";
        dominationImagesAndNames[4][0] = "https://gamewith-en.akamaized.net/img/fd2c975d21cf975979b1389004238b90.jpg";
        dominationImagesAndNames[5][0] = "https://gamewith-en.akamaized.net/img/fd2c975d21cf975979b1389004238b90.jpg";
        dominationImagesAndNames[6][0] = "https://gamewith-en.akamaized.net/img/fd2c975d21cf975979b1389004238b90.jpg";
        dominationImagesAndNames[7][0] = "https://gamewith-en.akamaized.net/img/fd2c975d21cf975979b1389004238b90.jpg";
        dominationImagesAndNames[8][0] = "https://gamewith-en.akamaized.net/img/fd2c975d21cf975979b1389004238b90.jpg";
        dominationImagesAndNames[9][0] = "https://gamewith-en.akamaized.net/img/fd2c975d21cf975979b1389004238b90.jpg";
        dominationImagesAndNames[0][1] = "Aniyah Palace";
        dominationImagesAndNames[1][1] = "Azhir Cave";
        dominationImagesAndNames[2][1] = "Akrlov Peak";
        dominationImagesAndNames[3][1] = "Euphrates Bridge";
        dominationImagesAndNames[4][1] = "Grazna Raid";
        dominationImagesAndNames[5][1] = "Gun Runner";
        dominationImagesAndNames[6][1]= "Hackney Yard";
        dominationImagesAndNames[7][1]= "Piccadilly";
        dominationImagesAndNames[8][1]= "Rammaza";
        dominationImagesAndNames[9][1]= "St. Petrograd";

        return dominationImagesAndNames;
    }

    public String[][] returnSearchAndDestroyImagesAndNames(){
        String[][] searchAndDestroyImagesAndNames = new String[10][2];

        searchAndDestroyImagesAndNames[0][0] = "https://gamewith-en.akamaized.net/img/fd2c975d21cf975979b1389004238b90.jpg";
        searchAndDestroyImagesAndNames[1][0] = "https://gamewith-en.akamaized.net/img/fd2c975d21cf975979b1389004238b90.jpg";
        searchAndDestroyImagesAndNames[2][0] = "https://gamewith-en.akamaized.net/img/fd2c975d21cf975979b1389004238b90.jpg";
        searchAndDestroyImagesAndNames[3][0] = "https://gamewith-en.akamaized.net/img/fd2c975d21cf975979b1389004238b90.jpg";
        searchAndDestroyImagesAndNames[4][0] = "https://gamewith-en.akamaized.net/img/fd2c975d21cf975979b1389004238b90.jpg";
        searchAndDestroyImagesAndNames[5][0] = "https://gamewith-en.akamaized.net/img/fd2c975d21cf975979b1389004238b90.jpg";
        searchAndDestroyImagesAndNames[6][0] = "https://gamewith-en.akamaized.net/img/fd2c975d21cf975979b1389004238b90.jpg";
        searchAndDestroyImagesAndNames[7][0] = "https://gamewith-en.akamaized.net/img/fd2c975d21cf975979b1389004238b90.jpg";
        searchAndDestroyImagesAndNames[8][0] = "https://gamewith-en.akamaized.net/img/fd2c975d21cf975979b1389004238b90.jpg";
        searchAndDestroyImagesAndNames[9][0] = "https://gamewith-en.akamaized.net/img/fd2c975d21cf975979b1389004238b90.jpg";
        searchAndDestroyImagesAndNames[0][1] = "Aniyah Palace";
        searchAndDestroyImagesAndNames[1][1] = "Azhir Cave";
        searchAndDestroyImagesAndNames[2][1] = "Akrlov Peak";
        searchAndDestroyImagesAndNames[3][1] = "Euphrates Bridge";
        searchAndDestroyImagesAndNames[4][1] = "Grazna Raid";
        searchAndDestroyImagesAndNames[5][1] = "Gun Runner";
        searchAndDestroyImagesAndNames[6][1]= "Hackney Yard";
        searchAndDestroyImagesAndNames[7][1]= "Piccadilly";
        searchAndDestroyImagesAndNames[8][1]= "Rammaza";
        searchAndDestroyImagesAndNames[9][1]= "St. Petrograd";

        return searchAndDestroyImagesAndNames;
    }
}