package com.bluemobi.util;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class GenerateRedUtil {

	public GenerateRedUtil() {
	}

	/**
	 * 两位小数
	 * 
	 * @param num
	 * @return
	 */
	private static double scale(double num) {
		BigDecimal money_bd = new BigDecimal(num);
		return money_bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * 计算红包
	 * 
	 * @param totalsum
	 *            总金额
	 * @param min
	 *            最小值
	 * @param max
	 *            最大值
	 * @param number
	 *            红包数量
	 * @return
	 */
	public static Map<String, Double> getRedbag(double totalsum, double min, double max, int number) {

		int total_n = (int) (totalsum * 100);
		int min_n = (int) (min * 100);
		int max_n = (int) (max * 100);
		Map<String, Double> map = new HashMap<String, Double>();

		// 开始时间
		// long start = System.currentTimeMillis();
		double bal_min = (double) total_n / number;
		for (int i = 1; i < number; i++) {

			int money = 0;
			if (bal_min == min_n || bal_min == max_n) {
				money = (int) bal_min;
			} else {
				money = (int) (Math.random() * max_n);
				if (money < min_n) {
					money = min_n;
				}
				if (money > max_n) {
					money = max_n;
				}

				// 如随机数不满足条件，无线循环
				// 条件为：1. 判断数值是否合法；2.判断剩余金额和剩余次数的平均数 是否合法
				bal_min = (double) (total_n - money) / (number - i);
				int breakMax = 0;
				while (money < min_n || money > max_n || bal_min < min_n || bal_min > max_n) {
					breakMax++;
					if (money < min_n || bal_min > max_n) {
						money += 1;
					} else {
						money -= 1;
					}

					if (breakMax > max_n) {
						break;
					}

					bal_min = (double) (total_n - money) / (number - i);

				}

				if (breakMax > max_n) {
					i = 0;
					breakMax = 0;
					map.clear();
					total_n = (int) (totalsum * 100);
					continue;
				}
			}

			total_n = total_n - money;

			map.put(UUID.randomUUID().toString(), Double.valueOf(scale((double) money / 100)));
			// System.out.println("第"+i+"个红包："+money+",余额为:"+total_n+"元,bal_min:"+bal_min);

		}
		map.put(UUID.randomUUID().toString(), Double.valueOf(scale((double) total_n / 100)));
		// System.out.println("第"+number+"个红包："+total_n+",余额为:0元");

		// 计算输出总用时
		// long stop = System.currentTimeMillis();
		// System.out.println("time:"+(stop-start));

		return map;
	}

}