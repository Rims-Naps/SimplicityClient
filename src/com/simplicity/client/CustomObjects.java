package com.simplicity.client;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Gabriel Hannason
 */
public class CustomObjects {

    public static void init() {
        for (int i = 0; i < CUSTOM_OBJECTS.length; i++) {
            int id = CUSTOM_OBJECTS[i][0];
            int x = CUSTOM_OBJECTS[i][1];
            int y = CUSTOM_OBJECTS[i][2];
            int z = CUSTOM_OBJECTS[i][3];
            int face = CUSTOM_OBJECTS[i][4];
            int type = CUSTOM_OBJECTS[i].length > 5 ? CUSTOM_OBJECTS[i][5] : 10;
            CUSTOM_OBJECT_LIST.add(new GameObject(id, x, y, z, face, type));
        }
    }

    // id, x, y, z, face
    // OR
    // id, x, y, z, face, type
    // 0 = north, 1 = east, 2 = south, 3 = west
    public static final int[][] CUSTOM_OBJECTS = {
    		
            /**
             * TOB
            */
            {130087, 3675, 3222, 0, 2},
            {132655, 3662, 3218, 0, 1},

            /**
             * Arthurs Dream II
            */
            {0, 2855, 3934, 0, 0},
            {129314, 2868, 3943, 0, 0}, // Brazier Arthur's dream II @ monster spawn

            {36695, 1636, 3673, 0, 0}, // staffzone fountain
            
            {1306, 3277, 3940, 0, 0},
            {1306, 3279, 3942, 0, 0},
            {1306, 3281, 3944, 0, 0},
            {-1, 3281, 3941, 0, 0},

            {-1, 3158, 3951, 0, 0}, // Web
            
            {46984, 3038, 4534, 0, 0}, // Hellraty crystal
            
            //special altar elite
            {42601, 1684, 3753, 0, 1}, // Portal elite boss dungeon
            {28698, 1686, 3739, 0, 0},

            {-1, 1695, 4703, 0, 0}, // ffa portal
            {-1, 1698, 4702, 0, 0}, // ffa portal

            {1817, 3090, 3475, 0, 0, 4}, // Edge lever

            {1817, 3153, 3923, 0, 0, 4}, // Wildy lever

            {10087, 3187, 3927, 0, 0}, // Dark crab fishing spot

            //Well for upgradable at home and gold bars
            {3485, 3089, 3495, 0, 0},

            //Xmass tree for december
            {47748, 3107, 3498, 0, 0},

            //Blocking ecto
            {1, 3639, 3540, 0, 0},
            {1, 3639, 3539, 0, 0},
            {1, 3639, 3538, 0, 0},
            {1, 3639, 3537, 0, 0},
            {1, 3639, 3536, 0, 0},
            {1, 3639, 3535, 0, 0},
            {1, 3639, 3534, 0, 0},
            {1, 3639, 3533, 0, 0},
            {1, 3639, 3532, 0, 0},
            {1, 3639, 3531, 0, 0},
            {1, 3639, 3530, 0, 0},
            {1, 3639, 3529, 0, 0},
            {1, 3639, 3528, 0, 0},
            {1, 3639, 3527, 0, 0},
            {1, 3639, 3526, 0, 0},
            {1, 3639, 3525, 0, 0},
            {1, 3639, 3524, 0, 0},
            {1, 3639, 3523, 0, 0},
            {1, 3639, 3522, 0, 0},
            {1, 3639, 3521, 0, 0},
            
            //Mage arena
            {-1, 3097, 3938, 0, 0},
            {-1, 3099, 3931, 0, 0},
            {-1, 3111, 3938, 0, 0},
            {-1, 3110, 3927, 0, 0},
            {-1, 3105, 3925, 0, 0},
            {-1, 3097, 3938, 0, 0},
            {-1, 3104, 3938, 0, 0},
            
            // Warmonger Boss area //

            {31427, 3108, 4354, 0, 0},
            {31427, 3107, 4354, 0, 0},
            {31427, 3106, 4354, 0, 0},
            {31427, 3105, 4354, 0, 0},
            {31427, 3104, 4354, 0, 0},
            {31427, 3103, 4354, 0, 0},
            {31427, 3102, 4354, 0, 0},

            // Warmonger Boss area //

            {31427, 3101, 4355, 0, 0},
            {31427, 3101, 4356, 0, 0},
            {31427, 3101, 4357, 0, 0},
            {31427, 3101, 4358, 0, 0},
            {31427, 3101, 4359, 0, 0},
            {31427, 3101, 4360, 0, 0},
            {31427, 3101, 4361, 0, 0},
            {31427, 3101, 4362, 0, 0},
            {31427, 3101, 4363, 0, 0},
            {31427, 3101, 4364, 0, 0},
            {31427, 3101, 4365, 0, 0},

            {31427, 3102, 4366, 0, 0},
            {31427, 3103, 4366, 0, 0},
            {31427, 3104, 4366, 0, 0},
            {31427, 3105, 4366, 0, 0},
            {31427, 3106, 4366, 0, 0},
            {31427, 3107, 4366, 0, 0},
            {31427, 3108, 4366, 0, 0},

            {31427, 3109, 4365, 0, 0},
            {31427, 3109, 4364, 0, 0},
            {31427, 3109, 4363, 0, 0},
            {31427, 3109, 4362, 0, 0},

            {31427, 3109, 4360, 0, 0},
            {31427, 3109, 4359, 0, 0},
            {31427, 3109, 4358, 0, 0},
            {31427, 3109, 4357, 0, 0},
            {31427, 3109, 4356, 0, 0},
            {31427, 3109, 4355, 0, 0},

            // stones at warmonger boss
            {31429, 3116, 4352, 0, 0},
            {31429, 3099, 4372, 0, 0},
            {31429, 3115, 4364, 0, 0},
            {31429, 3102, 4345, 0, 0},
            {31425, 3112, 4345, 0, 0},
            {31425, 3092, 4353, 0, 0},
            {31423, 3104, 4356, 0, 0},

            {31424, 3104, 4359, 0, 1},

            {31422, 3104, 4362, 0, 0},

            {31427, 3109, 4354, 0, 0},

            //Treasure island chests
            {46243, 3039, 2912, 0, 2},

            /**Donator Zone**/
            {11758, 3035, 4413, 0, 0},//bank
            {11758, 3036, 4413, 0, 0},//bank
            {11758, 3037, 4413, 0, 0},//bank
            {11758, 3038, 4413, 0, 0},//bank
            {11758, 3039, 4413, 0, 0},//bank
            {11758, 3040, 4413, 0, 0},//bank
            {11758, 3041, 4413, 0, 0},//bank
            {11758, 3042, 4413, 0, 0},//bank
            {11758, 3043, 4413, 0, 0},//bank
            {-1, 3037, 4402, 0, 0}, //Pipes around rocktail
            {-1, 3038, 4402, 0, 0}, //Pipes around rocktail
            {-1, 3037, 4398, 0, 0}, //Pipes around rocktail
            {-1, 3038, 4398, 0, 0}, //Pipes around rocktail
            {-1, 3040, 4398, 0, 0}, //Pipes around rocktail
            {-1, 3041, 4398, 0, 0}, //Pipes around rocktail
            {-1, 3041, 4401, 0, 0}, //Pipes around rocktail
            {-1, 3041, 4402, 0, 0}, //Pipes around rocktail
            {-1, 3041, 4399, 0, 0}, //Pipes around rocktail
            {-1, 3037, 4399, 0, 0}, //Pipes around rocktail
            {-1, 3037, 4401, 0, 0}, //Pipes around rocktail
            {-1, 3040, 4402, 0, 0}, //Pipes around rocktail
            {-1, 3043, 4391, 0, 0}, //cages
            {-1, 3043, 4393, 0, 0}, //cages
            {-1, 3041, 4391, 0, 0}, //cages

            {-1, 2573, 9876, 0, 0}, //cages
            {-1, 2575, 9876, 0, 0}, //cages
            {-1, 2578, 9875, 0, 0}, //cages
            {-1, 2576, 9873, 0, 0}, //cages
            {-1, 2577, 9893, 0, 0}, //cages
            {-1, 2567, 9886, 0, 0}, //cages
            {-1, 2566, 9889, 0, 0}, //cages
            {-1, 2577, 9894, 0, 0}, //cages
            {-1, 2580, 9894, 0, 0}, //cages


            {-1, 3041, 4393, 0, 0}, //cages
            {-1, 3039, 4391, 0, 0}, //cages
            {-1, 3039, 4393, 0, 0}, //cages
            {-1, 3037, 4393, 0, 0}, //cages
            {-1, 3037, 4391, 0, 0}, //cages
            {-1, 3042, 4388, 0, 0}, //Expiriment Tables
            {-1, 3037, 4388, 0, 0}, //Expiriment Tables
            {-1, 3036, 4385, 0, 0}, //Expiriment Tables
            {-1, 3044, 4385, 0, 0}, //Expiriment Tables
            {-1, 3037, 4384, 0, 0}, //Expiriment Tables
            {-1, 3042, 4384, 0, 0}, //Expiriment Tables
            {-1, 3036, 4388, 0, 0}, //Expiriment Tables
            {-1, 3044, 4388, 0, 0}, //Expiriment Tables
            {-1, 3041, 4385, 0, 0}, //Expiriment Tables
            {-1, 3039, 4385, 0, 0}, //Expiriment Tables


            //onyx city

            // onyxrocks
            {54613, 2716, 5312, 0, 0}, // Onyx city
            {54613, 2717, 5312, 0, 0}, // Onyx city
            {54613, 2717, 5311, 0, 0}, // Onyx city
            {54613, 2717, 5310, 0, 0}, // Onyx city
            {54613, 2717, 5309, 0, 0}, // Onyx city
            {54613, 2716, 5311, 0, 0}, // Onyx city
            {54613, 2716, 5310, 0, 0}, // Onyx city
            {54613, 2716, 5309, 0, 0}, // Onyx city

            //	{10088 , 3113, 3492, 0, 1}, // Afk fish edge
           	{26414 , 2393, 3490, 0, 0}, // New AFK zone
           	{26414 , 2392, 3485, 0, 0}, // New AFK zone
          	{26414 , 2396, 3488, 0, 0}, // New AFK zone
          	
          	{0 , 2889, 5319, 2, 0}, // Afk fountain removal Godwars dung

            // Arthur's dream
            {10089, 1826, 5168, 2, 0}, // anglerfish spot fishworld
            {10089, 1827, 5168, 2, 0}, // anglerfish spot fishworld
            {10089, 1823, 5168, 2, 0}, // anglerfish spot fishworld
            {10089, 1822, 5168, 2, 0}, // anglerfish spot fishworld

            {61551, 1820, 5160, 2, 0}, // white tree arthur's dream
            {61551, 1827, 5159, 2, 0}, // white tree arthur's dream

            {52709, 1824, 5161, 2, 0}, // arthur's dream campfire
            
            // Edge arthur's dream teleporter
            {48661, 3083, 3488, 0, 3}, // Arthur's dream teleporter edgeville
            {27254, 1831, 5163, 2, 0}, // Dark portal arthur's dream
            
            /* 2020 savior */
			{44111, 2340, 9796, 0, 0},
			
            /* Rees zone */
			//{3479, 2911, 5471, 0, 0},
			{-1, 2911, 5471, 0, 0},
            
            // Arthur's dream 2
            {129316, 1626, 3980, 0, 0}, // Objects Arthur's dream II
            {129320, 1626, 3982, 0, 0}, // Objects Arthur's dream II
            {129318, 1626, 3984, 0, 0}, // Objects Arthur's dream II
            
            {129317, 1634, 3980, 0, 0}, // Objects Arthur's dream II
            {129320, 1634, 3982, 0, 0}, // Objects Arthur's dream II
            {129319, 1634, 3984, 0, 0}, // Objects Arthur's dream II
            
            {129301, 1635, 3987, 0, 0}, // Objects Arthur's dream II
            {129305, 1635, 3988, 0, 0}, // Objects Arthur's dream II
            {129303, 1636, 3989, 0, 0}, // Objects Arthur's dream II
            {129301, 1636, 3988, 0, 0}, // Objects Arthur's dream II
            {129301, 1637, 3988, 0, 0}, // Objects Arthur's dream II
            
            {129311, 1639, 3988, 0, 1}, // Bruma roots Arthur's dream II
            
            {129301, 1625, 3987, 0, 0}, // Objects Arthur's dream II
            {129305, 1624, 3988, 0, 0}, // Objects Arthur's dream II
            {129303, 1623, 3988, 0, 0}, // Objects Arthur's dream II
            
            {129311, 1620, 3988, 0, 1}, // Bruma roots Arthur's dream II

            {28194, 3099, 3506, 0, 0}, // Comp orb
            
            {13292, 3077, 3497, 0, 2}, // Magic chest
            //{54408, 3089, 3483, 0, 0}, // Halloween chest
            
            {0, 1625, 3978, 0, 0}, // Objects Arthur's dream II
            {0, 1626, 3978, 0, 0}, // Objects Arthur's dream II
            {0, 1627, 3978, 0, 0}, // Objects Arthur's dream II
            {0, 1628, 3978, 0, 0}, // Objects Arthur's dream II
            {0, 1629, 3978, 0, 0}, // Objects Arthur's dream II
            {0, 1630, 3978, 0, 0}, // Objects Arthur's dream II
            {0, 1631, 3978, 0, 0}, // Objects Arthur's dream II
            {0, 1632, 3978, 0, 0}, // Objects Arthur's dream II
            {0, 1633, 3978, 0, 0}, // Objects Arthur's dream II
            {0, 1634, 3978, 0, 0}, // Objects Arthur's dream II
            {0, 1635, 3978, 0, 0}, // Objects Arthur's dream II
            
            {0, 1635, 3979, 0, 0}, // Objects Arthur's dream II
            {0, 1635, 3980, 0, 0}, // Objects Arthur's dream II
            {0, 1635, 3981, 0, 0}, // Objects Arthur's dream II
            {0, 1635, 3982, 0, 0}, // Objects Arthur's dream II
            {0, 1635, 3983, 0, 0}, // Objects Arthur's dream II
            {0, 1635, 3984, 0, 0}, // Objects Arthur's dream II
            {0, 1635, 3985, 0, 0}, // Objects Arthur's dream II
            {0, 1635, 3986, 0, 0}, // Objects Arthur's dream II
            
            {0, 1625, 3979, 0, 0}, // Objects Arthur's dream II
            {0, 1625, 3980, 0, 0}, // Objects Arthur's dream II
            {0, 1625, 3981, 0, 0}, // Objects Arthur's dream II
            {0, 1625, 3982, 0, 0}, // Objects Arthur's dream II
            {0, 1625, 3983, 0, 0}, // Objects Arthur's dream II
            {0, 1625, 3984, 0, 0}, // Objects Arthur's dream II
            {0, 1625, 3985, 0, 0}, // Objects Arthur's dream II
            {0, 1625, 3986, 0, 0}, // Objects Arthur's dream II
            
            {0, 1622, 3988, 0, 0}, // Objects Arthur's dream II
            {0, 1638, 3988, 0, 0}, // Objects Arthur's dream II
            
            {129314, 1638, 3997, 0, 0}, // Brazier Arthur's dream II
            {129314, 1638, 4015, 0, 0}, // Brazier Arthur's dream II
            {129314, 1620, 4015, 0, 0}, // Brazier Arthur's dream II
            {129314, 1620, 3997, 0, 0}, // Brazier Arthur's dream II
            
            //{46984, 1630, 3990, 0, 0}, // Statue of Arthur
            
            {0, 1623, 3994, 0, 0}, // Objects Arthur's dream II
            {0, 1624, 3994, 0, 0}, // Objects Arthur's dream II
            {0, 1625, 3994, 0, 0}, // Objects Arthur's dream II
            {0, 1626, 3994, 0, 0}, // Objects Arthur's dream II
            {0, 1627, 3994, 0, 0}, // Objects Arthur's dream II
            {0, 1628, 3994, 0, 0}, // Objects Arthur's dream II
            {0, 1629, 3994, 0, 0}, // Objects Arthur's dream II
            {0, 1630, 3994, 0, 0}, // Objects Arthur's dream II
            {0, 1631, 3994, 0, 0}, // Objects Arthur's dream II
            {0, 1632, 3994, 0, 0}, // Objects Arthur's dream II
            {0, 1633, 3994, 0, 0}, // Objects Arthur's dream II
            {0, 1634, 3994, 0, 0}, // Objects Arthur's dream II
            {0, 1635, 3994, 0, 0}, // Objects Arthur's dream II
            {0, 1636, 3994, 0, 0}, // Objects Arthur's dream II
            {0, 1637, 3994, 0, 0}, // Objects Arthur's dream II
            
            // Edge rune ores
            
            {14859, 3099, 3499, 0, 0}, // rune ore edge bank
            {14859, 3099, 3498, 0, 0}, // rune ore edge bank
            {14859, 3099, 3497, 0, 0}, // rune ore edge bank
            {14859, 3099, 3496, 0, 0}, // rune ore edge bank
            {14859, 3099, 3495, 0, 0}, // rune ore edge bank
            {14859, 3099, 3494, 0, 0}, // rune ore edge bank

            /*{54613, 3089, 3483, 0, 0}, // Onyx ore edge bank
            {54613, 3088, 3483, 0, 0}, // Onyx ore edge bank
            {54613, 3087, 3483, 0, 0}, // Onyx ore edge bank
            {54613, 3086, 3483, 0, 0}, // Onyx ore edge bank
            {54613, 3085, 3483, 0, 0}, // Onyx ore edge bank
            {54613, 3084, 3483, 0, 0}, // Onyx ore edge bank
            {54613, 3083, 3483, 0, 0}, // Onyx ore edge bank */

            //{11435, 3414, 2762, 0, 0}, // gold tree

            //dzone

            //runerocks
            {14859, 2331, 9798, 0, 0},
            {14859, 2331, 9799, 0, 0},
            {14859, 2331, 9800, 0, 0},
            {14859, 2331, 9801, 0, 0},
            {14859, 2331, 9802, 0, 0},

            {14859, 2330, 9796, 0, 0},
            {14859, 2330, 9795, 0, 0},
            {14859, 2330, 9794, 0, 0},

            //banks
            {2213, 2323, 9800, 0, 0},
            {2213, 2322, 9800, 0, 0},

            {2213, 2320, 9800, 0, 0},
            {2213, 2319, 9800, 0, 0},
            {2213, 2318, 9800, 0, 0},

            {2213, 1715, 5604, 0, 0},

            // MMA ZONE

            {-1, 2035, 4492, 0, 0},
            {-1, 2035, 4494, 0, 0},
            {-1, 2037, 4492, 0, 0},
            {-1, 2037, 4494, 0, 0},

            {57164, 2036, 4486, 0, 0},

            {-1, 2039, 4500, 0, 0},
            {-1, 2034, 4500, 0, 0},
            
            // MMA ZONE 2
            
            //{46984, 1993, 4529, 0, 0},
            //{46984, 1996, 4529, 0, 0},
            {-1, 1993, 4528, 0, 0},
            {-1, 1993, 4527, 0, 0},
            {-1, 1995, 4527, 0, 0},
            {-1, 1995, 4529, 0, 0},

            // Lava fire giants zone

            {-1, 2456, 5212, 0, 0},
            {-1, 2457, 5212, 0, 0},


            {-1, 2456, 5215, 0, 0},
            {-1, 2457, 5215, 0, 0},
            {-1, 2456, 5216, 0, 0},
            {-1, 2457, 5216, 0, 0},
            {-1, 2456, 5217, 0, 0},
            {-1, 2457, 5217, 0, 0},
            {-1, 2456, 5218, 0, 0},
            {-1, 2457, 5218, 0, 0},
            {-1, 2456, 5219, 0, 0},
            {-1, 2457, 5219, 0, 0},

            {-1, 2460, 5215, 0, 0},
            {-1, 2461, 5215, 0, 0},
            {-1, 2460, 5216, 0, 0},
            {-1, 2461, 5216, 0, 0},
            {-1, 2460, 5217, 0, 0},
            {-1, 2461, 5217, 0, 0},
            {-1, 2460, 5218, 0, 0},
            {-1, 2461, 5218, 0, 0},
            {-1, 2460, 5219, 0, 0},
            {-1, 2461, 5219, 0, 0},

            {-1, 2464, 5215, 0, 0},
            {-1, 2465, 5215, 0, 0},
            {-1, 2464, 5216, 0, 0},
            {-1, 2465, 5216, 0, 0},
            {-1, 2464, 5217, 0, 0},
            {-1, 2465, 5217, 0, 0},
            {-1, 2464, 5218, 0, 0},
            {-1, 2465, 5218, 0, 0},
            {-1, 2464, 5219, 0, 0},
            {-1, 2465, 5219, 0, 0},

            {-1, 2457, 5212, 0, 0},
            {-1, 2457, 5212, 0, 0},
            {-1, 2456, 5211, 0, 0},
            {-1, 2457, 5211, 0, 0},
            {-1, 2456, 5210, 0, 0},
            {-1, 2457, 5210, 0, 0},
            {-1, 2456, 5209, 0, 0},
            {-1, 2457, 5209, 0, 0},
            {-1, 2456, 5208, 0, 0},
            {-1, 2457, 5208, 0, 0},

            {-1, 2460, 5212, 0, 0},
            {-1, 2461, 5212, 0, 0},
            {-1, 2460, 5211, 0, 0},
            {-1, 2461, 5211, 0, 0},
            {-1, 2460, 5210, 0, 0},
            {-1, 2461, 5210, 0, 0},
            {-1, 2460, 5209, 0, 0},
            {-1, 2461, 5209, 0, 0},
            {-1, 2460, 5208, 0, 0},
            {-1, 2461, 5208, 0, 0},

            {-1, 2464, 5212, 0, 0},
            {-1, 2465, 5212, 0, 0},
            {-1, 2464, 5211, 0, 0},
            {-1, 2465, 5211, 0, 0},
            {-1, 2464, 5210, 0, 0},
            {-1, 2465, 5210, 0, 0},
            {-1, 2464, 5209, 0, 0},
            {-1, 2465, 5209, 0, 0},
            {-1, 2464, 5208, 0, 0},
            {-1, 2465, 5208, 0, 0},


            // TARN INSTANCED ZONE

            {-1, 3185, 4618, 0, 0},
            {-1, 3189, 4619, 0, 0},
            {-1, 3185, 4621, 0, 0},

            {20465, 3186, 4611, 0, 1},
            {20467, 3186, 4627, 0, 3},

            // CHRYSTAL ZONE Updated

            {57164, 3039, 4530, 0, 0},
            {57164, 3035, 4530, 0, 0},
            {-1, 3035, 4532, 0, 0},
            {57164, 3032, 4529, 0, 0},
            //{-1, 3032, 4528, 0, 0}, // smaller crystal
            {57164, 3031, 4532, 0, 0},
            {57164, 3037, 4536, 0, 0},
            {57164, 3038, 4536, 0, 0},
            {57164, 3033, 4528, 0, 0},
            {57164, 3033, 4528, 0, 0},
            {57164, 3038, 4528, 0, 0},
            {57164, 3046, 4528, 0, 0},
            {57164, 3041, 4534, 0, 0},
            {57164, 3042, 4534, 0, 0},
            {57164, 3043, 4534, 0, 0},
            {57164, 3045, 4534, 0, 0},
            {57164, 3046, 4534, 0, 0},
            {57164, 3042, 4534, 0, 0},
            {57164, 3042, 4534, 0, 0},

            {57164, 3047, 4530, 0, 0},
            {57164, 3046, 4533, 0, 0},

            {57164, 3048, 4532, 0, 0},
            {57164, 3037, 4535, 0, 0},
            {57164, 3038, 4535, 0, 0},
            {57164, 3032, 4530, 0, 0},
            {57164, 3032, 4532, 0, 0},
            {57164, 3032, 4531, 0, 0},
            //{57164, 3032, 4530, 0, 0},
            {57164, 3033, 4529, 0, 0},
            {57164, 3033, 4531, 0, 0},
            {57164, 3034, 4534, 0, 0},
            {57164, 3040, 4534, 0, 0},
            {57164, 3033, 4530, 0, 0},
            {57164, 3033, 4532, 0, 0},
            {57164, 3034, 4529, 0, 0},

            {57164, 3047, 4529, 0, 0},
            {57164, 3047, 4532, 0, 0},
            {57164, 3047, 4531, 0, 0},

            {57164, 3039, 4534, 0, 0},


            {-1, 3039, 4534, 0, 0},
            {-1, 3043, 4534, 0, 0},
            {-1, 3043, 4530, 0, 0},
            {-1, 3039, 4530, 0, 0},

            //{-1, 3038, 4535, 0, 0},
            //{-1, 3037, 4535, 0, 0},
            {-1, 3034, 4532, 0, 0},
            {-1, 3036, 4532, 0, 0},
            //{-1, 3037, 4535, 0, 0},
            {-1, 3034, 4531, 0, 0},
            //{-1, 3035, 4531, 0, 0},
            {-1, 3036, 4531, 0, 0},
            {-1, 3036, 4530, 0, 0},
            {-1, 3034, 4530, 0, 0},
            {-1, 3035, 4530, 0, 0},
            {-1, 3035, 4529, 0, 0},
            {-1, 3035, 4533, 0, 0},
            //{-1, 3046, 4533, 0, 0},
            {-1, 3045, 4532, 0, 0},
            //{-1, 3045, 4531, 0, 0},
            {-1, 3046, 4530, 0, 0},
            //	{-1, 3047, 4531, 0, 0},
            //{-1, 3047, 4532, 0, 0},
            //{-1, 3048, 4532, 0, 0},


            {14073, 3041, 4532, 0, 0},

            //{-1, 3032, 4532, 0, 0},
            //{-1, 3032, 4531, 0, 0},
            //{-1, 3032, 4530, 0, 0},
            //{-1, 3033, 4529, 0, 0},
            {57164, 3034, 4528, 0, 0},

            {-1, 3046, 4532, 0, 0},
            {-1, 3046, 4531, 0, 0},

            {57164, 3031, 4531, 0, 0},
            {-1, 3035, 4529, 0, 0},
            //{-1, 3047, 4529, 0, 0},

            {57164, 3047, 4528, 0, 0},
            {57164, 3049, 4532, 0, 0},
            {57164, 3040, 4535, 0, 0},
            {57164, 3039, 4535, 0, 0},
            {57164, 3036, 4535, 0, 0},
            {57164, 3035, 4535, 0, 0},
            {57164, 3034, 4535, 0, 0},
            {57164, 3033, 4534, 0, 0},
            {57164, 3033, 4533, 0, 0},

            {57164, 3031, 4530, 0, 0},
            {57164, 3033, 4533, 0, 0},
            {57164, 3033, 4533, 0, 0},
            {57164, 3033, 4533, 0, 0},

            {57164, 3035, 4528, 0, 0},
            {57164, 3036, 4528, 0, 0},
            {57164, 3037, 4528, 0, 0},
            {57164, 3039, 4528, 0, 0},

            {57164, 3042, 4528, 0, 0},
            {57164, 3043, 4528, 0, 0},
            {57164, 3044, 4528, 0, 0},
            {57164, 3045, 4528, 0, 0},

            {57164, 3048, 4530, 0, 0},
            {57164, 3048, 4531, 0, 0},
            {57164, 3048, 4533, 0, 0},
            {57164, 3047, 4533, 0, 0},

            // 2nd teleporter karuulm

            {35469, 2035, 4492, 0, 0},
            {16859, 2378, 3842, 0, 0}, // Block Electro Wyrm
            {16859, 2378, 3845, 0, 0}, // Block Electro Wyrm
            {29828, 2374, 3851, 0, 0}, // Hole Electro Wyrm

            {0, 2378, 3841, 0, 0}, // Block Broken Bridge

            {0, 2355, 3846, 0, 0}, // Block Broken Bridge
            {0, 2355, 3841, 0, 0}, // Block Broken Bridge

            {57163, 2348, 3879, 0, 0}, // Block Drake island
            {57163, 2347, 3882, 0, 0}, // Block Drake island

            {57163, 2345, 3830, 0, 0}, // Block Drake island

            {46327, 2314, 3848, 0, 0}, // Block Drake island
            {46327, 2345, 3833, 0, 0}, // Block Bridge Drake island

            {57165, 2031, 4496, 0, 0},
            {57165, 2031, 4491, 0, 0},

            {57165, 2033, 4486, 0, 0},
            {-1, 2034, 4486, 0, 0},
            {57165, 2039, 4486, 0, 0},

            {57165, 2042, 4496, 0, 0},
            {57165, 2042, 4491, 0, 0},

            // Teleport to new slayer dung

            {10780, 3105, 3507, 0, 0},
            
            
            
            // Supreme's Statue MMA2
            {59956, 1994, 4532, 0, 0}, // Supreme
            
            // Supreme's Statue Edgeville
            {59956, 3094, 3471, 0, 3}, // Supreme
            {40960, 2338, 9802, 0, 3}, // Scroll chest
            
            // obstable for cows event
            {5574, 3241, 3301, 0, 0},
            {5574, 3241, 3302, 0, 0},
            {5574, 3262, 3321, 0, 0},
            {5574, 3261, 3321, 0, 0},
            
            // Great Kourand
            {-1, 1634, 3671, 0, 0},
            //magetrees
            {1306, 2326, 9795, 0, 0},


            {6189, 2328, 9798, 0, 0},

            {-1, 2324, 9799, 0, 0},
            {-1, 2324, 9798, 0, 0},
            {-1, 2325, 9798, 0, 0},
            {-1, 2326, 9798, 0, 0},
            {-1, 2328, 9799, 0, 0},
            {-1, 2327, 9799, 0, 0},
            {-1, 2327, 9800, 0, 0},
            {-1, 2327, 9798, 0, 0},

            {-1, 2321, 9800, 0, 0},
            {-1, 2320, 9798, 0, 0},
            {-1, 2319, 9799, 0, 0},
            {-1, 2318, 9801, 0, 0},
            {-1, 2321, 9798, 0, 0},
            {-1, 2318, 9798, 0, 0},
            {-1, 2316, 9798, 0, 0},
            {0, 2309, 9799, 0, 0},

            {-1, 2309, 9806, 0, 0},

            {8135, 2309, 9804, 0, 0},
            {8135, 2310, 9804, 0, 0},
            {8135, 2308, 9804, 0, 0},
            {8135, 2307, 9804, 0, 0},
            {8135, 2309, 9805, 0, 0},
            {8135, 2310, 9805, 0, 0},
            {8135, 2308, 9805, 0, 0},
            {8135, 2307, 9805, 0, 0},

            {-1, 2319, 9798, 0, 0},

            {2213, 2321, 9800, 0, 0},

            {4306, 2325, 9798, 0, 0},
            {2644, 2326, 9798, 0, 0},

            {52709, 2323, 9806, 0, 0},

            {2646, 2328, 9804, 0, 0},
            {2646, 2329, 9804, 0, 0},
            {2646, 2327, 9804, 0, 0},
            {2646, 2328, 9803, 0, 0},
            {2646, 2329, 9803, 0, 0},
            {2646, 2327, 9803, 0, 0},
            {2646, 2330, 9803, 0, 0},

            {170, 3294, 3946, 0, 0}, // rogue castel crates
            {1, 3293, 3946, 0, 0},
            {1, 3295, 3945, 0, 0},
            {1, 3294, 3945, 0, 0},


            //rocktail fishing
            {8702, 2327, 9801, 0, 0},
            //frost drags portal
            //rune armour stealing
            {13493, 2316, 9801, 0, 2},
            //special altar
            {8749, 2342, 9805, 0, 3},

            //superior hall recharge
            {21893, 3018, 4410, 0, 0},
            {21893, 3012, 4380, 0, 3},
            {21893, 3034, 4361, 0, 1},
            {21893, 3043, 4361, 0, 3},
            {21893, 3066, 4380, 0, 1},
            {21893, 3058, 4410, 0, 0},

            //Superior portal at dzone
            {46935, 2345, 9801, 0, 2},


            //dzone thieve altars
            {4875, 2342, 9799, 0, 0},
            {4874, 2342, 9800, 0, 0},
            {4876, 2342, 9801, 0, 0},
            {4877, 2342, 9802, 0, 0},
            {4878, 2342, 9803, 0, 0},


            //dzone
            {2213, 2340, 9808, 0, 0},
            {2213, 2339, 9808, 0, 0},
            {2213, 2341, 9808, 0, 0},
            {2213, 2338, 9808, 0, 0},
            {2213, 2337, 9808, 0, 0},
            {2213, 2336, 9808, 0, 0},
            {2213, 2335, 9808, 0, 0},
            {2213, 2334, 9808, 0, 0},
            {2213, 2313, 9798, 0, 0},
            /*End of new Donator Zone*/

            //Wilderness box area

           // {18321, 3104, 3621, 0, 0}, //Tier 1 Wilderness Box
            {37010, 3170, 3886, 0, 0}, //Tier 2 Wilderness Box
           // {29578, 3170, 3886, 0, 0}, //Tier 3 Wilderness Box


            {-1, 3171, 3886, 0, 0}, //Removal objects
            {-1, 3168, 3884, 0, 0}, //Removal objects

            /*End of wilderness box area*/

            /*Misc*/
            {-1, 2268, 3067, 0, 0},
            {401, 3503, 3567, 0, 0},
            {401, 3504, 3567, 0, 0},

            {-1, 3213, 3430, 0, 0},
            {-1, 3213, 3426, 0, 0},
            {13405, 3083, 3492, 0, 1},

            {2274, 2912, 5300, 2, 0},
            {2274, 2914, 5300, 1, 0},
            {2274, 2919, 5276, 1, 0},
            {2274, 2918, 5274, 0, 0},
            //{2274, 3001, 3931, 0, 0}, agility teleport
            {-1, 2884, 9797, 0, 2},
            {29942, 3090, 3507, 0, 2}, // summoning obelisk
            {4483, 2444, 3083, 0, 1}, // Castle-wars Gamble
            {4483, 2909, 4832, 0, 3},
            {4483, 2901, 5201, 0, 2},
            {4483, 2902, 5201, 0, 2},
            {9326, 3001, 3960, 0, 0},
            {1662, 3112, 9677, 0, 2},
            {1661, 3114, 9677, 0, 2},
            {1661, 3122, 9664, 0, 1},
            {1662, 3123, 9664, 0, 2},
            {1661, 3124, 9664, 0, 3},
            {4483, 2918, 2885, 0, 3},
            {12356, 3207, 3415, 0, 0},
            {2182, 3206, 3415, 0, 0},
            {1746, 3090, 3492, 0, 1},
            {2644, 2737, 3444, 0, 0},
            {-1, 2608, 4777, 0, 0},
            {-1, 2601, 4774, 0, 0},
            {-1, 2611, 4776, 0, 0},
            /**New Member Zone*/
            {2344, 3421, 2908, 0, 0}, //Rock blocking
            {2345, 3438, 2909, 0, 0},
            {2344, 3435, 2909, 0, 0},
            {2344, 3432, 2909, 0, 0},
            {2345, 3431, 2909, 0, 0},
            {2344, 3428, 2921, 0, 1},
            {2344, 3428, 2918, 0, 1},
            {2344, 3428, 2915, 0, 1},
            {2344, 3428, 2912, 0, 1},
            {2345, 3428, 2911, 0, 1},
            {2344, 3417, 2913, 0, 1},
            {2344, 3417, 2916, 0, 1},
            {2344, 3417, 2919, 0, 1},
            {2344, 3417, 2922, 0, 1},
            {2345, 3417, 2912, 0, 0},
            {2346, 3418, 2925, 0, 0},
            {10378, 3426, 2907, 0, 0},
            {8749, 3426, 2923, 0, 2}, //Altar
            {-1, 3420, 2909, 0, 10}, //Remove crate by mining
            {-1, 3420, 2923, 0, 10}, //Remove Rockslide by Woodcutting
            {14859, 3421, 2909, 0, 0}, //Mining
            {14859, 3419, 2909, 0, 0},
            {14859, 3418, 2910, 0, 0},
            {14859, 3418, 2911, 0, 0},
            {14859, 3422, 2909, 0, 0},
            {1306, 3418, 2921, 0, 0}, //Woodcutting
            {1306, 3421, 2924, 0, 0},
            {1306, 3420, 2924, 0, 0},
            {1306, 3419, 2923, 0, 0},
            {1306, 3418, 2922, 0, 0},
            {-1, 3430, 2912, 0, 2},
            {13493, 3424, 2916, 0, 1},//Armour  stall
            /**New Member Zone end*/
            {-1, 3098, 3496, 0, 1},
            {-1, 3095, 3498, 0, 1},
            {-1, 3088, 3509, 0, 0},
            {-1, 3095, 3499, 0, 1},
            //{-1, 3085, 3506, 0, 1},

            {-1, 3206, 3263, 0, 0},
            {-1, 2794, 2773, 0, 0},
            {2, 2692, 3712, 0, 3},
            {2, 2688, 3712, 0, 1},
            {4483, 3081, 3496, 0, 1},
            {4483, 3081, 3495, 0, 1},
            
            {-1, 3108, 3931, 0, 0},
            
            /**Edgeville**/
            {409, 3088, 3483, 0, 0},	// prayer altar
            {409, 3090, 3510, 0, 1},	// prayer altar 
            {6552, 3092, 3506, 0, 2}, 	// ancient altar
            {13179, 3096, 3506, 0, 0},	// lunar altar
            {411, 3085, 3483, 0, 0},
            
            /**Chaos altar wilderness**/
            {411, 3239, 3608, 0, 0},
            
            //{30205, 3085, 3509, 0, 3},
            


            {4875, 3094, 3500, 0, 0},
            {4874, 3095, 3500, 0, 0},
            {4876, 3096, 3500, 0, 0},
            {4877, 3097, 3500, 0, 0},
            {4878, 3098, 3500, 0, 0},
            {11758, 3019, 9740, 0, 0},
            {11758, 3020, 9739, 0, 1},
            {11758, 3019, 9738, 0, 2},
            {11758, 3018, 9739, 0, 3},
            {11933, 3028, 9739, 0, 1},
            {11933, 3032, 9737, 0, 2},
            {11933, 3032, 9735, 0, 0},
            {11933, 3035, 9742, 0, 3},
            {11933, 3034, 9739, 0, 0},
            {11936, 3028, 9737, 0, 1},
            {11936, 3029, 9734, 0, 2},
            {11936, 3031, 9739, 0, 0},
            {11936, 3032, 9741, 0, 3},
            {11936, 3035, 9734, 0, 0},
            {11954, 3037, 9739, 0, 1},
            {11954, 3037, 9735, 0, 2},
            {11954, 3037, 9733, 0, 0},
            {11954, 3039, 9741, 0, 3},
            {11954, 3039, 9738, 0, 0},
            {11963, 3039, 9733, 0, 1},
            {11964, 3040, 9732, 0, 2},
            {11965, 3042, 9734, 0, 0},
            {11965, 3044, 9737, 0, 3},
            {11963, 3042, 9739, 0, 0},
            {11963, 3045, 9740, 0, 1},
            {11965, 3043, 9742, 0, 2},
            {11964, 3045, 9744, 0, 0},
            {11965, 3048, 9747, 0, 3},
            {11951, 3048, 9743, 0, 0},
            {11951, 3049, 9740, 0, 1},
            {11951, 3047, 9737, 0, 2},
            {11951, 3050, 9738, 0, 0},
            {11951, 3052, 9739, 0, 3},
            {11951, 3051, 9735, 0, 0},
            {11947, 3049, 9735, 0, 1},
            {11947, 3049, 9734, 0, 2},
            {11947, 3047, 9733, 0, 0},
            {11947, 3046, 9733, 0, 3},
            {11947, 3046, 9735, 0, 0},
            {11941, 3053, 9737, 0, 1},
            {11939, 3054, 9739, 0, 2},
            {11941, 3053, 9742, 0, 0},
            {14859, 3038, 9748, 0, 3},
            {14859, 3044, 9753, 0, 0},
            {14859, 3048, 9754, 0, 1},
            {14859, 3054, 9746, 0, 2},
            {4306, 3026, 9741, 0, 0},
            {6189, 3022, 9742, 0, 1},
            {172, 3077, 3499, 0, 1},
            
            {3192, 3078, 3480, 0, 0}, // scoreboard

            {75, 2914, 3452, 0, 2},


            //	{ 47947 , 2720, 5352, 0, 2}, // waterfall o city

            {16284, 3028, 4514, 0, 0}, // Crystal afk
            {49653, 3035, 4531, 0, 3}, // Stattuete of Axemurdera
            {41026, 3045, 4531, 0, 1}, // Stattuete of Risen Siren
            {53979, 3044, 4536, 0, 0}, // Teleporter to AFK Bosses

            {-1, 2461, 5295, 0, 0}, // remove object crystal cave
            {-1, 2463, 5291, 0, 0}, // remove object crystal cave
            {-1, 2462, 5287, 0, 0}, // remove object crystal cave
            
            // new AFK-westerfish location
            
            {13569, 2779, 3520, 0, 0}, // AFK-westerfish
            {13569, 2778, 3520, 0, 0}, // AFK-westerfish
            {13569, 2770, 3520, 0, 0}, // AFK-westerfish
            {13569, 2769, 3520, 0, 0}, // AFK-westerfish

            {2158, 3094, 3513, 0, 1}, // portal
            
            {13570, 3425, 2909, 0, 0}, // sapphire westerfish


            // Cleaning objects home

            //{-1, 3080, 3507, 0, 0},
            
            
            //{-1, 3084, 3509, 0, 0},
            //{-1, 3084, 3510, 0, 0},
            //{-1, 3084, 3512, 0, 0},
            {357, 3084, 3511, 0, 0},
            {-1, 3077, 3512, 0, 0},

            {0, 3079, 3507, 0, 0},
            {0, 3077, 3507, 0, 0},
            {0, 3083, 3507, 0, 0},
            {0, 3076, 3509, 0, 0},
            {0, 3076, 3510, 0, 0},
            {0, 3076, 3511, 0, 0},
            {0, 3076, 3512, 0, 0},
            {0, 3077, 3513, 0, 0},
            {0, 3078, 3513, 0, 0},
            {0, 3079, 3513, 0, 0},
            {0, 3080, 3513, 0, 0},
            {0, 3081, 3513, 0, 0},
            {0, 3082, 3513, 0, 0},
            {0, 3083, 3513, 0, 0},

            // END cleaning objects edgeville 2

            {0, 3089, 3474, 0, 0},
            {0, 3089, 3475, 0, 0},
            {0, 3089, 3476, 0, 0},
            {0, 3089, 3476, 0, 0},
            {0, 3089, 3479, 0, 0},
            {0, 3089, 3480, 0, 0},
            //{0, 3090, 3474, 0, 0},
            {0, 3090, 3473, 0, 0},

            // AFK HERB

            {56839, 3091, 3472, 0, 0},
            {56839, 3089, 3473, 0, 0},

            {11758, 3449, 3722, 0, 0},
            {11758, 3450, 3722, 0, 0},
            {50547, 3445, 3717, 0, 3},
            //{-1, 3085, 3512, 0, 0},
            {-1, 3092, 3496, 0, 0},
            {-1, 3659, 3508, 0, 0},
            {4053, 3660, 3508, 0, 0},
            {4051, 3659, 3508, 0, 0},
            {1, 3649, 3506, 0, 0},
            {1, 3650, 3506, 0, 0},
            {1, 3651, 3506, 0, 0},
            {1, 3652, 3506, 0, 0},
            {8702, 3423, 2911, 0, 0},

            {8702, 3281, 3940, 0, 0}, // rogues castle rocktail

            {47180, 3422, 2918, 0, 0},
            {11356, 3420, 2917, 0, 1},
            {-1, 2860, 9734, 0, 1},
            {-1, 2857, 9736, 0, 1},
            {664, 2859, 9742, 0, 1},
            {1167, 2860, 9742, 0, 1},
            {5277, 3691, 3465, 0, 2},
            {5277, 3690, 3465, 0, 2},
            {5277, 3688, 3465, 0, 2},
            {5277, 3687, 3465, 0, 2},

            {30087, 1231, 3559, 0, 3}, //west raids bank booth

            /**
             * Level 60+ woodcutting area
            */
            {-1, 2709, 3459, 0, 0},
            {-1, 2712, 3459, 0, 0},
            {-1, 2711, 3461, 0, 0},
            {-1, 2709, 3461, 0, 0},
            {-1, 2708, 3458, 0, 0},
            {-1, 2712, 3457, 0, 0},
            {-1, 2714, 3458, 0, 0},
            {-1, 2713, 3461, 0, 0},
            {-1, 2709, 3460, 0, 0},
            {-1, 2709, 3458, 0, 0},

            {1306, 2710, 3459, 0, 1},

            {-1, 2709, 3464, 0, 0},
            {-1, 2708, 3466, 0, 0},
            {-1, 2713, 3464, 0, 0},
            {-1, 2712, 3466, 0, 0},
            {-1, 2711, 3467, 0, 0},
            {-1, 2710, 3465, 0, 0},
            {-1, 2709, 3465, 0, 0},
            {-1, 2709, 3466, 0, 0},
            {-1, 2709, 3467, 0, 0},
            {-1, 2710, 3467, 0, 0},

            {-1, 3217, 3436, 0, 0},
            {-1, 3218, 3436, 0, 0},
            {-1, 3219, 3436, 0, 0},

            {-1, 3217, 3437, 0, 0},
            {-1, 3218, 3437, 0, 0},
            {-1, 3219, 3437, 0, 0},

            {1306, 2710, 3465, 0, 1},

            {-1, 2715, 3466, 0, 0},
            {-1, 2714, 3466, 0, 0},
            {-1, 2715, 3465, 0, 0},
            {-1, 2714, 3467, 0, 0},

            {1306, 2715, 3465, 0, 1},
    };

    public static List<GameObject> CUSTOM_OBJECT_LIST = new ArrayList<GameObject>();
}
