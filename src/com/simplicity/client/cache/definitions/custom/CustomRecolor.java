package com.simplicity.client.cache.definitions.custom;

import java.awt.Color;
import java.util.Arrays;

import com.simplicity.client.cache.definitions.ItemDefinition;

/**
 * An enumerated type that represents a custom recolored item.
 * 
 * @author Blake
 *
 */

public enum CustomRecolor {
	
	// Blade only colors: 90, 90, 90, 56220, 90, 90, 56220, 90, 90, 90, 90, 90, 90, 56220
	// Blade and crystal colors: 90, 90, 90, 56220, 90, 56220, 56220, 90, 56220, 90, 56220, 56220, 90, 56220
	// Blade only and crystal only, no further changes: 933, 933, 933, 933, 933, 933, 933
	
	BLACK_DRAGONSTONE_HELM(56000, 54034, "Dragonstone full helm", new int[] { 36252, 36257, 36133, 37165, 43059, 43067 }, new int[] { 15, 15, 15, 15, 15, 15 }),
	BLACK_DRAGONSTONE_PLATE(56001, 54037, "Dragonstone platebody", new int[] { 36252, 36257, 36133, 37165, 43059, 43067 }, new int[] { 15, 15, 15, 15, 15, 15 }),
	BLACK_DRAGONSTONE_LEGS(56002, 54040, "Dragonstone platelegs", new int[] { 36252, 36257, 36133, 37165, 43059, 43067 }, new int[] { 15, 15, 15, 15, 15, 15 }),
	BLACK_DRAGONSTONE_BOOTS(56003, 54043, "Dragonstone boots", new int[] { 36252, 36257, 36133, 37165, 43059, 43067 }, new int[] { 15, 15, 15, 15, 15, 15 }),
	BLACK_DRAGONSTONE_GLOVES(56004, 54046, "Dragonstone gloves", new int[] { 36252, 36257, 36133, 37165, 43059, 43067 }, new int[] { 15, 15, 15, 15, 15, 15 }),
	
	GROUP_IRONMAN_HELM(56005, 42810, "Group ironman helm", new int[] { 24, 37, 53, 57, 70, 78, 86, 90, 99, 107, 111, 115  }, new int[] { 16022, 16, 30, 34, 16022, 16021, 16023, 16022, 16026, 16026, 16022, 16022 }),
	GROUP_IRONMAN_PLATE(56006, 42811, "Group ironman plate", new int[] { 49, 111, 57, 78, 86, 41, 107, 70  }, new int[] { 16026, 16026, 16026, 16026, 16026, 24, 16026, 16025 }),
	GROUP_IRONMAN_LEGS(56007, 42812, "Group ironman legs", new int[] { 24, 37, 49, 53, 57, 70, 78, 86, 90, 94, 99, 103, 107, 111, 115  }, new int[] { 16026, 16026, 16026, 16026, 16026, 16026, 16026, 16023, 16026, 16026, 16026, 16026, 16022, 16026, 16026 }),
	
	
	RED_DRAGONSTONE_HELM(56008, 54034, "Dragonstone full helm", new int[] { 36252, 36257, 36133, 37165, 43059, 43067, 51111, 51133, 52122 }, new int[] { 933, 933, 933, 933, 933, 933, 0, 15, 0 }),
	RED_DRAGONSTONE_PLATE(56009, 54037, "Dragonstone platebody", new int[] { 36252, 36257, 36133, 37165, 43059, 43067, 51111, 51133, 52122 }, new int[] { 933, 933, 933, 933, 933, 933, 0, 15, 0 }),
	RED_DRAGONSTONE_LEGS(56010, 54040, "Dragonstone platelegs", new int[] { 36252, 36257, 36133, 37165, 43059, 43067, 51111, 51133, 52122 }, new int[] { 933, 933, 933, 933, 933, 933, 0, 15, 0 }),
	RED_DRAGONSTONE_BOOTS(56011, 54043, "Dragonstone boots", new int[] { 36252, 36257, 36133, 37165, 43059, 43067, 51111, 51133, 52122 }, new int[] { 933, 933, 933, 933, 933, 933, 0, 15, 0 }),
	RED_DRAGONSTONE_GLOVES(56012, 54046, "Dragonstone gloves", new int[] { 36252, 36257, 36133, 37165, 43059, 43067, 51111, 51133, 52122 }, new int[] { 933, 933, 933, 933, 933, 933, 0, 15, 0 }),
	
	DON_JR_SANG_X(13991, 52323, "Jesus's staff", 
			new int[] { 836, 156, 3127, 142, 3140, 24, 20, 28, 836, 37, 49, 41, 57, 33, 16, 284 }, 
			new int[] { 37631, 57300, 129770, 129770, 57300, 57300, 57300, 57300, 57300, 57300, 129770, 129770, 129770, 57300, 57300, 57300 }),
	
	EMAN_ANGELIC_CAPE(11206, 11614, "USA Angelic Cape", 
			new int[]{ 40023, 40036, 1822, 36, 25, 34243, 9230, 40040, 10348, 48, 34251, 0, 43335, 6218, 23, 11013 },
            new int[]{ 1024, 1024, 1024, 933, 933, 1024, 933, 1024, 1024, 933, 1024, 1024, 1024, 1024, 933, 1024 }),
	
	ORANGE_ICE_TBOW(15660, 20998, "@or1@Spooky Twisted Bow", 
			new int[] { 16, 24, 33, 13223, 14236, 8, 41, 10318, 10334 }, 
			new int[] { 4024, 4024, 0, 4024, 4024, 0, 4024, 0, 0 }),
	
	GREEN_ICE_TBOW(15661, 20998, "@gre@Licht Nightmare Bow", 
			new int[] { 16, 24, 33, 13223, 14236, 8, 41, 10318, 10334 }, 
			new int[] { 350770, 350770, 0, 350770, 350770, 0, 350770, 0, 0 }),
	
	JOURNEY_SCYTHE(19620, 15000, "Journey", 
			new int[] { 33, 37, 41, 78, 16, 784, 49, 20, 790, 24, 536, 796, 28, 61 },
			new int[] { 90, 90, 90, 56220, 90, 56220, 56220, 90, 56220, 90, 56220, 56220, 90, 56220 }),
	
	EMAN_SCYTHE_X(11207, 15000, "USA Dragonstone Scythe",
			new int[] { 784, 790, 796, 536, 61, 78, 49 },
            new int[] {  933, 933, 933, 933, 0, 933, 0  }),
	
	DARK_PRIMAL_HELM(3068, 16711, "Dark Primal Full Helm",
			new int[] { 2838, 2848, 2866, 2048, 2855, 7731, 7757, 7694, 4110, 2049,
						7753, 7718, 7372, 7712, 7403, 7713, 7726, 7743, 7721, 7684,
						7738, 7716, 7680, 7698, 7711, 7733, 7693, 7706, 7728 },
			new int[] { 2049, 2049, 2049, 2049, 2049, 2049, 2049, 2049, 2049, 2049,
						2049, 2049, 2049, 2049, 2049, 2049, 2049, 2049, 2049, 2049,
						2049, 2049, 2049, 2049, 2049, 2049, 2049, 2049, 2049 }),
	
	DARK_PRIMAL_BODY(3067, 17259, "Dark Primal Platebody",
			new int[] { 2828, 2840, 2848, 2833, 2834, 2845, 2824, 2826, 2855, 2830,
						2827, 2888, 2846, 2847, 2817, 2866, 2880, 7703, 7710, 7731,
						2822, 7694, 2816, 2862, 2823, 2844, 2853, 2831, 2839 },
			new int[] { 2049, 2049, 2049, 2049, 2049, 2049, 2049, 2049, 2049, 2049,
						2049, 2049, 2049, 2049, 2049, 2049, 2049, 2049, 2049, 2049,
						2049, 2049, 2049, 2049, 2049, 2049, 2049, 2049, 2049 }),
	
	DARK_PRIMAL_LEGS(3066, 16689, "Dark Primal Platelegs",
			new int[] { 2830, 7694, 7731, 7710, 7703, 2816, 2880, 2844, 7700, 2866,
						2848, 2853, 2839, 2925, 2857, 2840, 2836, 2822, 2832, 2828,
						2876, 2823, 2827, 2833, 2847, 2842, 7724, 7721, 7715, 7735,
						7714, 7740, 7719 },
			new int[] { 2049, 2049, 2049, 2049, 2049, 2049, 2049, 2049, 2049, 2049,
						2049, 2049, 2049, 2049, 2049, 2049, 2049, 2049, 2049, 2049,
						2049, 2049, 2049, 2049, 2049, 2049, 2049, 2049, 2049, 2049,
						2049, 2049, 2049 }),
	
	DARK_PRIMAL_KITE(3065, 17361, "Dark Primal Kiteshield",
			new int[] { 1567, 1559, 1549, 1557, 6694, 6704, 1539, 6729, 6719, 1562,
						1572, 5403, 5398, 5388, 5393, 1550, 5380, 5385, 5424, 5408,
						1584, 1554, 1544, 1574, 5378, 5376, 1540, 5383, 1589, 5411,
						5406, 5429, 5413, 1579, 5414, 5396, 5401, 5419},
            new int[] { 2049, 2049, 2049, 2049, 2049, 2049, 2049, 2049, 2049, 2049,
            			2049, 2049, 2049, 2049, 2049, 2049, 2049, 2049, 2049, 2049,
            			2049, 2049, 2049, 2049, 2049, 2049, 2049, 2049, 2049, 2049,
            			2049, 2049, 2049, 2049, 2049, 2049, 2049, 2049 }),
	
	DARK_PRIMAL_BOOTS(3064, 16359, "Dark Primal Boots",
			new int[] { 2830, 2853, 2840, 2836 },
            new int[] {  2049, 2049, 2049, 2049 }),
	
	DARK_PRIMAL_GLOVES(3063, 16293, "Dark Primal Gauntlents",
			new int[] { 2839, 2848, 2826 },
            new int[] {  2049, 2049, 2049 }),
	
	BLACK_BUNNY_EARS(56013, 1037, "Black Bunny ears", new int[] { 220 }, new int[] { 10 }),
	BLACK_BUNNY_TOP(56014, 43663, "Black Bunny top", new int[] { 2370, 2378, 2382 }, new int[] { 10, 10, 10 }),
	BLACK_BUNNY_LEGS(56015, 43664, "Black Bunny legs", new int[] { 2370, 2378, 2382 }, new int[] { 10, 10, 10 }),
	BLACK_BUNNY_PAWS(56016, 43665, "Black Bunny paws", new int[] { 2370, 2378, 2382 }, new int[] { 10, 10, 10 }),
	BLACK_BUNNY_BOOTS(56017, 43182, "Black Bunny boots", new int[] { 2370, 2378, 2382 }, new int[] { 10, 10, 10 }),
	EVIL_BUNNY_BOOTS(20208, 43182, "Evil Bunny boots", new int[] { 2370, 2378, 2382 }, new int[] { 16026, 16026, 16026 }),
	
	SCYTHE_OF_VITUR_INFERNAL(56018, 22011, "Scythe of Vitur Infernal", new int[] { 69 }, new int[] { 59 }),
	
	SEZY_SPOOKY_CAPE(8475, 11614, "Sezy's Spooky Cape",
			new int[] { 40023, 40036, 1822, 36, 25, 34243, 9230, 40040, 10348, 48, 34251, 0, 43335, 6218, 23, 11013 },
			new int[] { 1024, 1024, 1024, 461770, 461770, 1024, 461770, 1024, 1024, 461770, 1024, 1024, 1024, 1024, 461770, 1024 }),
	
	DARK_MASTERWORK_HELM(22024, 22000, "Dark masterwork full helm", new int[] { 37989, 39010, 57379, 49197, 58404, 46163, 53272, 52234, 48267, 42040, 47130, 52359, 58633,     39946, 42123, 5259, 40972, 3340, 48270, 42126, 5262, 15, 4495, 46223, 42128, 48272, 3217, 4497, 53265, 42131, 52245, 57365, 5141, 58517, 60566, 57494, 42137, 57497, 58394, 52250, 53277, 4381, 57374, 59552, 53282, 60451, 46115, 48163, 53285, 5413, 49189, 58405, 57381, 6567, 49192, 58409, 49194, 43052, 58412, 49199, 7601, 48177, 49202, 42041, 57404, 39997, 44095, 47168, 42050, 43077, 40006, 38983, 42057, 46155, 42059, 43084, 40012, 42062, 39118, 40015, 42065, 48209, 38993, 39123, 36947, 43097, 43098, 38109, 43101, 37982, 36958, 37983, 41055, 39009, 39010, 39011, 37989 }, new int[] { 16306, 16306, 16306, 16306, 16306, 16306, 16306, 16306, 16306, 16306, 16306, 16306, 16306, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 }),
	DARK_MASTERWORK_BODY(22025, 22001, "Dark masterwork platebody", new int[] { 46132, 53284, 37955, 38987, 2575, 2457, 38067, 46230, 43040, 34876, 42049, 44192, 6567, 5413, 1030, 48390, 1033, 265, 58633, 48393, 10, 52234, 39946, 57610, 60682, 266, 11, 40972, 268, 51212, 60684, 61966, 61710, 40975, 52239, 15, 61712, 58640, 53265, 4369, 2321, 40977, 42005, 52245, 533, 4374, 278, 4377, 52249, 40985, 25, 52250, 35866, 47130, 58394, 53275, 42011, 539, 4381, 53278, 52255, 42015, 47135, 58399, 32, 53283, 35, 58404, 48164, 42020, 47141, 58405, 58409, 43049, 47145, 5161, 53289, 43052, 53292, 49197, 53293, 48174, 42030, 46127, 41007, 42033, 43058, 46130, 42035, 42036, 53303, 38967, 38969, 42044, 38973, 42046, 38978, 43077, 38729, 52357, 43141, 135, 52359, 42119, 42123, 48267, 58507, 60811, 6795, 62091, 4492, 42126, 53390, 58510, 48270, 60559, 57487, 53392, 48272, 62864, 37008, 6544, 3217, 4497, 3473, 57489, 53396, 46228, 60564, 42132, 3476, 4500, 405, 57494, 3481, 58522, 42138, 410, 42139, 59547, 5533, 49310, 5539, 44195, 5549, 4269, 45231, 7601, 45239, 5561, 20158, 41663 }, new int[] { 16306, 16306, 16306, 16306, 16306, 16306, 16306, 16306, 16306, 16306, 16306, 16306, 16306, 16306, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 }),
	DARK_MASTERWORK_LEGS(22026, 22002, "Dark masterwork platelegs", new int[] { 38969, 47135, 58520, 60566, 47141, 5413, 4381, 40, 5, 1030, 262, 58630, 58633, 1033, 265, 52234, 10, 266, 60682, 11, 12, 51212, 1548, 40972, 60684, 270, 14, 15, 52239, 40975, 30735, 16, 272, 17, 62737, 53265, 40977, 21, 57365, 42005, 52245, 36885, 57368, 53272, 52249, 25, 58394, 52250, 53275, 58397, 53277, 43037, 53278, 52255, 48160, 43040, 53282, 48162, 53283, 53284, 48164, 53285, 42024, 53289, 47145, 43049, 42026, 43052, 53292, 46125, 45102, 42030, 48174, 46127, 42033, 53298, 46130, 39987, 42038, 42047, 36928, 40012, 388, 133, 52357, 3461, 389, 135, 52359, 60807, 391, 393, 61833, 2442, 62858, 139, 58507, 5515, 396, 62860, 397, 398, 58510, 399, 62863, 59791, 60559, 5520, 53392, 48272, 58512, 1425, 60561, 57489, 38035, 53395, 5523, 58515, 404, 5524, 60564, 149, 34966, 150, 63894, 57494, 63897, 57499, 62619, 5533, 5539, 6567, 5549, 7601, 5561 }, new int[] { 16306, 16306, 16306, 16306, 16306, 16306, 16306, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 }),
	DARK_MASTERWORK_BOOTS(22027, 22003, "Dark masterwork boots", new int[] { 60564, 24, 58515, 57365, 265, 58633, 266, 60682, 139, 58507, 268, 60684, 142, 60559, 143, 144, 60561, 145, 3217, 147, 60566, 3222, 58394, 53275, 4381, 53278, 31, 53284, 5413, 6567, 47145, 48174}, new int[] { 16306, 16306, 16306, 16306, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 }),
	DARK_MASTERWORK_GLOVES(22028, 22004, "Dark masterwork gloves", new int[] { 52249, 35, 5284, 135, 1033, 10, 52234, 5259, 11, 12, 51212, 14, 142, 15, 52239, 144, 58512, 17, 3217, 19, 52244, 148, 2197, 57365, 21, 150, 60566, 3222, 57368, 152, 2200, 153, 60569, 4249, 2202, 26, 154, 2205, 4381, 53278, 30, 4254, 52255, 59424, 52256, 32, 5282, 58402, 36, 3236, 5413, 58405, 6567, 2094, 7601,  }, new int[] { 16306, 16306, 16306, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10  }),
	
	SEZY_MASTERWORK_BODY(10152, 22001, "Sezy Masterwork",
			new int[] { 1030, 48390, 1033, 265, 58633, 48393, 10, 52234, 39946, 57610, 60682, 266, 
						11, 40972, 268, 51212, 60684, 61966, 61710, 40975, 52239, 15, 2575, 61712, 
						58640, 53265, 4369, 2321, 40977, 42005, 52245, 533, 4374, 278, 4377, 52249, 
						40985, 25, 52250, 35866, 47130, 58394, 53275, 42011, 539, 4381, 53278, 52255, 
						42015, 47135, 58399, 32, 43040, 53283, 35, 58404, 48164, 42020, 53284, 5413, 
						47141, 58405, 58409, 43049, 47145, 5161, 53289, 43052, 53292, 49197, 53293, 48174, 
						42030, 46127, 41007, 42033, 43058, 46130, 42035, 42036, 46132, 53303, 38967, 38969, 
						42044, 34876, 38973, 42046, 42049, 38978, 37955, 43077, 38729, 38987, 52357, 43141, 
						135, 52359, 42119, 42123, 48267, 58507, 60811, 6795, 62091, 4492, 42126, 53390, 58510, 
						48270, 60559, 57487, 53392, 48272, 62864, 37008, 6544, 3217, 4497, 3473, 57489, 53396, 
						46228, 60564, 42132, 3476, 4500, 405, 57494, 46230, 3481, 2457, 58522, 42138, 410, 42139, 
						59547, 5533, 49310, 44192, 5539, 44195, 6567, 5549, 4269, 45231, 7601, 38067, 45239, 5561, 
						20158, 41663 },
			new int[] { 0, 350770, 0, 0, 350770, 0, 350770, 0, 0, 0, 350770, 0, 
						0, 350770, 0, 0, 350770, 0, 350770, 0, 0, 0, 350770, 0, 
						0, 350770, 0, 0, 350770, 0, 350770, 0, 0, 0, 350770, 0, 
						0, 350770, 0, 0, 350770, 0, 350770, 0, 0, 0, 350770, 0, 
						0, 350770, 0, 0, 350770, 0, 350770, 0, 0, 0, 350770, 0, 
						0, 350770, 0, 0, 350770, 0, 350770, 0, 0, 0, 350770, 0, 
						0, 350770, 0, 0, 350770, 0, 350770, 0, 0, 0, 350770, 0, 
						0, 350770, 0, 0, 350770, 0, 350770, 0, 0, 0, 350770, 0, 
						0, 350770, 0, 0, 350770, 0, 350770, 0, 0, 0, 350770, 0, 
						0, 350770, 0, 0, 350770, 0, 350770, 0, 0, 0, 350770, 0, 
						0, 350770, 0, 0, 350770, 0, 350770, 0, 0, 0, 350770, 0, 
						0, 350770, 0, 0, 350770, 0, 350770, 0, 0, 0, 350770, 0, 
						0, 350770, 0, 0, 350770, 0, 350770, 0 }),
	SEZY_MASTERWORK_LEGS(10153, 22002, "Sezy Masterwork Legs",
			new int[] { 5, 1030, 262, 58630, 58633, 1033, 265, 52234, 10, 266, 
						60682, 11, 12, 51212, 1548, 40972, 60684, 270, 14, 15, 
						52239, 40975, 30735, 16, 272, 17, 62737, 53265, 40977, 
						21, 57365, 42005, 52245, 36885, 57368, 53272, 52249, 
						25, 58394, 52250, 53275, 4381, 58397, 53277, 43037, 53278, 
						52255, 47135, 48160, 43040, 53282, 48162, 53283, 53284, 
						48164, 5413, 47141, 53285, 40, 42024, 53289, 47145, 
						43049, 42026, 43052, 53292, 46125, 45102, 42030, 48174, 
						46127, 42033, 53298, 46130, 39987, 42038, 38969, 42047, 
						36928, 40012, 388, 133, 52357, 3461, 389, 135, 52359, 
						60807, 391, 393, 61833, 2442, 62858, 139, 58507, 5515, 
						396, 62860, 397, 398, 58510, 399, 62863, 59791, 60559, 
						5520, 53392, 48272, 58512, 1425, 60561, 57489, 38035, 53395, 
						5523, 58515, 404, 5524, 60564, 149, 60566, 34966, 150, 63894, 
						57494, 58520, 63897, 57499, 62619, 5533, 5539, 6567, 5549, 7601, 5561 },
			new int[] { 350770, 0, 350770, 0, 0, 350770, 0, 350770, 0, 0, 
						350770, 0, 350770, 0, 0, 350770, 0, 350770, 0, 0, 
						350770, 0, 350770, 0, 0, 350770, 0, 350770, 0, 
						350770, 0, 350770, 0, 0, 350770, 0, 350770, 
						350770, 0, 350770, 0, 0, 350770, 0, 350770, 0, 
						350770, 0, 350770, 0, 0, 350770, 0, 350770, 
						350770, 0, 350770, 0, 0, 350770, 0, 350770, 
						350770, 0, 350770, 0, 0, 350770, 0, 350770, 
						350770, 0, 350770, 0, 0, 350770, 0, 350770, 
						350770, 0, 350770, 0, 0, 350770, 0, 350770, 0, 
						350770, 0, 350770, 0, 0, 350770, 0, 350770, 0, 
						350770, 0, 350770, 0, 0, 350770, 0, 350770, 0, 
						350770, 0, 350770, 0, 0, 350770, 0, 350770, 0, 
						350770, 0, 350770, 0, 0, 350770, 0, 350770, 0, 0, 
						350770, 0, 350770, 0, 0, 350770, 0, 350770, 0, 0, 0 }),
	SEZY_MASTERWORK_HELMET(10154, 22000, "Sezy Masterwork Legs",
			new int[] { 52359, 58633, 52234, 39946, 48267, 42123, 5259, 
						40972, 3340, 48270, 42126, 5262, 15, 4495, 46223, 
						42128, 48272, 3217, 4497, 53265, 42131, 52245, 57365, 
						5141, 58517, 60566, 57494, 53272, 42137, 57497, 58394, 
						52250, 47130, 53277, 4381, 57374, 59552, 53282, 60451, 
						46115, 48163, 57379, 58404, 53285, 5413, 49189, 58405, 
						57381, 6567, 49192, 58409, 49194, 43052, 58412, 49197, 
						49199, 7601, 48177, 49202, 42040, 42041, 57404, 39997, 
						44095, 47168, 42050, 43077, 40006, 38983, 42057, 46155, 
						42059, 43084, 40012, 42062, 39118, 40015, 42065, 48209, 
						38993, 39123, 36947, 46163, 43097, 43098, 38109, 43101, 
						37982, 36958, 37983, 41055, 39009, 39010, 39011, 37989 },
			new int[] { 350770, 0, 0, 350770, 0, 0, 350770, 0, 0, 350770, 0, 0, 350770, 0, 0, 0, 0, 
						350770, 0, 0, 350770, 0, 0, 350770, 0, 0, 350770, 0, 0, 350770, 0, 0, 0, 0, 
						350770, 0, 0, 350770, 0, 0, 350770, 0, 0, 350770, 0, 0, 350770, 0, 0, 0, 0, 
						350770, 0, 0, 350770, 0, 0, 350770, 0, 0, 350770, 0, 0, 350770, 0, 0, 0, 0, 
						350770, 0, 0, 350770, 0, 0, 350770, 0, 0, 350770, 0, 0, 350770, 0, 0, 0, 0, 
						350770, 0, 0, 350770, 0, 0, 350770, 0, 0, 350770 }),
	
	SEZY_MASTERWORK_CAPE(3320, 11614, "Masterwork Angelic Cape",
			new int[] { 40023, 40036, 1822, 36, 25, 34243, 9230, 40040, 10348, 48, 34251, 0, 43335, 6218, 23, 11013 },
			getCustomCapeColor(-27430, -26464)),
	SEZY_SIRENIC_CAPE(3321, 11614, "Sirenic Angelic Cape",
			new int[] { 40023, 40036, 1822, 36, 25, 34243, 9230, 40040, 10348, 48, 34251, 0, 43335, 6218, 23, 11013 },
			getCustomCapeColor(-24161, 32217)),
	SEZY_ROSEBLOOD_CAPE(3322, 11614, "Roseblood Angelic Cape",
			new int[] { 40023, 40036, 1822, 36, 25, 34243, 9230, 40040, 10348, 48, 34251, 0, 43335, 6218, 23, 11013 },
			getCustomCapeColor(2328, 1587)),
	SEZY_BLACKRED_CAPE(3323, 11614, "Hell Cape",
			new int[] { 40023, 40036, 1822, 36, 25, 34243, 9230, 40040, 10348, 48, 34251, 0, 43335, 6218, 23, 11013 },
			getCustomCapeColor(1024, 926)),
	SEZY_PINK_ROSEBLOOD_TOP(22031, 17223, "Pink Roseblood robe top",
			new int[] { 6, 7207, 10, 7211, 14, 7215, 1296, 18, 1301, 22, 1305, 7227, 1590, 1311, 1568, 1578 },
			new int[] { 29, 10308, 49, 10328, 70, 10348, 80, 90, 105, 110, 125, 10280, 57300, 57300, 57300, 57300}),
	SEZY_PINK_ROSEBLOOD_HOOD(22030, 16851, "Pink Roseblood hood",
			new int[] { 6, 7207, 10, 7211, 14, 7215, 1296, 18, 1301, 22, 1305, 7227, 1590, 1311, 1568, 1578 },
			new int[] { 29, 10308, 49, 10328, 70, 10348, 80, 90, 105, 110, 125, 10280, 57300, 57300, 57300, 57300}),
			// getModifiedColors(new int[] {1568, 6, 7207, 1578, 10, 7211, 14, 7215, 1296, 18, 1301, 1590, 22, 1305, 7227}, 400)),
	SEZY_PINK_ROSEBLOOD_BOTTOMS(22032, 16741, "Pink Roseblood robe bottom",
			new int[] { 6, 7207, 10, 7211, 14, 7215, 1296, 18, 1301, 22, 1305, 7227, 1590, 1311, 1568, 1578 },
			new int[] { 29, 10308, 49, 10328, 70, 10348, 80, 90, 105, 110, 125, 10280, 57300, 57300, 57300, 57300}),
	SEZY_PINK_ROSEBLOOD_GLOVES(22033, 17157, "Pink Roseblood gloves",
			new int[] { 6, 7207, 10, 7211, 14, 7215, 1296, 18, 1301, 22, 1305, 7227, 1590, 1311, 1568, 1578 },
			new int[] { 29, 10308, 49, 10328, 70, 10348, 80, 90, 105, 110, 125, 10280, 57300, 57300, 57300, 57300}),
	SEZY_PINK_ROSEBLOOD_BOOTS(22034, 16917, "Pink Roseblood shoes",
			new int[] { 1305, 1297, 7219, 262, 1319 },
			new int[] { 125, 57300, 57300, 57300, 57300 }),
	
	;
	/**
	 * Constructs a new {@link CustomRecolor}.
	 * 
	 * @param itemId           The item id.
	 * @param copyFromId       The id to copy from.
	 * @param name             The name.
	 * @param editedModelColor The edited model colors.
	 * @param newModelColor    The new model colors.
	 */

	private static int[] appendArr(int[] a, int e) {
	    a  = Arrays.copyOf(a, a.length + 1);
	    a[a.length - 1] = e;
	    return a;
	}
	
	private static int[] getModifiedColors(int[] id, int change) {
		int[] colors = {};
		for(int i = 0; i < id.length; i++) {
			colors = appendArr(colors, modifyColor(id[i], 0, 0, 500));
		}
		System.out.println("Original: " + Arrays.toString(id));
		System.out.println("Modified: " + Arrays.toString(colors));
		return colors;
	}
	
	public static int modifyColor(int c, int hue, int sat, int bright) {
		Color colorRGB = ItemDefinition.RS2HSB_to_RGB_MODIFIED(c, hue, sat, bright);
		return ItemDefinition.RGB_to_RS2HSB(colorRGB.getRed(), colorRGB.getGreen(), colorRGB.getBlue());
	}
	
	private static int[] getCustomCapeColor(int main, int accent) {
		return new int[] { main, main, main, accent, accent, main, accent, main, main, accent, main, main, main, main, accent, main };
	}
	private CustomRecolor(int itemId, int copyFromId, String name, int[] editedModelColor, int[] newModelColor) {
		ItemDefinition def = new ItemDefinition();

		def.id = itemId;
		def.setDefaults();
		def.copy(ItemDefinition.forID(copyFromId));
		def.name = name;
		def.editedModelColor = editedModelColor;
		def.newModelColor = newModelColor;

		ItemDefinition.getCustomRecolors().put(itemId, def);
	}

}
