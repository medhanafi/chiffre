package com.kmsoft.main;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Random;
import java.util.Vector;

public class TestMain {
	static Vector<String> ligneChiffre = null;
	static Vector<String> ligneVide = null;
	static List<Vector> column = new ArrayList<>();

	public static void main(String[] args) {

		afficheTable();

	}

	private static void afficheTable() {
		Random r = new Random();
		int a;
		for (int i = 0; i < 5; i++) {
			ligneChiffre = new Vector<>();
			ligneVide = new Vector<>();
			for (int j = 0; j < 5; j++) {
				a = number(r);
				ligneChiffre.add(String.valueOf(a));
				if (j < 4) {
					ligneChiffre.add(signe());
				}

				ligneVide.add(signe());
				if (j < 4) {
					ligneVide.add("#");
				}
			}
			column.add(ligneChiffre);
			if (i < 4) {
				column.add(ligneVide);
			}
		}

		for (int i = 0; i < column.size(); i++) {
			Vector<String> v = column.get(i);
			int res = 0;
			String s = v.get(0);
			for (int j = 0; j < v.size(); j++) {
				if (j < v.size() - 1) {
					if (isNumber(v.get(j))) {
						if (j < 1) {
							res = Integer.parseInt(s);
						}
						if (j < v.size() - 4) {
							if (isPlus(v.get(j + 1))) {
								res = res + Integer.parseInt(v.get(j + 2));
							} else {
								res = res - Integer.parseInt(v.get(j + 2));
							}
						}
					}
					System.out.print(" " + v.get(j) + " " + v.get(j + 1));
				} else {
					if (isNumber(v.get(j))) {
						if (isPlus(v.get(j - 1))) {
							s = s + Integer.parseInt(v.get(j));
						} else {
							res = res - Integer.parseInt(v.get(j));
						}
						System.out.print(" " + Math.abs(res));
					} else {
						System.out.print(" " + s);
					}

				}
				j = j + 1;

			}
			System.out.print("\n");
		}

	}

	public static int number(Random r) {
		return r.nextInt(9 - 1 + 1) + 1;
	}

	public static String signe() {
		String[] s = { "+", "-" };
		return s[getidx()];
	}

	private static int getidx() {
		return new Random().nextInt(2);
	}

	private static boolean isNumber(String val) {
		try {
			Integer.parseInt(val);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private static boolean isPlus(String s) {
		return s.equals("+");
	}
}