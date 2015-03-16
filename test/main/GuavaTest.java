package main;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.primitives.Ints;

public class GuavaTest {

	@Test
	public void testList() {
		List<Integer> list = Lists.newArrayList(1);
		List<Integer> countUp = Ints.asList(1, 2, 3, 4, 5);
		List<Integer> countDown = Lists.reverse(countUp); // {5, 4, 3, 2, 1}

		assertTrue(list.get(0) == 1);
		assertTrue(countDown.get(0) == 5);
		assertEquals(new Integer(1), list.get(0));
	}
	
	@Test
	public void testSet() {
		Set<String> evenNumbers = ImmutableSet.of("two", "four", "six", "eight");
		Set<String> primes = ImmutableSet.of("two", "three", "five", "seven");
		
		Set<String> intersection = Sets.intersection(primes, evenNumbers); // contains "two"
		assertTrue(intersection.contains("two"));
		assertTrue(intersection.size() == 1);
	}
	
	@Test
	public void testMap() {
		Map<String, Integer> left = ImmutableMap.of("a", 1, "b", 2, "c", 3);
		Map<String, Integer> right = ImmutableMap.of("b", 2, "c", 4, "d", 5);
		MapDifference<String, Integer> diff = Maps.difference(left, right);

		assertTrue(diff.entriesInCommon().get("b") == 2); //{"b" => 2}
		assertTrue(diff.entriesOnlyOnLeft().get("a") == 1); // {"a" => 1}
	}
}
