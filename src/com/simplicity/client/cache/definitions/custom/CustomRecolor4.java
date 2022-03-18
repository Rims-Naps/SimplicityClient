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

public enum CustomRecolor4 {

	/** Lime and Purple Ocean archer set**/
	LIME_PUPRLE_OCEAN_ARCHER_WINGS(25412, 21096, "@gre@Sunset Ocean archer cape",
			new int[] {55324, 55325, 51229, 51230, 54302, 51231, 51232, 50208, 54304, 50209, 52257, 48162, 55331, 52259, 50211, 54307, 48163, 52260, 49188, 55332, 53284, 55333, 50214, 52262, 49190, 52263, 54311, 56359, 51239, 51240, 56360, 49192, 52264, 54312, 47144, 57385, 49193, 52265, 50218, 56362, 44074, 51243, 54315, 53291, 56363, 55339, 52268, 51245, 61485, 60461, 50221, 48173, 50222, 60462, 49198, 52270, 48174, 56367, 49199, 50223, 59439, 61487, 51247, 54320, 58416, 51248, 52272, 60464, 59440, 61488, 53297, 55345, 54321, 49201, 53298, 59442, 49202, 53299, 46131, 48179, 51252, 47156, 46133, 49206, 50230, 51254, 52278, 44086, 57399, 48183, 51256, 44088, 46137, 48185, 47162, 50235, 49211, 51259, 46139, 48187, 49212, 56380, 46140, 52284, 48189, 45117, 52286, 48191, 49216, 47168, 45120, 48193, 53313, 49218, 55362, 46146, 43074, 55363, 46147, 46148, 50245, 49222, 48199, 50248, 49224, 55368, 47176, 51272, 59464, 48201, 50251, 49228, 46156, 54349, 49229, 50254, 51279, 49233, 50257, 46163, 46164, 46175, 41057, 57484, 58508, 58510, 57486, 58511, 52367, 58512, 53393, 51345, 57490, 56467, 55443, 52371, 53395, 54420, 55444, 56468, 57492, 51348, 55445, 54421, 57493, 50325, 52373, 51349, 58518, 51350, 50326, 54423, 57495, 56472, 54424, 55448, 55449, 54425, 56474, 51354, 58522, 55450, 47258, 50330, 56475, 55451, 53403, 58523, 54427, 50331, 49308, 54428, 52380, 55453, 50333, 49309, 48285, 52382, 54430, 60574, 49310, 59551, 58527, 60575, 56479, 55455, 49311, 56480, 58528, 48288, 57505, 56481, 60577, 58529, 59553, 49313, 55458, 56482, 58530, 61602, 57506, 60579, 61603, 57507, 51364, 61604, 60580, 58532, 48292, 59557, 60581, 58533, 62629, 56485, 48293, 59558, 57510, 58534, 60582, 61606, 46246, 60583, 58535, 56487, 57511, 48295, 45223, 58536, 60584, 61608, 59560, 62632, 57512, 52392, 56488, 60585, 62633, 58537, 51369, 46249, 58538, 61610, 60586, 62634, 57514, 56490, 61611, 60587, 58539, 55467, 45227, 58540, 59564, 61612, 46252, 61613, 62637, 59565, 61614, 59566, 58542, 58544, 57520, 61617, 61624, 46271, 5825, 46280, 46281, 45257, 45259, 46283, 45261, 46286, 45263, 46290, 45266, 46291, 45269, 58636, 57613, 58637, 57614, 57615, 57619, 57620, 57622, 57624, 61723, 57627, 61724, 62748, 57628, 61725, 60701, 57629, 61726, 62750, 62751, 61727, 61728, 60705, 61729, 57633, 62755, 58659, 62759, 61735, 57641, 57642, 4923},
			new int[] {49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151}),
	
	LIME_PUPRLE_OCEAN_ARCHER_HELM(25406, 22800, "@gre@Sunset Ocean archer helm",
			new int[] {56589, 39443, 39444, 40221, 41245, 51230, 40223, 40224, 39200, 40225, 39201, 40226, 39202, 39203, 40227, 40228, 39206, 38184, 38185, 39209, 39210, 38186, 38187, 38189, 38191, 38192, 38194, 37172, 37182, 36167, 35161, 35163, 56460, 52365, 56465, 54419, 53395, 51348, 54420, 51349, 39317, 52374, 51350, 48278, 39318, 55446, 47255, 46231, 54423, 39319, 48280, 60568, 56472, 51352, 52376, 55448, 39320, 45208, 44185, 45209, 57497, 49305, 47257, 39321, 50329, 55449, 57498, 45210, 55450, 39322, 44187, 57499, 39323, 58524, 39324, 39325, 39326, 50334, 39327, 41120, 55456, 39328, 39329, 40097, 39330, 45218, 41122, 39331, 44195, 39332, 38308, 39077, 39333, 38309, 39335, 38312, 38313, 38314, 38316, 38317, 37300, 38328, 36307, 36059, 35039, 35040},
			new int[] {49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 49151, 20479, 20479, 20479, 49151, 20479, 20479, 20479, 20479, 49151, 20479, 20479, 20479, 20479, 20479, 20479, 49151, 20479, 20479, 20479, 49151, 49151, 49151, 49151, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 49151, 20479, 49151, 49151, 49151, 20479, 49151, 20479, 20479, 49151, 49151, 20479, 49151, 20479, 20479, 49151, 20479, 49151, 49151, 20479, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151}),
	
	LIME_PUPRLE_OCEAN_ARCHER_PLATEBODY(25407, 22801, "@gre@Sunset Ocean archer platebody",
			new int[] {41489, 40467, 39443, 40468, 40469, 39446, 39448, 49178, 50204, 59422, 58398, 42014, 47135, 54303, 38431, 56352, 38432, 48161, 43043, 52262, 42023, 43049, 50218, 36423, 36433, 36439, 54413, 56462, 54414, 53390, 53391, 56463, 55439, 51343, 57487, 52368, 50320, 53392, 51344, 55440, 40592, 57488, 48273, 52369, 56465, 40593, 50322, 47250, 59538, 39570, 56466, 48274, 40594, 54418, 57490, 52371, 48275, 54419, 55443, 56467, 48276, 52372, 55444, 54420, 57492, 47253, 48277, 54421, 53397, 56470, 39574, 53399, 55447, 39575, 49304, 47256, 56473, 58521, 59545, 59546, 46235, 59547, 57499, 52380, 57500, 59548, 59549, 58525, 60574, 59550, 60575, 45215, 41119, 50335, 54431, 52383, 58527, 59551, 44192, 57504, 60576, 52385, 41121, 49313, 59553, 60577, 41123, 58531, 60580, 58532, 59556, 57508, 41125, 60582, 58535, 41128, 58537, 60585, 59561, 61610, 60586, 57515, 59566, 60590, 59567, 59570, 60594, 61618, 62643, 61622, 62650, 20158, 61631, 36033, 36035, 195, 36552, 35537, 36566, 36568, 36063, 35042, 35044, 34022, 42763, 42764, 40716, 40718, 41742, 40719, 57615, 39696, 40720, 39701, 58647, 59671, 58648, 58649, 41241, 57626, 58650, 58651, 60700, 58653, 59680, 58658, 59682, 59684, 59685, 58662, 59687, 58663, 57640, 38184, 59688, 58664, 59689, 38186, 58666, 59690, 58668, 59693, 37168, 38196, 36160, 36163, 37189, 37191, 36167, 36168, 36169, 36170, 36171, 36172, 37708, 35149, 37709, 34643, 35669, 33621, 36694, 35670, 35671, 44431, 43413, 40341, 41366, 40342, 40343, 41367, 40344, 39320, 41370, 39322, 40346, 39323, 40347, 40348, 39325, 40349, 39326, 39327, 39328, 38305, 38306, 39330, 38307, 39331, 39332, 38309, 39333, 39334, 38310, 39335, 38312, 37289, 38314, 37290, 38315, 37291, 37292, 38317, 39343, 37296, 37297, 37298, 38322, 37299, 38323, 36275, 37300, 36276, 38325, 36279, 37303, 38328, 36281, 36282, 37306, 36283, 37307, 36285, 35263, 36292, 37317, 36293, 36294, 35271, 37320, 35272, 36298, 35275, 35276, 36301, 36302, 35280, 36304, 36307, 34265, 34266, 36314, 35291, 33243},
			new int[] {49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 20479, 20479, 20479, 49151, 20479, 49151, 20479, 20479, 20479, 20479, 20479, 20479, 49151, 49151, 49151, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 20479, 20479, 20479, 20479, 20479, 49151, 20479, 20479, 49151, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 20479, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151}),
	
	LIME_PUPRLE_OCEAN_ARCHER_LEGS(25408, 22802, "@gre@Sunset Ocean archer Legs",
			new int[] {56589, 57486, 55439, 56591, 57615, 56463, 56464, 55440, 56593, 57617, 55441, 57490, 58515, 59540, 59542, 47254, 56471, 57496, 55449, 56473, 52250, 56474, 52251, 53275, 59676, 53276, 50204, 51229, 62625, 48161, 48162, 60707, 62627, 42020, 60582, 59686, 48166, 43048, 60585, 62633, 43050, 60714, 62636, 39213, 60593, 62644},
			new int[] {49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 20479, 20479, 49151, 20479, 20479, 20479, 49151, 20479, 20479, 49151, 49151, 20479, 49151, 49151, 20479, 20479, 49151, 49151, 20479, 49151, 49151, 20479, 49151, 49151}),
	
	LIME_PUPRLE_OCEAN_ARCHER_GLOVES(25410, 22803, "@gre@Sunset Ocean archer gloves",
			new int[] {43281, 32178, 36242, 43283, 43274, 36254,40608, 33201, 43283, 40596, 43285, 43276},
			new int[] {20479, 49151, 20479, 20479, 20479, 20479, 49151, 49151, 20479, 20479, 20479, 20479}), 
	
	LIME_PUPRLE_OCEAN_ARCHER_BOOTS(25409, 22804, "@gre@Sunset Ocean archer boots",
			new int[] {40226, 62643, 62633, 59676, 56463},	
			new int[] {20479, 49151, 49151, 49151, 49151}), 
	
	LIME_PUPRLE_OCEAN_ARCHER_CROSSBOW(25411, 22806, "@gre@Sunset Ocean archer crossbow",
			new int[] {45204, 61719, 60695, 39193, 59674, 57626, 56474, 48410, 59675, 48412, 60700, 38045, 37021, 60701, 37022, 39199, 59680, 36000, 36001, 61858, 56482, 40227, 60710, 38310, 61864, 38184, 40105, 63785, 38315, 62763, 62892, 60717, 38317, 62765, 38318, 63791, 60719, 40112, 63665, 38324, 63670, 63800, 60729, 2108, 38333, 63809, 1098, 3404, 1487, 35040, 36088,45204, 61719, 60695, 39193, 59674, 57626, 56474, 48410, 59675, 48412, 60700, 38045, 37021, 60701, 37022, 39199, 59680, 36000, 36001, 61858, 56482, 40227, 60710, 38310, 61864, 38184, 40105, 63785, 38315, 62763, 62892, 60717, 38317, 62765, 38318, 63791, 60719, 40112, 63665, 38324, 63670, 63800, 60729, 2108, 38333, 63809, 1098, 3404, 1487, 35040, 36088},
			new int[] {49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 49151, 20479, 49151, 49151, 20479, 49151, 49151, 20479, 20479, 49151, 20479, 49151, 20479, 49151, 49151, 20479, 49151, 20479, 20479, 20479, 49151, 20479, 49151, 20479, 20479, 49151, 20479, 49151, 20479, 20479, 20479, 49151, 49151, 20479, 49151, 49151, 49151, 49151, 49151, 49151, 20479, 20479, 49151, 20479, 20479, 49151, 20479, 20479, 20479, 20479, 49151, 49151, 20479, 49151, 20479, 20479, 49151, 49151, 20479, 20479, 20479, 20479, 49151, 20479, 49151, 49151, 20479, 49151, 20479, 20479, 20479, 49151, 20479, 49151, 20479, 20479, 49151, 20479, 49151, 20479, 20479, 20479, 49151, 49151, 20479, 49151, 20479, 20479, 49151, 49151}),

	PURPLE_LIME_OVERLORD_CAPE(25413, 21045, "@gre@Sunset Overlord Cape",
	        new int[] { 40,8134,9036,8127,6975,7098,127,1953,789,792,3642,0,5,6 },
	        new int[] { 75,22527,22527,22527,22527,22527,22527,22527,22527,22527,22527,49151,49151,49151 }),

	PINK_GREEN_HAND_CANNON_XI_2(25414, 11620, "@gre@Pink Green Hand Cannon XI",
            new int[]{ 35840, 64, 35905, 35912, 1097, 35855, 35856, 85, 35862, 23, 35865, 35866, 1051, 35868, 6303, 31, 32, 35873, 1058, 35875, 39, 40, 35882, 6317, 45, 35886, 1070, 35888, 49, 50, 54, 35895, 59 },
            new int[]{ 58997, 58997, 58997, 58997, 58997, 22527, 22527, 58997, 58997, 58997, 58997, 58997, 58997, 58997, 58997, 58997, 58997, 58997, 58997, 58997, 58997, 58997, 22527, 22527, 58997, 22527, 58997, 58997, 22527, 22527, 22527, 58997, 22527 }),

	BLUE_HOLY_MYTHICAL_STAFF(21257, 55731, "@cya@Tar Heels Mythical Sanguinesti Staff",
			new int[] {6736, 6709, 43303, 39, 24, 8, 59466, 6602, 28, 59453, 4382},
			new int[] {37234, 37234, 37234, 39727, 39727, 37981, 39727, 37234, 39727, 39727, 39727}),
	
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

	private CustomRecolor4(int itemId, int copyFromId, String name, int[] editedModelColor, int[] newModelColor) {
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
