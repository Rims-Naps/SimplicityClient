package com.simplicity.client.cache.definitions.custom;

import com.simplicity.client.cache.definitions.ItemDefinition;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * An enumerated type that represents a custom recolored item.
 * 
 * @author Blake
 *
 **/

public enum CustomRecolor3 {

	DENMARK_VANGUARD_HELM(21229, 20013, "Virraz Tribrid Helm",
			new int[] {},
			new int[] {}),
	DENMARK_VANGUARD_BODY(21230, 20014, "Virraz Tribrid Body",
			new int[] {},
			new int[] {}),
	DENMARK_VANGUARD_LEGS(21231, 14062, "Virraz Tribrid Legs",
			new int[] {},
			new int[] {}),
	DENMARK_VANGUARD_BOOTS(21232, 13995, "Virraz Tribrid Boots",
			new int[] {},
			new int[] {}),
	DENMARK_VANGUARD_GLOVES(21233, 13994, "Virraz Tribrid Gloves",
			new int[] {},
			new int[] {}),

	GREEN_VITUR_SANGUINE(21234, 55739, "@gre@Green Sanguine Scythe of Vitur",
			new int[] {784, 16, 18, 20, 22, 790, 406, 536, 26, 427, 12, 796},
			new int[] {22427, 1024, 1024, 1024, 1024, 22427, 22427, 22427, 1024, 22427, 1024, 22427}),


	WHITE_GREY_OVERLORD_HELM(21235, 21091, "@red@Holy Knight Overlord Helm",
			new int[] {54285, 54286, 53265, 59666, 54291, 45075, 50196, 53271, 42007, 58648, 51224, 54296, 51225, 49178, 55322, 59675, 57627, 53275, 50203, 58654, 43038, 46110, 45087, 43039, 58657, 57633, 46114, 45093, 46117, 47142, 56616, 46121, 45097, 44074, 48171, 48172, 51245, 46126, 55599, 46120, 60720, 44081, 46131, 46132, 48182, 62774, 45111, 42040, 42041, 44090, 49211, 4923, 46140, 45116, 44093, 43070, 44095, 39999, 45119, 42047, 45124, 38981, 45125, 45126, 44104, 46154, 4938, 42059, 45134, 42062, 40015, 42321, 41299, 43091, 41055, 40032, 44129, 44131, 41064, 41065, 39023, 21628, 54414, 56467, 55443, 57492, 59541, 60567, 56471, 57496, 48280, 54424, 56472, 58521, 51354, 50330, 55451, 57501, 47262, 56479, 50338, 56487, 56488, 56490, 1462, 5825, 41154, 42181, 44231, 49352, 44232, 40138, 44239, 41168, 41172, 49366, 43222, 41174, 40155, 41182, 6905},
			new int[] {10292, 10292, 10292, 120, 10292, 10292, 10292, 10292, 10292, 120, 10292, 10292, 10292, 10292, 10292, 120, 120, 10292, 10292, 120, 10292, 10292, 10292, 10292, 120, 120, 46114, 45093, 46117, 47142, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 10292, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 10292, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 10292, 10292, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 10292}),
	WHITE_GREY_OVERLORD_PLATEBODY(21236, 21092, "@red@Holy Knight Overlord Platebody",
			new int[] {46100, 51222, 55318, 51226, 47131, 55323, 50203, 46108, 51232, 53282, 46115, 45092, 52261, 53286, 46120, 50217, 52265, 54314, 55338, 53291, 45100, 52268, 46125, 50222, 47151, 46128, 52272, 48177, 49202, 45107, 46131, 49203, 50227, 46132, 45108, 49204, 46133, 49206, 46135, 46136, 51257, 44090, 45115, 48187, 46140, 45117, 46141, 47165, 44093, 51261, 48189, 46143, 47167, 49215, 43072, 48192, 49216, 46145, 48194, 47171, 46147, 45124, 47173, 49222, 42055, 45120, 43080, 48201, 46156, 48207, 45142, 56461, 55438, 58510, 54415, 52367, 58511, 57489, 55441, 53394, 58514, 56466, 54419, 58515, 57491, 59539, 51348, 56468, 55444, 58516, 59541, 54422, 50326, 59542, 49302, 58518, 57494, 55446, 54423, 50327, 51351, 58519, 57495, 56472, 49304, 49305, 55449, 57497, 54426, 50330, 56474, 51355, 46235, 55451, 50331, 47259, 57499, 58523, 59547, 54427, 54428, 52380, 47260, 48284, 58524, 55453, 50333, 58525, 48285, 54430, 56478, 58526, 48287, 55455, 57503, 46240, 55456, 50336, 48288, 58528, 56480, 47265, 55457, 50337, 48289, 57505, 56481, 56482, 54434, 54435, 49316, 56484, 48292, 55461, 46246, 50342, 45222, 45223, 48296, 55464, 56489, 49322, 55466, 48298, 56490, 46251, 55467, 55468, 48302, 58542, 55470, 43183, 45233, 47281, 48306, 44211, 46263, 46264, 47289, 45242, 45244, 20158, 5825, 46277, 45254, 46278, 45255, 46282, 46285, 41165, 42191, 43218, 46290, 41172, 41173, 6905, 56583, 55559, 57608, 57609, 56585, 55561, 57610, 58634, 58636, 56588, 56591, 55567, 55568, 59665, 58641, 58642, 57618, 56594, 58643, 57619, 56595, 57620, 59668, 55572, 56596, 56597, 56598, 57623, 57624, 58648, 55577, 57626, 56602, 57627, 58652, 58653, 56605, 57631, 57635, 57636, 57637, 59685, 56614, 4923, 4938, 1462},
			new int[] {120, 120, 120, 120, 120, 120, 120, 116, 120, 122, 120, 120, 120, 120, 120, 116, 120, 120, 116, 120, 125, 120, 120, 120, 123, 120, 120, 124, 120, 125, 120, 120, 116, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 10292, 10292, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 10292, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 122, 120, 120, 120, 10292, 10292, 10292}),
	WHITE_GREY_OVERLORD_LEGS(21237, 21093, "@red@Holy Knight Overlord Legs",
			new int[] {58632, 56585, 58633, 57609, 59657, 54538, 56586, 58634, 59658, 56587, 51467, 57611, 54540, 51468, 56588, 58636, 55564, 57612, 52493, 58637, 57613, 56589, 58638, 56590, 55567, 56591, 57615, 55568, 56592, 57616, 57617, 56593, 58641, 48146, 58643, 56595, 50195, 48150, 50198, 57623, 47130, 46108, 45085, 50207, 57632, 47138, 46116, 45093, 45097, 48169, 46121, 46125, 46120, 46128, 47155, 43067, 4923, 46140, 46149, 58759, 56455, 54409, 56715, 58507, 52364, 55436, 55437, 54413, 56462, 54414, 58510, 49295, 57487, 52367, 54415, 54416, 50321, 52369, 55442, 54418, 50322, 51347, 49299, 54419, 49300, 50324, 55445, 49302, 54422, 53399, 56471, 49304, 49305, 54425, 56473, 49306, 54426, 49307, 57499, 51355, 53404, 48285, 51357, 46238, 48286, 55454, 55455, 48287, 50337, 48290, 47267, 48292, 52388, 50342, 46246, 48294, 49321, 48298, 50347, 48299, 47276, 48300, 46252, 49325, 48302, 48304, 46256, 48309, 1462, 5825, 46290, 6905},
			new int[] {120, 120, 120, 120, 120, 120, 116, 120, 120, 125, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 122, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 10292, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 10292, 10292, 120, 10292}),
	WHITE_GREY_OVERLORD_GLOVES(21238, 21094, "@red@Holy Knight Overlord Gloves",
			new int[] {56465, 57490, 56466, 58514, 59538, 58642, 54418, 58643, 58515, 57491, 55443, 57619, 56467, 58644, 58516, 57492, 55444, 57493, 54421, 58517, 56469, 56470, 58518, 57494, 55446, 54424, 57497, 54425, 53401, 54426, 55450, 54427, 54429, 52381, 52382, 52384, 51361, 52258, 47138, 51363, 49317, 50214, 48296, 46253, 46125, 48176, 47152, 47155, 1462, 46137, 45113, 4923, 44223, 44096, 5825, 46149, 44105, 6905},
			new int[] {120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 10292, 120, 120, 10292, 120, 120, 10292, 120, 120, 10292}),
	WHITE_GREY_OVERLORD_BOOTS(21239, 21095, "@red@Holy Knight Overlord Boots",
			new int[] {58628, 57605, 58632, 58634, 57610, 57611, 57612, 58636, 58637, 57613, 58638, 57614, 58510, 57615, 56463, 56464, 56465, 56470, 50330, 46108, 51357, 50334, 48287, 49311, 48288, 47265, 46251, 46120, 46134, 47167},
			new int[] {120, 120, 120, 120, 120, 120, 125, 120, 120, 120, 120, 120, 120, 120, 120, 122, 120, 124, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120}),

	OCEAN_ARCHER_WINGS(21096, 21096, "Ocean archer cape",
			new int[] {55324, 55325, 51229, 51230, 54302, 51231, 51232, 50208, 54304, 50209, 52257, 48162, 55331, 52259, 50211, 54307, 48163, 52260, 49188, 55332, 53284, 55333, 50214, 52262, 49190, 52263, 54311, 56359, 51239, 51240, 56360, 49192, 52264, 54312, 47144, 57385, 49193, 52265, 50218, 56362, 44074, 51243, 54315, 53291, 56363, 55339, 52268, 51245, 61485, 60461, 50221, 48173, 50222, 60462, 49198, 52270, 48174, 56367, 49199, 50223, 59439, 61487, 51247, 54320, 58416, 51248, 52272, 60464, 59440, 61488, 53297, 55345, 54321, 49201, 53298, 59442, 49202, 53299, 46131, 48179, 51252, 47156, 46133, 49206, 50230, 51254, 52278, 44086, 57399, 48183, 51256, 44088, 46137, 48185, 47162, 50235, 49211, 51259, 46139, 48187, 49212, 56380, 46140, 52284, 48189, 45117, 52286, 48191, 49216, 47168, 45120, 48193, 53313, 49218, 55362, 46146, 43074, 55363, 46147, 46148, 50245, 49222, 48199, 50248, 49224, 55368, 47176, 51272, 59464, 48201, 50251, 49228, 46156, 54349, 49229, 50254, 51279, 49233, 50257, 46163, 46164, 46175, 41057, 57484, 58508, 58510, 57486, 58511, 52367, 58512, 53393, 51345, 57490, 56467, 55443, 52371, 53395, 54420, 55444, 56468, 57492, 51348, 55445, 54421, 57493, 50325, 52373, 51349, 58518, 51350, 50326, 54423, 57495, 56472, 54424, 55448, 55449, 54425, 56474, 51354, 58522, 55450, 47258, 50330, 56475, 55451, 53403, 58523, 54427, 50331, 49308, 54428, 52380, 55453, 50333, 49309, 48285, 52382, 54430, 60574, 49310, 59551, 58527, 60575, 56479, 55455, 49311, 56480, 58528, 48288, 57505, 56481, 60577, 58529, 59553, 49313, 55458, 56482, 58530, 61602, 57506, 60579, 61603, 57507, 51364, 61604, 60580, 58532, 48292, 59557, 60581, 58533, 62629, 56485, 48293, 59558, 57510, 58534, 60582, 61606, 46246, 60583, 58535, 56487, 57511, 48295, 45223, 58536, 60584, 61608, 59560, 62632, 57512, 52392, 56488, 60585, 62633, 58537, 51369, 46249, 58538, 61610, 60586, 62634, 57514, 56490, 61611, 60587, 58539, 55467, 45227, 58540, 59564, 61612, 46252, 61613, 62637, 59565, 61614, 59566, 58542, 58544, 57520, 61617, 61624, 46271, 5825, 46280, 46281, 45257, 45259, 46283, 45261, 46286, 45263, 46290, 45266, 46291, 45269, 58636, 57613, 58637, 57614, 57615, 57619, 57620, 57622, 57624, 61723, 57627, 61724, 62748, 57628, 61725, 60701, 57629, 61726, 62750, 62751, 61727, 61728, 60705, 61729, 57633, 62755, 58659, 62759, 61735, 57641, 57642, 4923},
			new int[] {55324, 55325, 51229, 51230, 54302, 51231, 51232, 50208, 54304, 50209, 52257, 48162, 55331, 52259, 50211, 54307, 48163, 52260, 49188, 55332, 53284, 55333, 50214, 52262, 49190, 52263, 54311, 56359, 51239, 51240, 56360, 49192, 52264, 54312, 47144, 57385, 49193, 52265, 50218, 56362, 44074, 51243, 54315, 53291, 56363, 55339, 52268, 51245, 61485, 60461, 50221, 48173, 50222, 60462, 49198, 52270, 48174, 56367, 49199, 50223, 59439, 61487, 51247, 54320, 58416, 51248, 52272, 60464, 59440, 61488, 53297, 55345, 54321, 49201, 53298, 59442, 49202, 53299, 46131, 48179, 51252, 47156, 46133, 49206, 50230, 51254, 52278, 44086, 57399, 48183, 51256, 44088, 46137, 48185, 47162, 50235, 49211, 51259, 46139, 48187, 49212, 56380, 46140, 52284, 48189, 45117, 52286, 48191, 49216, 47168, 45120, 48193, 53313, 49218, 55362, 46146, 43074, 55363, 46147, 46148, 50245, 49222, 48199, 50248, 49224, 55368, 47176, 51272, 59464, 48201, 50251, 49228, 46156, 54349, 49229, 50254, 51279, 49233, 50257, 46163, 46164, 46175, 41057, 57484, 58508, 58510, 57486, 58511, 52367, 58512, 53393, 51345, 57490, 56467, 55443, 52371, 53395, 54420, 55444, 56468, 57492, 51348, 55445, 54421, 57493, 50325, 52373, 51349, 58518, 51350, 50326, 54423, 57495, 56472, 54424, 55448, 55449, 54425, 56474, 51354, 58522, 55450, 47258, 50330, 56475, 55451, 53403, 58523, 54427, 50331, 49308, 54428, 52380, 55453, 50333, 49309, 48285, 52382, 54430, 60574, 49310, 59551, 58527, 60575, 56479, 55455, 49311, 56480, 58528, 48288, 57505, 56481, 60577, 58529, 59553, 49313, 55458, 56482, 58530, 61602, 57506, 60579, 61603, 57507, 51364, 61604, 60580, 58532, 48292, 59557, 60581, 58533, 62629, 56485, 48293, 59558, 57510, 58534, 60582, 61606, 46246, 60583, 58535, 56487, 57511, 48295, 45223, 58536, 60584, 61608, 59560, 62632, 57512, 52392, 56488, 60585, 62633, 58537, 51369, 46249, 58538, 61610, 60586, 62634, 57514, 56490, 61611, 60587, 58539, 55467, 45227, 58540, 59564, 61612, 46252, 61613, 62637, 59565, 61614, 59566, 58542, 58544, 57520, 61617, 61624, 46271, 5825, 46280, 46281, 45257, 45259, 46283, 45261, 46286, 45263, 46290, 45266, 46291, 45269, 58636, 57613, 58637, 57614, 57615, 57619, 57620, 57622, 57624, 61723, 57627, 61724, 62748, 57628, 61725, 60701, 57629, 61726, 62750, 62751, 61727, 61728, 36694, 36694, 36694, 34643, 34643, 34643, 35669, 35669, 35669, 33621}),

	EVIL_SANTA_JACKET(21240, 14595, "Evil Santa Jacket",
			new int[] { 928, 5411, 933, 4550, 8998, 56328, 9032, 105, 75, 940, 5392, 56337, 9015, 120, 5401, 90, 924, 60, 255, 928, 933, 924, 940},
			new int[] { 15, 5, 12, 4550, 8998, 56328, 10064, 105, 75, 13, 9032, 56337, 9015, 120, 6, 90, 10, 60, 255, 15, 14, 10, 12 }),

	EVIL_SANTA_PANTS(21241, 42889, "Evil Santa Pants",
			 new int[] { 929, 8082, 931, 935, 7401, 7834, 939, 7964, 7518, 929, 931, 935, 7401, 939, 7964 },
			new int[] { 10, 127, 12, 14, 127, 127, 15, 127, 127, 10, 12, 14, 7401, 15, 7964 }),

	EVIL_SANTA_GLOVES(21242, 14602, "Evil Santa Gloves",
			new int[] { 56340, 5220, 5240, 5401, 56346, 5230 },
			new int[] { 12, 5220, 127, 5, 15, 127 }),

	EVIL_SANTA_BOOTS(21243, 14605, "Evil Santa Pants",
			new int[] { 56338, 56342, 120, 105, 90, 56334 },
			new int[] { 10, 12, 127, 127, 127, 12 }),

	EVIL_SANTA_MASK(21244, 42887, "Evil Santa Mask",
			new int[] { 929, 3297, 931, 4325, 935, 231, 7401, 939, 8082, 115, 7834, 123, 7964, 4316, 7518, 127 },
			new int[] { 10, 3297, 11, 4325, 13, 231, 7401, 14, 8082, 115, 7834, 123, 7964, 4316, 7518, 127 }),

	/** GREEN OVERLORD **/
	GREEN_OVERLORD_HELM(21245, 21091, "@gre@Corby's Overlord Helm",
			new int[] {54285, 54286, 53265, 59666, 54291, 45075, 50196, 53271, 42007, 58648, 51224, 54296, 51225, 49178, 55322, 59675, 57627, 53275, 50203, 58654, 43038, 46110, 45087, 43039, 58657, 57633, 46114, 45093, 46117, 47142, 56616, 46121, 45097, 44074, 48171, 48172, 51245, 46126, 55599, 46127, 60720, 44081, 46131, 46132, 48182, 62774, 45111, 42040, 42041, 44090, 49211, 4923, 46140, 45116, 44093, 43070, 44095, 39999, 45119, 42047, 45124, 38981, 45125, 45126, 44104, 46154, 4938, 42059, 45134, 42062, 40015, 42321, 41299, 43091, 41055, 40032, 44129, 44131, 41064, 41065, 39023, 21628, 54414, 56467, 55443, 57492, 59541, 60567, 56471, 57496, 48280, 54424, 56472, 58521, 51354, 50330, 55451, 57501, 47262, 56479, 50338, 56487, 56488, 56490, 1462, 5825, 41154, 42181, 44231, 49352, 44232, 40138, 44239, 41168, 41172, 49366, 43222, 41174, 40155, 41182, 6905},
			new int[] {54285, 54286, 53265, 10, 54291, 45075, 50196, 53271, 42007, 12, 51224, 54296, 51225, 49178, 55322, 10, 11, 53275, 50203, 12, 43038, 46110, 45087, 43039, 14, 14, 46114, 45093, 46117, 47142, 15, 33, 32, 38, 36, 34, 32, 30, 17, 20, 19, 36, 34, 32, 30, 20, 23, 25, 27, 29, 29, 22427, 23, 24, 24, 26, 26, 27, 26, 25, 24, 23, 22, 21, 20, 19, 22427, 19, 17, 18, 18, 17, 17, 20, 21, 22, 23, 24, 25, 26, 27, 28, 2, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 15, 16, 17, 17, 20, 19, 18, 15, 21, 22, 23, 22427, 22427, 43, 42, 41, 40, 39, 38, 37, 36, 35, 34, 33, 32, 31, 30, 22427}),
	GREEN_OVERLORD_PLATEBODY(21246, 21092, "@gre@Corby's Overlord Platebody",
			new int[] {46100, 51222, 55318, 51226, 47131, 55323, 50203, 46108, 51232, 53282, 46115, 45092, 52261, 53286, 46120, 50217, 52265, 54314, 55338, 53291, 45100, 52268, 46125, 50222, 47151, 46128, 52272, 48177, 49202, 45107, 46131, 49203, 50227, 46132, 45108, 49204, 46133, 49206, 46135, 46136, 51257, 44090, 45115, 48187, 46140, 45117, 46141, 47165, 44093, 51261, 48189, 46143, 47167, 49215, 43072, 48192, 49216, 46145, 48194, 47171, 46147, 45124, 47173, 49222, 42055, 45127, 43080, 48201, 46156, 48207, 45142, 56461, 55438, 58510, 54415, 52367, 58511, 57489, 55441, 53394, 58514, 56466, 54419, 58515, 57491, 59539, 51348, 56468, 55444, 58516, 59541, 54422, 50326, 59542, 49302, 58518, 57494, 55446, 54423, 50327, 51351, 58519, 57495, 56472, 49304, 49305, 55449, 57497, 54426, 50330, 56474, 51355, 46235, 55451, 50331, 47259, 57499, 58523, 59547, 54427, 54428, 52380, 47260, 48284, 58524, 55453, 50333, 58525, 48285, 54430, 56478, 58526, 48287, 55455, 57503, 46240, 55456, 50336, 48288, 58528, 56480, 47265, 55457, 50337, 48289, 57505, 56481, 56482, 54434, 54435, 49316, 56484, 48292, 55461, 46246, 50342, 45222, 45223, 48296, 55464, 56489, 49322, 55466, 48298, 56490, 46251, 55467, 55468, 48302, 58542, 55470, 43183, 45233, 47281, 48306, 44211, 46263, 46264, 47289, 45242, 45244, 20158, 5825, 46277, 45254, 46278, 45255, 46282, 46285, 41165, 42191, 43218, 46290, 41172, 41173, 6905, 56583, 55559, 57608, 57609, 56585, 55561, 57610, 58634, 58636, 56588, 56591, 55567, 55568, 59665, 58641, 58642, 57618, 56594, 58643, 57619, 56595, 57620, 59668, 55572, 56596, 56597, 56598, 57623, 57624, 58648, 55577, 57626, 56602, 57627, 58652, 58653, 56605, 57631, 57635, 57636, 57637, 59685, 56614, 4923, 4938, 1462},
			new int[] {16, 19, 20, 21, 21, 21, 22, 22, 23, 23, 23, 23, 23, 23, 24, 24, 24, 24, 24, 24, 24, 25, 25, 25, 25, 25, 24, 25, 26, 27, 27, 27, 29, 28, 29, 28, 29, 28, 29, 30, 30, 30, 30, 30, 30, 30, 30, 30, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 28, 28, 27, 27, 26, 26, 26, 25, 25, 7, 8, 9, 10, 11, 10, 9, 10, 11, 10, 11, 12, 13, 13, 14, 15, 16, 15, 16, 15, 16, 15, 16, 17, 16, 15, 16, 17, 16, 13, 14, 15, 16, 17, 18, 18, 18, 18, 14, 15, 14, 15, 16, 18, 18, 17, 18, 18, 19, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 20, 20, 20, 20, 20, 20, 20, 21, 21, 21, 21, 21, 22, 22, 22, 22, 24, 26, 22427, 22427, 26, 27, 28, 29, 30, 32, 31, 33, 34, 33, 35, 35, 22427, 2, 4, 6, 8, 10, 12, 12, 12, 13, 13, 14, 15, 15, 16, 17, 18, 18, 18, 18, 18, 18, 18, 18, 18, 16, 16, 16, 16, 16, 16, 16, 17, 17, 17, 17, 17, 17, 17, 18, 18, 18, 18, 18, 22427, 22427, 22427}),
	GREEN_OVERLORD_LEGS(21247, 21093, "@gre@Corby's Overlord Legs",
			new int[] {58632, 56585, 58633, 57609, 59657, 54538, 56586, 58634, 59658, 56587, 51467, 57611, 54540, 51468, 56588, 58636, 55564, 57612, 52493, 58637, 57613, 56589, 58638, 56590, 55567, 56591, 57615, 55568, 56592, 57616, 57617, 56593, 58641, 48146, 58643, 56595, 50195, 48150, 50198, 57623, 47130, 46108, 45085, 50207, 57632, 47138, 46116, 45093, 45097, 48169, 46121, 46125, 46127, 46128, 47155, 43067, 4923, 46140, 46149, 58759, 56455, 54409, 56715, 58507, 52364, 55436, 55437, 54413, 56462, 54414, 58510, 49295, 57487, 52367, 54415, 54416, 50321, 52369, 55442, 54418, 50322, 51347, 49299, 54419, 49300, 50324, 55445, 49302, 54422, 53399, 56471, 49304, 49305, 54425, 56473, 49306, 54426, 49307, 57499, 51355, 53404, 48285, 51357, 46238, 48286, 55454, 55455, 48287, 50337, 48290, 47267, 48292, 52388, 50342, 46246, 48294, 49321, 48298, 50347, 48299, 47276, 48300, 46252, 49325, 48302, 48304, 46256, 48309, 1462, 5825, 46290, 6905},
			new int[] {2, 3, 4, 5, 6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 4, 5, 6, 7, 8, 10, 11, 11, 11, 11, 12, 12, 12, 13, 14, 15, 16, 15, 15, 20, 14, 14, 15, 19, 20, 14, 21, 23, 25, 28, 29, 30, 32, 33, 32, 32, 32, 33, 34, 34, 34, 35, 22427, 42, 47, 2, 2, 3, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 11, 12, 13, 13, 13, 13, 13, 13, 13, 13, 14, 14, 14, 14, 15, 15, 15, 15, 15, 16, 16, 16, 16, 16, 16, 17, 17, 17, 17, 18, 18, 18, 19, 19, 20, 20, 21, 21, 21, 21, 21, 21, 22, 22, 22, 22, 22, 23, 24, 24, 25, 26, 26, 27, 1462, 22427, 29, 22427}),
	GREEN_OVERLORD_GLOVES(21248, 21094, "@gre@Corby's Overlord Gloves",
			new int[] {56465, 57490, 56466, 58514, 59538, 58642, 54418, 58643, 58515, 57491, 55443, 57619, 56467, 58644, 58516, 57492, 55444, 57493, 54421, 58517, 56469, 56470, 58518, 57494, 55446, 54424, 57497, 54425, 53401, 54426, 55450, 54427, 54429, 52381, 52382, 52384, 51361, 52258, 47138, 51363, 49317, 50214, 48296, 46253, 46125, 48176, 47152, 47155, 1462, 46137, 45113, 4923, 44223, 44096, 5825, 46149, 44105, 6905},
			new int[] {10, 11, 11, 12, 12, 12, 13, 14, 14, 16, 14, 11, 12, 12, 13, 14, 14, 15, 15, 16, 16, 17, 18, 19, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 29, 29, 20, 20, 22, 30, 23, 31, 32, 33, 34, 22427, 29, 29, 22427, 40, 45, 22427, 40, 40, 22427}),
	GREEN_OVERLORD_BOOTS(21249, 21095, "@gre@Corby's Overlord Boots",
			new int[] {58628, 57605, 58632, 58634, 57610, 57611, 57612, 58636, 58637, 57613, 58638, 57614, 58510, 57615, 56463, 56464, 56465, 56470, 50330, 46108, 51357, 50334, 48287, 49311, 48288, 47265, 46251, 46127, 46134, 47167},
			new int[] {10, 11, 12, 11, 12, 13, 12, 13, 12, 11, 11, 12, 10, 9, 10, 10, 10, 11, 12, 27, 28, 29, 30, 32, 33, 34, 35, 37, 41, 35}),

	/** BLACK RED MYTHICAL SET ***/
	BLACK_RED_MYTHICAL_SHIELD(21250, 20910, "@red@Corby's Mythical Shield",
			new int[] { 44641, 44612, 44564, 44615, 105, 44618, 44570, 44635, 44603, 44606, 44575, 4495,  },
			new int[] { 3, 3, 3, 3, 940, 3, 3, 3, 3, 3, 3, 3,  }),
	BLACK_RED_MYTHICAL_GLOVES(21251, 1580, "@red@Corby's Mythical Gloves",
			new int[] { 10004, },
			new int[] { 940, }),
	BLACK_RED_MYTHICAL_TOP(21252, 19380, "@red@Corby's Mythical Robes",
			new int[] { 115, 916, 84, 6550, 105, 90, 92, 5772, 908, 7050 },
			new int[] {  3, 940, 3, 940, 3, 3, 3, 940, 3, 3 }),
	BLACK_RED_MYTHICAL_BOTTOMS(21253, 19386, "@red@Corby's Mythical Bottoms",
			new int[] { 0, 115, 916, 105, 908 },
			new int[] { 0, 3, 940, 3, 940 }),
	BLACK_RED_MYTHICAL_ANGELIC_BOOTS(21254, 41860, "@red@Corby's Mythical Angelic Boots",
			new int[]{ 8396, 8417, 5293, 20 },
			new int[]{ 940, 3, 940, 3 }),
	BLACK_RED_MYTHICAL_HOOD(21255, 54857, "@red@Corby's Mythical Hood Green",
			new int[] { 0, 38325, 4550, 38362, 107, 38348, 38333, 38366, 127 },
			new int[] { 3, 940, 3, 940, 3, 940, 940, 940, 3 }),
	BLACK_RED_MYTHICAL_CAPE(21256, 54855, "@red@Corby's Mythical Cape",
			new int[] { 38113, 38210, 99, 522, 107, 76, 38348, 38356, 38325, 88, 38362, 38333, 38366, 127 },
			new int[] { 940, 940, 12, 522, 10, 3, 940, 940, 940, 3, 940, 940, 940, 3 }),

	BLACK_RED_HOLY_MYTHICAL_STAFF(21257, 55731, "@red@Corby's Holy Mythical Sangiusteni",
			new int[] {6736, 6709, 43303, 39, 24, 8, 59466, 6602, 28, 59453, 4382},
			new int[] {940, 940, 940, 3, 3, 8, 3, 940, 3, 3, 3}),

	BLACK_PINK_ARCANE_STREAM(21258, 18335, "@pink@Playboy arcane stream necklace",
			new int[] {7459, 10308, 10340, 10822, 7464, 75, 7469, 10318, 33134, 25070, 10862, 10832, 33104, 25040, 7474, 7444, 90, 33114, 25050, 10301, 7454, 24703, 32895},
			new int[] {4, 56314, 56304, 56314, 4, 56314, 4, 56304, 56314, 56304, 56314, 56314, 56304, 56314, 4, 4, 17364, 56304, 56314, 56314, 4, 56304, 56314}),

	;

	private static int[] randomScytheColor() {
		List<Integer> colors = Arrays.asList(
				1017, 58356, 42879, 22527, 9087, 8063, 51199, 25
		);
		Random rand = new Random();
		int COLOR = colors.get(rand.nextInt(colors.size()));
		return new int[] { 1024, 1024, 1024, COLOR, 1024, COLOR, COLOR, 1024, 1024, 1024, COLOR, COLOR, 1024, COLOR };
	}

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
		return new int[] { main, accent, main, main, accent, accent, main, accent, accent, main, main, main, accent, main, accent, accent };
		// return new int[] { main, main, main, accent, accent, main, accent, main, main, accent, main, main, main, main, accent, main };
	}

	private CustomRecolor3(int itemId, int copyFromId, String name, int[] editedModelColor, int[] newModelColor) {
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
