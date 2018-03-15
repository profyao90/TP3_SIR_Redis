package istic.sir.sir;

import redis.clients.jedis.Jedis;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       
        /**System.out.println( "Hello World!" );
        try {

            Jedis jedis = new Jedis("localhost");
            System.out.println("sssssssssssss"+jedis.sadd("01", "000001"));
            
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}*/
    	String cacheKey = "languages";
		Jedis jedis = new Jedis("localhost");
		// Adding a set as value

		jedis.sadd(cacheKey, "Java");
		jedis.sadd(cacheKey, "C#");
		jedis.sadd(cacheKey, "Python");// SADD

		// Getting all values in the set: SMEMBERS
		System.out.println("Languages: " + jedis.smembers(cacheKey));
		// Adding new values
		jedis.sadd(cacheKey, "Java");
		jedis.sadd(cacheKey, "Ruby");
		// Getting the values... it doesn't allow duplicates
		System.out.println("Languages: " + jedis.smembers(cacheKey));

    }
}
