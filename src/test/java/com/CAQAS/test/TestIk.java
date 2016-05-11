package com.CAQAS.test;

import com.xq.algorithm.CosineSimilarAlgorithm;

public class TestIk {
	public static void main(String[] args) {
		Double result = CosineSimilarAlgorithm.cosSimilarityByString("猴子", "为什么为什么为什么为什么？");
		System.out.println(result);
	}
}
