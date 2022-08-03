package mule.ubtmicroworld;

import java.util.ArrayList;
import java.util.List;

import mule.ubtmicroworld.UBTMicroworld.Agent;
import mule.ubtmicroworld.UBTMicroworld.DefaultLevelType;

public class Test {

	public static void main(String[] args) {
		UBTMicroworld.initDefaultGame(DefaultLevelType.DEFAULT_LEVEL_2);
		Agent a = UBTMicroworld.getAgentList().get(0).value;
		ArrayList<ArrayList<String>> navMap = UBTMicroworld.getNavMap();
		System.out.println(a);
		for (List<String> line : navMap) {
			System.out.println(line);
		}
	}

}
