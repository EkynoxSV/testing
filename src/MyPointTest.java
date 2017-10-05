import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import java.util.Random;

public class MyPointTest {
	MyPoint point;
	MyPoint point2;

	@Before
	public void setUp() throws Exception {
		point2 = new MyPoint(5, 4);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMyPoint() {
		point = new MyPoint();
		assertEquals(0, point.getX(), 0);
		assertEquals(0, point.getY(), 0);
	}

	@Test
	public void testMyPointDoubleDouble() {
		Double xRand = Math.random();
		Double yRand = Math.random();
		point = new MyPoint(xRand, yRand);
		assertEquals(xRand, point.getX(), 0);
		assertEquals(yRand, point.getY(), 0);
	}

	@Test
	public void testSetXGetX() {
		Double xRand = Math.random();
		point2.setX(xRand);
		assertEquals(xRand, point2.getX(), 0);
	}

	@Test
	public void testSetXNaN() {
		point2.setX(Double.NaN);
		assertEquals(5, point2.getX(), 0);
	}

	@Test
	public void testSetYGetY() throws Exception {
		Double yRand = Math.random();
		point2.setY(yRand);
		assertEquals(yRand, point2.getY(), 0);
	}

	@Test
	public void testSetYNaN() {
		point2.setY(Double.NaN);
		assertEquals(4, point2.getY(), 0);
	}

	@Test
	public void testMyPointMyPoint() {
		point = new MyPoint(point2);
		assertEquals(point2.getX(), point.getX(), 0);
		assertEquals(point2.getY(), point.getY(), 0);
	}

	@Test
	public void testMyPointMyPointNull() {
		point = new MyPoint(null);
		assertEquals(0, point.getX(), 0);
		assertEquals(0, point.getY(), 0);
	}

	@Test
	public void testScale() {
		point = point2.scale(2);
		assertEquals(10, point.getX(), 0);
		assertEquals(8, point.getY(), 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testHorizontalSymmetryNull() {
		point = point2.horizontalSymmetry(null);
	}

	@Test
	public void testHorizontalSymmetry() {
		point = point2.horizontalSymmetry(new MyPoint(1, 1));
		assertEquals(-3, point.getX(), 0);
		assertEquals(4, point.getY(), 0);
	}

	@Test
	public void testComputeAngleNull() {
		Double value = point2.computeAngle(null);
		assertEquals(Double.NaN, value, 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCentralSymmetryNull() {
		point = point2.centralSymmetry(null);

	}

	@Test
	public void testGetMiddlePoint() {
		point = point2.getMiddlePoint(new MyPoint(4, 4));
		assertEquals(4.5, point.getX(), 0);
		assertEquals(4, point.getY(), 0);
	}

	@Test
	public void testTranslateDoubleDouble() {
		point2.translate(3, 4);
		assertEquals(8, point2.getX(), 0);
		assertEquals(8, point2.getY(), 0);

	}

	@Test
	public void testTranslateDoubleDoubleXNaN() {
		point2.translate(Double.NaN, 4);
		assertEquals(5, point2.getX(), 0);
		assertEquals(4, point2.getY(), 0);

	}

	@Test
	public void testTranslateDoubleDoubleYNaN() {
		point2.translate(3, Double.NaN);
		assertEquals(5, point2.getX(), 0);
		assertEquals(4, point2.getY(), 0);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testCentralSymmetryNULL() {
		new MyPoint(10, 20).centralSymmetry(null);
	}

	@Test
	public void testSetPoint() {
	Random rand1 = Mockito.mock(Random.class);
	Random rand2 = Mockito.mock(Random.class);
	Mockito.when(rand1.nextInt()).thenReturn(42);
	Mockito.when(rand2.nextInt()).thenReturn(24);
	
	point2.setPoint(rand1, rand2);
	
	assertEquals(42,point2.getX(),0);
	assertEquals(24,point2.getY(),0);
	
	}

	@Test
	public void testTranslateITranslation() {
		ITranslation translation = Mockito.mock(ITranslation.class);
		Mockito.when(translation.getTx()).thenReturn(5);
		Mockito.when(translation.getTy()).thenReturn(7);
		
		point2.translate(translation);
		
		assertEquals(10, point2.getX(),0);
		assertEquals(11, point2.getY(),0);
	}

	@Test
	public void testTranslateITranslationNull() {
		point2.translate(null);
		assertEquals(5, point2.getX(),0);
		assertEquals(4, point2.getY(),0);
	}

	@Test
	public void testRotatePointNull() {
		point2 = point2.rotatePoint(null, 2);
		
		assertEquals(point2, null);
	}
	
	@Test
	public void testRotatePoint() {
		point = point2.rotatePoint(point2, 0);
		
		assertEquals(point2.getX(), point.getX(),0);
		assertEquals(point2.getY(), point.getY(),0);
	}
	

}
