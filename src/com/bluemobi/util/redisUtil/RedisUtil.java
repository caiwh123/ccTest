package com.bluemobi.util.redisUtil;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(RedisUtil.class);
	// private Jedis jedis;//非切片额客户端连接
	public static JedisPool jedisPool;// 非切片连接池
	// private ShardedJedis shardedJedis;//切片额客户端连接
	// private ShardedJedisPool shardedJedisPool;//切片连接池

	/*
	 * 获取非切片池
	 */
	public static JedisPool getJedisPool() {
		if (jedisPool == null) {
			LOGGER.info("初始化redis连接池开始");
			 ResourceBundle bundle = ResourceBundle.getBundle("redis");
			 JedisPoolConfig config = new JedisPoolConfig();
			
			 // 连接耗尽时是否阻塞, false报异常,ture阻塞直到超时, 默认true
			 config.setBlockWhenExhausted(true);
			 // 设置的逐出策略类名, 默认DefaultEvictionPolicy(当连接超过最大空闲时间,或连接数超过最大空闲连接数)
			 config.setEvictionPolicyClassName("org.apache.commons.pool2.impl.DefaultEvictionPolicy");
			 // 是否启用pool的jmx管理功能, 默认true
			 config.setJmxEnabled(true);
			 // MBean ObjectName = new ObjectName("org.apache.commons.pool2:type=GenericObjectPool,name=" + "pool" + i); 默认为"pool", JMX不熟,具体不知道是干啥的...默认就好.
			 config.setJmxNamePrefix("pool");
			 // 是否启用后进先出, 默认true
			 config.setLifo(true);
			 // 最大空闲连接数, 默认8个
			 config.setMaxIdle(Integer.valueOf(bundle.getString("redis.pool.maxIdle")));
			 // 最大连接数, 默认8个
			 config.setMaxTotal(Integer.valueOf(bundle.getString("redis.pool.maxTotal")));
			 // 获取连接时的最大等待毫秒数(如果设置为阻塞时BlockWhenExhausted),如果超时就抛异常,小于零:阻塞不确定的时间,
			 // 默认-1
			 config.setMaxWaitMillis(Integer.valueOf(bundle.getString("redis.pool.maxWait")));
			 // 逐出连接的最小空闲时间 默认1800000毫秒(30分钟)
			 config.setMinEvictableIdleTimeMillis(10000);
			 // 最小空闲连接数, 默认0
			 config.setMinIdle(Integer.valueOf(bundle.getString("redis.pool.minIdle")));
			 // 每次逐出检查时 逐出的最大数目 如果为负数就是 : 1/abs(n), 默认3
			 config.setNumTestsPerEvictionRun(3);
			 // 对象空闲多久后逐出, 当空闲时间>该值 且 空闲连接>最大空闲数
			 // 时直接逐出,不再根据MinEvictableIdleTimeMillis判断 (默认逐出策略)
			 config.setSoftMinEvictableIdleTimeMillis(10000);
			 // 在获取连接的时候检查有效性, 默认false
			 config.setTestOnBorrow(Boolean.getBoolean(bundle.getString("redis.pool.testOnBorrow")));
			 // 在空闲时检查有效性, 默认false
			 config.setTestWhileIdle(Boolean.getBoolean(bundle.getString("redis.pool.testOnReturn")));
			 // 逐出扫描的时间间隔(毫秒) 如果为负数,则不运行逐出线程, 默认-1
			 config.setTimeBetweenEvictionRunsMillis(-1);

			jedisPool = new JedisPool(config, bundle.getString("redis.host"),Integer.valueOf(bundle.getString("redis.port")),Integer.valueOf(bundle.getString("redis.timeout")),bundle.getString("redis.password"));

			LOGGER.info("初始化redis连接池结束");
		}

		return jedisPool;
	}

	public static byte[] serialize(Object object) {
		ObjectOutputStream oos = null;
		ByteArrayOutputStream baos = null;
		try {
			// 序列化
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(object);
			byte[] bytes = baos.toByteArray();
			return bytes;
		} catch (Exception e) {

		}
		return null;
	}

	public static Object unserialize(byte[] bytes) {
		ByteArrayInputStream bais = null;
		try {
			// 反序列化
			bais = new ByteArrayInputStream(bytes);
			ObjectInputStream ois = new ObjectInputStream(bais);
			return ois.readObject();
		} catch (Exception e) {

		}
		return null;
	}

	/*
	 * 缓存字符串
	 */
	public static void addString(String key, String str) {
		Jedis jedis = getJedisPool().getResource();
		jedis.set(key, str);
		getJedisPool().returnResource(jedis);
	}

	/*
	 * 获取字符串
	 */
	public static String getString(String key) {
		Jedis jedis = getJedisPool().getResource();
		String str = jedis.get(key);
		getJedisPool().returnResource(jedis);
		return str;
	}

	/*
	 * 缓存对象
	 */
	public static void addObject(String key, Object obj) {
		Jedis jedis = getJedisPool().getResource();
		byte[] bytes = serialize(obj);
		jedis.set(key.getBytes(), bytes);
		getJedisPool().returnResource(jedis);
	}

	/*
	 * 获取对象
	 */
	public static Object getObject(String key) {
		Jedis jedis = getJedisPool().getResource();
		byte[] bytes = jedis.get(key.getBytes());
		getJedisPool().returnResource(jedis);
		return unserialize(bytes);
	}

	/*
	 * 删除对象
	 */
	public static void delObject(String key) {
		Jedis jedis = getJedisPool().getResource();
		jedis.del(key);
		getJedisPool().returnResource(jedis);
	}
	
	/*
	 * 缓存hash
	 */
	public static void addHash(String key,String filed, Object obj) {
		Jedis jedis = getJedisPool().getResource();
		jedis.hset(key.getBytes(), filed.getBytes(), serialize(obj));
		getJedisPool().returnResource(jedis);
	}

	/*
	 * 获取hash
	 */
	public static Object getHash(String key,String fild) {
		Jedis jedis = getJedisPool().getResource();
		byte[] bytes = jedis.hget(key.getBytes(),fild.getBytes());
		getJedisPool().returnResource(jedis);
		return unserialize(bytes);
	}

	/*
	 * 删除hash中某个值
	 */
	public static void delHash(String key, String filed) {
		Jedis jedis = getJedisPool().getResource();
		jedis.hdel(key.getBytes(), filed.getBytes());
		getJedisPool().returnResource(jedis);
	}

	
	
	/*
	 * 设置一个有时效的缓存
	 */
	public static void setEx(String key,int time,String value) {
		Jedis jedis = getJedisPool().getResource();
		jedis.setex(key,time,value);
		getJedisPool().returnResource(jedis);
	}
	
	public static void main(String[] args) {
//		List<DictionaryDetail> dictionaryDetailList = (List<DictionaryDetail>) RedisUtil.getHash("DICT","YES_OR_NO");
//		for(int i=0;i<dictionaryDetailList.size();i++){
//			System.out.println("-------------------------------------"+dictionaryDetailList.get(i).getDictionaryItemName());
//		}
		//setEx("SMSCaptcha_18610036332",20,"123456");
		delObject("commentOrder_1");
//		System.out.println("------------"+getString("18610036332"));
	}
}
