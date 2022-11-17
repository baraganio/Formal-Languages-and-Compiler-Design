package test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import model.CustomHashTable;

public class HashTableTest {

	@Test
	public void test1() {
		CustomHashTable tabla = new CustomHashTable(11);
		System.out.println(tabla.toString());
		assertEquals("-;-;-;-;-;-;-;-;-;-;-;[Size: 11 Num.Elems.: 0]",tabla.toString());
		// Insert null
		assertEquals(-2,tabla.insert(null));
		// Insert elements
		assertEquals(0,tabla.insert("8"));
		assertEquals(0,tabla.insert("10"));
		System.out.println(tabla.toString());
		assertEquals("-;8;-;-;-;10;-;-;-;-;-;[Size: 11 Num.Elems.: 2]",tabla.toString());
		assertEquals(0,tabla.insert("66"));
		System.out.println(tabla.toString());
		assertEquals("-;8;66;-;-;10;-;-;-;-;-;[Size: 11 Num.Elems.: 3]",tabla.toString());
		// Insert elements with collisions
		assertEquals(0,tabla.insert("77"));
		System.out.println(tabla.toString());	
		assertEquals("77;8;66;-;-;10;-;-;-;-;-;[Size: 11 Num.Elems.: 4]",tabla.toString());
		assertEquals(0,tabla.insert("88"));
		System.out.println(tabla.toString());	
		assertEquals("77;8;66;-;-;10;-;-;-;-;88;[Size: 11 Num.Elems.: 5]",tabla.toString());
		assertEquals(0,tabla.insert("89"));
		System.out.println(tabla.toString());
		assertEquals("77;8;66;89;-;10;-;-;-;-;88;[Size: 11 Num.Elems.: 6]",tabla.toString());		
		// Insert elements
		assertEquals(0,tabla.insert("3"));
		assertEquals(0,tabla.insert("6"));
		assertEquals(0,tabla.insert("7"));
		assertEquals(0,tabla.insert("20"));
		assertEquals(0,tabla.insert("16"));
		System.out.println(tabla.toString());
		assertEquals("77;8;66;89;6;10;7;3;20;16;88;[Size: 11 Num.Elems.: 11]",tabla.toString());
	

	}
	

}
