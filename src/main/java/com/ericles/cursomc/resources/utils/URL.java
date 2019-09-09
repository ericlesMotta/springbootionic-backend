package com.ericles.cursomc.resources.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

public class URL {
	
	public static String decodeParam(String param) {
		try {
			return URLDecoder.decode(param,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
	public static List<Integer> decodeIntList (String categ){
		String[] vet = categ.split(",");
		List<Integer> listInteiros = new ArrayList<>();
		for (int i = 0; i < vet.length; i++) {
			listInteiros.add(Integer.parseInt(vet[i]));
		}
		return listInteiros;
		
	}
}
